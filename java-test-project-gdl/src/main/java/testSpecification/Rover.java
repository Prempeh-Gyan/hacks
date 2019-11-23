package testSpecification;

public class Rover {
    public String executeNasaInstructions(String roverPosition, String nasaInstructions, Grid map) {

        roverPosition = roverPosition.replaceAll(" ", "");

        Coordinate originalRoverCoordinate = new Coordinate();
        originalRoverCoordinate.setXCoordinate(Character.getNumericValue(roverPosition.charAt(0)));
        originalRoverCoordinate.setYCoordinate(Character.getNumericValue(roverPosition.charAt(1)));

        Direction originalRoverDirectionFromNasa = Direction.NORTH;

        char startingDirectionFromNasa = roverPosition.charAt(2);
        switch (startingDirectionFromNasa) {
            case 'N':
                originalRoverDirectionFromNasa = Direction.NORTH;
                break;
            case 'E':
                originalRoverDirectionFromNasa = Direction.EAST;
                break;
            case 'S':
                originalRoverDirectionFromNasa = Direction.SOUTH;
                break;
            case 'W':
                originalRoverDirectionFromNasa = Direction.WEST;
                break;
        }

        Direction newRoverDirection = originalRoverDirectionFromNasa;
        Coordinate newRoverCoordinate = originalRoverCoordinate;
        String executionResult = "";

        for (char instruction : nasaInstructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    newRoverDirection = newRoverDirection.turnLeft();
                    break;
                case 'R':
                    newRoverDirection = newRoverDirection.turnRight();
                    break;
                case 'M':
                    newRoverCoordinate = map.moveOneGridPoint(newRoverCoordinate, newRoverDirection);
                    break;
                default:
            }
            executionResult = newRoverCoordinate.toString() + " " + newRoverDirection.getHeadedDirection();
        }

        return executionResult;
    }
}
