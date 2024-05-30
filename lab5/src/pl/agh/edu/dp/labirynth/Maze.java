package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.sites.standard.Room;

import java.util.Collection;
import java.util.Vector;

public class Maze {
    public Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<>();
    }

    public Maze(Collection<Room> rooms) {
        this.rooms = new Vector<>(rooms);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
