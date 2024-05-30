package pl.agh.edu.dp.labirynth.sites.standard;

import pl.agh.edu.dp.labirynth.sites.MapSite;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void enter(){
        System.out.println("You hit Wall");
    }
}
