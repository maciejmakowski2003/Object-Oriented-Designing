package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.sites.standard.Door;
import pl.agh.edu.dp.labirynth.sites.standard.Room;
import pl.agh.edu.dp.labirynth.sites.standard.Wall;

public class MazeFactory {
    private static MazeFactory instance = null;

    protected MazeFactory() {}

    public static MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }

    public Room makeRoom(int roomNumber) {
        Room room = new Room(roomNumber);
        for(Direction direction : Direction.values()) {
            room.setSide(direction, makeWall());
        }

        return room;
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Door makeDoor(Room from, Room to, Direction direction) {
        if(from.getSide(direction) instanceof Door) {
            throw new IllegalArgumentException("Room number: " +
                    from.getRoomNumber() + " already has a door in direction " +
                    direction);
        }

        if(to.getSide(direction.opposite()) instanceof Door) {
            throw new IllegalArgumentException("Room number: " +
                    to.getRoomNumber() + " already has a door in direction " +
                    direction.opposite());
        }

        Door door = new Door(from, to);
        from.setSide(direction, door);
        to.setSide(direction.opposite(), door);
        return door;
    }

}
