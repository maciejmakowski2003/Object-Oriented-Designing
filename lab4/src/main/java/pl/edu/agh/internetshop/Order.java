package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final List<Product> products;
    private final Map<Product, Double> discounts;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private final User user;

    public Order(Product product, User user){
        this(Collections.singletonList(product), 0.0, user);
    }

    public Order(List<Product> products, User user){
        this(products, 0.0, user);
    }

    public Order(List<Product> products, double discount, User user) {
        if(discount < 0.0 || discount > 1.0)
            throw new IllegalArgumentException("Discount must be between 0.0 and 1.0");

        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        discounts = createDiscountsMap(products, discount);
        this.user = user;
    }

    private Map<Product, Double> createDiscountsMap(List<Product> products, double discount) {
        return products.stream().
                collect(Collectors.toMap(product -> product, product -> discount));
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public User getUser(){return user;}

    public BigDecimal getPrice() {
        return products.stream().
                reduce(BigDecimal.ZERO, (sum, product) -> sum.add(product.getPrice(discounts.get(product))), BigDecimal::add);
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, RoundingMode.HALF_UP);
    }

    public List<Product> getProducts() {
        return products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setSingleProductDiscount(Product product, double discount) {
        if(discount < 0.0 || discount > 1.0)
            throw new IllegalArgumentException("Discount must be between 0.0 and 1.0");
        discounts.put(product, discount);
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccessful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccessful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
