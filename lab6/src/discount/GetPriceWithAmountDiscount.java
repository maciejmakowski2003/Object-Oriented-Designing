package discount;

import static java.lang.Math.max;

public class GetPriceWithAmountDiscount implements GetPriceWithDiscount{
    private final double discount;

    public GetPriceWithAmountDiscount(double discount)
    {
        this.discount = discount;
    }

    @Override
    public double getPriceWithDiscount(double price)
    {
        return max(0,price - discount);
    }
}
