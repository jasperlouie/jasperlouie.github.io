import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Builds the GUI for editing and adding an Item.
 * @author Jasper
 * @version	0.1
 */
@SuppressWarnings("serial")
public class ItemPanel extends javax.swing.JPanel {
	MainGui parent;
	Item item;

    /**
     * Creates new form ItemPanel
     */
    public ItemPanel() {
        initComponents(true);
    }
    /**
	 * Creates new form ItemPanel used to edit an existing Item
	 *
	 * @param   i	Item used to construct the Panel
	 * @param	pa	the MainGui that this panel is going into
	 */
    public ItemPanel(Item i, final MainGui pa) {
    	parent = pa;
        initComponents(false);
        item = i;
        idNumberLabel.setText(i.getItemNumber()+"");
        datePubField.setText(DateUtil.printShortDate(i.getPubDate()));
        authorField.setText(i.getAuthor());
        titleField.setText(i.getTitle());
        typeBox.setSelectedItem(i.getType());
        saveItemButton.setIcon(saveIcon);
        deleteItemButton.setIcon(deleteIcon);
        
        //listener for the save button, and the action it takes
        saveItemButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if( !titleField.getText().equals("")&& !authorField.getText().equals("")&& !datePubField.getText().equals("")){
        			try{
        				//the process of writing the item to the Library Database
        				if(DateUtil.isValidMonth(datePubField.getText())&&DateUtil.isValidYear(datePubField.getText())){
        					LibraryDatabase.getInstance().setNewItem(item, ((LibraryType)typeBox.getSelectedItem()).getCode(), titleField.getText(), authorField.getText(), datePubField.getText());
        				}else{
        					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                    			    "Please enter a valid Date into the \"Publish Date\" field, "+datePubField.getText()+" is not a valid Date MM/YYYY format","Date Error",
                    			    JOptionPane.ERROR_MESSAGE);
        				}
        			}catch(Exception l){
        				//error handling
        				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
        						"Please enter valid a Date into the \"Publish Date\" field, "+datePubField.getText()+" is not a valid Date MM/YYYY format","Date Error",
                			    JOptionPane.ERROR_MESSAGE);
        			}
        			pa.refreshLists(false);
        		}else{
        			//error handling
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please input into all Text Fields.",
            			    "Blank Field Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        //listener for the "Delete Item" button
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	LibraryDatabase.getInstance().deleteItem(item);
            	parent.refreshLists(false);
            }
        });
    }
    /**
	 * Creates new form ItemPanel for adding Items
	 *
	 * @param	pa	the MainGui that this panel is going into
	 */
    public ItemPanel(final MainGui pa) {
    	//component initialization
    	parent = pa;
        initComponents(true);
        idNumberLabel.setText("to be Assigned");
        deleteItemButton.setVisible(false);
        saveItemButton.setText("Add Item");
        saveItemButton.setIcon(addIcon);
        saveItemButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//checks whether fields are blank	
        		if( !titleField.getText().equals("")&& !authorField.getText().equals("")&& !datePubField.getText().equals("")){
        			try{
        				//checks if valid date
        				if(DateUtil.isValidMonth(datePubField.getText())&&DateUtil.isValidYear(datePubField.getText())){
	        				LibraryDatabase.getInstance().addNewItem( ((LibraryType)typeBox.getSelectedItem()).getCode(), titleField.getText(), authorField.getText(), datePubField.getText());
	        				pa.refreshLists(true);
        				}else{
        					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
        							"Please enter a valid Date into the \"Publish Date\" field, "+datePubField.getText()+" is not a valid Date MM/YYYY format","Date Error",
                    			    JOptionPane.ERROR_MESSAGE);
        				}
        			}catch(Exception l){
        				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
        						"Please enter a valid Date into the \"Publish Date\" field, "+datePubField.getText()+" is not a valid Date in the MM/YYYY format","Date Error",
                			    JOptionPane.ERROR_MESSAGE);
            		}        			
        			
        		}else{
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please input into all Text Fields.",
            			    "Blank Field Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents(boolean isNew) {
    	
    	//initialization of components
    	ItemPanel = new javax.swing.JPanel();
        saveItemButton = new javax.swing.JButton();
        titleTitle = new javax.swing.JLabel();
        authorTitle = new javax.swing.JLabel();
        datePubTitle = new javax.swing.JLabel();
        typeTitle = new javax.swing.JLabel();
        datePubField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();
        itemIDTitle = new javax.swing.JLabel();
        idNumberLabel = new javax.swing.JLabel();
        mmLabel = new javax.swing.JLabel();
        deleteItemButton = new javax.swing.JButton();
        typeBox = new javax.swing.JComboBox();
        titleField = new javax.swing.JTextField();
        
        //setting component display names
        saveItemButton.setText("Save Item");
        titleTitle.setText("Title:");
        authorTitle.setText("Author:");
        datePubTitle.setText("Date Published:");
        typeTitle.setText("Type:");
        datePubField.setText("");
        authorField.setText("");
        titleField.setText("");
        itemIDTitle.setText("Item ID#:");
        idNumberLabel.setText("");
        mmLabel.setText("(MM/YYYY)");
        datePubField.setText("");
        authorField.setText("");
        titleField.setText("");
        deleteItemButton.setText("Delete Item");
        typeBox.setModel(new javax.swing.DefaultComboBoxModel(LibraryDatabase.getInstance().getTypes().toArray()));
        


       //Setting Layout attributes
        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addComponent(saveItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 161, Short.MAX_VALUE))
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datePubTitle)
                                    .addComponent(authorTitle)
                                    .addComponent(titleTitle)
                                    .addComponent(typeTitle)
                                    .addComponent(itemIDTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleField)
                                    .addComponent(authorField)
                                    .addComponent(datePubField)
                                    .addGroup(ItemPanelLayout.createSequentialGroup()
                                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idNumberLabel)
                                            .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(54, 54, 54))
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addComponent(mmLabel)
                        .addContainerGap())))
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIDTitle)
                    .addComponent(idNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorTitle)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePubTitle)
                    .addComponent(datePubField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(mmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeTitle)
                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveItemButton)
                    .addComponent(deleteItemButton))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
    }// </editor-fold>
        // Variables declaration - do not modify
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorTitle;
    private javax.swing.JTextField datePubField;
    private javax.swing.JLabel datePubTitle;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JLabel itemIDTitle;
    private javax.swing.JLabel mmLabel;
    private javax.swing.JButton saveItemButton;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleTitle;
    private javax.swing.JLabel typeTitle;
    private javax.swing.JButton deleteItemButton;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox typeBox;
    private ImageIcon addIcon = new ImageIcon("data/images/add.png");
    private ImageIcon saveIcon = new ImageIcon("data/images/save.png");
    private ImageIcon deleteIcon = new ImageIcon("data/images/delete.png");
    
        // End of variables declaration
    }

