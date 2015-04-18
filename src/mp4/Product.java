package mp4;
import java.util.Date;
import java.util.Calendar;

class Product {
	private double amount;
	private Date purchaseDate;
	private Date expirationDate;
	private String name;
	
	public Product(String n, Date e, Date p, double a) {
		name = n;
		purchaseDate = p;
		expirationDate = e;
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
