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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc2
 */
public class godown_edit_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);

    int i=0,j=0;   // For Mandatory

    /**
     * Creates new form godown_edit_panel
     */
    public godown_edit_panel() {
        initComponents();
        update_table();
        search();
        gd_name.setVisible(false);
        godown_id.setVisible(true);
        
        jLabel4.setFont(myFont);
        jLabel4.setEnabled(false);
        jLabel4.setVisible(false);
        
        jLabel5.setFont(myFont);
        jLabel5.setEnabled(false);
        jLabel5.setVisible(false);
    }
    
        public void name(){
            if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }   
        }
        
          public void add(){
            if(address_txt.getText().length()==0)
      {
          address_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
             
      }  
      else
      {
           address_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
      }   
        }
    
 private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
//jComboBox1.removeAll();
       //jComboBox1.setVisible(false);
//jTextField2.setVisible(true);
            int new1=table.getSelectedRow();
            String table_click=(table.getModel().getValueAt(new1, 0).toString());
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         Statement ps2 =con1.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT * from godown where gd_name='"+table_click+"' ");
            //jComboBox1.removeAll();
       while(rs1.next())
                {
                       String  id=rs1.getString(3);
                  godown_id.setText(id);
                     String  aa=rs1.getString(1);
                      name_txt.setText(aa);
                       String  ab=rs1.getString(2);
                     address_txt.setText(ab);
                
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
           ResultSet rs=ps.executeQuery("SELECT gd_name as GODOWN_NAME from GODOWN where gd_name like '"+s3+"%'"); 
          
              
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
           ResultSet rs=ps.executeQuery("SELECT gd_name as GODOWN_NAME from godown");
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
           ResultSet rs1=ps1.executeQuery("SELECT * from godown where gd_name='"+s1+"' ");
       while(rs1.next())
                {
                    
                           // jComboBox1.removeAll(); 
                    
                  String  id=rs1.getString(3);
                  godown_id.setText(id);
                     String  aa=rs1.getString(1);
                      name_txt.setText(aa);
                       String  ab=rs1.getString(2);
                     address_txt.setText(ab);
                   
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        godown_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        address_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        gd_name = new javax.swing.JTextField();

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
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(delete_button)
                .addGap(18, 18, 18)
                .addComponent(clear_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Name:");

        name_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                name_txtFocusLost(evt);
            }
        });

        jLabel3.setText("Address:");

        address_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_txtFocusLost(evt);
            }
        });

        jLabel4.setText("Enter Godown Name!");

        jLabel5.setText("Enter Address!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Godown Edit/Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(godown_id, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(gd_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(gd_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(godown_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
// Validation Start.................
        
       if(name_txt.getText().equals(""))
     {
           jopt1.showMessageDialog(this,"Select Godown Name!"); 
     }

   
       
  else {
       name();
       add();  
         if(i==1&&j==1)
    {       
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);

            // if(city_txt.isVisible())
            // {
                PreparedStatement ps1=con2.prepareStatement("update godown set gd_name='"+name_txt.getText()+"',gd_address='"+address_txt.getText()+"',v_address='"+address_txt.getText()+"' where  gd_id='"+godown_id.getText()+"'");
                ps1.executeUpdate();
                PreparedStatement ps2=con2.prepareStatement("update purchase_table1 set purchase_gd_name='"+name_txt.getText()+"' where  purchase_gd_name='"+gd_name.getText()+"'");
                ps2.executeUpdate();
                jopt1.showMessageDialog(this,"Godown Updated");
                update_table();

                name_txt.setText(null);

                address_txt.setText(null);

                //jComboBox1.removeAll();
                // }
            /* else{
                PreparedStatement ps1=con2.prepareStatement("update ledger set l_name='"+under_txt.getText()+"',l_under='"+jComboBox1.getSelectedItem().toString()+"',l_address='"+state_txt.getText()+"',l_state='"+country_txt.getText()+"',l_acc_no='"+jTextField5.getText()+"',l_pan='"+jTextField5.getText()+"',l_sale_tax_no='"+jTextField6.getText()+"',l_branch='"+jTextField7.getText()+"',l_bsr_code='"+jTextField8.getText()+"',l_opning_balance='"+jTextField9.getText()+"',l_persentage='"+jTextField10.getText()+"' where  l_id='"+jTextField12.getText()+"'");
                ps1.executeUpdate();
                jopt1.showMessageDialog(this,"Ledger Updated");
                update_table();
                under_txt.setText(null);
                city_txt.setText(null);
                state_txt.setText(null);
                country_txt.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                jTextField7.setText(null);
                jTextField8.setText(null);
                jTextField9.setText(null);
                jTextField10.setText(null);
                jTextField11.setText(null);
                jTextField12.setText(null);
                jComboBox1.removeAll();
            }*/
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

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed

        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from  godown where gd_id='"+godown_id.getText()+"'");

                ps1.executeUpdate();
                System.out.println("Done");
                update_table();

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
                name_txt.setText(null);

                address_txt.setText(null);

            }

        }

    }//GEN-LAST:event_delete_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        name_txt.setText(null);

        address_txt.setText(null);
        
        name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        address_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void name_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_name_txtFocusLost
           if(name_txt.getText().length()==0)
      {
          name_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel4.setEnabled(true);
          jLabel4.setForeground(Color.red);
          jLabel4.setVisible(true);
             
      }  
      else
      {
           name_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel4.setEnabled(false);  
           jLabel4.setVisible(false);
           i=1;
      }   
    }//GEN-LAST:event_name_txtFocusLost

    private void address_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_txtFocusLost
           if(address_txt.getText().length()==0)
      {
          address_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel5.setEnabled(true);
          jLabel5.setForeground(Color.red);
          jLabel5.setVisible(true);
             
      }  
      else
      {
           address_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel5.setEnabled(false);  
           jLabel5.setVisible(false);
           j=1;
      }   
    }//GEN-LAST:event_address_txtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JButton clear_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField gd_name;
    private javax.swing.JTextField godown_id;
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
    private javax.swing.JTextField name_txt;
    private javax.swing.JButton save_button;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane jopt1;
}
