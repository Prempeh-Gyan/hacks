package testSpecification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void executeNasaInstructions() {
        Rover rover = new Rover();
        Grid map = new Grid();

        map.setMaximumXCoordinate(5);
        map.setMaximumYCoordinate(5);

        String roverPosition = "1 2 N";
        String nasaInstruction = "LMLMLMLMM";

        String expectedExecutionResults = "1 3 N";

        String roverExecutionResults = rover.executeNasaInstructions(roverPosition, nasaInstruction, map);

        assertEquals(expectedExecutionResults, roverExecutionResults);
    }
}