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
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * GUI class to popup a dialog so Patrons can be searched for.
 * @author Jasper
 * @version 0.1
 */
@SuppressWarnings("serial")
public class LookupFrame extends javax.swing.JFrame {

    /**
     * Creates new form LookupFrame
     */
	ArrayList<Patron> patrons;
	MainGui parent;
	/**
	 * constructor of the LookupFrame that takes the components that the LookupFrame is linked to.
	 *
	 * @param theLibrary the libraryDatabase that this lookup screen is linked to
	 * @param pa The MainGui that this lookup screen is linked to
	 */
    public LookupFrame(LibraryDatabase theLibrary, MainGui pa) {
    	patrons = theLibrary.getPatrons();
    	parent = pa;
        initComponents();
        setTitle("Patron Lookup");
        setLocation(800,0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
    	//initializing components
        leftSideSplitPane = new javax.swing.JSplitPane();
        topSplitPane = new javax.swing.JSplitPane();
        patronLookupSearch = new javax.swing.JTextField();
        listScroll = new javax.swing.JScrollPane();
        patronLookupList = new javax.swing.JList();
        lookupPanel = new javax.swing.JPanel();
        idNumberTitle = new javax.swing.JLabel();
        firstNameTitle = new javax.swing.JLabel();
        lastNameTitle = new javax.swing.JLabel();
        emailAddressTitle = new javax.swing.JLabel();
        phoneNumberTitle = new javax.swing.JLabel();
        streetAddressTitle = new javax.swing.JLabel();
        cityTitle = new javax.swing.JLabel();
        stateTitle = new javax.swing.JLabel();
        zipCodeTitle = new javax.swing.JLabel();
        setAsPatronButton = new javax.swing.JButton();
        zipCodeLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        streetAddressLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        emailAddressLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        idNumberLabel = new javax.swing.JLabel();
        
        //sets close window behavior
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        class WindowEventHandler extends WindowAdapter {
        	  public void windowClosing(WindowEvent evt) {
        			parent.lookupIsClosed();
        	  }
        }
        addWindowListener(new WindowEventHandler());
        
        //set divider location for JSplitPane
        leftSideSplitPane.setDividerLocation(150);
        topSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        patronLookupSearch.setText("Patron Search");
        patronLookupSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        topSplitPane.setTopComponent(patronLookupSearch);
        //initializes jList1
        patronLookupList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        patronLookupList.removeAll();
        patronLookupList.setListData( LibraryDatabase.getInstance().getPatronsByName().toArray());
        
        //adds mouse listener
        
        patronLookupSearch.addMouseListener(new MouseListener(){
  		   public void mouseClicked(MouseEvent e){
  		        		
  		   }
  		   public void	mouseEntered(MouseEvent e) {
  			   
  		   }
  		   public void	mouseExited(MouseEvent e) {
  			   
  		   }
  		   public void	mousePressed(MouseEvent e) {
  			   
  		   }
  		   public void	mouseReleased(MouseEvent e){
  			   if(patronLookupSearch.getText().equals("Patron Search")){
  				   patronLookupSearch.setText("");

  			   }
  		   }
          	
          });
         patronLookupSearch.setText("Patron Search");
         patronLookupSearch.addKeyListener(new KeyAdapter() {
             public void keyReleased(KeyEvent e) {
            	 
             	if(patronLookupSearch!=null){
             		ArrayList<Patron> data2= getMatchingPatrons(patronLookupSearch.getText());
                 	patronLookupList.removeAll();
                 	patronLookupList.setListData(data2.toArray());
                 }
             } 
             public void keyTyped(KeyEvent e) {
             }

             public void keyPressed(KeyEvent e) {
            	 if(patronLookupSearch.getText().equals("Patron Search")){
  				   patronLookupSearch.setText("");
  			   }
             }
           });
         
         patronLookupSearch.addFocusListener(new FocusListener(){
     		   public void focusGained(FocusEvent f){
     			   
     		   }
     		   public void focusLost(FocusEvent f){
     			   if(patronLookupSearch.getText().equals("")){
	  				   patronLookupSearch.setText("Patron Search");
	  			   }
     		   }
             	
             });
         
         //setting JComponent display names
        listScroll.setViewportView(patronLookupList);
        topSplitPane.setRightComponent(listScroll);
        leftSideSplitPane.setLeftComponent(topSplitPane);
        idNumberTitle.setText("ID Number:");
        firstNameTitle.setText("First Name:");
        lastNameTitle.setText("Last Name:");
        emailAddressTitle.setText("Email Address:");
        phoneNumberTitle.setText("Phone Number");
        streetAddressTitle.setText("Street Address:");
        cityTitle.setText("City:");
        stateTitle.setText("State:");
        zipCodeTitle.setText("Zipcode:");
        setAsPatronButton.setText("Set As Active Patron");
        
        //Listeners for PatronList
        patronLookupList.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
            	
            	Patron itemSelected = (Patron)patronLookupList.getSelectedValue();
 			   changePane(itemSelected);
            }
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
          });
        
        patronLookupList.addMouseListener(new MouseListener(){
 		   public void mouseClicked(MouseEvent e){
 		        		
 		   }
 		   public void	mouseEntered(MouseEvent e) {
 			   
 		   }
 		   public void	mouseExited(MouseEvent e) {
 			   
 		   }
 		   public void	mousePressed(MouseEvent e) {
 			   
 		   }
 		   public void	mouseReleased(MouseEvent e){
 			  Patron itemSelected = (Patron)patronLookupList.getSelectedValue();
			   changePane(itemSelected);
 		   }
         	
         });
        setAsPatronButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(!idNumberLabel.getText().equals("")){
        			parent.setPatronId(Integer.parseInt(idNumberLabel.getText()));
        			dispose();
        			parent.lookupIsClosed();
        		}	
        	}
        });




        //Components are added and Layouts are established
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(lookupPanel);
        lookupPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddressTitle)
                            .addComponent(lastNameTitle)
                            .addComponent(firstNameTitle)
                            .addComponent(phoneNumberTitle)
                            .addComponent(stateTitle)
                            .addComponent(cityTitle)
                            .addComponent(streetAddressTitle)
                            .addComponent(zipCodeTitle)
                            .addComponent(idNumberTitle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddressLabel)
                            .addComponent(lastNameLabel)
                            .addComponent(firstNameLabel)
                            .addComponent(phoneNumberLabel)
                            .addComponent(stateLabel)
                            .addComponent(cityLabel)
                            .addComponent(streetAddressLabel)
                            .addComponent(zipCodeLabel)
                            .addComponent(idNumberLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(setAsPatronButton)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idNumberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(firstNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lastNameTitle)
                        .addGap(18, 18, 18)
                        .addComponent(emailAddressTitle)
                        .addGap(18, 18, 18)
                        .addComponent(phoneNumberTitle)
                        .addGap(18, 18, 18)
                        .addComponent(streetAddressTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cityTitle)
                        .addGap(18, 18, 18)
                        .addComponent(stateTitle)
                        .addGap(18, 18, 18)
                        .addComponent(zipCodeTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lastNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(emailAddressLabel)
                        .addGap(18, 18, 18)
                        .addComponent(phoneNumberLabel)
                        .addGap(18, 18, 18)
                        .addComponent(streetAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cityLabel)
                        .addGap(18, 18, 18)
                        .addComponent(stateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(zipCodeLabel)))
                .addGap(18, 18, 18)
                .addComponent(setAsPatronButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        leftSideSplitPane.setRightComponent(lookupPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftSideSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftSideSplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Uses a given Patron to generate the information on the right side of the pane
     *  @param	p	the patron given to change the information
     */
    private void changePane(Patron p){
    	 idNumberLabel.setText(p.getPatronNumber()+"");
         
         emailAddressLabel.setText(p.getEmailAddress());

         lastNameLabel.setText(p.getLastName());

         firstNameLabel.setText(p.getFirstName());

         phoneNumberLabel.setText(p.getPhoneNumber());

         cityLabel.setText(p.getCity());

         streetAddressLabel.setText(p.getStreetAddress());

         zipCodeLabel.setText(p.getZipcode());
         
         stateLabel.setText(p.getState());
    }

    /**
     * Gets Patrons from the LibraryDatabase who match the given String
     *  @param	s	String used as regex when searching
     *  @return the Arraylist of Patrons that match
     */
    private ArrayList<Patron> getMatchingPatrons(String s){
    	if(s.equals("Patron Search")){
    		s = "";
    	}
    	ArrayList<Patron> output = new ArrayList<Patron>();
    	for(Patron p:patrons){
    		if((" "+p.getFirstName().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1||(" "+p.getLastName().toLowerCase()).indexOf(" "+s.toLowerCase())!=-1){
    			output.add(p);
    		}
    	}
    	return output;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel cityTitle;
    private javax.swing.JLabel emailAddressLabel;
    private javax.swing.JLabel emailAddressTitle;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel firstNameTitle;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JLabel idNumberTitle;
    private javax.swing.JList patronLookupList;
    private javax.swing.JPanel lookupPanel;
    private javax.swing.JScrollPane listScroll;
    private javax.swing.JSplitPane leftSideSplitPane;
    private javax.swing.JSplitPane topSplitPane;
    private javax.swing.JTextField patronLookupSearch;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel lastNameTitle;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel phoneNumberTitle;
    private javax.swing.JButton setAsPatronButton;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel stateTitle;
    private javax.swing.JLabel streetAddressLabel;
    private javax.swing.JLabel streetAddressTitle;
    private javax.swing.JLabel zipCodeLabel;
    private javax.swing.JLabel zipCodeTitle;
    // End of variables declaration//GEN-END:variables
}
