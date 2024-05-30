package pl.agh.edu.dp.labirynth.sites.bombed;

import pl.agh.edu.dp.labirynth.sites.standard.Wall;

public class BombedWall extends Wall {
    public BombedWall() {
        super();
    }

    @Override
    public void enter(){
        System.out.println("You hit Bombed Wall");
    }
}
