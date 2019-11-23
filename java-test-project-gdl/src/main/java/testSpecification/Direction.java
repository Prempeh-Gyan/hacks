package testSpecification;

public enum Direction {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");
    private final String headedDirection;
    private final String leftOfHeadedDirection;
    private final String rightOfHeadedDirection;

    Direction(String headedDirection, String leftOfHeadedDirection, String rightOfHeadedDirection) {
        this.headedDirection = headedDirection;
        this.leftOfHeadedDirection = leftOfHeadedDirection;
        this.rightOfHeadedDirection = rightOfHeadedDirection;
    }

    public Direction turnLeft() {
        return directionThatMatches(leftOfHeadedDirection);
    }

    public Direction turnRight() {
        return directionThatMatches(rightOfHeadedDirection);
    }

    public String getHeadedDirection() {
        return headedDirection;
    }

    private Direction directionThatMatches(String newDirection) {
        for (Direction direction : values()) {
            if (direction.headedDirection == newDirection) {
                return direction;
            }
        }
        return null;
    }
}
