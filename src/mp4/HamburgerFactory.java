package mp4;

class HamburgerFactory extends BurgerFactory {

	public HamburgerFactory(IObserver inventory, IObserver projection) {
		IObserver[] observerList = new IObserver[2];
		observerList[0] = inventory;
		observerList[1] = projection;
		ingredientCnt = 2 ;
		ingredientList = new Condiment[ingredientCnt];
		//initalize the 3 condiments for the cheeseburger,
		ingredientList[0] = new CondimentBun(observerList);
		ingredientList[1] = new CondimentBeefPatty(observerList);
	}
	
	public void createBurger(int num) {
		for(Condiment c : ingredientList){//for each condiment c in the ingredient list
			c.Amount(num);//set the amount of each ingredient
			c.NotifyObserver();
		}
	}

}
