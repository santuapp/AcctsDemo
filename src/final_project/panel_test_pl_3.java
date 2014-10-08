package final_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc1
 */
public class panel_test_pl_3 extends javax.swing.JPanel implements ContainerListener{

    private final GridBagConstraints gridBagConstraints;
    private final GridBagConstraints gbc;
    
    int count = 1000;
    final JButton[][] labels=new JButton[count][9];
    int row = 0;
    
    //To draw line in Main Frame
    public void paint(Graphics g)  
    {  
     super.paint(g);  
     int a=(getSize().width/2)+8;
     //draw line in JFrame from top left corner until bottom right corner  
     g.drawLine(a,50,a,getSize().height); 
     repaint();
    }
    
    /**
     * Creates new form panel_test_pl_3
     */
    
    public panel_test_pl_3() {
        
      
        
        initComponents();
        
        jPanel1.setOpaque(false);
        
        Font myFont = new Font("plain", Font.BOLD, 13);
        Font myFont1 = new Font("plain", Font.ITALIC, 13);
        Font myFont2 = new Font("plain", Font.ITALIC + Font.BOLD, 13);
        
        GridBagLayout gridbag = new GridBagLayout();
        
        
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gbc = new java.awt.GridBagConstraints();
        
            addContainerListener(this);
            
            gridBagConstraints.anchor=gridBagConstraints.PAGE_START;
        
            
            
            
            
            double net_profit=0.0d,net_loss=0.0d,closing_total=0.0d,purchase_total=0.0d,opening_total=0.0d,sale_total=0.0d,pur_ledger_tot=0.0d,sale_ledger_tot=0.0d,direct_exp_tot=0.0d,direct_inc_tot=0.0d,total1=0.0d,total2=0.0d,diff_total=0.0d,indirct_exp_tot_value=0.0d,indirct_inc_tot_value=0.0d,profit_value=0.0d,loss_value=0.0d, total_first=0.0d;
            String closing="",purchase="", opening="",sale="",pur_ledger="",pur_led_tot="",sale_led_tot="",sale_ledger="",direct_exp="",direct_inc="", direct_inc_detail="",direct_exp_detail="",indirect_exp_led="",indirect_exp_total="", indirect_inc_total="",indirect_income_details="",indirect_expense_details="";
            int chk=0, pur=0, sal=0, dex=0, dinc=0, inex=0, indinc=0, l1=0, l2=0, r=0, r1=0,flag=0;
            
            labels[row][0] = new JButton("Particulars");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            
            System.out.println(labels[row][0].getText()+"Hello Rashbehari");
            
            if (labels[row][0].getText() == "")
            {
                System.out.println(labels[row][0].getClass());
                System.out.println("Hello Jaanki Das");
            }
            else
            {
                System.out.println(labels[row][0].getClass());
                System.out.println("Hello Bonoful");
            }
            
            //labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton("Am");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton("ou");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton("nt");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5] = new JButton("Particulars");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.CENTER);
            
            
            labels[row][6] = new JButton("Am");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][6].setFont(myFont);
            jPanel1.add(labels[row][6],gridBagConstraints);
            labels[row][6].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][7] = new JButton("ou");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][7].setFont(myFont);
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8] = new JButton("nt");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setHorizontalAlignment(SwingConstants.LEFT);
            
            row++;
            r=r1=row;
            
            
            
            //Content Opening/Closing Stock displaying
            
            labels[row][0] = new JButton("Opening Stock");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //cohead.setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][2] = new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            //opening stock from database
            
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select sum(amount) as opening_amount from opening");
          
               
           System.out.println("Done");
          
           while(rs.next())
           {
            opening=rs.getString("opening_amount");
            if(opening!=null)
            {
                opening_total=Double.parseDouble(opening);
            
                labels[row][3] = new JButton();
            
                labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(opening);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
              
            }
             
             else
             {
                
                opening_total=0.0d;
                labels[row][3] = new JButton();
            
                labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
                gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx=0.10;
                gridBagConstraints.gridx=26;
                gridBagConstraints.gridy=row;
                gridBagConstraints.gridwidth=5;
                labels[row][3].setFont(myFont);
                jPanel1.add(labels[row][3],gridBagConstraints);
                labels[row][3].setText("0.00");
                labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);

             }
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
           
                      
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
              
            labels[row][5] = new JButton("Closing Stock");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6] = new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7] = new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            //calculating closing stock from database
            
            try
            {
        
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps1 =con.createStatement();
            ResultSet rs1=ps1.executeQuery("select sum(amount) as closing_amount from closing");
          
            while(rs1.next())
            {
             closing=rs1.getString("closing_amount");
             if(closing!=null)
             {
              closing_total=Double.parseDouble(closing);
              closing=Double.toString(closing_total);
              
              labels[row][8]=new JButton();
            
              labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(closing);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
                          
             }
             else
             {
                labels[row][8]=new JButton();
            
                labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
                gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx=0.10;
                gridBagConstraints.gridx=61;
                gridBagConstraints.gridy=row;
                gridBagConstraints.gridwidth=5;
                labels[row][8].setFont(myFont);
                jPanel1.add(labels[row][8],gridBagConstraints);
                labels[row][8].setText("0.00");
                labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);

              }
           }
          
          System.out.println("Done");
            
         
        }
        catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
          
            
          
            
            row++;
            r=r1=row;
            
            
            labels[row][0]=new JButton("Purchase A/C");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //cohead.setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            //purchase total from database
            
            try{
        
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
             Statement ps =con.createStatement();
            ResultSet rs=ps.executeQuery("select sum(purchase_g_total) as purchase_total from purchase_table3");

           while(rs.next()){
               
             purchase=rs.getString("purchase_total");
             if(purchase!=null){
              purchase_total=Double.parseDouble(purchase);
              purchase=Double.toString(purchase_total);
               labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(purchase);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            }
             else{
                  labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText("0.00");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
             }
           }
          
          System.out.println("Done");
            
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
           
           
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Sale A/C");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            //sale total from database
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select sum(sale_g_total) as sale_total from sale_table3");
          
           while(rs.next()){
               
             sale=rs.getString("sale_total");
             if(sale!=null){
              sale_total=Double.parseDouble(sale);
              sale=Double.toString(sale_total);
              
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(sale);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
             }
             else{
               labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText("0.00");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);  
             }
           }
             }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            row++;
            r=r1=row;
            
            
            //Content Array Purchase A/C (Particulars and Value) displaying
            
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps10 =con.createStatement();
           ResultSet rs10=ps10.executeQuery("select purchase_ledger,sum(purchase_g_total) as g_total from purchase_table3 group by purchase_ledger");
            
            while(rs10.next())
            {
                pur_ledger=rs10.getString("purchase_ledger");
            if(pur_ledger!=null){
                pur_ledger_tot=Double.parseDouble(rs10.getString("g_total"));
                pur_led_tot=Double.toString(pur_ledger_tot);
            
            labels[r][0]=new JButton();
            
            labels[r][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r][0].setFont(myFont1);
            jPanel1.add(labels[r][0],gridBagConstraints);
            labels[r][0].setText("  "+(rs10.getString("purchase_ledger")));
            labels[r][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][1]=new JButton();
            
            labels[r][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            labels[r][1].setFont(myFont1);
            jPanel1.add(labels[r][1],gridBagConstraints);
            labels[r][1].setText(pur_led_tot);
            labels[r][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r][2]=new JButton("  ");
            
            labels[r][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r][2],gridBagConstraints);
            
            
            labels[r][3]=new JButton(" ");
            
            labels[r][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][3],gridBagConstraints);
            labels[r][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[r][4]=new JButton(" ");
            
            labels[r][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][4],gridBagConstraints);
            
            r++;
            }
            }
            
            }
        catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
            //Content Array Sale A/C (Particulars and Value) displaying
             
          try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps11 =con.createStatement();
           ResultSet rs11=ps11.executeQuery("select sale_ledger,sum(sale_g_total) as g_total from sale_table3 group by sale_ledger");
            
            
            while(rs11.next())
            {
            sale_ledger=rs11.getString("sale_ledger");
            if(sale_ledger!=null){
                sale_ledger_tot=Double.parseDouble(rs11.getString("g_total"));
                sale_led_tot=Double.toString(sale_ledger_tot);
            
            labels[r1][5]=new JButton();
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r1][5].setFont(myFont1);
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setText("  "+rs11.getString("sale_ledger"));
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton();
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            labels[r1][6].setFont(myFont1);
            jPanel1.add(labels[r1][6],gridBagConstraints);
            labels[r1][6].setText(sale_led_tot);
            labels[r1][6].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r1][7]=new JButton("  ");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            labels[r1][8]=new JButton(" ");
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r1++;
            
            }
            } 
              
              }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
            
            if (r>r1)
                row=r;
            else
                row=r1;
            
            //Content Direct Expense/Income displaying
            
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps12 =con.createStatement();
           ResultSet rs12=ps12.executeQuery("SELECT SUM(debit) AS di_exp FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Direct Expense' ");
            
            while(rs12.next()){
              direct_exp=rs12.getString("di_exp");
          
              
          if(direct_exp!=null){
              direct_exp_tot=Double.parseDouble(direct_exp);
            
            labels[r][0]=new JButton("Direct Expense");
            
            //labels[r][0]=new JButton("Direct Expense");
            
            labels[r][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r][0].setFont(myFont);
            jPanel1.add(labels[r][0],gridBagConstraints);
            labels[r][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][1]=new JButton(" ");
            
            labels[r][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][1],gridBagConstraints);
            //cohead.setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][2]=new JButton("  ");
            
            labels[r][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r][2],gridBagConstraints);
            
            
            labels[r][3]=new JButton();
            
            labels[r][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            labels[r][3].setFont(myFont);
            jPanel1.add(labels[r][3],gridBagConstraints);
            labels[r][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[r][3].setText(direct_exp);
            
                
            labels[r][4]=new JButton(" ");
            
            labels[r][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][4],gridBagConstraints);
            
            r++;
           }
            }
           }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
           try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps12 =con.createStatement();
           ResultSet rs12=ps12.executeQuery("SELECT SUM(credit) AS di_inc FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Direct Income' ");
            
            while(rs12.next()){
              direct_inc=rs12.getString("di_inc");
          
              
          if(direct_inc!=null){
              direct_inc_tot=Double.parseDouble(direct_inc);
         
            labels[r1][5]=new JButton("Direct Income");
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r1][5].setFont(myFont);
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton(" ");
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][6],gridBagConstraints);
            
            
            labels[r1][7]=new JButton("  ");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            
            labels[r1][8]=new JButton();
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            labels[r1][8].setFont(myFont);
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setText(direct_inc);
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r1++;
             }
            }
           }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
          
            if (r>r1)
                row=r;
            else
                row=r1;
            
            
                      
            //Content Array Direct Expense (Particulars and Value) displaying
            
            
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps13 =con.createStatement();
           ResultSet rs13=ps13.executeQuery("SELECT company_main_table.ledger,SUM(company_main_table.debit) AS di_exp_de FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Direct Expense' group by company_main_table.ledger ");
            
            
            while(rs13.next())
            {
            direct_exp_detail=rs13.getString("ledger");
            if(direct_exp_detail!=null)
            {
            
            labels[r][0]=new JButton();
            
            labels[r][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r][0].setFont(myFont1);
            jPanel1.add(labels[r][0],gridBagConstraints);
            labels[r][0].setText("  "+direct_exp_detail);
            labels[r][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][1]=new JButton();
            
            labels[r][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            labels[r][1].setFont(myFont1);
            jPanel1.add(labels[r][1],gridBagConstraints);
            labels[r][1].setText(rs13.getString("di_exp_de"));
            labels[r][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r][2]=new JButton("  ");
            
            labels[r][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r][2],gridBagConstraints);
            
            
            labels[r][3]=new JButton(" ");
            
            labels[r][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][3],gridBagConstraints);
            labels[r][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[r][4]=new JButton(" ");
            
            labels[r][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][4],gridBagConstraints);
            
            r++;
            }
            }
             }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
            //Content Array Direct Income (Particulars and Value) displaying
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps14 =con.createStatement();
           ResultSet rs14=ps14.executeQuery("SELECT company_main_table.ledger,SUM(company_main_table.credit) AS di_inc_de FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Direct Income' group by company_main_table.ledger ");
            
            
            while(rs14.next())
            {
            
            direct_inc_detail=rs14.getString("ledger");
            if(direct_inc_detail!=null)
            {
           
            labels[r1][5]=new JButton();
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r1][5].setFont(myFont1);
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setText("   "+direct_inc_detail);
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton();
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            labels[r1][6].setFont(myFont1);
            jPanel1.add(labels[r1][6],gridBagConstraints);
            labels[r1][6].setText(rs14.getString("di_inc_de"));
            labels[r1][6].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r1][7]=new JButton("  ");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            labels[r1][8]=new JButton(" ");
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r1++;
            }            
            }
             }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
          
                        
            if (r1>r)
            {
                row=r1;
                chk=1;
                blankrowprint(r, r1-1, chk);
            }
            else
            {
                row=r; 
                chk=2;
                blankrowprint(r1, r-1, chk) ;
            }
           
            
            
            //Content Total(1) displaying
            total1=opening_total + purchase_total + direct_exp_tot;
            String tot=Double.toString(total1);
            total2=closing_total+sale_total +direct_inc_tot;
            String tot1=Double.toString(total2);
           // diff_total=total1 - total2;
   
            
            
            labels[row][0]=new JButton("Total after DE");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            //labels[row][0].setText(rs1.getString("cash_bank_date"));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Total after DI");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(tot1);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            row++;
            r=r1=row;
           
            /*r1++;
            r++;
                
            if (r>r1)
                row=r;
            else
                row=r1; 
            */ 
            
          
            //Content Gross Profit/Loss carried over displaying
            if(total1>total2)
            {
                diff_total=total1 - total2;
                      String gross_pl1=Double.toString(diff_total);
                       
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(" ");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Gross Loss c/o");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont2);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont2);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(gross_pl1);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
            
            }
            else if(total2>total1)
            {
                diff_total=total2 -  total1;
                      String gross_pl=Double.toString(diff_total);
            
            labels[row][0]=new JButton("Gross Profit c/o");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_pl);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
           //labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
            
            }
            else{
                 diff_total=total2 - total1;
                 // String gross_pl=Double.toString(diff_total);
            
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
           // labels[row][3].setText(gross_pl);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
           //labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
                            
            }
            
            /*if (r>r1)
                row=r;
            else
                row=r1;            
            */
            //Checking which is bigger and assigning it to be displayed
            total_first = (total1>total2?total1:total2);
            String tot_first = Double.toString(total_first);
            
            
            //Content Total(2) after Gross P/L displaying
            
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            //labels[row][0].setText(rs1.getString("cash_bank_date"));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot_first);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Total");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(tot_first);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
          
            //Content Gross Profit/Loss brought forward displaying
              if(total1>total2)
            {
                diff_total=total1 - total2;
                String gross_plbf=Double.toString(diff_total);
            
            labels[row][0]=new JButton("Gross Loss b/f");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_plbf);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
          //  labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
            
            }
              else if(total2>total1)
            {
                diff_total=total2 -  total1;
                String gross_plbf1=Double.toString(diff_total);
                        
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(" ");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Gross Profit b/f");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont2);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont2);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(gross_plbf1);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            r=r1=row;
            
            }
             
            if (r>r1)
                row=r;
            else
                row=r1; 
              
            /*
            //Content Total(3) after Gross P/L displaying
                                  
            labels[r][0]=new JButton("Total");
            
            labels[r][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r][0],gridBagConstraints);
            //labels[r][0].setText(rs1.getString("cash_bank_date"));
            labels[r][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][1]=new JButton("");
            
            labels[r][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][1],gridBagConstraints);
            //labels[r][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r][2]=new JButton("");
            
            labels[r][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][2],gridBagConstraints);
            
            
            labels[r][3]=new JButton();
            
            labels[r][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][3],gridBagConstraints);
            labels[r][3].setText(rs1.getString("cash_bank_date"));
            labels[r][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[r][4]=new JButton(" ");
            
            labels[r][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][4],gridBagConstraints);
            
            
            labels[r1][5]=new JButton("Total");
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton("");
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][6],gridBagConstraints);
            
            
            labels[r1][7]=new JButton("");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            labels[r1][8]=new JButton("605008");
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setText(rs1.getString("cash_bank_date"));
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r1++;
            r++;
            
            if (r>r1)
                row=r;
            else
                row=r1;
            
            */
            
            //Content Indirect Expense/Income displaying
            
               try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps15 =con.createStatement();
           ResultSet rs15=ps15.executeQuery("SELECT SUM(company_main_table.debit) AS indi_exp_de FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Indirect Expense' ");
            
            while(rs15.next())
            {
             indirect_exp_total=rs15.getString("indi_exp_de");
             if(indirect_exp_total!=null)
             {
                indirct_exp_tot_value=Double.parseDouble(indirect_exp_total);
                indirect_exp_total=Double.toString(indirct_exp_tot_value);
            
            labels[row][0]=new JButton("Indirect Expense");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(indirect_exp_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            /*
            labels[r1][5]=new JButton(" ");
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton("");
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][6],gridBagConstraints);
            
            
            labels[r1][7]=new JButton("");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            labels[r1][8]=new JButton();
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setText("");
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            */
                    
             }
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
            /*if (r>r1)
                row=r;
            else
                row=r1;
            */
               

        //Indirct Income   total only
              
         try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps15 =con.createStatement();
           ResultSet rs15=ps15.executeQuery("SELECT SUM(company_main_table.credit) AS indi_inc_de FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Indirect Income' ");
            
            while(rs15.next())
            {
             indirect_inc_total=rs15.getString("indi_inc_de");
             if(indirect_inc_total!=null)
             {
                indirct_inc_tot_value=Double.parseDouble(indirect_inc_total);
                indirect_inc_total=Double.toString(indirct_inc_tot_value);
           
            labels[row][5]=new JButton("Indirect Income");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            labels[row][6].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(indirect_inc_total);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
         row++;
         r=r1=row;

           //Content Array InDirect Expense (Particulars and Value) displaying
            
                try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps16 =con.createStatement();
           ResultSet rs16=ps16.executeQuery("SELECT ledger,SUM(company_main_table.debit) AS indirect_detail FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Indirect Expense' group by company_main_table.ledger");
            
            while(rs16.next())
            {
               indirect_income_details=rs16.getString("indirect_detail");
               if(indirect_income_details!=null)
               {
            labels[r][0]=new JButton();
            
            labels[r][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r][0].setFont(myFont1);
            jPanel1.add(labels[r][0],gridBagConstraints);
            labels[r][0].setText("  "+rs16.getString("ledger"));
            labels[r][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r][1]=new JButton();
            
            labels[r][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            labels[r][1].setFont(myFont1);
            jPanel1.add(labels[r][1],gridBagConstraints);
            labels[r][1].setText(rs16.getString("indirect_detail"));
            labels[r][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r][2]=new JButton("  ");
            
            labels[r][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r][2],gridBagConstraints);
            
            
            labels[r][3]=new JButton(" ");
            
            labels[r][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[r][3],gridBagConstraints);
            labels[r][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[r][4]=new JButton(" ");
            
            labels[r][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[r][4],gridBagConstraints);
            
            r++;
               }  
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
        
           //Content Array Direct Income (Particulars and Value) displaying
              
           try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps17 =con.createStatement();
           ResultSet rs17=ps17.executeQuery("SELECT ledger,SUM(company_main_table.credit) AS indirect_detail1 FROM company_main_table,ledger WHERE company_main_table.ledger=ledger.l_name AND ledger.l_under='Indirect Income' group by company_main_table.ledger");
            while(rs17.next())
            {
            indirect_expense_details=rs17.getString("indirect_detail1");
            if(indirect_expense_details!=null)
            {
            
            labels[r1][5]=new JButton();
            
            labels[r1][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[r1][5].setFont(myFont1);
            jPanel1.add(labels[r1][5],gridBagConstraints);
            labels[r1][5].setText("  "+rs17.getString("ledger"));
            labels[r1][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[r1][6]=new JButton();
            
            labels[r1][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            labels[r1][6].setFont(myFont1);
            jPanel1.add(labels[r1][6],gridBagConstraints);
            labels[r1][6].setText(rs17.getString("indirect_detail1"));
            labels[r1][6].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[r1][7]=new JButton("  ");
            
            labels[r1][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[r1][7],gridBagConstraints);
            
            
            labels[r1][8]=new JButton(" ");
            
            labels[r1][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=r1;
            gridBagConstraints.gridwidth=5;
            labels[r1][8].setFont(myFont1);
            jPanel1.add(labels[r1][8],gridBagConstraints);
            labels[r1][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r1++;
            }          
            }
              }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
               
              if (r1>r)
            {
                row=r1;
                chk=1;
                blankrowprint(r, r1-1, chk);
            }
            else
            {
                row=r; 
                chk=2;
                blankrowprint(r1, r-1, chk) ;
            }
            
         //Content Net Profit/Loss displaying
          
         //net_loss=diff_total+indirct_inc_tot_value;
           
           loss_value=diff_total+indirct_exp_tot_value;
           profit_value=diff_total+indirct_inc_tot_value;
           
           if(indirct_exp_tot_value<profit_value&&total2>total1)
            {
                net_profit=(diff_total+indirct_inc_tot_value)-indirct_exp_tot_value;
                String profit=Double.toString(net_profit);
                flag=1;
            
            labels[row][0]=new JButton("Net Profit");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(profit);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(" ");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            
            }
          
            else if(loss_value>indirct_inc_tot_value&&total1>total2)
            {
                  net_loss=(diff_total+indirct_exp_tot_value)-indirct_inc_tot_value;
                  
                String loss=Double.toString(net_loss);
                flag=2;
            
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(" ");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Net Loss");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont2);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont2);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(loss);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            }
            
            else if(loss_value<indirct_inc_tot_value && total1>total2)
            {
             
                net_loss=indirct_inc_tot_value  - (diff_total+indirct_exp_tot_value);
                String loss=Double.toString(net_loss);
                flag=3;
            
            labels[row][0]=new JButton("Net Profit");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(loss);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1.0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(" ");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            }
            else if(profit_value<indirct_exp_tot_value&&total2>total1)
            {
                net_profit=indirct_exp_tot_value  - profit_value;
                String profit=Double.toString(net_profit);
                System.out.println(profit);
                flag=4;
            
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(" ");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Net Loss");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][5].setFont(myFont2);
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][8].setFont(myFont2);
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(profit);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            }
            
            r=r1=row;
           
            /*if (r>r1)
                row=r;
            else
                row=r1;
            */
            
           //Print Blank Row
            
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            //labels[row][3].setText(indirect_exp_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            labels[row][5]=new JButton(" ");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6], gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            //labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            
            //Content Grand Total displaying
            /*
            if(flag==1){
            
            String g_tot=Double.toString(profit_value);
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(g_tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Totals");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(g_tot);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            
            else if(flag==2)
            {
            String g_tot=Double.toString(profit_value);
            
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(g_tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Total");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(g_tot);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            else if(flag==3)
            {
            
            String g_tot=Double.toString(profit_value);
            
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(g_tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Total");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(g_tot);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            else if(flag==4){
             String g_tot=Double.toString(profit_value);
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(g_tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            labels[row][5]=new JButton("Total");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6],gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton();
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            labels[row][8].setText(g_tot);
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            }
            
            
            row++;
            
            /*
            //Blank Rows
            
            labels[row][0]=new JButton("C++");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            //labels[row][3].setText(indirect_exp_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            labels[row][5]=new JButton("Java");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6], gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.fill=gridBagConstraints.VERTICAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=1.00;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            //labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            
            //Print Blank Row
            
            labels[row][0]=new JButton("Hello");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            //labels[row][3].setText(indirect_exp_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            labels[row][5]=new JButton("World");
            
            labels[row][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][5],gridBagConstraints);
            labels[row][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][6]=new JButton(" ");
            
            labels[row][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][6], gridBagConstraints);
            
            
            labels[row][7]=new JButton("  ");
            
            labels[row][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][7],gridBagConstraints);
            
            
            labels[row][8]=new JButton(" ");
            
            labels[row][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.weighty=0.00;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][8],gridBagConstraints);
            //labels[row][8].setText("");
            labels[row][8].setHorizontalAlignment(SwingConstants.RIGHT);
            
            row++;
            
            */
            
            //Printing Vetical line in between for Full Report
            
            /*
            for (int rz=0; rz<row; rz++)
            {
                labels[rz][4]=new JButton(" ");

                labels[rz][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
                gridBagConstraints.weightx=0;
                gridBagConstraints.gridx=32;
                gridBagConstraints.gridy=rz;
                gridBagConstraints.gridwidth=2;
                gridBagConstraints.fill=gridBagConstraints.NONE;
                jPanel1.add(labels[rz][4],gridBagConstraints);
            }
            */
       
            //Converting Buttons to Labels excluding Row 0 (reserved for heading)
               
                for (int l=0; l < 9; l++)
                {
                    //labels [l][0].setBorderPainted(false);
                    labels [0][l].setContentAreaFilled(false);
                    
                }
            
                for (int i = 1; i < row; i++) 
                {
                   // loop for column buttons 0-8
                    for (JButton item : labels[i]) 
                   {
                       item.setBorderPainted(false);
                       item.setContentAreaFilled(false);
                       item.setFocusPainted(false);
                       item.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                   }
                }
              
            for (int rz=1; rz<row; rz++)
            {
                labels[rz][4]=new JButton(" ");
                
                labels[rz][4].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
                gridBagConstraints.weightx=0;
                gridBagConstraints.gridx=32;
                gridBagConstraints.gridy=rz;
                gridBagConstraints.gridwidth=2;
                gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
                jPanel1.add(labels[rz][4],gridBagConstraints);
                labels[rz][4].setContentAreaFilled(false);
            }
                
            
            //Panel 2 test
            /*
            gbc.anchor=gbc.PAGE_START;
            
            jPanel2.setLayout(gridbag);
            
            JButton[][] labels2=new JButton[1][9];
            
            
            labels2[0][0]=new JButton("Particulars");
            
            labels2[0][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gbc.weightx=0.20;
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.gridwidth=15;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][0],gbc);
            labels2[0][0].setFont(myFont);
            labels2[0][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels2[0][1]=new JButton("Am");
            
            labels2[0][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            
            gbc.weightx=0.10;
            gbc.gridx=17;
            gbc.gridy=0;
            gbc.gridwidth=5;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][1],gbc);
            labels2[0][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels2[0][2]=new JButton("ou");
            
            labels2[0][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gbc.weightx=0;
            gbc.gridx=23;
            gbc.gridy=0;
            gbc.gridwidth=2;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][2],gbc);
            
            
            labels2[0][3]=new JButton("nt");
            
            labels2[0][3].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.blue));
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            gbc.weightx=0.10;
            gbc.gridx=26;
            gbc.gridy=0;
            gbc.gridwidth=5;
            jPanel2.add(labels2[0][3],gbc);
            labels2[0][3].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels2[0][4]=new JButton(" ");
            
            labels2[0][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gbc.weightx=0;
            gbc.weighty=1.0;
            gbc.gridx=32;
            gbc.gridy=0;
            gbc.gridwidth=2;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][4],gbc);
            
                        
            labels2[0][5]=new JButton("Particulars");
            
            labels2[0][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gbc.weightx=0.20;
            gbc.gridx=35;
            gbc.gridy=0;
            gbc.gridwidth=15;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][5],gbc);
            labels2[0][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels2[0][6]=new JButton("Am");
            
            labels2[0][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            gbc.weightx=0.10;
            gbc.gridx=52;
            gbc.gridy=0;
            gbc.gridwidth=5;
            jPanel2.add(labels2[0][6],gbc);
            
            
            labels2[0][7]=new JButton("ou");
            
            labels2[0][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gbc.weightx=0;
            gbc.gridx=58;
            gbc.gridy=0;
            gbc.gridwidth=2;
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            jPanel2.add(labels2[0][7],gbc);
            
            
            labels2[0][8]=new JButton("nt");
            
            labels2[0][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gbc.fill=gbc.HORIZONTAL;
            gbc.fill=gbc.VERTICAL;
            gbc.weightx=0.10;
            gbc.gridx=61;
            gbc.gridy=0;
            gbc.gridwidth=5;
            jPanel2.add(labels2[0][8],gbc);
            labels2[0][8].setHorizontalAlignment(SwingConstants.RIGHT);
            */
            
        //   this.add(new Surfdraw());
        //   setSize(350, 250);
        //   this.setLocationRelativeTo(null); 
          
            
            //pack();
           
            
            //Inserting data into Database
           
//                      
//            for (int pl1=1; pl1<row; pl1++)
//            {
//                System.out.print(labels[pl1][1].getText()+" ");
//                System.out.println(labels[pl1][3].getText());
//                
//                System.out.print(labels[pl1][6].getText()+" ");
//                System.out.println(labels[pl1][8].getText());
//                
//            try
//            {
//                
//            Class.forName("com.mysql.jdbc.Driver");
//            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
//            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
//        
//             PreparedStatement psq=con.prepareStatement("delete from pl_open");
//            PreparedStatement psq1=con.prepareStatement("delete from pl_close");
//            
//            psq.executeUpdate();
//            psq1.executeUpdate();
//            
//            PreparedStatement ps=con.prepareStatement("insert into pl_open(part_data,amt_1,amt_2,year)values('"+labels[pl1][0].getText()+"','"+labels[pl1][1].getText()+"','"+labels[pl1][3].getText()+"','"+2014+"')");
//            PreparedStatement ps1=con.prepareStatement("insert into pl_close(part_data_2,amt_3,amt_4,year_2)values('"+labels[pl1][5].getText()+"','"+labels[pl1][6].getText()+"','"+labels[pl1][8].getText()+"','"+2014+"')");
//            
//            ps.executeUpdate();
//            ps1.executeUpdate();
//            
//            System.out.println("saved");
//            
//            JOptionPane jopt2=new JOptionPane();
//            jopt2.showMessageDialog(this,"Saved");
//            
//            }
//            catch (SQLException e)
//            {
//            System.out.println("Sql Exception" + e.toString());
//            }
//            catch(ClassNotFoundException ce)
//            {
//            System.out.println("ClassNotFoundException" + ce.toString());
//            }
//            
//            }
            
            //Pre Selecting the first row of data 
           
           labels[1][0].requestFocus();
           labels[1][0].setContentAreaFilled(true);
           labels[1][1].setContentAreaFilled(true);
           labels[1][2].setContentAreaFilled(true);
           labels[1][3].setContentAreaFilled(true);
           
           labels[1][0].setBackground(Color.orange);
           labels[1][1].setBackground(Color.orange);
           labels[1][2].setBackground(Color.orange);
           labels[1][3].setBackground(Color.orange);
           
           /*
           
           labels[1][1].setContentAreaFilled(true);
           labels[1][2].setContentAreaFilled(true);
           labels[1][3].setContentAreaFilled(true);
           
           labels[1][0].setContentAreaFilled(true);
           //labels[1][0].setBorder(null);
           //labels[1][0].setBorderPainted(false);
           labels[1][0].setBackground(Color.orange);
                     
           labels[1][1].setBorder(null);
           labels[1][2].setBorder(null);
           labels[1][3].setBorder(null);
                              
           labels[1][1].setBackground(Color.orange);
           labels[1][2].setBackground(Color.orange);
           labels[1][3].setBackground(Color.orange);
           */
           
           
        //Embedding Key Movement traversal
        // i loop for rows
        // j loop for columns
            
        for (int i = 0; i < row; i++) 
        {
          for (int j = 0; j < labels[i].length; j++) {
            final int rowfin = row;
            final int curRow = i;
            final int curCol = j;
            labels[i][j].setBorderPainted(true);
            labels[i][j].addKeyListener(enter);
            labels[i][j].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (curRow > 1)
                     {
                        if (!" ".equals(labels[curRow - 1][curCol].getText()))
                        {
                        labels[curRow - 1][curCol].requestFocus();
                        labels[curRow - 1][curCol].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+1].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+2].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+3].setContentAreaFilled(true);
                        
                        labels[curRow - 1][curCol].setBackground(Color.orange);
                        labels[curRow - 1][curCol+1].setBackground(Color.orange);
                        labels[curRow - 1][curCol+2].setBackground(Color.orange);
                        labels[curRow - 1][curCol+3].setBackground(Color.orange);
                        
                                         
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol+1].setContentAreaFilled(false);
                        labels[curRow][curCol+2].setContentAreaFilled(false);
                        labels[curRow][curCol+3].setContentAreaFilled(false);
                        }
                     else 
                        {
                            int cr = curRow;
                            do
                            {
                             cr--;   
                            }
                            while (" ".equals(labels[cr][curCol].getText()));
                            
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol+1].setContentAreaFilled(false);
                        labels[curRow][curCol+2].setContentAreaFilled(false);
                        labels[curRow][curCol+3].setContentAreaFilled(false);
                        
                        labels[cr][curCol].requestFocus();
                        
                        labels[cr][curCol].setContentAreaFilled(true);
                        labels[cr][curCol+1].setContentAreaFilled(true);
                        labels[cr][curCol+2].setContentAreaFilled(true);
                        labels[cr][curCol+3].setContentAreaFilled(true);
                        
                        labels[cr][curCol].setBackground(Color.orange);
                        labels[cr][curCol+1].setBackground(Color.orange);
                        labels[cr][curCol+2].setBackground(Color.orange);
                        labels[cr][curCol+3].setBackground(Color.orange);
                        }
                     }
                     break;
                  case KeyEvent.VK_DOWN:
                     if (curRow < rowfin - 1)
                     {
                        if (!" ".equals(labels[curRow + 1][curCol].getText()))
                        {    
                        labels[curRow + 1][curCol].requestFocus();
                        labels[curRow + 1][curCol].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+1].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+2].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+3].setContentAreaFilled(true);
                        
                        labels[curRow + 1][curCol].setBackground(Color.orange);
                        labels[curRow + 1][curCol+1].setBackground(Color.orange);
                        labels[curRow + 1][curCol+2].setBackground(Color.orange);
                        labels[curRow + 1][curCol+3].setBackground(Color.orange);
                            
                                if (curRow != 0)//to keep the heading intact with border
                                {    
                                labels[curRow][curCol].setContentAreaFilled(false);
                                labels[curRow][curCol+1].setContentAreaFilled(false);
                                labels[curRow][curCol+2].setContentAreaFilled(false);
                                labels[curRow][curCol+3].setContentAreaFilled(false);
                                }
                        }
                        else 
                        {
                            int cr = curRow;
                            do
                            {
                             cr++;   
                            }
                            while ((labels[cr][curCol].getText()) == " ");
                            
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol+1].setContentAreaFilled(false);
                        labels[curRow][curCol+2].setContentAreaFilled(false);
                        labels[curRow][curCol+3].setContentAreaFilled(false);
                        
                        labels[cr][curCol].requestFocus();
                        labels[cr][curCol].setContentAreaFilled(true);
                        labels[cr][curCol+1].setContentAreaFilled(true);
                        labels[cr][curCol+2].setContentAreaFilled(true);
                        labels[cr][curCol+3].setContentAreaFilled(true);
                        
                        labels[cr][curCol].setBackground(Color.orange);
                        labels[cr][curCol+1].setBackground(Color.orange);
                        labels[cr][curCol+2].setBackground(Color.orange);
                        labels[cr][curCol+3].setBackground(Color.orange);
                        }
                     }
                       break;
                  case KeyEvent.VK_LEFT:
                     if (curCol > 0)
                     {
                        if (!" ".equals(labels[curRow][curCol - 5].getText()))
                        {
                        labels[curRow][curCol - 5].requestFocus();
                        labels[curRow][curCol - 5].setContentAreaFilled(true);
                        labels[curRow][curCol - 4].setContentAreaFilled(true);
                        labels[curRow][curCol - 3].setContentAreaFilled(true);
                        labels[curRow][curCol - 2].setContentAreaFilled(true);
                        
                        labels[curRow][curCol - 5].setBackground(Color.orange);
                        labels[curRow][curCol - 4].setBackground(Color.orange);
                        labels[curRow][curCol - 3].setBackground(Color.orange);
                        labels[curRow][curCol - 2].setBackground(Color.orange);
                        
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol + 1].setContentAreaFilled(false);
                        labels[curRow][curCol + 2].setContentAreaFilled(false);
                        labels[curRow][curCol + 3].setContentAreaFilled(false);
                        }
                    }
                     break;
                  case KeyEvent.VK_RIGHT:
                     if (curCol < 4 && curRow > 0)
                     {
                        if (!" ".equals(labels[curRow][curCol + 5].getText()))
                        {
                        labels[curRow][curCol + 5].requestFocus();
                        labels[curRow][curCol + 5].setContentAreaFilled(true);
                        labels[curRow][curCol + 6].setContentAreaFilled(true);
                        labels[curRow][curCol + 7].setContentAreaFilled(true);
                        labels[curRow][curCol + 8].setContentAreaFilled(true);
                        
                        labels[curRow][curCol + 5].setBackground(Color.orange);
                        labels[curRow][curCol + 6].setBackground(Color.orange);
                        labels[curRow][curCol + 7].setBackground(Color.orange);
                        labels[curRow][curCol + 8].setBackground(Color.orange);
                        
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol + 1].setContentAreaFilled(false);
                        labels[curRow][curCol + 2].setContentAreaFilled(false);
                        labels[curRow][curCol + 3].setContentAreaFilled(false);
                        }
                     }
                     break;
                  default:
                      System.out.println();
                     break;
                  }
               }
            });
         }
      }
    
    }
    
     private KeyListener enter = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
         if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            ((JButton) e.getComponent()).doClick();
         }
      }
   };
    
    
    public void blankrowprint(int start_row, int end_row, int check)
    {
        if (check==1)
        {
         for (int s=start_row; s<=end_row; s++)
         {
            labels[s][0]=new JButton(" ");
            
            labels[s][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[s][0],gridBagConstraints);
            labels[s][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[s][1]=new JButton(" ");
            
            labels[s][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=17;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[s][1],gridBagConstraints);
            //labels[s][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[s][2]=new JButton("  ");
            
            labels[s][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=23;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[s][2],gridBagConstraints);
            
            
            labels[s][3]=new JButton(" ");
            
            labels[s][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=26;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[s][3],gridBagConstraints);
            //labels[s][3].setText(indirect_exp_total);
            labels[s][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[s][4]=new JButton(" ");
            
            labels[s][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=32;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[s][4],gridBagConstraints);
           
         }
        
        }
        
        else if (check == 2)
        {
            for (int s=start_row; s<=end_row; s++)
            {
            labels[s][5]=new JButton(" ");
            
            labels[s][5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.20;
            gridBagConstraints.gridx=35;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[s][5],gridBagConstraints);
            labels[s][5].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[s][6]=new JButton(" ");
            
            labels[s][6].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=52;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[s][6], gridBagConstraints);
            
            
            labels[s][7]=new JButton("  ");
            
            labels[s][7].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=58;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[s][7],gridBagConstraints);
            
            
            labels[s][8]=new JButton(" ");
            
            labels[s][8].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.10;
            gridBagConstraints.gridx=61;
            gridBagConstraints.gridy=s;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[s][8],gridBagConstraints);
            //labels[s][8].setText("");
            labels[s][8].setHorizontalAlignment(SwingConstants.RIGHT);
            }
        }
    
    }
    @Override
    public boolean isFocusTraversable()
{
    return true;
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

        jPanel1.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentAdded(ContainerEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
