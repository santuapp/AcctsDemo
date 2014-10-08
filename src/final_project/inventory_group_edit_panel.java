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
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class inventory_group_edit_panel extends javax.swing.JPanel {
    Font myFont=new Font("",Font.PLAIN,9);
        int i=0,j=0;

    /**
     * Creates new form inventory_group_edit_panel
     */
    public inventory_group_edit_panel() {
        
        
        initComponents();
        group_name_txt.setFocusable(true);
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
        
         try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con1.createStatement();
            ResultSet rs=ps.executeQuery("select distinct inv_g_name from inv_group  order by inv_g_id");
          
            while(rs.next())
            {
                String name=rs.getString("inv_g_name");

                under_combo.addItem(name);
               
            }
           
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        under_combo.setVisible(false);
        update_table();
        search();
        group_id.setVisible(false);
        name.setVisible(false);
        under_combo.setVisible(true);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"enter");
        table.getActionMap().put("enter", new AbstractAction() 
        
        {
        public void actionPerformed(ActionEvent e) 
        {
            //action to be performed
        }
         
        });
    }
    
    // Validation...........
    
        // group name
    
    public void group(){
              if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }
        
    }
    
    // under
    
    public void under(){
           if(under_combo.getSelectedItem().equals(""))
       {
          under_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
       }
        
    }

    
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
                        ResultSet rs=ps.executeQuery("SELECT inv_g_name as PRODUCT_GROUP_NAME from inv_group where inv_g_name like '"+s3+"%' AND inv_g_id>2"); 

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
            ResultSet rs=ps.executeQuery("SELECT DISTINCT inv_g_name as PRODUCT_GROUP_NAME from inv_group where inv_g_id > 2 ");
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
                    
                     int row=table.getSelectedRow();
                     int col=table.getSelectedColumn();
                
                     if(table.getValueAt(row, 0) != null)
                     {
                     String s1= (String)table.getValueAt(row, 0);
                
                
//JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ "" +table.getValueAt(0,(table.getSelectedColumn())).toString());

                    System.out.println(" Value in the row clicked :"+ " " +row+"");
                    System.out.println(" Value in the col clicked :"+ " " +col+"");
                    System.out.println(" Value in the col,row clicked :"+ " " +s1+"");

                    try
                    {

                     Class.forName("com.mysql.jdbc.Driver");
                     String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                     Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
                     Statement ps1 =con1.createStatement();
                     Statement ps2 =con1.createStatement();
                     ResultSet rs1=ps1.executeQuery("SELECT * from inv_group where inv_g_name='"+s1+"' AND inv_g_id>2");
                     
                     while(rs1.next())
                     {
                     String id = rs1.getString("inv_g_id");
                     group_id.setText(id);
                     
                     String  a1=rs1.getString("inv_g_name");
                     name.setText(a1);
                     group_name_txt.setText(a1);
                     
                     String  a2=rs1.getString("inv_g_under");
                     under_combo.setSelectedItem(a2);
                     }
       
                    }
                    catch (SQLException q)
                    {
                    System.out.println("Sql Exception" + q.toString());
                    }
                    catch(ClassNotFoundException ce)
                    {
                        System.out.println("ClassNotFoundException" + ce.toString());
                    }

                    }  
                    }

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
     
       private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
       
        
        
        int new1=table.getSelectedRow();
        
        String table_click=(table.getModel().getValueAt(new1, 0).toString());
        
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            Statement ps2 =con1.createStatement();
            ResultSet rs1=ps1.executeQuery("SELECT * from inv_group where inv_g_name='"+table_click+"' AND inv_g_id>2");
            //jComboBox1.removeAll();
            while(rs1.next())
                {
                     String id = rs1.getString("inv_g_id");
                     group_id.setText(id);
                     
                     String  a1=rs1.getString("inv_g_name");
                     name.setText(a1);
                     group_name_txt.setText(a1);
                     
                     String  a2=rs1.getString("inv_g_under");
                     under_combo.setSelectedItem(a2);;  
                }
       
          
          //jComboBox1.removeAll();
            }
            catch (SQLException q)
            {
            System.out.println("Sql Exception" + q.toString());
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
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        under_combo = new javax.swing.JComboBox();
        group_name_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        group_id = new javax.swing.JTextField();
        name = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventory Group Edit/Delete");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(28, 28, 28)
                .addComponent(delete_button)
                .addGap(28, 28, 28)
                .addComponent(clear_button)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Group Name:");

        under_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                under_comboActionPerformed(evt);
            }
        });
        under_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                under_comboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                under_comboFocusLost(evt);
            }
        });

        group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                group_name_txtFocusLost(evt);
            }
        });

        jLabel3.setText("Under:");

        jLabel4.setText("Enter Group Name!");

        jLabel5.setText("Enter Under!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(under_combo, 0, 148, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(under_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
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
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(group_id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addGap(241, 241, 241)))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(group_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addContainerGap(22, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
          if(name.getText().equals(""))
     {
           jOptionPane1.showMessageDialog(this,"Select Product Name!"); 
     }
        
      else {
       group();
      under();  
         if(i==1&&j==1)
    {       
    
        
        try{

           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            
           Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps5 =con2.createStatement(); 
           ResultSet rs5=ps5.executeQuery("SELECT inv_g_name from inv_group where inv_g_name='"+group_name_txt.getText()+"'");

            if(rs5.next())
            {
                 jOptionPane1.showMessageDialog(this,"Group Already Exsist"); 
            }
            
        
            
             else{
                PreparedStatement ps1=con2.prepareStatement("update inv_group set inv_g_name='"+group_name_txt.getText()+"',inv_g_under='"+under_combo.getSelectedItem().toString()+"' where  inv_g_id='"+group_id.getText()+"'");
                ps1.executeUpdate();
                Statement pss0 =con2.createStatement();
                 
          
               //  PreparedStatement ps40=con2.prepareStatement("rename table acc_database.`"+name.getText()+"` to acc_database.`"+group_name_txt.getText()+"`");
                if(name.getText()!=group_name_txt.getText())
                {
                  pss0.executeUpdate("rename table acc_database.`"+name.getText()+"` to acc_database.`"+group_name_txt.getText()+"`");
                }
                jOptionPane1.showMessageDialog(this,"Group Updated");
                
                update_table();

               
               
            



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

    private void under_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_under_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_under_comboActionPerformed

    private void under_comboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_under_comboFocusGained
       
    }//GEN-LAST:event_under_comboFocusGained

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from inv_group where inv_g_id='"+group_id.getText()+"'");

                ps1.executeUpdate();
                Statement stmt1=con1.createStatement();
                 
                stmt1.executeUpdate("drop table `"+group_name_txt.getText()+"`");

              
                System.out.println("Done");

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
            }
            group_name_txt.setText(null);
          
            search_txt.setText(null);
            group_id.setText(null);
            name.setText(null);
            
            update_table();
    }//GEN-LAST:event_delete_buttonActionPerformed
    }
    
    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
                group_name_txt.setText(null);
              
                search_txt.setText(null);
                group_id.setText(null);
                name.setText(null);
                under_combo.setSelectedItem(null);
                group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           
           jLabel4.setVisible(false);
           jLabel5.setVisible(false);
           
                
              
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void group_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_group_name_txtFocusLost
               if(group_name_txt.getText().length()==0)
      {
          group_name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }
    }//GEN-LAST:event_group_name_txtFocusLost

    private void under_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_under_comboFocusLost
           if(under_combo.getSelectedItem().equals(""))
       {
          under_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
       }
       else
       {
           under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
       }
    }//GEN-LAST:event_under_comboFocusLost
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField group_id;
    private javax.swing.JTextField group_name_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox under_combo;
    // End of variables declaration//GEN-END:variables
}
