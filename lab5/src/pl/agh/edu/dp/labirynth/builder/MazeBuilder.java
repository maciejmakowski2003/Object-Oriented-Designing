package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;

public interface MazeBuilder {
    public void addRoom(int roomNumber);
    public void addDoor(int roomFrom, int roomTo, Direction fromDirection);
    public void reset();
}
