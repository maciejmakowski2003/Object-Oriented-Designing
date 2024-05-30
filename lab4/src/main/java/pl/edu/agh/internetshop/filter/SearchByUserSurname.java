package pl.edu.agh.internetshop.filter;

import pl.edu.agh.internetshop.Order;

public class SearchByUserSurname implements SearchStrategy {

    private final String userSurname;

    public SearchByUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    @Override
    public boolean filter(Order order) {
        return order.getUser().getSurname().equals(userSurname);
    }
}
