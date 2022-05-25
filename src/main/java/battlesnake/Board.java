package battlesnake;

// YOU DONT NEED TO MODIFY THIS FILE

public class Board {
    // these fields are described in the api documentation:
    // https://docs.battlesnake.com/references/api
    private final int height;
    private final int width;
    private final XYPoint[] food;
    private final XYPoint[] hazards;
    private final Snake[] snakes;

    public Board(int height, int width, XYPoint[] food, XYPoint[] hazards, Snake[] snakes) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.hazards = hazards;
        this.snakes = snakes;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public XYPoint[] getFood() {
        return food;
    }

    public XYPoint[] getHazards() {
        return hazards;
    }

    public Snake[] getSnakes() {
        return snakes;
    }

    public String toString() {
        String result = "Board: height=" + height + ", width=" + width;
        for(Snake snake: snakes) {
            result += "\n\t" + snake.toString();
        }

        return result;
    }
}
