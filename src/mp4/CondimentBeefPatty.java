package mp4;

class CondimentBeefPatty extends Condiment {

	//if provided an observer list at intialization
	public CondimentBeefPatty(IObserver[] oList) {
		
		observerList = oList;
		name = "Beef Patty";
		
	}
	
	
	//if provided the observers at intialization
	public CondimentBeefPatty(BurgerStoreInventory bs, Projection p) {
		
		observerList[0] = bs;
		observerList[1] = p;
		name = "Beef Patty";
		
	}


	//calls update in BurgerStoreInventory and Projection
	public void NotifyObserver() {
		
		observerList[0].update(this);
		observerList[1].update(this);
	}

}
