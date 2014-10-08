package final_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
public class Ledger_create_panel extends javax.swing.JPanel {

    Font myFont = new Font("",Font.PLAIN,9);
    
     int i=0,j=0;     // For Mandatory
     int x=0,y=0,z=0;  // For Non Mandatory
     
   public JLabel jLabel50=new JLabel();
    
    /**
     * Creates new form Ledger_create_panel
     */
    public Ledger_create_panel() {
        initComponents();
        name_txt.setFocusable(true);
        
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
    
        jLabel15.setFont(myFont);
        jLabel15.setEnabled(false);
        jLabel15.setVisible(false);
        
        jLabel16.setFont(myFont);
        jLabel16.setEnabled(false);
        jLabel16.setVisible(false);
        
        
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
        
        jLabel25.setFont(myFont);
        jLabel25.setEnabled(false);
        jLabel25.setVisible(false);
        
        
        
        initcall();
        KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
  
  Action ShortkeyAction  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        
     //  jPanel3.setVisible(false);
    //   jPanel2.setVisible(false);
       acc_group_create gf1=new acc_group_create();
       gf1.setVisible(true);
       ledger_panel.setLayout(new BorderLayout());
       ledger_panel.add(gf1);
       
    //  gf1.setParent(this);
       ledger_panel.validate();
       ledger_panel.setVisible(true); 
        
    }
}; 

this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape");
this.getActionMap().put("escape", ShortkeyAction ); 
                   
         try{
        
//           Class.forName("com.mysql.jdbc.Driver");
//           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = Database.getConnection();//(Connection) DriverManager.getConnection(ConnUrl);
           Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct g_name from acc_group group by acc_g_id");
//            jComboBox1.addItem(d2); 
//           jComboBox1.setSelectedItem(d2);
           while(rs.next())
          {
              String name=rs.getString("g_name");
             
              l_under.addItem(name);
              
          }
          String name1="Others";
          l_under.addItem(name1);
            
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        } 
    }
     public void under(){
           if(l_under.getSelectedItem().equals(""))
      {
          l_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           l_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           j=1;
      }
        
    }
    // name
    
    
    public void name(){
            if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           i=1;
          
      }
        
    }
    
   
    
   
    
    
    public void short_cut_key(){
      
    }
    
    
private void initcall() {
        
        
        l_under.setEditable(true);
        
        //
        // Create an ActionListener for the JComboBox component.
        //
        l_under.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox jComboBox1 = (JComboBox) event.getSource();

                Object selected = jComboBox1.getSelectedItem();
                if(selected.toString().equals("Others"))
                {
                jTextField11.setEnabled(true);
                jComboBox2.setEnabled(true);
                jLabel13.setEnabled(true);
                jLabel14.setEnabled(true);
                ledger_panel.setEnabled(true);
                jButton3.setEnabled(true);
                
        try{
         
           Connection con = Database.getConnection();//(Connection) DriverManager.getConnection(ConnUrl);
           Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct g_name from acc_group group by acc_g_id");
            while(rs.next())
          {
              String name=rs.getString("g_name");
             
              jComboBox2.addItem(name);
              
          }
         
        }catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
         
        }
                }else 
                { jTextField11.setEnabled(false);
                jComboBox2.setEnabled(false);
                jLabel13.setEnabled(false);
                jLabel14.setEnabled(false);
                ledger_panel.setEnabled(false);
                jButton3.setEnabled(false);
                jComboBox2.removeAllItems();
                 
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

        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ledger_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        address_txt = new javax.swing.JTextField();
        name_txt = new javax.swing.JTextField();
        state_txt = new javax.swing.JTextField();
        account_no_txt = new javax.swing.JTextField();
        pan_it_no_txt = new javax.swing.JTextField();
        sale_tax_no_txt = new javax.swing.JTextField();
        branch_name_txt = new javax.swing.JTextField();
        ope_bal_num = new numeric.textField.NumericTextField();
        per_num = new numeric.textField.NumericTextField();
        submit_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bsr_ifsc_code_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        l_under = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ledger Create");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ledger Create Information"));

        address_txt.setAutoscrolls(false);
        address_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        address_txt.setMaximumSize(new java.awt.Dimension(6, 20));
        address_txt.setName(""); // NOI18N
        address_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_txtActionPerformed(evt);
            }
        });

        name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        name_txt.setMaximumSize(new java.awt.Dimension(2, 16));
        name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_txtActionPerformed(evt);
            }
        });
        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
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

        ope_bal_num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ope_bal_num.setText("0.00");
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

        submit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("*Name:");

        jLabel3.setText("*Under:");

        jLabel4.setText("Address:");

        jLabel5.setText("State:");

        jLabel6.setText("Account No.:");

        jLabel7.setText("PAN/IT No.:");

        jLabel8.setText("Sales Tax No.:");

        jLabel9.setText("Branch Name:");

        jLabel11.setText("Opening Balance:");

        jLabel12.setText("Percentage %:");

        jLabel10.setText("BSR/IFSC Code:");

        bsr_ifsc_code_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bsr_ifsc_code_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bsr_ifsc_code_txtFocusLost(evt);
            }
        });

        jLabel16.setText("Ledger Name Can Not Be Empty!");

        jLabel15.setText("Group Name Can Not Be Empty!");

        jLabel18.setText("Enter Correct State Name!");

        jLabel19.setText("Enter Valid Account Number!");

        jLabel20.setText("Enter Valid PAN/IT No.!");

        jLabel21.setText("Eneter Valid Sales Tax No.!");

        jLabel22.setText("Enter Valid Branch Name!");

        jLabel23.setText("Enter Valid Opening Balance!");

        jLabel24.setText("Enter Valid Percentage!");

        jLabel25.setText("Enter Valid BSR/IFSC Code!");

        l_under.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        l_under.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        l_under.setFocusable(false);
        l_under.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                l_underFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(branch_name_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(sale_tax_no_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(pan_it_no_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(address_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(name_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(state_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(account_no_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(ope_bal_num, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(per_num, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(bsr_ifsc_code_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(l_under, javax.swing.GroupLayout.Alignment.LEADING, 0, 158, Short.MAX_VALUE))
                                        .addComponent(jLabel16)))
                                .addGap(0, 14, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(submit_button)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_under, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(state_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(account_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan_it_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sale_tax_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsr_ifsc_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addComponent(ope_bal_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addComponent(per_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit_button)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(240, 255, 240));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Add Group")));

        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jTextField11.setEnabled(false);

        jLabel13.setText("Group Name");
        jLabel13.setEnabled(false);

        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jComboBox2.setEnabled(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Under");
        jLabel14.setEnabled(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        jButton3.setText("Submit");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Enter Group Name!");

        jLabel26.setText("Select Under!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton3)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, 0, 108, Short.MAX_VALUE)
                        .addComponent(jTextField11)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(16, 16, 16)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ledger_panelLayout = new javax.swing.GroupLayout(ledger_panel);
        ledger_panel.setLayout(ledger_panelLayout);
        ledger_panelLayout.setHorizontalGroup(
            ledger_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ledger_panelLayout.createSequentialGroup()
                .addGroup(ledger_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ledger_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ledger_panelLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ledger_panelLayout.setVerticalGroup(
            ledger_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ledger_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ledger_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ledger_panelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(ledger_panel);

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
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void address_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_txtActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_address_txtActionPerformed

    private void sale_tax_no_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_tax_no_txtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_sale_tax_no_txtActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
Connection con = Database.getConnection();
Statement ps5 =con.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT g_name from acc_group where g_name='"+jTextField11.getText()+"'");

if(rs5.next())
{
     jopt1.showMessageDialog(this,"Group Already Exsist"); 
}
else
{
            PreparedStatement ps=con.prepareStatement("insert into acc_group(g_name,g_under)values('"+jTextField11.getText()+"','"+jComboBox2.getSelectedItem().toString()+"')");
            ps.executeUpdate();
            System.out.println("saved");

            jopt2.showMessageDialog(this,"Saved");
            jComboBox2.removeAllItems();
           // under.removeAllItems();
            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group group by acc_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("g_name");
                l_under.addItem(name);
            }
            l_under.setSelectedItem(jTextField11.getText());
            jTextField11.setEnabled(false);
            jComboBox2.setEnabled(false);
            jLabel13.setEnabled(false);
            jLabel14.setEnabled(false);
            ledger_panel.setEnabled(false);
            jButton3.setEnabled(false);
            jComboBox2.removeAllItems();
            jTextField11.setText("");
        }
        }
catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed

       //  Validation Start.....
  
 
     

      name();
     under();
     

      
        if(i==1&&j==1&&x==0&&y==0&&z==0)
{ 
                              
                 

               
                         
                   
        try{
           Connection con = Database.getConnection();
           Statement ps5 =con.createStatement(); 
                           ResultSet rs5=ps5.executeQuery("SELECT l_name from ledger where l_name='"+name_txt.getText()+"'");

if(rs5.next())
{
     jopt1.showMessageDialog(this,"Ledger Already Exsist"); 
}
else
{
            PreparedStatement ps=con.prepareStatement("insert into ledger (l_name,l_under,l_address,l_state,l_acc_no,l_pan,l_sale_tax_no,l_branch,l_bsr_code,l_opning_balance,l_persentage)values('"+name_txt.getText()+"','"+l_under.getSelectedItem().toString()+"','"+address_txt.getText()+"','"+state_txt.getText()+"','"+account_no_txt.getText()+"','"+pan_it_no_txt.getText()+"','"+sale_tax_no_txt.getText()+"','"+branch_name_txt.getText()+"','"+bsr_ifsc_code_txt.getText()+"','"+ope_bal_num.getText()+"','"+per_num.getText()+"')");
            ps.executeUpdate();
            PreparedStatement ps2=con.prepareStatement("insert into `"+l_under.getSelectedItem().toString()+"`(l_name,debit)values('"+name_txt.getText()+"','"+ope_bal_num.getText()+"')");
            ps2.executeUpdate();
            System.out.println("saved");

            jopt1.showMessageDialog(this,"Ledger Created");
            
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
        l_under.setSelectedIndex(0);
        
             name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
            l_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
            //jComboBox1.removeAllItems();

            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select distinct g_name from acc_group group by acc_g_id");
            while(rs1.next())
            {
                String name=rs1.getString("g_name");

                l_under.addItem(name);
            }
            String name1="Others";
            l_under.addItem(name1);
        }
        }
catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
       

}
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
        l_under.setSelectedIndex(0);
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        l_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel16.setVisible(false);
        jLabel15.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bsr_ifsc_code_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bsr_ifsc_code_txtFocusLost
          
                         if(bsr_ifsc_code_txt.getText().length()==0)
                            {
                               bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel25.setEnabled(false);  
                               jLabel25.setVisible(false);
                               x=0;
                            }
                            else
                            {
                        String email =bsr_ifsc_code_txt.getText();
                        String regEx1 = "^[a-zA-Z0-9]+$";
                        Pattern p1 = Pattern.compile(regEx1);
                        Matcher m1 = p1.matcher(email);
                        bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        jLabel25.setEnabled(false);  
                        jLabel25.setVisible(false);
                        x=0;
                      if(m1.find()==false)
                    {
                        x=1;
                       bsr_ifsc_code_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel25.setEnabled(true);
                       jLabel25.setForeground(Color.red);
                       jLabel25.setVisible(true);
                     
                    }
                            }
    }//GEN-LAST:event_bsr_ifsc_code_txtFocusLost

    private void ope_bal_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ope_bal_numFocusLost
       if(ope_bal_num.getText().length()==0)
                            {
                               ope_bal_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel23.setEnabled(false);  
                               jLabel23.setVisible(false); 
                               y=0;
                            }
                            else
                            {
                       String content = ope_bal_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       ope_bal_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel23.setEnabled(false);  
                       jLabel23.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       ope_bal_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel23.setEnabled(true);
                       jLabel23.setForeground(Color.red);
                       jLabel23.setVisible(true);
                     
                    }
                            }
    }//GEN-LAST:event_ope_bal_numFocusLost

    private void per_numFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per_numFocusLost
     if(per_num.getText().length()==0)
                            {
                               per_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                               jLabel24.setEnabled(false);  
                               jLabel24.setVisible(false);
                               z=0;
                            }
                            else
                            {
                       String content = per_num.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       per_num.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel24.setEnabled(false);  
                       jLabel24.setVisible(false);
                       z=0;
                     if(!matchFound)
                    {
                        z=1;
                       per_num.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel24.setEnabled(true);
                       jLabel24.setForeground(Color.red);
                       jLabel24.setVisible(true);
                     
                    }
                            }
    }//GEN-LAST:event_per_numFocusLost

    private void name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txtFocusLost
if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel16.setEnabled(true);
          jLabel16.setForeground(Color.red);
          jLabel16.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel16.setEnabled(false);  
           jLabel16.setVisible(false);
           i=1;
          
      } 
                                
                            
        
        
    }//GEN-LAST:event_name_txtFocusLost

    private void l_underFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_l_underFocusLost
     if(l_under.getSelectedItem().equals(""))
      {
          l_under.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel15.setEnabled(true);
          jLabel15.setForeground(Color.red);
          jLabel15.setVisible(true);
             
      }  
      else
      {
           l_under.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel15.setEnabled(false);  
           jLabel15.setVisible(false);
           j=1;
         
      }
    }//GEN-LAST:event_l_underFocusLost

    private void name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_txtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account_no_txt;
    private javax.swing.JTextField address_txt;
    private javax.swing.JTextField branch_name_txt;
    private javax.swing.JTextField bsr_ifsc_code_txt;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JComboBox l_under;
    private javax.swing.JPanel ledger_panel;
    private javax.swing.JTextField name_txt;
    private numeric.textField.NumericTextField ope_bal_num;
    private javax.swing.JTextField pan_it_no_txt;
    private numeric.textField.NumericTextField per_num;
    private javax.swing.JTextField sale_tax_no_txt;
    private javax.swing.JTextField state_txt;
    private javax.swing.JButton submit_button;
    // End of variables declaration//GEN-END:variables
 private javax.swing.JOptionPane jopt1;
    private javax.swing.JOptionPane jopt2;
}
