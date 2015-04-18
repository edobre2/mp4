package mp4;

abstract class Condiment implements Subject{
	protected double amount;
	protected IObserver[] observerList;
	protected int observerCnt;
	protected String name;
	protected int shelfLife;
		
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
