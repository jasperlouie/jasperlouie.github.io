
import java.util.Comparator;
import java.util.Date;

/**
 *  This class contains the methods for the items in the library.
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class Item implements Comparable<Item>{
	/** A unique number for each item in the library */
	private int itemNumber;

	/** type of item */
	private LibraryType type;

	/** title of item */
	private String title;

	/** author/singer/publisher */
	private String author;

	/** published date (month/year) */
	private Date pubDate;

	/** indicates if item is checked out */
	private boolean isCheckedOut;

	/** due date for item */
	private Date dueDate;
	
	/**
	 * Constructs an item for the library
	 *
	 * @param	idNumber	item id
	 * @param	t		item type
	 * @param	ti		item title
	 * @param	a		item author
	 * @param	d		item published date
	 */
	public Item(String idNumber, LibraryType t, String ti, String a, String d){
		this.itemNumber=Integer.parseInt(idNumber);
		this.type = t;
		this.title = ti;
		this.author = a;
		this.pubDate = DateUtil.parseShortDate(d);
		isCheckedOut = false;
	}
	
	/* getters and setters */
	/**
	 * sets Item ID number to given int
	 *
	 * @param	i	item id
	 */
	public void setItemNumber(int i){
		itemNumber = i;
	}
	
	/**
	 * sets Item Type to given Type
	 *
	 * @param	t	item type
	 */
	public void setType(LibraryType t){
		type = t;
	}
	
	/**
	 * Sets Item title to given String
	 *
	 * @param	t	item title
	 */
	public void setTitle(String t){
		title = t;
	}
	
	/**
	 * Sets Item author to given String
	 *
	 * @param	a	item author
	 */
	public void setAuthor(String a){
		author = a;
	}
	
	/**
	 * Sets Item published date to given Date
	 *
	 * @param	d	item publish date
	 */
	public void setPubDate(Date d){
		pubDate = d;
	}
	
	/**
	 * returns Id number of item
	 *
	 * @return the ID number of the item
	 */
	public int getItemNumber(){
		return itemNumber;
	}
	/**
	 * returns Type of the item
	 *
	 * @return the type of the item
	 */
	public LibraryType getType(){
		return type;
	}
	/**
	 * returns the title String of the item
	 *
	 * @return title String
	 */
	public String getTitle(){
		return title;
	}
	/**
	 * returns author of item
	 *
	 * @return the String of the author of the item
	 */
	public String getAuthor(){
		return author;
	}
	/**
	 * returns published date of item
	 *
	 * @return the Date published of the item
	 */
	public Date getPubDate(){
		return pubDate;
	}
	
	/**
	 * Return a String array of the descriptive strings for this item
	 *
	 * @return a String array containing descriptive strings for this 
	 * item's information
	 */
	public String[] toStringArray(){

		String[] result = new String[5];
		result[0]=""+this.itemNumber;
		result[1]=this.type.getCode();
		result[2]=this.title;
		result[3]=this.author;
		result[4]=DateUtil.printShortDate(this.pubDate);
		return result;
	}

	/**
	 * Indicate if this item is checked out.
	 *
	 * @return the checkout status of this item
	 */
	public boolean isCheckedOut(){
		return isCheckedOut;
	}
	
	/**
	 * Change the status of this item to checked out and
	 * set the due date for this item to two weeks in the future.
	 *
	 */
	public void checkOut(){
		isCheckedOut = true;
		dueDate = DateUtil.getDateTwoWeeksLater();
	}
	
	/**
	 * Change the status of this item to checked out and
	 * set the due date for this item.
	 *
	 * @param	d	the item's due date
	 */
	public void checkOut(Date d){
		isCheckedOut = true;
		dueDate = d;
	}
	
	/**
	 * Indicates if this item is overdue (the due date has passed
	 * the current date.
	 *
	 * @return the checkout status for this item
	 */
	public boolean isOverdue(){
		if(isCheckedOut){
			Date currentDate = DateUtil.today();
			if(currentDate.compareTo(dueDate)>0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Change the status of this item to not checked out and
	 * reset the due date.
	 */
	public void returnItem(){
		isCheckedOut = false;
		dueDate = null;
	}
	
	
	/**
	 * Returns a descriptive string for this item
	 *
	 * @return a descriptive string for this item
	 */
	public String toString(){
		return title;
	}

	/**
	 * Return the difference between the two item number
	 *
	 * @return the difference between the two item number
	 */
	public int compareTo(Item compareItem) {
 
		int compareItemNumber = ((Item) compareItem).getItemNumber(); 
 
		//ascending order
		return this.itemNumber - compareItemNumber;
 
		//descending order
		//return compareItemNumber - this.ItemNumber;
 
	}
 
	/**
	 * Comparator for sorting items by title
	 */
	public static Comparator<Item> ItemTitleComparator 
                          = new Comparator<Item>() {
 
	    public int compare(Item item1, Item item2) {
 
	      String title1 = item1.getTitle().toUpperCase();
	      String title2 = item2.getTitle().toUpperCase();
 
	      //ascending order
	      return title1.compareTo(title2);
 
	      //descending order
	      //return title2.compareTo(title1);
	    }
 
	};

	/**
	 * Comparator for sorting items by type
	 */
	public static Comparator<Item> ItemTypeComparator 
                          = new Comparator<Item>() {
 
	    public int compare(Item item1, Item item2) {
 
	      LibraryType itemType1 = item1.getType();
	      LibraryType itemType2 = item2.getType();
 
	      //ascending order
	      return itemType1.compareTo(itemType2);
 
	      //descending order
	      //return itemType2.compareTo(itemType1);
	    }
 
	};

}
