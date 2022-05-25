package battlesnake;

// YOU DONT NEED TO MODIFY THIS FILE

public class Snake {
    // these fields are described in the api documentation:
    // https://docs.battlesnake.com/references/api
    private final String id;
    private final String name;
    private final int health;
    private final XYPoint[] body;
    private final XYPoint head;
    private final int length;

    public Snake(String id, String name, int health, XYPoint[] body, XYPoint head, int length) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.body = body;
        this.head = head;
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public XYPoint[] getBody() {
        return body;
    }

    public XYPoint getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        String bodyString = "Head: ";
        for(XYPoint point : body) {
            bodyString += point.toString() + ", ";
        }
        bodyString = bodyString.substring(0, bodyString.length() -2);
        bodyString += " :Tail";
        return "Snake: " + name + " | " + bodyString;
    }
}
