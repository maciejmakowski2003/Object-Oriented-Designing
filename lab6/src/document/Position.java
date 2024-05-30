package document;

import storage.Goods;

public class Position {
	private Goods goods;
	private double price;
	private double amount;
	private double totalPrice;
	private final String name;

	public Position(Goods goods, double amount) {
		this.goods = goods;
		this.amount = amount;
		this.price = goods.getPrice();
		this.name = goods.getName();
		this.countTotalPrice();
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
		this.price = goods.getPrice();
		this.countTotalPrice();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		this.countTotalPrice();
	}

	public double getPrice()
	{
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
		this.countTotalPrice();
	}

	public String getName() {
		return name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	private void countTotalPrice() {
		this.totalPrice = this.amount * this.price;
	}

}
