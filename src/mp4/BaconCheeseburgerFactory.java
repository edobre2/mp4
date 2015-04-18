package mp4;

class BaconCheeseburgerFactory extends BurgerFactory implements CreateBurgerStrategy {

	//constructor
	public BaconCheeseburgerFactory() {
		// nothing to do
	}
	
	public void createBurger(int num, IObserver[] observerList) {
		ingredientCnt = 4 ;
		ingredientList = new Condiment[ingredientCnt];
		
		//initalize the 4 condiments for the burger,
		ingredientList[0] = new CondimentBun();
		for(IObserver obs : observerList)
			ingredientList[0].AddObserver(obs);
		
		ingredientList[1] = new CondimentCheese();
		for(IObserver obs : observerList)
			ingredientList[1].AddObserver(obs);	
		ingredientList[2] = new CondimentBacon();
		for(IObserver obs : observerList)
			ingredientList[2].AddObserver(obs);
		ingredientList[3] = new CondimentBeefPatty();
		for(IObserver obs : observerList)
			ingredientList[3].AddObserver(obs);
		
		for(int i = 0; i< ingredientList.length; i++){
			ingredientList[i].Amount(num);//set the amount of each ingredient
			ingredientList[i].NotifyObservers();
		}
	}
}
