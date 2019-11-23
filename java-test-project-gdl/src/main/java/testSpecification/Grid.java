package testSpecification;

public class Grid {
    private int maximumXCoordinate;
    private int maximumYCoordinate;

    public void setMaximumXCoordinate(int numericValue) {
        maximumXCoordinate = numericValue;
    }

    public void setMaximumYCoordinate(int numericValue) {
        maximumYCoordinate = numericValue;
    }

    public Coordinate moveOneGridPoint(Coordinate currentRoverCoordinate, Direction newRoverDirection) {
        int x = currentRoverCoordinate.getXCoordinate();
        int y = currentRoverCoordinate.getYCoordinate();
        switch (newRoverDirection) {
            case NORTH:
                y = ((y + 1) <= maximumYCoordinate) ? (y + 1) : 1;
                break;
            case EAST:
                x = ((x + 1) <= maximumXCoordinate) ? (x + 1) : 1;
                break;
            case SOUTH:
                y = ((y - 1) >= 0) ? (y - 1) : maximumYCoordinate -1;
                break;
            case WEST:
                x = ((x - 1) >= 0) ? (x - 1) : maximumXCoordinate -1;
                break;
            default:
        }
        return new Coordinate(x, y);
    }
}
