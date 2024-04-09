package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Date;

public class Food extends Item{
    Date expiration_date;

    public Food(String name, Category category, int price, int quantity, Date expiration_date) {
        super(name, category, price, quantity);
        this.expiration_date = expiration_date;
    }

    public Food(){
        super();
    };

    public Date getExpirationDate() {
        return expiration_date;
    }

    public void setExpirationDate(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
