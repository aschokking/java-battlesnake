package battlesnake.webserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import battlesnake.BattleSnake;
import battlesnake.Board;
import battlesnake.Snake;
import battlesnake.XYPoint;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.get;

/**
 * This is a simple Battlesnake server written in Java.
 * 
 * For instructions see
 * https://github.com/BattlesnakeOfficial/starter-snake-java/README.md
 */
public class Webserver {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final Handler HANDLER = new Handler();
    private static final Logger LOG = LoggerFactory.getLogger(Webserver.class);
    private static final BattleSnake snake = new BattleSnake();

    /**
     * Main entry point.
     *
     * @param args are ignored.
     */
    public static void main(String[] args) {
        String port = System.getProperty("PORT");
        if (port == null) {
            LOG.info("Using default port: {}", port);
            port = "8080";
        } else {
            LOG.info("Found system provided port: {}", port);
        }
        port(Integer.parseInt(port));
        get("/", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/start", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/move", HANDLER::process, JSON_MAPPER::writeValueAsString);
        post("/end", HANDLER::process, JSON_MAPPER::writeValueAsString);
    }

    /**
     * Handler class for dealing with the routes set up in the main method.
     */
    public static class Handler {

        /**
         * For the start/end request
         */
        private static final Map<String, String> EMPTY = new HashMap<>();

        /**
         * Generic processor that prints out the request and response from the methods.
         *
         * @param req
         * @param res
         * @return
         */
        public Map<String, String> process(Request req, Response res) {
            try {
                JsonNode parsedRequest = JSON_MAPPER.readTree(req.body());
                String uri = req.uri();
                LOG.info("{} called with: {}", uri, req.body());
                Map<String, String> snakeResponse;
                if (uri.equals("/")) {
                    snakeResponse = index();
                } else if (uri.equals("/start")) {
                    snakeResponse = start(parsedRequest);
                } else if (uri.equals("/move")) {
                    snakeResponse = move(parsedRequest);
                } else if (uri.equals("/end")) {
                    snakeResponse = end(parsedRequest);
                } else {
                    throw new IllegalAccessError("Strange call made to the snake: " + uri);
                }

                LOG.info("Responding with: {}", JSON_MAPPER.writeValueAsString(snakeResponse));

                return snakeResponse;
            } catch (JsonProcessingException e) {
                LOG.warn("Something went wrong!", e);
                return null;
            }
        }

        /**
         * This method is called everytime your Battlesnake is entered into a game.
         * 
         * Use this method to decide how your Battlesnake is going to look on the board.
         *
         * @return a response back to the engine containing the Battlesnake setup
         *         values.
         */
        public Map<String, String> index() {
            Map<String, String> response = new HashMap<>();
            response.put("apiversion", "1");
            response.put("author", snake.getAuthor());
            response.put("color", snake.getColor());
            response.put("head", snake.getHead());
            response.put("tail", snake.getTail());
            return response;
        }

        /**
         * This method is called everytime your Battlesnake is entered into a game.
         * 
         * Use this method to decide how your Battlesnake is going to look on the board.
         *
         * @param startRequest a JSON data map containing the information about the game
         *                     that is about to be played.
         * @return responses back to the engine are ignored.
         */
        public Map<String, String> start(JsonNode startRequest) {
            LOG.info("START");
            return EMPTY;
        }

        /**
         * This method is called on every turn of a game. It's how your snake decides
         * where to move.
         * 
         * Use the information in 'moveRequest' to decide your next move. The
         * 'moveRequest' variable can be interacted with as
         * com.fasterxml.jackson.databind.JsonNode, and contains all of the information
         * about the Battlesnake board for each move of the game.
         * 
         * For a full example of 'json', see
         * https://docs.battlesnake.com/references/api/sample-move-request
         *
         * @param moveRequest JsonNode of all Game Board data as received from the
         *                    Battlesnake Engine.
         * @return a Map<String,String> response back to the engine the single move to
         *         make. One of "up", "down", "left" or "right".
         */
        public Map<String, String> move(JsonNode moveRequest) {

            try {
                LOG.info("Data: {}", JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(moveRequest));
            } catch (JsonProcessingException e) {
                LOG.error("Error parsing payload", e);
            }

            Board board = parseBoard(moveRequest.get("board"));
            Snake you = parseSnake(moveRequest.get("you"));

            String move = snake.computeMove(board, you);

            LOG.info("MOVE {}", move);

            Map<String, String> response = new HashMap<>();
            response.put("move", move);
            return response;
        }

        public static Board parseBoard(JsonNode jsonBoard) {
            Snake[] snakes = new Snake[jsonBoard.get("snakes").size()];
            int i = 0;
            for (JsonNode jsonSnake : jsonBoard.get("snakes")) {
                snakes[i] = parseSnake(jsonSnake);
            }
            return new Board(
                jsonBoard.get("height").asInt(), 
                jsonBoard.get("width").asInt(), 
                parseXYPoints(jsonBoard.get("food")),
                parseXYPoints(jsonBoard.get("hazards")), 
                snakes
            );
        }

        public static Snake parseSnake(JsonNode jsonSnake) {
            Snake snake = new Snake(
                jsonSnake.get("id").asText(),
                jsonSnake.get("health").asInt(),
                parseXYPoints(jsonSnake.get("body")),
                parseXYPoint(jsonSnake.get("head")),
                jsonSnake.get("length").asInt()
            );
            return snake;
        }

        public static XYPoint[] parseXYPoints(JsonNode jsonPoints) {
            XYPoint[] points = new XYPoint[jsonPoints.size()];
            int i = 0;
            for (JsonNode point : jsonPoints) {
                points[i] = parseXYPoint(point);
                i++;
            }
            return points;
        }

        public static XYPoint parseXYPoint(JsonNode jsonPoint) {
            return new XYPoint(jsonPoint.get("x").asInt(), jsonPoint.get("y").asInt());
        }

        /**
         * This method is called when a game your Battlesnake was in ends.
         * 
         * It is purely for informational purposes, you don't have to make any decisions
         * here.
         *
         * @param endRequest a map containing the JSON sent to this snake. Use this data
         *                   to know which game has ended
         * @return responses back to the engine are ignored.
         */
        public Map<String, String> end(JsonNode endRequest) {
            LOG.info("END");
            return EMPTY;
        }
    }

}
