import java.util.Comparator;

/**
 * InventoryItem<br>
 * The InventoryComparator Class sort the inventory list using comparator
 * 
 * @author Prince Adrianne Felix
 * @since 2021-04-07 CST8130 Data Structures
 * @version 1.0
 * 
 */
public class InventoryComparator implements Comparator<InventoryItem>{
	
	//Returns the sorted Inventory
	public int compare(InventoryItem o1, InventoryItem o2) {
		return o1.getItemCode() - o2.getItemCode();
	}
}
