package final_project;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class normal_sale_edit_panel extends javax.swing.JPanel {

    /**
     * Creates new form normal_sale_edit_panel
     */
    String name4="",inv_no="";
    public normal_sale_edit_panel() {
        initComponents();
        fill_combo();
        update_table();
        initialise();
        cell_caculate();
        search();
        
        
        TableCellRenderer r = table1.getTableHeader().getDefaultRenderer();
        JLabel headerlabel = (JLabel)r;
        headerlabel.setHorizontalAlignment(JLabel.CENTER);
    
        

    }

    public void fill_combo()
    {
      party_combo.removeAll();
      sale_combo.removeAll();
      godown_combo.removeAll();
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            
            // Adding Items to Party Ledger
            Statement ps =con.createStatement();
            ResultSet rs=ps.executeQuery("select distinct l_name from ledger order by l_id");
            
               while(rs.next())
              {
                  String name=rs.getString("l_name");
                  party_combo.addItem(name);
                  sale_combo.addItem(name);
              }
               
            //              String name1="Others";
            //              group.addItem(name1);
            
            //Adding Items to Purchase Ledger
            Statement ps2 =con.createStatement();
            ResultSet rs2=ps2.executeQuery("select distinct gd_name from godown order by gd_id");
            
               while(rs2.next())
              {
                  String name2=rs2.getString("gd_name");
                  godown_combo.addItem(name2);
              }
               
            //Adding Items to Unit in Table
            Statement ps3 = con.createStatement();
            ResultSet rs3=ps3.executeQuery("select distinct u_name from unit order by u_id");
            
            
               while(rs3.next())
              {
                  String name3=rs3.getString("u_name");
                  unit_combox.addItem(name3);
              }   
               
            //Adding Products to Item in Table
            Statement ps4 = con.createStatement();
            ResultSet rs4 = ps4.executeQuery("select distinct product_name from product order by p_id");
            
            
               while(rs4.next())
              {
                  String name4=rs4.getString("product_name");
                  item_combox.addItem(name4);
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
     
     //Setting Current Date to Date Field  
     /*
     Date dt = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
     String dtf = sdf.format(dt);
     date_txt.setText(dtf);
     */
    }
    
     public void update_table()
    { 
       
         
        try{
        
               Class.forName("com.mysql.jdbc.Driver");
               String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
               Connection con = (Connection) DriverManager.getConnection(ConnUrl);
               Statement ps =con.createStatement();
               ResultSet rs=ps.executeQuery("SELECT sale_inv as SALES_INVOICE from sale_table1");
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
            Statement ps3 =con1.createStatement();
            ResultSet rs1 =ps1.executeQuery("SELECT * from sale_table1 where sale_inv='"+s1+"' ");
            while(rs1.next())
                {
                
                String  aa=rs1.getString("sale_id");
                jTextField1.setText(aa);
                
                String a1=rs1.getString("sale_inv");
                invoice_no_txt.setText(a1);
                jTextField2.setText(a1);

                String a2=rs1.getString("sale_date");
                date_txt.setText("");
                date_txt.setText(a2);
                                
                String a3=rs1.getString("sale_party_name");
                party_combo.setSelectedItem(a3);
                
                String a4=rs1.getString("sale_current_balance");
                curbalnc_txt.setText(a4);
                
                String a5=rs1.getString("sale_ledger");
                sale_combo.setSelectedItem(a5);
                
                String a6=rs1.getString("sale_gd_name");
                godown_combo.setSelectedItem(a6);
                                                
                
            
            // Code to Save & Edit Sale Table 3 with value from JTextField 3
            String sch3 = jTextField2.getText().toString();
            System.out.println(sch3);
            Integer srch3 = Integer.parseInt(sch3);
            System.out.println("Invoice No.:"+srch3);
            
            ResultSet rs3=ps3.executeQuery("SELECT * from sale_table3 where sale_inv_no='"+srch3+"' ");
            while (rs3.next())
            {
                String ax = rs3.getString("sale_id");
                jTextField3.setText(ax);
            }

                }
            //Code to fill Item Table
           DefaultTableModel y1 = (DefaultTableModel)table1.getModel();
            int fr = y1.getRowCount();
            while (fr>=1)
            {   
            int a=y1.getRowCount()- 1;
            y1.removeRow(a);
            fr--;
            }
        
            
            
           ResultSet rs2=ps2.executeQuery("SELECT * from sale_table2 where sale_inv_no='"+s1+"' ");
        
//sale_item AS Item, sale_unit AS Unit, sale_quantity AS Quantity, sale_rate AS Rate, sale_amount AS Amount, sale_tax AS Amount, sale_taxable_amnt AS Taxable_Amt, sale_disc AS Discount, sale_disc_amnt AS Discount_Amt, sale_total AS Total
           
           //table1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs2));
           
           int li_row=0;
           int rw = 0;
           Vector <String> r[] = (Vector <String> []) new Vector[1000];
           
           
           table1.getColumnModel().getColumn(10).setMinWidth(0);
           table1.getColumnModel().getColumn(10).setMaxWidth(0);
           table1.getColumnModel().getColumn(10).setResizable(false);
           
           while(rs2.next())
                 {
                 y1.addRow(r[rw]); 
                    
                 table1.setValueAt(rs2.getString("sale_item"), li_row, 0);
                 table1.setValueAt(rs2.getString("sale_unit"), li_row, 1);
                 
                 Double sqty = Double.parseDouble(rs2.getString("sale_quantity"));
                 table1.setValueAt(sqty, li_row, 2);
                 
                 Double srt = Double.parseDouble(rs2.getString("sale_rate"));
                 table1.setValueAt(srt, li_row, 3);
                 
                 Double samnt = Double.parseDouble(rs2.getString("sale_amount"));
                 table1.setValueAt(samnt, li_row, 4);
                 
                 Double stax = Double.parseDouble(rs2.getString("sale_tax"));
                 table1.setValueAt(stax, li_row, 5);
                 
                 Double stxamnt = Double.parseDouble(rs2.getString("sale_taxable_amnt"));
                 table1.setValueAt(stxamnt, li_row, 6);
                 
                 Double sdisc = Double.parseDouble(rs2.getString("sale_disc"));
                 table1.setValueAt(sdisc, li_row, 7);
                 
                 Double sdamnt = Double.parseDouble(rs2.getString("sale_disc_amnt"));
                 table1.setValueAt(sdamnt, li_row, 8);
                 
                 table1.setValueAt(rs2.getString("sale_total"), li_row, 9);
                 
                 table1.setValueAt(rs2.getString("sale_id"), li_row, 10);
                 
                 rw++;
                 li_row++;
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
        ResultSet rs=ps.executeQuery("SELECT sale_inv as SALES_INVOICE from sale_table1 where sale_inv like '"+s3+"%'"); 
           

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
     
     
     
      public void initialise()
         {
            table1.setRowHeight(25);
            table1.getModel().addTableModelListener(new TableModelListener()
        
                {
                  public void tableChanged (TableModelEvent e)
                {
		  double gtot=0.0d;
            int n1=table1.getRowCount();
            System.out.println(n1);
            for (int i =0; i<=n1-1; i++)
            {
                if ((table1.getValueAt(i, 9)) !=null)
            {
                    String s1 = (String)table1.getValueAt(i, 9);
                    double d1=Double.parseDouble(s1);
                    System.out.println(s1);
                    
                    gtot=gtot+d1;
                    System.out.println(gtot);
                  
            }
                String s4=Double.toString(gtot);
                    gross_total.setText(s4);
            }
            
                }
                }
          );

         }

     public void cell_caculate()
     {
          
      table1.getModel().addTableModelListener(new TableModelListener()
        
                {
                  public void tableChanged (TableModelEvent e)
                {
                  int n=table1.getRowCount();
                  System.out.println(n);
                  for (int j = 0; j<=n-1; j++)
                    {
                        if (((table1.getValueAt(j, 2)) !=null) && (table1.getValueAt(j, 3)) !=null)
                        {
//                            String q1 = table1.getValueAt(j, 2).toString();
//                            
//                            double q = Double.parseDouble(q1);
                            double q = (double) table1.getValueAt(j, 2);
                            System.out.println(q);
                            //double q1 = Double.parseDouble(q);
                            double r = (double) table1.getValueAt(j, 3);
                            System.out.println(r);
                            // double r1 = Double.parseDouble(r);
                            double gtotal=0.0d;
                            double gtotal1=0.0d;
                            double tax_amnt=0.0d;
                            double disc_amnt=0.0d;
                            double tot =  (q*r);
                          // String tot1 = Double.toString(tot);
                            System.out.println(tot);
                            //System.out.flush();
                           if (table1.getValueAt(j, 4) == null)
                                {
                               table1.setValueAt(tot, j, 4);
                                }
                           if (table1.getValueAt(j, 5) != null)
                                {
                                double tax = (Double)table1.getValueAt(j, 5);
                                tax_amnt= (tot*tax)/100;
                                
                                if(table1.getValueAt(j, 6) == null)
                                    {
                                     System.out.println(tax_amnt);
                                     table1.setValueAt(tax_amnt, j, 6);
                                    }
                                }
                           if (table1.getValueAt(j, 7) != null) 
                                {
                                double disc = (Double)table1.getValueAt(j, 7);
                                disc_amnt= (tot*disc)/100;
                                
                                if(table1.getValueAt(j, 8) == null)
                                {
                                  System.out.println(disc_amnt);
                                  table1.setValueAt(disc_amnt, j, 8);
                                }
                                  
                                }
                           
          
                           if (table1.getValueAt(j, 8) != null&&table1.getValueAt(j, 6) != null&&table1.getValueAt(j, 4) != null&&table1.getValueAt(j, 9) == null)
                           {
                                    
                                 gtotal= tax_amnt  + tot - disc_amnt;
                                 
                                 System.out.println(gtotal);
                                 String gt=Double.toString(gtotal);
                                     
                                 //System.out.println(gtotal1);
                                 table1.setValueAt(gt, j, 9);
                                  
                            }
                         }
                    }
                }
               }
            );
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
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        invoice_no_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        party_combo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        curbalnc_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sale_combo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        godown_combo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        date_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        gross_total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        search_txt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Normal Sale Edit/Delete");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Clear");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton5, jButton6, save});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton5, jButton6, save});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("Invoice No:");

        jLabel4.setText("Party's Name:");

        jLabel5.setText("Current Balance:");

        jLabel6.setText("Sale Ledger:");

        jLabel7.setText("Godown Name:");

        jLabel8.setText("Date:");

        date_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                date_txtFocusLost(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, null, null, null, null, null, "0", null}
            },
            new String [] {
                "Item", "Unit", "Quantity", "Rate", "Amount", "Tax", "Taxable Amt", "Discount", "Discount Amt", "Total", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(10).setResizable(false);
        }
        table1.getColumn("Unit").setCellEditor(new DefaultCellEditor(unit_combox));
        table1.getColumn("Item").setCellEditor(new DefaultCellEditor(item_combox));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("-");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("+");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Amount:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(party_combo, 0, 119, Short.MAX_VALUE)
                            .addComponent(invoice_no_txt)
                            .addComponent(curbalnc_txt)
                            .addComponent(sale_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(godown_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gross_total, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(party_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curbalnc_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sale_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(godown_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gross_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton7)
                        .addGap(77, 77, 77)
                        .addComponent(jButton8)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        search_txt.setToolTipText("");
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
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
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
        jScrollPane3.setViewportView(product_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(16, 16, 16))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        String invoice = jTextField1.getText();
        DefaultTableModel y = (DefaultTableModel)table1.getModel();
        int fr = y.getRowCount();
        
        if (invoice!="")
      {  
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            
             Connection con2 = (Connection) DriverManager.getConnection(ConnUrl);
             Connection con3 = (Connection) DriverManager.getConnection(ConnUrl);
             Statement ps5 =con2.createStatement(); 
             Integer sx = Integer.parseInt(jTextField1.getText().toString());
             
                      Statement un = con2.createStatement();
            ResultSet un1 = un.executeQuery("select sale_item,p_group from sale_table2,product where sale_table2.sale_inv_no='"+jTextField2.getText()+"' and sale_table2.sale_item=product_name");
       while(un1.next()){
           
           
            PreparedStatement ps9=con2.prepareStatement("DELETE FROM `"+un1.getString("p_group")+"` WHERE trans_id='"+jTextField2.getText()+"'");
             ps9.executeUpdate();
           
           
       }
             
             
             
             //Updating Sale Table 1
             
             PreparedStatement ps1=con2.prepareStatement("update sale_table1 set sale_inv='"+invoice_no_txt.getText()+"', sale_date='"+date_txt.getText()+"', sale_party_name='"+party_combo.getSelectedItem().toString()+"', sale_current_balance='"+curbalnc_txt.getText()+"', sale_ledger='"+sale_combo.getSelectedItem().toString()+"', sale_gd_name='"+godown_combo.getSelectedItem().toString()+"' where sale_inv='"+jTextField2.getText()+"'");
             ps1.executeUpdate();
             
             Statement ps6 =con2.createStatement(); 
             Statement ps7 =con2.createStatement(); 
             
             //Deleting All Sale details from Sale Table 2 and godwon_deatil
             PreparedStatement ps9=con2.prepareStatement("DELETE FROM sale_table2 WHERE sale_inv_no='"+jTextField2.getText()+"'");
             ps9.executeUpdate();
              PreparedStatement ps90=con2.prepareStatement("DELETE FROM godown_detail WHERE invoice='"+jTextField2.getText()+"'");
             ps90.executeUpdate();
             //Inserting Details of Sale into Sale Table 2
             int p=table1.getRowCount();
             
          for(int i=0;i<p;i++)
         {
          String item=table1.getValueAt(i,0).toString();
          String unit=table1.getValueAt(i,1).toString();
          String quantity=table1.getValueAt(i,2).toString();
          String amount=table1.getValueAt(i,4).toString();
          String rate=table1.getValueAt(i,3).toString();
          String tax=table1.getValueAt(i,5).toString();
          String tax_amnt=table1.getValueAt(i,6).toString();
          String disc=table1.getValueAt(i,7).toString();
          String disc_amnt=table1.getValueAt(i,8).toString();
          String total=table1.getValueAt(i,9).toString();
                
          PreparedStatement ps10=con2.prepareStatement("insert into sale_table2 (sale_inv_no, sale_item, sale_quantity, sale_unit, sale_amount, sale_rate, sale_tax, sale_taxable_amnt, sale_disc, sale_disc_amnt, sale_total)values('"+invoice_no_txt.getText()+"','"+item+"','"+quantity+"','"+unit+"','"+amount+"','"+rate+"','"+tax+"','"+tax_amnt+"','"+disc+"','"+disc_amnt+"','"+total+"')");
           
            ps10.executeBatch();
            ps10.executeUpdate();
            
      PreparedStatement gds=con2.prepareStatement("insert into godown_detail (gd_name, item, s_quantity, unit,invoice)values('"+godown_combo.getSelectedItem().toString()+"','"+item+"','"+quantity+"','"+unit+"','"+invoice_no_txt.getText()+"')");
           
            gds.executeBatch();
            gds.executeUpdate();
              Statement ps400 = con2.createStatement();
            ResultSet rs40 = ps400.executeQuery("select p_group from product where product_name='"+item+"'");
            
            
               if(rs40.next())
              {
                   name4=rs40.getString("p_group");
                  item_combox.addItem(name4);
               
            
               PreparedStatement it=con2.prepareStatement("insert into `"+name4+"` (p_name, inv_sale,trans_id)values('"+item+"','"+quantity+"','"+invoice_no_txt.getText()+"')");
           
            it.executeBatch();
            it.executeUpdate();
            
              }   
         }  
             //Updating Sale Table 2
//             for (int tabrow = 0; tabrow < fr; tabrow++)
//                {
//                    String s_inv_no = jTextField2.getText();
//                    System.out.println("*** Save Starts ***");
//                    System.out.println(s_inv_no);
//                    String s_item = table1.getValueAt(tabrow,0).toString();
//                    System.out.println(s_item);
//                    String s_unt = table1.getValueAt(tabrow,1).toString();
//                    System.out.println(s_unt);
//                    Double s_quant = (Double) table1.getValueAt(tabrow,2);
//                    System.out.println(s_quant);
//                    Double s_rt = (Double) table1.getValueAt(tabrow,3);
//                    System.out.println(s_rt);
//                    Double s_amnt = (Double) table1.getValueAt(tabrow,4);
//                    System.out.println(s_amnt);
//                    Double s_t = (Double) table1.getValueAt(tabrow,5);
//                    System.out.println(s_t);
//                    Double s_amt_tx = (Double) table1.getValueAt(tabrow,6);
//                    System.out.println(s_amt_tx);
//                    Double s_dsc = (Double) table1.getValueAt(tabrow,7);
//                    System.out.println(s_dsc);
//                    Double s_dsc_amt = (Double) table1.getValueAt(tabrow,8);
//                    System.out.println(s_dsc_amt);
//                    
//                    String s1 = (String)table1.getValueAt(tabrow, 9);
//                    double d1=Double.parseDouble(s1);
//                    System.out.println(d1);
//                    
//                    Integer s_id = (Integer) table1.getValueAt(tabrow,10);
//                    System.out.println(s_id);
//                    
//                    PreparedStatement ps10=con2.prepareStatement("update sale_table2 set sale_inv_no='"+s_inv_no+"', sale_item='"+s_item+"', sale_unit='"+s_unt+"', sale_quantity='"+s_quant+"', sale_rate='"+s_rt+"', sale_amount='"+s_amnt+"', sale_tax='"+s_t+"', sale_taxable_amnt='"+s_amt_tx+"', sale_disc='"+s_dsc+"', sale_disc_amnt='"+s_dsc_amt+"', sale_total='"+d1+"' where sale_id='"+s_id+"'");
//                    
//                    ps10.executeBatch();
//                    ps10.executeUpdate();
//                }
             
             //Updating Sale Table 3
             String gtt = gross_total.getText().toString();
             Double gt = Double.parseDouble(gtt);
             
             String isrch = jTextField3.getText().toString();
             Integer src3 = Integer.parseInt(isrch);
             System.out.println("Update details of Sale ID for Sale Table 3:"+src3);
             
             PreparedStatement ps8=con3.prepareStatement("update sale_table3 set sale_inv_no='"+invoice_no_txt.getText()+"', sale_g_total='"+gt+"', sale_ledger='"+sale_combo.getSelectedItem().toString()+"' where sale_invoice_no='"+jTextField2.getText()+"'");
             ps8.executeUpdate();
              PreparedStatement ps88=con3.prepareStatement("update company_main_table set ledger='"+party_combo.getSelectedItem().toString()+"', credit='"+gt+"' where get_id='"+jTextField2.getText()+"' and debit='0'");
             ps88.executeUpdate();
             
             PreparedStatement ps889=con3.prepareStatement("update company_main_table set ledger='"+sale_combo.getSelectedItem().toString()+"', debit='"+gt+"' where get_id='"+jTextField2.getText()+"' and credit='0'");
             ps889.executeUpdate();
             
             
             
             
             
             
        }catch (SQLException q){
            System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
        
        jOptionPane1.showMessageDialog(this,"Sale Details Updated");
        
        //Clearing Forms 
        invoice_no_txt.setText(null);
        party_combo.setSelectedItem(null);
        sale_combo.setSelectedItem(null);
        curbalnc_txt.setText(null);
        date_txt.setText(null);
        godown_combo.setSelectedItem(null);
                        
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        search_txt.setText(null);
        gross_total.setText("");
        gross_total.setText(null);
        
        // Deleting all rows from Table1 of Item Description
           while (fr>=1)
            {   
            int a=y.getRowCount()- 1;
            y.removeRow(a);
            fr--;
            }
        
        fill_combo();
        update_table();
      }
      else
      {
      jOptionPane1.showMessageDialog(this,"Select a valid Sale Invoice");
      }
        jTextField1.setText(null);
        search_txt.setText(null);
        fill_combo();
        update_table();
    }//GEN-LAST:event_saveActionPerformed

    private void date_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_txtFocusLost
        String pass =  date_txt.getText();

        System.out.println(pass);

        int sd=Integer.parseInt(pass);
        if(sd>0&&sd<=31)
        {

        }
        else
        {

            date_txt.setText("");
            JOptionPane.showMessageDialog(null, "Invalid Day Format");

        }
    }//GEN-LAST:event_date_txtFocusLost

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
      
    }//GEN-LAST:event_search_txtActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        int a=y.getRowCount()- 1;

        y.removeRow(a);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        Vector <String> r = new Vector <String>();
        y.addRow(r);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
            //Deleting all rows from Table 1
            DefaultTableModel y = (DefaultTableModel)table1.getModel();
            int fr = y.getRowCount();
            while (fr>=1)
            {   
            int a=y.getRowCount()- 1;
            y.removeRow(a);
            fr--;
            }
        
        
            int new1=product_table.getSelectedRow();
            String table_click=(product_table.getModel().getValueAt(new1, 0).toString());
            
            try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con1 = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps1 =con1.createStatement();
           Statement ps3 =con1.createStatement();                      
           ResultSet rs1=ps1.executeQuery("SELECT * from sale_table1 where sale_inv='"+table_click+"' ");
                      
           while(rs1.next())
                {
                String  aa=rs1.getString("sale_id");
                jTextField1.setText(aa);
                
                String a1=rs1.getString("sale_inv");
                invoice_no_txt.setText(a1);
                jTextField2.setText(a1);

                String a2=rs1.getString("sale_date");
                date_txt.setText("");
                date_txt.setText(a2);
                                
                String a3=rs1.getString("sale_party_name");
                party_combo.setSelectedItem(a3);
                
                String a4=rs1.getString("sale_current_balance");
                curbalnc_txt.setText(a4);
                
                String a5=rs1.getString("sale_ledger");
                sale_combo.setSelectedItem(a5);
                
                String a6=rs1.getString("sale_gd_name");
                godown_combo.setSelectedItem(a6);
                
                
                // Code to Save & Edit Sale Table 3 with value from JTextField 3
            String sch3 = jTextField2.getText().toString();
            System.out.println(sch3);
            Integer srch3 = Integer.parseInt(sch3);
            System.out.println("Invoice No.:"+srch3);
            
            ResultSet rs3=ps3.executeQuery("SELECT * from sale_table3 where sale_inv_no='"+srch3+"' ");
            while (rs3.next())
            {
                String ax = rs3.getString("sale_id");
                jTextField3.setText(ax);
            }

                
                
                }
           
           Statement ps2 =con1.createStatement();
           ResultSet rs2=ps2.executeQuery("SELECT * from sale_table2 where sale_inv_no='"+table_click+"' ");
           //sale_item AS Item, sale_unit AS Unit, sale_quantity AS Quantity, sale_rate AS Rate, sale_amount AS Amount, sale_tax AS Amount, sale_taxable_amnt AS Taxable_Amt, sale_disc AS Discount, sale_disc_amnt AS Discount_Amt, sale_total AS Total
           //table1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs2));
           
           int li_row=0;
           int rw = 0;
           Vector <String> r[] = (Vector <String> []) new Vector[1000];
           
           
           table1.getColumnModel().getColumn(10).setMinWidth(0);
           table1.getColumnModel().getColumn(10).setMaxWidth(0);
           table1.getColumnModel().getColumn(10).setResizable(false);
           
           while(rs2.next())
                 {
                 y.addRow(r[rw]); 
                    
                 table1.setValueAt(rs2.getString("sale_item"), li_row, 0);
                 table1.setValueAt(rs2.getString("sale_unit"), li_row, 1);
                 
                 Double sqty = Double.parseDouble(rs2.getString("sale_quantity"));
                 table1.setValueAt(sqty, li_row, 2);
                 
                 Double srt = Double.parseDouble(rs2.getString("sale_rate"));
                 table1.setValueAt(srt, li_row, 3);
                 
                 Double samnt = Double.parseDouble(rs2.getString("sale_amount"));
                 table1.setValueAt(samnt, li_row, 4);
                 
                 Double stax = Double.parseDouble(rs2.getString("sale_tax"));
                 table1.setValueAt(stax, li_row, 5);
                 
                 Double stxamnt = Double.parseDouble(rs2.getString("sale_taxable_amnt"));
                 table1.setValueAt(stxamnt, li_row, 6);
                 
                 Double sdisc = Double.parseDouble(rs2.getString("sale_disc"));
                 table1.setValueAt(sdisc, li_row, 7);
                 
                 Double sdamnt = Double.parseDouble(rs2.getString("sale_disc_amnt"));
                 table1.setValueAt(sdamnt, li_row, 8);
                 
                 table1.setValueAt(rs2.getString("sale_total"), li_row, 9);
                 
                 Integer said = Integer.parseInt(rs2.getString("sale_id"));
                 table1.setValueAt(said, li_row, 10);
                 
                 rw++;
                 li_row++;
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        try{
         
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection conn1 = (Connection) DriverManager.getConnection(ConnUrl);
           
            PreparedStatement del=conn1.prepareStatement("DELETE FROM sale_table2 WHERE sale_inv_no='"+jTextField2.getText()+"'");
             del.executeUpdate();
              PreparedStatement del1=conn1.prepareStatement("DELETE FROM godown_detail WHERE invoice='"+jTextField2.getText()+"'");
             del1.executeUpdate();
              PreparedStatement del2=conn1.prepareStatement("DELETE FROM sale_table1 WHERE sale_inv='"+jTextField2.getText()+"'");
             del2.executeUpdate();
            
              PreparedStatement del4=conn1.prepareStatement("DELETE FROM sale_table3 WHERE sale_inv_no='"+jTextField2.getText()+"'");
             del4.executeUpdate();
              PreparedStatement del5=conn1.prepareStatement("DELETE FROM company_main_table WHERE get_id='"+jTextField2.getText()+"'");
             del5.executeUpdate();
             
             
               Statement under = conn1.createStatement();
            ResultSet under1 = under.executeQuery("select sale_item,p_group from sale_table2,product where sale_table2.sale_inv_no='"+jTextField2.getText()+"' and sale_table2.sale_item=product_name");
       while(under1.next()){
           
           
            PreparedStatement del3=conn1.prepareStatement("DELETE FROM `"+under1.getString("p_group")+"` WHERE trans_id='"+jTextField2.getText()+"'");
             del3.executeUpdate();
           
           
       }
             
             
        }catch (SQLException q){
        System.out.println("Sql Exception" + q.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField curbalnc_txt;
    private javax.swing.JTextField date_txt;
    private javax.swing.JComboBox godown_combo;
    private javax.swing.JTextField gross_total;
    private javax.swing.JTextField invoice_no_txt;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox party_combo;
    private javax.swing.JTable product_table;
    private javax.swing.JComboBox sale_combo;
    private javax.swing.JButton save;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
    JComboBox item_combox = new JComboBox();
    JComboBox unit_combox = new JComboBox();

}
