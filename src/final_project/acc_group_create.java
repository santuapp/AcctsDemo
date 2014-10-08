package final_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc2
 */
public class acc_group_create extends javax.swing.JPanel {
Font myFont=new Font("",Font.PLAIN,9);
 int i=0,j=0;
    /**
     * Creates new form acc_group_create
     */
    String no;
    public acc_group_create() {
        
        initComponents();
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
      
         try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group order by acc_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("g_name");
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
    
    // group name
    
    public void group(){
              if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }
        
    }
    
    // under
    
    public void under(){
           if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
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

        group_create = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        group_name_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        under = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Create Group Ledger");

        group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                group_name_txtFocusLost(evt);
            }
        });

        jLabel2.setText("*Group Name:");

        jLabel3.setText("*Under:");

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                underFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Save-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Valid Group Name!");

        jLabel5.setText("Select One Group!");

        javax.swing.GroupLayout group_createLayout = new javax.swing.GroupLayout(group_create);
        group_create.setLayout(group_createLayout);
        group_createLayout.setHorizontalGroup(
            group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_createLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(group_createLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(group_createLayout.createSequentialGroup()
                        .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        group_createLayout.setVerticalGroup(
            group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_createLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(group_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(group_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// Validation Start.................
        
     
          group();
          under();
        
      
    if(i==1&&j==1)
    {
     
        
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
Statement ps2 =con.createStatement();
//           ResultSet rs2=ps2.executeQuery("select max(id) as id from test");
//          while(rs2.next())
//          {
//              no=rs2.getString("id");
//          }    
//            PreparedStatement pss=con.prepareStatement("update test set Col_2='"+group_name_txt.getText()+"' where id='"+no+"'");
//          pss.executeUpdate();
           Statement ps5 =con.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT g_name from acc_group where g_name='"+group_name_txt.getText()+"'");

if(rs5.next())
{
     jopt1.showMessageDialog(this,"Group Already Exsist"); 
}
else
{
            PreparedStatement ps=con.prepareStatement("insert into acc_group(g_name,g_under)values('"+group_name_txt.getText()+"','"+under.getSelectedItem().toString()+"')");
            ps.executeUpdate();
            PreparedStatement psss=con.prepareStatement("CREATE TABLE IF NOT EXISTS `"+group_name_txt.getText()+"`(`id` int(11) NOT NULL AUTO_INCREMENT,`l_name` varchar(1000) NOT NULL DEFAULT '',`debit` varchar(1000),`credit` varchar(1000),`trans_id` varchar(1000),PRIMARY KEY (`id`)) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='Table with abuse reports' AUTO_INCREMENT=1");
            psss.executeUpdate();
            System.out.println("saved");

            jopt1.showMessageDialog(this,"Saved");
           // under.removeAllItems();
             group_name_txt.setText("");
        under.setSelectedIndex(0);
            
            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group order by acc_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("g_name");
                under.addItem(name);
            }
//            
          }
        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
    
      } 
        
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        group_name_txt.setText("");
        under.setSelectedIndex(0);
        group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void group_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_group_name_txtFocusLost
         if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }
    }//GEN-LAST:event_group_name_txtFocusLost

    private void underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_underFocusLost
          if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_underFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel group_create;
    private javax.swing.JTextField group_name_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox under;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;

    void setParent(AbstractAction aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}