package final_project;
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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
 * @author pc3
 */
public class Journal_edit extends javax.swing.JFrame {

    /**
     * Creates new form Journal_edit
     */
    static String w;
    public Journal_edit(String inv) {
        w=inv;
        initComponents();
        journal_id.setVisible(false);
          ledger_name.removeAllItems();
          textvalidation();
          create_table();
            table.setRowHeight(30);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
         
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        } 
    }
    
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
         System.out.println(w);
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
                  day_txt.setText(af);
                     String  ag=rs2.getString("MONTH");
                  month_txt.setText(ag); 
                  String  ag1=rs2.getString("YEAR");
                  year_txt.setText(ag1);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        ledger_name = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        savebutton = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        Clear_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        invoice_no_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        balance_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        day_txt = new numeric.textField.NumericTextField();
        month_txt = new numeric.textField.NumericTextField();
        year_txt = new numeric.textField.NumericTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ref_no = new javax.swing.JTextField();
        debit_total = new javax.swing.JTextField();
        credit_total = new javax.swing.JTextField();
        journal_id = new javax.swing.JTextField();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Journal Edit/Delete");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        savebutton.setText("Save");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        delete_button.setText("Delete");

        Clear_button.setText("Clear");

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
                .addGap(48, 48, 48)
                .addComponent(delete_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(Clear_button)
                .addGap(24, 24, 24))
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

        day_txt.setText("numericTextField1");

        month_txt.setText("numericTextField1");

        year_txt.setText("numericTextField1");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Choose", "Perticulars", "Debit", "Credit", ""
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumn("Choose").setCellEditor(new DefaultCellEditor(combox1));
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(10);
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setMinWidth(250);
            table.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

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
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(ref_no))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(balance_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(day_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(debit_total, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(credit_total, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(journal_id, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(journal_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(debit_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(credit_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
           PreparedStatement ps10=con1.prepareStatement("delete from  journal_creation where purchase_id='"+journal_id.getText()+"'");
      
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
    
            private void tableMouseClicked(java.awt.event.MouseEvent evt) {   
                
             int n=table.getRowCount();                                
//jComboBox1.removeAll();
       //jComboBox1.setVisible(false);
//jTextField2.setVisible(true);
            int new1=table.getSelectedRow();
           // String table_click=(table.getModel().getValueAt(new1, 0).toString());
             if((table.getValueAt(n-1, 4))!=null){
            String table_click=(table.getModel().getValueAt(new1, 4).toString());
            System.out.println(table_click);
             journal_id.setText(table_click);
             }

// TODO add your handling code here:
    } 
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
              
                
         
          PreparedStatement ps1=con.prepareStatement("update journal_creation set journal_inv='"+invoice_no_txt+"',ledger='"+ledger+"',debit='"+debit+"',credit='"+credit+"',journal_date='"+year_txt+""+month_txt+""+day_txt+"',journal_ref_no='"+ref_no+"',journal_balance='"+balance_txt+"',journal_select='"+select+"'");
           
         
         ps1.executeBatch();
          ps1.executeUpdate();
         }
          System.out.println("saved");
            
          jopt1.showMessageDialog(this,"Journal Created");
         
        
           
           
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }  
                






    }//GEN-LAST:event_savebuttonActionPerformed

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
            java.util.logging.Logger.getLogger(Journal_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Journal_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Journal_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Journal_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear_button;
    private javax.swing.JTextField balance_txt;
    private javax.swing.JTextField credit_total;
    private numeric.textField.NumericTextField day_txt;
    private javax.swing.JTextField debit_total;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField invoice_no_txt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField journal_id;
    private javax.swing.JComboBox ledger_name;
    private numeric.textField.NumericTextField month_txt;
    private javax.swing.JTextField ref_no;
    private javax.swing.JButton savebutton;
    private javax.swing.JTable table;
    private numeric.textField.NumericTextField year_txt;
    // End of variables declaration//GEN-END:variables
JComboBox combox1 = new JComboBox(new String [] {"Select","By","To"});
private javax.swing.JOptionPane jopt1;
}
