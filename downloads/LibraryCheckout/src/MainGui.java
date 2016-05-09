import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Creates the main UI components along with their mouse and key listeners and puts them into a layout.
 * @author Jasper
 * @version 0.1
 */
@SuppressWarnings("serial")
public class MainGui extends javax.swing.JFrame {
	//field initialization
	LibraryDatabase theLibrary;
	Item[] items;
	Patron[] patrons;
	LibraryType[] types;
	int editListState;
	boolean lookupIsOpen;

    /**
     * Creates new form MainGui
     */
	public MainGui() {
        initComponents();
    }
	/**
     * Creates New MainGui using a LibraryDatabase to populate its lists
     */
    public MainGui(LibraryDatabase l) {
    	theLibrary = l;
        items = theLibrary.getItems().toArray(new Item[theLibrary.getItems().size()]);
        patrons = theLibrary.getPatrons().toArray(new Patron[theLibrary.getPatrons().size()]);
        types = theLibrary.getTypes().toArray(new LibraryType[theLibrary.getTypes().size()]);
    	initComponents();
    	setTitle("Library Checkout");
    	editListState=0;
    	setSize(920,600);
    	setMinimumSize(new Dimension(600,400));
    	
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
    	//sets Java.Swing look and feel into new Nimbus Look and Feel if it is found in the Program Files
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	//All Variables are declared
    	tabbedPane = new javax.swing.JTabbedPane();
        checkoutPane = new javax.swing.JSplitPane();
        leftSplitPane = new javax.swing.JSplitPane();
        checkoutScrollPane = new javax.swing.JScrollPane();
        checkoutList = new javax.swing.JList();
        checkoutSearchSplitPane = new javax.swing.JSplitPane();
        itemSearch = new javax.swing.JTextField();
        patronSplit = new javax.swing.JSplitPane();
        patronSearch = new javax.swing.JTextField();
        ImageIcon lookupIcon = new ImageIcon("data/images/search_icon.png");
        ImageIcon addnewIcon = new ImageIcon("data/images/addnew.png");
        ImageIcon checkmarkIcon = new ImageIcon("data/images/checkmark.png");
        ImageIcon editIcon = new ImageIcon("data/images/edit.png");
        ImageIcon helpIcon = new ImageIcon("data/images/help.png");
        ImageIcon reportIcon = new ImageIcon("data/images/report.png");
        lookupButton = new javax.swing.JButton(lookupIcon);
        checkoutInfoPane = new javax.swing.JPanel();
        checkoutButton = new javax.swing.JButton();
        itemIDTitle = new javax.swing.JLabel();
        titleTitle = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        authorTitle = new javax.swing.JLabel();
        datePubTitle = new javax.swing.JLabel();
        typeTitle = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        datePubLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        statusTitle = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        checkInButton = new javax.swing.JButton();
        editSplitPane = new javax.swing.JSplitPane();
        editLeftSplitPane = new javax.swing.JSplitPane();
        typeSelectionBox = new javax.swing.JComboBox();
        editSearchSplitPane = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        editList = new javax.swing.JList();
        addNewButton = new javax.swing.JButton(addnewIcon);
        editSearch = new javax.swing.JTextField();
        getReportsPane = new javax.swing.JPanel();
        outByPatronButton = new javax.swing.JButton();
        outByDueDateButton = new javax.swing.JButton();
        itemsByTypeButton = new javax.swing.JButton();
        itemsByTitleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportTextArea = new PagedTextArea();
        ImageIcon printIcon = new ImageIcon("data/images/print.png");
        printAllButton = new javax.swing.JButton("Print All",printIcon);
        printPageButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        outByTypeButton = new javax.swing.JButton();
        helpPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        helpTextArea = new PagedTextArea();
        
        //sets window behavior to dispose after close
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        //Creates window listener that writes out data upon closing
        class WindowEventHandler extends WindowAdapter {
        	  public void windowClosing(WindowEvent evt) {
        		  FileIO io = new FileIO();
        		  if(lookupFrame!=null){
        			  lookupFrame.dispose();
        		  }
        		  
        			LibraryDatabase library= LibraryDatabase.getInstance();
        			try{
        				io.writeTypes(library);
        				io.writeItems(library);
        				io.writePatrons(library);
        				io.writeItemsOut(library);
        					
        					
        					
        			}catch(Exception e){
        				System.out.println(e);
        			}
        	  }
        }
        addWindowListener(new WindowEventHandler());

        //changes SplitPane Attributes
        checkoutPane.setDividerLocation(350);
        editSplitPane.setDividerLocation(350);
        leftSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        
        //initializes the checkoutList to contain the items
        checkoutList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return items.length; }
            public Object getElementAt(int i) { return items[i]; }
        });
        checkoutScrollPane.setViewportView(checkoutList);
        checkoutList.removeAll();
        
        
        
       
        //Prepares components of the Checkout Tab
        leftSplitPane.setRightComponent(checkoutScrollPane);
        checkoutSearchSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        patronSearch.setText("Patron Id");
        checkoutSearchSplitPane.setTopComponent(patronSearch);
        checkoutSearchSplitPane.setRightComponent(itemSearch);
        
        //KeyListener for the Edit Tab Search Bar
        editSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	
            	if(editSearch!=null){
            		ArrayList<Object> data2= getEditList(editSearch.getText());
                	editList.removeAll();
                	editList.setListData(data2.toArray());
                }
            } 
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
          });
        
        //KeyListener for the Checkout Tab Search Bar 
        checkoutList.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	
            	Item itemSelected = (Item)checkoutList.getSelectedValue();
 			   changeCheckoutPane(itemSelected);
            }
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
          });
        
        //Mouse Listener for the item Search Bar
        itemSearch.addMouseListener(new MouseListener(){
 		   public void mouseClicked(MouseEvent e){
 		        		
 		   }
 		   public void	mouseEntered(MouseEvent e) {
 			   
 		   }
 		   public void	mouseExited(MouseEvent e) {
 			   
 		   }
 		   public void	mousePressed(MouseEvent e) {
 			   
 		   }
 		   public void	mouseReleased(MouseEvent e){
 			   if(itemSearch.getText().equals("Item Search")){
 				   itemSearch.setText("");
 			   }
 		   }
         	
         });
        itemSearch.setText("Item Search");
        itemSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	
            	if(itemSearch!=null){
            		ArrayList<Item> data2= getMatchingItems(itemSearch.getText());
                	checkoutList.removeAll();
                	checkoutList.setListData( data2.toArray());
                }
            } 
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
          });
        
        itemSearch.addFocusListener(new FocusListener(){
    		   public void focusGained(FocusEvent f){
    			   
    		   }
    		   public void focusLost(FocusEvent f){
    			if(itemSearch.getText().equals("")){
 				   itemSearch.setText("Item Search");
 			   }
    		   }
            	
            });
        //Listeners for Patron Search
        patronSearch.addMouseListener(new MouseListener(){
  		   public void mouseClicked(MouseEvent e){
  		        		
  		   }
  		   public void	mouseEntered(MouseEvent e) {
  			   
  		   }
  		   public void	mouseExited(MouseEvent e) {
  			   
  		   }
  		   public void	mousePressed(MouseEvent e) {
  			   
  		   }
  		   public void	mouseReleased(MouseEvent e){
  			   if(patronSearch.getText().equals("Patron Id")){
  				   patronSearch.setText("");
  			   }
  		   }
          	
          });
        
        patronSearch.addFocusListener(new FocusListener(){
   		   public void focusGained(FocusEvent f){
   			   
   		   }
   		   public void focusLost(FocusEvent f){
   			if(patronSearch.getText().equals("")){
				   patronSearch.setText("Patron Id");
			   }
   		   }
           	
           });
      //Listeners for the search bar on the edit tab
        editSearch.addMouseListener(new MouseListener(){
  		   public void mouseClicked(MouseEvent e){
  		        		
  		   }
  		   public void	mouseEntered(MouseEvent e) {
  			   
  		   }
  		   public void	mouseExited(MouseEvent e) {
  			   
  		   }
  		   public void	mousePressed(MouseEvent e) {
  			   
  		   }
  		   public void	mouseReleased(MouseEvent e){
  			   if(editSearch.getText().equals("Search")){
  				   editSearch.setText("");
  			   }
  		   }
          	
          });
        
        editSearch.addFocusListener(new FocusListener(){
    		   public void focusGained(FocusEvent f){
    			   
    		   }
    		   public void focusLost(FocusEvent f){
    			if(editSearch.getText().equals("")){
 				   editSearch.setText("Search");
 			   }
    		   }
            	
            });
      //Listeners for the list on the checkout page
        checkoutList.addMouseListener(new MouseListener(){
		   public void mouseClicked(MouseEvent e){
		        		
		   }
		   public void	mouseEntered(MouseEvent e) {
			   
		   }
		   public void	mouseExited(MouseEvent e) {
			   
		   }
		   public void	mousePressed(MouseEvent e) {
			   
		   }
		   public void	mouseReleased(MouseEvent e){
			   Item itemSelected = (Item)checkoutList.getSelectedValue();
			   changeCheckoutPane(itemSelected);
		   }
        	
        });
        
        //Listeners for the List on the left side of the edit tab
        editList.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	
            	Object objectSelected = (Object)editList.getSelectedValue();
 			   changeEditPane(objectSelected);
            }
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
          });
        
        editList.addMouseListener(new MouseListener(){
		   public void mouseClicked(MouseEvent e){
		        		
		   }
		   public void	mouseEntered(MouseEvent e) {
			   
		   }
		   public void	mouseExited(MouseEvent e) {
			   
		   }
		   public void	mousePressed(MouseEvent e) {
			   
		   }
		   public void	mouseReleased(MouseEvent e){
			   Object objectSelected = (Object)editList.getSelectedValue();
 			   changeEditPane(objectSelected);
		   }
        	
        });
        
        //Actions taken by the "Checkout" button
        checkoutButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//Error Checking for checkout
        		Item itemSelected = (Item)checkoutList.getSelectedValue();
        		String patronId = patronSearch.getText();
        		try{
        			if(itemSelected==null){
        				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                			    "Please select an item before attempting to check out.",
                			    "No Item Selected Error",
                			    JOptionPane.ERROR_MESSAGE);
            		}else if(theLibrary.findItem(itemSelected.getItemNumber()).isCheckedOut()){
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "This item is already checked out.\nPlease check in item before checking out.",
            			    "Checkout Error",
            			    JOptionPane.ERROR_MESSAGE);
	        		}else{
	        			if(theLibrary.findPatron(Integer.parseInt(patronId))!=null){
	    	        		theLibrary.findItem(itemSelected.getItemNumber()).checkOut();
	    	        		theLibrary.addNewItemOut(itemSelected.getItemNumber()+"", patronId, DateUtil.today(), DateUtil.getDateTwoWeeksLater());
	    	        		changeCheckoutPane(itemSelected);
	    	        		reportTextArea.setText("");
	            		}else{
	            		JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
	            			    "Please enter a valid Patron ID Number into the box in the upper left.",
	            			    "Invalid Patron ID",
	            			    JOptionPane.ERROR_MESSAGE);
	            		}
	        		}
	        	}catch(Exception err){
	        				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
	                			    "Please enter a valid Patron ID Number into the box in the upper left.",
	                			    "Invalid Patron ID",
	                			    JOptionPane.ERROR_MESSAGE);
	        		}
        		}
        			
        		
        });
        //"Check In" Button Listener
        checkInButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//Error checking for checking in
        		Item itemSelected = (Item)checkoutList.getSelectedValue();
        		if(itemSelected!=null&&itemSelected.isCheckedOut()){
        			itemSelected.returnItem();
            		theLibrary.deleteItemOut(itemSelected);
            		changeCheckoutPane(itemSelected);
            		reportTextArea.setText("");
        		}else if(itemSelected!=null){
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please checkout item before checking it in.",
            			    "Check In Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}else{
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please select an item before attempting to check in.",
            			    "No Item Selected Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}
        		
        		
        	}
        });
        
        //component initialization
        leftSplitPane.setTopComponent(checkoutSearchSplitPane);
        checkoutPane.setLeftComponent(leftSplitPane);
        patronSplit.setDividerLocation(73);
        patronSearch.setText("Patron Id");
        patronSplit.setTopComponent(patronSearch);
        lookupButton.setText("Lookup");
        patronSplit.setRightComponent(lookupButton);
        checkoutSearchSplitPane.setTopComponent(patronSplit);
        leftSplitPane.setTopComponent(checkoutSearchSplitPane);
        checkoutPane.setLeftComponent(leftSplitPane);
        checkoutButton.setText("Checkout");
        checkoutButton.setIcon(checkoutIcon);
        itemIDTitle.setText("Item ID:");
        titleTitle.setText("Title:");
        idLabel.setText("ID");
        authorTitle.setText("Author:");
        datePubTitle.setText("Date Published:");
        typeTitle.setText("Type:");
        titleLabel.setText("title");
        authorLabel.setText("auth");
        datePubLabel.setText("pubdate");
        typeLabel.setText("tyname");
        statusTitle.setText("Status");
        statusLabel.setText("status");
        checkInButton.setText("Check In");
        checkInButton.setIcon(checkinIcon);
        clearCheckoutPane();
        
      //Components are added and Layouts are established
        javax.swing.GroupLayout checkoutInfoPaneLayout = new javax.swing.GroupLayout(checkoutInfoPane);
        checkoutInfoPane.setLayout(checkoutInfoPaneLayout);
        checkoutInfoPaneLayout.setHorizontalGroup(
            checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                        .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                        .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datePubTitle)
                            .addComponent(authorTitle)
                            .addComponent(typeTitle)
                            .addComponent(titleTitle)
                            .addComponent(itemIDTitle)
                            .addComponent(statusTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleLabel)
                            .addComponent(authorLabel)
                            .addComponent(datePubLabel)
                            .addComponent(typeLabel)
                            .addComponent(statusLabel))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        checkoutInfoPaneLayout.setVerticalGroup(
            checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                        .addComponent(itemIDTitle)
                        .addGap(18, 18, 18)
                        .addComponent(titleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(authorTitle)
                        .addGap(18, 18, 18)
                        .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePubTitle)
                            .addComponent(datePubLabel))
                        .addGap(18, 18, 18)
                        .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeTitle)
                            .addComponent(typeLabel)))
                    .addGroup(checkoutInfoPaneLayout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(18, 18, 18)
                        .addComponent(titleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(authorLabel)))
                .addGap(18, 18, 18)
                .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusTitle)
                    .addComponent(statusLabel))
                .addGap(18, 18, 18)
                .addGroup(checkoutInfoPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutButton)
                    .addComponent(checkInButton))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        checkoutPane.setRightComponent(checkoutInfoPane);
        tabbedPane.addTab("Checkout", checkmarkIcon, checkoutPane);
        editLeftSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        typeSelectionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        typeSelectionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeSelectionBoxActionPerformed(evt);
            }
        });
        //initialization of type selection box on the edit screen
        editLeftSplitPane.setTopComponent(typeSelectionBox);
        typeSelectionBox.removeAllItems();
        typeSelectionBox.addItem("Items");
        typeSelectionBox.addItem("Patrons");
        typeSelectionBox.addItem("Types");
        
        /*initialization of the split pane that contains the search bar
         *on the edit screen
         */
        editSearchSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        editSearch.setText("Search");
        editSearchSplitPane.setTopComponent(editSearch);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        editList.setModel(new javax.swing.AbstractListModel() {
        	public int getSize() { return items.length; }
            public Object getElementAt(int i) { return items[i]; }
        });
        
        //more component initialization
        jScrollPane3.setViewportView(editList);
        editSearchSplitPane.setRightComponent(jScrollPane3);
        editLeftSplitPane.setRightComponent(editSearchSplitPane);
        editSplitPane.setLeftComponent(editLeftSplitPane);
        tabbedPane.addTab("Edit", editIcon, editSplitPane);
        jScrollPane4.setViewportView(editList);
        jSplitPane1.setRightComponent(jScrollPane4);
        addNewButton.setText("Add New");
        jSplitPane1.setLeftComponent(addNewButton);
        editSearchSplitPane.setRightComponent(jSplitPane1);
        editSearch.setText("Search");
        editSearchSplitPane.setLeftComponent(editSearch);
        editLeftSplitPane.setRightComponent(editSearchSplitPane);
        editSplitPane.setLeftComponent(editLeftSplitPane);
        outByPatronButton.setText("Items Checked Out By Patron");
        outByDueDateButton.setText("Items Checked Out By Due Date");
        itemsByTypeButton.setText("Item Report By Type");
        itemsByTitleButton.setText("Item Report By Title");
        reportTextArea.setColumns(20);
        Font font = new Font("Courier", Font.PLAIN, 12);
        reportTextArea.setFont(font);
        reportTextArea.setRows(5);
        reportTextArea.setEditable(false);
        jScrollPane1.setViewportView(reportTextArea);
        printAllButton.setText("Print All");
        printPageButton.setText("Print Page");
        previousButton.setText("Previous");
        printPageButton.setVisible(false);
        previousButton.setVisible(false);
        nextButton.setVisible(false);
        nextButton.setText("Next");
        outByTypeButton.setText("Items Checked Out By Type");
        
        //more layout implementation
        javax.swing.GroupLayout getReportsPaneLayout = new javax.swing.GroupLayout(getReportsPane);
        getReportsPane.setLayout(getReportsPaneLayout);
        getReportsPaneLayout.setHorizontalGroup(
            getReportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getReportsPaneLayout.createSequentialGroup()
                .addGroup(getReportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(getReportsPaneLayout.createSequentialGroup()
                        .addGap(0, 275, Short.MAX_VALUE)
                        .addComponent(printAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(getReportsPaneLayout.createSequentialGroup()
                        .addGroup(getReportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outByTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemsByTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outByDueDateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(itemsByTitleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(outByPatronButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        getReportsPaneLayout.setVerticalGroup(
            getReportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(getReportsPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemsByTitleButton)
                .addGap(18, 18, 18)
                .addComponent(itemsByTypeButton)
                .addGap(18, 18, 18)
                .addComponent(outByDueDateButton)
                .addGap(18, 18, 18)
                .addComponent(outByTypeButton)
                .addGap(18, 18, 18)
                .addComponent(outByPatronButton)
                .addContainerGap())
            .addGroup(getReportsPaneLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(getReportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(printPageButton)
                    .addComponent(printAllButton))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        //initialializtion of "Get Reports" tab
        tabbedPane.addTab("Get Reports", reportIcon, getReportsPane);
        
        //Listeners for the "Items By Title" button 
        itemsByTitleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String result = theLibrary.getItemsByTitle();
                reportTextArea.setText(result);
                jScrollPane1.getVerticalScrollBar().setValue(0);
                reportTextArea.setCaretPosition(0);
            }
        });
        
      //Listeners for the "Lookup" button
        lookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(!lookupIsOpen){
            		openLookup();
            	}
            	
                
            }
        });
      //Listeners for the "Add New" button
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	setNewPanel();
            	editSplitPane.setDividerLocation(350);
            }
        });
        
        
      //Listeners for the "Print All" button
        printAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 PrinterJob job = PrinterJob.getPrinterJob();
                 job.setPrintable(reportTextArea);
                 PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

                 boolean ok = job.printDialog(pras);
                 if (ok) {
                     System.out.println("Printing...");
                     try {
                         job.print();
                     } catch (PrinterException ex) {
                         System.out.println("The job did not successfully complete");
                     }
                 } else {
                     System.out.println("Could not print");
                 }
            }
        });
        
       
      //Listeners for the "Items By Type" button
        itemsByTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String result = theLibrary.getItemsByType();
                reportTextArea.setText(result);
                jScrollPane1.getVerticalScrollBar().setValue(0);
                reportTextArea.setCaretPosition(0);
            }
        });
        
      //Listeners for the "Items Out by Type" button
        outByTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String result = theLibrary.getItemsOutByType();
                reportTextArea.setText(result);
                jScrollPane1.getVerticalScrollBar().setValue(0);
                reportTextArea.setCaretPosition(0);
            }
        });
        
      //Listeners for the "Items Out By Patron" button
        outByPatronButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String result = theLibrary.getItemsOutByPatron();
                reportTextArea.setText(result);
                jScrollPane1.getVerticalScrollBar().setValue(0);
                reportTextArea.setCaretPosition(0);
            }
        });
        
      //Listeners for the "Items Out By Due Date" button
        outByDueDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String result = theLibrary.getItemsOutByDateDue();
                reportTextArea.setText(result);
                jScrollPane1.getVerticalScrollBar().setValue(0);
                reportTextArea.setCaretPosition(0);
            }
        });
        
        //Initializes text area that displays the help message
        helpTextArea.setColumns(20);
        helpTextArea.setRows(5);
        jScrollPane2.setViewportView(helpTextArea);
        helpTextArea.setEditable(false);
        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Help", helpIcon, helpPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        FileIO io = new FileIO();
        try{
        	helpTextArea.setText(io.readHelpFile());
        }catch(Exception e){
        	
        }
        pack();
        
    }// </editor-fold>//GEN-END:initComponents
    
    //Edit tab selection box
	private void typeSelectionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeSelectionBoxActionPerformed
        if(typeSelectionBox!=null){
            if(typeSelectionBox.getSelectedItem()!=null){

                if(typeSelectionBox.getSelectedItem().equals("Items")){
                    editSplitPane.setRightComponent(new ItemPanel(this));
                    editSplitPane.setDividerLocation(350);
                    editListState = 0;
                    ArrayList<Object> data2= getEditList(editSearch.getText());
                	editList.removeAll();
                	editList.setListData(data2.toArray());
                }else if(typeSelectionBox.getSelectedItem().equals("Patrons")){
                    editSplitPane.setRightComponent(new PatronPanel(this));
                    editSplitPane.setDividerLocation(350);
                    editListState = 1;
                    ArrayList<Object> data2= getEditList(editSearch.getText());
                	editList.removeAll();
                	editList.setListData(data2.toArray());
                }else if(typeSelectionBox.getSelectedItem().equals("Types")){
                    editSplitPane.setRightComponent(new TypePanel(this));
                    editSplitPane.setDividerLocation(350);
                    editListState = 2;
                    ArrayList<Object> data2= getEditList(editSearch.getText());
                	editList.removeAll();
                	editList.setListData(data2.toArray());
            
                }
            }
        }
    }//GEN-LAST:event_typeSelectionBoxActionPerformed
    /**
     * Gets Items in the LibraryDatabase that match the given String
     *  @param	s	String used as regex when searching
     *  @return the ArrayList of Items that match
     */
    private ArrayList<Item> getMatchingItems(String s){
    	if(s.equals("Item Search")){
    		s = "";
    	}
    	ArrayList<Item> output = new ArrayList<Item>();
    	for(Item i:items){
    		if((" "+i.getTitle().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1){
    			output.add(i);
    		}
    	}
    	return output;
    }
    
    /**
     * Gets Objects in the LibraryDatabase that match the given String
     *  @param	s	String used as regex when searching
     *  @return the ArrayList of Objects that match
     */
    private ArrayList<Object> getEditList(String s){
    	if(s.equals("Search")){
    		s = "";
    	}
    	/*
    	 * if editListState = 0 then "Items" is selected in the edit tab
    	 * if editListState = 1 then "Patrons" is selected in the edit tab
    	 * if editListState = 2 then "Types" is selected in the edit tab
    	 */
    	ArrayList<Object> output = new ArrayList<Object>();
    	if(editListState==0){	
        	for(Item i:items){
        		if((" "+i.getTitle().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1){
        			output.add(i);
        		}
        	}
    	}else if(editListState==1){	
        	for(Patron p:patrons){
        		if((" "+p.getFirstName().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1||(" "+p.getLastName().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1){
        			output.add(p);
        		}
        	}
    	}else if(editListState==2){	
        	for(LibraryType t:types){
        		if((" "+t.getCode().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1){
        			output.add(t);
        		}
        	}
    	}
        	
    	
    	return output;
    }
    
    /**
     * Updates the CheckoutPanel with the information of the Item passed in
     *  @param	i	Item to be checked out
     */
    private void changeCheckoutPane(Item i){
    	idLabel.setText(i.getItemNumber()+"");
    	titleLabel.setText(i.getTitle());
    	authorLabel.setText(i.getAuthor());
    	datePubLabel.setText(DateUtil.printShortDate(i.getPubDate()));
    	typeLabel.setText(i.getType().toString());
    	if(!i.isCheckedOut()){
    		statusLabel.setText("Checked In");
    	}else{
    		statusLabel.setText("Checked Out");
    	}
    }
    
    /**
     * Clears all the information in the CheckoutPane
     */
    private void clearCheckoutPane(){
    	idLabel.setText("");
    	titleLabel.setText("");
    	authorLabel.setText("");
    	datePubLabel.setText("");
    	typeLabel.setText("");
    	statusLabel.setText("");
    }
    
    /**
     * changes the right pane in the edit tab to be filled with the given object's information
     *  @param	o	Object with which the panel's information is filled
     */
    private void changeEditPane(Object o){
    	if(o!=null){
    		if(editListState==0){
        		Item i = (Item)o;
        		editSplitPane.setRightComponent(new ItemPanel(i,this));
        		editSplitPane.setDividerLocation(350);
        	}else if(editListState==1){
        		Patron p = (Patron)o;
        		editSplitPane.setRightComponent(new PatronPanel(p,this));
        		editSplitPane.setDividerLocation(350);
        	}else{
        		LibraryType t = (LibraryType)o;
        		editSplitPane.setRightComponent(new TypePanel(t,this));
        		editSplitPane.setDividerLocation(350);
        	}
    	}else{
    		if(editListState==0){
        		editSplitPane.setRightComponent(new ItemPanel(this));
        		editSplitPane.setDividerLocation(350);
        	}else if(editListState==1){
        		editSplitPane.setRightComponent(new PatronPanel(this));
        		editSplitPane.setDividerLocation(350);
        	}else{
        		editSplitPane.setRightComponent(new TypePanel(this));
        		editSplitPane.setDividerLocation(350);
        	}
    	}
    	
    }
    
    /**
     * Refreshes the lists on the left side of the screen and updates the gui with the new Items added
     *  @param	isNewItem	A boolean saying whether the item added was a new Item
     */
	public void refreshLists(boolean isNewItem){
    	int index = editList.getSelectedIndex();
    	items = theLibrary.getItems().toArray(new Item[theLibrary.getItems().size()]);
        patrons = theLibrary.getPatrons().toArray(new Patron[theLibrary.getPatrons().size()]);
        types = theLibrary.getTypes().toArray(new LibraryType[theLibrary.getTypes().size()]);
        ArrayList<Object> data2= getEditList(editSearch.getText());
    	editList.removeAll();
    	editList.setListData(data2.toArray());
    	checkoutList.setListData( getMatchingItems("").toArray());
    	reportTextArea.setText("");
    	if(!isNewItem&&index<data2.size()){
    		editList.setSelectedIndex(index);
    	}else{
    		editList.setSelectedIndex(data2.size()-1);
    	}
    	changeEditPane(editList.getSelectedValue());
    	
    }
    
    /**
     * Sets active user using their Patron ID
     *  @param	i	the int ID of the Patron who is the current user
     */
    public void setPatronId(int i){
    	patronSearch.setText(i+"");
    }
    
    /**
     * Opens the Patron Lookup Window
     */
    private void openLookup(){
    	lookupFrame = new LookupFrame(theLibrary,this);
    	lookupFrame.setVisible(true);
    	lookupIsOpen=true;
    }
    
    /**
     * Sets the right Edit tab Panel into an "Add New Item" window
     */
    public void setNewPanel(){
    	if(editListState==0){
    		editSplitPane.setRightComponent(new ItemPanel(this));
    	}else if(editListState==1){
    		editSplitPane.setRightComponent(new PatronPanel(this));
    	}else{
    		editSplitPane.setRightComponent(new TypePanel(this));
    	}
    }
    
    /**
     * sets the boolean saying that there is no lookup window currently open
     */
    public void lookupIsClosed(){
    	lookupIsOpen=false;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel authorTitle;
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JPanel checkoutInfoPane;
    private javax.swing.JList checkoutList;
    private javax.swing.JSplitPane checkoutPane;
    private javax.swing.JScrollPane checkoutScrollPane;
    private javax.swing.JSplitPane checkoutSearchSplitPane;
    private javax.swing.JLabel datePubLabel;
    private javax.swing.JLabel datePubTitle;
    private javax.swing.JSplitPane editLeftSplitPane;
    private javax.swing.JList editList;
    private javax.swing.JTextField editSearch;
    private javax.swing.JSplitPane editSearchSplitPane;
    private javax.swing.JSplitPane editSplitPane;
    private javax.swing.JPanel getReportsPane;
    private javax.swing.JPanel helpPanel;
    private PagedTextArea helpTextArea;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel itemIDTitle;
    private javax.swing.JTextField itemSearch;
    private javax.swing.JButton itemsByTitleButton;
    private javax.swing.JButton itemsByTypeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane leftSplitPane;
    private javax.swing.JButton lookupButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton outByDueDateButton;
    private javax.swing.JButton outByPatronButton;
    private javax.swing.JButton outByTypeButton;
    private javax.swing.JTextField patronSearch;
    private javax.swing.JSplitPane patronSplit;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton printAllButton;
    private javax.swing.JButton printPageButton;
    private PagedTextArea reportTextArea;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusTitle;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleTitle;
    private javax.swing.JLabel typeLabel;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox typeSelectionBox;
    private javax.swing.JLabel typeTitle;
    private LookupFrame lookupFrame;
    private ImageIcon checkinIcon = new ImageIcon("data/images/checkin.png");
    private ImageIcon checkoutIcon = new ImageIcon("data/images/checkout.png");
    // End of variables declaration//GEN-END:variables
}
