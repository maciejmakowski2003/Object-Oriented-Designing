package print.invoice;

import document.Invoice;

public abstract class PrintInvoiceTemplate {
    protected abstract void printHeader(Invoice invoice);
    protected abstract void printBody(Invoice invoice);
    protected abstract void printFooter(Invoice invoice);
    public void printInvoice(Invoice invoice)
    {
        printHeader(invoice);
        printBody(invoice);
        printFooter(invoice);
    }
}
