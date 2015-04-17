package mp4;

abstract class Condiment {
	protected double amount;
	protected IObserver[] observerList;
	protected String name;
	
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
