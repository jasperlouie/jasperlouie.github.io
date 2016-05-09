
import java.util.Comparator;

/**
 *  Contains the methods for a patron/borrower for the library.
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class Patron implements Comparable<Patron>{
	/** unique number for each patron */
	private int patronNumber;

	/** patron's first name */
	private String firstName;

	/** patron's last name */
	private String lastName;

	/** patron's email address */
	private String emailAddress;

	/** patron's phone number */
	private String phoneNumber;

	/** patron's street address */
	private String streetAddress;

	/** patron's city */
	private String city;

	/** patron's state */
	private String state;

	/** patron's zip code */
	private String zipcode;
	
	/**
	 * Construct a patron object with the patron information
	 *
	 * @param	idNumber	patron id number
	 * @param	fn	first name
	 * @param	ln	last name
	 * @param	ea	email address
	 * @param	pn	phone number
	 * @param	sa	street address
	 * @param	c	city
	 * @param	s	state
	 * @param	z	zip code
	 */
	public Patron (String idNumber, String fn, String ln, String ea, String pn, String sa, String c, String s, String z){
		patronNumber = Integer.parseInt(idNumber);
		firstName = fn;
		lastName = ln;
		emailAddress = ea;
		phoneNumber = pn;
		streetAddress = sa;
		city = c;
		state = s;
		zipcode = z;
	}


	/**
	 * returns the user's ID Number
	 *
	 * @return a String containing the user's ID Number
	 */
	public int getPatronNumber() {
		return patronNumber;
	}

	/**
	 * sets Patron ID number to given int
	 *
	 * @param	patronNumber	Patron id
	 */
	public void setPatronNumber(int patronNumber) {
		this.patronNumber = patronNumber;
	}

	/**
	 * returns the user's First Name
	 *
	 * @return a String containing the user's First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets Patron's First Name to the given String
	 *
	 * @param	firstName	Patron's First Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * returns the user's Last Name
	 *
	 * @return a String containing the user's Last Name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets Patron's Last Name to the given String
	 *
	 * @param	lastName	Patron's Last Name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * returns the user's Email Address
	 *
	 * @return a String containing the user's Email Address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * sets Patron's Email Address to the given String
	 *
	 * @param	emailAddress	The Patron's Email Address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * returns the user's Phone Number
	 *
	 * @return a String containing the user's Phone Number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * sets Patron's Phone Number number to the given String
	 *
	 * @param	phoneNumber	Patron's Phone Number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * returns the user's Street Address
	 *
	 * @return a String containing the user's Street Address
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * sets streetAddress to the given String
	 *
	 * @param	streetAddress	a String containing the user's street address
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * returns the user's City name
	 *
	 * @return a String containing the user's City name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * sets Patron's city to the given String
	 *
	 * @param	city	Name of the Patron's city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * returns the user's Zip State
	 *
	 * @return a String containing the user's State
	 */
	public String getState() {
		return state;
	}

	/**
	 * sets Patron's state to the given String
	 *
	 * @param	state	String containing the Patrons State
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * returns the user's Zip Code
	 *
	 * @return a String containing the user's Zip Code
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * sets Patron ID number to given int
	 *
	 * @param	zipcode	Patron id
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * returns a String containing the last name, then first of the Patron, separated by a comma.
	 *
	 * @return a String containing "lastname, firstname"
	 */
	public String toString(){
		return (lastName+", "+firstName);
	}
	
	/**
	 * A string array of descriptive strings for this patron's information
	 *
	 * @return String array of descriptive strings for this patron's info
	 */
	public String[] toStringArray(){
		String[] result = new String[9];
		result[0]=""+patronNumber;
		result[1]=firstName;
		result[2]=lastName;
		result[3]=emailAddress;
		result[4]=phoneNumber;
		result[5]=streetAddress;
		result[6]=city;
		result[7]=state;
		result[8]=zipcode;
		return result;
	}
	
	
	/**
	 * Compare by patron last name, first name, and then patron number
	 * @return difference in patron numbers
	 */
	public int compareTo(Patron comparePatron) {
	      String patronName1 = this.getLastName() + 
					this.getFirstName() + 
					this.getPatronNumber();
	      String patronName2 = comparePatron.getLastName() + 
					comparePatron.getFirstName() + 
					comparePatron.getPatronNumber();
 

	      //ascending order
	      return patronName1.compareTo(patronName2);

	}

	/**
	 * Comparator to sort by patron name - sort by last name, first name,
	 * and then patron number
	 */
	public static Comparator<Patron> PatronNameComparator 
                          = new Comparator<Patron>() {
 
	    public int compare(Patron patron1, Patron patron2) {
 
	      String patronName1 = patron1.getLastName() + 
					patron1.getFirstName() + 
					patron1.getPatronNumber();
	      String patronName2 = patron2.getLastName() + 
					patron2.getFirstName() + 
					patron2.getPatronNumber();
 

	      //ascending order
	      return patronName1.compareTo(patronName2);
 
	      //descending order
	      //return patronName2.compareTo(patronName1);
	    }
 
	};


	/**
	 * Comparator to sort by patron number
	 */
	public static Comparator<Patron> PatronNumberComparator 
                          = new Comparator<Patron>() {
 
	    public int compare(Patron patron1, Patron patron2) {
		int patronNumber1 = patron1.getPatronNumber();
		int patronNumber2 = patron2.getPatronNumber();
 
	      //ascending order
	      return patronNumber1 - patronNumber2;
 
	      //descending order
	      // return patronNumber2 - patronNumber1;
	    }
 
	};


}
