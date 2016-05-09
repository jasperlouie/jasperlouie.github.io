
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 *  Contains the methods to manage the data for the library system.
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class LibraryDatabase {
	
	static LibraryDatabase libraryDatabase;

	/** The array list of the library items */
	private ArrayList<Item> items = new ArrayList<Item>();

	/** The array list of the library patrons */
	private ArrayList<Patron> patrons= new ArrayList<Patron>();

	/** The array list of the library item types */
	private ArrayList<LibraryType> types= new ArrayList<LibraryType>();

	/** The array list of the library checked out items */
	private ArrayList<ItemOut> itemsOut= new ArrayList<ItemOut>();

	/** The high value for the patron number  */
	private int patronNumberHigh = 0;

	/** The high value for the item number  */
	private int itemNumberHigh = 0;


	/**
	 * returns the Database's ArrayList of Items
	 *
	 * @return ArrayList of Items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * returns the Database's ArrayList of Patrons
	 *
	 * @return ArrayList of Patrons
	 */
	public ArrayList<Patron> getPatrons() {
		return patrons;
	}

	/**
	 * returns the Database's ArrayList of Types
	 *
	 * @return ArrayList of Types
	 */
	public ArrayList<LibraryType> getTypes() {
		return types;
	}
	
	/**
	 * returns the Database's ArrayList of ItemOuts
	 *
	 * @return ArrayList of ItemsOut
	 */
	public ArrayList<ItemOut> getItemsOut(){
		return itemsOut;
	}
	/**
	 * Removes any checkout record of the given item
	 *
	 * @param   i	Item of which the records are to be removed
	 */
	public void deleteItemOut(Item i){
		ItemOut targetItemOut= null;
		for(ItemOut io: itemsOut){
			if(io.getItemNumber()==i.getItemNumber()){
				targetItemOut=io;
			}
		}
		itemsOut.remove(targetItemOut);
	}
	/**
	 * Removes any checkout records from the given Patron
	 *
	 * @param   p	Patron of whom's item records are to be removed
	 */
	public void deleteItemOut(Patron p){
		ArrayList<ItemOut> targetItemsOut = new ArrayList<ItemOut>();
		for(ItemOut io: itemsOut){
			if(io.getPatronNumber()==p.getPatronNumber()){
				targetItemsOut.add(io);
			}
		}
		for(ItemOut io: targetItemsOut){
			itemsOut.remove(io);
		}
	}
	/**
	 * Removes Item from library database
	 *
	 * @param   i	Item to be removed
	 */
	public void deleteItem(Item i){
		Item targetItem= null;
		for(Item i2: items){
			if(i2.getItemNumber()==i.getItemNumber()){
				targetItem=i2;
			}
		}
		deleteItemOut(targetItem);
		items.remove(targetItem);
	}
	/**
	 * Removes given Patron from Library Database
	 *
	 * @param	p	the Patron to be removed
	 */
	public void deletePatron(Patron p){
		Patron targetPatron= null;
		for(Patron p2: patrons){
			if(p2.getPatronNumber()==p.getPatronNumber()){
				targetPatron=p2;
			}
		}
		patrons.remove(targetPatron);
		deleteItemOut(targetPatron);
	}
	
	
	/**
	 * Create the library database if it does not already exist.  
	 * Then return the library database
	 *
	 * @return return the library database
	 */
	 public static LibraryDatabase getInstance() {
		if (libraryDatabase == null) {
			libraryDatabase = new LibraryDatabase();
		}
		return libraryDatabase;
	}

	/**
	 * Return a copy of the arraylist of all library database items
	 *
	 * @return copy of Items array
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Item> getItemsCopy() {
		return ((ArrayList<Item>) items.clone());
	}
	
	/**
	 * Return a copy of the arraylist of all library database patrons
	 *
	 * @return copy of Patrons array
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Patron> getPatronsCopy() {
		return ((ArrayList<Patron>) patrons.clone());
	}

	/**
	 * Return a copy of the arraylist of all library database checked
	 * out items
	 *
	 * @return  copy of ItemOut array
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ItemOut> getItemsOutCopy() {
		return ((ArrayList<ItemOut>) itemsOut.clone());
	}

	/**
	 * Adds the type to arraylist of types
	 *
	 * @param	t	item type being added to arraylist of types
	 */
	public void readType(LibraryType t){
		types.add(t);
	}
	
	/**
	 * Adds the patron to arraylist of patrons
	 *
	 * @param	p	patron being added to arraylist of patrons
	 */
	public void readPatron(Patron p){
		patrons.add(p);
	}
	
	/**
	 * Adds the item to arraylist of items
	 *
	 * @param	i	item being added to arraylist of items
	 */
	public void readItem(Item i){
		items.add(i);
	}
	
	/**
	 * Adds the checkout record to the arraylist of checkout records
	 *
	 * @param	i	checkout record being added to arraylist of records
	 */
	public void readItemOut(ItemOut i){
		itemsOut.add(i);
		findItem(i.getItemNumber()).checkOut(i.getDateDue());
	}
	
	/**
	 * Adds the item type to arraylist of item types
	 *
	 * @param	c	item type unique code
	 * @param	d	item type descriptiojn
	 */
	public void addNewType(String c, String d){
		types.add(new LibraryType(c, d));
	}
	
	/**
	 * Adds the patron to arraylist of patrons with the next new patron number
	 *
	 * @param	fn	patron first name
	 * @param	ln	patron last name
	 * @param	ea	patron email address
	 * @param	pn	patron phone number
	 * @param	sa	patron street address
	 * @param	c	patron city
	 * @param	s	patron state
	 * @param	z	patron zip code
	 */
	public void addNewPatron(String fn, String ln, String ea, String pn, String sa, String c, String s, String z){
		patrons.add(new Patron(getNextPatronNumber()+"", fn, ln, ea, pn, sa, c, s, z));
	}
	
	/**
	 * Adds the item to arraylist of items with the next new item number
	 *
	 * @param	t	item type code
	 * @param	ti	item title 
	 * @param	a	item author
	 * @param	d	item published date
	 */
	public void addNewItem( String t, String ti, String a, String d) throws Exception{
		Date da= DateUtil.parseShortDate(d);
		LibraryType ty = getType(t);
		if(da == null){
			throw new Exception("Please enter a date in the MM/YYYY format.");
		}
		
		if(ty == null){
			throw new Exception("Please enter a valid type name into the type field.");
		}
		
		items.add(new Item(getNextItemNumber()+"", getType(t), ti, a, d));
	}
	
	/**
	 * Adds the checkout record to the arraylist of checkout records
	 *
	 * @param	in	checkout record item number
	 * @param	pn	checkout record patron number
	 * @param	dco	checkout record checked out date string
	 * @param	dd	checkout record due date string
	 */
	public void addNewItemOut( String in, String pn, String dco, String dd){
		itemsOut.add(new ItemOut(in,pn, dco, dd));
	}
	
	/**
	 * Adds the item type to arraylist of item types
	 *
	 * @param   t   item type to replace
	 * @param	c	item type new unique code
	 * @param	d	item type new description
	 */
	public void setNewType(LibraryType t,String c, String d){
		types.set(types.indexOf(t),new LibraryType(c, d));
	}
	
	/**
	 * Adds the patron to arraylist of patrons
	 *
	 * @param	fn	patron first name
	 * @param	ln	patron last name
	 * @param	ea	patron email address
	 * @param	pn	patron phone number
	 * @param	sa	patron street address
	 * @param	c	patron city
	 * @param	s	patron state
	 * @param	z	patron zip code
	 */
	public void setNewPatron(Patron p, String fn, String ln, String ea, String pn, String sa, String c, String s, String z){
		patrons.set(patrons.indexOf(p),new Patron(p.getPatronNumber()+"", fn, ln, ea, pn, sa, c, s, z));
	}
	
	/**
	 * Adds the item to arraylist of items
	 *
	 * @param	t	item type code
	 * @param	ti	item title 
	 * @param	a	item author
	 * @param	d	item published date
	 */
	public void setNewItem(Item i, String t, String ti, String a, String d) throws Exception {
		Date da= DateUtil.parseShortDate(d);
		LibraryType ty = getType(t);
		if(da == null){
			throw new Exception("Please enter a date in the MM/YYYY format.");
		}
		
		if(ty == null){
			throw new Exception("Please enter a valid type name into the type field.");
		}
		items.set(items.indexOf(i),new Item((i.getItemNumber())+"",  getType(t), ti, a, d));
	}
	


	
	/**
	 * Adds the checkout record to the arraylist of checkout records
	 *
	 * @param	in	checkout record item number
	 * @param	pn	checkout record patron number
	 * @param	dco	checkout record checked out date
	 * @param	dd	checkout record due date
	 */
	public void addNewItemOut( String in, String pn, Date dco, Date dd){
		itemsOut.add(new ItemOut(in,pn, dco, dd));
	}
	
	/**
	 * Returns the library Type for the given typeID
	 *
	 * @param	typeID	the library type code
	 * @return	the type object for the library type
	 */
	public LibraryType getType(String typeID){
		LibraryType result = null;
		for(int i = 0; i<types.size();i++){
			if(types.get(i).getCode().equals(typeID)){
				result = types.get(i);
			}
		}
		return result;
	}

	/**
	 * Returns item with given item number
	 *
	 * @param	number	item number
	 * @return item with given item number
	 */
	public Item findItem(int number){
		for(Item i:items){
			if(number == i.getItemNumber()){
				return i;
			}
		}
		return null;
	}

	/**
	 * Returns patron with given patron number
	 *
	 * @param	number	patron number
	 * @return item at the position index
	 */
	public Patron findPatron(int number){
		for(Patron p:patrons){
			if(number == p.getPatronNumber()){
				return p;
			}
		}
		return null;
	}
	

	
	/**
	 * Bump up the value of the highest patron number if necessary
	 *
	 * @param	patronNumber	the new patron number
	 */
	public void bumpPatronNumber(int patronNumber) {
		if (patronNumber > patronNumberHigh)
			patronNumberHigh = patronNumber;
		return;
	}

	/**
	 * Returns the incremented patron number and resets
	 * the highest patron number
	 *
	 * @return	the new highest patron number
	 */
	public int getNextPatronNumber() {
		/* increase the highest patron number */
		patronNumberHigh++;
		/* return the new highest patron number */
		return patronNumberHigh;
	}

	/**
	 * Bump up the value of the highest item number if necessary
	 *
	 * @param	itemNumber	the new item number
	 */
	public void bumpItemNumber(int itemNumber) {
		if (itemNumber > itemNumberHigh)
			itemNumberHigh = itemNumber;
		return;
	}

	/**
	 * Returns the incremented item number and resets
	 * the highest item number
	 *
	 * @return	the new highest item number
	 */
	public int getNextItemNumber() {
		/* increase the highest item number */
		itemNumberHigh++;
		/* return the new highest item number */
		return itemNumberHigh;
	}

	/**
	 * Returns a String comtaining the output in report format for all
	 * items sorted by title
	 *
	 * @return the String of the report output
	 */
	public String getItemsByTitle(){
		StringBuilder result = new StringBuilder("Item Report; Sorted by Title\n----------------------------------------------------------------------------\n");
		ArrayList<Item> items = getItemsCopy();
		Collections.sort(items, Item.ItemTitleComparator);
		for(Item temp2: items){
			result.append( String.format("%-3s", temp2.getItemNumber()));
			result.append( String.format("%-6s", " "+temp2.getType().toString()));
			if ( temp2.getTitle().length() > 34 )
				result.append( String.format("%-50s", " Title: " + temp2.getTitle().substring(0, 34) ) );
			else
				result.append( String.format("%-50s", " Title: " + temp2.getTitle() ) );
			result.append("\n");
		}
		return result.toString();
	}
	
	/**
	 * Returns a String comtaining the output in report format for all
	 * items sorted by type
	 *
	 * @return the String of the report output
	 */
	public String getItemsByType(){
		StringBuilder result = new StringBuilder("Item Report; Sorted by Type\n----------------------------------------------------------------------------\n");
		ArrayList<Item> items = getItemsCopy();
		Collections.sort(items, Item.ItemTypeComparator);
		for(Item temp2: items){
			result.append( String.format("%-3s", temp2.getItemNumber()));
			result.append( String.format("%-6s", " "+temp2.getType().toString()));
			if ( temp2.getTitle().length() > 34 )
				result.append( String.format("%-50s", " Title: " + temp2.getTitle().substring(0, 34) ) );
			else
				result.append( String.format("%-50s", " Title: " + temp2.getTitle() ) );
			result.append("\n");
		}
		return result.toString();
	}
	
	/**
	 * Returns a String comtaining the output in report format for all
	 * checked out items sorted by type
	 *
	 * @return the String of the report output
	 */
	public String getItemsOutByType(){
		StringBuilder result = new StringBuilder("Items Out Report; Sorted by Type\n----------------------------------------------------------------------------\n");
		ArrayList<ItemOut> itemsOut = getItemsOutCopy();
		Collections.sort(itemsOut, ItemOut.ItemOutTypeComparator);
		for(ItemOut temp: itemsOut){

			Item currentItem = findItem(temp.getItemNumber());
			Patron currentPatron = findPatron(temp.getPatronNumber());
			if (currentItem != null) {
				result.append( String.format("%-5s", currentItem.getType().toString()));
				if ( currentItem.getTitle().length() > 34 )
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+" Title: " + currentItem.getTitle().substring(0, 34) ) );
				else
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+" Title: " + currentItem.getTitle() ) );
			} else {
				result.append( String.format("%-50s", "-" ));
			}
			if (currentPatron != null) {
				result.append(String.format("%-30s", "Patron: " + 
					temp.getPatronNumber() + " " +
					currentPatron.getLastName() + " " +
					currentPatron.getFirstName() ));
			}
			result.append(" Due: " + DateUtil.printDate(temp.getDateDue())+"\n");

		}

		return result.toString();
	}
	
	/**
	 * Returns a String comtaining the output in report format for all
	 * checked out items sorted by patron
	 *
	 * @return the String of the report output
	 */
	public String getItemsOutByPatron(){
		StringBuilder result = new StringBuilder("Items Out Report; Sorted by Patron\n----------------------------------------------------------------------------\n");
		boolean doPageBreak = false;
		ArrayList<ItemOut> itemsOut = getItemsOutCopy();
		Collections.sort(itemsOut, ItemOut.ItemOutPatronComparator);
		int lastPatronNumber = 0;
		for(ItemOut temp: itemsOut){
			Item currentItem = findItem(temp.getItemNumber());
			Patron currentPatron = findPatron(temp.getPatronNumber());

			if (lastPatronNumber != temp.getPatronNumber())	{
				if (lastPatronNumber != 0) {
					doPageBreak = true;
				}
				lastPatronNumber = temp.getPatronNumber();
			}
			if (doPageBreak) {
				result.append(PagedTextArea.PAGE_BREAK);
				doPageBreak = false;
			}

			if (currentItem != null) {
				if ( currentItem.getTitle().length() > 34 )
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+"Title: " + currentItem.getTitle().substring(0, 34) ) );
				else
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+"Title: " + currentItem.getTitle() ) );
			} else {
				result.append( String.format("%-50s", "-" ));
			}
			if (currentPatron != null) {
				result.append(String.format("%-30s", " Patron: " + 
					temp.getPatronNumber() + " " +
					currentPatron.getLastName() + " " +
					currentPatron.getFirstName() ) );
			}
			result.append(" Due: " + DateUtil.printDate(temp.getDateDue()) + "\n");
		}
		return result.toString();
	}
	
	/**
	 * Returns a String comtaining the output in report format for all
	 * checked out items sorted by due date
	 *
	 * @return the String of the report output
	 */
	public String getItemsOutByDateDue(){
		StringBuilder result = new StringBuilder("Items Out Report; Sorted by Date\n----------------------------------------------------------------------------\n");
		ArrayList<ItemOut> itemsOut = getItemsOutCopy();
		Collections.sort(itemsOut, ItemOut.ItemOutDueDateComparator);
		Date lastDueDate = null;
		Calendar cal1;
	        Calendar cal2;
	        boolean doPageBreak=true;
		doPageBreak = false;
		for(ItemOut temp: itemsOut){
			Item currentItem = findItem(temp.getItemNumber());
			Patron currentPatron = findPatron(temp.getPatronNumber());
				if (lastDueDate != temp.getDateDue())	{
					if (lastDueDate != null) {
						cal1 = Calendar.getInstance();
						cal2 = Calendar.getInstance();
						cal1.setTime(lastDueDate);
						cal2.setTime(temp.getDateDue());
						if(!cal1.equals(cal2)){
							doPageBreak = true;
						}
					}
				}
			lastDueDate = temp.getDateDue();

			if (doPageBreak) {
				result.append(PagedTextArea.PAGE_BREAK);
				doPageBreak = false;
			}

			if (currentItem != null) {
				if ( currentItem.getTitle().length() > 34 )
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+"Title: " + currentItem.getTitle().substring(0, 34) ) );
				else
					result.append( String.format("%-50s", "ID: "+currentItem.getItemNumber()+" "+"Title: " + currentItem.getTitle() ) );
			} else {
				result.append( String.format("%-50s", "-" ));
			}
			if (currentPatron != null) {
				result.append(String.format("%-30s", " Patron: " + 
					temp.getPatronNumber() + " " +
					currentPatron.getLastName() + " " +
					currentPatron.getFirstName() ) );
			}
			result.append(" Due: " + DateUtil.printDate(temp.getDateDue()) + "\n");
		}
		
		
		
		
		

		return result.toString();
	}
	/**
	 * Returns an ArrayList of all the Patrons, sorted by Last Name
	 *
	 * @return the ArrayList of sorted Patrons
	 */
	public ArrayList<Patron> getPatronsByName(){
		ArrayList<Patron> patrons = getPatronsCopy();
		Collections.sort(patrons, Patron.PatronNameComparator);
		return patrons;
		}
}
