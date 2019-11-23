package testSpecification;

import java.util.ArrayList;
import java.util.List;

public class RoverStation {
    public String[] distributeInstructionsToRovers(String[] nasaInstructions) {

        String mapDimension = nasaInstructions[0];
        mapDimension = mapDimension.replaceAll(" ", "");

        List<String> roverPositions = new ArrayList<>();
        List<String> roverInstructions = new ArrayList<>();

        for (int i = 1; i < nasaInstructions.length; i++) {
            int value = i % 2;
            if (value > 0) {
                roverPositions.add(nasaInstructions[i]);
            } else {
                roverInstructions.add(nasaInstructions[i]);
            }
        }

        String[] resultsFromExecutingRoverInstructions = new String[roverPositions.size()];
            Grid map = new Grid();
            map.setMaximumXCoordinate(Character.getNumericValue(mapDimension.charAt(0)));
            map.setMaximumYCoordinate(Character.getNumericValue(mapDimension.charAt(1)));

        for (int i = 0; i < roverInstructions.size(); i++) {

            Rover rover = new Rover();


            String executionResultsFromRover = rover.executeNasaInstructions(roverPositions.get(i), roverInstructions.get(i), map);
            resultsFromExecutingRoverInstructions[i] = executionResultsFromRover;
        }

        return resultsFromExecutingRoverInstructions;
    }
}
