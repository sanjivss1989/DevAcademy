/**
 * 
 */
package com.sanjib.concepts;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * @author server
 *
 */
public class SortingService {
	
	public static void main(String args[])
	{
		List<Product> p = new ArrayList<Product>();
		p.add(new Product(500,56447, "ABC"));
		p.add(new Product(545,56445, "CDE"));
		p.add(new Product(540,56447, "DEF"));
		
		//sort(p, "PRICE_SORT");
		
		sort(p, "NAME_SORT");
		
	}
	
	
	public static void sort(List<Product> pList, String sortType)
	{
		if("PRICE_SORT".equals(sortType))
		{
			Collections.sort(pList, new PriceComparator());
			for(Product p : pList)
			{
				System.out.println(p.getId()+" "+p.getPrice()+" "+p.getName());
			}
		}
		else
		{
			Collections.sort(pList, new NameComparator());
			for(Product p : pList)
			{
				System.out.println(p.getId()+" "+p.getPrice()+" "+p.getName());
			}
		}
	}

}
class Product 
{
	private double price;
	private int id;
	private String name;
	
	
	
	
	public Product(double price, int id, String name) {
		super();
		this.price = price;
		this.id = id;
		this.name = name;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}

}

class  PriceComparator implements Comparator<Product>
{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		if(o1.getPrice()>o2.getPrice())
			return 1;
		else if (o1.getPrice()<o2.getPrice())
			return -1;
			else
		return 0;
	}
	
}

class NameComparator implements Comparator<Product>
{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}
