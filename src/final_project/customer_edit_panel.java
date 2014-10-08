package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
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
public class customer_edit_panel extends javax.swing.JPanel {
     Font myFont = new Font("",Font.PLAIN,9);
     int i=0,j=0,k=0;                    // for Mandatory
     int x=0,y=0,z=0,p=0,q=0;           // For Non Mandatory
    /**
     * Creates new form customer_edit_panel
     */
    public customer_edit_panel() {
        initComponents();
        name_txt.setFocusable(true);
        
        jLabel2.setFont(myFont);
        jLabel2.setEnabled(false);
        jLabel2.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
        
        jLabel18.setFont(myFont);
        jLabel18.setEnabled(false);
        jLabel18.setVisible(false);
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
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
        
        jLabel13.setFont(myFont);
        jLabel13.setEnabled(false);
        jLabel13.setVisible(false);
        
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
        
       
        
        
        c_dob.setVisible(false);
        L_Name.setVisible(false);
        c_under_txt.setVisible(false);
        
        PromptSupport.setPrompt("John Smith", name_txt);
        PromptSupport.setPrompt("dd/mm/yyyy", c_dob);
        PromptSupport.setPrompt("12, ABC Road", address_txt);
        PromptSupport.setPrompt("123456", pin_num);
        PromptSupport.setPrompt("abc@xyz.com", Email_Id_txt);
        PromptSupport.setPrompt("+911234567890", mobile_no_txt);
        PromptSupport.setPrompt("+91123456789", phone_no_txt);
        PromptSupport.setPrompt("12345678901", cst_no_txt);
        PromptSupport.setPrompt("12345678901", vat_no_txt);
        PromptSupport.setPrompt("AAAPL1234C", pan_no_txt);
    
        update_table();
        search();
        c_id.setVisible(false);
        c_under_txt.setVisible(false);
        company.setEnabled(false);
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"enter");
        table.getActionMap().put("enter", new AbstractAction() 
        {
        public void actionPerformed(ActionEvent e) 
        {
            //action to be performed
        }

            
        });
        
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct g_name from acc_group group by acc_g_id");
          while(rs.next())
          {
              String name=rs.getString("g_name");
             
              under_txt.addItem(name);
             
          }
         
            
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        } 
        
        
         try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct company_name,company_id from company_creation");
//            jComboBox1.addItem(d2); 
//           jComboBox1.setSelectedItem(d2);
           while(rs.next())
          {
              String name=rs.getString("company_name");
             int cc_id=Integer.parseInt(rs.getString("company_id"));
              company.addItem(name);
              System.out.println(cc_id);
          }
         // String name1="Others";
          //jComboBox1.addItem(name1);
            
         
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
  
       ///c_name
     
     public void c_name(){
          if(name_txt.getText().length()==0)
        {
             name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel2.setEnabled(true);
             jLabel2.setForeground(Color.red);
             jLabel2.setVisible(true);
        }
        else
        {
            String content = name_txt.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel2.setEnabled(false);  
            jLabel2.setVisible(false);
            i=1;
            if(!matchFound)
            {

                name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel2.setEnabled(true);
                jLabel2.setForeground(Color.red);
                jLabel2.setVisible(true);
                
            }
        }
     }
     // under
     public void under(){
          if(under_txt.getSelectedItem().equals(""))
       {
          under_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
       }
     }
     
       // phone no
     
     public void phone(){
         if(phone_no_txt.getText().length()==0)
        {
            phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel13.setEnabled(true);
            jLabel13.setForeground(Color.red);
            jLabel13.setVisible(true);
        }
        else
        {
            String content = phone_no_txt.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel13.setEnabled(false);  
            jLabel13.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel13.setEnabled(true);
                 jLabel13.setForeground(Color.red);
                 jLabel13.setVisible(true);
                
                 
            }
        }
     }
    
   
    
     private void tableMouseClicked(java.awt.event.MouseEvent evt) 
           {                  
               
under_txt.removeAll();
      // v_under.setVisible(false);
c_under_txt.setVisible(false);
L_Name.setVisible(true);
c_dob.setVisible(true);
            int new1=table.getSelectedRow();
            String table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         Statement ps2 =con1.createStatement();
                //   ResultSet rs2=ps2.executeQuery("SELECT DAYOFMONTH(v_dob) AS day,MONTH(v_dob) as month,YEAR(v_dob) as year from vendor where v_name='"+table_click+"'");
           ResultSet rs1=ps1.executeQuery("SELECT * from customer where c_name='"+table_click+"' ");
            //jComboBox1.removeAll();
       while(rs1.next())
                {
                      String  id=rs1.getString(1);
                  c_id.setText(id);
                     String  aa=rs1.getString(2);
                      name_txt.setText(aa);
                    String a1=rs1.getString(3);
                    c_under_txt.setText(a1);
                  under_txt.setSelectedItem(a1);
                   String a2=rs1.getString(4);
                  c_dob.setText(a2);
                     
                    String a6=rs1.getString(9);
                   pin_num.setText(a6);
                        
                 String a4=rs1.getString(11);
                   Email_Id_txt.setText(a4);
                    String a5=rs1.getString(5);
                    String g1="Male";
                     String g2="Female";
                     if(a5.compareTo(g1)==0){
                      male_radiobutton.setSelected(true);
                    }
                     else if(a5.compareTo(g2)==0){
                        Female_radio.setSelected(true);
                       
                        
                    }
                     else{
                         Company_radio.setSelected(true);
                     }
                    String a7=rs1.getString(6);
                    address_txt.setText(a7);
                    
                     String a8=rs1.getString(7);
                     city_txt.setText(a8);
                       String a9=rs1.getString(8);
                    state_txt.setText(a9);
                     String a10=rs1.getString(10);
                    country_txt.setText(a10);
                     
                     
                     String a13=rs1.getString(12);
                    mobile_no_txt.setText(a13);
                    String a14=rs1.getString(13);
                  phone_no_txt.setText(a14);
                   
                    String a16=rs1.getString(14);
                    vat_no_txt.setText(a16);
                      String a18=rs1.getString(15);
                    cst_no_txt.setText(a18);
                    String a19=rs1.getString(16);
                   pan_no_txt.setText(a19);
                
                    
                    String a30=rs1.getString(17);
                    opening_balance_num.setText(a30);
                    String a303=rs1.getString("c_dob");
                    c_dob.setText(a303);
                
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
    
    public void search(){
        search_text.addKeyListener(new java.awt.event.KeyAdapter()

            {

public void keyReleased(java.awt.event.KeyEvent e)

{
   String s1=search_text.getText();

 
 
 String s3=s1;
     
                    try{
                   Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("SELECT c_name as CUSTOMER_NAME from customer where c_name like '"+s3+"%'"); 
          
              
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
public void update_table()
{ 
       
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("SELECT c_name as CUSTOMER_NAME from customer ");
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
          Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from customer where c_name='"+s1+"' ");
       while(rs1.next())
                {
                    
                           // jComboBox1.removeAll(); 
                    
                  String  id=rs1.getString(1);
                  c_id.setText(id);
                     String  aa=rs1.getString(2);
                      name_txt.setText(aa);
                    String a1=rs1.getString(3);
                  under_txt.setSelectedItem(a1);
                     
                    String a6=rs1.getString(9);
                   pin_num.setText(a6);
                    
          
                 String a4=rs1.getString(11);
                    Email_Id_txt.setText(a4);
                    String a5=rs1.getString(5);
                    String g1="Male";
                     String g2="Female";
                     if(a5.compareTo(g1)==0){
                      male_radiobutton.setSelected(true);
                    }
                     else if(a5.compareTo(g2)==0){
                        Female_radio.setSelected(true);
                       
                        
                    }
                     else{
                         Company_radio.setSelected(true);
                     }
                    String a7=rs1.getString(6);
                    address_txt.setText(a7);
                    
                     String a8=rs1.getString(7);
                     city_txt.setText(a8);
                       String a9=rs1.getString(8);
                    state_txt.setText(a9);
                     String a10=rs1.getString(10);
                    country_txt.setText(a10);
                     
                     
                     String a13=rs1.getString(12);
                    mobile_no_txt.setText(a13);
                    String a14=rs1.getString(13);
                  phone_no_txt.setText(a14);
                   
                    String a16=rs1.getString(14);
                    vat_no_txt.setText(a16);
                      String a18=rs1.getString(15);
                    cst_no_txt.setText(a18);
                    String a19=rs1.getString(16);
                   pan_no_txt.setText(a19);
                
                    String a27=rs1.getString("opening_balance");
                   
                    opening_balance_num.setText(a27);
                     String a303=rs1.getString("c_dob");
                    c_dob.setText(a303);
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
    
    
    
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        c_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        L_Name = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        U_label = new javax.swing.JLabel();
        male_radiobutton = new javax.swing.JRadioButton();
        Female_radio = new javax.swing.JRadioButton();
        Company_radio = new javax.swing.JRadioButton();
        A_label = new javax.swing.JLabel();
        C_label = new javax.swing.JLabel();
        S_label = new javax.swing.JLabel();
        Co_label = new javax.swing.JLabel();
        P_label = new javax.swing.JLabel();
        E_label = new javax.swing.JLabel();
        Email_Id_txt = new javax.swing.JTextField();
        M_label = new javax.swing.JLabel();
        mobile_no_txt = new javax.swing.JTextField();
        Ph_label = new javax.swing.JLabel();
        phone_no_txt = new javax.swing.JTextField();
        V_label = new javax.swing.JLabel();
        vat_no_txt = new javax.swing.JTextField();
        Cst_label = new javax.swing.JLabel();
        cst_no_txt = new javax.swing.JTextField();
        Pan_label = new javax.swing.JLabel();
        pan_no_txt = new javax.swing.JTextField();
        Op_label = new javax.swing.JLabel();
        state_txt = new javax.swing.JTextField();
        country_txt = new javax.swing.JTextField();
        city_txt = new javax.swing.JTextField();
        under_txt = new javax.swing.JComboBox();
        address_txt = new javax.swing.JTextField();
        c_dob = new javax.swing.JTextField();
        company = new javax.swing.JComboBox();
        opening_balance_num = new numeric.textField.NumericTextField();
        pin_num = new numeric.textField.NumericTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        search_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        c_under_txt = new javax.swing.JTextField();

        c_id.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Edit/Delete");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("*Name:");

        L_Name.setText("Date Of Birth:");

        name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
            }
        });

        U_label.setText("*Under:");

        buttonGroup1.add(male_radiobutton);
        male_radiobutton.setText("Male");
        male_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                male_radiobuttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(Female_radio);
        Female_radio.setText("Female");
        Female_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Female_radioActionPerformed(evt);
            }
        });

        buttonGroup1.add(Company_radio);
        Company_radio.setText("Company");
        Company_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Company_radioActionPerformed(evt);
            }
        });

        A_label.setText("Address:");

        C_label.setText("City:");

        S_label.setText("State:");

        Co_label.setText("Country:");

        P_label.setText("Pin:");

        E_label.setText("Email Id:");

        Email_Id_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Email_Id_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Email_Id_txtFocusLost(evt);
            }
        });

        M_label.setText("Mobile No:");

        mobile_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mobile_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobile_no_txtFocusLost(evt);
            }
        });

        Ph_label.setText("Phone No:");

        phone_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        phone_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone_no_txtFocusLost(evt);
            }
        });

        V_label.setText("VAT No:");

        vat_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Cst_label.setText("CST No:");

        cst_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Pan_label.setText("PAN No:");

        pan_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Op_label.setText("Opening Balance:");

        state_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        country_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        city_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        under_txt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                under_txtFocusLost(evt);
            }
        });

        address_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        c_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_dob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_dobFocusLost(evt);
            }
        });

        company.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        opening_balance_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        opening_balance_num.setText("0.00");
        opening_balance_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                opening_balance_numFocusLost(evt);
            }
        });

        pin_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pin_num.setText("numericTextField1");
        pin_num.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pin_numFocusLost(evt);
            }
        });

        jLabel2.setText("Enter Customer Name!");

        jLabel4.setText("Enter Valid Date Format!");

        jLabel5.setText("Select Under!");

        jLabel6.setText("Enter Your Address!");

        jLabel7.setText("Enter City Name!");

        jLabel8.setText("Enter State Name!");

        jLabel9.setText("Enter Country Name!");

        jLabel10.setText("Enter Pincode!");

        jLabel11.setText("Enter Valid Email ID!");

        jLabel12.setText("Enter Valid Mobile!");

        jLabel13.setText("Enter Valid Phone Number!");

        jLabel14.setText("Enter Valid VAT Number!");

        jLabel15.setText("Enter Valid CST Number!");

        jLabel16.setText("Enter Valid PAN Number!");

        jLabel17.setText("Enter Valid Opening Balance!");

        jLabel18.setText("Select Company Name!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Name)
                            .addComponent(jLabel3)
                            .addComponent(U_label)
                            .addComponent(male_radiobutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Female_radio)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(under_txt, javax.swing.GroupLayout.Alignment.TRAILING, 0, 181, Short.MAX_VALUE)
                                    .addComponent(c_dob, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(name_txt, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Company_radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(company, 0, 181, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(A_label)
                            .addComponent(C_label)
                            .addComponent(S_label)
                            .addComponent(Co_label)
                            .addComponent(P_label)
                            .addComponent(E_label)
                            .addComponent(M_label)
                            .addComponent(Ph_label)
                            .addComponent(V_label)
                            .addComponent(Cst_label)
                            .addComponent(Pan_label)
                            .addComponent(Op_label))
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cst_no_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vat_no_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phone_no_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mobile_no_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Email_Id_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pin_num, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(country_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(state_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(city_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(address_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pan_no_txt)
                            .addComponent(opening_balance_num, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(U_label)
                    .addComponent(under_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Company_radio)
                    .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(male_radiobutton)
                    .addComponent(Female_radio)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_Name)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(c_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A_label)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_label)
                    .addComponent(city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_label)
                    .addComponent(state_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Co_label)
                    .addComponent(country_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_label)
                    .addComponent(pin_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email_Id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobile_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ph_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V_label))
                .addGap(4, 4, 4)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cst_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cst_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pan_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pan_label))
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Op_label)
                    .addComponent(opening_balance_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(234, 188));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        table.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_text, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_under_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(266, 266, 266))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(c_under_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

    if(c_id.getText().equals(""))
     {
           jopt1.showMessageDialog(this,"Select Customer Name!"); 
     }
    else{
        c_name();
        under();
        phone();
        if(i==1&&j==1&&k==1&&x==0&&y==0&&z==0&&p==0&&q==0)
        {

                                      
    
           
                   
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);

            
             Statement ps5 =con2.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT l_name,c_name from ledger,customer where l_name='"+name_txt.getText()+"' and l_name=c_name and c_id!='"+c_id.getText()+"'");

                if(rs5.next())
                    {
                    jopt1.showMessageDialog(this,"Customer Already Exsist"); 
                    }
                else{
                PreparedStatement ps1=con2.prepareStatement("update customer set c_name='"+name_txt.getText()+"',c_under='"+under_txt.getSelectedItem().toString()+"',c_address='"+address_txt.getText()+"',c_state='"+state_txt.getText()+"',c_city='"+city_txt.getText()+"',c_pin='"+pin_num.getText()+"',c_eid='"+Email_Id_txt.getText()+"',c_mb_no='"+mobile_no_txt.getText()+"',c_ph_no='"+phone_no_txt.getText()+"',c_vat_no='"+vat_no_txt.getText()+"',c_cst_no='"+cst_no_txt.getText()+"',c_pan='"+pan_no_txt.getText()+"', opening_balance='"+opening_balance_num.getText()+"',c_gender='"+gender+"' where  c_id='"+c_id.getText()+"'");
                ps1.executeUpdate();
                  PreparedStatement ps3=con2.prepareStatement("delete from  `"+c_under_txt.getText()+"` where l_name='"+name_txt.getText()+"' and trans_id='"+c_id.getText()+"'");

                ps3.executeUpdate();
                PreparedStatement ps4=con2.prepareStatement("insert into `"+under_txt.getSelectedItem().toString()+"`(l_name,debit)values('"+name_txt.getText()+"','"+opening_balance_num.getText()+"')");
                ps4.executeUpdate();
                jopt1.showMessageDialog(this,"Customer Updated");
                update_table();
                c_under_txt.setText(null);
                city_txt.setText(null);
                state_txt.setText(null);
                country_txt.setText(null);
                name_txt.setText(null);
               
                address_txt.setText(null);
                pin_num.setText(null);
                Email_Id_txt.setText(null);
                mobile_no_txt.setText(null);
                phone_no_txt.setText(null);
                vat_no_txt.setText(null);
                cst_no_txt.setText(null);
                pan_no_txt.setText(null);
                opening_balance_num.setText(null);
                male_radiobutton.setSelected(false);
                Female_radio.setSelected(false);
                Company_radio.setSelected(false);
                //jComboBox1.removeAll();
                // }
            /* else{
                PreparedStatement ps1=con2.prepareStatement("update ledger set l_name='"+under_txt.getText()+"',l_under='"+jComboBox1.getSelectedItem().toString()+"',l_address='"+state_txt.getText()+"',l_state='"+country_txt.getText()+"',l_acc_no='"+jTextField5.getText()+"',l_pan='"+jTextField5.getText()+"',l_sale_tax_no='"+jTextField6.getText()+"',l_branch='"+jTextField7.getText()+"',l_bsr_code='"+jTextField8.getText()+"',l_opning_balance='"+jTextField9.getText()+"',l_persentage='"+jTextField10.getText()+"' where  l_id='"+jTextField12.getText()+"'");
                ps1.executeUpdate();
                jopt1.showMessageDialog(this,"Ledger Updated");
                update_table();
                under_txt.setText(null);
                city_txt.setText(null);
                state_txt.setText(null);
                country_txt.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextField7.setText(null);
                jTextField8.setText(null);
                jTextField9.setText(null);
                jTextField10.setText(null);
                jTextField11.setText(null);
                jTextField12.setText(null);
                jComboBox1.removeAll();
            }*/
        }
        }catch (SQLException q){
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

        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from  customer where c_id='"+c_id.getText()+"'");

                ps1.executeUpdate();
                 PreparedStatement ps2=con1.prepareStatement("delete from  ledger where l_name='"+name_txt.getText()+"'");

                ps2.executeUpdate();
                PreparedStatement ps3=con1.prepareStatement("delete from  `"+c_under_txt.getText()+"` where l_name='"+name_txt.getText()+"' and trans_id is null");

                ps3.executeUpdate();
                System.out.println("Done");

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            c_under_txt.setText(null);
            city_txt.setText(null);
            state_txt.setText(null);
            country_txt.setText(null);
            name_txt.setText(null);
            
            address_txt.setText(null);
            pin_num.setText(null);
            Email_Id_txt.setText(null);
            mobile_no_txt.setText(null);
            phone_no_txt.setText(null);
            vat_no_txt.setText(null);
            cst_no_txt.setText(null);
            pan_no_txt.setText(null);
            opening_balance_num.setText(null);
            male_radiobutton.setSelected(false);
            Female_radio.setSelected(false);
            Company_radio.setSelected(false);
            update_table();

        }
        else{
            c_under_txt.setText(null);
            city_txt.setText(null);
            state_txt.setText(null);
            country_txt.setText(null);
            name_txt.setText(null);
           
            address_txt.setText(null);
            pin_num.setText(null);
            Email_Id_txt.setText(null);
            mobile_no_txt.setText(null);
            phone_no_txt.setText(null);
            vat_no_txt.setText(null);
            cst_no_txt.setText(null);
            pan_no_txt.setText(null);
            opening_balance_num.setText(null);
            male_radiobutton.setSelected(false);
            Female_radio.setSelected(false);
            Company_radio.setSelected(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void Company_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Company_radioActionPerformed
      company.setEnabled(true);
      c_dob.setEnabled(false);
      c_dob.setVisible(false);
       L_Name.setVisible(false);
      gender=company.getSelectedItem().toString();
      jLabel4.setVisible(false);
    }//GEN-LAST:event_Company_radioActionPerformed

    private void male_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_male_radiobuttonActionPerformed
       gender="Male";
       company.setEnabled(false);
       c_dob.setEnabled(true);
       c_dob.setVisible(true);
       L_Name.setVisible(true);
    }//GEN-LAST:event_male_radiobuttonActionPerformed

    private void Female_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Female_radioActionPerformed
      
        gender="Female";
        company.setEnabled(false);
        c_dob.setEnabled(true);
        c_dob.setVisible(true);
        L_Name.setVisible(true);
    }//GEN-LAST:event_Female_radioActionPerformed

    private void Email_Id_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Email_Id_txtFocusLost
         if(Email_Id_txt.getText().length()==0)
        {
             Email_Id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel11.setEnabled(false);  
             jLabel11.setVisible(false);
             z=0;
        }
        else
        {
            String email =Email_Id_txt.getText();
            String regEx1 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
            Pattern p1 = Pattern.compile(regEx1);
            Matcher m1 = p1.matcher(email);
            Email_Id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel11.setEnabled(false);  
            jLabel11.setVisible(false);
            z=0;

            if(m1.find()==false)
            {
                z=1;
                Email_Id_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel11.setEnabled(true);
                jLabel11.setForeground(Color.red);
                jLabel11.setVisible(true);

            }
        }
    }//GEN-LAST:event_Email_Id_txtFocusLost

    private void mobile_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobile_no_txtFocusLost
        if(mobile_no_txt.getText().length()==0)
        {
             mobile_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel12.setEnabled(false);  
             jLabel12.setVisible(false);
             p=0;
        }
        else
        {
            String pin =mobile_no_txt.getText();
            String regEx = "[+]\\d{10,12}";
            Pattern p1 = Pattern.compile(regEx);
            Matcher m = p1.matcher(pin);
            boolean matchFound = m.matches();
            mobile_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel12.setEnabled(false);  
            jLabel12.setVisible(false);
            p=0;
            if(!matchFound)
            {
                p=1;
                mobile_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel12.setEnabled(true);
                jLabel12.setForeground(Color.red);
                jLabel12.setVisible(true);
            }

        }
    }//GEN-LAST:event_mobile_no_txtFocusLost

    private void pin_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pin_numFocusLost
        if(pin_num.getText().length()==0)
        {
              pin_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel10.setEnabled(false);  
              jLabel10.setVisible(false);
              y=0;
        }
        else
        {
            String pin = pin_num.getText();
            String regEx = "\\d{6}";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(pin);
            pin_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel10.setEnabled(false);  
            jLabel10.setVisible(false);
            y=0;
            if(m.find()==false)
            {
                y=1;
                pin_num.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel10.setEnabled(true);
                jLabel10.setForeground(Color.red);
                jLabel10.setVisible(true);

            }
        }
                
    }//GEN-LAST:event_pin_numFocusLost

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
            String content = name_txt.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel2.setEnabled(false);  
            jLabel2.setVisible(false);
            i=1;
            if(!matchFound)
            {

                name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel2.setEnabled(true);
                jLabel2.setForeground(Color.red);
                jLabel2.setVisible(true);
                
            }
        }
    }//GEN-LAST:event_name_txtFocusLost

    private void c_dobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_dobFocusLost
              if(c_dob.getText().length()==0)
        {
             c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel4.setEnabled(false);  
             jLabel4.setVisible(false);
             x=0;   
        }
        else
        {
            String content = c_dob.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel4.setEnabled(false);  
            jLabel4.setVisible(false);
            x=0;
            
            if(!matchFound)

            {
                 x=1;

                 c_dob.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel4.setEnabled(true);
                 jLabel4.setForeground(Color.red);
                 jLabel4.setVisible(true);

            }
        }
    }//GEN-LAST:event_c_dobFocusLost

    private void phone_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_no_txtFocusLost
        if(phone_no_txt.getText().length()==0)
        {
            phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel13.setEnabled(true);
            jLabel13.setForeground(Color.red);
            jLabel13.setVisible(true);
        }
        else
        {
            String content = phone_no_txt.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel13.setEnabled(false);  
            jLabel13.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel13.setEnabled(true);
                 jLabel13.setForeground(Color.red);
                 jLabel13.setVisible(true);
                
                 
            }
        }
    }//GEN-LAST:event_phone_no_txtFocusLost

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        // TODO add your handling code here:
        name_txt.setText("");
        under_txt.setSelectedIndex(-1);
        company.setSelectedIndex(-1);
        c_dob.setText("");
        address_txt.setText("");
        city_txt.setText("");
        state_txt.setText("");
        country_txt.setText("");
        pin_num.setText("");
        Email_Id_txt.setText("");
        mobile_no_txt.setText("");
        phone_no_txt.setText("");
        vat_no_txt.setText("");
        cst_no_txt.setText("");
        pan_no_txt.setText("");
        opening_balance_num.setText("0.00");
        c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pin_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Email_Id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mobile_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        //.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void under_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_under_txtFocusLost
          if(under_txt.getSelectedItem().equals(""))
       {
          under_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_under_txtFocusLost

    private void opening_balance_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_opening_balance_numFocusLost
       if(opening_balance_num.getText().length()==0)
        {
              opening_balance_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel17.setEnabled(false);  
              jLabel17.setVisible(false);
              q=0;
        }
        else
        {
            String content = opening_balance_num.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            opening_balance_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel17.setEnabled(false);  
            jLabel17.setVisible(false);
            q=0;
            if(!matchFound)
            {
                q=1;
                opening_balance_num.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel17.setEnabled(true);
                jLabel17.setForeground(Color.red);
                jLabel17.setVisible(true);

            }
        }
    }//GEN-LAST:event_opening_balance_numFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A_label;
    private javax.swing.JLabel C_label;
    private javax.swing.JLabel Co_label;
    private javax.swing.JRadioButton Company_radio;
    private javax.swing.JLabel Cst_label;
    private javax.swing.JLabel E_label;
    private javax.swing.JTextField Email_Id_txt;
    private javax.swing.JRadioButton Female_radio;
    private javax.swing.JLabel L_Name;
    private javax.swing.JLabel M_label;
    private javax.swing.JLabel Op_label;
    private javax.swing.JLabel P_label;
    private javax.swing.JLabel Pan_label;
    private javax.swing.JLabel Ph_label;
    private javax.swing.JLabel S_label;
    private javax.swing.JLabel U_label;
    private javax.swing.JLabel V_label;
    private javax.swing.JTextField address_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField c_dob;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_under_txt;
    private javax.swing.JTextField city_txt;
    private javax.swing.JButton clear_button;
    private javax.swing.JComboBox company;
    private javax.swing.JTextField country_txt;
    private javax.swing.JTextField cst_no_txt;
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
    private javax.swing.JRadioButton male_radiobutton;
    private javax.swing.JTextField mobile_no_txt;
    private javax.swing.JTextField name_txt;
    private numeric.textField.NumericTextField opening_balance_num;
    private javax.swing.JTextField pan_no_txt;
    private javax.swing.JTextField phone_no_txt;
    private numeric.textField.NumericTextField pin_num;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_text;
    private javax.swing.JTextField state_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox under_txt;
    private javax.swing.JTextField vat_no_txt;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
private String gender;
}
