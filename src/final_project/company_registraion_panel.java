package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * @author virtual vista
 */
public class company_registraion_panel extends javax.swing.JPanel {
    Font myFont=new Font("",Font.PLAIN,9);
    /**
     * Creates new form company_registraion_panel
     */
    public company_registraion_panel() {
        initComponents();
        
        jLabel23.setFont(myFont);
        jLabel23.setEnabled(false);
        jLabel23.setVisible(false);
        
        jLabel29.setFont(myFont);
        jLabel29.setEnabled(false);
        jLabel29.setVisible(false);
        
        jLabel30.setFont(myFont);
        jLabel30.setEnabled(false);
        jLabel30.setVisible(false);
        
        jLabel32.setFont(myFont);
        jLabel32.setEnabled(false);
        jLabel32.setVisible(false);
        
        jLabel33.setFont(myFont);
        jLabel33.setEnabled(false);
        jLabel33.setVisible(false);
        
        jLabel31.setFont(myFont);
        jLabel31.setEnabled(false);
        jLabel31.setVisible(false);
        
        jLabel35.setFont(myFont);
        jLabel35.setEnabled(false);
        jLabel35.setVisible(false);
        
        jLabel34.setFont(myFont);
        jLabel34.setEnabled(false);
        jLabel34.setVisible(false);
        
        jLabel36.setFont(myFont);
        jLabel36.setEnabled(false);
        jLabel36.setVisible(false);
        
        jLabel37.setFont(myFont);
        jLabel37.setEnabled(false);
        jLabel37.setVisible(false);
        
        jLabel38.setFont(myFont);
        jLabel38.setEnabled(false);
        jLabel38.setVisible(false);
        
         PromptSupport.setPrompt("dd", day_txt);
         PromptSupport.setPrompt("mm", month_txt);
         PromptSupport.setPrompt("yyyy", year_txt);
         PromptSupport.setPrompt("John Smith", owner_name_txt);
         PromptSupport.setPrompt("12,ABC Road", company_address_txt);
         PromptSupport.setPrompt("abc@xyz.com", email_id_txt);
         PromptSupport.setPrompt("ABC PVT LTD.", company_name_txt);
         PromptSupport.setPrompt("123456", pin_nxt);
         PromptSupport.setPrompt("+91123456789", phone_no_txt);
         PromptSupport.setPrompt("+91123456789", fax_no_txt);
         PromptSupport.setPrompt("+911234567890", mobile_txt);
         PromptSupport.setPrompt("www.abc.com", url_ip_name_txt);
         PromptSupport.setPrompt("John", user_name_txt);
         initradio();
         TextValidation();  
       
       
         
        
        
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


    
    
    private void initradio() {
        company_type.setEnabled(false);
        company_address_txt.setEnabled(false);
        male_rad.setEnabled(false);
        female_rad.setEnabled(false);
        city.setEnabled(false);
         pin_nxt.setEnabled(false);
           email_id_txt.setEnabled(false);
            phone_no_txt.setEnabled(false);
             mobile_txt.setEnabled(false);
              day_txt.setEnabled(false);
               month_txt.setEnabled(false);
                year_txt.setEnabled(false);
                 state.setEnabled(false);
                 country.setEnabled(false);
                   fax_no_txt.setEnabled(false);
                    user_name_txt.setEnabled(false);
                     vat_no_txt.setEnabled(false);
                      cst_no_txt.setEnabled(false);
                       service_tax_no_txt.setEnabled(false);
                        tan_txt.setEnabled(false);
                         pan_txt.setEnabled(false);
                         password_psttxt.setEnabled(false);
                         retype_password_pastxt.setEnabled(false);
                          owner_name_txt.setEnabled(false);
                          url_ip_name_txt.setEnabled(false);
        
        company_rad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                if (company_rad.isSelected())
                {
                   
                    company_type.setEnabled(true);
                    company_address_txt.setEnabled(true);
                    male_rad.setEnabled(true);
        female_rad.setEnabled(true);
         city.setEnabled(true);
          pin_nxt.setEnabled(true);
           email_id_txt.setEnabled(true);
            phone_no_txt.setEnabled(true);
            mobile_txt.setEnabled(true);
              day_txt.setEnabled(true);
               month_txt.setEnabled(true);
                year_txt.setEnabled(true);
                  state.setEnabled(true);
                   country.setEnabled(true);
                   fax_no_txt.setEnabled(true);
                    user_name_txt.setEnabled(true);
                     vat_no_txt.setEnabled(true);
                      cst_no_txt.setEnabled(true);
                       service_tax_no_txt.setEnabled(true);
                        tan_txt.setEnabled(true);
                         pan_txt.setEnabled(true);
                         password_psttxt.setEnabled(true);
                         retype_password_pastxt.setEnabled(true);
                          owner_name_txt.setEnabled(true);
                          url_ip_name_txt.setEnabled(true);
                }
                  if (company_rad.isSelected()==false)
                {
                   
                    company_type.setEnabled(false);
                    company_address_txt.setEnabled(false);
                    male_rad.setEnabled(false);
        female_rad.setEnabled(false);
         city.setEnabled(false);
          pin_nxt.setEnabled(false);
           email_id_txt.setEnabled(false);
            phone_no_txt.setEnabled(false);
             mobile_txt.setEnabled(false);
              day_txt.setEnabled(false);
               month_txt.setEnabled(false);
                year_txt.setEnabled(false);
                  state.setEnabled(false);
                   country.setEnabled(false);
                   fax_no_txt.setEnabled(false);
                    user_name_txt.setEnabled(false);
                     vat_no_txt.setEnabled(false);
                      cst_no_txt.setEnabled(false);
                       service_tax_no_txt.setEnabled(false);
                        tan_txt.setEnabled(false);
                         pan_txt.setEnabled(false);
                         password_psttxt.setEnabled(false);
                         retype_password_pastxt.setEnabled(false);
                          owner_name_txt.setEnabled(false);
                          url_ip_name_txt.setEnabled(false);
                }
                
            }
            
        });
         
    }
    
    
     public void TextValidation(){
        
        // Validation Start...............
        
        
        
     
       
        // Company Name Validation
        
         company_name_txt.addKeyListener(new KeyAdapter(){
            
             public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                String a1=company_name_txt.getText();
                String s1=""+c;
               String s2=a1+s1;
                Company_printable_name_txt.setText(s2);   
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        password_psttxt = new javax.swing.JPasswordField();
        retype_password_pastxt = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        user_name_txt = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        vat_no_txt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cst_no_txt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        service_tax_no_txt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tan_txt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pan_txt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        day_txt = new numeric.textField.NumericTextField();
        month_txt = new numeric.textField.NumericTextField();
        year_txt = new numeric.textField.NumericTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        company_name_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Company_printable_name_txt = new javax.swing.JTextField();
        company_rad = new javax.swing.JRadioButton();
        company_type = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        male_rad = new javax.swing.JRadioButton();
        female_rad = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        owner_name_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        company_address_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        city = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        pin_nxt = new numeric.textField.NumericTextField();
        jLabel10 = new javax.swing.JLabel();
        country = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        email_id_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        phone_no_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fax_no_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mobile_txt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        url_ip_name_txt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        reset_but = new javax.swing.JButton();
        submit_but = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(276, 155));

        jLabel16.setText("*User Name:");

        jLabel17.setText("*Password:");

        password_psttxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_psttxtFocusLost(evt);
            }
        });

        retype_password_pastxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                retype_password_pastxtFocusLost(evt);
            }
        });

        jLabel18.setText("*Re-enter Password:");

        user_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_name_txtFocusLost(evt);
            }
        });

        jLabel36.setText("Enter User Name!");

        jLabel37.setText("Enter Password!");

        jLabel38.setText("Re-enter Password!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(retype_password_pastxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_psttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(user_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_psttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retype_password_pastxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Statutory Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(276, 155));

        jLabel8.setText("VAT No:");

        jLabel19.setText("CST No:");

        jLabel20.setText("Service Tax No:");

        jLabel21.setText("TAN No:");

        jLabel22.setText("PAN No:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(cst_no_txt)
                    .addComponent(service_tax_no_txt)
                    .addComponent(tan_txt)
                    .addComponent(pan_txt))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(vat_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cst_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(service_tax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tan_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(pan_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Financial Year"));

        jLabel15.setText("*Financial Year From:");

        day_txt.setText("numericTextField1");
        day_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                day_txtFocusLost(evt);
            }
        });

        month_txt.setText("numericTextField1");
        month_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                month_txtFocusLost(evt);
            }
        });

        year_txt.setText("numericTextField1");
        year_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                year_txtFocusLost(evt);
            }
        });

        jLabel24.setText("Financial Year From:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Informations"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("*Fields are Mandetory");
        jLabel2.setToolTipText("");

        jLabel3.setText("*Company Name:");

        company_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                company_name_txtFocusLost(evt);
            }
        });

        jLabel5.setText("Company Printable Name:");

        gender.add(company_rad);
        company_rad.setText("Company");

        company_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("*Gender:");

        gender.add(male_rad);
        male_rad.setText("Male");

        gender.add(female_rad);
        female_rad.setText("Female");

        jLabel4.setText("Owner Name:");

        jLabel6.setText("Company Address:");

        jLabel7.setText("City:");

        city.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("State:");

        state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Pin Code:");

        pin_nxt.setText("numericTextField1");
        pin_nxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pin_nxtFocusLost(evt);
            }
        });

        jLabel10.setText("Country:");

        country.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Email ID:");

        email_id_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                email_id_txtFocusLost(evt);
            }
        });

        jLabel12.setText("*Phone No:");

        phone_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phone_no_txtFocusLost(evt);
            }
        });

        jLabel13.setText("Fax No:");

        fax_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fax_no_txtFocusLost(evt);
            }
        });

        jLabel14.setText("Mobile No:");

        mobile_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobile_txtFocusLost(evt);
            }
        });

        jLabel28.setText("URL/Ip Name:");

        url_ip_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                url_ip_name_txtFocusLost(evt);
            }
        });

        jLabel23.setText("Enter Company Name!");

        jLabel29.setText("Select Any One!");

        jLabel30.setText("Enter Owner Name!");

        jLabel31.setText("Enter Phone Number!");

        jLabel32.setText("Enter Valid Pincode!");

        jLabel33.setText("Enter Valid Email ID!");

        jLabel34.setText("Enter Valid  Fax No.!");

        jLabel35.setText("Enter Valid Mobile No.!");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(company_rad)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pin_nxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(company_name_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(company_address_txt, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(owner_name_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(city, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(company_type, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(email_id_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mobile_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(72, 72, 72)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Company_printable_name_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(male_rad)
                                                .addGap(18, 18, 18)
                                                .addComponent(female_rad)))
                                        .addGap(14, 14, 14))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(url_ip_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(company_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Company_printable_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(male_rad)
                    .addComponent(female_rad)
                    .addComponent(company_rad)
                    .addComponent(company_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(owner_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(company_address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel25)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pin_nxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phone_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(fax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(url_ip_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mobile_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addContainerGap())
        );

        reset_but.setText("Reset");
        reset_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_butActionPerformed(evt);
            }
        });

        submit_but.setText("Submit");
        submit_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reset_but)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit_but)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_but)
                    .addComponent(submit_but))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("COMPANY REGISTRATION FORM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submit_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_butActionPerformed
     if(company_name_txt.getText().length()==0)
           {
               JOptionPane.showMessageDialog(null, "Enter Company Name!");
               company_name_txt.requestFocus();
           //    company_name_txt.setBackground(Color.red);
           }
     else
     {
          if(company_rad.isSelected()==false&&male_rad.isSelected()==false&&female_rad.isSelected()==false)
                        {
                         JOptionPane.showMessageDialog(null, "Select the gender field!");
                        }
     
        else{
                   if(phone_no_txt.getText().length()==0)                        
                
                {
                    JOptionPane.showMessageDialog(null, "Enter Phone No!");
                    phone_no_txt.requestFocus();
                 //   phone_no_txt.setBackground(Color.red);
                }
                  else{
           
                      if(day_txt.getText().length()==0)
                 {
                      JOptionPane.showMessageDialog(null, "Enter Day!");
                      day_txt.requestFocus();
                   //   day_txt.setBackground(Color.red);
                 }
                      else{
           
                           if(month_txt.getText().length()==0)
                   {
                    JOptionPane.showMessageDialog(null, "Enter Month!");
                    month_txt.requestFocus();
                   // month_txt.setBackground(Color.red);
                     
                   }
                
                         else{
           
                           if(year_txt.getText().length()==0)
                          {
                           JOptionPane.showMessageDialog(null, "Enter Year!");
                           year_txt.requestFocus();
                     //      year_txt.setBackground(Color.red);
                          }
                
                             else{
           
                                if(user_name_txt.getText().length()==0)
                              {
                                JOptionPane.showMessageDialog(null, "Enter User Name!");
                                user_name_txt.requestFocus();
                             //   user_name_txt.setBackground(Color.red);
                                
                              }
                
                                  else{
                                      
                               
                                   if(password_psttxt.getPassword().length==0)
                                   {
                                      JOptionPane.showMessageDialog(null, "Enter Password!");
                                      password_psttxt.requestFocus();
                                  //    password_psttxt.setBackground(Color.red);
                                   }
                                          else{
           
                                     if(retype_password_pastxt.getPassword().length==0)
                               
                                   
                                      {                   
                                        JOptionPane.showMessageDialog(null, "Enter Re-Type Password");
                                        retype_password_pastxt.requestFocus();
                                       // retype_password_pastxt.setBackground(Color.red);
                                      }
                                   }        
                           }
                                     
                       }
      
                    }
                
                }
                
            }
           
        }
                
     }
       
                   
                      
    }//GEN-LAST:event_submit_butActionPerformed

    private void reset_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_butActionPerformed
      company_name_txt.setText("");
      Company_printable_name_txt.setText("");
      owner_name_txt.setText("");
      company_address_txt.setText("");
      pin_nxt.setText("");
      email_id_txt.setText("");
      phone_no_txt.setText("");
      fax_no_txt.setText("");
      mobile_txt.setText("");
      url_ip_name_txt.setText("");
      day_txt.setText("");
      month_txt.setText("");
      year_txt.setText("");
      user_name_txt.setText("");
      password_psttxt.setText("");
      retype_password_pastxt.setText("");
      vat_no_txt.setText("");
      cst_no_txt.setText("");
      service_tax_no_txt.setText("");
      tan_txt.setText("");
      pan_txt.setText("");
      jLabel26.setText("");
    }//GEN-LAST:event_reset_butActionPerformed

    private void company_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_company_name_txtFocusLost
    if(company_name_txt.getText().length()==0)
    {
        
    }
    else
    {
        
 
        String content = company_name_txt.getText();
       Pattern p = Pattern.compile("^[a-zA-Z0-9]+(([\\'\\,\\.\\- ][a-zA-Z0-9])?[a-zA-Z0-9][\\'\\,\\.\\- ]*)*$");
          Matcher m = p.matcher(content);
          boolean matchFound = m.matches();
          System.out.println(matchFound);
          company_name_txt.setBackground(Color.white);
          
          if(!matchFound)
          { 
               
                   // System.out.println("illegal company name ! " + content);
                    
                    JOptionPane.showMessageDialog(null, " Invalid Company Name!");
                   
             //       SwingUtilities.invokeLater(new FocusGrabber(company_name_txt));
                    company_name_txt.setBackground(Color.red);
                     company_name_txt.requestFocus();
          }
    }
    }//GEN-LAST:event_company_name_txtFocusLost

    private void phone_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phone_no_txtFocusLost
       if(phone_no_txt.getText().length()==0)
    {
        
    }
    else
    {
        String content = phone_no_txt.getText();
               Pattern p = Pattern.compile("[+]\\d{3,16}");
               Matcher m = p.matcher(content);
               boolean matchFound = m.matches();
               System.out.println(matchFound);
               phone_no_txt.setBackground(Color.white);
               
               if(!matchFound)
               { 
               //System.out.println("illegal company name ! " + content);
               JOptionPane.showMessageDialog(null, " Invalid Phone No!");
          //     SwingUtilities.invokeLater(new FocusGrabber(phone_no_txt));
               phone_no_txt.setBackground(Color.red);
                phone_no_txt.requestFocus();
               }
    }
    }//GEN-LAST:event_phone_no_txtFocusLost

    private void day_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_day_txtFocusLost
    if(day_txt.getText().length()==0)
    {
        
    }
    else
    {
        
 
        String content = day_txt.getText();
                      Pattern p = Pattern.compile("0?[1-9]|1[0-9]|2[0-9]|3[01]");
                      Matcher m = p.matcher(content);
                      boolean matchFound = m.matches();
                      System.out.println(matchFound);
                      day_txt.setBackground(Color.white);
                     
                      if(!matchFound)
                      {
                    
                        JOptionPane.showMessageDialog(null, " Invalid Day!");
                   
                   //     SwingUtilities.invokeLater(new FocusGrabber(day_txt));
                         day_txt.requestFocus();
                        day_txt.setBackground(Color.red);
               }
    }
    }//GEN-LAST:event_day_txtFocusLost

    private void month_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_month_txtFocusLost
        if(month_txt.getText().length()==0)
    {
        
    }
    else
    {
        String content = month_txt.getText();
                           Pattern p = Pattern.compile("0?[1-9]|1[012]");
                           Matcher m = p.matcher(content);
                           boolean matchFound = m.matches();
                           System.out.println(matchFound);
                           month_txt.setBackground(Color.white);
                           
                           
                           if(!matchFound)
                           {
                    
                           JOptionPane.showMessageDialog(null, " Invalid Month!");
                   
                      //     SwingUtilities.invokeLater(new FocusGrabber(month_txt));
                           month_txt.requestFocus();
                           month_txt.setBackground(Color.red);
                   }
    }
    }//GEN-LAST:event_month_txtFocusLost

    private void year_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_year_txtFocusLost
        if(year_txt.getText().length()==0)
    {
        
    }
    else
    {
        String content = year_txt.getText();
                           Pattern p = Pattern.compile("^\\d{4}$");
                           Matcher m = p.matcher(content);
                           boolean matchFound = m.matches();
                           year_txt.setBackground(Color.white);
                           
                           {
                                   
                             try
                             {
                            String b1=month_txt.getText();
                            int ab=Integer.parseInt(b1);
                            System.out.println(ab);
                            String b2=year_txt.getText();
                            int ac=Integer.parseInt(b2);
                            System.out.println(ac);
                            if(ab<=3)
                            {
                            int cx=ac -1;
                            String year=Integer.toString(cx);
                            String fyear=year+ ""+"-"+b2;
                            jLabel26.setText(fyear);
                            }
                            if(ab>3)
                            {
                           int cx=ac + 1;
                           String year=Integer.toString(cx);
                           String fyear=b2+ ""+"-"+year;
                           jLabel26.setText(fyear);
                           }
                           }
                           catch(NumberFormatException c)
                           {
               
                           }
                           }
                           System.out.println(matchFound);
                          
                           if(!matchFound)
                           {
                    
                    JOptionPane.showMessageDialog(null, " Invalid Year!");
                   
                //    SwingUtilities.invokeLater(new FocusGrabber(year_txt));
                     month_txt.requestFocus();
                    year_txt.setBackground(Color.red);
                    }
    }
            
    }//GEN-LAST:event_year_txtFocusLost

    private void user_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_name_txtFocusLost
            if(user_name_txt.getText().length()==0)
    {
        
    }
    else
    {
        String content = user_name_txt.getText();
                               Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
                               Matcher m = p.matcher(content);
                               boolean matchFound = m.matches();
                               System.out.println(matchFound);
                               user_name_txt.setBackground(Color.white);
                              
                                if(!matchFound)
                                { 
                            
                                 JOptionPane.showMessageDialog(null, "Invalid User Name!");
           
                            //     SwingUtilities.invokeLater(new FocusGrabber(user_name_txt));
                                  user_name_txt.requestFocus();
                                 user_name_txt.setBackground(Color.red);
                         }
    }
    }//GEN-LAST:event_user_name_txtFocusLost

    private void password_psttxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_psttxtFocusLost
                if(password_psttxt.getText().length()==0)
    {
        
    }
    else
    {
        char[] pass= password_psttxt.getPassword();
                                String content= new String(pass);
                                Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
                                Matcher m = p.matcher(content);
                                boolean matchFound = m.matches();
                                System.out.println(matchFound);
                                password_psttxt.setBackground(Color.white);
                               
                                 if(!matchFound)
                                 { 
                            
                                  JOptionPane.showMessageDialog(null, "Invalid Password!");
           
                    //              SwingUtilities.invokeLater(new FocusGrabber(password_psttxt));
                                  password_psttxt.requestFocus();
                                  password_psttxt.setBackground(Color.red);
                                                }
    }
    }//GEN-LAST:event_password_psttxtFocusLost

    private void retype_password_pastxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_retype_password_pastxtFocusLost
                       if(password_psttxt.getText().length()==0)
    {
        
    }
    else
    {
        char[] pass=  password_psttxt.getPassword();
                                    String s1= new String(pass);    
                                    char[] pas=retype_password_pastxt.getPassword();
                                    String s2= new String(pas);
                                    retype_password_pastxt.setBackground(Color.white);
                               
                                    if(s1.compareTo(s2) != 0)
                                    { 
                            
                                     JOptionPane.showMessageDialog(null, "Password does not Match!");
           
                              //       SwingUtilities.invokeLater(new FocusGrabber(password_psttxt));
                                     
                                     retype_password_pastxt.setBackground(Color.red);
                                      password_psttxt.requestFocus();
                                     retype_password_pastxt.setText("");
                                                   }
    }
    }//GEN-LAST:event_retype_password_pastxtFocusLost

    private void email_id_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_email_id_txtFocusLost
     if(email_id_txt.getText().length()==0)
                            {
                                
                            }
                            else
                            {
                                 String email =email_id_txt.getText();
                        String regEx1 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
                        Pattern p1 = Pattern.compile(regEx1);
                        Matcher m1 = p1.matcher(email);
                       
                      if(m1.find()==false)
                    {
                       JOptionPane.showMessageDialog(null, "Enter Valid Email Id!");
                       email_id_txt.requestFocus();
                     
                    }
                            }
    }//GEN-LAST:event_email_id_txtFocusLost

    private void pin_nxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pin_nxtFocusLost
        if(pin_nxt.getText().length()==0)
                   {
                       
                   }
                   else
                   {
                        String pin = pin_nxt.getText();
                        String regEx = "\\d{6}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                      if(m.find()==false)
                    {
                       JOptionPane.showMessageDialog(null, "Enter 6 Digit Pin No!");
                       pin_nxt.requestFocus();
                       
                    }
                      
                   }
    }//GEN-LAST:event_pin_nxtFocusLost

    private void fax_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fax_no_txtFocusLost
     if(fax_no_txt.getText().length()==0)
                   {
                       
                   }
                    else
                   {
                        String pin =fax_no_txt.getText();
                        String regEx = "[+]\\d{3,10}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                      if(m.find()==false)
                    {
                       JOptionPane.showMessageDialog(null, "Enter Valid Fax No!");
                       fax_no_txt.requestFocus();
                    }
                   }
    }//GEN-LAST:event_fax_no_txtFocusLost

    private void mobile_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobile_txtFocusLost
        if(mobile_txt.getText().length()==0)
                   {
                       
                   }
                   else
                   {
                        String pin =mobile_txt.getText();
                        String regEx = "[+]\\d{10,12}";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                      if(m.find()==false)
                    {
                       JOptionPane.showMessageDialog(null, "Enter Valid Mobile No!");
                       mobile_txt.requestFocus();
                    }
                       
                   }
    }//GEN-LAST:event_mobile_txtFocusLost

    private void url_ip_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_url_ip_name_txtFocusLost
        if(url_ip_name_txt.getText().length()==0)
                   {
                       
                   }
                   else
                   {
                        String pin =url_ip_name_txt.getText();
                        String regEx = "(?<http>(http:[/][/]|www.)([a-z]|[A-Z]|[0-9]|[/.]|[~])*)";
                        Pattern p = Pattern.compile(regEx);
                        Matcher m = p.matcher(pin);
                      if(m.find()==false)
                    {
                       JOptionPane.showMessageDialog(null, "Enter Valid URL!");
                       url_ip_name_txt.requestFocus();
                       
                    }
                   }
    }//GEN-LAST:event_url_ip_name_txtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Company_printable_name_txt;
    private javax.swing.JComboBox city;
    private javax.swing.JTextField company_address_txt;
    private javax.swing.JTextField company_name_txt;
    private javax.swing.JRadioButton company_rad;
    private javax.swing.JComboBox company_type;
    private javax.swing.JComboBox country;
    private javax.swing.JTextField cst_no_txt;
    private numeric.textField.NumericTextField day_txt;
    private javax.swing.JTextField email_id_txt;
    private javax.swing.JTextField fax_no_txt;
    private javax.swing.JRadioButton female_rad;
    private javax.swing.ButtonGroup gender;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton male_rad;
    private javax.swing.JTextField mobile_txt;
    private numeric.textField.NumericTextField month_txt;
    private javax.swing.JTextField owner_name_txt;
    private javax.swing.JTextField pan_txt;
    private javax.swing.JPasswordField password_psttxt;
    private javax.swing.JTextField phone_no_txt;
    private numeric.textField.NumericTextField pin_nxt;
    private javax.swing.JButton reset_but;
    private javax.swing.JPasswordField retype_password_pastxt;
    private javax.swing.JTextField service_tax_no_txt;
    private javax.swing.JComboBox state;
    private javax.swing.JButton submit_but;
    private javax.swing.JTextField tan_txt;
    private javax.swing.JTextField url_ip_name_txt;
    private javax.swing.JTextField user_name_txt;
    private javax.swing.JTextField vat_no_txt;
    private numeric.textField.NumericTextField year_txt;
    // End of variables declaration//GEN-END:variables
}
