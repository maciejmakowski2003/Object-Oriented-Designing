package discount;

public class GetPriceWithPercentageDiscount implements GetPriceWithDiscount {
    private final double discount;

    public GetPriceWithPercentageDiscount(double discount)
    {
        this.discount = discount;
    }
    @Override
    public double getPriceWithDiscount(double price) {
        return (1 - discount) * price;
    }
}
