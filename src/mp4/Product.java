package mp4;
import java.util.Date;

class Product {
	private double amount;
	private Date purchaseDate;
	private Date expirationDate;
	private String name;
	
	public Product(String n, Date e, Date p, double a) {
		name = n;
		expirationDate = e;
		purchaseDate = p;
		amount = a;
	}
	
	public double GetAmount() {
		return amount;
	}
	
	public void SetAmount(double amt) {
		amount = amt;
	}
	
	public String GetName() {
		return name;
	}
	
	public Date GetExpirationDate() {
		return expirationDate;
	}
}
