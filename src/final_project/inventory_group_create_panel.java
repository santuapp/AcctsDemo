package final_project;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class inventory_group_create_panel extends javax.swing.JPanel {
    Font myFont=new Font("",Font.PLAIN,9);
    int i=0,j=0,k=0;

    /**
     * Creates new form inventory_group_create_panel
     */
    public inventory_group_create_panel() {
        initComponents();
        
        jLabel1.setFont(myFont);
        jLabel1.setEnabled(false);
        jLabel1.setVisible(false);
        
        jLabel2.setFont(myFont);
        jLabel2.setEnabled(false);
        jLabel2.setVisible(false);
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct inv_g_name from inv_group order by inv_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("inv_g_name");
                under.addItem(name);
            }
        
        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        
    }
    
    // group
    
    public void group(){
              if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel1.setEnabled(true);
          jLabel1.setForeground(Color.red);
          jLabel1.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel1.setEnabled(false);  
           jLabel1.setVisible(false);
          j=1;
      }
    }
    
    // under
    
    public void under(){
          if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel2.setEnabled(true);
          jLabel2.setForeground(Color.red);
          jLabel2.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel2.setEnabled(false);  
           jLabel2.setVisible(false);
           k=1;
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        group_name_txt = new javax.swing.JTextField();
        under = new javax.swing.JComboBox();
        reset_button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        submit_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Inventory Master");

        jLabel8.setText("Group Name:");

        group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                group_name_txtFocusLost(evt);
            }
        });

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                underFocusLost(evt);
            }
        });

        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        jLabel9.setText("Under:");

        submit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Group Name!");

        jLabel2.setText("Select Under!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(reset_button)
                        .addGap(29, 29, 29)
                        .addComponent(submit_button)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jLabel7)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_button)
                    .addComponent(submit_button))
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(199, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
       group_name_txt.setText("");
       under.setSelectedIndex(0);
       group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       jLabel1.setVisible(false);
       jLabel2.setVisible(false);
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
    // Validation Start
     group();
     under();
        
        
        
        
        if(j==1&&k==1)
      {
   
       try
            {

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps2 =con.createStatement();
            PreparedStatement ps=con.prepareStatement("insert into inv_group(inv_g_name,inv_g_under)values('"+group_name_txt.getText()+"','"+under.getSelectedItem().toString()+"')");
            ps.executeUpdate();
            PreparedStatement psss=con.prepareStatement("CREATE TABLE IF NOT EXISTS `"+group_name_txt.getText()+"`(`inv_id` int(11) NOT NULL AUTO_INCREMENT,`inv_p_id` varchar(1000),`p_name` varchar(1000) NOT NULL DEFAULT '',`inv_open` varchar(1000),`inv_sale` varchar(1000),`inv_purchase` varchar(1000),`trans_id` varchar(1000),PRIMARY KEY (`inv_id`)) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='Table for inventory reports' AUTO_INCREMENT=1");
            psss.executeUpdate();
            System.out.println("saved");

            jOptionPane1.showMessageDialog(this,"Saved");
            under.removeAllItems();
            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct inv_g_name from inv_group order by inv_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("inv_g_name");
                under.addItem(name);
            }
        
        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
      } 
     else{
          //jOptionPane1.showMessageDialog(this,"Not saved");
     }
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void group_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_group_name_txtFocusLost
          if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel1.setEnabled(true);
          jLabel1.setForeground(Color.red);
          jLabel1.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel1.setEnabled(false);  
           jLabel1.setVisible(false);
           j=1;
      }
    }//GEN-LAST:event_group_name_txtFocusLost

    private void underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_underFocusLost
      if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel2.setEnabled(true);
          jLabel2.setForeground(Color.red);
          jLabel2.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel2.setEnabled(false);  
           jLabel2.setVisible(false);
           k=1;
       }
    }//GEN-LAST:event_underFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField group_name_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JComboBox under;
    // End of variables declaration//GEN-END:variables
}