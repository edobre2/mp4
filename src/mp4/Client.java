package mp4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Client {
	private static BurgerStoreInventory inventory;
	private static Projection projection;
	private static IObserver[] observerList;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ParseException {

		System.out.println("Welcome! Press <ENTER> to begin!");

		String line;
		Scanner scanner;
		BufferedReader lineReader;
		inventory = new BurgerStoreInventory();
		projection = new Projection();
		
		observerList = new IObserver[2];
		observerList[0] = inventory;
		observerList[1] = projection;

		while (true) // loops until 'q' is entered
		{
			lineReader = new BufferedReader(new InputStreamReader(System.in));

			while ((line = lineReader.readLine()) != null) // stops reading at
															// end of line
			{
				scanner = new Scanner(line);

				char ch = 'z';
				if (scanner.hasNext())
					ch = scanner.next().charAt(0); // gets first character

				if (ch == 's') // input sales
					GetSalesFromPrevDay();
				else if (ch == 'l') // get shopping list
					GetShoppingList();
				else if (ch == 'i') // list inventory
					ListInventory();
				else if (ch == 'a') // display list
					AddToInventory();
				else if (ch == 'q') // quit program
					System.exit(0);

				System.out
						.println("Options:\n <s> - input sales\n <l> - get shopping list\n <i>"
								+ " - list inventory\n <a> - add to inventory\n <q> - quit program\n\n");
			}
		}
	}

	public static void GetSalesFromPrevDay() {
		BaconCheeseburgerFactory bcbf = new BaconCheeseburgerFactory();
		bcbf.createBurger(5, observerList);
		CheeseburgerFactory cbf = new CheeseburgerFactory();
		cbf.createBurger(7, observerList);
		HamburgerFactory hbf = new HamburgerFactory();
		hbf.createBurger(3, observerList);
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the # of BaconCheeseBurgers sold yesterday:");
		int num = sc.nextInt();
		BaconCheeseburgerFactory bcbf = new BaconCheeseburgerFactory();
		bcbf.createBurger(num, observerList);
		System.out.print("Please enter the # of CheeseBurgers sold yesterday:");
		num = sc.nextInt();
		CheeseburgerFactory cbf = new CheeseburgerFactory();
		cbf.createBurger(num, observerList);
		System.out.print("Please enter the # of Hamburger sold yesterday:");
		num = sc.nextInt();
		HamburgerFactory hbf = new HamburgerFactory();
		hbf.createBurger(num, observerList);
		sc.close();
		*/
	}

	public static void GetShoppingList() {
		Date now = new Date(0);
		Product[] p = inventory.GenerateShoppingList(projection, now);
		System.out.printf("Shopping List: \n");
		for(Product product : p ) {
			if (product != null)
				System.out.printf("%s: %3.2f\n", product.GetName(), product.GetAmount());
		}
	}

	public static void ListInventory() {
		inventory.ListInventory();
	}

	public static void AddToInventory() throws ParseException {
		Product p = new Product("Bun", new Date(), new Date(), 5.0);
		inventory.AddProduct(p);
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you want to add more products?(Y/N):");
		char ch = sc.next().charAt(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		if (ch == 'y' || ch == 'Y') {
			do {
				sc.nextLine();
				System.out.print("Enter the name of the product:");
				String name = sc.nextLine();
				System.out.print("Enter the amount of the product:");
				int amount = sc.nextInt();
				System.out.print("Enter the purchase date of the product:(yyyy/MM/dd HH:mm:ss)");
				String str = sc.nextLine();
				Date purDate = format.parse(str);
				System.out.print("Enter the expiration date of the product:(yyyy/MM/dd HH:mm:ss)");
				String str1 = sc.nextLine();
				Date expDate = format.parse(str1);
				Product p = new Product(name, expDate, purDate, amount);
				inventory.AddProduct(p);
				System.out.print("Do you want to add more products?(Y/N):");
				ch = sc.next().charAt(0);
			} while (ch == 'y' || ch == 'Y');
		}
		sc.close();
		*/
	}
}