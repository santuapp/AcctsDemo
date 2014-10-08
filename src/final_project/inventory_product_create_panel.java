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
 * @author virtual vista
 */
public class inventory_product_create_panel extends javax.swing.JPanel {
Font myFont = new Font("",Font.PLAIN,9);

int i=0,j=0,k=0,l=0;   // For Mandatory
int x=0,y=0,z=0;       // For Non Mandatory
    /**
     * Creates new form inventory_product_create_panel
     */
    public inventory_product_create_panel() 
    {
        initComponents();
        
        PromptSupport.setPrompt("0.00", discount_txt);
        PromptSupport.setPrompt("0.00", tax_txt);
        PromptSupport.setPrompt("0.00", quantity_txt);
        PromptSupport.setPrompt("0.00", rate_txt);
        PromptSupport.setPrompt("0.00", value_txt);
        
        refresh_form();
        
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
        
        jLabel19.setFont(myFont);
        jLabel19.setEnabled(false);
        jLabel19.setVisible(false);
        
        
        jLabel20.setFont(myFont);
        jLabel20.setEnabled(false);
        jLabel20.setVisible(false);
        
        jLabel21.setFont(myFont);
        jLabel21.setEnabled(false);
        jLabel21.setVisible(false);
        
       
  
        
        
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
        // VaLIDATION..........................
        
    // item name
        
        public void item(){
            if(item_name_txt.getText().length()==0)
      {
          item_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           i=1;
      }    
            
            
        }
        
    // group
        
        public void group(){
              if(group.getSelectedItem().equals(""))
       {
          group.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
       }
       else
       {
           group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           j=1;
       }
        }
        
      // unit
        
        public void unit(){
                     if(unit.getSelectedItem().equals(""))
       {
          unit.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel14.setEnabled(true);
          jLabel14.setForeground(Color.red);
          jLabel14.setVisible(true);
       }
       else
       {
           unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel14.setEnabled(false);  
           jLabel14.setVisible(false);
           k=1;
       }
        }
        
      // quantity
        
        public void quantity(){
              if(quantity_txt.getText().length()==0)
        {
            quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel18.setEnabled(true);
            jLabel18.setForeground(Color.red);
            jLabel18.setVisible(true);
        }
        else
        {
             String content = quantity_txt.getText();
             Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
             Matcher m = p.matcher(content);
             boolean matchFound = m.matches();
             quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel18.setEnabled(false);  
             jLabel18.setVisible(false);
             l=1;
           
            if(!matchFound)

            {
                 quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel18.setEnabled(true);
                 jLabel18.setForeground(Color.red);
                 jLabel18.setVisible(true);
                 
            }
        }
        }
        
        // rate
        
//        public void rate(){
//                 if(rate_txt.getText().length()==0)
//      
//      {
//          rate_txt.setBorder(BorderFactory.createLineBorder(Color.red));
//          jLabel19.setEnabled(true);
//          jLabel19.setForeground(Color.red);
//          jLabel19.setVisible(true);
//             
//      }  
//      else
//      {
//           rate_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
//           jLabel19.setEnabled(false);  
//           jLabel19.setVisible(false);
//           m=1;
//        }
//                 
//        }

    public void refresh_form()
    {
        item_name_txt.setText(null);
//        group.removeAll();
//        unit.removeAll();
        quantity_txt.setText(null);
        rate_txt.setText(null);
        discount_txt.setText(null);
        tax_txt.setText(null);
        product_code_txt.setText(null);
        per_txt.setText(null);
        value_txt.setText(null);
        
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            
            // Adding Items to Group
            Statement ps =con.createStatement();
            ResultSet rs=ps.executeQuery("select distinct inv_g_name from inv_group order by inv_g_id");
            
               while(rs.next())
              {
                  String name=rs.getString("inv_g_name");
                  group.addItem(name);
              }
               
            //              String name1="Others";
            //              group.addItem(name1);
            
            //Adding Items to Unit
            Statement ps2 =con.createStatement();
            ResultSet rs2=ps2.executeQuery("select distinct u_name from unit order by u_id");
            
               while(rs2.next())
              {
                  String name2=rs2.getString("u_name");
                  unit.addItem(name2);
              }
                           
            }
            catch (SQLException e)
            {
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
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

        jOptionPane1 = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        item_name_txt = new javax.swing.JTextField();
        group = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        unit = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        product_code_txt = new javax.swing.JTextField();
        reset_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        per_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        quantity_txt = new numeric.textField.NumericTextField();
        rate_txt = new numeric.textField.NumericTextField();
        value_txt = new numeric.textField.NumericTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        discount_txt = new numeric.textField.NumericTextField();
        tax_txt = new numeric.textField.NumericTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Product Creation Master");

        jLabel2.setText("*Item Name:");

        item_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        item_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_name_txtFocusLost(evt);
            }
        });

        group.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        group.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                groupFocusLost(evt);
            }
        });

        jLabel3.setText("*Group:");

        unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        unit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                unitFocusLost(evt);
            }
        });

        jLabel4.setText("*Unit:");

        jLabel9.setText("Product Code:");

        product_code_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

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
        submit_button.setPreferredSize(new java.awt.Dimension(61, 23));
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Opening Balance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N

        jLabel5.setText("*Quantity:");

        jLabel6.setText("*Rate:");
        jLabel6.setToolTipText("");

        per_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        per_txt.setEnabled(false);

        jLabel10.setText("Per:");

        jLabel11.setText("Value:");

        quantity_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        quantity_txt.setText("numericTextField1");
        quantity_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantity_txtFocusLost(evt);
            }
        });

        rate_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rate_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rate_txtFocusLost(evt);
            }
        });

        value_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        value_txt.setText("numericTextField1");
        value_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                value_txtFocusLost(evt);
            }
        });

        jLabel18.setText("Enter Quantity!");

        jLabel19.setText("Enter Rate!");

        jLabel20.setText("Enter Per!");

        jLabel21.setText("Enter Valid Value!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(per_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(value_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(per_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(value_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );

        jLabel7.setText("Discount (%):");

        jLabel8.setText("Tax (%):");

        discount_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        discount_txt.setText("numericTextField1");
        discount_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                discount_txtFocusLost(evt);
            }
        });

        tax_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tax_txt.setText("numericTextField1");
        tax_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tax_txtFocusLost(evt);
            }
        });

        jLabel12.setText("Enter Valid Item Name!");

        jLabel13.setText("Select Group!");

        jLabel14.setText("Select Unit!");

        jLabel15.setText("Enter Product Code!");

        jLabel16.setText("Enter Disc. Percentage!");

        jLabel17.setText("Enter Tax Percentage!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(item_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(product_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(discount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tax_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(reset_button)
                                .addGap(100, 100, 100)
                                .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(product_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(discount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tax_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_button))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {reset_button, submit_button});

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
// Validation Start.....
        
 
        
        
        item();
        group();
        unit();
        quantity();
   //     rate();
        
       
              if(i==1&&j==1&&k==1&&l==1&&x==0&&y==0&&z==0)
                     {
                         
      
         
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            PreparedStatement ps=con.prepareStatement("insert into product (product_name, p_group, p_unit, p_quantity, p_rate, p_discount, p_tax, product_code, p_value)values('"+item_name_txt.getText()+"','"+group.getSelectedItem().toString()+"','"+unit.getSelectedItem().toString()+"','"+quantity_txt.getText()+"','"+rate_txt.getText()+"','"+discount_txt.getText()+"','"+tax_txt.getText()+"','"+product_code_txt.getText()+"','"+value_txt.getText()+"')");
            ps.executeUpdate();
            
//            PreparedStatement ps2=con.prepareStatement("insert into `"+jComboBox1.getSelectedItem().toString()+"`(l_name,amount)values('"+jTextField1.getText()+"','"+jTextField9.getText()+"')");
//            ps2.executeUpdate();
            
            System.out.println("saved");
            refresh_form();
            jOptionPane1.showMessageDialog(this,"Product Created");
            

        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }

                     
                  
              
         }




    }//GEN-LAST:event_submit_buttonActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        item_name_txt.setText(null);
        quantity_txt.setText(null);
        rate_txt.setText(null);
        discount_txt.setText(null);
        tax_txt.setText(null);
        product_code_txt.setText(null);
        per_txt.setText(null);
        value_txt.setText(null);
        unit.setSelectedIndex(0);
        
         item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
         group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
         unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
         quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
         jLabel12.setVisible(false);
         jLabel13.setVisible(false);
         jLabel14.setVisible(false);
         jLabel18.setVisible(false);
        
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void rate_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rate_txtFocusLost
      // Selecting Unit of Product
 //       rate();
        String xuname = null;
        String xu = unit.getSelectedItem().toString();
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con3 = (Connection) DriverManager.getConnection(ConnUrl);
            
            Statement ps3 =con3.createStatement();
            ResultSet rs3=ps3.executeQuery("select distinct u_value from unit where u_name='"+xu+"'");
                                                                    
               while(rs3.next())
              {
                  
                  xuname=rs3.getString("u_value");
                  
              }
                   
            }
            catch (SQLException e)
            {
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            } 
        
        //Setting unit in short of Product
         per_txt.setText(xuname);           
        
        
        String rte  = rate_txt.getText();
        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
        Matcher matcher = pattern.matcher(rte);
        
        if (matcher.matches()) {
         
        }
        else
        {

            rate_txt.setText("");
            JOptionPane.showMessageDialog(null, "Enter Number!");
        }
        //Calculating
        String quant = quantity_txt.getText();
        
        if (!"".equals(quant))
        {
            per_txt.setText(xuname);
            Integer qty=Integer.parseInt(quant);
            Float rt = Float.parseFloat(rte);
            Float val = qty*rt;
            value_txt.setText(val.toString());
        }
        else
        {
            per_txt.setText(xuname);
            Integer qty=1;
            Float rt = Float.parseFloat(rte);
            Float val = qty*rt;
            value_txt.setText(val.toString());
            
        }
        
        
    }//GEN-LAST:event_rate_txtFocusLost

    private void quantity_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantity_txtFocusLost
              if(quantity_txt.getText().length()==0)
        {
            quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel18.setEnabled(true);
            jLabel18.setForeground(Color.red);
            jLabel18.setVisible(true);
        }
        else
        {
             String content = quantity_txt.getText();
             Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
             Matcher m = p.matcher(content);
             boolean matchFound = m.matches();
             quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel18.setEnabled(false);  
             jLabel18.setVisible(false);
             l=1;
           
            if(!matchFound)

            {
                 quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel18.setEnabled(true);
                 jLabel18.setForeground(Color.red);
                 jLabel18.setVisible(true);
                 
            }
        }
    }//GEN-LAST:event_quantity_txtFocusLost

    private void discount_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discount_txtFocusLost
        if(discount_txt.getText().length()==0)
            {
                   discount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                   jLabel16.setEnabled(false);  
                   jLabel16.setVisible(false);
                   x=0;
            }
            else
              {
                       String content = discount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       discount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel16.setEnabled(false);  
                       jLabel16.setVisible(false);
                       x=0;
                     if(!matchFound)
                    {
                        x=1;
                      discount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                      jLabel16.setEnabled(true);
                      jLabel16.setForeground(Color.red);
                      jLabel16.setVisible(true);
                     
                    }
               }
    }//GEN-LAST:event_discount_txtFocusLost

    private void tax_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tax_txtFocusLost
       
         
         if(tax_txt.getText().length()==0)
            {
                      tax_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                      jLabel17.setEnabled(false);  
                      jLabel17.setVisible(false); 
                      y=0;
            } 
            else
              { 
                       String content = tax_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       tax_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel17.setEnabled(false);  
                       jLabel17.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       tax_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel17.setEnabled(true);
                       jLabel17.setForeground(Color.red);
                       jLabel17.setVisible(true);
                     
                    }
               }
    }//GEN-LAST:event_tax_txtFocusLost

    private void value_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_value_txtFocusLost
    
          if(value_txt.getText().length()==0)
                   {
                       value_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel21.setEnabled(false);  
                       jLabel21.setVisible(false);
                       z=0;
                       
                   }
                   else
                   {
                       String content = value_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       value_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel21.setEnabled(false);  
                       jLabel21.setVisible(false);
                       z=0;
                     if(!matchFound)
                    {
                        z=1;
                       tax_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel17.setEnabled(true);
                       jLabel17.setForeground(Color.red);
                       jLabel17.setVisible(true);
                       
                    }
                   }
    }//GEN-LAST:event_value_txtFocusLost

    private void item_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_name_txtFocusLost
        if(item_name_txt.getText().length()==0)
      {
          item_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           i=1;
      }    
    }//GEN-LAST:event_item_name_txtFocusLost

    private void groupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_groupFocusLost
          if(group.getSelectedItem().equals(""))
       {
          group.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
       }
       else
       {
           group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_groupFocusLost

    private void unitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitFocusLost
                  if(unit.getSelectedItem().equals(""))
       {
          unit.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel14.setEnabled(true);
          jLabel14.setForeground(Color.red);
          jLabel14.setVisible(true);
       }
       else
       {
           unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel14.setEnabled(false);  
           jLabel14.setVisible(false);
           k=1;
       }
    }//GEN-LAST:event_unitFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private numeric.textField.NumericTextField discount_txt;
    private javax.swing.JComboBox group;
    private javax.swing.JTextField item_name_txt;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField per_txt;
    private javax.swing.JTextField product_code_txt;
    private numeric.textField.NumericTextField quantity_txt;
    private numeric.textField.NumericTextField rate_txt;
    private javax.swing.JButton reset_button;
    private javax.swing.JButton submit_button;
    private numeric.textField.NumericTextField tax_txt;
    private javax.swing.JComboBox unit;
    private numeric.textField.NumericTextField value_txt;
    // End of variables declaration//GEN-END:variables
}
