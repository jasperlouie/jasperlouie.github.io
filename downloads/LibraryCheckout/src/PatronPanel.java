import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Creates the UI components for editing and adding a Patron.
 * @author Jasper
 * @version 0.1
 */
@SuppressWarnings("serial")
public class PatronPanel extends javax.swing.JPanel {
	MainGui parent;
	Patron patron;

    /**
     * Creates new form Patron Panel
     */
    public PatronPanel() {
        initComponents();
    }
    /**
	 * Creates new form Patron Panel used to edit an existing Patron
	 *
	 * @param   p	Patron used to construct the Panel
	 * @param	pa	the MainGui that this panel is going into
	 */
    public PatronPanel(Patron p, final MainGui pa) {
        initComponents1();
        parent=pa;
        patron = p;
        savePatronButton.setIcon(saveIcon);
        deletePatronButton.setIcon(deleteIcon);
        
        idNumberLabel.setText(p.getPatronNumber()+"");
        
        emailAddressField.setText(p.getEmailAddress());

        lastNameField.setText(p.getLastName());

        firstNameField.setText(p.getFirstName());

        phoneNumberField.setText(p.getPhoneNumber());

        cityField.setText(p.getCity());

        streetAddressField.setText(p.getStreetAddress());

        zipCodeField.setText(p.getZipcode());
        
        stateField.setText(p.getState());
        
        savePatronButton.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e){
    		if(firstNameField.getText().equals("")||lastNameField.getText().equals("")||emailAddressField.getText().equals("")||phoneNumberField.getText().equals("")||
    				streetAddressField.getText().equals("")||cityField.getText().equals("")||stateField.getText().equals("")||zipCodeField.getText().equals("")){
    			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
        			    "Please do not leave any of the fields blank.",
        			    "Blank Field Error",
        			    JOptionPane.ERROR_MESSAGE);
    		}else{
    			if(!DateUtil.containsNumber(phoneNumberField.getText())){
    				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please enter a valid phone number into the \"Phone Number\" field.",
            			    "Invalid Phone Number Error",
            			    JOptionPane.ERROR_MESSAGE);	
    			}else{
    				if(!DateUtil.containsNumber(zipCodeField.getText())){
    					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                			    "Please enter a valid zip code into the \"Zip Code\" field.",
                			    "Invalid Zip Code Error",
                			    JOptionPane.ERROR_MESSAGE);	
						
					}else{
						LibraryDatabase.getInstance().setNewPatron(patron,firstNameField.getText(),lastNameField.getText(),emailAddressField.getText(),phoneNumberField.getText(),
	            				streetAddressField.getText(),cityField.getText(),stateField.getText(), zipCodeField.getText());
	            		pa.refreshLists(false);
						
					}
    				
    			}
    			
    		}
    		
    	}
    });
        
        deletePatronButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	LibraryDatabase.getInstance().deletePatron(patron);
            	parent.refreshLists(false);
            }
        });
    }
    /**
     * Creates new form Patron Panel for adding Patrons
     *  @param	pa	the MainGui that this panel is going into
     */
    public PatronPanel(final MainGui pa) {
        initComponents();
        parent=pa;

        
        idNumberLabel.setText("To Be Assigned");
        savePatronButton.setText("Add Patron");
        savePatronButton.setIcon(addIcon);
        deletePatronButton.setIcon(deleteIcon);
        
        
        savePatronButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(firstNameField.getText().equals("")||lastNameField.getText().equals("")||emailAddressField.getText().equals("")||phoneNumberField.getText().equals("")||
        				streetAddressField.getText().equals("")||cityField.getText().equals("")||stateField.getText().equals("")||zipCodeField.getText().equals("")){
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please do not leave any of the fields blank.",
            			    "Blank Field Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}else{
        			if(!DateUtil.containsNumber(phoneNumberField.getText())){
        				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                			    "Please enter a valid phone number into the \"Phone Number\" field.",
                			    "Invalid Phone Number Error",
                			    JOptionPane.ERROR_MESSAGE);	
        			}else{
        				if(!DateUtil.containsNumber(zipCodeField.getText())){
        					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                    			    "Please enter a valid zip code into the \"Zip Code\" field.",
                    			    "Invalid Zip Code Error",
                    			    JOptionPane.ERROR_MESSAGE);	
    						
    					}else{
    						LibraryDatabase.getInstance().addNewPatron(firstNameField.getText(),lastNameField.getText(),emailAddressField.getText(),phoneNumberField.getText(),
                    				streetAddressField.getText(),cityField.getText(),stateField.getText(), zipCodeField.getText());
                    		pa.refreshLists(true);
    						
    					}
        				
        			}
        			
        		}
        		
        	}
        });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form for adding a Patron.
     * 
     */
    
    private void initComponents() {
    	//look and feel being applied
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
    	
    	//components being initialized
    	PatronPanel = new javax.swing.JPanel();
        savePatronButton = new javax.swing.JButton();
        firstNameTitle = new javax.swing.JLabel();
        lastNameTitle = new javax.swing.JLabel();
        emailAddressTitle = new javax.swing.JLabel();
        phoneNumberTitle = new javax.swing.JLabel();
        emailAddressField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        streetAddressField = new javax.swing.JTextField();
        zipCodeField = new javax.swing.JTextField();
        stateField = new javax.swing.JTextField();
        cityTitle = new javax.swing.JLabel();
        streetAddressTitle = new javax.swing.JLabel();
        zipCodeTitle = new javax.swing.JLabel();
        stateTitle = new javax.swing.JLabel();
        idNumberTitle = new javax.swing.JLabel();
        idNumberLabel = new javax.swing.JLabel();
        deletePatronButton = new javax.swing.JButton();
        
        //text names of files being initialized
        firstNameTitle.setText("First Name:");
        lastNameTitle.setText("Last Name:");
        emailAddressTitle.setText("Email Address:");
        phoneNumberTitle.setText("Phone Number");
        emailAddressField.setText("ea");
        lastNameField.setText("ln");
        firstNameField.setText("fn");
        phoneNumberField.setText("pn");
        cityField.setText("c");
        streetAddressField.setText("sa");
        zipCodeField.setText("zc");
        stateField.setText("state");
        cityTitle.setText("City:");
        streetAddressTitle.setText("Street Address:");
        zipCodeTitle.setText("Zipcode:");
        stateTitle.setText("State:");
        idNumberTitle.setText("ID Number:");
        idNumberLabel.setText("");
        savePatronButton.setText("Save Patron");
        emailAddressField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        phoneNumberField.setText("");
        cityField.setText("");
        streetAddressField.setText("");
        zipCodeField.setText("");
        stateField.setText("");
        cityTitle.setText("City:");
      //Components are added and Layouts are established
        javax.swing.GroupLayout PatronPanelLayout = new javax.swing.GroupLayout(PatronPanel);
        PatronPanel.setLayout(PatronPanelLayout);
        PatronPanelLayout.setHorizontalGroup(
            PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailAddressTitle)
                    .addComponent(lastNameTitle)
                    .addComponent(firstNameTitle)
                    .addComponent(phoneNumberTitle)
                    .addComponent(stateTitle)
                    .addComponent(cityTitle)
                    .addComponent(streetAddressTitle)
                    .addComponent(zipCodeTitle)
                    .addComponent(idNumberTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField)
                    .addComponent(lastNameField)
                    .addComponent(emailAddressField)
                    .addComponent(streetAddressField)
                    .addComponent(cityField)
                    .addComponent(stateField)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(phoneNumberField)
                    .addGroup(PatronPanelLayout.createSequentialGroup()
                        .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idNumberLabel)
                            .addComponent(savePatronButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PatronPanelLayout.setVerticalGroup(
            PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTitle)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddressTitle)
                    .addComponent(emailAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTitle)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetAddressTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityTitle)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateTitle)
                    .addComponent(stateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeTitle)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(savePatronButton)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PatronPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PatronPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form with settings for editing a Patron.
     * 
     */
    private void initComponents1() {
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
    	
    	//components being initialized
    	PatronPanel = new javax.swing.JPanel();
        savePatronButton = new javax.swing.JButton();
        firstNameTitle = new javax.swing.JLabel();
        lastNameTitle = new javax.swing.JLabel();
        emailAddressTitle = new javax.swing.JLabel();
        phoneNumberTitle = new javax.swing.JLabel();
        emailAddressField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        streetAddressField = new javax.swing.JTextField();
        zipCodeField = new javax.swing.JTextField();
        stateField = new javax.swing.JTextField();
        cityTitle = new javax.swing.JLabel();
        streetAddressTitle = new javax.swing.JLabel();
        zipCodeTitle = new javax.swing.JLabel();
        stateTitle = new javax.swing.JLabel();
        idNumberTitle = new javax.swing.JLabel();
        idNumberLabel = new javax.swing.JLabel();
        deletePatronButton = new javax.swing.JButton();
        firstNameTitle.setText("First Name:");
        lastNameTitle.setText("Last Name:");
        emailAddressTitle.setText("Email Address:");
        phoneNumberTitle.setText("Phone Number");
        emailAddressField.setText("ea");
        lastNameField.setText("ln");
        firstNameField.setText("fn");
        phoneNumberField.setText("pn");
        cityField.setText("c");
        streetAddressField.setText("sa");
        zipCodeField.setText("zc");
        stateField.setText("state");
        cityTitle.setText("City:");
        streetAddressTitle.setText("Street Address:");
        zipCodeTitle.setText("Zipcode:");
        stateTitle.setText("State:");
        idNumberTitle.setText("ID Number:");
        idNumberLabel.setText("");
        savePatronButton.setText("Save Patron");
        emailAddressField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        phoneNumberField.setText("");
        cityField.setText("");
        streetAddressField.setText("");
        zipCodeField.setText("");
        stateField.setText("");
        cityTitle.setText("City:");
        deletePatronButton.setText("Delete Patron");
        
        //panel layout being configured
        javax.swing.GroupLayout PatronPanelLayout = new javax.swing.GroupLayout(PatronPanel);
        PatronPanel.setLayout(PatronPanelLayout);
        PatronPanelLayout.setHorizontalGroup(
            PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailAddressTitle)
                    .addComponent(lastNameTitle)
                    .addComponent(firstNameTitle)
                    .addComponent(phoneNumberTitle)
                    .addComponent(stateTitle)
                    .addComponent(cityTitle)
                    .addComponent(streetAddressTitle)
                    .addComponent(zipCodeTitle)
                    .addComponent(idNumberTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField)
                    .addComponent(lastNameField)
                    .addComponent(emailAddressField)
                    .addComponent(streetAddressField)
                    .addComponent(cityField)
                    .addComponent(stateField)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(phoneNumberField)
                    .addGroup(PatronPanelLayout.createSequentialGroup()
                        .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idNumberLabel)
                            .addGroup(PatronPanelLayout.createSequentialGroup()
                                .addComponent(savePatronButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(deletePatronButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PatronPanelLayout.setVerticalGroup(
            PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatronPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idNumberTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTitle)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddressTitle)
                    .addComponent(emailAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberTitle)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetAddressTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityTitle)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateTitle)
                    .addComponent(stateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeTitle)
                    .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PatronPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savePatronButton)
                    .addComponent(deletePatronButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PatronPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PatronPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatronPanel;
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityTitle;
    private javax.swing.JTextField emailAddressField;
    private javax.swing.JLabel emailAddressTitle;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameTitle;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JLabel idNumberTitle;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameTitle;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberTitle;
    private javax.swing.JButton savePatronButton;
    private javax.swing.JTextField stateField;
    private javax.swing.JLabel stateTitle;
    private javax.swing.JTextField streetAddressField;
    private javax.swing.JLabel streetAddressTitle;
    private javax.swing.JTextField zipCodeField;
    private javax.swing.JLabel zipCodeTitle;
    private javax.swing.JButton deletePatronButton;
    private ImageIcon addIcon = new ImageIcon("data/images/add.png");
    private ImageIcon saveIcon = new ImageIcon("data/images/save.png");
    private ImageIcon deleteIcon = new ImageIcon("data/images/delete.png");
    // End of variables declaration//GEN-END:variables
}
