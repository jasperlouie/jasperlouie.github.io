
import java.util.Comparator;
import java.util.Date;

/**
 *  Contains the methods for a borrowed/checked out library item
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class ItemOut implements Comparable<ItemOut>{
	/** the itemNumber of the checked out item */
	int itemNumber;

	/** the patronNumber of the patron who checked out the item */
	int patronNumber;

	/** the date the patron checked out the item */
	Date dateCheckedOut;

	/** the date the checked out item is due */
	Date dateDue;
	
	/**
	 * Constructs a instance for the checked out item
	 *
	 * @param	in	itemNumber for the item
	 * @param	pn	patronNumber for the patron
	 * @param	dco	the checkout date string
	 * @param	dd	the due date string
	 */
	public ItemOut(String in, String pn, String dco, String dd){
		itemNumber = Integer.parseInt(in);
		patronNumber = Integer.parseInt(pn);
		dateCheckedOut = DateUtil.parseDate(dco);
		dateDue = DateUtil.parseDate(dd);
	}
	
	/**
	 * Constructs a instance for the checked out item
	 *
	 * @param	in	itemNumber for the item
	 * @param	pn	patronNumber for the patron
	 * @param	dco	the checkout date
	 * @param	dd	the due date
	 */
	public ItemOut(String in, String pn, Date dco, Date dd){
		itemNumber = Integer.parseInt(in);
		patronNumber = Integer.parseInt(pn);
		dateCheckedOut = dco;
		dateDue = dd;
	}
	
	/* getters and setters */
	/**
	 * returns item ID Number
	 *
	 * @return The Item's ID
	 */
	public int getItemNumber() {
		return itemNumber;
	}
	
	/**
	 * sets Item ID number to given int
	 *
	 * @param	itemNumber	item id
	 */
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	/**
	 * returns the Patron to whom the Item is checked out
	 *
	 * @return Patron who the item is checked out to
	 */
	public int getPatronNumber() {
		return patronNumber;
	}
	
	/**
	 * sets Patron to whom the item is checked out to
	 *
	 * @param	patronNumber	Patron's ID
	 */
	public void setPatronNumber(int patronNumber) {
		this.patronNumber = patronNumber;
	}
	
	/**
	 * returns the Date that the item was checked out
	 *
	 * @return	Date dateCheckedOut
	 */
	public Date getDateCheckedOut() {
		return dateCheckedOut;
	}
	
	/**
	 * sets the Date that the item was checked out to the given Date
	 *
	 * @param	dateCheckedOut	Date that the item was checked out
	 */
	public void setDateCheckedOut(Date dateCheckedOut) {
		this.dateCheckedOut = dateCheckedOut;
	}
	public Date getDateDue() {
		return dateDue;
	}
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}
	
	/**
	 * Returns a String array of descriptive strings for a checked out
	 * library item
	 *
	 * @return a string array of descriptive strings for this object
	 */
	public String[] toStringArray(){
		String[] output = {itemNumber+"",patronNumber+"",DateUtil.printDate(dateCheckedOut),DateUtil.printDate(dateDue)};
		return output;
	}

	/**
	 * Compare by checked out item item number
	 *
	 * @param  compareItemOut item to be compared
	 * @return difference in item number
	 */
	public int compareTo(ItemOut compareItemOut) {
 
		int compareItemNumber = ((ItemOut) compareItemOut).getItemNumber(); 
 
		//ascending order
		return this.itemNumber - compareItemNumber;
 
		//descending order
		//return compareItemNumber - this.ItemNumber;
 
	}


 
	
	/**
	 * Comparator for sorting by due date
	 */
	public static Comparator<ItemOut> ItemOutDueDateComparator 
                          = new Comparator<ItemOut>() {
 
	    public int compare(ItemOut itemOut1, ItemOut itemOut2) {
 
	      Date itemOutDueDate1 = itemOut1.getDateDue();
	      Date itemOutDueDate2 = itemOut2.getDateDue();
 
	      //ascending order
	      return itemOutDueDate1.compareTo(itemOutDueDate2);
 
	      //descending order
	      //return itemOutDueDate2.compareTo(itemOutDueDate1);
	    }
 
	};

	/**
	 * Comparator for sorting by item type
	 */
	public static Comparator<ItemOut> ItemOutTypeComparator 
                          = new Comparator<ItemOut>() {
 
	    public int compare(ItemOut itemOut1, ItemOut itemOut2) {
	      LibraryDatabase library = LibraryDatabase.getInstance();
 
	      Item item1 = library.findItem(itemOut1.getItemNumber());
	      Item item2 = library.findItem(itemOut2.getItemNumber());
 
	      //ascending order 
	      return item1.getType().compareTo(item2.getType());

	    }
 
	};

	/**
	 * Comparator for sorting by patron
	 */
	public static Comparator<ItemOut> ItemOutPatronComparator 
                          = new Comparator<ItemOut>() {
 
	    public int compare(ItemOut itemOut1, ItemOut itemOut2) {
	      LibraryDatabase library = LibraryDatabase.getInstance();
 
	      Patron patron1 = library.findPatron(itemOut1.getPatronNumber());
	      Patron patron2 = library.findPatron(itemOut2.getPatronNumber());
 
	      //ascending order 
	      return patron1.compareTo(patron2);
	    }
 
	};
}
