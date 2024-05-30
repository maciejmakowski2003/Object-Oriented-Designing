package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.sites.enchanted.Abyss;
import pl.agh.edu.dp.labirynth.sites.enchanted.Chamber;
import pl.agh.edu.dp.labirynth.sites.standard.Room;
import pl.agh.edu.dp.labirynth.sites.standard.Wall;

public class EnchantedMazeFactory extends MazeFactory{
    private static EnchantedMazeFactory instance;

    protected EnchantedMazeFactory() {}

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room makeRoom(int roomNumber) {
        Room room = new Chamber(roomNumber);
        for(Direction direction : Direction.values()) {
            room.setSide(direction, makeWall());
        }

        return room;
    }

    @Override
    public Wall makeWall() {
        return new Abyss();
    }
}
