package mp4;

class ProductIterator implements Iterator {

	Product[] products;
	int position;
	
	public ProductIterator(Product[] pList) {
		products = pList;
		position = 0;
	}
	
	public boolean hasNext() {
		if (products[position] == null)
			return false;
		return true;
	}

	public Object next() {
		return products[position++];
	}

	public void removeElement() {
		
	}

	public void next(Object o) {
		products[position++] = (Product) o;
	}
}
