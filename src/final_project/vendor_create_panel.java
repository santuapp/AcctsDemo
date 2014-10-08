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
 * @author pc2
 */
public class vendor_create_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
    
    int i=0,j=0,k=0;  // For Mandatory
    int x=0,y=0,z=0,p=0,q=0;  // For Non Mandatory
    /**
     * Creates new form vendor_create_panel
     */
    public vendor_create_panel() {
        initComponents();
        jLabel3.setVisible(false);
       v_dob.setVisible(false);
        
         jLabel17.setFont(myFont);
        jLabel17.setEnabled(false);
        jLabel17.setVisible(false);
        
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
        
        PromptSupport.setPrompt("John Smith", v_name);
        PromptSupport.setPrompt("dd/mm/yyyy", v_dob);
        PromptSupport.setPrompt("12, ABC Road", v_add);
        PromptSupport.setPrompt("123456", v_pin);
        PromptSupport.setPrompt("abc@xyz.com", v_eid);
        PromptSupport.setPrompt("+911234567890", v_mb_no);
        PromptSupport.setPrompt("+91123456789", v_ph_no);
        PromptSupport.setPrompt("12345678901", v_cst);
        PromptSupport.setPrompt("12345678901", v_vat_no);
        PromptSupport.setPrompt("AAAPL1234C", v_pan);
        
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
              v_under.addItem(name);
              
          }
          v_under.addItem("Others");
            
         
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
       // name
       
       public void name(){
           if(v_name.getText().length()==0)
        {
             v_name.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel17.setEnabled(true);
             jLabel17.setForeground(Color.red);
             jLabel17.setVisible(true);
        }
        else
        {
            String content = v_name.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            v_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel17.setEnabled(false);  
            jLabel17.setVisible(false);
            i=1;
            if(!matchFound)
            {

                v_name.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel17.setEnabled(true);
                jLabel17.setForeground(Color.red);
                jLabel17.setVisible(true);
            }
        }
       }
       
       // under
       
       public void under(){
          if(v_under.getSelectedItem().equals(""))
       {
          v_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
       }
       else
       {
           v_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           j=1;
       }
     } 
       
     // gender
     
//     public void gender(){
//        if(buttonGroup1.isSelected(null))
//        {
//             jLabel21.setEnabled(true);
//             jLabel21.setForeground(Color.red);
//             jLabel21.setVisible(true);
//        }
//     }  
     
     
       // dob
//     
//     public void dob(){
//            if(v_dob.getText().length()==0)
//        {
//            v_dob.setBorder(BorderFactory.createLineBorder(Color.red));
//            jLabel22.setEnabled(true);
//            jLabel22.setForeground(Color.red);
//            jLabel22.setVisible(true);
//        }
//        else
//        {
//            String content = v_dob.getText();
//            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
//            Matcher m = p.matcher(content);
//            boolean matchFound = m.matches();
//            v_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
//            jLabel22.setEnabled(false);  
//            jLabel22.setVisible(false);
//            if(!matchFound)
//
//            {
//
//                 v_dob.setBorder(BorderFactory.createLineBorder(Color.red));
//                 jLabel22.setEnabled(true);
//                 jLabel22.setForeground(Color.red);
//                 jLabel22.setVisible(true);
//
//            }
//        }
//         
//     }
     
     
       // phone no
     
     public void phone(){
         if(v_ph_no.getText().length()==0)
        {
            v_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel29.setEnabled(true);
            jLabel29.setForeground(Color.red);
            jLabel29.setVisible(true);
        }
        else
        {
            String content = v_ph_no.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            v_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel29.setEnabled(false);  
            jLabel29.setVisible(false);
            k=1;
           
            if(!matchFound)

            {
                 v_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel29.setEnabled(true);
                 jLabel29.setForeground(Color.red);
                 jLabel29.setVisible(true);
                 
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        v_name = new javax.swing.JTextField();
        company = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        v_under = new javax.swing.JComboBox();
        c_company = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        v_add = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        v_dob = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        v_city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        v_state = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        v_pin = new numeric.textField.NumericTextField();
        jLabel9 = new javax.swing.JLabel();
        v_eid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        v_mb_no = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        v_country = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        v_vat_no = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        v_pan = new javax.swing.JTextField();
        reset_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        v_opening = new numeric.textField.NumericTextField();
        jLabel1 = new javax.swing.JLabel();
        v_ph_no = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        v_cst = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendor Create Informations"));

        jLabel2.setText("*Name:");

        v_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_nameActionPerformed(evt);
            }
        });
        v_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_nameFocusLost(evt);
            }
        });

        buttonGroup1.add(company);
        company.setText("*Company");
        company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyActionPerformed(evt);
            }
        });

        jLabel16.setText("*Under:");

        v_under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        v_under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_underFocusLost(evt);
            }
        });

        c_company.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_companyActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Address:");

        v_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setText("*Date of Birth:");

        v_dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_dob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_dobFocusLost(evt);
            }
        });

        jLabel6.setText("City:");

        v_city.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel7.setText("State:");

        v_state.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel8.setText("Pin Code:");

        v_pin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_pin.setText("numericTextField1");
        v_pin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_pinFocusLost(evt);
            }
        });

        jLabel9.setText("Email ID:");

        v_eid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_eid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_eidFocusLost(evt);
            }
        });

        jLabel10.setText("Mobile No:");

        v_mb_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_mb_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_mb_noFocusLost(evt);
            }
        });

        jLabel14.setText("Country:");

        v_country.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setText("VAT No:");

        v_vat_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel13.setText("PAN:");

        v_pan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        submit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jLabel4.setText("Opening Balanace:");

        v_opening.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_opening.setText("0.00");
        v_opening.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_openingFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENDOR REGISTRATION FORM");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        v_ph_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_ph_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                v_ph_noFocusLost(evt);
            }
        });

        jLabel12.setText("CST No:");

        v_cst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel15.setText("*Phone No:");

        jLabel17.setText("Enter Vendor Name!");

        jLabel20.setText("Choose Under!");

        jLabel21.setText("Select Any One!");

        jLabel22.setText("Enter Valid Date of Birth!");

        jLabel23.setText("Enter Valid City Name!");

        jLabel24.setText("Enter Valid State Name!");

        jLabel25.setText("Enter Valid Country Name!");

        jLabel26.setText("Enter Valid Pincode!");

        jLabel27.setText("Enter Valid Email ID!");

        jLabel28.setText("Enter Valid Mobile Number!");

        jLabel29.setText("Enter Valid Phone Number!");

        jLabel30.setText("Enter Valid CST Number!");

        jLabel31.setText("Enter Valid VAT Number!");

        jLabel32.setText("Enter Valid PAN Number!");

        jLabel33.setText("Enter Valid Opening Balance!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(v_country, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(v_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(v_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(v_ph_no, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(v_mb_no, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(company)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton2)))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(c_company, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_under, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_name, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_add, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(v_state, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(v_city, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(reset_button)
                                    .addGap(18, 18, 18)
                                    .addComponent(submit_button))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(v_opening, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(v_cst, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(v_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(v_under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(company)
                    .addComponent(c_company, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel21))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(v_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(v_add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(v_city, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v_state, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(v_country, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(v_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(v_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(v_mb_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(v_ph_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(v_cst, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(v_vat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(v_pan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(v_opening, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_button)
                    .addComponent(submit_button))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(240, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Add Group")));

        jTextField11.setEnabled(false);

        jLabel18.setText("Group Name");
        jLabel18.setEnabled(false);

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

        jLabel34.setText("Enter Group Name!");

        jLabel35.setText("Choose Under!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField11)
                    .addComponent(jComboBox2, 0, 117, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void v_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v_nameActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
              
 

        
        
        name();
        under();
        phone();
     

      
if(i==1&&j==1&&k==1&&x==0&&y==0&&z==0&&p==0&&q==0)
{      
                    
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
 Statement ps5 =con.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT l_name from ledger where l_name='"+v_name.getText()+"'");

if(rs5.next())
{
     jopt2.showMessageDialog(this,"Vendor Already Exsist"); 
}
else{     PreparedStatement ps=con.prepareStatement("insert into vendor(v_name,v_under,v_dob,v_gender,v_address,v_city,v_state,v_pin,v_country,v_eid,v_mb_no,v_ph_no,v_vat_no,v_cst_no,v_pan)values('"+v_name.getText()+"','"+v_under.getSelectedItem().toString()+"','"+v_dob.getText()+"','"+gender+"','"+v_add.getText()+"','"+v_city.getText()+"','"+v_state.getText()+"','"+v_pin.getText()+"','"+v_country.getText()+"','"+v_eid.getText()+"','"+v_mb_no.getText()+"','"+v_ph_no.getText()+"','"+v_vat_no.getText()+"','"+v_cst.getText()+"','"+v_pan.getText()+"')");
            ps.executeUpdate();
            PreparedStatement ps2=con.prepareStatement("insert into ledger(l_name,l_under,l_address,l_state,l_pan)values('"+v_name.getText()+"','"+v_under.getSelectedItem().toString()+"','"+v_add.getText()+"','"+v_state.getText()+"','"+v_pan.getText()+"')");
            ps2.executeUpdate();
            PreparedStatement ps3=con.prepareStatement("insert into `"+v_under.getSelectedItem().toString()+"`(l_name,debit,credit)values('"+v_name.getText()+"','0','"+v_opening.getText()+"')");    
           ps3.executeUpdate();
            System.out.println("saved");

            jopt1.showMessageDialog(this,"Vendor Created");
        v_name.setText("");
        v_opening.setText("0.00");
        v_pin.setText("");
        v_dob.setText("");
        v_eid.setText("");
        v_mb_no.setText("");
        v_ph_no.setText("");
        v_vat_no.setText("");
        v_cst.setText("");
        v_pin.setText("");
        v_add.setText("");
        v_city.setText(""); 
        v_state.setText("");
        v_country.setText("");
        v_under.setSelectedIndex(0);
        c_company.setSelectedIndex(0);

        }
        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
                                  
                           
                      
                  
    }
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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

    private void c_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_companyActionPerformed

    }//GEN-LAST:event_c_companyActionPerformed

    private void companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyActionPerformed
       jLabel3.setVisible(false);
       v_dob.setVisible(false);
       c_company.setEnabled(true);
       gender=c_company.getSelectedItem().toString();
        
        
        
    }//GEN-LAST:event_companyActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
//        jLabel21.setEnabled(false);
//        jLabel21.setVisible(false);
        
        gender="Male";
       c_company.setEnabled(false);
       jLabel3.setVisible(true);
       v_dob.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
//        jLabel21.setEnabled(false);
//        jLabel21.setVisible(false);
        
        gender="Female";
        c_company.setEnabled(false);
        jLabel3.setVisible(true);
       v_dob.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        v_name.setText("");
        v_opening.setText("0.00");
        v_pin.setText("");
        v_dob.setText("");
        v_eid.setText("");
        v_mb_no.setText("");
        v_ph_no.setText("");
        v_vat_no.setText("");
        v_cst.setText("");
        v_pin.setText("");
        v_add.setText("");
        v_city.setText(""); 
        v_state.setText("");
        v_country.setText("");
        
        v_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_pin.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        v_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        c_company.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel17.setVisible(false);
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
        jLabel26.setVisible(false);
        jLabel27.setVisible(false);
        jLabel28.setVisible(false);
        jLabel29.setVisible(false);
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void v_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_nameFocusLost
         if(v_name.getText().length()==0)
        {
             v_name.setBorder(BorderFactory.createLineBorder(Color.red));
             jLabel17.setEnabled(true);
             jLabel17.setForeground(Color.red);
             jLabel17.setVisible(true);
        }
        else
        {
            String content = v_name.getText();
            Pattern p = Pattern.compile("^[a-zA-Z]+(([\\'\\,\\.\\- ][a-zA-Z ])?[a-zA-Z][\\'\\,\\.\\- ]*)*$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            System.out.println(matchFound);
            v_name.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel17.setEnabled(false);  
            jLabel17.setVisible(false);
            i=1;
            if(!matchFound)
            {

                v_name.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel17.setEnabled(true);
                jLabel17.setForeground(Color.red);
                jLabel17.setVisible(true);
            }
        }
    }//GEN-LAST:event_v_nameFocusLost

    private void v_dobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_dobFocusLost
        if(v_dob.getText().length()==0)
        {
            v_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel22.setEnabled(false);  
            jLabel22.setVisible(false);
            x=0;
        }
        else
        {
            String content = v_dob.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            v_dob.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel22.setEnabled(false);  
            jLabel22.setVisible(false);
            x=0;
            if(!matchFound)

            {
                x=1;

                 v_dob.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel22.setEnabled(true);
                 jLabel22.setForeground(Color.red);
                 jLabel22.setVisible(true);

            }
        }
    }//GEN-LAST:event_v_dobFocusLost

    private void v_pinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_pinFocusLost
         if(v_pin.getText().length()==0)
                   {
                         v_pin.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                         jLabel26.setEnabled(false);  
                         jLabel26.setVisible(false);
                         y=0;
                       
                   }
                   else
                   {
                        String pin = v_pin.getText();
                        String regEx = "\\d{6}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                        v_pin.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel26.setEnabled(false);  
                        jLabel26.setVisible(false);
                        y=0;
                      if(m.find()==false)
                    {
                        y=1;
                        v_pin.setBorder(BorderFactory.createLineBorder(Color.red));
                        jLabel26.setEnabled(true);
                        jLabel26.setForeground(Color.red);
                        jLabel26.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_v_pinFocusLost

    private void v_eidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_eidFocusLost
    
              if(v_eid.getText().length()==0)
                            {
                                 v_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                 jLabel27.setEnabled(false);  
                                 jLabel27.setVisible(false);
                                 z=0;
                                
                            }
                            else
                            {
                                 String email =v_eid.getText();
                        String regEx1 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
                        Pattern p1 = Pattern.compile(regEx1);
                        Matcher m1 = p1.matcher(email);
                        v_eid.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel27.setEnabled(false);  
                        jLabel27.setVisible(false);
                        z=0;
                       
                      if(m1.find()==false)
                    {
                        z=1;
                        v_eid.setBorder(BorderFactory.createLineBorder(Color.red));
                        jLabel27.setEnabled(true);
                        jLabel27.setForeground(Color.red);
                        jLabel27.setVisible(true);
                     
                    }
                            }
    }//GEN-LAST:event_v_eidFocusLost

    private void v_mb_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_mb_noFocusLost
      if(v_mb_no.getText().length()==0)
                             {   
                                   v_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                                   jLabel28.setEnabled(false);  
                                   jLabel28.setVisible(false);
                                   p=0;
                       
                             }
                  else
              {
                    String pin =v_mb_no.getText();
                    String regEx = "[+]\\d{10,12}";
                    Pattern p1 = Pattern.compile(regEx);
                    Matcher m = p1.matcher(pin);
                    boolean matchFound = m.matches();
                    v_mb_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                    jLabel28.setEnabled(false);  
                    jLabel28.setVisible(false);
                    p=0;
                       if(!matchFound)
                            {
                                p=1;
                              v_mb_no.setBorder(BorderFactory.createLineBorder(Color.red));
                              jLabel28.setEnabled(true);
                              jLabel28.setForeground(Color.red);
                              jLabel28.setVisible(true);
                            }
                       
               }     
    }//GEN-LAST:event_v_mb_noFocusLost

    private void v_ph_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_ph_noFocusLost
     
       if(v_ph_no.getText().length()==0)
        {
            v_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel29.setEnabled(true);
            jLabel29.setForeground(Color.red);
            jLabel29.setVisible(true);
        }
        else
        {
            String content = v_ph_no.getText();
            Pattern p = Pattern.compile("[+]\\d{3,16}");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            v_ph_no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel29.setEnabled(false);  
            jLabel29.setVisible(false);
            k=1;
           
            if(!matchFound)

            {
                 v_ph_no.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel29.setEnabled(true);
                 jLabel29.setForeground(Color.red);
                 jLabel29.setVisible(true);
                 
            }
        }                  
    }//GEN-LAST:event_v_ph_noFocusLost

    private void v_underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_underFocusLost
         if(v_under.getSelectedItem().equals(""))
       {
          v_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel20.setEnabled(true);
          jLabel20.setForeground(Color.red);
          jLabel20.setVisible(true);
       }
       else
       {
           v_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel20.setEnabled(false);  
           jLabel20.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_v_underFocusLost

    private void v_openingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_v_openingFocusLost
      if(v_opening.getText().length()==0)
        {
              v_opening.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel33.setEnabled(false);  
              jLabel33.setVisible(false);
              q=0;
        }
        else
        {
            String content = v_opening.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            v_opening.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel33.setEnabled(false);  
            jLabel33.setVisible(false);
            q=0;
            if(!matchFound)
            {
                q=1;
                v_opening.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel33.setEnabled(true);
                jLabel33.setForeground(Color.red);
                jLabel33.setVisible(true);

            }
        }
    }//GEN-LAST:event_v_openingFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox c_company;
    private javax.swing.JRadioButton company;
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
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    private javax.swing.JTextField v_add;
    private javax.swing.JTextField v_city;
    private javax.swing.JTextField v_country;
    private javax.swing.JTextField v_cst;
    private javax.swing.JTextField v_dob;
    private javax.swing.JTextField v_eid;
    private javax.swing.JTextField v_mb_no;
    private javax.swing.JTextField v_name;
    private numeric.textField.NumericTextField v_opening;
    private javax.swing.JTextField v_pan;
    private javax.swing.JTextField v_ph_no;
    private numeric.textField.NumericTextField v_pin;
    private javax.swing.JTextField v_state;
    private javax.swing.JComboBox v_under;
    private javax.swing.JTextField v_vat_no;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
private javax.swing.JOptionPane jopt2;
private String gender;
}
