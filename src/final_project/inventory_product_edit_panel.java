package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JOptionPane;
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
public class inventory_product_edit_panel extends javax.swing.JPanel {
           

    Font myFont = new Font("",Font.PLAIN,9);

int i=0,j=0,k=0,l=0;   // For Mandatory
int x=0,y=0,z=0;       // For Non Mandatory

    /**
     * Creates new form inventory_product_edit_panel
     */
    public inventory_product_edit_panel() {
      
        initComponents();
      
        fill_combo();
        update_table();
        search();
        
        PromptSupport.setPrompt("0.00", discount_txt);
        PromptSupport.setPrompt("0.00", tax_txt);
        PromptSupport.setPrompt("0.00", quantity_txt);
        PromptSupport.setPrompt("0.00", rate_txt);
        PromptSupport.setPrompt("0.00", value_txt);
        
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
        
        
        jLabel11.setFont(myFont);
        jLabel11.setEnabled(false);
        jLabel11.setVisible(false);
        
        
    }
    
           // VaLIDATION..........................
        
    // item name
        
        public void item(){
            if(item_name_txt.getText().length()==0)
      {
          item_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel11.setEnabled(true);
          jLabel11.setForeground(Color.red);
          jLabel11.setVisible(true);
             
      }  
      else
      {
           item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel11.setEnabled(false);  
           jLabel11.setVisible(false);
           i=1;
      }    
            
            
        }
        
    // group
        
        public void group(){
              if(group.getSelectedItem().equals(""))
       {
          group.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
       }
       else
       {
           group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           j=1;
       }
        }
        
      // unit
        
        public void unit(){
                     if(unit.getSelectedItem().equals(""))
       {
          unit.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
       }
       else
       {
           unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           k=1;
       }
        }
        
      // quantity
        
        public void quantity(){
              if(quantity_txt.getText().length()==0)
        {
            quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel17.setEnabled(true);
            jLabel17.setForeground(Color.red);
            jLabel17.setVisible(true);
        }
        else
        {
             String content = quantity_txt.getText();
             Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
             Matcher m = p.matcher(content);
             boolean matchFound = m.matches();
             quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel17.setEnabled(false);  
             jLabel17.setVisible(false);
             l=1;
           
            if(!matchFound)

            {
                 quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel17.setEnabled(true);
                 jLabel17.setForeground(Color.red);
                 jLabel17.setVisible(true);
                 
            }
        }
        }

    public void fill_combo()
    {
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
    
        public void update_table()
    { 
       
        try{
        
               Class.forName("com.mysql.jdbc.Driver");
               String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
               Connection con = (Connection) DriverManager.getConnection(ConnUrl);
               Statement ps =con.createStatement();
               ResultSet rs=ps.executeQuery("SELECT product_name as PRODUCT_NAME from product");
               product_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

               System.out.println("Done");
          
         
            }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
        
        product_table.addKeyListener(new java.awt.event.KeyAdapter()

            {

            public void keyReleased(java.awt.event.KeyEvent e)

            {

            int keyvalue=e.getKeyCode();
            if(keyvalue==KeyEvent.VK_ENTER)
                            {
                                                                
                             int row=product_table.getSelectedRow();
                             int col=product_table.getSelectedColumn();

                            if(product_table.getValueAt(row, 0) != null){
                            String s1= (String)product_table.getValueAt(row, 0);


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
            ResultSet rs1 =ps1.executeQuery("SELECT * from product where product_name='"+s1+"' ");
            while(rs1.next())
                {
                
                String  aa=rs1.getString("p_id");
                jTextField1.setText(aa);
                
                String a1=rs1.getString("product_name");
                item_name_txt.setText(a1);

                String a2=rs1.getString("p_group");
                group.setSelectedItem(a2);
                
                String a3=rs1.getString("p_unit");
                unit.setSelectedItem(a3);
                
                String a4=rs1.getString("p_quantity");
                quantity_txt.setText(a4);
                
                String a5=rs1.getString("p_rate");
                rate_txt.setText(a5);

                String a6=rs1.getString("p_discount");
                discount_txt.setText(a6);
                                
                String a7=rs1.getString("p_tax");
                tax_txt.setText(a7);
                
                String a8=rs1.getString("product_code");
                product_code_txt.setText(a8);
                
                String a9=rs1.getString("p_value");
                value_txt.setText(a9);
                
                
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
  
     public void search()
    {
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
        ResultSet rs=ps.executeQuery("SELECT product_name as PRODUCT_NAME from product where product_name like '"+s3+"%'"); 


        product_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

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
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        item_name_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        group = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        unit = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        product_code_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        discount_txt = new numeric.textField.NumericTextField();
        tax_txt = new numeric.textField.NumericTextField();
        quantity_txt = new numeric.textField.NumericTextField();
        rate_txt = new numeric.textField.NumericTextField();
        value_txt = new numeric.textField.NumericTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Inventory Product Edit/Delete");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(delete_button)
                .addGap(33, 33, 33)
                .addComponent(clear_button)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Item Name:");

        item_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        item_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_name_txtFocusLost(evt);
            }
        });

        jLabel3.setText("Group:");

        group.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        group.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                groupFocusLost(evt);
            }
        });

        jLabel4.setText("Unit:");

        unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        unit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        unit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                unitFocusLost(evt);
            }
        });

        jLabel7.setText("Discount(%):");

        jLabel8.setText("Tax(%):");

        jLabel9.setText("Product Code:");

        product_code_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel10.setText("Value:");

        jLabel5.setText("Quantity:");

        jLabel6.setText("Rate:");

        jLabel11.setText("Enter Item Name!");

        jLabel12.setText("Select Group!");

        jLabel13.setText("Select Unit!");

        jLabel14.setText("Enter Disc. Percentage!");

        jLabel15.setText("Enter Tax Percentage!");

        jLabel17.setText("Enter Quantity!");

        jLabel18.setText("Enter Rate!");

        jLabel19.setText("Enter Valid Value!");

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

        quantity_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        quantity_txt.setText("numericTextField1");
        quantity_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantity_txtFocusLost(evt);
            }
        });

        rate_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        rate_txt.setText("numericTextField1");
        rate_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rate_txtFocusLost(evt);
            }
        });

        value_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        value_txt.setText("numericTextField1");

        jLabel16.setText("Enter Product Code!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantity_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(rate_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(item_name_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(group, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                            .addComponent(unit, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                            .addComponent(discount_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(tax_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(product_code_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(value_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(item_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(discount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tax_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_code_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantity_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(value_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19))
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
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        product_table.setModel(new javax.swing.table.DefaultTableModel(
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
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(product_table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
       if(item_name_txt.getText().equals(""))
     {
           JOptionPane.showMessageDialog(this,"Select Product!"); 
     }
    else{
        item();
        group();
        unit();
        quantity();
        
        if(i==1&&j==1&&k==1&&l==1&&x==0&&y==0&&z==0)
                     {
      
        String invoice = jTextField1.getText();
        
        if (invoice!="")
      {  
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            
             Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);
             Statement ps5 =con2.createStatement(); 
             PreparedStatement ps1=con2.prepareStatement("update product set product_name='"+item_name_txt.getText()+"',p_group='"+group.getSelectedItem().toString()+"',p_unit='"+unit.getSelectedItem().toString()+"',product_code='"+product_code_txt.getText()+"',p_discount='"+discount_txt.getText()+"',p_tax='"+tax_txt.getText()+"',p_quantity='"+quantity_txt.getText()+"',p_rate='"+rate_txt.getText()+"',p_value='"+value_txt.getText()+"' where p_id='"+jTextField1.getText()+"'");
             ps1.executeUpdate();
 
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        jOptionPane1.showMessageDialog(this,"Product Details Updated");
        
        item_name_txt.setText(null);
        group.setSelectedItem(null);
        unit.setSelectedItem(null);
        discount_txt.setText(null);
        tax_txt.setText(null);
        product_code_txt.setText(null);
        quantity_txt.setText(null);
        rate_txt.setText(null);
        value_txt.setText(null);
                
        jTextField1.setText(null);
        search_txt.setText(null);
        
        update_table();
      }
      else
      {
      jOptionPane1.showMessageDialog(this,"Select a valid Product Name");
      }
        jTextField1.setText(null);
        search_txt.setText(null);
        update_table();
                     }
       }
    }//GEN-LAST:event_save_buttonActionPerformed

    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
         
            int new1=product_table.getSelectedRow();
            String table_click=(product_table.getModel().getValueAt(new1, 0).toString());
            
            try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from product where product_name='"+table_click+"' ");
            //jComboBox1.removeAll();
       
           while(rs1.next())
                {
                 String  aa=rs1.getString("p_id");
                jTextField1.setText(aa);
                
                String a1=rs1.getString("product_name");
                item_name_txt.setText(a1);

                String a2=rs1.getString("p_group");
                group.setSelectedItem(a2);
                
                String a3=rs1.getString("p_unit");
                unit.setSelectedItem(a3);
                
                String a4=rs1.getString("p_quantity");
                quantity_txt.setText(a4);
                
                String a5=rs1.getString("p_rate");
                rate_txt.setText(a5);

                String a6=rs1.getString("p_discount");
                discount_txt.setText(a6);
                                
                String a7=rs1.getString("p_tax");
                tax_txt.setText(a7);
                
                String a8=rs1.getString("product_code");
                product_code_txt.setText(a8);
                
                String a9=rs1.getString("p_value");
                value_txt.setText(a9);
                
                
                }
       
          
          //jComboBox1.removeAll();
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }//GEN-LAST:event_product_tableMouseClicked

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from product where p_id='"+jTextField1.getText()+"'");

                ps1.executeUpdate();
                  
                System.out.println("Done");
            }
            catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            
        jOptionPane1.showMessageDialog(this,"Product Details Deleted");
        jTextField1.setText(null);
        search_txt.setText(null);
        update_table();
        
        item_name_txt.setText(null);
        discount_txt.setText(null);
        tax_txt.setText(null);
        product_code_txt.setText(null);
        quantity_txt.setText(null);
        rate_txt.setText(null);
        value_txt.setText(null);
        
    }//GEN-LAST:event_delete_buttonActionPerformed
   }
    
    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        jTextField1.setText(null);
        search_txt.setText(null);
        update_table();
        
        item_name_txt.setText(null);
        discount_txt.setText(null);
        tax_txt.setText(null);
        product_code_txt.setText(null);
        quantity_txt.setText(null);
        rate_txt.setText(null);
        value_txt.setText(null);
        
        item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel17.setVisible(false);
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

    private void item_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_name_txtFocusLost
             if(item_name_txt.getText().length()==0)
      {
          item_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel11.setEnabled(true);
          jLabel11.setForeground(Color.red);
          jLabel11.setVisible(true);
             
      }  
      else
      {
           item_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel11.setEnabled(false);  
           jLabel11.setVisible(false);
           i=1;
      }    
    }//GEN-LAST:event_item_name_txtFocusLost

    private void groupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_groupFocusLost
               if(group.getSelectedItem().equals(""))
       {
          group.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
       }
       else
       {
           group.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_groupFocusLost

    private void unitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitFocusLost
                    if(unit.getSelectedItem().equals(""))
       {
          unit.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
       }
       else
       {
           unit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           k=1;
       }
    }//GEN-LAST:event_unitFocusLost

    private void discount_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discount_txtFocusLost
       if(discount_txt.getText().length()==0)
            {
                   discount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                   jLabel14.setEnabled(false);  
                   jLabel14.setVisible(false);
                   x=0;
            }
            else
              {
                       String content = discount_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       discount_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel14.setEnabled(false);  
                       jLabel14.setVisible(false);
                       x=0;
                     if(!matchFound)
                    {
                        x=1;
                      discount_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                      jLabel14.setEnabled(true);
                      jLabel14.setForeground(Color.red);
                      jLabel14.setVisible(true);
                     
                    }
               }
    }//GEN-LAST:event_discount_txtFocusLost

    private void tax_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tax_txtFocusLost
        if(tax_txt.getText().length()==0)
            {
                      tax_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                      jLabel15.setEnabled(false);  
                      jLabel15.setVisible(false); 
                      y=0;
            } 
            else
              { 
                       String content = tax_txt.getText();
                       Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
                       Matcher m = p.matcher(content);
                       boolean matchFound = m.matches();
                       tax_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                       jLabel15.setEnabled(false);  
                       jLabel15.setVisible(false);
                       y=0;
                     if(!matchFound)
                    {
                        y=1;
                       tax_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                       jLabel15.setEnabled(true);
                       jLabel15.setForeground(Color.red);
                       jLabel15.setVisible(true);
                     
                    }
               }
    }//GEN-LAST:event_tax_txtFocusLost

    private void quantity_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantity_txtFocusLost
              if(quantity_txt.getText().length()==0)
        {
            quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
            jLabel17.setEnabled(true);
            jLabel17.setForeground(Color.red);
            jLabel17.setVisible(true);
        }
        else
        {
             String content = quantity_txt.getText();
             Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
             Matcher m = p.matcher(content);
             boolean matchFound = m.matches();
             quantity_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
             jLabel17.setEnabled(false);  
             jLabel17.setVisible(false);
             l=1;
           
            if(!matchFound)

            {
                 quantity_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel17.setEnabled(true);
                 jLabel17.setForeground(Color.red);
                 jLabel17.setVisible(true);
                 
            }
        }
    }//GEN-LAST:event_quantity_txtFocusLost

    private void rate_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rate_txtFocusLost
           String mobile  = rate_txt.getText();
        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
        Matcher matcher = pattern.matcher(mobile);
        if (matcher.matches()) {
        }
        else
        {

            rate_txt.setText("");
            JOptionPane.showMessageDialog(null, "Enter Number!");
        }
        
        String quant = quantity_txt.getText();
        String rte = rate_txt.getText();
        
        if (!"".equals(quant))
        {
            Integer qty=Integer.parseInt(quant);
            Float rt = Float.parseFloat(rte);
            Float val = qty*rt;
            value_txt.setText(val.toString());
        }
        else
        {
            Integer qty=1;
            Float rt = Float.parseFloat(rte);
            Float val = qty*rt;
            value_txt.setText(val.toString());
        }
    }//GEN-LAST:event_rate_txtFocusLost
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_button;
    private javax.swing.JButton delete_button;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField product_code_txt;
    private javax.swing.JTable product_table;
    private numeric.textField.NumericTextField quantity_txt;
    private numeric.textField.NumericTextField rate_txt;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private numeric.textField.NumericTextField tax_txt;
    private javax.swing.JComboBox unit;
    private numeric.textField.NumericTextField value_txt;
    // End of variables declaration//GEN-END:variables
}
