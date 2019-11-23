package testSpecification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void turnLeft() {
        Direction direction = Direction.NORTH;
        assertEquals(Direction.WEST, direction.turnLeft());
    }

    @Test
    void turnRight() {
        Direction direction = Direction.NORTH;
        assertEquals(Direction.EAST, direction.turnRight());
    }

    @Test
    void getHeadedDirection() {
        Direction direction = Direction.EAST;
        assertEquals("E", direction.getHeadedDirection());
    }
}