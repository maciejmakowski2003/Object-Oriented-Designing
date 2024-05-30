package storage;

public class Goods {
	private final double price;
	private final String name;
	
	public Goods(double price, String name)
	{
		this.price = price;
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}

	public String getName()
	{
		return name;
	}
}
