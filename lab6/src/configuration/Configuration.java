package configuration;

import discount.GetPriceWithDiscount;
import print.invoice.PrintInvoiceTemplate;

public class Configuration {
    private static Configuration instance = null;

    private final GetPriceWithDiscount discountMethod;
    private final PrintInvoiceTemplate printInvoiceTemplate;

    private Configuration(GetPriceWithDiscount discountMethod, PrintInvoiceTemplate printInvoiceTemplate) {
        this.discountMethod = discountMethod;
        this.printInvoiceTemplate = printInvoiceTemplate;
    }

    public static Configuration getInstance(GetPriceWithDiscount discountMethod, PrintInvoiceTemplate printInvoiceTemplate) {
        if (instance == null)
            instance = new Configuration(discountMethod, printInvoiceTemplate);
        return instance;
    }

    public GetPriceWithDiscount getDiscountMethod() {
        return discountMethod;
    }

    public PrintInvoiceTemplate getPrintInvoiceTemplate() {
        return printInvoiceTemplate;
    }
}
