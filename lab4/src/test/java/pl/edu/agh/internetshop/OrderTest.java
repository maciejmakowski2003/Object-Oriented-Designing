package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProductAndUser() {
		Product product = mock(Product.class);
		User user = mock(User.class);
		return new Order(product, user);
	}

	private Order getOrderWithMockedUser(List<Product> products) {
		User user = mock(User.class);
		return new Order(products, user);
	}

	private Order getOrderWithMockedUser(List<Product> products, double discount) {
		User user = mock(User.class);
		return new Order(products, discount, user);
	}

	private Order getOrderWithMockedUser(Product product) {
		User user = mock(User.class);
		return new Order(Collections.singletonList(product), user);
	}

	@Test
	public void testGetProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		User user = mock(User.class);
		Order order = new Order(expectedProduct, user);

		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertEquals(1, actualProducts.size());
		assertSame(expectedProduct, actualProducts.get(0));
	}

	@Test
	public void testGetProductsThroughOrder() {
		// given
		int expectedProductsNumber = 3;
		List<Product> expectedProducts = new ArrayList<>();
		for (int i = 0; i < expectedProductsNumber; i++) {
			expectedProducts.add(mock(Product.class));
		}
		Order order = getOrderWithMockedUser(expectedProducts);

		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertEquals(expectedProductsNumber, actualProducts.size());
		assertSame(expectedProducts, actualProducts);
	}

	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPrice() throws Exception {
		// given
		int expectedProductPrice = 1000;
		Order order = getOrderWithCertainProductPrice(expectedProductPrice);

		// when
		BigDecimal actualProductPrice = order.getPrice();
		System.out.println(actualProductPrice);
		// then
		assertBigDecimalCompareValue(BigDecimal.valueOf(expectedProductPrice), actualProductPrice);
	}

	private Order getOrderWithCertainProductPrice(double productPriceValue) {
		Product product = new Product("", BigDecimal.valueOf(productPriceValue));
		User user = mock(User.class);
		return new Order(product,user);
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(2); // 2 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
																							
	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN
																							
	}

	@Test
	public void testPriceWithGlobalDiscountWithoutTax(){
		//given
		Product product1 = new Product("a", BigDecimal.valueOf(100));
		Product product2 = new Product("b", BigDecimal.valueOf(15));
		Product product3 = new Product("c", BigDecimal.valueOf(20));
		Product product4 = new Product("d", BigDecimal.valueOf(55));

		Order order = getOrderWithMockedUser(List.of(product1, product2, product3, product4), 0.1);

		//when
		BigDecimal expectedPrice = BigDecimal.valueOf(171);

		//then
		assertBigDecimalCompareValue(expectedPrice, order.getPrice());
	}

	@Test
	public void testPriceWithIndividualDiscountWithoutTax(){
		//given
		Product product1 = new Product("a", BigDecimal.valueOf(100));
		Product product2 = new Product("b", BigDecimal.valueOf(15));
		Product product3 = new Product("c", BigDecimal.valueOf(20));
		Product product4 = new Product("d", BigDecimal.valueOf(55));
		Order order = getOrderWithMockedUser(List.of(product1, product2, product3, product4));

		//when
		order.setSingleProductDiscount(product1, 0.2);
		order.setSingleProductDiscount(product2, 0.1);
		BigDecimal expectedPrice = BigDecimal.valueOf(168.5);

		//then
		assertBigDecimalCompareValue(expectedPrice, order.getPrice());
	}

	@Test
	public void testPriceWithGlobalDiscountWithTax(){
		//given
		Product product1 = new Product("a", BigDecimal.valueOf(100));
		Product product2 = new Product("b", BigDecimal.valueOf(15));
		Product product3 = new Product("c", BigDecimal.valueOf(20));
		Product product4 = new Product("d", BigDecimal.valueOf(55));
		Order order = getOrderWithMockedUser(List.of(product1, product2, product3, product4), 0.1);

		//when
		BigDecimal expectedPrice = BigDecimal.valueOf(210.33);

		//then
		assertBigDecimalCompareValue(expectedPrice, order.getPriceWithTaxes());
	}

	@Test
	public void testPriceWithIndividualDiscountWithTax(){
		//given
		Product product1 = new Product("a", BigDecimal.valueOf(100));
		Product product2 = new Product("b", BigDecimal.valueOf(15));
		Product product3 = new Product("c", BigDecimal.valueOf(20));
		Product product4 = new Product("d", BigDecimal.valueOf(55));
		Order order = getOrderWithMockedUser(List.of(product1, product2, product3, product4));

		//when
		order.setSingleProductDiscount(product1, 0.2);
		order.setSingleProductDiscount(product2, 0.1);
		BigDecimal expectedPrice = BigDecimal.valueOf(207.26);

		//then
		assertBigDecimalCompareValue(expectedPrice, order.getPriceWithTaxes());
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProductAndUser();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProductAndUser();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProductAndUser();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProductAndUser();

		// when

		// then
		assertFalse(order.isPaid());
	}
}
