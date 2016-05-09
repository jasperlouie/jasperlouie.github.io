
import java.util.Comparator;

/**
 *  This class contains the methods that act on the types of items in 
 *  the library (ie. books, magazine, etc.)
 *
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class LibraryType implements Comparable<LibraryType> {
	/** The unique code for the type of item (abbreviation) */ 
	private String code;

	/** The description of the type */ 
	private String description;
	
	/**
	 * Constructs a library item type
	 *
	 * @param	c	the code for the item type
	 * @param	d	the descriptions for the item type
	 */
	public LibraryType(String c, String d){
		code = c;
		description = d;
	}

	/* getters and setters */
	/**
	 * returns the Code of the LibraryType
	 *
	 * @return String code that tells the code of the type
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * sets the Code of the LibraryType
	 *
	 * @param code	 String of the code for the Type
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * returns the Description of the LibraryType
	 *
	 * @return String Description that tells the code of the type
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * sets the Description of the LibraryType
	 *
	 * @param description	 String of the Description for the Type
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

	/**
	 * Return a string of the code and description for output
	 *
	 * @return the string of the code and description
	 */
	public String toString(){
		//return (""+code +", ["+description+"]");
		return (code);
	}
	

	/**
	 * Return a stringArray of the code and description for this type
	 *
	 * @return a stringarray of the code and description for this item type
	 */
	public String[] toStringArray(){
		String[] result = new String[2];
		result[0]=getCode();
		result[1]= getDescription();
		return result;
	}

	/**
	 * Return the difference between the type codes
	 *
	 * @return the difference between the type codes
	 */
	public int compareTo(LibraryType compareIType) {
		String compareITypeCode = ((LibraryType) compareIType).getCode().toUpperCase();

		//ascending order
		return this.code.toUpperCase().compareTo(compareITypeCode);
	}

 
	/**
	 * Comparator for comparing the type code (library item's type
	 * abbreviation)
	 *
	 */
	public static Comparator<LibraryType> ITypeCodeComparator 
                          = new Comparator<LibraryType>() {
 
	    public int compare(LibraryType iType1, LibraryType iType2) {
 
	      String iTypeCode1 = iType1.getCode().toUpperCase();
	      String iTypeCode2 = iType2.getCode().toUpperCase();
 
	      //ascending order
	      return iTypeCode1.compareTo(iTypeCode2);
 
	      //descending order
	      //return iTypeCode2.compareTo(iTypeCode1);
	    }
 
	};

}
