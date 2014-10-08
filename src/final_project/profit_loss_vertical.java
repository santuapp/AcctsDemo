
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author virtual vista
 */
public class profit_loss_vertical extends javax.swing.JFrame implements ContainerListener{

    private final GridBagConstraints gridBagConstraints;
    int count = 1000;
    final JButton[][] labels=new JButton[count][5];
    /**
     * Creates new form profit_loss_vertical
     */
    public profit_loss_vertical() {
        initComponents();
        Font myFont = new Font("plain", Font.BOLD, 13);
        Font myFont1 = new Font("plain", Font.ITALIC, 13);
        Font myFont2 = new Font("plain", Font.ITALIC + Font.BOLD, 13);
        gridBagConstraints = new java.awt.GridBagConstraints();
        addContainerListener(this);
            
        gridBagConstraints.anchor=gridBagConstraints.PAGE_START;
        
         double net_profit=0.0d,net_loss=0.0d,closing_total=0.0d,purchase_total=0.0d,opening_total=0.0d,sale_total=0.0d,pur_ledger_tot=0.0d,sale_ledger_tot=0.0d,direct_exp_tot=0.0d,direct_inc_tot=0.0d,total1=0.0d,total2=0.0d,diff_total=0.0d,indirct_exp_tot_value=0.0d,indirct_inc_tot_value=0.0d,profit_value=0.0d,loss_value=0.0d, total_first=0.0d;
            String closing="",purchase="", opening="",sale="",pur_ledger="",pur_led_tot="",sale_led_tot="",sale_ledger="",direct_exp="",direct_inc="", direct_inc_detail="",direct_exp_detail="",indirect_exp_led="",indirect_exp_total="", indirect_inc_total="",indirect_income_details="",indirect_expense_details="";
            int chk=0, pur=0, sal=0, dex=0, dinc=0, inex=0, indinc=0, l1=0, l2=0, r=0, row=3, r1=0,flag=0;        

        
        //Heading Labels
         // Panel 1 start.....y=2
            
            JLabel tohead=new JLabel("Particulars");
            tohead.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.70;
            tohead.setHorizontalAlignment(SwingConstants.CENTER);
            tohead.setFont(myFont);
            jPanel1.add(tohead,gridBagConstraints);
            tohead.setHorizontalAlignment(SwingConstants.LEFT);
            
            JLabel refhead=new JLabel("1-Apr-2008");
            refhead.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            refhead.setHorizontalAlignment(SwingConstants.CENTER);
            //gridBagConstraints.anchor=gridBagConstraints.EAST;
            gridBagConstraints.weightx=0.15;
            refhead.setFont(myFont);
            jPanel1.add(refhead,gridBagConstraints);
            
            JLabel blankhead4=new JLabel("to");
            blankhead4.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            blankhead4.setFont(myFont);
            jPanel1.add(blankhead4,gridBagConstraints);
            
            JLabel refhead1=new JLabel("1-Apr-2009");
            refhead1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            refhead1.setHorizontalAlignment(SwingConstants.CENTER);
            //gridBagConstraints.anchor=gridBagConstraints.EAST;
            gridBagConstraints.weightx=0.15;
            refhead1.setFont(myFont);
            jPanel1.add(refhead1,gridBagConstraints);
            
            JLabel blankhead5=new JLabel(" ");
            blankhead5.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            blankhead5.setFont(myFont);
            jPanel1.add(blankhead5,gridBagConstraints);
            
            
            // Heading Button for Trading Account
            
            
            
            labels[row][0] = new JButton("Trading Account:");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            // Heading Sale A/C
            
            labels[row][0] = new JButton("Sale A/C");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
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
              
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(sale);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
             }
             else{
               labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText("0.00");
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);  
             }
           }
             }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            
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
            
            labels[row][0]=new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont1);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("  "+rs11.getString("sale_ledger"));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont1);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(sale_led_tot);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton("  ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            }
            } 
              
              }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
          
          // Heading Opening Stock
          
            labels[row][0] = new JButton("Opening Stock");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
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
                gridBagConstraints.weightx=0.15;
                gridBagConstraints.gridx=24;
                gridBagConstraints.gridy=row;
                gridBagConstraints.gridwidth=5;
                labels[row][3].setFont(myFont);
                jPanel1.add(labels[row][3],gridBagConstraints);
                labels[row][3].setText("0.00");
                labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);

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
               
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            // Heading Purchase Account
            
            
            labels[row][0] = new JButton("Purchase A/C");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
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
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints); 
            
            row++;
            
            
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
            
            labels[row][0]=new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont1);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("  "+(rs10.getString("purchase_ledger")));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont1);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(pur_led_tot);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
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
            
             
             
              // Heading Closing Balance
             
            
            labels[row][0] = new JButton("Closing Stock");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
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
              
              labels[row][3]=new JButton();
            
              labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(closing);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
                          
             }
             else
             {
                labels[row][3]=new JButton();
            
                labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
                gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx=0.10;
                gridBagConstraints.gridx=59;
                gridBagConstraints.gridy=row;
                gridBagConstraints.gridwidth=5;
                labels[row][3].setFont(myFont);
                jPanel1.add(labels[row][3],gridBagConstraints);
                labels[row][3].setText("0.00");
                labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);

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
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints); 
            
            row++;
            
            
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
            
            labels[row][0]=new JButton("Direct Expense");
            
            //labels[r][0]=new JButton("Direct Expense");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //cohead.setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(direct_exp);
            
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
           }
            }
           }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
               
                              
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
            
            labels[row][0]=new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont1);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("  "+direct_exp_detail);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont1);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(rs13.getString("di_exp_de"));
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            }
            }
             }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
             
             
             // Heading Direct Income(Displaying)
             
             
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
         
            labels[row][0]=new JButton("Direct Income");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(direct_inc);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++; 
             
             }
            }
           }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
         
                     
            //Content Total(1) displaying
                
            total1=opening_total + purchase_total + direct_exp_tot;
            String tot=Double.toString(total1);
            total2=closing_total+sale_total +direct_inc_tot;
            String tot1=Double.toString(total2);
            
           // diff_total=total1 - total2;
   
            
            
            labels[row][0]=new JButton("Total after DE");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            labels[row][0]=new JButton("Total after DI");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot1);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            row++;
            
           
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
                       
           
            
            labels[row][0]=new JButton("Gross Loss c/o");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_pl1);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
           
            
            }
            else if(total2>total1)
            {
                diff_total=total2 -  total1;
                      String gross_pl=Double.toString(diff_total);
            
            labels[row][0]=new JButton("Gross Profit c/o");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_pl);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
           row++;
            
            }
            else{
                 diff_total=total2 - total1;
                 // String gross_pl=Double.toString(diff_total);
            
            labels[row][0]=new JButton(" ");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
           // labels[row][3].setText(gross_pl);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
           
            row++;
            
                            
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
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot_first);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            labels[row][0]=new JButton("Total");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(tot_first);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            r=r1=row;
                   
            //Content Gross Profit/Loss brought forward displaying
                
              if(total1>total2)
            {
                diff_total=total1 - total2;
                String gross_plbf=Double.toString(diff_total);
            
            labels[row][0]=new JButton("Gross Loss b/f");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_plbf);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            row++;
            
            }
              else if(total2>total1)
            {
                diff_total=total2 -  total1;
                String gross_plbf1=Double.toString(diff_total);
                        
           
            
            labels[row][0]=new JButton("Gross Profit b/f");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(gross_plbf1);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            
            
            }
              
                       // Heading Income Statement
            
            
            
            labels[row][0] = new JButton("Income Statement:");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            labels[row][2] = new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            
            labels[row][4] = new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][4].setFont(myFont);
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
                
              
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
           
            labels[row][0]=new JButton("Indirect Income");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(indirect_inc_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
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
        
         
            //Content Array InDirect Income (Particulars and Value) displaying
              
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
            
            labels[row][0]=new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont1);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("  "+rs17.getString("ledger"));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont1);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(rs17.getString("indirect_detail1"));
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont1);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            }          
            }
              }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
                
                
         
            
            // Heading Indirect Expense Displaying
            
            
                
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
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(indirect_exp_total);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=2;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
             }
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
               
               
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
            labels[row][0]=new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont1);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("  "+rs16.getString("ledger"));
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.pink));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][1].setFont(myFont1);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(rs16.getString("indirect_detail"));
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
               }  
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
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
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(profit);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            
            
            row++;
            
            }
          
            else if(loss_value>indirct_inc_tot_value&&total1>total2)
            {
                  net_loss=(diff_total+indirct_exp_tot_value)-indirct_inc_tot_value;
                  
                String loss=Double.toString(net_loss);
                flag=2;
            
         
            labels[row][0]=new JButton("Net Loss");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(loss);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            }
            
            else if(loss_value<indirct_inc_tot_value && total1>total2)
            {
             
                net_loss=indirct_inc_tot_value  - (diff_total+indirct_exp_tot_value);
                String loss=Double.toString(net_loss);
                flag=3;
            
            labels[row][0]=new JButton("Net Profit");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.weightx=0.70;
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
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            //labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2]=new JButton(" ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(loss);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
          
            row++;
            }
            else if(profit_value<indirct_exp_tot_value&&total2>total1)
            {
                net_profit=indirct_exp_tot_value  - profit_value;
                String profit=Double.toString(net_profit);
                System.out.println(profit);
                flag=4;
            
           
            labels[row][0]=new JButton("Net Loss");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow));
            gridBagConstraints.weightx=0.70;
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            labels[row][0].setFont(myFont2);
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            
            labels[row][1]=new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            jPanel1.add(labels[row][1],gridBagConstraints);
            
            
            labels[row][2]=new JButton("  ");
            
            labels[row][2].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=22;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3]=new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.cyan));
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.15;
            gridBagConstraints.gridx=24;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=5;
            labels[row][3].setFont(myFont2);
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(profit);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][4]=new JButton(" ");
            
            labels[row][4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.magenta));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=30;
            gridBagConstraints.gridy=row;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.NONE;
            jPanel1.add(labels[row][4],gridBagConstraints);
            
            row++;
            }
           
                  
            for (int pl1=4; pl1<row; pl1++)
            {
               // System.out.print(labels[pl1][0].getText()+" ");
              //  System.out.println(labels[pl1][1].getText());
                
              //  System.out.println(labels[pl1][2].getText());
               
            try
            {
                
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        
            //PreparedStatement ps=con.prepareStatement("insert into v_p_l(partlr,amt_1,amt_2,amt_3)values('"+labels[pl1][0].getText()+"','"+labels[pl1][1].getText()+"','"+labels[pl1][2].getText()+"','"+labels[pl1][3].getText()+"')");
           
//            ps.executeUpdate();
           
            
            System.out.println("saved");
            
            //jopt2.showMessageDialog(this,"Saved");
            
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(profit_loss_vertical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profit_loss_vertical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profit_loss_vertical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profit_loss_vertical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profit_loss_vertical().setVisible(true);
            }
        });
    }

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
