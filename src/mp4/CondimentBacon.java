package mp4;

class CondimentBacon extends Condiment {
	
	//if provided the observers at intialization
	public CondimentBacon() {
		observerList = new IObserver[20];
		observerCnt = 0;
		name = "Bacon";	
		shelfLife = 5;
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
