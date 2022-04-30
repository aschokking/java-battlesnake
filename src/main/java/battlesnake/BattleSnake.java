package battlesnake;

import java.util.ArrayList;
import java.util.Arrays;

public class BattleSnake {

    // these methods identify your snake in the game:
    
    public String getAuthor() {
        // TODO: Customize
        return "YOUR NAME HERE";
    }

    public String getColor() {
        // TODO: Customize
        return "#E800FF";
    }

    public String getHead() {
        // TODO: Customize
        return "default";
    }

    public String getTail() {
        // TODO: Customize
        return "default";
    }

    // this is the primary method that determines what your snake does each turn.
    // should return a string that's one of "up", "down", "left", "right"
    public String computeMove(Board board, Snake you) {
        ArrayList<String> possibleMoves = new ArrayList<String>(Arrays.asList("up", "down", "left", "right"));
        
        avoidWalls(board, you, possibleMoves);

        // Choose a random direction to move in
        int choice = (int)(Math.random() * possibleMoves.size());
        String move = possibleMoves.get(choice);

        return move;
    }

    private void avoidWalls(Board board, Snake you, ArrayList<String> possibleMoves) {
        XYPoint head = you.getHead();

        int boardWidth = board.getWidth();
        int boardHeight = board.getHeight();

        if (head.getX() == 0) {
            possibleMoves.remove("left");
        }
        if(head.getX() == boardWidth - 1) {
            possibleMoves.remove("right");
        }
        if(head.getY() == 0) {
            possibleMoves.remove("down");
        }
        if(head.getY() == boardHeight - 1) {
            possibleMoves.remove("up");
        }
    }
}
