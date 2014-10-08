package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
public class payment_edit_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
 int i=0,j=0,k=0,l=0,m=0;    // For Mandatory
 int x=0,y=0,z=0;           // For Non Mandatory
  String  table_click,a3,a6;
    /**
     * Creates new form payment_edit_panel
     */
    public payment_edit_panel() 
    {
        initComponents();
        PromptSupport.setPrompt("dd/mm/yyyy", date_txt);
        PromptSupport.setPrompt("John Smith", customer_name_txt);
        PromptSupport.setPrompt("123456", cheque_no_txt);
        PromptSupport.setPrompt("0.00", balance_txt);
        PromptSupport.setPrompt("BANK", bank_name_txt);
        PromptSupport.setPrompt("BRANCH", branch_name_txt);
        PromptSupport.setPrompt("0.00", total_amount_txt);
        PromptSupport.setPrompt("One Two Three Only", amount_in_word_txt);
        PromptSupport.setPrompt("xyz", payment_for_txt);
        
        jLabel14.setFont(myFont);
        jLabel14.setEnabled(false);
        jLabel14.setVisible(false);
        
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
        
        jLabel24.setFont(myFont);
        jLabel24.setEnabled(false);
        jLabel24.setVisible(false);
        
         
      jTextField1.setVisible(false);
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con1.createStatement();
            ResultSet rs=ps.executeQuery("select distinct l_name from ledger order by l_id");
                      
            while(rs.next())
            {
                String name=rs.getString("l_name");

                under_combo.addItem(name);
                pay_combo.addItem(name);
            }
            
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
                       
        update_table();
        search();
        
        payment_table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"enter");
        payment_table.getActionMap().put("enter", new AbstractAction() 
        {
        public void actionPerformed(ActionEvent e) 
        {
            //action to be performed
        }
        });
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
 
 
  
     
     // date
     
     public void date(){
             if(date_txt.getText().length()==0)
       {
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
           
       }
       else
       {
           
       
                 String content = date_txt.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
           //      System.out.println(matchFound);
                 date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel15.setEnabled(false);  
                 jLabel15.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
          }
       }
     }
 
    // ledger
     
     public void ledger(){
                if(under_combo.getSelectedItem().equals(""))
      {
          under_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           j=1;
      }
     }
 
    // payment
     
     public void payment(){
                     if(pay_combo.getSelectedItem().equals(""))
      {
          pay_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel19.setEnabled(true);
          jLabel19.setForeground(Color.red);
          jLabel19.setVisible(true);
             
      }  
      else
      {
           pay_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel19.setEnabled(false);  
           jLabel19.setVisible(false);
           k=1;
      }
         
     }
     
     // amount
     
     public void amt(){
                       if(total_amount_txt.getText().length()==0)
                   {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel23.setEnabled(true);
                       jLabel23.setForeground(Color.red);
                       jLabel23.setVisible(true);
                       
                   }
                   else
                   {
                       String content = total_amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel23.setEnabled(false);  
                       jLabel23.setVisible(false);
                       l=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel23.setEnabled(true);
                       jLabel23.setForeground(Color.red);
                       jLabel23.setVisible(true);
                       
                    }
                   }
                           
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void search()
    {
       search_txt.addKeyListener(new java.awt.event.KeyAdapter()

       {

        public void keyReleased(java.awt.event.KeyEvent e)

        {
        String s1=search_txt.getText();
        String s3=s1;
     
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
        Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
        ResultSet rs=ps.executeQuery("SELECT pay_invoice as INVOICE_NO from payment where pay_invoice like '"+s3+"%'"); 


         payment_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        }catch (SQLException e1){
        System.out.println("Sql Exception" + e1.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
                
        }
     });
    }
    
    
    public void update_table()
    { 
       
        try{
        
               Class.forName("com.mysql.jdbc.Driver");
               String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
               Connection con = (Connection) DriverManager.getConnection(ConnUrl);
               Statement ps =con.createStatement();
               ResultSet rs=ps.executeQuery("SELECT pay_invoice as INVOICE_NO from payment");
               payment_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

               System.out.println("Done");
          
         
            }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
        
        payment_table.addKeyListener(new java.awt.event.KeyAdapter()

            {

            public void keyReleased(java.awt.event.KeyEvent e)

            {

            int keyvalue=e.getKeyCode();
            if(keyvalue==KeyEvent.VK_ENTER)
                            {
                                                                
                             int row=payment_table.getSelectedRow();
                             int col=payment_table.getSelectedColumn();

                            if(payment_table.getValueAt(row, 0) != null){
                           table_click= (String)payment_table.getValueAt(row, 0);


            //JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ "" +table.getValueAt(0,(table.getSelectedColumn())).toString());

            System.out.println(" Value in the row clicked :"+ " " +row+"");
            System.out.println(" Value in the col clicked :"+ " " +col+"");
           // System.out.println(" Value in the col,row clicked :"+ " " +s1+"");

          try{
         
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            Statement ps2 =con1.createStatement();
            ResultSet rs1 =ps1.executeQuery("SELECT * from payment where pay_invoice='"+table_click+"' ");
            while(rs1.next())
                {
                
                String  aa=rs1.getString("pay_invoice");
                jTextField1.setText(aa);
                
                String a1=rs1.getString("pay_c_name");
                customer_name_txt.setText(a1);

                String a2=rs1.getString("pay_date");
                date_txt.setText(a2);
                
                a3=rs1.getString("pay_ledger");
                under_combo.setSelectedItem(a3);
                
                String a4=rs1.getString("pay_ref_no");
                ref_combo.addItem(a4);
                ref_combo.setSelectedItem(a4);
                
                String a5=rs1.getString("pay_balance");
                balance_txt.setText(a5);

                 a6=rs1.getString("pay_ledger1");
                pay_combo.setSelectedItem(a6);
                                
                String a8=rs1.getString("pay_bank_name");
                bank_name_txt.setText(a8);
                
                String a9=rs1.getString("pay_branch_name");
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString("pay_cheque_no");
                cheque_no_txt.setText(a10);
                
                String a11=rs1.getString("pay_total_amnt");
                total_amount_txt.setText(a11);
                
                String a12=rs1.getString("pay_amnt_words");
                amount_in_word_txt.setText(a12);
                
                String a13=rs1.getString("pay_for");
                payment_for_txt.setText(a13);
                
                }
       
          
         
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }

                }  }

        }

        }

        );
            Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        };


        }
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
            
            
            int new1=payment_table.getSelectedRow();
            table_click=(payment_table.getModel().getValueAt(new1, 0).toString());
            
            try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from payment where pay_invoice='"+table_click+"' ");
            //jComboBox1.removeAll();
       
           while(rs1.next())
                {
                String  aa=rs1.getString("pay_invoice");
                jTextField1.setText(aa);
                                             
                String a1=rs1.getString("pay_c_name");
                customer_name_txt.setText(a1);

                String a2=rs1.getString("pay_date");
                date_txt.setText(a2);
                
                 a3=rs1.getString("pay_ledger");
                under_combo.setSelectedItem(a3);
                
                
                String a4=rs1.getString("pay_ref_no");
                ref_combo.addItem(a4);
                ref_combo.setSelectedItem(a4);
                
                String a5=rs1.getString("pay_balance");
                balance_txt.setText(a5);

                 a6=rs1.getString("pay_ledger1");
                pay_combo.setSelectedItem(a6);
                                
                String a8=rs1.getString("pay_bank_name");
                bank_name_txt.setText(a8);
                
                String a9=rs1.getString("pay_branch_name");
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString("pay_cheque_no");
                cheque_no_txt.setText(a10);
                
                String a11=rs1.getString("pay_total_amnt");
                total_amount_txt.setText(a11);
                
                String a12=rs1.getString("pay_amnt_words");
                amount_in_word_txt.setText(a12);
                
                String a13=rs1.getString("pay_for");
                payment_for_txt.setText(a13);
                
                }
       
          
          //jComboBox1.removeAll();
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }
    
                                     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customer_name_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ref_combo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pay_combo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        bank_name_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        branch_name_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        amount_in_word_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        payment_for_txt = new javax.swing.JTextField();
        date_txt = new javax.swing.JTextField();
        under_combo = new javax.swing.JComboBox();
        total_amount_txt = new numeric.textField.NumericTextField();
        balance_txt = new numeric.textField.NumericTextField();
        cheque_no_txt = new numeric.textField.NumericTextField();
        jLabel14 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payment_table = new javax.swing.JTable();
        search_txt = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Payment Edit/Delete");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        save_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Save-icon.png"))); // NOI18N
        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Recycle-Bin-full-icon.png"))); // NOI18N
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(delete_button)
                .addGap(18, 18, 18)
                .addComponent(clear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Customer Name:");

        customer_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customer_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                customer_name_txtFocusLost(evt);
            }
        });

        jLabel3.setText("*Date:");

        jLabel4.setText("*Ledger:");

        jLabel5.setText("Reference No:");

        ref_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        ref_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("Balance:");

        jLabel7.setText("*Payment Ledger:");

        pay_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        pay_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pay_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pay_comboFocusLost(evt);
            }
        });

        jLabel8.setText("Bank Name:");

        bank_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel9.setText("Branch Name:");

        branch_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel10.setText("Cheque No:");

        jLabel11.setText("*Total Amount:");

        jLabel12.setText("Amount in Words:");

        amount_in_word_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel13.setText("Payment For:");

        payment_for_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        date_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        date_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                date_txtFocusLost(evt);
            }
        });

        under_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                under_comboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                under_comboFocusLost(evt);
            }
        });

        total_amount_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        total_amount_txt.setText("numericTextField1");
        total_amount_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                total_amount_txtFocusLost(evt);
            }
        });

        balance_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        balance_txt.setText("numericTextField1");
        balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                balance_txtFocusLost(evt);
            }
        });

        cheque_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        cheque_no_txt.setText("numericTextField1");
        cheque_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cheque_no_txtFocusLost(evt);
            }
        });

        jLabel14.setText("Enter Customer Name!");

        jLabel15.setText("Enter Valid Date Format!");

        jLabel16.setText("Select Ledger!");

        jLabel17.setText("Select Reference No!");

        jLabel18.setText("Enter Valid Balance!");

        jLabel19.setText("Select Payment Ledger!");

        jLabel20.setText("Enter Bank Name!");

        jLabel21.setText("Enter Branch Name!");

        jLabel22.setText("Enter Valid Cheque No!");

        jLabel23.setText("Enter Total Amount!");

        jLabel24.setText("Enter Amount in Words!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customer_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bank_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount_in_word_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payment_for_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pay_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(under_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cheque_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customer_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(under_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ref_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pay_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bank_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cheque_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(total_amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount_in_word_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment_for_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        payment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        payment_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(payment_table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
if(date_txt.getText().equals(""))
     {
           JOptionPane.showMessageDialog(this,"Select Invoice No!"); 
     }
 else{
        date();
        ledger();
        payment();
        amt();
        if(i==1&&j==1&&k==1&&l==1&&x==0&&y==0&&z==0)
        {
  
        String invoice = jTextField1.getText();
        
        if (invoice!="")
      {  
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            
             Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);
             Statement ps5 =con2.createStatement(); 
             PreparedStatement ps1=con2.prepareStatement("update payment set pay_c_name='"+customer_name_txt.getText()+"',pay_date='"+date_txt.getText()+"',pay_ledger='"+under_combo.getSelectedItem()+"',pay_ref_no='"+ref_combo.getSelectedItem()+"',pay_balance='"+balance_txt.getText()+"',pay_ledger1='"+pay_combo.getSelectedItem()+"',pay_bank_name='"+bank_name_txt.getText()+"',pay_branch_name='"+branch_name_txt.getText()+"',pay_cheque_no='"+cheque_no_txt.getText()+"',pay_total_amnt='"+total_amount_txt.getText()+"',pay_amnt_words='"+amount_in_word_txt.getText()+"',pay_for='"+payment_for_txt.getText()+"' where pay_invoice='"+jTextField1.getText()+"'");
             ps1.executeUpdate();
             PreparedStatement psm=con2.prepareStatement("update company_main_table set ledger='"+under_combo.getSelectedItem().toString()+"',trans_date='"+date_txt.getText()+"',debit='"+total_amount_txt.getText()+"' where pay_invoice='"+jTextField1.getText()+"' and credit='0'");
             psm.executeUpdate();
              PreparedStatement psg=con2.prepareStatement("update company_main_table set ledger='"+pay_combo.getSelectedItem().toString()+"',trans_date='"+date_txt.getText()+"',credit='"+total_amount_txt.getText()+"' where pay_invoice='"+jTextField1.getText()+"' and debit='0'");
             psg.executeUpdate();
             /////
             
             
             Statement pssw =con2.createStatement();
                   Statement pssw1 =con2.createStatement();
                 Statement smt1 =con2.createStatement();
                 Statement pssws =con2.createStatement();
                   Statement pssw11 =con2.createStatement();
                 Statement smt11 =con2.createStatement();
                 //Ledger
                  ResultSet rssw1=pssw1.executeQuery("select  l_under from ledger where l_name='"+a3+"'");
          while(rssw1.next())
          {
               String under2=rssw1.getString("l_under");
               smt1.executeUpdate("delete from `"+under2+"` where l_name='"+a3+"' and trans_id='"+jTextField1.getText()+"'");
          }
          
           ResultSet rssw=pssw.executeQuery("select  l_under from ledger where l_name='"+under_combo.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under=rssw.getString("l_under");
              
             PreparedStatement psw=con2.prepareStatement("insert into `"+under+"` (l_name,debit,credit,trans_id)values('"+under_combo.getSelectedItem().toString()+"','"+total_amount_txt.getText()+"','0','"+table_click+"')");
          psw.executeUpdate();
             
          }
          //payment_ledger
                            ResultSet rssw11=pssw1.executeQuery("select  l_under from ledger where l_name='"+a6+"'");

          while(rssw11.next())
          {
               String under2=rssw11.getString("l_under");
               smt11.executeUpdate("delete from `"+under2+"` where l_name='"+a6+"' and trans_id='"+jTextField1.getText()+"'");
          }
          
           ResultSet rssw111=pssw11.executeQuery("select  l_under from ledger where l_name='"+pay_combo.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under=rssw.getString("l_under");
              
             PreparedStatement psw=con2.prepareStatement("insert into `"+under+"` (l_name,credit,debit,trans_id)values('"+pay_combo.getSelectedItem().toString()+"','"+total_amount_txt.getText()+"','0','"+table_click+"')");
          psw.executeUpdate();
             
          } 
 
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        customer_name_txt.setText(null);
        date_txt.setText(null);
        under_combo.setSelectedItem(null);
        ref_combo.removeAllItems();
        balance_txt.setText(null);
        pay_combo.setSelectedItem(null);
        bank_name_txt.setText(null);
        branch_name_txt.setText(null);
        cheque_no_txt.setText(null);
        total_amount_txt.setText(null);
        amount_in_word_txt.setText(null);
        payment_for_txt.setText(null);
        
        jOptionPane1.showMessageDialog(this,"Payment Details Updated");
        jTextField1.setText(null);
        search_txt.setText(null);
        update_table();
      }
      else
      {
      jOptionPane1.showMessageDialog(this,"Select an Invoice Number");
      }

        search_txt.setText(null);
        update_table();
                    
                   
        }
}
     
       
    }//GEN-LAST:event_save_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
       
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
Statement smt11 =con1.createStatement();
  Statement smt12 =con1.createStatement();
  Statement pq =con1.createStatement();
  Statement pr =con1.createStatement();
                PreparedStatement ps1=con1.prepareStatement("delete from payment where pay_invoice='"+jTextField1.getText()+"'");

                ps1.executeUpdate();
          
         //ledger delete
          ResultSet rp=pq.executeQuery("select  l_under from ledger where l_name='"+under_combo.getSelectedItem().toString()+"'");
          while(rp.next())
          {
              String under=rp.getString("l_under");
         smt11.executeUpdate("delete from `"+under+"` where trans_id='"+jTextField1.getText()+"'");
          }
          //receipt _ledger delete
           ResultSet rw=pr.executeQuery("select  l_under from ledger where l_name='"+pay_combo.getSelectedItem().toString()+"'");
          while(rw.next())
          {
              String unders=rw.getString("l_under");
         smt12.executeUpdate("delete from `"+unders+"` where trans_id='"+jTextField1.getText()+"'");
          }
                System.out.println("Done");

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            
        jOptionPane1.showMessageDialog(this,"Payment Details Deleted");
        jTextField1.setText(null);
        search_txt.setText(null);
        update_table();

        }

    }//GEN-LAST:event_delete_buttonActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
        search_txt.setText(null);
        update_table();
        
        jTextField1.setText(null);
        customer_name_txt.setText(null);
        date_txt.setText(null);
        under_combo.setSelectedItem(null);
        ref_combo.removeAllItems();
        balance_txt.setText(null);
        pay_combo.setSelectedItem(null);
        bank_name_txt.setText(null);
        branch_name_txt.setText(null);
        cheque_no_txt.setText(null);
        total_amount_txt.setText(null);
        amount_in_word_txt.setText(null);
        payment_for_txt.setText(null);
        
        date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customer_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pay_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel19.setVisible(false);
        jLabel23.setVisible(false);
        
        
        
    }//GEN-LAST:event_clearActionPerformed

    private void under_comboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_under_comboFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_under_comboFocusGained

    private void customer_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customer_name_txtFocusLost
     if(customer_name_txt.getText().length()==0)
                            {
                                customer_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                jLabel14.setEnabled(false);  
                                jLabel14.setVisible(false);
                                x=0;
                                
                            }
                            else
                            {
                                 String email =customer_name_txt.getText();
                                 String regEx1 = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$";
                                 Pattern p1 = Pattern.compile(regEx1);
                                 Matcher m1 = p1.matcher(email);
                                 customer_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                 jLabel14.setEnabled(false);  
                                 jLabel14.setVisible(false);
                                 x=0;
                       
                               if(m1.find()==false)
                             {
                                 x=1;
                               customer_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                               jLabel14.setEnabled(true);
                               jLabel14.setForeground(Color.red);
                               jLabel14.setVisible(true);

                             }
                           }
    }//GEN-LAST:event_customer_name_txtFocusLost

    private void date_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_txtFocusLost
            if(date_txt.getText().length()==0)
       {
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
           
       }
       else
       {
           
       
                 String content = date_txt.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
           //      System.out.println(matchFound);
                 date_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel15.setEnabled(false);  
                 jLabel15.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             date_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
          }
       }
    }//GEN-LAST:event_date_txtFocusLost

    private void cheque_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cheque_no_txtFocusLost
    if(cheque_no_txt.getText().length()==0)
                   {
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel22.setEnabled(false);  
                        jLabel22.setVisible(false);
                        z=0;
                       
                   }
                   else
                   {
                        String pin = cheque_no_txt.getText();
                        String regEx = "\\d{6}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel22.setEnabled(false);  
                        jLabel22.setVisible(false);
                        z=0;
                      if(m.find()==false)
                    {
                        z=1;
                        cheque_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                        jLabel22.setEnabled(true);
                        jLabel22.setForeground(Color.red);
                        jLabel22.setVisible(true);
                       
                    }
                      
                   }
    }//GEN-LAST:event_cheque_no_txtFocusLost

    private void total_amount_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_total_amount_txtFocusLost
           if(total_amount_txt.getText().length()==0)
                   {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel23.setEnabled(true);
                       jLabel23.setForeground(Color.red);
                       jLabel23.setVisible(true);
                       
                   }
                   else
                   {
                       String content = total_amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel23.setEnabled(false);  
                       jLabel23.setVisible(false);
                       l=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       total_amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel23.setEnabled(true);
                       jLabel23.setForeground(Color.red);
                       jLabel23.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_total_amount_txtFocusLost

    private void under_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_under_comboFocusLost
               if(under_combo.getSelectedItem().equals(""))
      {
          under_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           j=1;
      }
    }//GEN-LAST:event_under_comboFocusLost

    private void pay_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pay_comboFocusLost
                     if(pay_combo.getSelectedItem().equals(""))
      {
          pay_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel19.setEnabled(true);
          jLabel19.setForeground(Color.red);
          jLabel19.setVisible(true);
             
      }  
      else
      {
           pay_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel19.setEnabled(false);  
           jLabel19.setVisible(false);
           k=1;
      }
    }//GEN-LAST:event_pay_comboFocusLost

    private void balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_balance_txtFocusLost
         if(balance_txt.getText().length()==0)
                   {
                       balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel18.setEnabled(false);  
                       jLabel18.setVisible(false);
                       y=0;
                       
                   }
                   else
                   {
                       String content = balance_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel18.setEnabled(false);  
                       jLabel18.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       balance_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel18.setEnabled(true);
                       jLabel18.setForeground(Color.red);
                       jLabel18.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_balance_txtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_in_word_txt;
    private numeric.textField.NumericTextField balance_txt;
    private javax.swing.JTextField bank_name_txt;
    private javax.swing.JTextField branch_name_txt;
    private numeric.textField.NumericTextField cheque_no_txt;
    private javax.swing.JButton clear;
    private javax.swing.JTextField customer_name_txt;
    private javax.swing.JTextField date_txt;
    private javax.swing.JButton delete_button;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox pay_combo;
    private javax.swing.JTextField payment_for_txt;
    private javax.swing.JTable payment_table;
    private javax.swing.JComboBox ref_combo;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private numeric.textField.NumericTextField total_amount_txt;
    private javax.swing.JComboBox under_combo;
    // End of variables declaration//GEN-END:variables
}
