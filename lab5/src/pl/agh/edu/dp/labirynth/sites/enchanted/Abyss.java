package pl.agh.edu.dp.labirynth.sites.enchanted;

import pl.agh.edu.dp.labirynth.sites.standard.Wall;

public class Abyss extends Wall {
    public Abyss() {
        super();
    }

    @Override
    public void enter(){
        System.out.println("Watch out for the Abyss!");
    }
}
