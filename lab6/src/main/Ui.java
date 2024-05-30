package main;

import java.util.Iterator;
import java.util.Calendar;

import category.Category;
import category.CategoryComposite;
import category.Subcategory;
import configuration.Configuration;
import discount.DiscountConfiguration;
import discount.GetPriceWithPercentageDiscount;

import discount.GetPriceWithRandomDiscountAdapter;
import print.invoice.StandardPrintInvoice;
import storage.Goods;
import document.Invoice;


public class Ui {

	public static void main(String[] args) {
		Calendar now=Calendar.getInstance();
		
		//Goods
		Goods t1 = new Goods(100, "Laptop");
		Goods t2 = new Goods(50, "Mysz");
		Goods t3 = new Goods(20, "Klawiatura");
		Goods t4 = new Goods(200, "Monitor");
		Goods t5 = new Goods(10, "Pendrive");

		//Category
		CategoryComposite elektronika = new Subcategory("Elektronika");
		CategoryComposite akcesoriaKomputerowe = new Subcategory("Akcesoria Komputerowe");
		CategoryComposite komputery = new Category("Komputery");
		CategoryComposite myszki = new Category("Myszki");
		CategoryComposite klawiatury = new Category("Klawiatury");
		CategoryComposite monitory = new Category("Monitory");
		CategoryComposite pendrive = new Category("Pendrive'y");

		((Category) komputery).addGoods(t1);
		((Category) myszki).addGoods(t2);
		((Category) klawiatury).addGoods(t3);
		((Category) monitory).addGoods(t4);
		((Category) pendrive).addGoods(t5);

		akcesoriaKomputerowe.add(myszki);
		akcesoriaKomputerowe.add(klawiatury);
		akcesoriaKomputerowe.add(monitory);
		akcesoriaKomputerowe.add(pendrive);

		elektronika.add(komputery);
		elektronika.add(akcesoriaKomputerowe);

		elektronika.print();
		

		//Configuration
		Configuration configuration = Configuration.getInstance(new GetPriceWithRandomDiscountAdapter(), new StandardPrintInvoice());
		
		//Invoice
		Invoice f = new Invoice(now.getTime(),"Fido", configuration);
		f.addPosition(t1,3);
		f.addPosition(t2, 5);
		f.addPosition(t3, 10);
		f.addPosition(t4, 1);
		f.addPosition(t5, 2);

		configuration.getPrintInvoiceTemplate().printInvoice(f);
	}
}
