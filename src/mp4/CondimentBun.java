package mp4;

class CondimentBun extends Condiment {

	//if provided an observer list at intialization
	public CondimentBun(IObserver[] oList) {
		
		observerList = oList;
		name = "Bun";
		
	}
	
	
	//if provided the observers at intialization
	public CondimentBun(BurgerStoreInventory bs, Projection p) {
		
		observerList[0] = bs;
		observerList[1] = p;
		name = "Bun";
		
	}

	
	//calls update in BurgerStoreInventory and Projection
	public void NotifyObserver() {
		
		observerList[0].update(this);
		observerList[1].update(this);
	}

}
