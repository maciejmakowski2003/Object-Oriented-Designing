package pl.edu.agh.internetshop;

import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
