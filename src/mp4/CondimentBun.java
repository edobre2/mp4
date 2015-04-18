package mp4;

class CondimentBun extends Condiment {

	//if provided an observer list at intialization
	public CondimentBun() {
		observerList = new IObserver[20];
		shelfLife = 2;
		name = "Bun";
		
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
