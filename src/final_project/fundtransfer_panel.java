package final_project;
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
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.xswingx.PromptSupport;
//import org.jdesktop.xswingx.PromptSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class fundtransfer_panel extends javax.swing.JPanel {
     Font myFont = new Font("",Font.PLAIN,9);
    
     int i=0,j=0,k=0,l=0,m=0;     // For Mandatory
    
  

    /**
     * Creates new form fundtransfer_panel
     */
    public fundtransfer_panel() {
        initComponents();
        
        PromptSupport.setPrompt("dd/mm/yyyy", date_txt);
        PromptSupport.setPrompt("0.00", amt_num);
        
        jLabel6.setFont(myFont);
        jLabel6.setEnabled(false);
        jLabel6.setVisible(false);
        
        jLabel7.setFont(myFont);
        jLabel7.setEnabled(false);
        jLabel7.setVisible(false);
        
        
        jLabel8.setFont(myFont);
        jLabel8.setEnabled(false);
        jLabel8.setVisible(false);
        
        jLabel9.setFont(myFont);
        jLabel9.setEnabled(false);
        jLabel9.setVisible(false);
        
        jLabel10.setFont(myFont);
        jLabel10.setEnabled(false);
        jLabel10.setVisible(false);
        
        
        
      
      
         try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct l_name from ledger");
          while(rs.next())
          {
            
           
            from.addItem(rs.getString("l_name"));
              to.addItem(rs.getString("l_name"));
            
          }
       
          
         
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        } 
    }
        class FocusGrabber implements Runnable {
  private JComponent component;

  public FocusGrabber(JComponent component) {
    this.component = component;
  }

  public void run() {
    component.grabFocus();
  }
}
           // Validation Start.....................
 
            // invoice
     
     public void invoice(){
         
                        if(inv_no.getText().length()==0)
      {
          inv_no.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel7.setEnabled(true);
          jLabel7.setForeground(Color.red);
          jLabel7.setVisible(true);
             
      }  
      else
      {
           inv_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel7.setEnabled(false);  
           jLabel7.setVisible(false);
           j=1;
      }
     }
     
     // date
     
     public void date(){
             if(date_txt.getText().length()==0)
       {
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel6.setEnabled(true);
             jLabel6.setForeground(Color.red);
             jLabel6.setVisible(true);
           
       }
       else
       {
           
       
                 String content = date_txt.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
            //     System.out.println(matchFound);
                 date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel6.setEnabled(false);  
                 jLabel6.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel6.setEnabled(true);
             jLabel6.setForeground(Color.red);
             jLabel6.setVisible(true);
          }
       }
     }
 
    // from
     
     public void from(){
                if(from.getSelectedItem().equals(""))
      {
          from.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel8.setEnabled(true);
          jLabel8.setForeground(Color.red);
          jLabel8.setVisible(true);
             
      }  
      else
      {
           from.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel8.setEnabled(false);  
           jLabel8.setVisible(false);
           k=1;
      }
     }
 
    // to
     
     public void to(){
                     if(to.getSelectedItem().equals(""))
      {
          to.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel9.setEnabled(true);
          jLabel9.setForeground(Color.red);
          jLabel9.setVisible(true);
             
      }  
      else
      {
           to.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel9.setEnabled(false);  
           jLabel9.setVisible(false);
           l=1;
      }
         
     }
     
     // amount
     
     public void amt(){
                       if(amt_num.getText().length()==0)
                   {
                       amt_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                       
                   }
                   else
                   {
                       String content = amt_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       amt_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel10.setEnabled(false);  
                       jLabel10.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       amt_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                       
                    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        from = new javax.swing.JComboBox();
        to = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        amt_num = new numeric.textField.NumericTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        date_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inv_no = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Transfer Information"));

        from.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        from.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        from.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fromFocusLost(evt);
            }
        });

        to.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        to.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        to.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                toFocusLost(evt);
            }
        });

        jLabel3.setText("From:");

        jLabel4.setText("To:");

        amt_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        amt_num.setText("numericTextField1");
        amt_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amt_numFocusLost(evt);
            }
        });

        jLabel5.setText("Amount:");

        jLabel8.setText("Select One!");

        jLabel9.setText("Select One!");

        jLabel10.setText("Enter Valid Amount!");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/wire-transfer-icon.png"))); // NOI18N
        jButton1.setText("TRANSFER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amt_num, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Date and Invoice Informations"));

        jLabel2.setText("Date:");

        date_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        date_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                date_txtFocusLost(evt);
            }
        });

        jLabel6.setText("Enter Valid Date!");

        jLabel1.setText("Invoice No.:");

        inv_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        inv_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inv_noFocusLost(evt);
            }
        });

        jLabel7.setText("Enter Invoice No!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_no, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(inv_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Fund Transfer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(207, 207, 207))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        date();
        invoice();
        from();
        to();
        amt();
       

      if(i==1&&j==1&&k==1&&l==1&&m==1)

{   
    try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
Statement ps5 =con.createStatement();
            ResultSet rs5=ps5.executeQuery("SELECT get_id from company_main_table where get_id='"+inv_no.getText()+"'");

            if(rs5.next())
            {
                jopt1.showMessageDialog(this,"Transaction ID Already Exsist");
            }
            else
            {
            PreparedStatement ps=con.prepareStatement("insert into company_main_table (ledger,debit,get_id,trans_date,credit,type)values('"+to.getSelectedItem().toString()+"','"+amt_num.getText()+"','"+inv_no.getText()+"','"+date_txt.getText()+"','0','FUND TRANSFER')");
            ps.executeUpdate();
            PreparedStatement ps1=con.prepareStatement("insert into company_main_table (ledger,credit,get_id,trans_date,debit,type)values('"+from.getSelectedItem().toString()+"','"+amt_num.getText()+"','"+inv_no.getText()+"','"+date_txt.getText()+"','0','FUND TRANSFER')");
            ps1.executeUpdate();
            System.out.println("saved");
 
            jopt1.showMessageDialog(this,"Transaction Done");

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
    date_txt.setText("");
    inv_no.setText("");
    from.setSelectedItem("");
    to.setSelectedItem("");
    amt_num.setText("");  
    
     date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
      inv_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       from.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        to.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
         amt_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    
         jLabel6.setVisible(false);
         jLabel7.setVisible(false);
         jLabel8.setVisible(false);
         jLabel9.setVisible(false);
         jLabel10.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void date_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_txtFocusLost
             if(date_txt.getText().length()==0)
       {
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel6.setEnabled(true);
             jLabel6.setForeground(Color.red);
             jLabel6.setVisible(true);
           
       }
       else
       {
           
       
                 String content = date_txt.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
            //     System.out.println(matchFound);
                 date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel6.setEnabled(false);  
                 jLabel6.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel6.setEnabled(true);
             jLabel6.setForeground(Color.red);
             jLabel6.setVisible(true);
          }
       }
    }//GEN-LAST:event_date_txtFocusLost

    private void inv_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inv_noFocusLost
                        if(inv_no.getText().length()==0)
      {
          inv_no.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel7.setEnabled(true);
          jLabel7.setForeground(Color.red);
          jLabel7.setVisible(true);
             
      }  
      else
      {
           inv_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel7.setEnabled(false);  
           jLabel7.setVisible(false);
           j=1;
      }
    }//GEN-LAST:event_inv_noFocusLost

    private void fromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fromFocusLost
               if(from.getSelectedItem().equals(""))
      {
          from.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel8.setEnabled(true);
          jLabel8.setForeground(Color.red);
          jLabel8.setVisible(true);
             
      }  
      else
      {
           from.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel8.setEnabled(false);  
           jLabel8.setVisible(false);
           k=1;
      }
    }//GEN-LAST:event_fromFocusLost

    private void toFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toFocusLost
                  if(to.getSelectedItem().equals(""))
      {
          to.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel9.setEnabled(true);
          jLabel9.setForeground(Color.red);
          jLabel9.setVisible(true);
             
      }  
      else
      {
           to.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel9.setEnabled(false);  
           jLabel9.setVisible(false);
           l=1;
      }
    }//GEN-LAST:event_toFocusLost

    private void amt_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amt_numFocusLost
            if(amt_num.getText().length()==0)
                   {
                       amt_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                       
                   }
                   else
                   {
                       String content = amt_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       amt_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel10.setEnabled(false);  
                       jLabel10.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       amt_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                       
                    }
                   }
                           
    }//GEN-LAST:event_amt_numFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private numeric.textField.NumericTextField amt_num;
    private javax.swing.JTextField date_txt;
    private javax.swing.JComboBox from;
    private javax.swing.JTextField inv_no;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox to;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
}
