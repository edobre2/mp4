package mp4;

class CheeseburgerFactory extends BurgerFactory {

	public CheeseburgerFactory(IObserver inventory, IObserver projection) {
		IObserver[] observerList = new IObserver[2];
		observerList[0] = inventory;
		observerList[1] = projection;
		ingredientCnt = 3 ;
		ingredientList = new Condiment[ingredientCnt];
		//initalize the 3 condiments for the cheeseburger,
		ingredientList[0] = new CondimentBun(observerList);
		ingredientList[1] = new CondimentCheese(observerList);
		ingredientList[2] = new CondimentBeefPatty(observerList);

	}
	
	public void createBurger(int num) {
		for(Condiment c : ingredientList){//for each condiment c in the ingredient list
			c.Amount(num);//set the amount of each ingredient
			c.NotifyObserver();
		}

	}

}
