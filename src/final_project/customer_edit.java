
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
 * @author pc1
 */
public class customer_edit extends javax.swing.JFrame {

    /**
     * Creates new form customer_edit
     */
    public customer_edit() {
        initComponents();
         textvalidation();
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         close();
           PromptSupport.setPrompt("DD", day_txt);
         PromptSupport.setPrompt("MM", month_txt);
          PromptSupport.setPrompt("YYYY", year_txt);
    } 
      public void  textvalidation(){
         name_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
             private boolean ESCAPE_PRESSED;
            
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
        }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.ESCAPE_PRESSED = true;
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
      
      public void close(){
       KeyStroke escape1 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action action1 = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
       

dispose();
     
 
    }
 
    
};

         
getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape1, "escape");
getRootPane().getActionMap().put("escape", action1);
   
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        L_Name = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        U_label = new javax.swing.JLabel();
        under = new javax.swing.JComboBox();
        male_radiobutton = new javax.swing.JRadioButton();
        Female_radio = new javax.swing.JRadioButton();
        Company_radio = new javax.swing.JRadioButton();
        A_label = new javax.swing.JLabel();
        address_txt = new javax.swing.JTextField();
        C_label = new javax.swing.JLabel();
        S_label = new javax.swing.JLabel();
        Co_label = new javax.swing.JLabel();
        city = new javax.swing.JComboBox();
        state = new javax.swing.JComboBox();
        country = new javax.swing.JComboBox();
        P_label = new javax.swing.JLabel();
        pin_txt = new javax.swing.JTextField();
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
        opening_balance_txt = new javax.swing.JTextField();
        create_button = new javax.swing.JButton();
        day_txt = new numeric.textField.NumericTextField();
        month_txt = new numeric.textField.NumericTextField();
        year_txt = new numeric.textField.NumericTextField();
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        find_button = new javax.swing.JButton();
        refresh_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Edit/Delete");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer Edit/Delete");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("Name:");

        L_Name.setText("Date Of Birth:");

        U_label.setText("Under");

        under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(male_radiobutton);
        male_radiobutton.setText("Male");

        buttonGroup1.add(Female_radio);
        Female_radio.setText("Female");

        buttonGroup1.add(Company_radio);
        Company_radio.setText("Company");

        A_label.setText("Address:");

        C_label.setText("City:");

        S_label.setText("State:");

        Co_label.setText("Country:");

        city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        country.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        P_label.setText("Pin:");

        E_label.setText("Email Id:");

        M_label.setText("Mobile No:");

        Ph_label.setText("Phone No:");

        V_label.setText("VAT No:");

        Cst_label.setText("CST No:");

        Pan_label.setText("PAN No:");

        Op_label.setText("Opening Balance:");

        opening_balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                opening_balance_txtFocusLost(evt);
            }
        });

        create_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        create_button.setText("Create");

        day_txt.setText("numericTextField1");
        day_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                day_txtFocusLost(evt);
            }
        });

        month_txt.setText("numericTextField2");
        month_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                month_txtFocusLost(evt);
            }
        });

        year_txt.setText("numericTextField3");
        year_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                year_txtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(male_radiobutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Female_radio)
                        .addGap(50, 50, 50)
                        .addComponent(Company_radio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_Name)
                            .addComponent(jLabel3)
                            .addComponent(U_label))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(under, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(address_txt)
                            .addComponent(city, 0, 142, Short.MAX_VALUE)
                            .addComponent(state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(country, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pin_txt)
                            .addComponent(Email_Id_txt)
                            .addComponent(mobile_no_txt)
                            .addComponent(phone_no_txt)
                            .addComponent(vat_no_txt)
                            .addComponent(cst_no_txt)
                            .addComponent(pan_no_txt)
                            .addComponent(opening_balance_txt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(create_button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L_Name)
                            .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(U_label)
                    .addComponent(under, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(create_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(male_radiobutton)
                    .addComponent(Female_radio)
                    .addComponent(Company_radio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A_label)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_label)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S_label))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Co_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_label)
                    .addComponent(pin_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email_Id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobile_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ph_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cst_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cst_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pan_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pan_label))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opening_balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Op_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(234, 188));

        save_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete_button.setText("Delete");

        clear_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear_button.setText("Clear");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(save_button)
                .addGap(26, 26, 26)
                .addComponent(delete_button)
                .addGap(26, 26, 26)
                .addComponent(clear_button)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        find_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        find_button.setText("Find");

        refresh_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refresh_button.setText("Refresh");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(find_button)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refresh_button))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(find_button)
                    .addComponent(refresh_button))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(480, 480, 480))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

                if(name_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Name");
        }
         else
        {
       if(day_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Date");
        }
        else
        {
       if(month_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Month");
        }
        else
        {
       if(year_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter Year");
        }
        else {
                if(under.getSelectedItem()==null)
        {
               JOptionPane.showMessageDialog(null, "Select the Under Field");
        } 
       else {
                if(male_radiobutton.isSelected()==false&&Female_radio.isSelected()==false&&Company_radio.isSelected()==false)
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
                     String email = Email_Id_txt.getText(); 
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
                if(pan_no_txt.getText().length()==0)
        {
               JOptionPane.showMessageDialog(null, "Enter PAN No");
        } 
                 else {
                if(opening_balance_txt.getText().length()==0)
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
                }
                }
       }}
        }       
    }//GEN-LAST:event_save_buttonActionPerformed

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        name_txt.setText("");
         month_txt.setText("");
          day_txt.setText("");
           year_txt.setText("");
            address_txt.setText("");
             pin_txt.setText("");
              Email_Id_txt.setText("");
               mobile_no_txt.setText("");
                phone_no_txt.setText("");
                 vat_no_txt.setText("");
                  cst_no_txt.setText("");
                   pan_no_txt.setText("");
                    opening_balance_txt.setText("");
                     jTextField15.setText("");
                      
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void opening_balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_opening_balance_txtFocusLost
             String pin = opening_balance_txt.getText();
      Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
      Matcher matcher = pattern.matcher(pin);
       
   if (matcher.matches()) {
   }
 else
 {
  
      opening_balance_txt.setText("");
      JOptionPane.showMessageDialog(null, "Enter Number!");
 }
    }//GEN-LAST:event_opening_balance_txtFocusLost

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
            java.util.logging.Logger.getLogger(customer_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customer_edit().setVisible(true);
            }
        });
    }

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
    private javax.swing.JComboBox city;
    private javax.swing.JButton clear_button;
    private javax.swing.JComboBox country;
    private javax.swing.JButton create_button;
    private javax.swing.JTextField cst_no_txt;
    private numeric.textField.NumericTextField day_txt;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton find_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JRadioButton male_radiobutton;
    private javax.swing.JTextField mobile_no_txt;
    private numeric.textField.NumericTextField month_txt;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField opening_balance_txt;
    private javax.swing.JTextField pan_no_txt;
    private javax.swing.JTextField phone_no_txt;
    private javax.swing.JTextField pin_txt;
    private javax.swing.JButton refresh_button;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox state;
    private javax.swing.JComboBox under;
    private javax.swing.JTextField vat_no_txt;
    private numeric.textField.NumericTextField year_txt;
    // End of variables declaration//GEN-END:variables
}
