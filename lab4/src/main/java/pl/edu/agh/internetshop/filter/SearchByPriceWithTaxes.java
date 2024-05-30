package pl.edu.agh.internetshop.filter;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class SearchByPriceWithTaxes implements SearchStrategy{
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public SearchByPriceWithTaxes(double minPrice, double maxPrice){
        if(minPrice < 0 || maxPrice < 0 || minPrice > maxPrice)
            throw new IllegalArgumentException("Invalid price range");
        this.minPrice = BigDecimal.valueOf(minPrice);
        this.maxPrice = BigDecimal.valueOf(maxPrice);
    }

    @Override
    public boolean filter(Order order){
        BigDecimal priceWithTax = order.getPriceWithTaxes();
        return priceWithTax.compareTo(minPrice) >=0 && priceWithTax.compareTo(maxPrice)<=0;
    }
}
