package final_project;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
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
public class normal_sale_create_panel extends javax.swing.JPanel {
    Font myFont = new Font("",Font.PLAIN,9);
     int i=0,j=0,k=0,l=0,m=0;   // For Mandatory
     int x=0,y=0;              // For Non Mandatory

    String pur_item,quantity_name,quan,name4;
    Double quantity_value,quantity_value1,quantity_value3;
    
    /**
     * Creates new form normal_sale_create_panel
     */
    public normal_sale_create_panel() {
        initComponents();
        
        PromptSupport.setPrompt("dd/mm/yyyy", date);
        PromptSupport.setPrompt("0.00", curbalnc_txt);
        PromptSupport.setPrompt("0.00", gross_total);
        
        fill_combo();
        initialise();
        cell_caculate();
        invoice_no_txt.requestFocusInWindow();
        
        jLabel3.setFont(myFont);
        jLabel3.setEnabled(false);
        jLabel3.setVisible(false);
        
        jLabel10.setFont(myFont);
        jLabel10.setEnabled(false);
        jLabel10.setVisible(false);
        
        jLabel11.setFont(myFont);
        jLabel11.setEnabled(false);
        jLabel11.setVisible(false);
        
        jLabel12.setFont(myFont);
        jLabel12.setEnabled(false);
        jLabel12.setVisible(false);
        
        jLabel13.setFont(myFont);
        jLabel13.setEnabled(false);
        jLabel13.setVisible(false);
        
        jLabel14.setFont(myFont);
        jLabel14.setEnabled(false);
        jLabel14.setVisible(false);
        
        jLabel16.setFont(myFont);
        jLabel16.setEnabled(false);
        jLabel16.setVisible(false);
        
        TableCellRenderer r = table1.getTableHeader().getDefaultRenderer();
        JLabel headerlabel = (JLabel)r;
        headerlabel.setHorizontalAlignment(JLabel.CENTER);
    }
    
    // Invoice No
    
    public void invoice(){
   if(invoice_no_txt.getText().length()==0)
      {
          invoice_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel3.setEnabled(true);
          jLabel3.setForeground(Color.red);
          jLabel3.setVisible(true);
             
      }  
      else
      {
           invoice_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel3.setEnabled(false);  
           jLabel3.setVisible(false);
           i=1;
          
      }
    }
    
    // date
    
    public void date(){
     if(date.getText().length()==0)
        {
                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);
        }
        else
        {
            String content = date.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel14.setEnabled(false);  
            jLabel14.setVisible(false);
            j=1;
            if(!matchFound)

            {

                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);

            }
        }
    }
    
    // Party Name
    
    public void party(){
    if(party_combo.getSelectedItem().equals(""))
      {
          party_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel10.setEnabled(true);
          jLabel10.setForeground(Color.red);
          jLabel10.setVisible(true);
             
      }  
      else
      {
           party_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel10.setEnabled(false);  
           jLabel10.setVisible(false);
           k=1;
      }
    }
    
    // Sale Ledger
    
    public void sale(){
     if(sale_combo.getSelectedItem().equals(""))
      {
          sale_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           sale_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           l=1;
      }
        
    }
    
    // Godown
    
    public void godown(){
     if(godown_combo.getSelectedItem().equals(""))
      {
          godown_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
             
      }  
      else
      {
           godown_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           m=1;
      }
        
    }

    
    public void fill_combo()
    {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        invoice_no_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        party_combo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        sale_combo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        godown_combo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        curbalnc_txt = new numeric.textField.NumericTextField();
        gross_total = new numeric.textField.NumericTextField();
        jLabel16 = new javax.swing.JLabel();

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("SALE INVOICE");

        jLabel9.setText("Invoice No:");

        invoice_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        invoice_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                invoice_no_txtFocusLost(evt);
            }
        });

        jLabel3.setText("Enter Invoice No.!");

        jLabel5.setText("Party's Name:");

        party_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        party_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        party_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                party_comboActionPerformed(evt);
            }
        });
        party_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                party_comboFocusLost(evt);
            }
        });

        jLabel10.setText("Enter Party Name!");

        jLabel6.setText("Current Balance:");

        jLabel11.setText("Enter Current Balance!");

        jLabel4.setText("Date:");

        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFocusLost(evt);
            }
        });

        jLabel14.setText("Enter Valid Date Format!");

        jLabel7.setText("Sale Ledger:");

        sale_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        sale_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        sale_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_comboActionPerformed(evt);
            }
        });
        sale_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sale_comboFocusLost(evt);
            }
        });

        jLabel12.setText("Select Ledger!");

        jLabel8.setText("Godown Name:");

        godown_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        godown_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        godown_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_comboActionPerformed(evt);
            }
        });
        godown_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                godown_comboFocusLost(evt);
            }
        });

        jLabel13.setText("Select Godown!");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Unit", "Quantity", "Rate", "Amount", "Tax", "Taxable  Amount ", "Discount", "Discountable Amount", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);
        table1.getColumn("Unit").setCellEditor(new DefaultCellEditor(unit_combox));
        table1.getColumn("Item").setCellEditor(new DefaultCellEditor(item_combox));
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(6).setMinWidth(110);
            table1.getColumnModel().getColumn(8).setMinWidth(135);
        }

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/folder-access-icon.png"))); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Icons/Button-Refresh-icon.png"))); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Amount:");

        curbalnc_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        curbalnc_txt.setText("numericTextField1");
        curbalnc_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                curbalnc_txtFocusLost(evt);
            }
        });

        gross_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        gross_total.setText("numericTextField1");
        gross_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                gross_totalFocusLost(evt);
            }
        });

        jLabel16.setText("Enter Valid Amount!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(147, 147, 147))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sale_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(godown_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(party_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(curbalnc_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(82, 82, 82)
                                .addComponent(jButton4)
                                .addGap(280, 280, 280))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gross_total, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {godown_combo, invoice_no_txt, party_combo, sale_combo});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(party_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(curbalnc_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sale_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(godown_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gross_total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        invoice_no_txt.setText("");
        date.setText("");
        party_combo.setSelectedItem(null);
        curbalnc_txt.setText("");
        sale_combo.setSelectedItem(null);
        godown_combo.setSelectedItem(null);
        invoice_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        party_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        curbalnc_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));        
        sale_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        godown_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        jLabel3.setVisible(false);
        jLabel14.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //String dt = date_txt.getText()+"/"+month_txt.getText()+"/"+year_txt.getText();
    invoice();
    date();
    party();
    sale();
    godown();
     if(i==1&&j==1&&k==1&&l==1&&m==1&&x==0&&y==0)
     {
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            PreparedStatement ps=con.prepareStatement("insert into sale_table1 (sale_inv, sale_date, sale_party_name, sale_current_balance, sale_ledger, sale_gd_name)values('"+invoice_no_txt.getText()+"','"+date.getText()+"','"+party_combo.getSelectedItem().toString()+"','"+curbalnc_txt.getText()+"','"+sale_combo.getSelectedItem().toString()+"','"+godown_combo.getSelectedItem().toString()+"')");
            ps.executeUpdate();

            System.out.println("Done Insertion in Sale Table 1");

            PreparedStatement ps2=con.prepareStatement("insert into sale_table3 (sale_inv_no, sale_g_total, sale_ledger)values('"+invoice_no_txt.getText()+"','"+gross_total.getText()+"','"+party_combo.getSelectedItem().toString()+"')");
            ps2.executeUpdate();
            PreparedStatement ps4=con.prepareStatement("insert into company_main_table (ledger,debit,get_id,trans_date,type)values('"+party_combo.getSelectedItem().toString()+"','"+gross_total.getText()+"','"+invoice_no_txt.getText()+"','"+date.getText()+"','SALE')");
            ps4.executeUpdate();
            PreparedStatement ps5=con.prepareStatement("insert into company_main_table (ledger,credit,get_id,trans_date,type)values('"+sale_combo.getSelectedItem().toString()+"','"+gross_total.getText()+"','"+invoice_no_txt.getText()+"','"+date.getText()+"','SALE')");
            ps5.executeUpdate();

            System.out.println("Done Insertion in Sale Table 3");

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

                PreparedStatement ps1=con.prepareStatement("insert into sale_table2 (sale_inv_no, sale_item, sale_quantity, sale_unit, sale_amount, sale_rate, sale_tax, sale_taxable_amnt, sale_disc, sale_disc_amnt, sale_total)values('"+invoice_no_txt.getText()+"','"+item+"','"+quantity+"','"+unit+"','"+amount+"','"+rate+"','"+tax+"','"+tax_amnt+"','"+disc+"','"+disc_amnt+"','"+total+"')");

                ps1.executeBatch();
                ps1.executeUpdate();

                PreparedStatement gds=con.prepareStatement("insert into godown_detail (gd_name, item, s_quantity, unit,invoice)values('"+godown_combo.getSelectedItem().toString()+"','"+item+"','"+quantity+"','"+unit+"','"+invoice_no_txt.getText()+"')");

                gds.executeBatch();
                gds.executeUpdate();

                Statement ps400 = con.createStatement();
                ResultSet rs40 = ps400.executeQuery("select p_group from product where product_name='"+item+"'");

                if(rs40.next())
                {
                    name4=rs40.getString("p_group");
                    item_combox.addItem(name4);

                    PreparedStatement it=con.prepareStatement("insert into `"+name4+"` (p_name, inv_sale,trans_id)values('"+item+"','"+quantity+"','"+invoice_no_txt.getText()+"')");

                    it.executeBatch();
                    it.executeUpdate();

                }

            }

            System.out.println("saved");

            jOptionPane1.showMessageDialog(this,"Sale Invoice Created");

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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        int a=y.getRowCount()- 1;

        y.removeRow(a);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        Vector <String> r = new Vector <String>();
        y.addRow(r);
        int i=table1.getRowCount();
        System.out.println("no."+i);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void godown_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_godown_comboActionPerformed

    private void sale_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sale_comboActionPerformed

    private void party_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_party_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_party_comboActionPerformed

    private void curbalnc_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_curbalnc_txtFocusLost
       if(curbalnc_txt.getText().length()==0)
        {
              curbalnc_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel11.setEnabled(false);  
              jLabel11.setVisible(false);
              x=0;
        }
        else
        {
            String content = curbalnc_txt.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            curbalnc_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel11.setEnabled(false);  
            jLabel11.setVisible(false);
            x=0;
            if(!matchFound)
            {
                x=1;
                curbalnc_txt.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel11.setEnabled(true);
                jLabel11.setForeground(Color.red);
                jLabel11.setVisible(true);

            }
        }
    }//GEN-LAST:event_curbalnc_txtFocusLost

    private void gross_totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gross_totalFocusLost
       if(gross_total.getText().length()==0)
        {
              gross_total.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
              jLabel16.setEnabled(false);  
              jLabel16.setVisible(false);
              y=0;
        }
        else
        {
            String content = gross_total.getText();
            Pattern p = Pattern.compile("[-+]?[0-9]*\\.[0-9]?[0-9]|[-+]?[0-9]*");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            gross_total.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel16.setEnabled(false);  
            jLabel16.setVisible(false);
            y=0;
            if(!matchFound)
            {
                y=1;
                gross_total.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel16.setEnabled(true);
                jLabel16.setForeground(Color.red);
                jLabel16.setVisible(true);

            }
        }
    }//GEN-LAST:event_gross_totalFocusLost

    private void invoice_no_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invoice_no_txtFocusLost
        if(invoice_no_txt.getText().length()==0)
      {
          invoice_no_txt.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel3.setEnabled(true);
          jLabel3.setForeground(Color.red);
          jLabel3.setVisible(true);
             
      }  
      else
      {
           invoice_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel3.setEnabled(false);  
           jLabel3.setVisible(false);
           i=1;
          
      }
    }//GEN-LAST:event_invoice_no_txtFocusLost

    private void dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFocusLost
       if(date.getText().length()==0)
        {
                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);
        }
        else
        {
            String content = date.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel14.setEnabled(false);  
            jLabel14.setVisible(false);
            j=1;
            if(!matchFound)

            {

                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel14.setEnabled(true);
                 jLabel14.setForeground(Color.red);
                 jLabel14.setVisible(true);

            }
        }
    }//GEN-LAST:event_dateFocusLost

    private void party_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_party_comboFocusLost
      if(party_combo.getSelectedItem().equals(""))
      {
          party_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel10.setEnabled(true);
          jLabel10.setForeground(Color.red);
          jLabel10.setVisible(true);
             
      }  
      else
      {
           party_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel10.setEnabled(false);  
           jLabel10.setVisible(false);
           k=1;
      }
    }//GEN-LAST:event_party_comboFocusLost

    private void sale_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sale_comboFocusLost
      if(sale_combo.getSelectedItem().equals(""))
      {
          sale_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           sale_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           l=1;
      }
    }//GEN-LAST:event_sale_comboFocusLost

    private void godown_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_godown_comboFocusLost
      if(godown_combo.getSelectedItem().equals(""))
      {
          godown_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel13.setEnabled(true);
          jLabel13.setForeground(Color.red);
          jLabel13.setVisible(true);
             
      }  
      else
      {
           godown_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel13.setEnabled(false);  
           jLabel13.setVisible(false);
           m=1;
      }
    }//GEN-LAST:event_godown_comboFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private numeric.textField.NumericTextField curbalnc_txt;
    private javax.swing.JTextField date;
    private javax.swing.JComboBox godown_combo;
    private numeric.textField.NumericTextField gross_total;
    private javax.swing.JTextField invoice_no_txt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox party_combo;
    private javax.swing.JComboBox sale_combo;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
    JComboBox item_combox = new JComboBox();
    JComboBox unit_combox = new JComboBox();
}
