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
								+ " - list inventory\n <a> - add to inventory\n <q> - quit program");
			}
		}
	}

	public static void GetSalesFromPrevDay() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the # of BaconCheeseBurgers sold yesterday:");
		int num = Integer.parseInt(sc.nextLine());
		BaconCheeseburgerFactory bcbf = new BaconCheeseburgerFactory();
		bcbf.createBurger(num, observerList);
		System.out.print("Please enter the # of CheeseBurgers sold yesterday:");
		num = Integer.parseInt(sc.nextLine());
		CheeseburgerFactory cbf = new CheeseburgerFactory();
		cbf.createBurger(num, observerList);
		System.out.print("Please enter the # of Hamburger sold yesterday:");
		num = Integer.parseInt(sc.nextLine());
		HamburgerFactory hbf = new HamburgerFactory();
		hbf.createBurger(num, observerList);
	}

	public static void GetShoppingList() {
		Date now = new Date(0);
		Product[] p = inventory.GenerateShoppingList(projection, now);
		System.out.printf("Shopping List: \n");
		for(Product product : p ) {
			if (product != null)
				System.out.printf("%10s: %7.2f\n", product.GetName(), product.GetAmount());
		}
	}

	public static void ListInventory() {
		inventory.ListInventory();
	}

	public static void AddToInventory() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you want to add more products?(Y/N):");
		char ch = sc.nextLine().charAt(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		if (ch == 'y' || ch == 'Y') {
			do {
				System.out.print("Enter the name of the product:");
				String name = sc.nextLine();
				System.out.print("Enter the amount of the product:");
				int amount = Integer.parseInt(sc.nextLine());
				System.out.print("Enter the purchase date of the product:(yyyy/MM/dd HH:mm:ss)");
				String str = sc.nextLine();
				Date purDate = format.parse(str);
				System.out.print("Enter the expiration date of the product:(yyyy/MM/dd HH:mm:ss)");
				String str1 = sc.nextLine();
				Date expDate = format.parse(str1);
				Product p = new Product(name, expDate, purDate, amount);
				inventory.AddProduct(p);
				System.out.print("Do you want to add more products?(Y/N):");
				ch = sc.nextLine().charAt(0);
			} while (ch == 'y' || ch == 'Y');
		}
	}
}