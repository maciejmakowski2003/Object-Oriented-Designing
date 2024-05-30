package pl.edu.agh.internetshop.filter;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class SearchByPriceWithoutTaxes implements  SearchStrategy{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public SearchByPriceWithoutTaxes(double minPrice, double maxPrice){
        if(minPrice < 0 || maxPrice < 0 || minPrice > maxPrice)
            throw new IllegalArgumentException("Invalid price range");
        this.minPrice = BigDecimal.valueOf(minPrice);
        this.maxPrice = BigDecimal.valueOf(maxPrice);
    }

    @Override
    public boolean filter(Order order){
        BigDecimal price = order.getPrice();
        return price.compareTo(minPrice) >=0 && price.compareTo(maxPrice)<=0;
    }
}
