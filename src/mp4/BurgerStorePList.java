package mp4;

public class BurgerStorePList implements ProductList {
	private Product[] products;
	private int max_count;
	private int count;
	private String productName;
	
	public BurgerStorePList(String name) {
		
	}
	
	@Override
	public Iterator CreateIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int cnt) {
		
	}
	
	public String getProductName() {
		return productName;
	}
}
