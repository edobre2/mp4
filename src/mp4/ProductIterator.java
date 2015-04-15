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
		position = 0;
		while(products[position] != null) {
			products[position] = products[position+1];
		}
		position = 0;
	}

	public void next(Object o) {
		products[position++] = (Product) o;
	}
}
