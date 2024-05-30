package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.sites.standard.Door;
import pl.agh.edu.dp.labirynth.sites.standard.Room;

import java.util.HashMap;

public class StandardMazeBuilder implements MazeBuilder {
    private final HashMap<Integer, Room> currentMaze = new HashMap<>();
    private MazeFactory mazeFactory;

    public StandardMazeBuilder(MazeFactory mazeFactory){
        this.mazeFactory = mazeFactory;
    }

    @Override
    public void addRoom(int roomNumber) {
        if(currentMaze.containsKey(roomNumber)){
            throw new IllegalArgumentException("Room number: " + roomNumber + " already exists");
        }

        Room room = mazeFactory.makeRoom(roomNumber);
        currentMaze.put(roomNumber, room);
    }

    @Override
    public void addDoor(int roomFrom, int roomTo, Direction fromDirection) {
        Room r1 = currentMaze.get(roomFrom);
        if(r1 == null){
            throw new IllegalArgumentException("Room number: " + roomFrom + "  not found");
        }
        Room r2 = currentMaze.get(roomTo);
        if(r2 == null){
            throw new IllegalArgumentException("Room number: " + roomTo + "  not found");
        }

        Door door = mazeFactory.makeDoor(r1, r2, fromDirection);
    }

    @Override
    public void reset() {
        currentMaze.clear();
    }

    public void setMazeFactory(MazeFactory mazeFactory){
        this.mazeFactory = mazeFactory;
    }

    public Maze buildMaze(){
        return new Maze(currentMaze.values());
    }
}
