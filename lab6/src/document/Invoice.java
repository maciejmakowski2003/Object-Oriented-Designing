package document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import configuration.Configuration;
import discount.DiscountConfiguration;
import discount.GetPriceWithDiscount;
import storage.Goods;


public class Invoice {
	Date dateOfSale;
	String contractor;
	ArrayList<Position> positions;
	double sum;
	GetPriceWithDiscount discount;

	public Invoice(Date dateOfSale, String contractor, Configuration configuration)
	{
		this.dateOfSale = dateOfSale;
		this.contractor = contractor;
		positions = new ArrayList<>();
		sum = 0;
		this.discount = configuration.getDiscountMethod();
	}

	public void addPosition(Goods goods, double amount)
	{
		positions.add(new Position(goods,amount));
		this.countSum();
	}

	public double getSum()
	{
		return sum;
	}

	public Date getDateOfSale()
	{
		return dateOfSale;
	}


	private void countSum()
	{
		Iterator<Position> itr=positions.iterator();
		Position position;
		sum =0;
		while(itr.hasNext())
		{
			position = itr.next();
			sum += discount.getPriceWithDiscount(position.getTotalPrice());
		}
	}
	public Iterator<Position> getPositionIterator()
	{
		return positions.iterator();
	}
	public String getContractor()
	{
		return this.contractor;
	}
	
}
