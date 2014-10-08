package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JComponent;
import static javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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
public class payment_create_panel extends javax.swing.JPanel {
 Font myFont = new Font("",Font.PLAIN,9);
 int i=0,j=0,k=0,l=0,m=0;    // For Mandatory
 int x=0,y=0,z=0;           // For Non Mandatory
    /**
     * Creates new form payment_create_panel
     */
    public payment_create_panel() {
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
        
        jLabel23.setFont(myFont);
        jLabel23.setEnabled(false);
        jLabel23.setVisible(false);
        
        jLabel22.setFont(myFont);
        jLabel22.setEnabled(false);
        jLabel22.setVisible(false);
        
        jLabel24.setFont(myFont);
        jLabel24.setEnabled(false);
        jLabel24.setVisible(false);
        
        jLabel25.setFont(myFont);
        jLabel25.setEnabled(false);
        jLabel25.setVisible(false);
        
        
        
        PromptSupport.setPrompt("dd/mm/yyyy", pay_date);
        PromptSupport.setPrompt("John Smith", customer_name_txt);
        PromptSupport.setPrompt("123456", cheque_no_txt);
        PromptSupport.setPrompt("0.00", balance_txt);
        PromptSupport.setPrompt("BANK", bank_name_txt);
        PromptSupport.setPrompt("BRANCH", branch_name_txt);
        PromptSupport.setPrompt("0.00", total_amount_txt);
        PromptSupport.setPrompt("One Two Three Only", amount_in_word_txt);
        PromptSupport.setPrompt("xyz", payment_for_txt);
 
        
        
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct l_name from ledger order by l_id");
            while(rs1.next())
            {
                String name=rs1.getString("l_name");
                ledger.addItem(name);
                payment_ledger.addItem(name);
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
         
                        if(pay_invoice_txt.getText().length()==0)
      {
          pay_invoice_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           pay_invoice_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           i=1;
      }
     }
     
     // date
     
     public void date(){
             if(pay_date.getText().length()==0)
       {
             pay_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel25.setEnabled(true);
             jLabel25.setForeground(Color.red);
             jLabel25.setVisible(true);
           
       }
       else
       {
           
       
                 String content = pay_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
                 System.out.println(matchFound);
                 pay_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel25.setEnabled(false);  
                 jLabel25.setVisible(false);
                 j=1;
          
          if(!matchFound)
          { 
             pay_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel25.setEnabled(true);
             jLabel25.setForeground(Color.red);
             jLabel25.setVisible(true);
          }
       }
     }
 
    // ledger
     
     public void ledger(){
                if(ledger.getSelectedItem().equals(""))
      {
          ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel17.setEnabled(true);
          jLabel17.setForeground(Color.red);
          jLabel17.setVisible(true);
             
      }  
      else
      {
           ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel17.setEnabled(false);  
           jLabel17.setVisible(false);
           k=1;
      }
     }
 
    // payment
     
     public void payment(){
                     if(payment_ledger.getSelectedItem().equals(""))
      {
          payment_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
             
      }  
      else
      {
           payment_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           l=1;
      }
         
     }
     
     // amount
     
     public void amt(){
                       if(total_amount_txt.getText().length()==0)
                   {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                   }
                   else
                   {
                       String content = total_amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel24.setEnabled(false);  
                       jLabel24.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
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

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pay_invoice_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        customer_name_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ledger = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        reference_no = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        balance_txt = new numeric.textField.NumericTextField();
        jLabel7 = new javax.swing.JLabel();
        payment_ledger = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        bank_name_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cheque_no_txt = new numeric.textField.NumericTextField();
        jLabel10 = new javax.swing.JLabel();
        amount_in_word_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        branch_name_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        total_amount_txt = new numeric.textField.NumericTextField();
        jLabel13 = new javax.swing.JLabel();
        payment_for_txt = new javax.swing.JTextField();
        reset_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pay_date = new javax.swing.JTextField();
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

        jLabel14.setText("*Invoice No.:");

        pay_invoice_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pay_invoice_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pay_invoice_txtFocusLost(evt);
            }
        });

        jLabel2.setText("Customer Name:");

        customer_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customer_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                customer_name_txtFocusLost(evt);
            }
        });

        jLabel4.setText("*Ledger:");

        ledger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        ledger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ledger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ledgerFocusLost(evt);
            }
        });

        jLabel5.setText("Reference No:");

        reference_no.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        reference_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("Balance:");

        balance_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        balance_txt.setText("numericTextField1");
        balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                balance_txtFocusLost(evt);
            }
        });

        jLabel7.setText("*Payment Ledger:");

        payment_ledger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        payment_ledger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        payment_ledger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                payment_ledgerFocusLost(evt);
            }
        });

        jLabel8.setText("Bank Name:");

        bank_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel9.setText("Cheque No:");

        cheque_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        cheque_no_txt.setText("numericTextField1");
        cheque_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cheque_no_txtFocusLost(evt);
            }
        });

        jLabel10.setText("Amount in words:");

        amount_in_word_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setText("Branch Name:");

        branch_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        branch_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_name_txtActionPerformed(evt);
            }
        });

        jLabel12.setText("*Total Amount:");

        total_amount_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        total_amount_txt.setText("numericTextField1");
        total_amount_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_amount_txtActionPerformed(evt);
            }
        });
        total_amount_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                total_amount_txtFocusLost(evt);
            }
        });

        jLabel13.setText("Payment For:");

        payment_for_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        reset_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        reset_button.setText("RESET");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        submit_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        submit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        submit_button.setText("SUBMIT");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jLabel3.setText("*Date:");

        pay_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pay_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pay_dateFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("PAYMENT FORM");

        jLabel15.setText("Enter Valid Invoice No.!");

        jLabel16.setText("Enter Customer Name!");

        jLabel17.setText("Select Ledger!");

        jLabel18.setText("Select Reference No.!");

        jLabel19.setText("Enter Balance!");

        jLabel20.setText("Select Payment Ledger!");

        jLabel21.setText("Enter Bank Name!");

        jLabel22.setText("Enter Bank Branch Name!");

        jLabel23.setText("Enter Valid Cheque No.!");

        jLabel24.setText("Enter Total Number!");

        jLabel25.setText("Enter Valid Date Format!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cheque_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(amount_in_word_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pay_invoice_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bank_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pay_date, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(24, 24, 24)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(total_amount_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(payment_for_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(107, 107, 107)
                                            .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(reset_button)
                                .addGap(18, 18, 18)
                                .addComponent(submit_button))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment_ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(pay_invoice_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(pay_date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customer_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(payment_ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bank_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cheque_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(total_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(amount_in_word_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(payment_for_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submit_button))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void branch_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branch_name_txtActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        customer_name_txt.setText("");
        pay_date.setText("");
        balance_txt.setText("");
        bank_name_txt.setText("");
        cheque_no_txt.setText("");
        amount_in_word_txt.setText("");
        branch_name_txt.setText("");
        total_amount_txt.setText("");
        payment_for_txt.setText("");
        pay_invoice_txt.setText("");
        ledger.setSelectedIndex(0);
        payment_ledger.setSelectedIndex(0);
        
        pay_invoice_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pay_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        payment_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel15.setVisible(false);
        jLabel25.setVisible(false);
        jLabel17.setVisible(false);
        jLabel20.setVisible(false);
        jLabel24.setVisible(false);

       //total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed

  
        
        
        invoice();
        date();
        ledger();
        payment();
        amt();
       

      if(i==1&&j==1&&k==1&&l==1&&m==1&&x==0&&y==0&&z==0)

{   
                
        try
            {
                
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        
            PreparedStatement ps=con.prepareStatement("insert into payment(pay_c_name, pay_date, pay_ledger, pay_ref_no, pay_balance, pay_ledger1, pay_bank_name, pay_branch_name, pay_cheque_no, pay_total_amnt, pay_amnt_words, pay_for, pay_invoice)values('"+customer_name_txt.getText()+"','"+pay_date.getText()+"','"+ledger.getSelectedItem().toString()+"','"+reference_no.getSelectedItem().toString()+"','"+balance_txt.getText()+"','"+payment_ledger.getSelectedItem().toString()+"','"+bank_name_txt.getText()+"','"+branch_name_txt.getText()+"','"+cheque_no_txt.getText()+"','"+total_amount_txt.getText()+"','"+amount_in_word_txt.getText()+"','"+payment_for_txt.getText()+"','"+pay_invoice_txt.getText()+"')");
            
            ps.executeUpdate();
             PreparedStatement psq=con.prepareStatement("insert into company_main_table(ledger, debit, credit, get_id,trans_date)values('"+ledger.getSelectedItem().toString()+"','"+total_amount_txt.getText()+"','0','"+pay_invoice_txt.getText()+"','"+pay_date.getText()+"')");
            
            psq.executeUpdate();
            PreparedStatement psm=con.prepareStatement("insert into company_main_table(ledger, debit, credit, get_id,trans_date)values('"+payment_ledger.getSelectedItem().toString()+"','0','"+total_amount_txt.getText()+"','"+pay_invoice_txt.getText()+"','"+pay_date.getText()+"')");
            
            psm.executeUpdate();
             Statement pss =con.createStatement();
           ResultSet rss=pss.executeQuery("select  l_under from ledger where l_name='"+ledger.getSelectedItem().toString()+"'");
          while(rss.next())
          {
              String under=rss.getString("l_under");
             PreparedStatement psw=con.prepareStatement("insert into `"+under+"` (l_name,credit,debit,trans_id)values('"+ledger.getSelectedItem().toString()+"','"+total_amount_txt.getText()+"','0','"+pay_invoice_txt.getText()+"')");
          psw.executeUpdate();
              
          }
          Statement pssw =con.createStatement();
           ResultSet rssw=pssw.executeQuery("select  l_under from ledger where l_name='"+payment_ledger.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under1=rssw.getString("l_under");
             PreparedStatement pswm=con.prepareStatement("insert into `"+under1+"` (l_name,credit,debit,trans_id)values('"+payment_ledger.getSelectedItem().toString()+"','0','"+total_amount_txt.getText()+"','"+pay_invoice_txt.getText()+"')");
          pswm.executeUpdate();
              
          }
            System.out.println("Payment Done");
            
            jOptionPane1.showMessageDialog(this,"Payment Done");
            
            customer_name_txt.setText("");
            pay_date.setText("");
            balance_txt.setText("");
            bank_name_txt.setText("");
            cheque_no_txt.setText("");
            amount_in_word_txt.setText("");
            branch_name_txt.setText("");
            total_amount_txt.setText("");
            payment_for_txt.setText("");
            pay_invoice_txt.setText("");
            
            }
            catch (SQLException e)
            {
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
            System.out.println("ClassNotFoundException" + ce.toString());
            }
                    }
      else{
          //jOptionPane1.showMessageDialog(this,"Payment not Done");
      }
          
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void pay_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pay_dateFocusLost
          if(pay_date.getText().length()==0)
       {
             pay_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel25.setEnabled(true);
             jLabel25.setForeground(Color.red);
             jLabel25.setVisible(true);
           
       }
       else
       {
           
       
                 String content = pay_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
                 System.out.println(matchFound);
                 pay_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel25.setEnabled(false);  
                 jLabel25.setVisible(false);
                 j=1;
          
          if(!matchFound)
          { 
             pay_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel25.setEnabled(true);
             jLabel25.setForeground(Color.red);
             jLabel25.setVisible(true);
          }
       }
    }//GEN-LAST:event_pay_dateFocusLost

    private void customer_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customer_name_txtFocusLost
   if(customer_name_txt.getText().length()==0)
                            {
                                customer_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                jLabel16.setEnabled(false);  
                                jLabel16.setVisible(false);
                                x=0;
                                
                            }
                            else
                            {
                                 String email =customer_name_txt.getText();
                                 String regEx1 = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$";
                                 Pattern p1 = Pattern.compile(regEx1);
                                 Matcher m1 = p1.matcher(email);
                                 customer_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                 jLabel16.setEnabled(false);  
                                 jLabel16.setVisible(false);
                                 x=0;
                       
                               if(m1.find()==false)
                             {
                                 x=1;
                               customer_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                               jLabel16.setEnabled(true);
                               jLabel16.setForeground(Color.red);
                               jLabel16.setVisible(true);

                             }
                           }
    }//GEN-LAST:event_customer_name_txtFocusLost

    private void total_amount_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_total_amount_txtFocusLost
                       
                    if(total_amount_txt.getText().length()==0)
                   {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                   }
                   else
                   {
                       String content = total_amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel24.setEnabled(false);  
                       jLabel24.setVisible(false);
                       m=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                    }
                   }
                           
    }//GEN-LAST:event_total_amount_txtFocusLost

    private void cheque_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cheque_no_txtFocusLost
        if(cheque_no_txt.getText().length()==0)
                   {
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel23.setEnabled(false);  
                        jLabel23.setVisible(false);
                        z=0;
                       
                   }
                   else
                   {
                        String pin = cheque_no_txt.getText();
                        String regEx = "\\d{6}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel23.setEnabled(false);  
                        jLabel23.setVisible(false);
                        z=0;
                      if(m.find()==false)
                    {
                        z=1;
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                        jLabel23.setEnabled(true);
                        jLabel23.setForeground(Color.red);
                        jLabel23.setVisible(true);
                       
                    }
                      
                   }
    }//GEN-LAST:event_cheque_no_txtFocusLost

    private void pay_invoice_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pay_invoice_txtFocusLost
      
                        if(pay_invoice_txt.getText().length()==0)
      {
          pay_invoice_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           pay_invoice_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           i=1;
      }
    }//GEN-LAST:event_pay_invoice_txtFocusLost

    private void total_amount_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_amount_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_amount_txtActionPerformed

    private void ledgerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ledgerFocusLost
               if(ledger.getSelectedItem().equals(""))
      {
          ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel17.setEnabled(true);
          jLabel17.setForeground(Color.red);
          jLabel17.setVisible(true);
             
      }  
      else
      {
           ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel17.setEnabled(false);  
           jLabel17.setVisible(false);
           k=1;
      }
    }//GEN-LAST:event_ledgerFocusLost

    private void balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_balance_txtFocusLost
                  if(balance_txt.getText().length()==0)
                   {
                       balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel19.setEnabled(false);  
                       jLabel19.setVisible(false);
                       y=0;
                       
                   }
                   else
                   {
                       String content = balance_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel19.setEnabled(false);  
                       jLabel19.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       balance_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel19.setEnabled(true);
                       jLabel19.setForeground(Color.red);
                       jLabel19.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_balance_txtFocusLost

    private void payment_ledgerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_payment_ledgerFocusLost
                 if(payment_ledger.getSelectedItem().equals(""))
      {
          payment_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
             
      }  
      else
      {
           payment_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           l=1;
      }
    }//GEN-LAST:event_payment_ledgerFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_in_word_txt;
    private numeric.textField.NumericTextField balance_txt;
    private javax.swing.JTextField bank_name_txt;
    private javax.swing.JTextField branch_name_txt;
    private numeric.textField.NumericTextField cheque_no_txt;
    private javax.swing.JTextField customer_name_txt;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox ledger;
    private javax.swing.JTextField pay_date;
    private javax.swing.JTextField pay_invoice_txt;
    private javax.swing.JTextField payment_for_txt;
    private javax.swing.JComboBox payment_ledger;
    private javax.swing.JComboBox reference_no;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    private numeric.textField.NumericTextField total_amount_txt;
    // End of variables declaration//GEN-END:variables
}
