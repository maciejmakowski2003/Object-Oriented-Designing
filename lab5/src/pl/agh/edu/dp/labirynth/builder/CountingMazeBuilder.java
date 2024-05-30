package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import java.util.HashMap;

public class CountingMazeBuilder implements MazeBuilder{
    private int rooms = 0;
    private int doors = 0;
    private int walls = 0;
    @Override
    public void addRoom(int roomNumber) {
        rooms++;
        walls += 4;
    }

    @Override
    public void addDoor(int roomFrom, int roomTo, Direction fromDirection) {
        doors++;
        walls -= 2;
    }

    @Override
    public void reset() {
        rooms = 0;
        doors = 0;
        walls = 0;
    }

    public HashMap<String, Integer> getCounts(){
        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("rooms", rooms);
        counts.put("doors", doors);
        counts.put("walls", walls);
        return counts;
    }
}
