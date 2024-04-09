package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Date;
import pl.edu.agh.dronka.shop.model.Genre;

public class Music extends Item{
    Genre genre;
    boolean video_attached;

    public Music(String name, Category category, int price, int quantity, Genre genre, boolean video_attached) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.video_attached = video_attached;
    }

    public Music(){
        super();
    };

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean getVideoAttached() {
        return video_attached;
    }

    public void setVideoAttached(boolean video_attached) {
        this.video_attached = video_attached;
    }
}
