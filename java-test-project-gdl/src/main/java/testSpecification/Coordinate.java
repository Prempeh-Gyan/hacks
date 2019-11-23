package testSpecification;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
    }

    public int getYCoordinate() {
        return y;
    }

    public void setYCoordinate(int numericValue) {
        y = numericValue;
    }

    public int getXCoordinate() {
        return x;
    }

    public void setXCoordinate(int numericValue) {
        x = numericValue;
    }

    @Override
    public String toString() {
        return ("" + x + " " + y);
    }
}
