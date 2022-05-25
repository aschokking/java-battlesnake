package battlesnake;

// THIS IS THE MAIN FILE YOU NEED TO IMPLEMENT YOUR SNAKE AI IN

import java.util.ArrayList;
import java.util.Arrays;

public class BattleSnake {

    // these methods identify your snake in the game:
    
    public String getAuthor() {
        // TODO: Customize
        return "YOUR NAME";
    }

    public String getColor() {
        // TODO: Customize
        return "#FF00FF";
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
        // create an ArrayList that starts with all 4 possible moves in it. 
        ArrayList<String> possibleMoves = new ArrayList<String>(Arrays.asList("up", "down", "left", "right"));
        
        avoidWalls(board, you, possibleMoves);
        avoidNeck(you, possibleMoves);

        // Choose a random direction to move in from the remaining possibleMoves
        int choice = (int)(Math.random() * possibleMoves.size());
        String move = possibleMoves.get(choice);

        return move;
    }

    // don't run into walls
    private void avoidWalls(Board board, Snake you, ArrayList<String> possibleMoves) {
        XYPoint head = you.getHead();

        // TODO: Remove any directions from possibleMoves that would result in hitting a wall
        // This diagram will help you understand the board's coordinates: https://docs.battlesnake.com/references/api#board
    }

    // don't run into our own neck (the part of our body that's before the head)
    private void avoidNeck(Snake you, ArrayList<String> possibleMoves) {
        XYPoint head = you.getHead();
        XYPoint neck = you.getBody()[1];

        // TODO: Remove any directions from possibleMoves that would result in hitting our own neck
    }
}
