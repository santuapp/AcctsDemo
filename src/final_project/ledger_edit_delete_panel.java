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
import net.proteanit.sql.DbUtils;
import org.jdesktop.xswingx.PromptSupport;
//import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class ledger_edit_delete_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
     int i=0,j=0;    // For Mandatory
     int x=0,y=0,z=0; // For Non Mandatory

    /**
     * Creates new form ledger_edit_delete_panel
     */
    public ledger_edit_delete_panel() 
    {
        initComponents();
        name_txt.setFocusable(true);
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con1.createStatement();
            ResultSet rs=ps.executeQuery("select distinct g_name from acc_group order by acc_g_id");
          
            while(rs.next())
            {
                String name=rs.getString("g_name");

                under.addItem(name);
               
            }
           
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        jLabel2.setFont(myFont);
        jLabel2.setEnabled(false);
        jLabel2.setVisible(false);
        
        jLabel3.setFont(myFont);
        jLabel3.setEnabled(false);
        jLabel3.setVisible(false);
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
        
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
        
        jLabel11.setFont(myFont);
        jLabel11.setEnabled(false);
        jLabel11.setVisible(false);
        
        jLabel12.setFont(myFont);
        jLabel12.setEnabled(false);
        jLabel12.setVisible(false);
        
        PromptSupport.setPrompt("12, ABC Road", address_txt);
        PromptSupport.setPrompt("AAAPL1234C", pan_it_no_txt);
        PromptSupport.setPrompt("12345678901", sale_tax_no_txt);
        PromptSupport.setPrompt("ABCD1234567", bsr_ifsc_code_txt);
        PromptSupport.setPrompt("1234567", account_no_txt);
        PromptSupport.setPrompt("STATE", state_txt);
        PromptSupport.setPrompt("BRANCH", branch_name_txt);
        PromptSupport.setPrompt("0.00", ope_bal_num);
        PromptSupport.setPrompt("0.00", per_num);
        PromptSupport.setPrompt("LEDGER", name_txt);
        update_table();
        search();
       
       jTextField12.setVisible(false);
        name.setVisible(false);
         table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"enter");
        table.getActionMap().put("enter", new AbstractAction() 
        {
        public void actionPerformed(ActionEvent e) 
        {
            //action to be performed
        }

            
        });
      
    }
    
    
      // name
    
    
    public void name(){
            if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel2.setEnabled(true);
          jLabel2.setForeground(Color.red);
          jLabel2.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel2.setEnabled(false);  
           jLabel2.setVisible(false);
           i=1;
          
      }
        
    }
    
    
    // under
    
    
     public void under(){
           if(under.getSelectedItem().equals(""))
      {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel3.setEnabled(true);
          jLabel3.setForeground(Color.red);
          jLabel3.setVisible(true);
             
      }  
      else
      {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel3.setEnabled(false);  
           jLabel3.setVisible(false);
           j=1;
      }
        
    }
            
        
               
            
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public void search(){
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter()

            {

public void keyReleased(java.awt.event.KeyEvent e)

{
                String s1=jTextField13.getText();
                String s3=s1;
     
                try
                    {
                        
                    Class.forName("com.mysql.jdbc.Driver");
                    String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                    Connection con = (Connection) DriverManager.getConnection(ConnUrl);
                    Statement ps =con.createStatement();
                    ResultSet rs=ps.executeQuery("SELECT l_name as LEDGER_NAME, l_under as UNDER from ledger where l_name like '"+s3+"%'"); 


                    table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

                    }
                    catch (SQLException e1)
                    {
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
           ResultSet rs=ps.executeQuery("SELECT l_name as LEDGER_NAME from ledger ");
          table.setModel(DbUtils.resultSetToTableModel(rs));
           
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
                    

                 int row=table.getSelectedRow();
                 int col=table.getSelectedColumn();
                
                if(table.getValueAt(row, 0) != null){
                String s1= (String)table.getValueAt(row, 0);
                
                
//JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ "" +table.getValueAt(0,(table.getSelectedColumn())).toString());

System.out.println(" Value in the row clicked :"+ " " +row+"");
System.out.println(" Value in the col clicked :"+ " " +col+"");
System.out.println(" Value in the col,row clicked :"+ " " +s1+"");

          try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from ledger where l_name='"+s1+"' ");
       while(rs1.next())
                {
                              
                   
                   String  aa=rs1.getString("l_id");
                jTextField12.setText(aa);
                
                String a1=rs1.getString("l_name");
                name_txt.setText(a1);

               
                under.setSelectedItem(rs1.getString("l_under"));

                String a3=rs1.getString("l_address");
                address_txt.setText(a3);
                
                String a4=rs1.getString("l_state");
                state_txt.setText(a4);
                
                String a5=rs1.getString("l_acc_no");
                account_no_txt.setText(a5);
                
                String a7=rs1.getString("l_pan");
                pan_it_no_txt.setText(a7);
                
                String a8=rs1.getString("l_sale_tax_no");
                sale_tax_no_txt.setText(a8);
                
                String a9=rs1.getString("l_branch");
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString("l_bsr_code");
                bsr_ifsc_code_txt.setText(a10);
                
                String a11=rs1.getString("l_opning_balance");
                ope_bal_num.setText(a11);
                
                String a12=rs1.getString("l_persentage");
                per_num.setText(a12);
                    
                
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        l_name = new javax.swing.JLabel();
        l_under = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        l_state = new javax.swing.JLabel();
        l_acc_no = new javax.swing.JLabel();
        l_pan = new javax.swing.JLabel();
        sale_tax = new javax.swing.JLabel();
        l_branch = new javax.swing.JLabel();
        l_bsr = new javax.swing.JLabel();
        l_opening_balance = new javax.swing.JLabel();
        l_persentage = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        address_txt = new javax.swing.JTextField();
        state_txt = new javax.swing.JTextField();
        account_no_txt = new javax.swing.JTextField();
        pan_it_no_txt = new javax.swing.JTextField();
        sale_tax_no_txt = new javax.swing.JTextField();
        branch_name_txt = new javax.swing.JTextField();
        bsr_ifsc_code_txt = new javax.swing.JTextField();
        under = new javax.swing.JComboBox();
        ope_bal_num = new numeric.textField.NumericTextField();
        per_num = new numeric.textField.NumericTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        name = new javax.swing.JTextField();

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ledger Edit/Delete");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        l_name.setText("*Name:");

        l_under.setText("*Under:");

        address.setText("Address:");

        l_state.setText("State:");

        l_acc_no.setText("Account_no:");

        l_pan.setText("PAN/IT No.");

        sale_tax.setText("Sale Tax No.");

        l_branch.setText("Branch Name:");

        l_bsr.setText("BSR/IFSC Code:");

        l_opening_balance.setText("Opening Balance:");

        l_persentage.setText("Percentage:");

        name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
            }
        });

        address_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_txtActionPerformed(evt);
            }
        });

        state_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        account_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        pan_it_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        sale_tax_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        sale_tax_no_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_tax_no_txtActionPerformed(evt);
            }
        });

        branch_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        bsr_ifsc_code_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bsr_ifsc_code_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bsr_ifsc_code_txtFocusLost(evt);
            }
        });

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underActionPerformed(evt);
            }
        });
        under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                underFocusLost(evt);
            }
        });

        ope_bal_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ope_bal_num.setText("numericTextField1");
        ope_bal_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ope_bal_numFocusLost(evt);
            }
        });

        per_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        per_num.setText("numericTextField1");
        per_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                per_numFocusLost(evt);
            }
        });

        jLabel2.setText("Ledger Name Can Not be Empty!");

        jLabel3.setText("Select Under!");

        jLabel4.setText("Please Provide Your Address!");

        jLabel5.setText("Enter Your State Name!");

        jLabel6.setText("Enter Valid Account Number!");

        jLabel7.setText("Enter Valid PAN/IT Number!");

        jLabel8.setText("Enter Valid Sales Tax Number!");

        jLabel9.setText("Enter Valid Branch Name!");

        jLabel10.setText("Enter Valid BSR/IFSC Code!");

        jLabel11.setText("Enter Valid Opening Balance!");

        jLabel12.setText("Enter Valid Percentage!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_under, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_state, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sale_tax, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_persentage, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_opening_balance, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(l_bsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(state_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(account_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pan_it_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sale_tax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bsr_ifsc_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ope_bal_num, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(per_num, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_name)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_under)
                    .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_state)
                    .addComponent(state_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_acc_no)
                    .addComponent(account_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_pan)
                    .addComponent(pan_it_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sale_tax)
                    .addComponent(sale_tax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_branch)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_bsr)
                    .addComponent(bsr_ifsc_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_opening_balance)
                    .addComponent(ope_bal_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(per_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_persentage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Save-icon.png"))); // NOI18N
        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Recycle-Bin-full-icon.png"))); // NOI18N
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        clear_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        clear_button.setText("Clear");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(save_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(delete_button)
                .addGap(18, 18, 18)
                .addComponent(clear_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

           
            
     if(name.getText().equals(""))
     {
           jopt1.showMessageDialog(this,"Select Ledger Name!"); 
     }

   
       
  else {
       name();
      under();  
         if(i==1&&j==1&&x==0&&y==0&&z==0)
    {       
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);
 

            
       
       
                PreparedStatement ps1=con2.prepareStatement("update ledger set l_name='"+name_txt.getText()+"',l_under='"+under.getSelectedItem().toString()+"',l_address='"+address_txt.getText()+"',l_state='"+state_txt.getText()+"',l_acc_no='"+account_no_txt.getText()+"',l_pan='"+pan_it_no_txt.getText()+"',l_sale_tax_no='"+sale_tax_no_txt.getText()+"',l_branch='"+branch_name_txt.getText()+"',l_bsr_code='"+bsr_ifsc_code_txt.getText()+"',l_opning_balance='"+ope_bal_num.getText()+"',l_persentage='"+per_num.getText()+"' where  l_id='"+jTextField12.getText()+"'");
                ps1.executeUpdate();
                 
                 PreparedStatement ps4=con2.prepareStatement("insert into `"+under.getSelectedItem().toString()+"`(l_name,debit)values('"+name_txt.getText()+"','"+ope_bal_num.getText()+"')");
            ps4.executeUpdate();
                jopt1.showMessageDialog(this,"Ledger Updated");
                update_table();
                name_txt.setText(null);
               under.setSelectedItem("");
                address_txt.setText(null);
                state_txt.setText(null);
                account_no_txt.setText(null);
                pan_it_no_txt.setText(null);
                sale_tax_no_txt.setText(null);
                branch_name_txt.setText(null);
                bsr_ifsc_code_txt.setText(null);
                ope_bal_num.setText(null);
                per_num.setText(null);
                jTextField12.setText(null);
              
            
        
        
    }
     catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }
     }
    }//GEN-LAST:event_save_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        jTextField13.setText("");
        
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from  ledger where l_id='"+jTextField12.getText()+"'");

                ps1.executeUpdate();
                PreparedStatement ps3=con1.prepareStatement("delete from  `"+under.getSelectedItem().toString()+"` where l_name='"+name.getText()+"' and trans_id is null");

                ps3.executeUpdate();
                System.out.println("Done");

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            name_txt.setText(null);
          
            address_txt.setText(null);
            state_txt.setText(null);
            account_no_txt.setText(null);
            pan_it_no_txt.setText(null);
            sale_tax_no_txt.setText(null);
            branch_name_txt.setText(null);
            bsr_ifsc_code_txt.setText(null);
            ope_bal_num.setText(null);
            per_num.setText(null);
            jTextField12.setText(null);
            under.removeAll();
         update_table();

        }
        else{
            name_txt.setText(null);
            under.setSelectedItem("");
            address_txt.setText(null);
            state_txt.setText(null);
            account_no_txt.setText(null);
            pan_it_no_txt.setText(null);
            sale_tax_no_txt.setText(null);
            branch_name_txt.setText(null);
            bsr_ifsc_code_txt.setText(null);
            ope_bal_num.setText(null);
            per_num.setText(null);
            jTextField12.setText(null);
            under.removeAll();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed

        name_txt.setText(null);
        under.setSelectedItem("");
        address_txt.setText(null);
        state_txt.setText(null);
        account_no_txt.setText(null);
        pan_it_no_txt.setText(null);
        sale_tax_no_txt.setText(null);
        branch_name_txt.setText(null);
        bsr_ifsc_code_txt.setText(null);
        ope_bal_num.setText(null);
        per_num.setText(null);
        jTextField12.setText(null);
        under.removeAll();
        
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       
       
     
        int new1=table.getSelectedRow();
        String table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            ResultSet rs1=ps1.executeQuery("SELECT * from ledger where l_name='"+table_click+"' ");
            under.removeAll();
            while(rs1.next())
            {

                
                
                String  aa=rs1.getString("l_id");
                jTextField12.setText(aa);
                 
                String a1=rs1.getString("l_name");
                name_txt.setText(a1);
name.setText(a1);
            
                under.setSelectedItem(rs1.getString("l_under"));

                String a3=rs1.getString("l_address");
                address_txt.setText(a3);
                
                String a4=rs1.getString("l_state");
                state_txt.setText(a4);
                
                String a5=rs1.getString("l_acc_no");
                account_no_txt.setText(a5);
                
                String a7=rs1.getString("l_pan");
                pan_it_no_txt.setText(a7);
                
                String a8=rs1.getString("l_sale_tax_no");
                sale_tax_no_txt.setText(a8);
                
                String a9=rs1.getString("l_branch");
                branch_name_txt.setText(a9);
                
                String a10=rs1.getString("l_bsr_code");
                bsr_ifsc_code_txt.setText(a10);
                
                String a11=rs1.getString("l_opning_balance");
                ope_bal_num.setText(a11);
                
                String a12=rs1.getString("l_persentage");
                per_num.setText(a12);

            }

            under.removeAll();
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void sale_tax_no_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_tax_no_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sale_tax_no_txtActionPerformed

    private void address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_txtActionPerformed

    private void bsr_ifsc_code_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bsr_ifsc_code_txtFocusLost
         
                        
                        
                         if(bsr_ifsc_code_txt.getText().length()==0)
                            {
                               bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel10.setEnabled(false);  
                               jLabel10.setVisible(false);
                               x=0;
                                
                            }
                            else
                            {
                        String email =bsr_ifsc_code_txt.getText();
                        String regEx1 = "^[a-zA-Z0-9]+$";
                        Pattern p1 = Pattern.compile(regEx1);
                        Matcher m1 = p1.matcher(email);
                        bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel10.setEnabled(false);  
                        jLabel10.setVisible(false);
                        x=0;
                       
                      if(m1.find()==false)
                    {
                        x=1;
                       bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                     
                    }
                            }
                         
    }//GEN-LAST:event_bsr_ifsc_code_txtFocusLost

    private void ope_bal_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ope_bal_numFocusLost
            if(ope_bal_num.getText().length()==0)
                            {
                               ope_bal_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel10.setEnabled(false);  
                               jLabel10.setVisible(false);
                               y=0;
                                
                            }
                            else
                            {
                       String content = ope_bal_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       ope_bal_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel10.setEnabled(false);  
                       jLabel10.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       ope_bal_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel10.setEnabled(true);
                       jLabel10.setForeground(Color.red);
                       jLabel10.setVisible(true);
                     
                    }
                            }
    }//GEN-LAST:event_ope_bal_numFocusLost

    private void per_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per_numFocusLost
               
                      if(per_num.getText().length()==0)
                            {
                               per_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel12.setEnabled(false);  
                               jLabel12.setVisible(false);
                               z=0;
                                
                            }
                            else
                            {
                       String content = per_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       per_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel12.setEnabled(false);  
                       jLabel12.setVisible(false);
                       z=0;
                     if(!matchFound)
                    {
                        z=1;
                       per_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel12.setEnabled(true);
                       jLabel12.setForeground(Color.red);
                       jLabel12.setVisible(true);
                     
                    }
                     
                            }
    }//GEN-LAST:event_per_numFocusLost

    private void underActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_underActionPerformed

    private void name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txtFocusLost
    if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel2.setEnabled(true);
          jLabel2.setForeground(Color.red);
          jLabel2.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel2.setEnabled(false);  
           jLabel2.setVisible(false);
           i=1;
          
      }
    }//GEN-LAST:event_name_txtFocusLost

    private void underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_underFocusLost
            if(under.getSelectedItem().equals(""))
      {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel3.setEnabled(true);
          jLabel3.setForeground(Color.red);
          jLabel3.setVisible(true);
             
      }  
      else
      {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel3.setEnabled(false);  
           jLabel3.setVisible(false);
           j=1;
      }
    }//GEN-LAST:event_underFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account_no_txt;
    private javax.swing.JLabel address;
    private javax.swing.JTextField address_txt;
    private javax.swing.JTextField branch_name_txt;
    private javax.swing.JTextField bsr_ifsc_code_txt;
    private javax.swing.JButton clear_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JLabel l_acc_no;
    private javax.swing.JLabel l_branch;
    private javax.swing.JLabel l_bsr;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_opening_balance;
    private javax.swing.JLabel l_pan;
    private javax.swing.JLabel l_persentage;
    private javax.swing.JLabel l_state;
    private javax.swing.JLabel l_under;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name_txt;
    private numeric.textField.NumericTextField ope_bal_num;
    private javax.swing.JTextField pan_it_no_txt;
    private numeric.textField.NumericTextField per_num;
    private javax.swing.JLabel sale_tax;
    private javax.swing.JTextField sale_tax_no_txt;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField state_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox under;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
}
