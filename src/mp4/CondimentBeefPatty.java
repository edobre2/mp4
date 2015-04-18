package mp4;

class CondimentBeefPatty extends Condiment {

	public CondimentBeefPatty() {
		shelfLife = 3;
		name = "Beef Patty";	
	}
	
	
	//if provided the observers at intialization
	public CondimentBeefPatty(BurgerStoreInventory bs, Projection p) {
		observerList = new IObserver[20];
		observerList[0] = bs;
		observerList[1] = p;
		name = "Beef Patty";
		
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
