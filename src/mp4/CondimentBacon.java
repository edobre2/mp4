package mp4;

class CondimentBacon extends Condiment {

	//if provided an observer list at intialization
	public CondimentBacon(IObserver[] oList) {
		
		observerList = oList;
		name = "Bacon";
	}
	
	
	//if provided the observers at intialization
	public CondimentBacon(BurgerStoreInventory bs, Projection p) {
		
		observerList[0] = bs;
		observerList[1] = p;
		name = "Bacon";
		
	}
	

	//calls update in BurgerStoreInventory and Projection
	public void NotifyObserver() {		
		
		observerList[0].update(this);
		observerList[1].update(this);
	}

}
