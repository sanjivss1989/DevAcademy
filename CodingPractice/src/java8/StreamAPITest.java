/**
 * 
 */
package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author server
 *
 */
public class StreamAPITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Fill up Some Test Data
		
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Mary");
		names.add("Sanjiv");
		names.add("Rakesh");
		names.add("Ram");
		names.add("Jolly");
		names.add("Andy");
		names.add("David");
		names.add("Vishal");
		names.add("Aditya");
		
		
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product("1010A", "mobile", 1500, 45, "Apple"));
		productsList.add(new Product("1010B", "mobile", 1590, 45, "Apple"));
		productsList.add(new Product("5677X", "laptop", 2300, 80, "Dell"));
		productsList.add(new Product("7080", "tablet", 1200, 90, "Lenovo"));
		productsList.add(new Product("5677Y", "laptop", 1598, 40, "Dell"));
		
		
		// Example of Filtering operations
		
		
		// Filter  out names having length > 6
		
		List<String> filteredList1 = names.stream().filter(n -> n.length()<6).collect(Collectors.toList());
		filteredList1.forEach(System.out::println);
		
		// Filter out with multiple conditions
		
		List<String> filteredList2 = names.stream().filter(n -> n.length()<6 && n.startsWith("A")).collect(Collectors.toList());
		filteredList2.forEach(System.out::println);
		
		
		// Aggregate Operations
		
		// # Counting Operation
		long countResult = productsList.stream().filter(p -> p.getPrice()>1500).count();
		System.out.println(" Count of products ==> "+countResult);
		
		
		// # Use Like Opeartions
		productsList.stream().filter(p -> p.getName().startsWith("lap")).collect(Collectors.toList())
		.forEach(n -> {System.out.println(n.toString());});
		
		// # Sort Operator ascending order
		productsList.stream().sorted((p1,p2) -> (int)(p1.getPrice()-p2.getPrice())).collect(Collectors.toList())
		.forEach(n -> {System.out.println(n.toString());});
		
		// # Limit Operator
		
		productsList.stream().limit(3).collect(Collectors.toList())
		.forEach(n -> {System.out.println(n.toString());});
		
		// # Group By
		Map<String, Long> m = productsList.stream().collect(Collectors.groupingBy(Product::getManufacturer, Collectors.counting()));
		
		for(String grpName : m.keySet())
		{
			System.out.println("Group Name ==> "+grpName);
			System.out.println("Products ==> "+m.get(grpName));
		}
		
		
		Map<String, Integer> calculateMap = productsList.stream().collect(Collectors.groupingBy(Product::getManufacturer,Collectors.summingInt(Product::getQuantity)));
		
		for(String grpName : calculateMap.keySet())
		{
			System.out.println("Group Name ==> "+grpName);
			System.out.println("Quantity of Product ==> "+calculateMap.get(grpName));
		}
		
		// # Map Operator
		
		names.stream().map(n -> "Mr. ".concat(n)).collect(Collectors.toList()).forEach(System.out::println);

	   // # Sum operator
		
		int s = productsList.stream().mapToInt(p -> p.getQuantity()).sum();
		System.out.println("Total quantity of all products==> "+s);
		
		// # Min and Max
		Product product1 = productsList.stream().max((p1,p2) -> (int)(p1.getPrice()-p2.getPrice())).get();
		System.out.println("Product with Maximum Price  "+product1.toString());
		
		Product product2 = productsList.stream().min((p1,p2) -> (int)(p1.getPrice()-p2.getPrice())).get();
		System.out.println("Product with Minimum Price  "+product2.toString());
		
		
		
	
	}

}

class Product
{
	private String id;
	private String name;
	private int price;
	private int quantity;
	private String manufacturer;
	
	
	public Product(String id, String name, int price, int quantity, String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", manufacturer=" + manufacturer + "]";
	}
	
	
	
	
	
}
