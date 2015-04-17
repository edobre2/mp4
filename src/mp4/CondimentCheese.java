package mp4;

class CondimentCheese extends Condiment {

	//if provided an observer list at intialization
	public CondimentCheese(IObserver[] oList) {
		
		observerList = oList;
		name = "Cheese";
		
	}
	
	
	//if provided the observers at intialization
	public CondimentCheese(BurgerStoreInventory bs, Projection p) {
		
		observerList[0] = bs;
		observerList[1] = p;
		name = "Cheese";
		
	}


	//calls update in BurgerStoreInventory and Projection
	public void NotifyObserver() {
		
		observerList[0].update(this);
		observerList[1].update(this);
	}

}
