package pl.agh.edu.dp.labirynth.sites.bombed;

import pl.agh.edu.dp.labirynth.sites.standard.Room;

public class BombedRoom extends Room {
    public BombedRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public void enter(){
        System.out.println("You are in Bombed Room");
    }
}
