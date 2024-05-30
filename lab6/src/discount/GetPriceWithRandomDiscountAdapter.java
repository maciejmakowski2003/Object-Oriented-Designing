package discount;

import rabatlosowy.LosowyRabat;

public class GetPriceWithRandomDiscountAdapter implements GetPriceWithDiscount{
    private final GetPriceWithPercentageDiscount getPriceWithPercentageDiscount;

    public GetPriceWithRandomDiscountAdapter() {
        LosowyRabat losowyRabat = new LosowyRabat();
        getPriceWithPercentageDiscount = new GetPriceWithPercentageDiscount(losowyRabat.losujRabat());
    }

    @Override
    public double getPriceWithDiscount(double price) {
        return getPriceWithPercentageDiscount.getPriceWithDiscount(price);
    }
}
