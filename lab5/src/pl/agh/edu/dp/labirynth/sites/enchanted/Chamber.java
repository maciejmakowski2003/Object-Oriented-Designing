package pl.agh.edu.dp.labirynth.sites.enchanted;

import pl.agh.edu.dp.labirynth.sites.standard.Room;

import java.util.Random;

public class Chamber extends Room {

    private final int secretKey;
    public Chamber(int roomNumber) {

        super(roomNumber);
        Random random = new Random();
        secretKey = random.nextInt(2);
    }

    @Override
    public void enter(){
        System.out.println("You are in Chamber");
    }

    public boolean unlock(int key){
        return key == secretKey;
    }
}
