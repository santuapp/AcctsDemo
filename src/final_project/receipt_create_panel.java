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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class receipt_create_panel extends javax.swing.JPanel {

    Font myFont = new Font("",Font.PLAIN,9);
    int i=0,j=0,k=0,l=0,m=0;   // For Mandatory
    int x=0,y=0,z=0;           // For Non Mandatory
    /**
     * Creates new form receipt_create_panel
     */
    public receipt_create_panel() {
        initComponents();
        
        jLabel15.setFont(myFont);
        jLabel15.setEnabled(false);
        jLabel15.setVisible(false);
        
         jLabel16.setFont(myFont);
        jLabel16.setEnabled(false);
        jLabel16.setVisible(false);
        
         jLabel17.setFont(myFont);
        jLabel17.setEnabled(false);
        jLabel17.setVisible(false);
        
         jLabel18.setFont(myFont);
        jLabel18.setEnabled(false);
        jLabel18.setVisible(false);
        
        jLabel19.setFont(myFont);
        jLabel19.setEnabled(false);
        jLabel19.setVisible(false);
        
         jLabel20.setFont(myFont);
        jLabel20.setEnabled(false);
        jLabel20.setVisible(false);
        
         jLabel21.setFont(myFont);
        jLabel21.setEnabled(false);
        jLabel21.setVisible(false);
        
         jLabel22.setFont(myFont);
        jLabel22.setEnabled(false);
        jLabel22.setVisible(false);
        
        
         jLabel23.setFont(myFont);
        jLabel23.setEnabled(false);
        jLabel23.setVisible(false);
        
        
         jLabel25.setFont(myFont);
        jLabel25.setEnabled(false);
        jLabel25.setVisible(false);
        
        
         jLabel24.setFont(myFont);
        jLabel24.setEnabled(false);
        jLabel24.setVisible(false);
        
        
         jLabel26.setFont(myFont);
        jLabel26.setEnabled(false);
        jLabel26.setVisible(false);
        
        
            
        
        
        
        PromptSupport.setPrompt("dd/mm/yyyy", rec_date);
        PromptSupport.setPrompt("John Smith", rec_c_name);
        PromptSupport.setPrompt("123456", rec_cheque_no);
        PromptSupport.setPrompt("0.00", rec_balance);
        PromptSupport.setPrompt("BANK", rec_bank_name);
        PromptSupport.setPrompt("BRANCH", rec_br_name);
        PromptSupport.setPrompt("0.00", rec_amnt);
        PromptSupport.setPrompt("One Two Three Only", rec_amnt_words);
        PromptSupport.setPrompt("xyz", rec_received_for);
      
         try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct l_name from ledger group by l_id");
          while(rs.next())
          {
              String name=rs.getString("l_name");
             
              rec_ledger.addItem(name);
              rec_ledger2.addItem(name);
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
   
   
     // invoice
     
     public void invoice(){
         
                        if(rec_inv.getText().length()==0)
      {
          rec_inv.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           rec_inv.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           i=1;
      }
     }
     
     // date
     
     public void date(){
             if(rec_date.getText().length()==0)
       {
             rec_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel26.setEnabled(true);
             jLabel26.setForeground(Color.red);
             jLabel26.setVisible(true);
           
       }
       else
       {
           
       
                 String content = rec_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
                 System.out.println(matchFound);
                 rec_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel26.setEnabled(false);  
                 jLabel26.setVisible(false);
                 j=1;
          
          if(!matchFound)
          { 
             rec_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel26.setEnabled(true);
             jLabel26.setForeground(Color.red);
             jLabel26.setVisible(true);
          }
       }
     }
 
    // ledger
     
     public void ledger(){
                if(rec_ledger.getSelectedItem().equals(""))
      {
          rec_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel17.setEnabled(true);
          jLabel17.setForeground(Color.red);
          jLabel17.setVisible(true);
             
      }  
      else
      {
           rec_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel17.setEnabled(false);  
           jLabel17.setVisible(false);
           k=1;
      }
     }
 
    // payment
     
     public void payment(){
                     if(rec_ledger2.getSelectedItem().equals(""))
      {
          rec_ledger2.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel21.setEnabled(true);
          jLabel21.setForeground(Color.red);
          jLabel21.setVisible(true);
             
      }  
      else
      {
           rec_ledger2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel21.setEnabled(false);  
           jLabel21.setVisible(false);
           l=1;
      }
         
     }
     
     // amount
     
     public void amt(){
                       if(rec_amnt.getText().length()==0)
                   {
                       rec_amnt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel25.setEnabled(true);
                       jLabel25.setForeground(Color.red);
                       jLabel25.setVisible(true);
                       
                   }
                   else
                   {
                       String content = rec_amnt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       rec_amnt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel25.setEnabled(false);  
                       jLabel25.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       rec_amnt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel25.setEnabled(true);
                       jLabel25.setForeground(Color.red);
                       jLabel25.setVisible(true);
                       
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
        jLabel12 = new javax.swing.JLabel();
        rec_inv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rec_c_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rec_ledger = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        rec_ref_no = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        rec_balance = new numeric.textField.NumericTextField();
        jLabel6 = new javax.swing.JLabel();
        rec_received_for = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rec_ledger2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        rec_bank_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rec_cheque_no = new numeric.textField.NumericTextField();
        jLabel10 = new javax.swing.JLabel();
        rec_amnt = new numeric.textField.NumericTextField();
        jLabel14 = new javax.swing.JLabel();
        rec_br_name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rec_amnt_words = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rec_date = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        jLabel12.setText("*Invoice No.:");

        rec_inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_inv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_invFocusLost(evt);
            }
        });

        jLabel2.setText("Name:");

        rec_c_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_c_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_c_nameFocusLost(evt);
            }
        });

        jLabel3.setText("*Ledger:");

        rec_ledger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        rec_ledger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_ledger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_ledgerFocusLost(evt);
            }
        });

        jLabel4.setText("Reference No:");

        rec_ref_no.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        rec_ref_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setText("Balance:");

        rec_balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_balance.setText("numericTextField1");
        rec_balance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_balanceFocusLost(evt);
            }
        });

        jLabel6.setText("Received For:");

        rec_received_for.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel7.setText("*Receipt Ledger:");

        rec_ledger2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        rec_ledger2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_ledger2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_ledger2FocusLost(evt);
            }
        });

        jLabel8.setText("Bank Name:");

        rec_bank_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel9.setText("Cheque No:");

        rec_cheque_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_cheque_no.setText("numericTextField1");
        rec_cheque_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_cheque_noFocusLost(evt);
            }
        });

        jLabel10.setText("*Amount:");

        rec_amnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_amnt.setText("numericTextField1");
        rec_amnt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_amntFocusLost(evt);
            }
        });

        jLabel14.setText("Branch Name:");

        rec_br_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setText("Amount in Words:");

        rec_amnt_words.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel13.setText("*Date:");

        rec_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rec_dateFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("RECEIPT VOUNCER CREATION");

        jLabel15.setText("Enter Valid Invoice Number!");

        jLabel16.setText("Enter Valid Name!");

        jLabel17.setText("Select Ledger!");

        jLabel18.setText("Select Reference Number!");

        jLabel19.setText("Enter Balance!");

        jLabel20.setText("Enter Received Name!");

        jLabel21.setText("Select Receipt Ledger!");

        jLabel22.setText("Enter Bank Name!");

        jLabel23.setText("Enter Valid Cheque Number!");

        jLabel24.setText("Enter Bank Branch Name!");

        jLabel25.setText("Enter Valid Amount!");

        jLabel26.setText("Enter Valid Date Format!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rec_ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rec_received_for, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rec_c_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rec_ref_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rec_balance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rec_ledger2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rec_bank_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(rec_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(rec_cheque_no, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rec_amnt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jButton2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton1)))
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel11)))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rec_br_name, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rec_amnt_words, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rec_amnt, rec_balance, rec_bank_name, rec_c_name, rec_cheque_no, rec_inv, rec_ledger, rec_ledger2, rec_received_for, rec_ref_no});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rec_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rec_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rec_ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rec_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rec_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rec_received_for, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rec_ledger2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rec_bank_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rec_cheque_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(rec_br_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rec_amnt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rec_amnt_words, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void day_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_day_txtFocusLost
       
    }//GEN-LAST:event_day_txtFocusLost

    private void month_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_month_txtFocusLost
       
    }//GEN-LAST:event_month_txtFocusLost

    private void year_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_year_txtFocusLost
       
    }//GEN-LAST:event_year_txtFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   //  Validation Start.....
        
     
                           
       invoice();
        date();
        ledger();
        payment();
        amt();
       

      if(i==1&&j==1&&k==1&&l==1&&m==1&&x==0&&y==0&&z==0)
                  
      {
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        
          PreparedStatement ps=con.prepareStatement("insert into receipt(rec_c_name,rec_date,rec_ledger,rec_ref_no,rec_balance,rec_ledger1,rec_bank_name,rec_branch_name,rec_cheque_no,rec_total_amnt,rec_amnt_words,rec_for,rec_invoice)values('"+rec_c_name.getText()+"','"+rec_date.getText()+"','"+rec_ledger.getSelectedItem().toString()+"','"+rec_ref_no.getSelectedItem().toString()+"','"+rec_balance.getText()+"','"+rec_ledger2.getSelectedItem().toString()+"','"+rec_bank_name.getText()+"','"+rec_br_name.getText()+"','"+rec_cheque_no.getText()+"','"+rec_amnt.getText()+"','"+rec_amnt_words.getText()+"','"+rec_received_for.getText()+"','"+rec_inv.getText()+"')");
          ps.executeUpdate();
          PreparedStatement psq=con.prepareStatement("insert into company_main_table(ledger, credit, debit, get_id,trans_date)values('"+rec_ledger.getSelectedItem().toString()+"','"+rec_amnt.getText()+"','0','"+rec_inv.getText()+"','"+rec_date.getText()+"')");
            
            psq.executeUpdate();
            PreparedStatement psm=con.prepareStatement("insert into company_main_table(ledger, credit, debit, get_id,trans_date)values('"+rec_ledger2.getSelectedItem().toString()+"','0','"+rec_amnt.getText()+"','"+rec_inv.getText()+"','"+rec_date.getText()+"')");
            
            psm.executeUpdate();
             Statement pss =con.createStatement();
           ResultSet rss=pss.executeQuery("select  l_under from ledger where l_name='"+rec_ledger.getSelectedItem().toString()+"'");
          while(rss.next())
          {
              String under=rss.getString("l_under");
             PreparedStatement psw=con.prepareStatement("insert into `"+under+"` (l_name,debit,credit,trans_id)values('"+rec_ledger.getSelectedItem().toString()+"','"+rec_amnt.getText()+"','0','"+rec_inv.getText()+"')");
          psw.executeUpdate();
              
          }
          Statement pssw =con.createStatement();
           ResultSet rssw=pssw.executeQuery("select  l_under from ledger where l_name='"+rec_ledger2.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under1=rssw.getString("l_under");
             PreparedStatement pswm=con.prepareStatement("insert into `"+under1+"` (l_name,debit,credit,trans_id)values('"+rec_ledger2.getSelectedItem().toString()+"','0','"+rec_amnt.getText()+"','"+rec_inv.getText()+"')");
          pswm.executeUpdate();
              
          }
          System.out.println("saved");
            
          jopt1.showMessageDialog(this,"Received Successfully");
        
           
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
        rec_c_name.setText("");
        rec_balance.setText("");
        rec_received_for.setText("");
        rec_bank_name.setText("");
        rec_cheque_no.setText("");
        rec_amnt.setText("");
        rec_amnt_words.setText("");
        rec_inv.setText("");
        rec_date.setText("");
        rec_br_name.setText("");
        
        rec_inv.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_ledger2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rec_amnt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        //rec_inv.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       
        jLabel15.setVisible(false);
        jLabel26.setVisible(false);
        jLabel17.setVisible(false);
        jLabel21.setVisible(false);
        jLabel25.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void rec_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_dateFocusLost
        
       if(rec_date.getText().toString()==null){
           
           rec_date.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel26.setEnabled(true);
          jLabel26.setForeground(Color.red);
          jLabel26.setVisible(true);
       }
       else{
        String content = rec_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
                 System.out.println(matchFound);
                 rec_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel26.setEnabled(false);  
                 jLabel26.setVisible(false);
                 j=1;
                          
          if(!matchFound)
          { 
                    
           rec_date.setBorder(BorderFactory.createLineBorder(Color.red));
           jLabel26.setEnabled(true);
          jLabel26.setForeground(Color.red);
          jLabel26.setVisible(true);
          }
       }
       
    }//GEN-LAST:event_rec_dateFocusLost

    private void rec_c_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_c_nameFocusLost
     if(rec_c_name.getText().length()==0)
                            {
                                rec_c_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                jLabel16.setEnabled(false);  
                                jLabel16.setVisible(false);
                                x=0;
                                
                            }
                            else
                            {
                                 String email =rec_c_name.getText();
                                 String regEx1 = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$";
                                 Pattern p1 = Pattern.compile(regEx1);
                                 Matcher m1 = p1.matcher(email);
                                 rec_c_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                 jLabel16.setEnabled(false);  
                                 jLabel16.setVisible(false);
                                 x=0;
                       
                               if(m1.find()==false)
                             {
                                  x=1;
                               rec_c_name.setBorder(BorderFactory.createLineBorder(Color.red));
                               jLabel16.setEnabled(true);
                               jLabel16.setForeground(Color.red);
                               jLabel16.setVisible(true);
                              
                             }
                           }
    }//GEN-LAST:event_rec_c_nameFocusLost

    private void rec_cheque_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_cheque_noFocusLost
      if(rec_cheque_no.getText().length()==0)
                   {
                        rec_cheque_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel23.setEnabled(false);  
                        jLabel23.setVisible(false);
                        z=0;
                       
                   }
                   else
                   {
                        String pin = rec_cheque_no.getText();
                        String regEx = "\\d{6}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                        rec_cheque_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel23.setEnabled(false);  
                        jLabel23.setVisible(false);
                        z=0;
                      if(m.find()==false)
                    {
                        z=1;
                        rec_cheque_no.setBorder(BorderFactory.createLineBorder(Color.red));
                               jLabel23.setEnabled(true);
                               jLabel23.setForeground(Color.red);
                               jLabel23.setVisible(true);
                       
                    }
                      
                   }
    }//GEN-LAST:event_rec_cheque_noFocusLost

    private void rec_amntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_amntFocusLost
          
             if(rec_amnt.getText().length()==0)
                   {
                       rec_amnt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel25.setEnabled(true);
                       jLabel25.setForeground(Color.red);
                       jLabel25.setVisible(true);
                       
                   }
                   else
                   {
                       String content = rec_amnt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       rec_amnt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel25.setEnabled(false);  
                       jLabel25.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       rec_amnt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel25.setEnabled(true);
                       jLabel25.setForeground(Color.red);
                       jLabel25.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_rec_amntFocusLost

    private void rec_invFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_invFocusLost

         if(rec_inv.getText().length()==0)
      {
          rec_inv.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           rec_inv.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           i=1;
      }
    }//GEN-LAST:event_rec_invFocusLost

    private void rec_ledgerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_ledgerFocusLost

        if(rec_ledger.getSelectedItem().toString()== null)
      {
          rec_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel17.setEnabled(true);
          jLabel17.setForeground(Color.red);
          jLabel17.setVisible(true);
             
      }  
      else
      {
           rec_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel17.setEnabled(false);  
           jLabel17.setVisible(false);
           k=1;
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_rec_ledgerFocusLost

    private void rec_ledger2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_ledger2FocusLost
                     if(rec_ledger2.getSelectedItem().equals(""))
      {
          rec_ledger2.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel21.setEnabled(true);
          jLabel21.setForeground(Color.red);
          jLabel21.setVisible(true);
             
      }  
      else
      {
           rec_ledger2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel21.setEnabled(false);  
           jLabel21.setVisible(false);
           l=1;
      }
    }//GEN-LAST:event_rec_ledger2FocusLost

    private void rec_balanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rec_balanceFocusLost
     if(rec_balance.getText().length()==0)
                   {
                       rec_balance.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel19.setEnabled(false);  
                       jLabel19.setVisible(false);
                       y=0;
                       
                   }
                   else
                   {
                       String content = rec_balance.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       rec_balance.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel19.setEnabled(false);  
                       jLabel19.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       rec_balance.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel19.setEnabled(true);
                       jLabel19.setForeground(Color.red);
                       jLabel19.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_rec_balanceFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private numeric.textField.NumericTextField rec_amnt;
    private javax.swing.JTextField rec_amnt_words;
    private numeric.textField.NumericTextField rec_balance;
    private javax.swing.JTextField rec_bank_name;
    private javax.swing.JTextField rec_br_name;
    private javax.swing.JTextField rec_c_name;
    private numeric.textField.NumericTextField rec_cheque_no;
    private javax.swing.JTextField rec_date;
    private javax.swing.JTextField rec_inv;
    private javax.swing.JComboBox rec_ledger;
    private javax.swing.JComboBox rec_ledger2;
    private javax.swing.JTextField rec_received_for;
    private javax.swing.JComboBox rec_ref_no;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
}
