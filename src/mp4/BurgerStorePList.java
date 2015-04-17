package mp4;

public class BurgerStorePList implements ProductList {
	private Product[] products;
	private int max_count;
	private int count;
	private String productName;
	
	public BurgerStorePList(String name) {
		productName = name;
		max_count = 100;
		products = new Product[max_count];
		count = 0;
	}
	
	public Iterator CreateIterator() {
		return new ProductIterator(products);
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int cnt) {
		count = cnt;
	}
	
	public String getProductName() {
		return productName;
	}
}
