package pl.edu.agh.internetshop.filter;

import pl.edu.agh.internetshop.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final List<SearchStrategy> strategyList;

    public Filter() {
        this.strategyList = new ArrayList<>();
    }
    public Filter(SearchStrategy strategy) {
        this.strategyList = Collections.singletonList(strategy);
    }

    public Filter(List<SearchStrategy> strategyList) {
        this.strategyList = strategyList;
    }

    public List<Order> filterOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> strategyList.stream().allMatch(strategy -> strategy.filter(order)))
                .collect(Collectors.toList());
    }
}
