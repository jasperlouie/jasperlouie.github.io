/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Creates the UI for the Report panel called from the Reports tab.
 * @author Jasper
 */
@SuppressWarnings("serial")
public class ReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportPanel
     */
    public ReportPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	//initializes components
        openItemReportsButton = new javax.swing.JButton();
        openPatronReportsButton = new javax.swing.JButton();
        openTypeReportsButton = new javax.swing.JButton();
        OpenItemsOutReportsButton = new javax.swing.JButton();
        
        //sets JComponent display names
        openItemReportsButton.setText("Open Item Report");

        openPatronReportsButton.setText("Open Patron Report");

        openTypeReportsButton.setText("Open Type Report");

        OpenItemsOutReportsButton.setText("Open Items Checked Out Report");
        
        //sets layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openItemReportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openPatronReportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openTypeReportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpenItemsOutReportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openItemReportsButton)
                .addGap(18, 18, 18)
                .addComponent(openPatronReportsButton)
                .addGap(18, 18, 18)
                .addComponent(openTypeReportsButton)
                .addGap(18, 18, 18)
                .addComponent(OpenItemsOutReportsButton)
                .addContainerGap(243, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OpenItemsOutReportsButton;
    private javax.swing.JButton openItemReportsButton;
    private javax.swing.JButton openPatronReportsButton;
    private javax.swing.JButton openTypeReportsButton;
    // End of variables declaration//GEN-END:variables
}
