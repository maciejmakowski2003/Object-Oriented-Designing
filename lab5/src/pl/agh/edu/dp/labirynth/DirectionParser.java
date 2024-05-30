package pl.agh.edu.dp.labirynth;

public class DirectionParser {
    public Direction parse(String direction) {
        return switch (direction.trim().toUpperCase()) {
            case "NORTH", "N" -> Direction.North;
            case "SOUTH", "S" -> Direction.South;
            case "EAST", "E" -> Direction.East;
            case "WEST", "W" -> Direction.West;
            default -> throw new IllegalArgumentException("Invalid direction, " +
                    "try N S E W or North South East West");
        };
    }
}
