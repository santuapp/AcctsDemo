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
public class vendor_edit_delete_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
    int i=0,j=0,k=0;                    // for Mandatory
    int x=0,y=0,z=0,p=0,q=0;           // For Non Mandatory
    /**
     * Creates new form vendor_edit_delete_panel
     */
    public vendor_edit_delete_panel() {
        initComponents();
        
        name_txt.setFocusable(true);
        
        DOB_label.setVisible(false);
        dob_txt.setVisible(false);
        v_under_txt.setVisible(false);
        
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
        
        jLabel18.setFont(myFont);
        jLabel18.setEnabled(false);
        jLabel18.setVisible(false);
     
        PromptSupport.setPrompt("John Smith", name_txt);
        PromptSupport.setPrompt("dd/mm/yyyy", dob_txt);
        PromptSupport.setPrompt("12,ABC Road", address_txt);
        PromptSupport.setPrompt("123456", pin_txt);
        PromptSupport.setPrompt("abc@xyz.com", email_id_txt);
        PromptSupport.setPrompt("+911234567890", mobile_no_txt);
        PromptSupport.setPrompt("+91123456789", phone_no_txt);
        PromptSupport.setPrompt("12345678901", cst_no_txt);
        PromptSupport.setPrompt("12345678901", vat_no_txt);
        PromptSupport.setPrompt("AAAPL1234C", pan_no_txt);
            update_table();
            search();
              company.setEnabled(false);
            v_under_txt.setVisible(false);
            v_id.setVisible(false);
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
    
       class FocusGrabber implements Runnable {
  private JComponent component;

  public FocusGrabber(JComponent component) {
    this.component = component;
  }

  public void run() {
    component.grabFocus();
  }
}
  
         ///v_name
     
     public void c_name(){
          if(name_txt.getText().length()==0)
        {
             name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel3.setEnabled(true);
             jLabel3.setForeground(Color.red);
             jLabel3.setVisible(true);
        }
        else
        {
            String content = name_txt.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
         //   System.out.println(matchFound);
            name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel3.setEnabled(false);  
            jLabel3.setVisible(false);
            i=1;
            if(!matchFound)
            {

                name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel3.setEnabled(true);
                jLabel3.setForeground(Color.red);
                jLabel3.setVisible(true);
                
            }
        }
     }
     // under
     public void under(){
          if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           j=1;
       }
     }
     
       // phone no
     
     public void phone(){
         if(phone_no_txt.getText().length()==0)
        {
            phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel14.setEnabled(true);
            jLabel14.setForeground(Color.red);
            jLabel14.setVisible(true);
        }
        else
        {
            String content = phone_no_txt.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel14.setEnabled(false);  
            jLabel14.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);
                
                 
            }
        }
     }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
      
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
           ResultSet rs=ps.executeQuery("SELECT v_name as VENDOR_NAME from vendor where v_name like '"+s3+"%'"); 
          
              
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
           ResultSet rs=ps.executeQuery("SELECT v_name as VENDOR_NAME from vendor ");
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
           ResultSet rs1=ps1.executeQuery("SELECT * from vendor where v_name='"+s1+"' ");
       while(rs1.next())
                {
                    
                           // jComboBox1.removeAll(); 
                    
                  String  id=rs1.getString(1);
                  v_id.setText(id);
                     String  aa=rs1.getString(2);
                      name_txt.setText(aa);
                    String a1=rs1.getString(3);
                  v_under_txt.setText(a1);
                   under.setSelectedItem(rs1.getString("v_under"));
                   
                    String a6=rs1.getString(9);
                   pin_txt.setText(a6);
                    
          
                 String a4=rs1.getString(11);
                   email_id_txt.setText(a4);
                    String a5=rs1.getString(5);
                    String g1="Male";
                     String g2="Female";
                     if(a5.compareTo(g1)==0){
                      m_radio.setSelected(true);
                    }
                     else if(a5.compareTo(g2)==0){
                        f_radio.setSelected(true);
                       
                        
                    }
                     else{
                         company_radio.setSelected(true);
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
                    opening_balance_txt.setText(a30);
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
   
           
           
           private void tableMouseClicked(java.awt.event.MouseEvent evt) 
           {                                   
under.removeAll();
      // v_under.setVisible(false);
v_under_txt.setVisible(true);
            int new1=table.getSelectedRow();
            String table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         Statement ps2 =con1.createStatement();
                //   ResultSet rs2=ps2.executeQuery("SELECT DAYOFMONTH(v_dob) AS day,MONTH(v_dob) as month,YEAR(v_dob) as year from vendor where v_name='"+table_click+"'");
           ResultSet rs1=ps1.executeQuery("SELECT * from vendor where v_name='"+table_click+"' ");
            //jComboBox1.removeAll();
       while(rs1.next())
                {
                      String  id=rs1.getString(1);
                  v_id.setText(id);
                     String  aa=rs1.getString(2);
                      name_txt.setText(aa);
                    String a1=rs1.getString(3);
                    v_under_txt.setText(a1);
                  under.setSelectedItem(a1);
                   String a2=rs1.getString(4);
                  dob_txt.setText(a2);
                     
                    String a6=rs1.getString(9);
                   pin_txt.setText(a6);
                        
                 String a4=rs1.getString(11);
                   email_id_txt.setText(a4);
                    String a5=rs1.getString(5);
                    String g1="Male";
                     String g2="Female";
                     if(a5.compareTo(g1)==0){
                      m_radio.setSelected(true);
                    }
                     else if(a5.compareTo(g2)==0){
                        f_radio.setSelected(true);
                       
                        
                    }
                     else{
                         company_radio.setSelected(true);
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
                    opening_balance_txt.setText(a30);
                
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        v_under_txt = new javax.swing.JTextField();
        v_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        DOB_label = new javax.swing.JLabel();
        Under_label = new javax.swing.JLabel();
        m_radio = new javax.swing.JRadioButton();
        f_radio = new javax.swing.JRadioButton();
        company_radio = new javax.swing.JRadioButton();
        Add_label = new javax.swing.JLabel();
        Cty_label = new javax.swing.JLabel();
        St_label = new javax.swing.JLabel();
        Cou_label = new javax.swing.JLabel();
        Pn_label = new javax.swing.JLabel();
        Em_label = new javax.swing.JLabel();
        email_id_txt = new javax.swing.JTextField();
        Mb_label = new javax.swing.JLabel();
        mobile_no_txt = new javax.swing.JTextField();
        Ph_label = new javax.swing.JLabel();
        phone_no_txt = new javax.swing.JTextField();
        VT_label = new javax.swing.JLabel();
        vat_no_txt = new javax.swing.JTextField();
        CT_label = new javax.swing.JLabel();
        cst_no_txt = new javax.swing.JTextField();
        Pan_label = new javax.swing.JLabel();
        pan_no_txt = new javax.swing.JTextField();
        Op_label = new javax.swing.JLabel();
        dob_txt = new javax.swing.JTextField();
        city_txt = new javax.swing.JTextField();
        state_txt = new javax.swing.JTextField();
        country_txt = new javax.swing.JTextField();
        under = new javax.swing.JComboBox();
        company = new javax.swing.JComboBox();
        address_txt = new javax.swing.JTextField();
        pin_txt = new numeric.textField.NumericTextField();
        opening_balance_txt = new numeric.textField.NumericTextField();
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
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(426, 594));

        jLabel2.setText(" Name:");

        name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
            }
        });

        DOB_label.setText("Date Of Birth:");

        Under_label.setText("Under:");

        buttonGroup1.add(m_radio);
        m_radio.setText("Male");
        m_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_radioActionPerformed(evt);
            }
        });

        buttonGroup1.add(f_radio);
        f_radio.setText("Female");
        f_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_radioActionPerformed(evt);
            }
        });

        buttonGroup1.add(company_radio);
        company_radio.setText("Company");
        company_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                company_radioActionPerformed(evt);
            }
        });

        Add_label.setText("Address:");

        Cty_label.setText("City:");

        St_label.setText("State:");

        Cou_label.setText("Country:");

        Pn_label.setText("Pin:");

        Em_label.setText("Email Id:");

        email_id_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        email_id_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email_id_txtFocusLost(evt);
            }
        });

        Mb_label.setText("Mobile No:");

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

        VT_label.setText("VAT No:");

        vat_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        CT_label.setText("CST No:");

        cst_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Pan_label.setText("Pan No:");

        pan_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Op_label.setText("Opening Balance:");

        dob_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        dob_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dob_txtFocusLost(evt);
            }
        });

        city_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        state_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        country_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                underFocusLost(evt);
            }
        });

        company.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        company.setToolTipText("");
        company.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        address_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        pin_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pin_txt.setText("numericTextField1");
        pin_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pin_txtFocusLost(evt);
            }
        });

        opening_balance_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        opening_balance_txt.setText("0.00");
        opening_balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                opening_balance_txtFocusLost(evt);
            }
        });

        jLabel3.setText("Enter Vendor Name!");

        jLabel4.setText("Select Under!");

        jLabel5.setText("Select Any One!");

        jLabel6.setText("Enter Valid Date of Birth");

        jLabel7.setText("Enter Valid Address!");

        jLabel8.setText("Enter Valid City Name!");

        jLabel9.setText("Enter State Name!");

        jLabel10.setText("Enter Valid Country Name!");

        jLabel11.setText("Enter Valid Pincode!");

        jLabel12.setText("Enter Valid Email ID!");

        jLabel13.setText("Enter Valid Mobile Number!");

        jLabel14.setText("Enter Valid Phone Number!");

        jLabel15.setText("Enter Valid VAT Number!");

        jLabel16.setText("Enter Valid CST Number!");

        jLabel17.setText("Enter Valid PAN Number!");

        jLabel18.setText("Enter Opening Balance!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(company_radio, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Under_label, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(under, 0, 131, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(m_radio)
                                .addGap(43, 43, 43)
                                .addComponent(f_radio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(dob_txt)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Pn_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Cou_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Add_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(St_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Cty_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(43, 43, 43))
                            .addComponent(Em_label)
                            .addComponent(Mb_label)
                            .addComponent(Ph_label)
                            .addComponent(VT_label)
                            .addComponent(CT_label)
                            .addComponent(Pan_label)
                            .addComponent(Op_label))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(state_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email_id_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mobile_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phone_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vat_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cst_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pan_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(address_txt)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(country_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(opening_balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(DOB_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Under_label)
                    .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(company_radio)
                    .addComponent(company, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_radio)
                    .addComponent(f_radio)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DOB_label)
                    .addComponent(dob_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_label)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cty_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(St_label)
                    .addComponent(state_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cou_label))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Pn_label))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Em_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobile_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mb_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ph_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VT_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cst_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CT_label))
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pan_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pan_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Op_label)
                    .addComponent(opening_balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(22, 22, 22)
                .addComponent(delete_button)
                .addGap(22, 22, 22)
                .addComponent(clear_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_txt)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vendor Edit/Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(v_under_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_id, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(v_under_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(v_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

 if(v_id.getText().equals(""))
     {
           jopt1.showMessageDialog(this,"Select Vendor Name!"); 
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

            // if(city_txt.isVisible())
            // {
            Statement ps5 =con2.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT l_name,v_name from ledger,vendor where l_name='"+name_txt.getText()+"' and l_name=v_name and v_id!='"+v_id.getText()+"'");

                if(rs5.next())
                    {
                    jopt1.showMessageDialog(this,"Vendor Already Exsist"); 
                    }
                else{
                PreparedStatement ps1=con2.prepareStatement("update vendor set v_name='"+name_txt.getText()+"',v_under='"+under.getSelectedItem().toString()+"',v_address='"+address_txt.getText()+"',v_state='"+state_txt.getText()+"',v_city='"+city_txt.getText()+"',v_pin='"+pin_txt.getText()+"',v_eid='"+email_id_txt.getText()+"',v_mb_no='"+mobile_no_txt.getText()+"',v_ph_no='"+phone_no_txt.getText()+"',v_vat_no='"+vat_no_txt.getText()+"',v_cst_no='"+cst_no_txt.getText()+"',v_pan='"+pan_no_txt.getText()+"', opening_balance='"+opening_balance_txt.getText()+"',v_dob='"+dob_txt.getText()+"',v_gender='"+gender+"' where  v_id='"+v_id.getText()+"'");
                ps1.executeUpdate();
                PreparedStatement ps3=con2.prepareStatement("delete from  `"+v_under_txt.getText()+"` where l_name='"+name_txt.getText()+"' and trans_id='"+v_id.getText()+"'");

                ps3.executeUpdate();
                PreparedStatement ps4=con2.prepareStatement("insert into `"+under.getSelectedItem().toString()+"`(l_name,credit)values('"+name_txt.getText()+"','"+opening_balance_txt.getText()+"')");
                ps4.executeUpdate();
                jopt1.showMessageDialog(this,"Vendor Updated");
                update_table();
                dob_txt.setText(null);
                city_txt.setText(null);
                state_txt.setText(null);
                country_txt.setText(null);
                name_txt.setText(null);
                dob_txt.setText(null);

                address_txt.setText(null);
                pin_txt.setText(null);
                email_id_txt.setText(null);
                mobile_no_txt.setText(null);
                phone_no_txt.setText(null);
                vat_no_txt.setText(null);
                cst_no_txt.setText(null);
                pan_no_txt.setText(null);
                opening_balance_txt.setText(null);
                m_radio.setSelected(false);
                f_radio.setSelected(false);
                company_radio.setSelected(false);
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

                PreparedStatement ps1=con1.prepareStatement("delete from  vendor where v_id='"+v_id.getText()+"'");

                ps1.executeUpdate();
                PreparedStatement ps2=con1.prepareStatement("delete from  ledger where l_name='"+name_txt.getText()+"'");

                ps2.executeUpdate();
                PreparedStatement ps3=con1.prepareStatement("delete from  `"+v_under_txt.getText()+"` where l_name='"+name_txt.getText()+"' and trans_id is null");

                ps3.executeUpdate();
                System.out.println("Done");

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            dob_txt.setText(null);
            city_txt.setText(null);
            state_txt.setText(null);
            country_txt.setText(null);
            name_txt.setText(null);
            dob_txt.setText(null);

            address_txt.setText(null);
            pin_txt.setText(null);
            email_id_txt.setText(null);
            mobile_no_txt.setText(null);
            phone_no_txt.setText(null);
            vat_no_txt.setText(null);
            cst_no_txt.setText(null);
            pan_no_txt.setText(null);
            opening_balance_txt.setText(null);
            m_radio.setSelected(false);
            f_radio.setSelected(false);
            company_radio.setSelected(false);
            update_table();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void company_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_company_radioActionPerformed
     company.setEnabled(true);
      DOB_label.setVisible(false);
       dob_txt.setVisible(false);
        gender=company.getSelectedItem().toString();
    }//GEN-LAST:event_company_radioActionPerformed

    private void m_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_radioActionPerformed
      gender="Male";
       company.setEnabled(false);
       DOB_label.setVisible(true);
       dob_txt.setVisible(true);
    }//GEN-LAST:event_m_radioActionPerformed

    private void f_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_radioActionPerformed
       gender="Female";
        company.setEnabled(false);
         DOB_label.setVisible(true);
       dob_txt.setVisible(true);
    }//GEN-LAST:event_f_radioActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        name_txt.setText("");
        opening_balance_txt.setText("");
        pin_txt.setText("");
        dob_txt.setText("");
        email_id_txt.setText("");
        mobile_no_txt.setText("");
        phone_no_txt.setText("");
        vat_no_txt.setText("");
        cst_no_txt.setText("");
        pin_txt.setText("");
        address_txt.setText("");
        city_txt.setText(""); 
        state_txt.setText("");
        country_txt.setText("");
        
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        company.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pin_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        email_id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mobile_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        dob_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel6.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txtFocusLost
      if(name_txt.getText().length()==0)
        {
             name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel3.setEnabled(true);
             jLabel3.setForeground(Color.red);
             jLabel3.setVisible(true);
        }
        else
        {
            String content = name_txt.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
         //   System.out.println(matchFound);
            name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel3.setEnabled(false);  
            jLabel3.setVisible(false);
            i=1;
            if(!matchFound)
            {

                name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel3.setEnabled(true);
                jLabel3.setForeground(Color.red);
                jLabel3.setVisible(true);
                
            }
        }
    }//GEN-LAST:event_name_txtFocusLost

    private void dob_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dob_txtFocusLost
              if(dob_txt.getText().length()==0)
        {
             dob_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel6.setEnabled(false);  
             jLabel6.setVisible(false);
             x=0;   
        }
        else
        {
            String content = dob_txt.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            dob_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel6.setEnabled(false);  
            jLabel6.setVisible(false);
            x=0;
            
            if(!matchFound)

            {
                 x=1;

                 dob_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel6.setEnabled(true);
                 jLabel6.setForeground(Color.red);
                 jLabel6.setVisible(true);

            }
        }
    }//GEN-LAST:event_dob_txtFocusLost

    private void pin_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pin_txtFocusLost
      if(pin_txt.getText().length()==0)
        {
              pin_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel11.setEnabled(false);  
              jLabel11.setVisible(false);
              y=0;
        }
        else
        {
            String pin = pin_txt.getText();
            String regEx = "\\d{6}";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(pin);
            pin_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel11.setEnabled(false);  
            jLabel11.setVisible(false);
            y=0;
            if(m.find()==false)
            {
                y=1;
                pin_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel11.setEnabled(true);
                jLabel11.setForeground(Color.red);
                jLabel11.setVisible(true);

            }
        }
    }//GEN-LAST:event_pin_txtFocusLost

    private void email_id_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_id_txtFocusLost
           if(email_id_txt.getText().length()==0)
        {
             email_id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel12.setEnabled(false);  
             jLabel12.setVisible(false);
             z=0;
        }
        else
        {
            String email =email_id_txt.getText();
            String regEx1 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
            Pattern p1 = Pattern.compile(regEx1);
            Matcher m1 = p1.matcher(email);
            email_id_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel12.setEnabled(false);  
            jLabel12.setVisible(false);
            z=0;

            if(m1.find()==false)
            {
                z=1;
                email_id_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel12.setEnabled(true);
                jLabel12.setForeground(Color.red);
                jLabel12.setVisible(true);

            }
        }
    }//GEN-LAST:event_email_id_txtFocusLost

    private void mobile_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobile_no_txtFocusLost
         if(mobile_no_txt.getText().length()==0)
        {
             mobile_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel13.setEnabled(false);  
             jLabel13.setVisible(false);
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
            jLabel13.setEnabled(false);  
            jLabel13.setVisible(false);
            p=0;
            if(!matchFound)
            {
                p=1;
                mobile_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel13.setEnabled(true);
                jLabel13.setForeground(Color.red);
                jLabel13.setVisible(true);
            }

        }
    }//GEN-LAST:event_mobile_no_txtFocusLost

    private void phone_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_no_txtFocusLost
         if(phone_no_txt.getText().length()==0)
        {
            phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel14.setEnabled(true);
            jLabel14.setForeground(Color.red);
            jLabel14.setVisible(true);
        }
        else
        {
            String content = phone_no_txt.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            phone_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel14.setEnabled(false);  
            jLabel14.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 phone_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);
                
                 
            }
        }
    }//GEN-LAST:event_phone_no_txtFocusLost

    private void underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_underFocusLost
          if(under.getSelectedItem().equals(""))
       {
          under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
       }
       else
       {
           under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_underFocusLost

    private void opening_balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_opening_balance_txtFocusLost
      if(opening_balance_txt.getText().length()==0)
        {
              opening_balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel18.setEnabled(false);  
              jLabel18.setVisible(false);
              q=0;
        }
        else
        {
            String content = opening_balance_txt.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            opening_balance_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel18.setEnabled(false);  
            jLabel18.setVisible(false);
            q=0;
            if(!matchFound)
            {
                q=1;
                opening_balance_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel18.setEnabled(true);
                jLabel18.setForeground(Color.red);
                jLabel18.setVisible(true);

            }
        }
    }//GEN-LAST:event_opening_balance_txtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_label;
    private javax.swing.JLabel CT_label;
    private javax.swing.JLabel Cou_label;
    private javax.swing.JLabel Cty_label;
    private javax.swing.JLabel DOB_label;
    private javax.swing.JLabel Em_label;
    private javax.swing.JLabel Mb_label;
    private javax.swing.JLabel Op_label;
    private javax.swing.JLabel Pan_label;
    private javax.swing.JLabel Ph_label;
    private javax.swing.JLabel Pn_label;
    private javax.swing.JLabel St_label;
    private javax.swing.JLabel Under_label;
    private javax.swing.JLabel VT_label;
    private javax.swing.JTextField address_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField city_txt;
    private javax.swing.JButton clear_button;
    private javax.swing.JComboBox company;
    private javax.swing.JRadioButton company_radio;
    private javax.swing.JTextField country_txt;
    private javax.swing.JTextField cst_no_txt;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField dob_txt;
    private javax.swing.JTextField email_id_txt;
    private javax.swing.JRadioButton f_radio;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton m_radio;
    private javax.swing.JTextField mobile_no_txt;
    private javax.swing.JTextField name_txt;
    private numeric.textField.NumericTextField opening_balance_txt;
    private javax.swing.JTextField pan_no_txt;
    private javax.swing.JTextField phone_no_txt;
    private numeric.textField.NumericTextField pin_txt;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField state_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox under;
    private javax.swing.JTextField v_id;
    private javax.swing.JTextField v_under_txt;
    private javax.swing.JTextField vat_no_txt;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
private String gender;
}
