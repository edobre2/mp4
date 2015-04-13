package mp4;
import java.util.Date;

interface Inventory {
	public Product[] GenerateShoppingList(Projection p, Date now);
	public void AddProduct(Product p);
	public void ListInventory();
}
