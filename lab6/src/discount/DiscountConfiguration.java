package discount;

public class DiscountConfiguration {
    private static DiscountConfiguration instance = null;

    private final GetPriceWithDiscount discountMethod;

    private DiscountConfiguration(GetPriceWithDiscount discountMethod) {
        this.discountMethod = discountMethod;
    }

    public static DiscountConfiguration getInstance(GetPriceWithDiscount discountMethod) {
        if (instance == null)
            instance = new DiscountConfiguration(discountMethod);
        return instance;
    }

    public GetPriceWithDiscount getDiscountMethod() {
        return discountMethod;
    }
}
