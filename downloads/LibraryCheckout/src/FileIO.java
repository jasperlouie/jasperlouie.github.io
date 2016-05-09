
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

/**
 *  This class contains the methods to process the data files for the library
 *  system.
 *  <pre>
 *  There are four types of data files - they are in subdirectory "data"
 *      TYPES - Types.txt - contains the different item types
 *      PATRONS - Patrons.txt - contains the information for library borrowers
 *      ITEMS - Items.txt - contains the records for all library items
 *      ITEMS_OUT - ItemsOut.txt - contains the records for checked out items
 *  </pre>    
 *
 *  @author	Jasper Louie
 *  @version	0.1
 * 
 */
public class FileIO {
	/*
	 * Data file names
	 */
	private final String TYPE_FILE="data/Types.txt";
	private final String PATRON_FILE="data/Patrons.txt";
	private final String ITEM_FILE = "data/Items.txt";
	private final String ITEMSOUT_FILE = "data/ItemsOut.txt";

	/*
	 * Backup data file names
	 */
	private final String TYPE_BAK_FILE="data/Types.bak";
	private final String PATRON_BAK_FILE="data/Patrons.bak";
	private final String ITEM_BAK_FILE = "data/Items.bak";
	private final String ITEMSOUT_BAK_FILE = "data/ItemsOut.bak";

	/*
	 * Help file text
	 */
	private final String HELP_FILE = "data/Help.txt";
	

	/**
	 * Reads in the media types for the library items from the CSV file 
	 * and adds them to the library database.
	 *
	 * @param theLibrary	the library database
	 */
	public void readTypes(LibraryDatabase theLibrary) throws IOException {

		CSVReader reader = new CSVReader(new FileReader(TYPE_FILE));
		String[] nextLine;
		
		//converts lines of text into "Types"
		while ((nextLine = reader.readNext()) != null) {
			LibraryType typeRec = new LibraryType(nextLine[0], nextLine[1]);
			theLibrary.readType(typeRec);
		}
		
	}
	
	/**
	 * Reads in the patrons for the library items from the CSV file 
	 * and adds them to the library database.
	 *
	 * @param theLibrary  the library database
	 */
	public void readPatrons(LibraryDatabase theLibrary) throws IOException {
			CSVReader reader = new CSVReader(new FileReader(PATRON_FILE));
			String[] nextLine;
			int patronNumber;
			//converts lines of text into "Patrons"
			while ((nextLine = reader.readNext()) != null) {
				Patron patronRec = new Patron(nextLine[0], nextLine[1],nextLine[2], nextLine[3],nextLine[4], nextLine[5],nextLine[6], nextLine[7],nextLine[8]);
				patronNumber = Integer.parseInt(nextLine[0]);
				/* increase the highest patron number if necessary */
				theLibrary.bumpPatronNumber(patronNumber);
				theLibrary.readPatron(patronRec);
			}
		
		
	}
	
	/**
	 * Reads in the library items and adds them
	 * to the library database.
	 *
	 * @param 	theLibrary	the library database
	 */
	public void readItems(LibraryDatabase theLibrary) throws IOException {

		CSVReader reader = new CSVReader(new FileReader(ITEM_FILE));
		String[] nextLine;
		int itemNumber;
		//converts lines of text into "Items"
		while ((nextLine = reader.readNext()) != null) {
			Item itemRec = new Item(nextLine[0], theLibrary.getType(nextLine[1]),nextLine[2], nextLine[3],nextLine[4]);
			if(itemRec.getPubDate()==null||itemRec.getType()==null){
				throw new IOException();
			}
			itemNumber = Integer.parseInt(nextLine[0]);
			/* increase the highest item number if necessary */
			theLibrary.bumpItemNumber(itemNumber);
			theLibrary.readItem(itemRec);
		}
		
	}
	
	/**
	 * Reads in the checked out library items from the CSV file 
	 * and adds them to the library database.
	 *
	 * @param	theLibrary	the library database
	 */
	public void readItemsOut(LibraryDatabase theLibrary) throws IOException {

		CSVReader reader = new CSVReader(new FileReader(ITEMSOUT_FILE));
		String[] nextLine; 

		while ((nextLine = reader.readNext()) != null) {
			ItemOut itemOutRec = new ItemOut(nextLine[0], nextLine[1],nextLine[2], nextLine[3]);
			if(itemOutRec.getDateCheckedOut()==null||itemOutRec.getDateDue()==null){
				throw new IOException();
			}
			theLibrary.readItemOut(itemOutRec);
		}
		
	}
	
	/**
	 * Copy from src file to target file
	 *
	 * @param	srcFilename	source file name
	 * @param	targetFilename	target file name
	 * @throws Exception
	 */
	public void copyFile(String srcFilename, String targetFilename)  throws Exception{
		try {
			File srcFile = new File(srcFilename);
			File targetFile = new File(targetFilename);
			InputStream in = new FileInputStream(srcFile);
			OutputStream out = new FileOutputStream(targetFile);
			
			//uses input stream to read old file into new file
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
		catch (Exception e) {
		}
		return;
	}

	/**
	 * Write the library items in the library database out to the CSV file
	 * ITEM_FILE after copying the original contents to ITEM_BAK_FILE
	 *
	 * @param	theLibrary	the library database
	 * @throws Exception
	 */
	public void writeItems(LibraryDatabase theLibrary) throws Exception{
		/* backup old item data file */
		copyFile(ITEM_FILE, ITEM_BAK_FILE);

		CSVWriter writer = new CSVWriter(new FileWriter(ITEM_FILE));

		//Converts "items" into string arrays and reads them into the CSV reader
		Item[] items = theLibrary.getItems().toArray(new Item[theLibrary.getItems().size()]);
		for(int i = 0;i<items.length;i++){
			writer.writeNext(items[i].toStringArray());
		}
		writer.close();
	}
	
	/**
	 * Write the patrons in the library database out to the CSV file
	 * PATRON_FILE after copying the original contents to PATRON_BAK_FILE
	 *
	 * @param theLibrary	is the library database
	 * @throws Exception
	 */
	public void writePatrons(LibraryDatabase theLibrary) throws Exception{
		/* backup old patron data file */
		copyFile(PATRON_FILE, PATRON_BAK_FILE);
		
		//Converts "Patrons" into string arrays and reads them into the CSV reader
		CSVWriter writer = new CSVWriter(new FileWriter(PATRON_FILE));
		Patron[] patrons = theLibrary.getPatrons().toArray(new Patron[theLibrary.getPatrons().size()]);
		for(int i = 0;i<patrons.length;i++){
			writer.writeNext(patrons[i].toStringArray());
		}
		writer.close();
	}
	
	/**
	 * Write the media types in the library database out to the CSV file
	 * TYPE_FILE after copying the original contents to TYPE_BAK_FILE
	 *
	 * @param	theLibrary	the library database
	 * @throws Exception
	 */
	public void writeTypes(LibraryDatabase theLibrary) throws Exception{
		/* backup old types data file */
		copyFile(TYPE_FILE, TYPE_BAK_FILE);

		CSVWriter writer = new CSVWriter(new FileWriter(TYPE_FILE));
		LibraryType[] types = theLibrary.getTypes().toArray(new LibraryType[theLibrary.getTypes().size()]);
		for(int i = 0;i<types.length;i++){
			writer.writeNext(types[i].toStringArray());
		}
		writer.close();
	}
	
	/**
	 * Write the check out items in the library database out to the CSV file
	 * ITEMSOUT_FILE
	 *
	 * @param	theLibrary	the library database
	 * @throws Exception
	 */
	public void writeItemsOut(LibraryDatabase theLibrary) throws Exception{
		/* backup old checkout items data file */
		copyFile(ITEMSOUT_FILE, ITEMSOUT_BAK_FILE);

		CSVWriter writer = new CSVWriter(new FileWriter(ITEMSOUT_FILE));
		ItemOut[] itemsOut = theLibrary.getItemsOut().toArray(new ItemOut[theLibrary.getItemsOut().size()]);
		for(int i = 0;i<itemsOut.length;i++){
			writer.writeNext(itemsOut[i].toStringArray());
		}
		writer.close();
	}

	/**
	 * Reads the help information from a file.
	 * @return the string for the text content of the help file
	 * @throws IOException
	 */
	public String readHelpFile() throws IOException{
		FileReader reader = new FileReader(HELP_FILE);
		BufferedReader br = new BufferedReader(reader);
		String result="";
		String s;
		while((s = br.readLine()) != null) {
		result+=s+"\n";
		}
		reader.close();
	return result;
	}
}
