package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.sites.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.sites.bombed.BombedWall;
import pl.agh.edu.dp.labirynth.sites.standard.Room;
import pl.agh.edu.dp.labirynth.sites.standard.Wall;

public class BombedMazeFactory extends MazeFactory{
    private static BombedMazeFactory instance;

    protected BombedMazeFactory() {}

    public static BombedMazeFactory getInstance() {
        if (instance == null) {
            instance = new BombedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room makeRoom(int roomNumber) {
        BombedRoom room = new BombedRoom(roomNumber);
        for(Direction direction : Direction.values()) {
            room.setSide(direction, makeWall());
        }

        return room;
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }
}
