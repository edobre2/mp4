package mp4;
import java.util.Date;

class Product {
	private double amount;
	private Date purchaseDate;
	private Date expirationDate;
	private String name;
	
	public Product(String name, Date expDate, Date purchDate) {
		
	}
	
	public double GetAmount() {
		return amount;
	}
	
	public void SetAmount(double amt) {
		
	}
	
	public String GetName() {
		return name;
	}
	
	public Date GetExpirationDate() {
		return expirationDate;
	}
}
