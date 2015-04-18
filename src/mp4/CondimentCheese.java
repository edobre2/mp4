package mp4;

class CondimentCheese extends Condiment {

	public CondimentCheese() {
		shelfLife = 5;
		observerList = new IObserver[20];
		name = "Cheese";
	}

	public void AddObserver(IObserver observer) {
		observerList[observerCnt++] = observer;
	}
	
	public void RemoveObserver(IObserver observer) {
		for(int i = 0; i < observerCnt; i++) {
			if (observerList[i] == observer) 
				observerList[i] = null;
		}
	}
	
	//calls update in BurgerStoreInventory and Projection
	public void NotifyObservers() {		
		for(IObserver observer: observerList) {
			if(observer != null)
				observer.update(this);
		}
	}
}
