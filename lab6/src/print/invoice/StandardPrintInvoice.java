package print.invoice;

import document.Invoice;
import document.Position;

import java.util.Iterator;

public class StandardPrintInvoice extends PrintInvoiceTemplate {
    @Override
    protected void printHeader(Invoice invoice) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: " + invoice.getDateOfSale().toString() + " dla: " + invoice.getContractor());
        System.out.println("=====================================================");
    }

    @Override
    protected void printBody(Invoice invoice) {
        Iterator<Position> itr = invoice.getPositionIterator();
        while(itr.hasNext())
        {
            Position position=itr.next();
            System.out.println("Towar: " + position.getName() + " Ilosc: " + position.getAmount() + " Wartosc:" + position.getTotalPrice());
        }
        System.out.println("=====================================================");
    }

    @Override
    protected void printFooter(Invoice invoice) {
        System.out.println("Na kwote: " + invoice.getSum());
        System.out.println("=====================================================");
    }
}
