package final_project;
import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
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
public class normal_purchase_create_panel extends javax.swing.JPanel {
Font myFont = new Font("",Font.PLAIN,9);
int i=0,j=0,k=0,l=0,m=0;   // For Mandatory
 int x=0,y=0;              // For Non Mandatory
    /**
     * Creates new form normal_purchase_create
     */
     String pur_item,quantity_name,quan,name4;
    Double quantity_value,quantity_value1,quantity_value3;
    public normal_purchase_create_panel() {
        Properties date_prop = new Properties();    
    InputStream input = null;
    try{
    input = new FileInputStream("date_config.properties");
    date_prop.load(input);
    String b = date_prop.getProperty("normal_purchase_create_panel");
    System.out.println(b);
    date.setText(b);
    input.close();
   }
    catch (IOException io) {
		io.printStackTrace();
        }
        initComponents();
        
        PromptSupport.setPrompt("dd/mm/yyyy", date);
        PromptSupport.setPrompt("0.00", curbalnc_txt);
        PromptSupport.setPrompt("0.00", gross_total);
        
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
        
        jLabel15.setFont(myFont);
        jLabel15.setEnabled(false);
        jLabel15.setVisible(false);
        
        jLabel16.setFont(myFont);
        jLabel16.setEnabled(false);
        jLabel16.setVisible(false);
        
         fill_combo();
        initialise();
        cell_caculate();
        
        
        
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
                 jLabel15.setEnabled(true);
                 jLabel15.setForeground(Color.red);
                 jLabel15.setVisible(true);
        }
        else
        {
            String content = date.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel15.setEnabled(false);  
            jLabel15.setVisible(false);
            j=1;
            if(!matchFound)

            {

                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel15.setEnabled(true);
                 jLabel15.setForeground(Color.red);
                 jLabel15.setVisible(true);

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
    
    // Purchase Ledger
    
    public void pur(){
     if(purchase_combo.getSelectedItem().equals(""))
      {
          purchase_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           purchase_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
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
                  purchase_combo.addItem(name);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        invoice_no_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        party_combo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        curbalnc_txt = new numeric.textField.NumericTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        purchase_combo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        godown_combo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        gross_total = new numeric.textField.NumericTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Purchase  Invoice");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));

        invoice_no_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        invoice_no_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                invoice_no_txtFocusLost(evt);
            }
        });

        jLabel9.setText("Invoice No:");

        jLabel3.setText("Enter Invoice No.!");

        jLabel4.setText("Date:");

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

        jLabel15.setText("Enter Valid Date!");

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

        jLabel10.setText("Select Party Name!");

        jLabel6.setText("Current Balance:");

        curbalnc_txt.setText("numericTextField1");
        curbalnc_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                curbalnc_txtFocusLost(evt);
            }
        });

        jLabel11.setText("Enter Current Balance!");

        jLabel7.setText("Purchase Ledger:");

        purchase_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        purchase_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_comboActionPerformed(evt);
            }
        });
        purchase_combo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchase_comboFocusLost(evt);
            }
        });

        jLabel12.setText("Enter Purcase Ledger Name!");

        jLabel8.setText("Godown Name:");

        godown_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
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

        jLabel13.setText("Enter Godown Name!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(party_combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curbalnc_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(purchase_combo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 152, Short.MAX_VALUE)
                            .addComponent(godown_combo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 152, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoice_no_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(party_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(curbalnc_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(purchase_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(godown_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("-");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Unit", "Quantity", "Rate", "Amount", "Tax", "Taxable Amount", "Discount", "Discountable Amt", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.getColumn("Unit").setCellEditor(new DefaultCellEditor(unit_combox));
        table1.getColumn("Item").setCellEditor(new DefaultCellEditor(item_combox));
        table1.setDefaultEditor(Integer.class,new IntegerEditor(0, 100));
        jScrollPane2.setViewportView(table1);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total Amount:");

        gross_total.setText("numericTextField1");
        gross_total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                gross_totalFocusLost(evt);
            }
        });

        jLabel16.setText("Enter Valid Amount!");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gross_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(184, 184, 184))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gross_total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void party_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_party_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_party_comboActionPerformed

    private void purchase_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_comboActionPerformed

    private void godown_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_godown_comboActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        int a=y.getRowCount()- 1;

        y.removeRow(a);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel y = (DefaultTableModel)table1.getModel();

        Vector <String> r = new Vector <String>();
        y.addRow(r);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //String dt = date_txt.getText()+"/"+month_txt.getText()+"/"+year_txt.getText();
        
        try{
            Properties date_prop = new Properties();
            OutputStream output = null;
            InputStream input = null;
            output = new FileOutputStream("date_config.properties");
            date_prop.setProperty("normal_purchase_create_panel",date.toString());
            output.close();            
        }
        catch (IOException io) {
            io.printStackTrace();
        }
  invoice();
    date();
    party();
    pur();
    godown();
     if(i==1&&j==1&&k==1&&l==1&&m==1&&x==0&&y==0)
     {
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);

            PreparedStatement ps=con.prepareStatement("insert into purchase_table1 (purchase_inv, purchase_date, purchase_party_name, purchase_current_balance, purchase_ledger, purchase_gd_name)values('"+invoice_no_txt.getText()+"','"+date.getText()+"','"+party_combo.getSelectedItem().toString()+"','"+curbalnc_txt.getText()+"','"+purchase_combo.getSelectedItem().toString()+"','"+godown_combo.getSelectedItem().toString()+"')");
            ps.executeUpdate();

            System.out.println("Done Insertion in Sale Table 1");

            PreparedStatement ps2=con.prepareStatement("insert into purchase_table3 (purchase_inv, purchase_g_total, party_ledger)values('"+invoice_no_txt.getText()+"','"+gross_total.getText()+"','"+party_combo.getSelectedItem().toString()+"')");
            ps2.executeUpdate();
            PreparedStatement ps4=con.prepareStatement("insert into company_main_table (ledger,credit,get_id,trans_date,type)values('"+party_combo.getSelectedItem().toString()+"','"+gross_total.getText()+"','"+invoice_no_txt.getText()+"','"+date.getText()+"','PURCHASE')");
            ps4.executeUpdate();
            PreparedStatement ps5=con.prepareStatement("insert into company_main_table (ledger,debit,get_id,trans_date,type)values('"+purchase_combo.getSelectedItem().toString()+"','"+gross_total.getText()+"','"+invoice_no_txt.getText()+"','"+date.getText()+"','PURCHASE')");
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

                PreparedStatement ps1=con.prepareStatement("insert into purchase_table2 (purchase_inv, purchase_item, purchase_quantity, purchase_unit, purchase_amount, purchase_rate, purchase_tax, purchase_taxable_amnt, purchase_disc, purchase_disc_amnt, purchase_total)values('"+invoice_no_txt.getText()+"','"+item+"','"+quantity+"','"+unit+"','"+amount+"','"+rate+"','"+tax+"','"+tax_amnt+"','"+disc+"','"+disc_amnt+"','"+total+"')");

                ps1.executeBatch();
                ps1.executeUpdate();

                PreparedStatement gds=con.prepareStatement("insert into godown_detail (gd_name, item, p_quantity, unit,invoice)values('"+godown_combo.getSelectedItem().toString()+"','"+item+"','"+quantity+"','"+unit+"','"+invoice_no_txt.getText()+"')");

                gds.executeBatch();
                gds.executeUpdate();

                Statement ps400 = con.createStatement();
                ResultSet rs40 = ps400.executeQuery("select p_group from product where product_name='"+item+"'");

                if(rs40.next())
                {
                    name4=rs40.getString("p_group");
                    item_combox.addItem(name4);

                    PreparedStatement it=con.prepareStatement("insert into `"+name4+"` (p_name, inv_purchase,trans_id)values('"+item+"','"+quantity+"','"+invoice_no_txt.getText()+"')");

                    it.executeBatch();
                    it.executeUpdate();

                }

            }

            System.out.println("saved");

            jOptionPane1.showMessageDialog(this,"Purchase Invoice Created");

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        invoice_no_txt.setText("");
        //  date_txt.setText("");
        curbalnc_txt.setText("");
        // month_txt.setText("");
        // year_txt.setText("");
        invoice_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        party_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        purchase_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        godown_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       // invoice_no_txt.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
               
       jLabel3.setVisible(false);
       jLabel15.setVisible(false);
       jLabel10.setVisible(false);
       jLabel12.setVisible(false);
       jLabel13.setVisible(false);
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFocusLost
       if(date.getText().length()==0)
        {
                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel15.setEnabled(true);
                 jLabel15.setForeground(Color.red);
                 jLabel15.setVisible(true);
        }
        else
        {
            String content = date.getText();
            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher m = p.matcher(content);
            boolean matchFound = m.matches();
            date.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            jLabel15.setEnabled(false);  
            jLabel15.setVisible(false);
            j=1;
            if(!matchFound)

            {

                 date.setBorder(BorderFactory.createLineBorder(Color.red));
                 jLabel15.setEnabled(true);
                 jLabel15.setForeground(Color.red);
                 jLabel15.setVisible(true);

            }
        }
    }//GEN-LAST:event_dateFocusLost

    private void purchase_comboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchase_comboFocusLost
       if(purchase_combo.getSelectedItem().equals(""))
      {
          purchase_combo.setBorder(BorderFactory.createLineBorder(Color.red));
          jLabel12.setEnabled(true);
          jLabel12.setForeground(Color.red);
          jLabel12.setVisible(true);
             
      }  
      else
      {
           purchase_combo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
           jLabel12.setEnabled(false);  
           jLabel12.setVisible(false);
           l=1;
      }
    }//GEN-LAST:event_purchase_comboFocusLost

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox party_combo;
    private javax.swing.JComboBox purchase_combo;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
 JComboBox item_combox = new JComboBox();
    JComboBox unit_combox = new JComboBox();
}
