package mp4;
import java.util.Date;

class BurgerStoreInventory implements Inventory, IObserver {

	
	private ProductList[] productList; // array of ProductList items
	
	
	// Constructor for BurgerStoreInventory
	// initializes the product list
	public BurgerStoreInventory() {
		// list can have a maximum of 100 items
		productList = new ProductList[100];
		
		// initialize list to null
		for(ProductList p : productList) {
			p = null;
		}
	} // end constructor
	
	
	// print the name amount and expiration date for each product
	// to standard output
	public void ListInventory() {
		// iterate through every list
		for(ProductList pList : productList) {
			// check if list is initialized
			if(pList == null)
				continue;
			
			// create an iterator to go through the product list
			Iterator iterator = pList.CreateIterator();
			
			// print the name of the product, amount and expiration date
			while(iterator.hasNext()) {
				Product p = (Product) iterator.next();
				System.out.printf("%s [%lf units] [expires: %s]\n", p.GetName(), 
						p.GetAmount(), p.GetExpirationDate().toString());
			}
		} // end for
	} // end ListInventory

	
	public Product[] GenerateShoppingList(Projection projection, Date dateNow) {
		double amount = 0.0; // total amount of product in inventory
		int count = 0; // number of items in shopping list
		Iterator it;

		CheckExpirationDates(dateNow);
		
		Product[] projectionList = projection.GetProducts();
		Product[] shoppingList = new Product[100];
		
		// initialize shopping list to null
		for(Product product : shoppingList)
			product = null;
		
		// for every product in projection list, check the total amount
		// of that product in inventory and take the difference
		for(Product p : projectionList) {
			// find out the total amount in inventory
			for(ProductList pList : productList) {
				// empty list
				if (pList == null)
					continue;
				// list of a different product
				if( ((BurgerStorePList)pList).getProductName() != p.GetName())
					continue;
				
				it = pList.CreateIterator();
				while(it.hasNext()) {
					Product invProduct = (Product) it.next();
					amount += invProduct.GetAmount();
				} // end while loop
			}// end for loop
			
			double diff = p.GetAmount() - amount;
			if (diff > 0) {
				// positive difference new amount is projection - inventory;
				p.SetAmount(diff);
				shoppingList[count++] = p;
			}
			// if diff is less than or equal to 0, don't add this product to 
			// the shopping list, the inventory already has enough of it
			amount = 0.0;
		} // end for loop
		
		// making the assumption that when the shopping list is generated, the person will
		// add those items to the inventory
		for (Product p : shoppingList) {
			if (p != null) 
				AddProduct(p);
		}
		return shoppingList;
	} // end GenerateShoppingList

	
	// adds newProduct to the appropriate product list
	public void AddProduct(Product newProduct) {
		Iterator it;
		
		// find the list containing this product
		for(ProductList pList : productList) {
			
			// list not initialized, insert product here
			if(pList == null) {
				pList = new BurgerStorePList(newProduct.GetName());
				it = pList.CreateIterator();
				it.next(newProduct);
				return;
			}
			
			it = pList.CreateIterator();
			// list is initialized, check if it actually contains something
			if(!it.hasNext()) {
				// list is empty, insert here
				it.next(newProduct);
				return;
			}
			
			// list is initialized and contains products
			// try to match the product name
			Product p = (Product) it.next();
			if(p.GetName() == newProduct.GetName()){
				// names match, insert product at the end of list
				while(it.hasNext()) {
					it.next();
				}
				it.next(newProduct);
			}
			// continue to next list
		} // end for loop
	} // end AddProduct()

	
	// subtracts the amount of condiment c from the product list
	public void update(Condiment c) {
		double remainingAmount = c.Amount();
		Iterator it;
		
		// find the list for that product
		for(ProductList pList : productList) {
			// check for uninitialized list
			if (pList == null)
				continue;
			String productName = ((BurgerStorePList)pList).getProductName();

			if (productName == c.Name()) {
				// this list contains products of the same type as condiment
				it = pList.CreateIterator();
				
				while(it.hasNext() && remainingAmount > 0) {
					// get the first element in the list
					Product p = (Product) it.next();
					// reset iterator to point to the first element again
					it = pList.CreateIterator();
					
					double diff = p.GetAmount() - remainingAmount;
					if ( diff > 0 ) {
						// positive difference -> subtract remainingAmount from the product amount
						p.SetAmount(diff);
						it.next(p);
						return;
					}
					if ( diff >= 0) {
						// negative or 0 difference 
						remainingAmount = -diff;
						it.removeElement();
					}
				} // end while
			} // end if
		} // end for
	} // end update()
	
	
	// checks expiration dates of each item in inventory
	// and discards expired product
	private void CheckExpirationDates(Date now) {
		Iterator it;
		
		// for each product list in array
		for(ProductList pList : productList) {
			// if empty continue
			if(pList == null)
				continue;
			it = pList.CreateIterator();
			
			// for every item in pList
			while(it.hasNext()) {
				// if expired
				if( ((Product) it.next()).GetExpirationDate().after(now)) {
					// discard and reset iterator to start of pList
					it.removeElement();
					it = pList.CreateIterator();
				} // end if
			} // end while loop
		} // end for loop
	} // end CheckExpirationDates()
} // end BurgerStoreInventory
