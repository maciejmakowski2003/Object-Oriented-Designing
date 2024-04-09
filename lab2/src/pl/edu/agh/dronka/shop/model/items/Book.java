package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Book extends Item {
    int page_number;
    boolean hard_cover;

    public Book(String name, Category category, int price, int quantity, int page_number, boolean hard_cover) {
        super(name, category, price, quantity);
        this.page_number = page_number;
        this.hard_cover = hard_cover;
    }

    public Book(){
        super();
    };

    public int getPage_number() {
        return page_number;
    }

    public void setPageNumber(int page_number) {
        this.page_number = page_number;
    }

    public boolean getHardCover() {
        return hard_cover;
    }

    public void setHardCover(boolean hard_cover) {
        this.hard_cover = hard_cover;
    }
}
