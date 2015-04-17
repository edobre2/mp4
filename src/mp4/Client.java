package mp4;
import java.util.Date;
class Client {
	private static Inventory inventory;
	private static Projection projection;

	//changes reflected

	public static void main(String[] args) {
		inventory = new BurgerStoreInventory();
		projection = new Projection();
		inventory.AddProduct(new Product("Cheese", new Date(), new Date(), 5.0));
		inventory.AddProduct(new Product("Bun", new Date(), new Date(), 20.0));
		inventory.AddProduct(new Product("Bacon", new Date(), new Date(), 7.0));
		
		inventory.ListInventory();
		System.out.println("djshf");
		// loop through:
		// ask user what they want to do
		// list out options
		// call function based on choice
		// MEHHHH
	}
	
	public void GetSalesFromPrevDay() {
		// let user input burgers
		// >> Enter # of hamburgers sold
		// 7
		// create an instance of HamburgerFactory
		// createBurger(7);
		// for every burger type
	}

	public void GetShoppingList() {
		// call generate shopping list
		// print result
	
	}
	
	public void ListInventory() {
		// call inventory.ListInventory()
	}
	
	public void AddToInventory() {
		// ask user what they want to add
		// ask for expiration date
		// ask for amount
		// make new product and call inventory.AddProduct()
	}
}
