package pl.edu.agh.internetshop.filter;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.Order;
import pl.edu.agh.internetshop.Product;
import pl.edu.agh.internetshop.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class FilterTest {
    private List<Order> getSampleOrders() {
        Product product1 = new Product("Product1", BigDecimal.valueOf(50));
        Product product2 = new Product("Product2", BigDecimal.valueOf(100));
        Product product3 = new Product("Product3", BigDecimal.valueOf(150));
        Product product4 = new Product("Product4", BigDecimal.valueOf(200));

        User user1 = mock(User.class);
        given(user1.getSurname()).willReturn("Kowalski");
        User user2 = mock(User.class);
        given(user2.getSurname()).willReturn("Nowak");

        Order order1 = new Order(List.of(product1, product2, product3), user1);//300 369
        Order order2 = new Order(List.of(product1, product2, product3), 0.2, user1);//240 295,2
        Order order3 = new Order(List.of(product2, product4), user2);//230 282,9
        order3.setSingleProductDiscount(product2, 0.1);
        order3.setSingleProductDiscount(product4, 0.3);
        Order order4 = new Order(List.of(product1, product3), user2);//200 246

        return new ArrayList<>(List.of(order1, order2, order3, order4));
    }

    @Test
    public void testSearchByUserSurname() {
        //given
        List<Order> orders = getSampleOrders();
        Filter filter = new Filter(new SearchByUserSurname("Kowalski"));

        //when
        List<Order> filteredOrders = filter.filterOrders(orders);

        //then
        assertEquals(2, filteredOrders.size());
        assertTrue(filteredOrders.stream()
                .allMatch(order -> order.getUser().getSurname().equals("Kowalski")));
    }

    @Test
    public void testSearchByProductName() {
        //given
        List<Order> orders = getSampleOrders();
        Filter filter = new Filter(new SearchByProductName("Product1"));

        //when
        List<Order> filteredOrders = filter.filterOrders(orders);

        //then
        assertEquals(3, filteredOrders.size());
        assertTrue(filteredOrders.stream()
                .allMatch(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getName().equals("Product1"))));
    }

    @Test
    public void testSearchByPriceWithoutTaxes() {
        //given
        List<Order> orders = getSampleOrders();
        double minPrice = 200;
        double maxPrice = 240;
        Filter filter = new Filter(new SearchByPriceWithoutTaxes(minPrice, maxPrice));

        //when
        List<Order> filteredOrders = filter.filterOrders(orders);

        //then
        assertEquals(3, filteredOrders.size());
        assertTrue(filteredOrders.stream()
                .allMatch(order -> order.getPrice()
                        .compareTo(BigDecimal.valueOf(minPrice)) >= 0 && order.getPrice()
                        .compareTo(BigDecimal.valueOf(maxPrice)) <= 0));
    }

    @Test
    public void testSearchByPriceWithTaxes() {
        //given
        List<Order> orders = getSampleOrders();
        double minPrice = 282.9;
        double maxPrice = 295.2;
        Filter filter = new Filter(new SearchByPriceWithTaxes(minPrice, maxPrice));

        //when
        List<Order> filteredOrders = filter.filterOrders(orders);

        //then
        assertEquals(2, filteredOrders.size());
        assertTrue(filteredOrders.stream()
                .allMatch(order -> order.getPriceWithTaxes()
                        .compareTo(BigDecimal.valueOf(minPrice)) >= 0 && order
                        .getPriceWithTaxes().compareTo(BigDecimal.valueOf(maxPrice)) <= 0));
    }

    @Test
    public void testMultipleSearchStrategies(){
        //given
        List<Order> orders = getSampleOrders();
        double minPrice = 200;
        double maxPrice = 239.5;
        double minPriceTax = 246;
        double maxPriceTax = 369;
        List<SearchStrategy> strategies = List.of(
            new SearchByPriceWithoutTaxes(minPrice, maxPrice),
            new SearchByPriceWithTaxes(minPriceTax, maxPriceTax),
            new SearchByUserSurname("Nowak"),
            new SearchByProductName("Product4")
        );
        Filter filter = new Filter(strategies);

        //when
        List<Order> filteredOrders = filter.filterOrders(orders);

        //then
        assertEquals(1, filteredOrders.size());
    }
}
