package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author pc2
 */
public class customer_create_panel extends javax.swing.JPanel {
String gender="";
 Font myFont = new Font("",Font.PLAIN,9);
 int i=0,j=0,k=0;    // For Mandatory
 int x=0,y=0,z=0,p=0,q=0;    // For Non Mandatory
 
    /**
     * Creates new form customer_create_panel
     */
    public customer_create_panel() {
        initComponents();
        c_name.setFocusable(true);
        
         
         jLabel3.setVisible(false);
         c_dob.setVisible(false);
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel20.setFont(myFont);
        jLabel20.setEnabled(false);
        jLabel20.setVisible(false);
        
        jLabel21.setFont(myFont);
        jLabel21.setEnabled(false);
        jLabel21.setVisible(false);
       
        
        jLabel23.setFont(myFont);
        jLabel23.setEnabled(false);
        jLabel23.setVisible(false);
        
        jLabel24.setFont(myFont);
        jLabel24.setEnabled(false);
        jLabel24.setVisible(false);
        
        jLabel25.setFont(myFont);
        jLabel25.setEnabled(false);
        jLabel25.setVisible(false);
        
        jLabel26.setFont(myFont);
        jLabel26.setEnabled(false);
        jLabel26.setVisible(false);
        
        jLabel27.setFont(myFont);
        jLabel27.setEnabled(false);
        jLabel27.setVisible(false);
        
        jLabel28.setFont(myFont);
        jLabel28.setEnabled(false);
        jLabel28.setVisible(false);
        
        jLabel29.setFont(myFont);
        jLabel29.setEnabled(false);
        jLabel29.setVisible(false);
        
        jLabel30.setFont(myFont);
        jLabel30.setEnabled(false);
        jLabel30.setVisible(false);
        
        jLabel31.setFont(myFont);
        jLabel31.setEnabled(false);
        jLabel31.setVisible(false);
        
        jLabel32.setFont(myFont);
        jLabel32.setEnabled(false);
        jLabel32.setVisible(false);
        
        jLabel33.setFont(myFont);
        jLabel33.setEnabled(false);
        jLabel33.setVisible(false);
        
        jLabel34.setFont(myFont);
        jLabel34.setEnabled(false);
        jLabel34.setVisible(false);
        
        jLabel35.setFont(myFont);
        jLabel35.setEnabled(false);
        jLabel35.setVisible(false);
        
        jLabel36.setFont(myFont);
        jLabel36.setEnabled(false);
        jLabel36.setVisible(false);
        
        PromptSupport.setPrompt("John Smith", c_name);
        PromptSupport.setPrompt("dd/mm/yyyy", c_dob);
        PromptSupport.setPrompt("12, ABC Road", c_add);
        PromptSupport.setPrompt("123456", c_pin_no);
        PromptSupport.setPrompt("abc@xyz.com", c_eid);
        PromptSupport.setPrompt("+911234567890", c_mb_no);
        PromptSupport.setPrompt("+91123456789", c_ph_no);
        PromptSupport.setPrompt("12345678901", c_cst_no);
        PromptSupport.setPrompt("12345678901", c_vat_no);
        PromptSupport.setPrompt("AAAPL1234C", c_pan_no);
        
   
       
      
        
    c_company.setEnabled(false);
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct g_name from acc_group group by acc_g_id");
          while(rs.next())
          {
              String name=rs.getString("g_name");
              c_under.addItem(name);
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
   
    ///c_name
     
     public void c_name(){
          if(c_name.getText().length()==0)
        {
             c_name.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel4.setEnabled(true);
             jLabel4.setForeground(Color.red);
             jLabel4.setVisible(true);
        }
        else
        {
            String content = c_name.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            c_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel4.setEnabled(false);  
            jLabel4.setVisible(false);
            i=1;
            if(!matchFound)
            {

                c_name.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel4.setEnabled(true);
                jLabel4.setForeground(Color.red);
                jLabel4.setVisible(true);
                
            }
        }
     }
     // under
     public void under(){
          if(c_under.getSelectedItem().equals(""))
       {
          c_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
       }
       else
       {
           c_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           j=1;
       }
     }
     
   // gender
     
//     public void gender(){
//         if(buttongroup.isSelected(null))
//         {
//              jLabel36.setEnabled(true);
//              jLabel36.setForeground(Color.red);
//              jLabel36.setVisible(true);
//              k=1;
//         }
//     }
//     
 
   
      
     // phone no
     
     public void phone(){
         if(c_ph_no.getText().length()==0)
        {
            c_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel32.setEnabled(true);
            jLabel32.setForeground(Color.red);
            jLabel32.setVisible(true);
        }
        else
        {
            String content = c_ph_no.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            c_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel32.setEnabled(false);  
            jLabel32.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 c_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel32.setEnabled(true);
                 jLabel32.setForeground(Color.red);
                 jLabel32.setVisible(true);
                
                 
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

        buttongroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        c_under = new javax.swing.JComboBox();
        company = new javax.swing.JRadioButton();
        c_company = new javax.swing.JComboBox();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        c_dob = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        c_add = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        c_state = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        c_pin_no = new numeric.textField.NumericTextField();
        jLabel10 = new javax.swing.JLabel();
        c_eid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        c_mb_no = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        c_vat_no = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        c_country = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        c_pan_no = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c_opening = new numeric.textField.NumericTextField();
        reset_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        c_ph_no = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        c_cst_no = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Informations"));

        jLabel2.setText("*Name:");

        c_name.setToolTipText("Input Name");
        c_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_nameFocusLost(evt);
            }
        });

        jLabel17.setText("*Under:");

        c_under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        c_under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_underFocusLost(evt);
            }
        });

        buttongroup.add(company);
        company.setText("*Company");
        company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyActionPerformed(evt);
            }
        });
        company.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                companyFocusLost(evt);
            }
        });

        c_company.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        c_company.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_companyActionPerformed(evt);
            }
        });

        buttongroup.add(male);
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        buttongroup.add(female);
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        jLabel3.setText("Date of Birth");

        c_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dobActionPerformed(evt);
            }
        });
        c_dob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_dobFocusLost(evt);
            }
        });

        jLabel5.setText("Address:");

        c_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setText("City:");

        c_city.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel7.setText("State:");
        jLabel7.setToolTipText("");

        c_state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel8.setText("Pin:");

        c_pin_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_pin_no.setText("numericTextField1");
        c_pin_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_pin_noFocusLost(evt);
            }
        });

        jLabel10.setText("Email ID:");

        c_eid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_eid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_eidFocusLost(evt);
            }
        });

        jLabel11.setText("Mobile No:");

        c_mb_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_mb_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_mb_noFocusLost(evt);
            }
        });

        jLabel13.setText("VAT No:");

        c_vat_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel9.setText("Country:");

        c_country.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel15.setText("PAN No:");

        c_pan_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel16.setText("Openning Balance:");
        jLabel16.setToolTipText("");

        c_opening.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_opening.setText("0.00");
        c_opening.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_openingFocusLost(evt);
            }
        });

        reset_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        submit_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        submit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jLabel4.setText("Enter Valid Name!");

        jLabel20.setText("Select Under!");

        jLabel21.setText("Enter Valid Date of Birth!");

        jLabel23.setText("Enter Your City Name!");

        jLabel24.setText("Enter Your State Name!");

        jLabel25.setText("Enter Your Coountry Name!");

        jLabel26.setText("Enter Your Valid Pincode!");

        jLabel27.setText("Enter Valid Email ID!");

        jLabel28.setText("Enter Valid Mobile Number!");

        jLabel29.setText("Enter Valid VAT Number!");

        jLabel30.setText("Enter Valid PAN Number!");

        jLabel31.setText("Enter Valid Opening Balance!");

        jLabel36.setText("Select Any One!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(company)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2)
                            .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(female)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_name, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_under, 0, 158, Short.MAX_VALUE)
                            .addComponent(c_company, 0, 158, Short.MAX_VALUE)
                            .addComponent(c_dob, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_add, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_city, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_state, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_country, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_pin_no, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_eid, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_mb_no, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_vat_no, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(c_pan_no, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 96, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_opening, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(reset_button)
                                .addGap(18, 18, 18)
                                .addComponent(submit_button)))))
                .addGap(28, 28, 28))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {c_add, c_city, c_company, c_country, c_dob, c_eid, c_mb_no, c_name, c_opening, c_pan_no, c_pin_no, c_state, c_under, c_vat_no});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(c_under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(company)
                    .addComponent(c_company, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(c_city, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_state, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(c_country, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(c_pin_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(c_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(c_mb_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(c_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(c_pan_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(c_opening, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_button)
                    .addComponent(submit_button))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(240, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Add Group")));

        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField11.setEnabled(false);

        jLabel18.setText("Group Name");
        jLabel18.setEnabled(false);

        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jComboBox2.setEnabled(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Under");
        jLabel19.setEnabled(false);

        jButton3.setText("Submit");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel34.setText("Enter Valid Group Name!");

        jLabel35.setText("Choose Under!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 153, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(4, 4, 4)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addGap(4, 4, 4)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("*Phone No:");

        c_ph_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_ph_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_ph_noFocusLost(evt);
            }
        });

        jLabel14.setText("CST No:");

        c_cst_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel32.setText("Enter Valid Phone Number!");

        jLabel33.setText("Enter Valid CST Number!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c_cst_no, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_ph_no, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(c_ph_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(c_cst_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Registration Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void c_ph_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_ph_noFocusLost
   if(c_ph_no.getText().length()==0)
        {
            c_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel32.setEnabled(true);
            jLabel32.setForeground(Color.red);
            jLabel32.setVisible(true);
        }
        else
        {
            String content = c_ph_no.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            c_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel32.setEnabled(false);  
            jLabel32.setVisible(false);
             k=1;
           
            if(!matchFound)

            {
                 c_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel32.setEnabled(true);
                 jLabel32.setForeground(Color.red);
                 jLabel32.setVisible(true);
                
                 
            }
        }   
    }//GEN-LAST:event_c_ph_noFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            PreparedStatement ps=con.prepareStatement("insert into acc_group(g_name,g_under)values('"+jTextField11.getText()+"','"+jComboBox2.getSelectedItem().toString()+"')");
            ps.executeUpdate();
            System.out.println("saved");

            jopt2.showMessageDialog(this,"Saved");
            jComboBox2.removeAllItems();
            jComboBox2.removeAllItems();
            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group group by acc_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("g_name");
                jComboBox2.addItem(name);
            }
        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void c_dobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_dobFocusLost
          if(c_dob.getText().length()==0)
        {
             c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel21.setEnabled(false);  
             jLabel21.setVisible(false);
             x=0;
        }
        else
        {
            String content = c_dob.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel21.setEnabled(false);  
            jLabel21.setVisible(false);
            x=0;
            if(!matchFound)

            {
                x=1;

                 c_dob.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel21.setEnabled(true);
                 jLabel21.setForeground(Color.red);
                 jLabel21.setVisible(true);

            }
        }
    }//GEN-LAST:event_c_dobFocusLost

    private void c_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_dobActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed

        
        
        c_name();
        under();
  //      gender();
    
        phone();
         

      
if(i==1&&j==1&&k==1&&x==0&&y==0&&z==0&&p==0&&q==0)
{        
                
                
                
                
                            try{

                                Class.forName("com.mysql.jdbc.Driver");
                                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                                Connection con = (Connection) DriverManager.getConnection(ConnUrl);
                                Statement ps5 =con.createStatement();
                                ResultSet rs5=ps5.executeQuery("SELECT l_name from ledger where l_name='"+c_name.getText()+"'");

                                if(rs5.next())
                                {
                                    jopt2.showMessageDialog(this,"Customer Already Exsist");
                                }
                                else{
                                    PreparedStatement ps=con.prepareStatement("insert into customer(c_name,c_under,c_dob,c_gender,c_address,c_city,c_state,c_pin,c_country,c_eid,c_mb_no,c_ph_no,c_vat_no,c_cst_no,c_pan)values('"+c_name.getText()+"','"+c_under.getSelectedItem().toString()+"','"+c_dob.getText()+"','"+gander+"','"+c_add.getText()+"','"+c_state.getText()+"','"+c_state.getText()+"','"+c_pin_no.getText()+"','"+c_country.getText()+"','"+c_eid.getText()+"','"+c_mb_no.getText()+"','"+c_ph_no.getText()+"','"+c_vat_no.getText()+"','"+c_cst_no.getText()+"','"+c_pan_no.getText()+"')");
                                    ps.executeUpdate();
                                    PreparedStatement ps2=con.prepareStatement("insert into ledger(l_name,l_under,l_address,l_state,l_pan)values('"+c_name.getText()+"','"+c_under.getSelectedItem().toString()+"','"+c_add.getText()+"','"+c_state.getText()+"','"+c_pan_no.getText()+"')");
                                    ps2.executeUpdate();
                                    PreparedStatement ps3=con.prepareStatement("insert into `"+c_under.getSelectedItem().toString()+"`(l_name,debit,credit)values('"+c_name.getText()+"','"+c_opening.getText()+"','0')");
                                    ps3.executeUpdate();
                                    System.out.println("saved");

                                    jopt1.showMessageDialog(this,"Customer Created");
                                   // c_under.removeAllItems();
                                     c_name.setText("");
                                     c_opening.setText("0.00");
                                     c_pin_no.setText("");
                                     c_dob.setText("");
                                     c_eid.setText("");
                                     c_mb_no.setText("");
                                     c_ph_no.setText("");
                                     c_vat_no.setText("");
                                     c_cst_no.setText("");
                                     c_pan_no.setText("");
                                     c_add.setText("");
                                     c_under.setSelectedIndex(0);
                                     c_company.setSelectedIndex(0);
                                    
                                    
                                    Statement ps1 =con.createStatement();
                                    ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group group by acc_g_id");
                                    while(rs1.next())
                                    {
                                        String name=rs1.getString("g_name");
                                        c_under.addItem(name);
                                    }
                                }
                            }catch (SQLException e){
                                System.out.println("Sql Exception" + e.toString());
                            }
                            catch(ClassNotFoundException ce)
                            {
                                System.out.println("ClassNotFoundException" + ce.toString());
                            }
        }
        

        //        ///
        //
        //
        //
        //

    }//GEN-LAST:event_submit_buttonActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed

        c_name.setText("");
        c_opening.setText("0.00");
        c_pin_no.setText("");
        c_dob.setText("");
        c_eid.setText("");
        c_mb_no.setText("");
        c_ph_no.setText("");
        c_vat_no.setText("");
        c_cst_no.setText("");
        c_pan_no.setText("");
        c_add.setText("");
        
        
        c_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_pin_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        
        jLabel4.setVisible(false);
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
        jLabel32.setVisible(false);
        jLabel27.setVisible(false);
        jLabel28.setVisible(false);
        jLabel26.setVisible(false);

    }//GEN-LAST:event_reset_buttonActionPerformed

    private void c_mb_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_mb_noFocusLost
        if(c_mb_no.getText().length()==0)
        {
             c_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel28.setEnabled(false);  
             jLabel28.setVisible(false);
             p=0;
        }
        else
        {
            String pin =c_mb_no.getText();
            String regEx = "[+]\\d{10,12}";
            Pattern p1 = Pattern.compile(regEx);
            Matcher m = p1.matcher(pin);
            c_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel28.setEnabled(false);  
            jLabel28.setVisible(false);
            p=0;
            if(m.find()==false)
            {
                p=1;
                c_mb_no.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel28.setEnabled(true);
                jLabel28.setForeground(Color.red);
                jLabel28.setVisible(true);
            }

        }
    }//GEN-LAST:event_c_mb_noFocusLost

    private void c_eidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_eidFocusLost
        if(c_eid.getText().length()==0)
        {
             c_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel27.setEnabled(false);  
             jLabel27.setVisible(false);
             z=0;
        }
        else
        {
            String email =c_eid.getText();
            String regEx1 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
            Pattern p1 = Pattern.compile(regEx1);
            Matcher m1 = p1.matcher(email);
            c_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel27.setEnabled(false);  
            jLabel27.setVisible(false);
            z=0;

            if(m1.find()==false)
            {
                z=1;
                c_eid.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel27.setEnabled(true);
                jLabel27.setForeground(Color.red);
                jLabel27.setVisible(true);

            }
        }

    }//GEN-LAST:event_c_eidFocusLost

    private void c_pin_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_pin_noFocusLost
        if(c_pin_no.getText().length()==0)
        {
              c_pin_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel26.setEnabled(false);  
              jLabel26.setVisible(false);
              y=0;
        }
        else
        {
            
            String pin = c_pin_no.getText();
            String regEx = "\\d{6}";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(pin);
            c_pin_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel26.setEnabled(false);  
            jLabel26.setVisible(false);
            y=0;
            if(m.find()==false)
            {
                y=1;
                c_pin_no.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel26.setEnabled(true);
                jLabel26.setForeground(Color.red);
                jLabel26.setVisible(true);

            }
        }
    }//GEN-LAST:event_c_pin_noFocusLost

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
//       jLabel36.setEnabled(false);
//       jLabel36.setVisible(false);
//       
//        gender="Female";
//        c_company.setEnabled(false);
//        c_dob.setEnabled(true);
        
        // testing
        
         gender="Female";
        c_company.setEnabled(false);
         jLabel3.setVisible(true);
         c_dob.setVisible(true);
        
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
//       jLabel36.setEnabled(false);
//       jLabel36.setVisible(false);
//       
//        gander="Male";
//        c_company.setEnabled(false);
//        c_dob.setEnabled(true);
        
        //testing
        
        gander="Male";
         c_company.setEnabled(false);
         
         jLabel3.setVisible(true);
         c_dob.setVisible(true);
    }//GEN-LAST:event_maleActionPerformed

    private void c_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_companyActionPerformed
 
    }//GEN-LAST:event_c_companyActionPerformed

    private void companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyActionPerformed
//       jLabel36.setEnabled(false);
//       jLabel36.setVisible(false);
//       
//        c_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
//        jLabel21.setEnabled(false);
//        jLabel21.setVisible(false);
//        c_company.setEnabled(true);
//        c_dob.setEnabled(false);
//        gender=c_company.getSelectedItem().toString();
        
      
        // tsting
        
         c_company.setEnabled(true);
        gender=c_company.getSelectedItem().toString();
      
         jLabel3.setVisible(false);
         c_dob.setVisible(false);
       
       
    }//GEN-LAST:event_companyActionPerformed

    private void c_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_nameFocusLost
             if(c_name.getText().length()==0)
        {
             c_name.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel4.setEnabled(true);
             jLabel4.setForeground(Color.red);
             jLabel4.setVisible(true);
        }
        else
        {
            String content = c_name.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            c_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel4.setEnabled(false);  
            jLabel4.setVisible(false);
              i=1;
            if(!matchFound)
            {

                c_name.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel4.setEnabled(true);
                jLabel4.setForeground(Color.red);
                jLabel4.setVisible(true);
              
            }
        }
    }//GEN-LAST:event_c_nameFocusLost

    private void c_underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_underFocusLost
     if(c_under.getSelectedItem().equals(""))
       {
          c_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
       }
       else
       {
           c_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           j=1;
       }     
    }//GEN-LAST:event_c_underFocusLost

    private void companyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyFocusLost
     
    }//GEN-LAST:event_companyFocusLost

    private void c_openingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_openingFocusLost
        if(c_opening.getText().length()==0)
        {
              c_opening.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel31.setEnabled(false);  
              jLabel31.setVisible(false);
              q=0;
        }
        else
        {
            String content = c_opening.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            c_opening.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel31.setEnabled(false);  
            jLabel31.setVisible(false);
            q=0;
            if(!matchFound)
            {
                q=1;
                c_opening.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel31.setEnabled(true);
                jLabel31.setForeground(Color.red);
                jLabel31.setVisible(true);

            }
        }
    }//GEN-LAST:event_c_openingFocusLost

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttongroup;
    private javax.swing.JTextField c_add;
    private javax.swing.JTextField c_city;
    private javax.swing.JComboBox c_company;
    private javax.swing.JTextField c_country;
    private javax.swing.JTextField c_cst_no;
    private javax.swing.JTextField c_dob;
    private javax.swing.JTextField c_eid;
    private javax.swing.JTextField c_mb_no;
    private javax.swing.JTextField c_name;
    private numeric.textField.NumericTextField c_opening;
    private javax.swing.JTextField c_pan_no;
    private javax.swing.JTextField c_ph_no;
    private numeric.textField.NumericTextField c_pin_no;
    private javax.swing.JTextField c_state;
    private javax.swing.JComboBox c_under;
    private javax.swing.JTextField c_vat_no;
    private javax.swing.JRadioButton company;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox2;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JRadioButton male;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    // End of variables declaration//GEN-END:variables
 private javax.swing.JOptionPane jopt1;
    private javax.swing.JOptionPane jopt2;
private String gander;
}
