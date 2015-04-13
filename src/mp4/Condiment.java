package mp4;

abstract class Condiment {
	private double amount;
	private IObserver[] observerList;
	private String name;
	
	public abstract void RegisterObserver();
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
}
