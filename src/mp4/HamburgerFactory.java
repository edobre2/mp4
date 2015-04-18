package mp4;

class HamburgerFactory extends BurgerFactory {

	public HamburgerFactory() {
		// nothing to do
	}
	
	public void createBurger(int num, IObserver[] observerList) {
		ingredientCnt = 2 ;
		ingredientList = new Condiment[ingredientCnt];
		
		//initalize the 3 condiments for the cheeseburger,
		ingredientList[0] = new CondimentBun();
		for(IObserver obs : observerList)
			ingredientList[0].AddObserver(obs);
		ingredientList[1] = new CondimentBeefPatty();
		for(IObserver obs : observerList)
			ingredientList[1].AddObserver(obs);
		
		for(int i = 0; i< ingredientList.length; i++){
			ingredientList[i].Amount(num);//set the amount of each ingredient
			ingredientList[i].NotifyObservers();
		}
	}

}
