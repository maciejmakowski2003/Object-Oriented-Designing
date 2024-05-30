package print.invoice;

import document.Invoice;

public class ShortPrintInvoice extends PrintInvoiceTemplate{

    @Override
    protected void printHeader(Invoice invoice) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: " + invoice.getDateOfSale().toString());
        System.out.println("Kontrahent: " + invoice.getContractor());
        System.out.println("=====================================================");
    }

    @Override
    protected void printBody(Invoice invoice) {
        System.out.println("=====================================================");
    }

    @Override
    protected void printFooter(Invoice invoice) {
        System.out.println("Na kwote: " + invoice.getSum());
        System.out.println("=====================================================");
    }
}
