package mp4;

class ProductIterator implements Iterator {

	// reference to the product list
	Product[] products;
	// current index
	int position;
	
	
	// constructor takes a reference to the product list
	// sets the index to the first element
	public ProductIterator(Product[] pList) {
		products = pList;
		position = 0;
	}
	
	
	// checks if next element is null
	public boolean hasNext() {
		if (products[position] == null)
			return false;
		return true;
	}

	
	// returns the next element
	public Object next() {
		return products[position++];
	}

	// removes the first element in the array and shifts the 
	// rest one position down
	// resets the position to the start of the list
	public void removeElement() {
		position = 0;
		while(products[position] != null) {
			products[position] = products[position+1];
			position++;
		}
		position = 0;
	}

	// sets next object to o
	public void next(Object o) {
		products[position++] = (Product) o;
	}
}
