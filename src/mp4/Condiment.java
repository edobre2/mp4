package mp4;

abstract class Condiment {
	private double amount;
	private IObserver[] observerList;
	private String name;
	protected int shelfLife;
	
	public abstract void NotifyObserver();
	
	public double Amount() {
		return amount;
	}
	
	public void Amount(double d) {
		amount = d;
	}
	
	public String Name() {
		return name;
	}
	
	public void setShelfLife(int days) {
		shelfLife = days;
	}
	
	public int setShelfLife() {
		return shelfLife;
	}
}
