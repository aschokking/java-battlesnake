package battlesnake;

public class Board {
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
}
