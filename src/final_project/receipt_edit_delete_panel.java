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
 * @author pc2
 */
public class receipt_edit_delete_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
      int i=0,j=0,k=0,l=0;    // For Mandatory
      int x=0,y=0,z=0;           // For Non Mandatory
String table_click,a2,a5;
    /**
     * Creates new form receipt_edit_delete_panel
     */
    public receipt_edit_delete_panel() {
        initComponents();
        
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
        
      
        
        PromptSupport.setPrompt("dd/mm/yyyy", receipt_date);
        PromptSupport.setPrompt("John Smith", name_txt);
        PromptSupport.setPrompt("123456", cheque_no_txt);
        PromptSupport.setPrompt("0.00", balance_txt);
        PromptSupport.setPrompt("BANK", bank_name_txt);
        PromptSupport.setPrompt("BRANCH", branch_name_txt);
        PromptSupport.setPrompt("0.00", amount_txt);
        PromptSupport.setPrompt("One Two Three Only", amount_in_word_txt);
        PromptSupport.setPrompt("xyz", received_for_txt);
      
        search();
        update_table();
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"enter");
        table.getActionMap().put("enter", new AbstractAction() 
        {
        public void actionPerformed(ActionEvent e) 
        {
            //action to be performed
        }

            
        });
        rec_id.setVisible(false);
//        receipt_ledger.setVisible(false);
//        reference_no.setVisible(false);
      //  ledger.setVisible(false);
          try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con1.createStatement();
            ResultSet rs=ps.executeQuery("select distinct l_name from ledger order by l_id");
            receipt_ledger.removeAll();
            while(rs.next())
            {
                String name=rs.getString("l_name");

                ledger.addItem(name);
                receipt_ledger.addItem(name);
               // ledger.removeAll();
            }
            ledger.removeAll();
               receipt_ledger.removeAll();
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
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
   // Validation.....
      
         // date
     
     public void date(){
             if(receipt_date.getText().length()==0)
       {
             receipt_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
           
       }
       else
       {
           
       
                 String content = receipt_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
           //      System.out.println(matchFound);
                 receipt_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel15.setEnabled(false);  
                 jLabel15.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             receipt_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
          }
       }
     }
 
    // ledger
     
     public void ledger(){
                if(ledger.getSelectedItem().equals(""))
      {
          ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           j=1;
      }
     }
 
    // Receipt
     
     public void receipt(){
                     if(receipt_ledger.getSelectedItem().equals(""))
      {
          receipt_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
             
      }  
      else
      {
           receipt_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           k=1;
      }
         
     }
     
     // amount
     
     public void amt(){
                       if(amount_txt.getText().length()==0)
                   {
                       amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                   }
                   else
                   {
                       String content = amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel24.setEnabled(false);  
                       jLabel24.setVisible(false);
                       l=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                    }
                   }
                           
     }
             public void update_table()
{ 
       
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("SELECT rec_invoice as INVOICE_NO  from receipt ");
          table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
           
          System.out.println("Done");
          
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        table.addKeyListener(new java.awt.event.KeyAdapter()

            {

public void keyReleased(java.awt.event.KeyEvent e)

{
   
int keyvalue=e.getKeyCode();
if(keyvalue==KeyEvent.VK_ENTER)
                {
                   // jComboBox1.setVisible(false);
//jTextField2.setVisible(true);
                 int row=table.getSelectedRow();
                 int col=table.getSelectedColumn();
                
                if(table.getValueAt(row, 0) != null){
                table_click= (String)table.getValueAt(row, 0);
                
                
//JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ "" +table.getValueAt(0,(table.getSelectedColumn())).toString());

System.out.println(" Value in the row clicked :"+ " " +row+"");
System.out.println(" Value in the col clicked :"+ " " +col+"");
//System.out.println(" Value in the col,row clicked :"+ " " +s1+"");

          try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
          Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from receipt where rec_invoice='"+table_click+"' ");
       while(rs1.next())
                {
                    
                           // jComboBox1.removeAll(); 
                    
               String  id=rs1.getString(1);
                      rec_id.setText(id);
                    
                       
                       String  aa=rs1.getString(2);
                name_txt.setText(aa);
                 
                String a1=rs1.getString(3);
                receipt_date.setText(a1);
              
                 a2=rs1.getString(4);
               ledger.setSelectedItem(a2);

                String a3=rs1.getString(5);
               reference_no.addItem(a3);
                
                String a4=rs1.getString(6);
               balance_txt.setText(a4);
                
                 a5=rs1.getString(7);
                receipt_ledger.setSelectedItem(a5);
                
                String a7=rs1.getString(8);
                bank_name_txt.setText(a7);
                
                String a8=rs1.getString(9);
                branch_name_txt.setText(a8);
                
                String a9=rs1.getString(10);
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString(11);
               cheque_no_txt.setText(a10);
                
                String a11=rs1.getString(12);
                amount_txt.setText(a11);
                
                String a12=rs1.getString(13);
                amount_in_word_txt.setText(a12);
                   
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
    
    public void search(){
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
           ResultSet rs=ps.executeQuery("SELECT rec_invoice as INVOICE_NO  from receipt where rec_invoice like '"+s3+"%'"); 
          
              
                table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
           
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
  private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
ledger.removeAll();
receipt_ledger.removeAll();
      // ledger.setVisible(false);
        //receipt_ledger.setVisible(false);
//ledger_txt.setVisible(true);
//ledger_txt2.setVisible(true);
            int new1=table.getSelectedRow();
            table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from receipt where rec_invoice='"+table_click+"' ");
            //jComboBox1.removeAll();
       while(rs1.next())
                {
                      String  id=rs1.getString(1);
                      rec_id.setText(id);
                    
                       
                       String  aa=rs1.getString(2);
                name_txt.setText(aa);
                 
                String a1=rs1.getString(3);
                receipt_date.setText(a1);
              
                a2=rs1.getString(4);
               
               ledger.setSelectedItem(a2);

                String a3=rs1.getString(5);
                reference_no.addItem(a3);
                
                String a4=rs1.getString(6);
               balance_txt.setText(a4);
                
                 a5=rs1.getString(7);
               receipt_ledger.setSelectedItem(a5);
                
                String a7=rs1.getString(8);
                bank_name_txt.setText(a7);
                
                String a8=rs1.getString(9);
                branch_name_txt.setText(a8);
                
                String a9=rs1.getString(10);
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString(11);
               cheque_no_txt.setText(a10);
                
                String a11=rs1.getString(12);
                amount_txt.setText(a11);
                
                String a12=rs1.getString(13);
                amount_in_word_txt.setText(a12);
                
                }
       
          
          //jComboBox1.removeAll();
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }

// TODO add your handling code here:
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
        jPanel6 = new javax.swing.JPanel();
        rec_id = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ledger = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        reference_no = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        received_for_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        receipt_ledger = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        bank_name_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        branch_name_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        amount_in_word_txt = new javax.swing.JTextField();
        receipt_date = new javax.swing.JTextField();
        balance_txt = new numeric.textField.NumericTextField();
        amount_txt = new numeric.textField.NumericTextField();
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
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Name:");

        name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
            }
        });

        jLabel3.setText("*Date:");

        jLabel4.setText("*Ledger:");

        ledger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        ledger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ledger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ledgerFocusLost(evt);
            }
        });

        jLabel5.setText("Reference No:");

        reference_no.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        reference_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("Balance:");

        jLabel7.setText("Received For:");

        received_for_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel8.setText("*Receipt Ledger:");

        receipt_ledger.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        receipt_ledger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        receipt_ledger.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receipt_ledgerFocusLost(evt);
            }
        });

        jLabel9.setText("Bank Name:");

        bank_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel10.setText("Branch Name:");

        branch_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setText("Cheque No:");

        jLabel12.setText("*Amount:");

        jLabel13.setText("Amount in Words:");

        amount_in_word_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        receipt_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        receipt_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receipt_dateFocusLost(evt);
            }
        });

        balance_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        balance_txt.setText("numericTextField1");
        balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                balance_txtFocusLost(evt);
            }
        });

        amount_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        amount_txt.setText("numericTextField1");
        amount_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amount_txtFocusLost(evt);
            }
        });

        cheque_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        cheque_no_txt.setText("numericTextField1");
        cheque_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cheque_no_txtFocusLost(evt);
            }
        });

        jLabel14.setText("Enter Name!");

        jLabel15.setText("Enter Valid Date Format!");

        jLabel16.setText("Select Ledger!");

        jLabel17.setText("Select Reference No.!");

        jLabel18.setText("Enter Valid Balance!");

        jLabel19.setText("Enter Receipt Name!");

        jLabel20.setText("Select Receipt!");

        jLabel21.setText("Enter Bank Name!");

        jLabel22.setText("Enter Branch Name!");

        jLabel23.setText("Enter Valid Cheque No.!");

        jLabel24.setText("Enter Valid Amount No.!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(received_for_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(bank_name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(amount_in_word_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(receipt_date, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(ledger, 0, 152, Short.MAX_VALUE)
                    .addComponent(receipt_ledger, 0, 152, Short.MAX_VALUE)
                    .addComponent(reference_no, 0, 152, Short.MAX_VALUE)
                    .addComponent(balance_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(amount_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(cheque_no_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(receipt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(received_for_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receipt_ledger, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bank_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cheque_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(amount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount_in_word_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        save_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Save-icon.png"))); // NOI18N
        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Recycle-Bin-full-icon.png"))); // NOI18N
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        clear_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        clear_button.setText("Clear");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(delete_button)
                .addGap(18, 18, 18)
                .addComponent(clear_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_txt)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Receipt Edit/Delete");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rec_id, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(262, 262, 262))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rec_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
if(receipt_date.getText().equals(""))
     {
           JOptionPane.showMessageDialog(this,"Select Invoice No!"); 
     }
 else{
        date();
        ledger();
        receipt();
        amt();
        if(i==1&&j==1&&k==1&&l==1&&x==0&&y==0&&z==0)
        {
     
        if(rec_id.getText()!="")
        {
          try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);

           
                PreparedStatement ps1=con2.prepareStatement("update receipt set rec_c_name='"+name_txt.getText()+"',rec_date='"+receipt_date.getText()+"',rec_ledger='"+ledger.getSelectedItem().toString()+"',rec_ref_no='"+reference_no.getSelectedItem()+"',rec_balance='"+balance_txt.getText()+"',rec_for='"+received_for_txt.getText()+"',rec_ledger1='"+receipt_ledger.getSelectedItem().toString()+"',rec_bank_name='"+bank_name_txt.getText()+"',rec_branch_name='"+branch_name_txt.getText()+"',rec_cheque_no='"+cheque_no_txt.getText()+"',rec_total_amnt='"+amount_txt.getText()+"',rec_amnt_words='"+amount_in_word_txt.getText()+"' where  receipt_id='"+rec_id.getText()+"'");
                ps1.executeUpdate();
                
                 PreparedStatement psm=con2.prepareStatement("update company_main_table set ledger='"+ledger.getSelectedItem().toString()+"',trans_date='"+receipt_date.getText()+"',credit='"+amount_txt.getText()+"' where pay_invoice='"+rec_id.getText()+"' and debit='0'");
             psm.executeUpdate();
              PreparedStatement psg=con2.prepareStatement("update company_main_table set ledger='"+receipt_ledger.getSelectedItem().toString()+"',trans_date='"+receipt_date.getText()+"',debit='"+amount_txt.getText()+"' where pay_invoice='"+rec_id.getText()+"' and credit='0'");
             psg.executeUpdate();
                 Statement pssw =con2.createStatement();
                   Statement pssw1 =con2.createStatement();
                 Statement smt1 =con2.createStatement();
                 Statement pssws =con2.createStatement();
                   Statement pssw11 =con2.createStatement();
                 Statement smt11 =con2.createStatement();
                 //Ledger
                  ResultSet rssw1=pssw1.executeQuery("select  l_under from ledger where l_name='"+a2+"'");
          while(rssw1.next())
          {
               String under2=rssw1.getString("l_under");
               smt1.executeUpdate("delete from `"+under2+"` where l_name='"+a2+"' and trans_id='"+rec_id+"'");
          }
          
           ResultSet rssw=pssw.executeQuery("select  l_under from ledger where l_name='"+ledger.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under=rssw.getString("l_under");
              
             PreparedStatement psw=con2.prepareStatement("insert into `"+under+"` (l_name,credit,debit,trans_id)values('"+ledger.getSelectedItem().toString()+"','"+amount_txt.getText()+"','0','"+table_click+"')");
          psw.executeUpdate();
             
          }
          //receipt_ledger
                            ResultSet rssw11=pssw1.executeQuery("select  l_under from ledger where l_name='"+a5+"'");

          while(rssw11.next())
          {
               String under2=rssw11.getString("l_under");
               smt11.executeUpdate("delete from `"+under2+"` where l_name='"+a5+"' and trans_id='"+rec_id+"'");
          }
          
           ResultSet rssw111=pssw11.executeQuery("select  l_under from ledger where l_name='"+receipt_ledger.getSelectedItem().toString()+"'");
          while(rssw.next())
          {
              String under=rssw.getString("l_under");
              
             PreparedStatement psw=con2.prepareStatement("insert into `"+under+"` (l_name,debit,credit,trans_id)values('"+receipt_ledger.getSelectedItem().toString()+"','"+amount_txt.getText()+"','0','"+table_click+"')");
          psw.executeUpdate();
             
          } 
                 Statement pss =con2.createStatement();
               jopt1.showMessageDialog(this,"Receipt Updated");
                update_table();
                name_txt.setText(null);
               receipt_date.setText(null);
                balance_txt.setText(null);
                bank_name_txt.setText(null);
                branch_name_txt.setText(null);
                cheque_no_txt.setText(null);
                amount_txt.setText(null);
               // branch_name_txt.setText(null);
                amount_in_word_txt.setText(null);
               
            
        
          }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        }
        else{
             jOptionPane1.showMessageDialog(this,"Select Invoice no");
        }
                    
                    
             }
     }
    }//GEN-LAST:event_save_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
     if(rec_id.getText()!="")
        {
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
                PreparedStatement ps1=con1.prepareStatement("delete from receipt where rec_invoice='"+rec_id.getText()+"'");

                ps1.executeUpdate();
                //ledger delete
          ResultSet rp=pq.executeQuery("select  l_under from ledger where l_name='"+ledger.getSelectedItem().toString()+"'");
          while(rp.next())
          {
              String under=rp.getString("l_under");
         smt11.executeUpdate("delete from `"+under+"` where trans_id='"+rec_id.getText()+"'");
          }
          //receipt _ledger delete
           ResultSet rw=pr.executeQuery("select  l_under from ledger where l_name='"+receipt_ledger.getSelectedItem().toString()+"'");
          while(rw.next())
          {
              String unders=rw.getString("l_under");
         smt12.executeUpdate("delete from `"+unders+"` where trans_id='"+rec_id.getText()+"'");
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
        rec_id.setText(null);
        search_txt.setText(null);
        update_table();

        }
        }
      else{
             jOptionPane1.showMessageDialog(this,"Select Invoice no");
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        name_txt.setText("");
        balance_txt.setText("");
        received_for_txt.setText("");
        bank_name_txt.setText("");
        cheque_no_txt.setText("");
        amount_txt.setText("");
        amount_in_word_txt.setText("");
       
        receipt_date.setText("");
        branch_name_txt.setText("");
        ledger.setSelectedIndex(0);
        reference_no.removeAllItems();
        //receipt_ledger.
        
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        receipt_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        receipt_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        //name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                                      
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel20.setVisible(false);
        jLabel24.setVisible(false);
        
        
        
        
        
        
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txtFocusLost
     if(name_txt.getText().length()==0)
                            {
                                name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                jLabel14.setEnabled(false);  
                                jLabel14.setVisible(false);
                                x=0;
                                
                            }
                            else
                            {
                                 String email =name_txt.getText();
                                 String regEx1 = "^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$";
                                 Pattern p1 = Pattern.compile(regEx1);
                                 Matcher m1 = p1.matcher(email);
                                 name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                 jLabel14.setEnabled(false);  
                                 jLabel14.setVisible(false);
                                 x=0;
                       
                               if(m1.find()==false)
                             {
                                 x=1;
                               name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                               jLabel14.setEnabled(true);
                               jLabel14.setForeground(Color.red);
                               jLabel14.setVisible(true);

                             }
                           }
    }//GEN-LAST:event_name_txtFocusLost

    private void receipt_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receipt_dateFocusLost
           if(receipt_date.getText().length()==0)
       {
             receipt_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
           
       }
       else
       {
           
       
                 String content = receipt_date.getText();
                 Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                 Matcher m = p.matcher(content);
                 boolean matchFound = m.matches();
           //      System.out.println(matchFound);
                 receipt_date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                 jLabel15.setEnabled(false);  
                 jLabel15.setVisible(false);
                 i=1;
          
          if(!matchFound)
          { 
             receipt_date.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel15.setEnabled(true);
             jLabel15.setForeground(Color.red);
             jLabel15.setVisible(true);
          }
       }
    }//GEN-LAST:event_receipt_dateFocusLost

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

    private void ledgerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ledgerFocusLost
                if(ledger.getSelectedItem().equals(""))
      {
          ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           j=1;
      }
    }//GEN-LAST:event_ledgerFocusLost

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

    private void receipt_ledgerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receipt_ledgerFocusLost
                   if(receipt_ledger.getSelectedItem().equals(""))
      {
          receipt_ledger.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
             
      }  
      else
      {
           receipt_ledger.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           k=1;
      }
    }//GEN-LAST:event_receipt_ledgerFocusLost

    private void amount_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amount_txtFocusLost
         if(amount_txt.getText().length()==0)
                   {
                       amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                   }
                   else
                   {
                       String content = amount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m1 = p.matcher(content);
                       boolean matchFound = m1.matches();
                       amount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel24.setEnabled(false);  
                       jLabel24.setVisible(false);
                       l=1;
                       
                       
                       
                     if(!matchFound)
                    {
                       amount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_amount_txtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_in_word_txt;
    private numeric.textField.NumericTextField amount_txt;
    private numeric.textField.NumericTextField balance_txt;
    private javax.swing.JTextField bank_name_txt;
    private javax.swing.JTextField branch_name_txt;
    private numeric.textField.NumericTextField cheque_no_txt;
    private javax.swing.JButton clear_button;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox ledger;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField rec_id;
    private javax.swing.JTextField receipt_date;
    private javax.swing.JComboBox receipt_ledger;
    private javax.swing.JTextField received_for_txt;
    private javax.swing.JComboBox reference_no;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
private javax.swing.JOptionPane jopt2;
 private javax.swing.JOptionPane jOptionPane1;
}
