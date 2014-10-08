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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc2
 */
public class acc_group_edit_delete_panel extends javax.swing.JPanel {
     Font myFont = new Font("",Font.PLAIN,9);
      int i=0,j=0;
    /**
     * Creates new form acc_group_edit_delete_panel
     */
    public acc_group_edit_delete_panel() {
        initComponents();
        
           try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con1.createStatement();
            ResultSet rs=ps.executeQuery("select distinct g_name from acc_group order by acc_g_id");
          
            while(rs.next())
            {
                String name=rs.getString("g_name");

                under_combo.addItem(name);
               
            }
           
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
        
        under_combo.setVisible(true);
        update_table();
         search();
          group_id.setVisible(false);
            name.setVisible(false);
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
           ResultSet rs=ps.executeQuery("SELECT g_name as GROUP_NAME from acc_group where g_name like '"+s3+"%' and acc_g_id>4"); 
          
              
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
           ResultSet rs=ps.executeQuery("SELECT g_name as GROUP_NAME from acc_group where acc_g_id > 4 ");
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
           ResultSet rs1=ps1.executeQuery("SELECT * from acc_group where g_name='"+s1+"' ");
       while(rs1.next())
                {
                    
                           // jComboBox1.removeAll(); 
                    
                  String  id=rs1.getString(1);
                  group_name_txt.setText(id);
                     String  aa=rs1.getString(2);
                     under_combo.setSelectedItem(aa);
                   
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
             private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   

            int new1=table.getSelectedRow();
            String table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from acc_group where g_name='"+table_click+"' ");
            //jComboBox1.removeAll();
       while(rs1.next())
                {
                      String  id=rs1.getString(3);
                      group_id.setText(id);
                       String  gname=rs1.getString(1);
                       
                       name.setText(gname);
                    group_name_txt.setText(gname);
                     String  aa=rs1.getString(2);
                     under_combo.setSelectedItem(aa);
                
                }
       
          
          //jComboBox1.removeAll();
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        

// TODO add your handling code here:
    }     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        group_id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        group_name_txt = new javax.swing.JTextField();
        under_combo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Save-icon.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Recycle-Bin-full-icon.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(save)
                .addGap(44, 44, 44)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(20, 20, 20))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("*Group Name:");

        jLabel3.setText("*Under:");

        group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group_name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                group_name_txtFocusLost(evt);
            }
        });

        under_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        under_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        under_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                under_comboFocusLost(evt);
            }
        });

        jLabel4.setText("Enter Group Name!");

        jLabel5.setText("Select Under!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(under_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(group_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(under_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        table.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Edit/Delete Group Ledger");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(group_id, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(group_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 // Validation Start...
        
        if(name.getText().equals(""))
     {
           jopt1.showMessageDialog(this,"Select Group Name!"); 
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
                           ResultSet rs5=ps5.executeQuery("SELECT g_name from acc_group where g_name='"+group_name_txt.getText()+"'");

if(rs5.next())
{
     jopt2.showMessageDialog(this,"Group Already Exsist"); 
}
else{
            
                PreparedStatement ps1=con2.prepareStatement("update acc_group set g_name='"+group_name_txt.getText()+"',g_under='"+under_combo.getSelectedItem().toString()+"' where  acc_g_id='"+group_id.getText()+"'");
                ps1.executeUpdate();
                  Statement pss0 =con2.createStatement();
                 
          
               //  PreparedStatement ps40=con2.prepareStatement("rename table acc_database.`"+name.getText()+"` to acc_database.`"+group_name_txt.getText()+"`");
                if(name.getText()!=group_name_txt.getText())
                {
                  pss0.executeUpdate("rename table acc_database.`"+name.getText()+"` to acc_database.`"+group_name_txt.getText()+"`");
                }
                jopt1.showMessageDialog(this,"Group Updated");
                update_table();
                //under_txt.setText(null);
                //city_txt.setText(null);
               // state_txt.setText(null);
                //country_txt.setText(null);
               // jTextField5.setText(null);
               // jTextField6.setText(null);
               // jTextField7.setText(null);
               // jTextField8.setText(null);
               // jTextField9.setText(null);
               // jTextField10.setText(null);
               // jTextField11.setText(null);
                //jTextField12.setText(null);
               // jComboBox1.removeAll();
            



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
      
    }//GEN-LAST:event_saveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from  acc_group where acc_g_id='"+group_id.getText()+"'");

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
          

            update_table();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void group_name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_group_name_txtFocusLost
//        // TODO add your handling code here:
//        if(group_name_txt.getText().length()==0){
//            
//            group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
//            jLabel4.setForeground(Color.RED);
//            jLabel4.setEnabled(true);
//            jLabel4.setVisible(true);
//            
//        }
//        else
//            group_name_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
//            jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
//            jLabel4.setEnabled(false);
//            jLabel4.setVisible(false);
        
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
//        // TODO add your handling code here:
//         if(under_combo.getSelectedItem()==null){
//            
//            under_combo.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
//        }
//        else
//            under_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        group_name_txt.setText(null);
        under_combo.setSelectedItem("");
        under_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        group_name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField group_id;
    private javax.swing.JTextField group_name_txt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JButton save;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox under_combo;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
private javax.swing.JOptionPane jopt2;
}
