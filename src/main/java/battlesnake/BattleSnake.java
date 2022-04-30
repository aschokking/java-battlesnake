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
        return "#888888";
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
    public String computeMove() {
        ArrayList<String> possibleMoves = new ArrayList<String>(Arrays.asList("up", "down", "left", "right"));
        
        // Choose a random direction to move in
        int choice = (int)(Math.random() * possibleMoves.size());
        String move = possibleMoves.get(choice);

        return move;
    }
}
