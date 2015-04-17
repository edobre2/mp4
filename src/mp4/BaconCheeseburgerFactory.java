package mp4;

class BaconCheeseburgerFactory extends BurgerFactory {

	//constructor
	public BaconCheeseburgerFactory(IObserver inventory, IObserver projection) {
		IObserver[] observerList = new IObserver[2];
		observerList[0] = inventory;
		observerList[1] = projection;
		ingredientCnt = 4 ;
		ingredientList = new Condiment[ingredientCnt];
		//initalize the 4 condiments for the burger,
		ingredientList[0] = new CondimentBun(observerList);
		ingredientList[1] = new CondimentCheese(observerList);
		ingredientList[2] = new CondimentBacon(observerList);
		ingredientList[3] = new CondimentBeefPatty(observerList);
	}
	public void createBurger(int num) {
		for(int i = 0; i< ingredientList.length; i++){
			ingredientList[i].Amount(num);//set the amount of each ingredient
			ingredientList[i].NotifyObserver();
		}
	}
}
