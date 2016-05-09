import javax.swing.JOptionPane;

/**
 *  Main driver for the library application
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */

public class Main {
	/**
	 * Start off the application by initializing the library data from
	 * the library data CSV files and bring up the user GUI to
	 * 
	 */
	public static void main(String args[]){
		FileIO io = new FileIO();
		LibraryDatabase library= LibraryDatabase.getInstance();
		try{
			//reading in items
			io.readTypes(library);
			io.readItems(library);
			io.readPatrons(library);
			io.readItemsOut(library);
			//creation of GUI
			new MainGui(library).setVisible(true);
				
				
				
		}catch(Exception e){
			//error handling
			System.out.println(e);
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
    			    "Please put valid data into the \"data\" folder found into the same directory of the LibraryCheckout.jar",
    			    "Invalid Data Read Error",
    			    JOptionPane.ERROR_MESSAGE);
		}

	}
}

