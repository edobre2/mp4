package mp4;
import java.util.Date;

class Projection implements IObserver {
	private Product[] productList;
	int length;

	public Projection() {
		productList = new Product[100];
		length = 0;
	}

	public void addProduct(Product p) {
		productList[length] = p;
		length++;
	}

	public Product[] GetProducts() {
		return productList;
	}

	public void update(Condiment c) {
		Date purchaseDate = new Date();
		// 24*60*1000 = 1 day, multiply that by shelf life
		long timeadj = 24*60*60*1000*c.shelfLife;
		Date expirationDate = new Date(purchaseDate.getTime() + timeadj);
	    Product p = new Product(c.Name(), expirationDate, purchaseDate, c.Amount());
	    addProduct(p);
	}
}