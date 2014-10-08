package final_project;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc2
 */
public class journal_edit_panel extends javax.swing.JPanel {

    /**
     * Creates new form journal_edit_panel
     */
      static String w;
    public journal_edit_panel() {
        initComponents();
        j_id.setVisible(false);
          ledger_name.removeAllItems();
          textvalidation();
          create_table();
           initialise1();
        initialise();
        search();
        update_table();
     
            table.setRowHeight(30);
       
          try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct l_name from ledger");
          while(rs.next())
          {
            
             // String name=rs.getString("l_name");
           //  reference_no.removeAllItems();
            ledger_name.addItem(rs.getString("l_name"));
             //reference_no.addItem(rs.getString("l_name"));
          }
         Statement ps1 =con.createStatement();
           ResultSet rs1=ps1.executeQuery("select distinct journal_inv from journal_creation");
          
            
             // String name=rs.getString("l_name");
           //  reference_no.removeAllItems();
                          table2.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs1));

             //reference_no.addItem(rs.getString("l_name"));
          
         
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        } 
    }

    
    ////
    private void tableMouseClicked(java.awt.event.MouseEvent evt)
    {                                   
//jComboBox1.removeAll();
       //jComboBox1.setVisible(false);
//jTextField2.setVisible(true);
            int new1=table2.getSelectedRow();
            String table_click=(table2.getModel().getValueAt(new1, 0).toString());
            System.out.println(table_click);
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
          ResultSet rs=ps1.executeQuery("SELECT journal_id,journal_select as Choose ,ledger as Perticulars, DEBIT,CREDIT from journal_creation where journal_inv='"+table_click+"'");
         int li_row=0;
           while(rs.next())
                 {
                    
                 table.setValueAt(rs.getString("Choose"), li_row, 0);
                  table.setValueAt(rs.getString("Perticulars"), li_row, 1);
                  table.setValueAt(rs.getString("DEBIT"), li_row, 2);
                   table.setValueAt(rs.getString("CREDIT"), li_row, 3);
                    table.setValueAt(rs.getString("journal_id"), li_row, 4);
                   li_row++;
                 }
           table.getColumnModel().getColumn(4).setMinWidth(0);
             table.getColumnModel().getColumn(4).setMaxWidth(0);
                table.getColumnModel().getColumn(4).setResizable(false);
          //TableColoumn tc=table.getColumnModel().getColumn(0);
        //table.removeColumn(table.getColumnModel().getColumn(4));
         //table.setTableHeader(table.getColumnModel().getColumn("SELECT"));
         
                      ResultSet rs1=ps1.executeQuery("SELECT distinct journal_inv,journal_date,journal_ref_no,journal_balance,sum(debit) as tdebit,sum(credit) as tcredit from journal_creation where journal_inv='"+table_click+"'");
                       
                  while(rs1.next())
                 {
                     String  aa=rs1.getString("journal_inv");
                      invoice_no_txt.setText(aa);
                       String  ab=rs1.getString("journal_ref_no");
                   ref_no.setText(ab);
                   String  ac=rs1.getString("journal_balance");
                   balance_txt.setText(ac);
                   String  at=rs1.getString("tdebit");
                   debit_total.setText(at);
                   String  ay=rs1.getString("tcredit");
                   credit_total.setText(ay);
                   j_date.setText(rs1.getString("journal_date"));
                 
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
           ResultSet rs=ps.executeQuery("SELECT journal_inv as JOURNAL_INVOICE from journal_creation where journal_inv like '"+s3+"%'"); 
          
              
                table2.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
           
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
           ResultSet rs=ps.executeQuery("SELECT journal_inv  from journal_creation");
          table2.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
           
          System.out.println("Done");
          
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        table2.addKeyListener(new java.awt.event.KeyAdapter()

            {

public void keyReleased(java.awt.event.KeyEvent e)

{
   
int keyvalue=e.getKeyCode();
if(keyvalue==KeyEvent.VK_ENTER)
                {
                   // jComboBox1.setVisible(false);
//jTextField2.setVisible(true);
                 int row=table2.getSelectedRow();
                 int col=table2.getSelectedColumn();
                
                if(table2.getValueAt(row, 0) != null){
                String s1= (String)table2.getValueAt(row, 0);
                
                
//JOptionPane.showMessageDialog(null,"Value in the cell clicked :"+ "" +table.getValueAt(0,(table.getSelectedColumn())).toString());

System.out.println(" Value in the row clicked :"+ " " +row+"");
System.out.println(" Value in the col clicked :"+ " " +col+"");
System.out.println(" Value in the col,row clicked :"+ " " +s1+"");

          try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con1.createStatement();
         ResultSet rs=ps1.executeQuery("SELECT journal_id,journal_select as Choose ,ledger as Perticulars, DEBIT,CREDIT from journal_creation where journal_inv='"+s1+"'");
         int li_row=0;
           while(rs.next())
                 {
                    
                 table.setValueAt(rs.getString("Choose"), li_row, 0);
                  table.setValueAt(rs.getString("Perticulars"), li_row, 1);
                  table.setValueAt(rs.getString("DEBIT"), li_row, 2);
                   table.setValueAt(rs.getString("CREDIT"), li_row, 3);
                    table.setValueAt(rs.getString("journal_id"), li_row, 4);
                   li_row++;
                 }
           table.getColumnModel().getColumn(4).setMinWidth(0);
             table.getColumnModel().getColumn(4).setMaxWidth(0);
                table.getColumnModel().getColumn(4).setResizable(false);
          //TableColoumn tc=table.getColumnModel().getColumn(0);
        //table.removeColumn(table.getColumnModel().getColumn(4));
         //table.setTableHeader(table.getColumnModel().getColumn("SELECT"));
         
                      ResultSet rs1=ps1.executeQuery("SELECT distinct journal_inv,journal_date,journal_ref_no,journal_balance,sum(debit) as tdebit,sum(credit) as tcredit from journal_creation where journal_inv='"+s1+"'");
                       
                  while(rs1.next())
                 {
                     String  aa=rs1.getString("journal_inv");
                      invoice_no_txt.setText(aa);
                       String  ab=rs1.getString("journal_ref_no");
                   ref_no.setText(ab);
                   String  ac=rs1.getString("journal_balance");
                   balance_txt.setText(ac);
                   String  at=rs1.getString("tdebit");
                   debit_total.setText(at);
                   String  ay=rs1.getString("tcredit");
                   credit_total.setText(ay);
                   j_date.setText(rs1.getString("journal_date"));
                 
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
    
    ///////
    
    
    
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        ledger_name = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        savebutton = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        Clear_button = new javax.swing.JButton();
        j_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        invoice_no_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        balance_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ref_no = new javax.swing.JTextField();
        j_date = new javax.swing.JTextField();
        credit_total = new javax.swing.JTextField();
        debit_total = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        jButton4.setText("jButton4");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        savebutton.setText("Save");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        Clear_button.setText("Clear");
        Clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(savebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(savebutton)
                .addGap(21, 21, 21)
                .addComponent(delete_button)
                .addGap(31, 31, 31)
                .addComponent(Clear_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel6.setText("Invoice No.");

        jLabel2.setText("Reference No.");

        jLabel4.setText("Balance:");

        balance_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                balance_txtFocusLost(evt);
            }
        });

        jLabel5.setText("Date");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Choose", "Perticulars", "Debit", "Credit", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(table);
        table.getColumn("Choose").setCellEditor(new DefaultCellEditor(combox1));

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(debit_total, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(credit_total, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(invoice_no_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(balance_txt))
                        .addGap(137, 137, 137)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ref_no, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(j_date)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(j_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(debit_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(credit_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(j_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1047, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed

        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            int p=table.getRowCount();
            for(int i=0;i<p;i++)
            {
                String select=table.getValueAt(i,0).toString();
                String ledger=table.getValueAt(i,1).toString();
                String debit=table.getValueAt(i,2).toString();
                String credit=table.getValueAt(i,3).toString();

                PreparedStatement ps1=con.prepareStatement("update journal_creation set journal_inv='"+invoice_no_txt.getText()+"',ledger='"+ledger+"',debit='"+debit+"',credit='"+credit+"',journal_date='"+j_date.getText()+"',journal_ref_no='"+ref_no.getText()+"',journal_balance='"+balance_txt.getText()+"',journal_select='"+select+"'");

                ps1.executeBatch();
                ps1.executeUpdate();
                 PreparedStatement ps2=con.prepareStatement("update company_main_table set get_id='"+invoice_no_txt.getText()+"',ledger='"+ledger+"',debit='"+debit+"',credit='"+credit+"',trans_date='"+j_date.getText()+"'");

                ps2.executeBatch();
                ps2.executeUpdate();
            }
            System.out.println("saved");

            jopt1.showMessageDialog(this,"Journal Updated");

        }catch (SQLException e){
            System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void balance_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_balance_txtFocusLost
        String pin = balance_txt.getText();
        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
        Matcher matcher = pattern.matcher(pin);

        if (matcher.matches()) {
        }
        else
        {

            balance_txt.setText("");
            JOptionPane.showMessageDialog(null, "Enter Number!");
        }
    }//GEN-LAST:event_balance_txtFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        DefaultTableModel y = (DefaultTableModel)table.getModel();

        Vector <String> r = new Vector <String>();
        y.addRow(r);

        initialise1();
        initialise();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        DefaultTableModel y = (DefaultTableModel)table.getModel();

        int a=y.getRowCount()- 1;

        y.removeRow(a);
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con1.createStatement();
            Statement ps2 =con1.createStatement();
            PreparedStatement ps10=con1.prepareStatement("delete from  journal_creation where purchase_id='"+j_id.getText()+"'");

            ps10.executeUpdate();

            //jComboBox1.removeAll();
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p==0)
        {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
                Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);

                PreparedStatement ps1=con1.prepareStatement("delete from  journal_creation where journal_inv='"+invoice_no_txt.getText()+"'");

                ps1.executeUpdate();
                System.out.println("Done");
                update_table();

            }catch (SQLException e){
                System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
                System.out.println("ClassNotFoundException" + ce.toString());
                

            }

        }
        j_id.setText("");
invoice_no_txt.setText("");
        balance_txt.setText("");
        j_date.setText("");
        ref_no.setText("");
         DefaultTableModel y = (DefaultTableModel)table.getModel();
         for(int i=0;i<(y.getRowCount());i++)
         {
           int a=y.getRowCount()- 1;

        y.removeRow(a);
         }
        debit_total.setText("");
        credit_total.setText("");
        
        
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void Clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_buttonActionPerformed
      
         j_id.setText("");
         invoice_no_txt.setText("");
        balance_txt.setText("");
        j_date.setText("");
        ref_no.setText("");
         DefaultTableModel y = (DefaultTableModel)table.getModel();
         for(int i=0;i<(y.getRowCount());i++)
         {
           int a=y.getRowCount()- 1;

        y.removeRow(a);
         }
        debit_total.setText("");
        credit_total.setText("");
    }//GEN-LAST:event_Clear_buttonActionPerformed
  public void initialise(){
   
       table.getModel().addTableModelListener(new TableModelListener()
        
                {
                  public void tableChanged (TableModelEvent e)
                {
		  double gtot=0.0d;
                   double gtot1=0.0d;
            int n1=table.getRowCount();
            System.out.println(n1);
            for (int i =0; i<=n1-1; i++)
            {
                if ((table.getValueAt(i, 2)) !=null)
            {
                    String s1 = (String)table.getValueAt(i, 2);
                    double d1=Double.parseDouble(s1);
                    System.out.println(s1);
                   
                   
                    gtot=gtot+d1;
                    System.out.println(gtot);
                  
            }
                String s4=Double.toString(gtot);
                    debit_total.setText(s4);
            }
             for (int i =0; i<=n1-1; i++)
            {
                if ((table.getValueAt(i, 3)) !=null)
            {
                    String s0 = (String)table.getValueAt(i, 3);
                    double d1=Double.parseDouble(s0);
                    System.out.println(s0);
                   
                   
                    gtot1=gtot1+d1;
                    System.out.println(gtot1);
                  
            }
                String s40=Double.toString(gtot1);
                    credit_total.setText(s40);
            }
            
                }
                }
          );

    }
      
    public void initialise1()
    {
  
     table.getModel().addTableModelListener(new TableModelListener(){
 public void tableChanged  (TableModelEvent e) {
                String b[] = { "Titan", "HMT" };
                String c[] = {"Nokia","Sony","Motorola","Samsung"};
                String d[] = {""};
                        int n=table.getRowCount();
 for (int j =0; j<=n-1; j++)
                    {
                        
                if (((table.getValueAt(j, 0)) !=null) && (table.getValueAt(j, 1)) ==null){
                        if (combox1.getSelectedItem().equals("Select")) {
                            //JComboBox combox2 = new JComboBox();
                            //JComboBox combox = new JComboBox();
                             JComboBox combox3 = new JComboBox(d);
                              table.getColumn("Perticulars").setCellEditor(new DefaultCellEditor(combox3));
                               
                               //combox3.setEnabled(true);
                           
                               //combox.setEnabled(false);
                                //combox2.setEnabled(false);
                                //combox2.removeAllItems();
                                //combox.removeAllItems();
                        }
                    if (combox1.getSelectedItem().equals("By")) {
                        
                            //JComboBox combox = new JComboBox(b);
                          // table.setValueAt("s1", j, 2);
                           //  combox2.removeAllItems();
                                //combox2.setEnabled(true);
                            //combox2.removeAllItems();
                               
                               
                            // table.getColumn("Debit").setCellEditor(new DefaultCellEditor(combox));

                         // combox.removeAllItems();
                                //combox.setEnabled(true); 
                                  table.getColumn("Perticulars").setCellEditor(new DefaultCellEditor(ledger_name));
                                
                                  
                        } 
                    else if (combox1.getSelectedItem().equals("To")) {
                            
                                
                               // JComboBox combox = new JComboBox(c);
                          // combox.removeAllItems();
                              //  table.setValueAt("0.00", j, 2);
                               //combox.setEnabled(true);
                      table.getColumn("Perticulars").setCellEditor(new DefaultCellEditor(ledger_name));

                        }
                }   }  }
        
 });

               }
    
    
    
    
    public void create_table(){
        String wsdf="";
     //    System.out.println(w);
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
         Statement ps1 =con.createStatement();
          Statement ps2 =con.createStatement();
           Statement ps3 =con.createStatement();
           ResultSet rs=ps.executeQuery("SELECT journal_id,journal_select as Choose ,ledger as Perticulars, DEBIT,CREDIT from journal_creation where journal_inv='"+w+"'");
         int li_row=0;
           while(rs.next())
                 {
                    
                 table.setValueAt(rs.getString("Choose"), li_row, 0);
                  table.setValueAt(rs.getString("Perticulars"), li_row, 1);
                  table.setValueAt(rs.getString("DEBIT"), li_row, 2);
                   table.setValueAt(rs.getString("CREDIT"), li_row, 3);
                    table.setValueAt(rs.getString("journal_id"), li_row, 4);
                   li_row++;
                 }
           table.getColumnModel().getColumn(4).setMinWidth(0);
             table.getColumnModel().getColumn(4).setMaxWidth(0);
                table.getColumnModel().getColumn(4).setResizable(false);
          //TableColoumn tc=table.getColumnModel().getColumn(0);
        //table.removeColumn(table.getColumnModel().getColumn(4));
         //table.setTableHeader(table.getColumnModel().getColumn("SELECT"));
         
                      ResultSet rs1=ps1.executeQuery("SELECT distinct journal_inv,journal_ref_no,journal_balance,sum(debit) as tdebit,sum(credit) as tcredit from journal_creation where journal_inv='"+w+"'");
                       
                  while(rs1.next())
                 {
                     String  aa=rs1.getString("journal_inv");
                      invoice_no_txt.setText(aa);
                       String  ab=rs1.getString("journal_ref_no");
                   ref_no.setText(ab);
                   String  ac=rs1.getString("journal_balance");
                   balance_txt.setText(ac);
                   String  at=rs1.getString("tdebit");
                   debit_total.setText(at);
                   String  ay=rs1.getString("tcredit");
                   credit_total.setText(ay);
                 
                  }
                   ResultSet rs2=ps2.executeQuery("SELECT DAYOFMONTH(journal_date) as DAY,MONTH(journal_date)as month,YEAR(journal_date) as year from journal_creation where journal_inv='"+w+"'");
                    while(rs2.next())
                    {
                        String  af=rs2.getString("DAY");
                 
                    }
                    
          System.out.println("Done");
            
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }
     public void  textvalidation(){
         invoice_no_txt.addKeyListener(new KeyAdapter(){
             private boolean SHIFT_PRESSED;
             private boolean SPACE_PRESSED;
             private boolean CAPS_LOCK_PRESSED;
            
             public void keyPressed(KeyEvent e){
           String  i=invoice_no_txt.getText();
            
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
                  invoice_no_txt.setText("");
                }
            
             }
        });
     }

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear_button;
    private javax.swing.JTextField balance_txt;
    private javax.swing.JTextField credit_total;
    private javax.swing.JTextField debit_total;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField invoice_no_txt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField j_date;
    private javax.swing.JTextField j_id;
    private javax.swing.JComboBox ledger_name;
    private javax.swing.JTextField ref_no;
    private javax.swing.JButton savebutton;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
JComboBox combox1 = new JComboBox(new String [] {"Select","By","To"});
private javax.swing.JOptionPane jopt1;
}
