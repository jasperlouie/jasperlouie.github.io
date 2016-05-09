import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Creates the UI components for editing and adding a LibraryType.
 * @author Jasper
 * @version 0.1
 */
@SuppressWarnings("serial")
public class TypePanel extends javax.swing.JPanel {
	MainGui parent;
	LibraryType type;
    /**
     * Creates new form NewJPanel
     */
    public TypePanel() {
        initComponents();
    }
    
    /**
	 * Creates new form TypePanel used to edit an existing Type
	 *
	 * @param	pa	the MainGui that this panel is going into
	 */
    public TypePanel( final MainGui pa ) {
    	parent = pa;
        initComponents1();
        //listener for the "Save Type" button
        saveTypeButton.setText("Add Type");
        saveTypeButton.setIcon(addIcon);
        saveTypeButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(!typeDescriptionField.getText().equals("")&&!typeCodeField1.getText().equals("")){
        			LibraryDatabase.getInstance().addNewType(typeCodeField1.getText(),typeDescriptionField.getText());
            		pa.refreshLists(true);
        		}else{
        			//error handling
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please do not leave any of the fields blank.",
            			    "Blank Field Error",
            			    JOptionPane.ERROR_MESSAGE);
        		}
        		
        	}
        });
        
    }
    /**
	 * Creates new form TypePanel for adding new Types
	 * @param	pa	the MainGui that this panel is going into
	 */
    public TypePanel(LibraryType t, final MainGui pa ) {
    	parent = pa;
    	type = t;
        initComponents();
        typeCodeField.setText(t.getCode());
        typeDescriptionField.setText(t.getDescription());
        //Action Listener for the SaveType Button
        saveTypeButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(!typeDescriptionField.getText().equals("")){
        			LibraryDatabase.getInstance().setNewType(type, typeCodeField.getText(),typeDescriptionField.getText());
            		pa.refreshLists(false);
        		}else{
        			//error handling
        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            			    "Please do not leave any of the fields blank.",
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
    private void initComponents() {
    	//initializes components
        typePanel = new javax.swing.JPanel();
        saveTypeButton = new javax.swing.JButton();
        typeCodeTitle = new javax.swing.JLabel();
        typeDescriptionTitle = new javax.swing.JLabel();
        typeDescriptionField = new javax.swing.JTextField();
        typeCodeField = new javax.swing.JLabel();
        typeCodeField1 = new javax.swing.JTextField();
        
        //contents of buttons being initialized
        saveTypeButton.setText("Save Type");
        saveTypeButton.setIcon(saveIcon);
        typeCodeTitle.setText("Type Code:");
        typeDescriptionTitle.setText("Type Description");
        typeDescriptionField.setText("");
        
        //layout for jframe being configured
        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(typePanelLayout.createSequentialGroup()
                        .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeDescriptionTitle)
                            .addComponent(typeCodeTitle))
                        .addGap(31, 31, 31)
                        .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeCodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(typeDescriptionField))))
                .addContainerGap())
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeDescriptionTitle)
                    .addComponent(typeDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveTypeButton)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(typePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(typePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }
    
    private void initComponents1() {
    	
    	//components being initalized
        typePanel = new javax.swing.JPanel();
        saveTypeButton = new javax.swing.JButton();
        typeCodeTitle = new javax.swing.JLabel();
        typeDescriptionTitle = new javax.swing.JLabel();
        typeDescriptionField = new javax.swing.JTextField();
        typeCodeField1 = new javax.swing.JTextField();

        //button text names being initialized
        saveTypeButton.setText("Save Type");
        typeCodeTitle.setText("Type Code:");
        typeDescriptionTitle.setText("Type Description");

        //jframe layout being applied
        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(typePanelLayout.createSequentialGroup()
                        .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeDescriptionTitle)
                            .addComponent(typeCodeTitle))
                        .addGap(31, 31, 31)
                        .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeCodeField1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addComponent(typeDescriptionField))))
                .addContainerGap())
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCodeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeDescriptionTitle)
                    .addComponent(typeDescriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveTypeButton)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(typePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(typePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void typeDescriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeDescriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeDescriptionFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel typeCodeField;
    private javax.swing.JTextField typeCodeField1;
    private javax.swing.JTextField typeDescriptionField;
    private javax.swing.JButton saveTypeButton;
    private javax.swing.JLabel typeCodeTitle;
    private javax.swing.JLabel typeDescriptionTitle;
    private javax.swing.JPanel typePanel;
    private ImageIcon addIcon = new ImageIcon("data/images/add.png");
    private ImageIcon saveIcon = new ImageIcon("data/images/save.png");
    // End of variables declaration//GEN-END:variables
}
