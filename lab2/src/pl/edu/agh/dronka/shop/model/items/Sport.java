package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Sport extends Item {
    public Sport (String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    public Sport() {
        super();
    }
}
