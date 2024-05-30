package pl.edu.agh.internetshop.filter;

import pl.edu.agh.internetshop.Order;

public interface SearchStrategy {
    public boolean filter(Order order);
}
