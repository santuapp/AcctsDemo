
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
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc1
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
        textvalidation();
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
      public void  textvalidation(){
       name_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
            
             public void keyPressed(KeyEvent e){
           String  i=name_txt.getText();
            
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch)){
                }
                else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                }else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.SHIFT_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.SPACE_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            this.CAPS_LOCK_PRESSED = true;
        }
                else{
                    JOptionPane.showMessageDialog(null, "Special Character are not Allowed!");
                    name_txt.setText("");
                }
            
             }
        });
       
        phone_no_txt.addKeyListener(new KeyAdapter(){
            
             public void keyPressed(KeyEvent e){
           String  i=phone_no_txt.getText();
            
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Enter Number!");
                    phone_no_txt.setText("");
                }
            
             }
        });
         vat_no_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
            
             public void keyPressed(KeyEvent e){
           String  i=vat_no_txt.getText();
            
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch)){
                }
                else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                }else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.SHIFT_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.SPACE_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            this.CAPS_LOCK_PRESSED = true;
        }
                else{
                    JOptionPane.showMessageDialog(null, "Special Character are not Allowed!");
                    vat_no_txt.setText("");
                }
            
             }
        });
        cst_no_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
            
             public void keyPressed(KeyEvent e){
           String  i=cst_no_txt.getText();
            
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch)){
                }
                else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                }else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.SHIFT_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.SPACE_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            this.CAPS_LOCK_PRESSED = true;
        }
                else{
                    JOptionPane.showMessageDialog(null, "Special Character are not Allowed!");
                    cst_no_txt.setText("");
                }
            
             }
        });
        pan_no_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
            
             public void keyPressed(KeyEvent e){
           String  i=pan_no_txt.getText();
            
                char ch = e.getKeyChar();
                if(Character.isLetterOrDigit(ch)){
                }
                else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                }else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            this.SHIFT_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.SPACE_PRESSED = true;
        }else if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            this.CAPS_LOCK_PRESSED = true;
        }
                else{
                    JOptionPane.showMessageDialog(null, "Special Character are not Allowed!");
                    pan_no_txt.setText("");
                }
            
             }
        });
        
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pin_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        email_id_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        mobile_no_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        phone_no_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        vat_no_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cst_no_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pan_no_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        openning_balance_txt = new javax.swing.JTextField();
        day_txt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        country = new javax.swing.JComboBox();
        jRadioButton3 = new javax.swing.JRadioButton();
        address_txt = new javax.swing.JTextField();
        month_txt = new javax.swing.JTextField();
        year_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        city = new javax.swing.JComboBox();
        under = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Registration");
        setBackground(new java.awt.Color(51, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer Registration Form");

        name_txt.setToolTipText("Input Name");

        jLabel2.setText("Name:");

        jLabel3.setText("Date of Birth");

        gender.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        gender.add(jRadioButton2);
        jRadioButton2.setText("Female");

        jLabel5.setText("Address:");

        jLabel6.setText("City:");

        jLabel7.setText("State:");
        jLabel7.setToolTipText("");

        jLabel8.setText("Pin:");

        jLabel9.setText("Country:");

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Email ID:");

        jLabel11.setText("Mobile No:");

        jLabel12.setText("Phone No:");

        jLabel13.setText("VAT No:");

        jLabel14.setText("CST No:");

        jLabel15.setText("PAN No:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Openning Balance:");
        jLabel16.setToolTipText("");

        openning_balance_txt.setToolTipText("");
        openning_balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                openning_balance_txtFocusLost(evt);
            }
        });

        day_txt.setText("DD");
        day_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                day_txtFocusLost(evt);
            }
        });

        jLabel17.setText("Under:");

        country.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });

        gender.add(jRadioButton3);
        jRadioButton3.setText("Company");

        month_txt.setText("MM");
        month_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                month_txtFocusLost(evt);
            }
        });

        year_txt.setText("YYYY");
        year_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                year_txtFocusLost(evt);
            }
        });

        jLabel4.setToolTipText("Enter Number");

        jPanel1.setBackground(new java.awt.Color(240, 255, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Add Group")));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 108, Short.MAX_VALUE)
                    .addComponent(jTextField11))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel11)
                            .addComponent(jLabel17)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(openning_balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(pan_no_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(vat_no_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mobile_no_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email_id_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pin_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(state, javax.swing.GroupLayout.Alignment.LEADING, 0, 147, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9)
                                    .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(day_txt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cst_no_txt)
                                    .addComponent(phone_no_txt))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(address_txt, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(152, 152, 152))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobile_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(cst_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pan_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(openning_balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
                if(name_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Name");
        }
        else {
                    
               String date =day_txt.getText();
                 String month =month_txt.getText();
                 String year =year_txt.getText();
                 String a1="DD";
                 String a2="MM";
                 String a3="YYYY";
                if(date.compareTo(a1)==0&&month.compareTo(a2)==0&&year.compareTo(a3)==0)
                    
                
        {
               JOptionPane.showMessageDialog(null, "Enter Valid Date!");
        } 
        else {
                if(under.getSelectedItem()==null)
        {
               JOptionPane.showMessageDialog(null, "Select the Under Field");
        } 
       else {
                if(jRadioButton1.isSelected()==false&&jRadioButton2.isSelected()==false&&jRadioButton3.isSelected()==false)
        {
               JOptionPane.showMessageDialog(null, "Select the gender field");
        }
                
           else {
                if(address_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Address");
        } 
                else {
                if(city.getSelectedItem()==null)
        {
               JOptionPane.showMessageDialog(null, "Select the City Field");
        } 
               
                   else {
                if(state.getSelectedItem()==null)
        {
               JOptionPane.showMessageDialog(null, "Select the State Field");
        } 
                 else {
                if(country.getSelectedItem()==null)
        {
               JOptionPane.showMessageDialog(null, "Select the Country Field");
        } 
                  else {
                     String pin = pin_txt.getText();
      Pattern pattern = Pattern.compile("\\d{6}");
      Matcher matcher = pattern.matcher(pin);
       
   if (matcher.matches()==false)
               
        {
               JOptionPane.showMessageDialog(null, "Enter 6 Digit Pin Code");
        } 
                 else {
                     String email = email_id_txt.getText(); 
 String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
 Pattern p = Pattern.compile(regEx);
 Matcher m = p.matcher(email);
                if(m.find()==false)
        {
               JOptionPane.showMessageDialog(null, "Enter Valid Email ID");
        } 
               
                  else {
                String mobile  = mobile_no_txt.getText();
         Pattern patterns = Pattern.compile("\\d{10}");
          Matcher matchers = patterns.matcher(mobile);
           if (matchers.matches()==false)
        {
               JOptionPane.showMessageDialog(null, "Enter Mobile No");
        } 
                else {
                if(phone_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Phone No");
        } 
                else {
                if(vat_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter VAT No");
        } 
                else {
                if(cst_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter CST No");
        } 
                 else {
                if(cst_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter PAN No");
        } 
                 else {
                if(cst_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Opening Balance");
        } 
                }
                }
                }
                }
                }
                
                }
   
                
                
                }
                }
                }
                }
                }
                }
       }}
        }
    

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        name_txt.setText("");
         
          openning_balance_txt.setText("");
           pin_txt.setText("");
            month_txt.setText("");
             year_txt.setText("");
             email_id_txt.setText("");
              mobile_no_txt.setText("");
               phone_no_txt.setText("");
                vat_no_txt.setText("");
                 cst_no_txt.setText("");
                  pan_no_txt.setText("");
                   day_txt.setText("");
                 
                     address_txt.setText("");
               
                     
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void day_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_day_txtFocusLost
          String pass=  day_txt.getText();
      
       System.out.println(pass);
 
  int sd=Integer.parseInt(pass);
 if(sd>0&&sd<=31) 
 {
  
 }
 else
 {
  
      day_txt.setText("");
      JOptionPane.showMessageDialog(null, "Invalid Day Format");
                   
 }
    }//GEN-LAST:event_day_txtFocusLost

    private void month_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_month_txtFocusLost
        String pass=  month_txt.getText();
      
       System.out.println(pass);
 
  int sd=Integer.parseInt(pass);
 if(sd>0&&sd<=12) 
 {
  
 }
 else
 {
  
      month_txt.setText("");
      JOptionPane.showMessageDialog(null, "Invalid Month Format");
                   
 }
    }//GEN-LAST:event_month_txtFocusLost

    private void year_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_year_txtFocusLost
           String str=  year_txt.getText();
String str1="^\\d{4}$";
boolean sd=str.matches(str1);
if(sd){
    
}
else{
    
      year_txt.setText("");
      JOptionPane.showMessageDialog(null, "Invalid Year Format");
}
    }//GEN-LAST:event_year_txtFocusLost

    private void openning_balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_openning_balance_txtFocusLost
              String pin = openning_balance_txt.getText();
      Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
      Matcher matcher = pattern.matcher(pin);
       
   if (matcher.matches()) {
   }
 else
 {
     jLabel4.setText("Enter");
     
      
     
 }
    }//GEN-LAST:event_openning_balance_txtFocusLost

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

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JComboBox city;
    private javax.swing.JComboBox country;
    private javax.swing.JTextField cst_no_txt;
    private javax.swing.JTextField day_txt;
    private javax.swing.JTextField email_id_txt;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField mobile_no_txt;
    private javax.swing.JTextField month_txt;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField openning_balance_txt;
    private javax.swing.JTextField pan_no_txt;
    private javax.swing.JTextField phone_no_txt;
    private javax.swing.JTextField pin_txt;
    private javax.swing.JComboBox state;
    private javax.swing.JComboBox under;
    private javax.swing.JTextField vat_no_txt;
    private javax.swing.JTextField year_txt;
    // End of variables declaration//GEN-END:variables


     private javax.swing.JOptionPane jopt1;
    private javax.swing.JOptionPane jopt2;
}
