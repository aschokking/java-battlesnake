package battlesnake;

public class XYPoint {
    private final int x, y;

    public XYPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYPoint)) {
            return false;
        }
        XYPoint p = (XYPoint) o;
        return p.x == x && p.y == y;
    }
}
