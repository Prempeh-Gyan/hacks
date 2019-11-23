package testSpecification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RoverStationTest {

    @Test
    void distributeInstructionsToRovers() {

        RoverStation roverStation = new RoverStation();

        String[] nasaInstructions = new String[5];
        nasaInstructions[0] = "5 5";
        nasaInstructions[1] = "1 2 N";
        nasaInstructions[2] = "LMLMLMLMM";
        nasaInstructions[3] = "3 3 E";
        nasaInstructions[4] = "MMRMMRMRRM";

        String[] executionResults = roverStation.distributeInstructionsToRovers(nasaInstructions);
        String[] expectedResults = new String[2];
        expectedResults[0] = "1 3 N";
        expectedResults[1] = "5 1 E";
        assertArrayEquals(expectedResults, executionResults);
    }
}