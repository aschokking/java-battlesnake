package battlesnake;

public class Snake {
    private final String id;
    private final int health;
    private final XYPoint[] body;
    private final XYPoint head;
    private final int length;

    public Snake(String id, int health, XYPoint[] body, XYPoint head, int length) {
        this.id = id;
        this.health = health;
        this.body = body;
        this.head = head;
        this.length = length;
    }

}
