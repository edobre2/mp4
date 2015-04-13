package mp4;

class Projection implements IObserver {
	private Product[] productList;
	
	public Projection() {
		productList = new Product[100];
		for(Product p : productList)
			p = null;
	}
	
	public Product[] GetProducts() {
		return productList;
	}
	
	public void update(Condiment c) {
		
	}
}
