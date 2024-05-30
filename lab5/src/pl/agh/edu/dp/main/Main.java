package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.sites.standard.Room;

public class Main {

    public static void main(String[] args) {
        StandardMazeBuilder builder = new StandardMazeBuilder(MazeFactory.getInstance());
        builder.addRoom(1);
        builder.setMazeFactory(BombedMazeFactory.getInstance());
        builder.addRoom(2);
        builder.setMazeFactory(MazeFactory.getInstance());
        builder.addRoom(3);
        builder.setMazeFactory(EnchantedMazeFactory.getInstance());
        builder.addRoom(4);
        builder.addDoor(1, 2, Direction.North);
        builder.addDoor(2, 3, Direction.East);
        builder.addDoor(3, 4, Direction.South);
        builder.addDoor(2, 4, Direction.West);

        MazeGame game = new MazeGame();
        game.createMaze(builder);

        game.play();
    }
}



