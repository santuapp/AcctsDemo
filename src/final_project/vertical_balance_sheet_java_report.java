
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class vertical_balance_sheet_java_report extends javax.swing.JFrame implements ContainerListener {
    
    private final GridBagConstraints gridBagConstraints;
    int count = 1000;
    final JButton[][] labels=new JButton[count][4];

    /**
     * Creates new form vertical_balance_sheet_java_report
     */
    public vertical_balance_sheet_java_report() {
        initComponents();
        Font myFont = new Font("plain", Font.BOLD, 13);
        Font myFont1 = new Font("plain", Font.ITALIC, 13);
        Font myFont2 = new Font("plain", Font.ITALIC + Font.BOLD, 13);
        gridBagConstraints = new java.awt.GridBagConstraints();
        addContainerListener((ContainerListener) this);    
        gridBagConstraints.anchor=gridBagConstraints.PAGE_START;
        
        // Heading -Panel 1 start.....y=2
            
            JLabel tohead=new JLabel(" ");
            tohead.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead.setHorizontalAlignment(SwingConstants.NORTH_EAST);
            gridBagConstraints.weightx=0.5;
            jPanel1.add(tohead,gridBagConstraints);
            
            JLabel tohead1=new JLabel(" ");
            tohead1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead1.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.weightx=0.166;
            jPanel1.add(tohead1,gridBagConstraints);
            
            JLabel tohead2=new JLabel("as at 31-Mar-2009");
            tohead2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead2.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.weightx=0.166;
            jPanel1.add(tohead2,gridBagConstraints);
            
            JLabel tohead3=new JLabel(" ");
            tohead3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=28;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead3.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.weightx=0.166;
            jPanel1.add(tohead3,gridBagConstraints);
            
            
            // Heading -Panel 2 start.....y=2
            
            JLabel tohead4=new JLabel("Total");
            tohead4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead4.setHorizontalAlignment(SwingConstants.NORTH_EAST);
            gridBagConstraints.weightx=0.5;
            jPanel2.add(tohead4,gridBagConstraints);
            
            
            JLabel tohead5=new JLabel("                 ");
            tohead5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead5.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.weightx=0.166;
            jPanel2.add(tohead5,gridBagConstraints);
            
            JLabel tohead6=new JLabel(" ");
            tohead6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead6.setHorizontalAlignment(SwingConstants.CENTER);
            gridBagConstraints.weightx=0.166;
            jPanel2.add(tohead6,gridBagConstraints);
            
            JLabel tohead7=new JLabel("12202111.50 ");
            tohead7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=28;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            tohead7.setHorizontalAlignment(SwingConstants.RIGHT);
            gridBagConstraints.weightx=0.166;
            jPanel2.add(tohead7,gridBagConstraints);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vertical_balance_sheet_java_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vertical_balance_sheet_java_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vertical_balance_sheet_java_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vertical_balance_sheet_java_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vertical_balance_sheet_java_report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentAdded(ContainerEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
