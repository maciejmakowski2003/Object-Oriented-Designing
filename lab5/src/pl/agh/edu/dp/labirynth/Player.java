package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.sites.standard.Room;

public class Player {
    private Room currentRoom;
    private int hp = 3;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void move(Room roomNumber) {
        currentRoom = roomNumber;
    }

    public void hit() {
        hp--;
        System.out.println("Player was hit! HP: " + hp);
    }

    public void kill() {
        hp = 0;
        System.out.println("Player was killed!");
    }

    public int getHp() {
        return hp;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
