
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Trial_balance_demo3 extends javax.swing.JFrame implements ContainerListener{
private final GridBagConstraints gridBagConstraints;
    /**
     * Creates new form trial_balance_demo
     */
    public Trial_balance_demo3() {
        initComponents();
        Font myFont = new Font("Serif", Font.BOLD, 17);
        Font myFont2 = new Font("Serif", Font.BOLD, 13);
        Font myFont1 = new Font("Serif", Font.ITALIC, 14);
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.anchor=gridBagConstraints.PAGE_START;
        // gridBagConstraints.insets=new Insets(0,0,0,0);
            
            addContainerListener(this);
            String capital_acc_debit,capital_acc_credit,curr_lib_debit,curr_lib_credit,fix_asset,cur_asset,sundry_debtors,sundry_creditors,sales_account,purchase_account,dir_exp,dir_inc,indir_exp,cash,bank,indir_inc;
            Double cap_total=0.0d,cur_lib=0.0d,fixed_asset=0.0d,current_asset=0.0d,sundry_deb=0.0d,sundry_cre=0.0d,sales=0.0d,purchase=0.0d,direct_exp=0.0d,direct_inc=0.0d,indirect_exp=0.0d,cash_acc=0.0d,bank_acc=0.0d,indirect_inc=0.0d;
            int cap=0,lon=0,cur=0,fxd=0,ivt=0,crt=0,act=0,pur=0,dxp=0,din=0,iex=0,cas=0,bak=0,sun=0,sud=0,r=4,iid=0;
            
            int count = 1000;
            final JButton[][] labels=new JButton[count][4];
            
                
            int row=0;
            
            // Panel 1 start.....y=2
            
            
            JLabel tohead=new JLabel("Particulars");
            tohead.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            tohead.setHorizontalAlignment(SwingConstants.CENTER);
            tohead.setFont(myFont);
            jPanel1.add(tohead,gridBagConstraints);
            
            JLabel blankhead4=new JLabel(" ");
            blankhead4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            blankhead4.setFont(myFont);
            jPanel1.add(blankhead4,gridBagConstraints);
            
            JLabel refhead=new JLabel("Closing Balance");
            refhead.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=2;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            refhead.setHorizontalAlignment(SwingConstants.CENTER);
            //gridBagConstraints.anchor=gridBagConstraints.EAST;
            gridBagConstraints.weightx=0.4;
            refhead.setFont(myFont);
            jPanel1.add(refhead,gridBagConstraints);
            
            // y=3
            
            JLabel tohead1=new JLabel(" ");
            tohead1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            tohead1.setFont(myFont);
            jPanel1.add(tohead1,gridBagConstraints);
            
            JLabel blankhead5=new JLabel(" ");
            blankhead5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=16;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            blankhead5.setFont(myFont);
            jPanel1.add(blankhead5,gridBagConstraints);
            
            JLabel tohead5=new JLabel("Debit");
            tohead5.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            tohead5.setHorizontalAlignment(SwingConstants.CENTER);
            tohead5.setFont(myFont);
            jPanel1.add(tohead5,gridBagConstraints);
            
            JLabel blankhead6=new JLabel(" ");
            blankhead6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            blankhead6.setFont(myFont);
            jPanel1.add(blankhead6,gridBagConstraints);
            
            JLabel tohead6=new JLabel("Credit");
            tohead6.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=3;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            tohead6.setHorizontalAlignment(SwingConstants.CENTER);
            tohead6.setFont(myFont);
            jPanel1.add(tohead6,gridBagConstraints);
            
             
            //y=4...start...
             //Heading Capital Account
            
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Capital Account'");
          
            
          while(rs.next())
             {
                 capital_acc_credit=rs.getString("total_capital");
                 if(capital_acc_credit!=null){
                     cap_total=Double.parseDouble(capital_acc_credit);
                    
                     if(cap_total>0.0d){
                         //cap_total=0.0d - cap_total;
                          String cpaital=Double.toString(cap_total);
            
            
            
            labels[row][0] = new JButton("Capital Account");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
                        
    
           
            labels[row][1] = new JButton(" "); 
           
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
              
            
            labels[row][3] = new JButton(" "); 
           
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0.2;
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][3],gridBagConstraints);
           
            
          
            
            r++;
                     }
                 
                     else{
                         cap_total=0.0d - cap_total;
                         String cpaital=Double.toString(cap_total);
            
                         
            labels[row][0] = new JButton("Capital Account");               
                         
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add( labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
                        
    
           
            labels[row][1] = new JButton(" "); 
           
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(cpaital);
            labels[row][1].setFont(myFont);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0.2;
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setFont(myFont);
            
            
            r++; 
                         
                         
                         
                         
                         
                     }
                 
                 } }
          }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
            //Content Array (Capital A/C  Name,debit Value,Credit Value) displaying
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps1 =con.createStatement();
           ResultSet rs1=ps1.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Capital Account' group by company_main_table.ledger ");
           while(rs1.next())
           {
               String cap_ledger=rs1.getString("ledger");
                 String cap_ledger_value_debit=rs1.getString("debit");
                 String cap_ledger_value_credit=rs1.getString("credit");
               if(cap_ledger!=null)
               {
               
            labels[row][0] = new JButton();   
                
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+cap_ledger);
            labels[row][0].setFont(myFont1);
                
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setFont(myFont1);
            labels[row][1].setText(cap_ledger_value_debit);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
             
             
            labels[row][3] = new JButton(); 
             
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont1);
            labels[row][3].setText(cap_ledger_value_credit);
            
            row++;
            
             r++;
             cap++;
                   } 
             } 
          }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }
                 
              /*   
           
            //Heading Loan Liabilities
            
            JLabel tohead8=new JLabel("Loan Liabilities");
            tohead8.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(tohead8,gridBagConstraints);
            tohead8.setFont(myFont);
            tohead8.setHorizontalAlignment(SwingConstants.LEFT);
            
            JLabel tohead10=new JLabel("500000000 ");
            tohead10.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead10,gridBagConstraints);
            tohead10.setFont(myFont);
            tohead10.setHorizontalAlignment(SwingConstants.RIGHT);
            
            JLabel tohead11=new JLabel("8500000.00");
            tohead11.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead11,gridBagConstraints);
            tohead11.setFont(myFont);
            tohead11.setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
           
            //Content Array (Loans Libilities  Name,debit Value,Credit Value) displaying
            
             while(rs1.next())
             {
                   loanlabel[lon]=new JLabel();
                   loandblabel[lon]=new JLabel();
                   loancrlabel[lon]=new JLabel(); 
                   
            loanlabel[lon].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(loanlabel[lon],gridBagConstraints);
            loanlabel[lon].setHorizontalAlignment(SwingConstants.LEFT);
            loanlabel[lon].setText("Loan name");
            
            loandblabel[lon].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(loandblabel[lon],gridBagConstraints);
            loandblabel[lon].setHorizontalAlignment(SwingConstants.CENTER); 
            loandblabel[lon].setText("Loan Debit value");
            
            loancrlabel[lon].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(loancrlabel[lon],gridBagConstraints);
            loancrlabel[lon].setHorizontalAlignment(SwingConstants.RIGHT);
            loancrlabel[lon].setText("Loan Credit value");
            
            r++;
            lon++;
            
             }
            */
           
             // Heading Current Liabilities
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps2 =con.createStatement();
           ResultSet rs2=ps2.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Current Liabilities'");
          
            
            
            
          while(rs2.next())
             {
                 curr_lib_debit=rs2.getString("total_capital");
                 if(curr_lib_debit!=null){
                     cur_lib=Double.parseDouble(curr_lib_debit);
                    String curr_liabilities=Double.toString(cur_lib);
                     if(cur_lib>0.0d){
            
            labels[row][0] = new JButton("Current Liabilities"); 
            
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText(curr_liabilities);
            labels[row][0].setFont(myFont);
            
            
            labels[row][1] = new JButton(" ");
           
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(curr_liabilities);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            
            
            labels[row][3] = new JButton(" ");
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
                     }
            else{
            
            cur_lib=0 - cur_lib;
            String curr_liabilities1=Double.toString(cur_lib);
            
            labels[row][0] = new JButton("Current Liabilities");
           
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont); 
            
           
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(curr_liabilities1);
            labels[row][1].setFont(myFont);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            //tohead14.setText(curr_liabilities);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont);
            r++;
                     }
                } 
             }
          }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }      
            
              
              
        //Content Array (Current Libilities  Name,debit Value,Credit Value) displaying
               
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps3 =con.createStatement();
           ResultSet rs3=ps3.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Current Liabilities' group by company_main_table.ledger ");
          
              
            while(rs3.next())
            {
               String cur_lib_ledger=rs3.getString("ledger");
                 String cur_lib_ledger_value_debit=rs3.getString("debit");
                 String cup_lib_ledger_value_credit=rs3.getString("credit");
               if(cur_lib_ledger!=null)
               {
              
            labels[row][0] = new JButton();
              
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+cur_lib_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(cur_lib_ledger_value_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(cup_lib_ledger_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            cur++;
            }
              }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
            

        //Heading Fixed Asset
          
               try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps4 =con.createStatement();
           ResultSet rs4=ps4.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Fixed Asset'");
          
            
            
            
       while(rs4.next())
             {
                 fix_asset=rs4.getString("total_capital");
                 if(fix_asset!=null){
                     fixed_asset=Double.parseDouble(fix_asset);
                    String f_asset=Double.toString(fixed_asset);
                     if(fixed_asset>0.0d){
            
            labels[row][0] = new JButton("Fixed Asset");             
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            
            labels[row][1] = new JButton(" ");   
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(f_asset);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            
            labels[row][3] = new JButton(" ");
           
            labels[row][3] .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3] ,gridBagConstraints);
            labels[row][3] .setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont);
            r++;
            }
            
            else{
                   fixed_asset=0.0d - fixed_asset;  
                       String f_asset1=Double.toString(fixed_asset);
            
            labels[row][0] = new JButton("Fixed Asset");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
         
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
        //    tohead17.setFont(myFont);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(f_asset1);
            labels[row][3].setFont(myFont);
                  
            r++;
               
                     }
               }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
             //Content Array (Fixed Asset  Name,debit Value,Credit Value) displaying
               
                try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps5 =con.createStatement();
           ResultSet rs5=ps5.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Fixed Asset' group by company_main_table.ledger ");
          
              
            while(rs5.next())
            {
               String fix_asset_ledger=rs5.getString("ledger");
                 String fix_asset_ledger_value_debit=rs5.getString("debit");
                 String fix_asset_ledger_value_credit=rs5.getString("credit");
               if(fix_asset_ledger!=null)
               {
            
            labels[row][0] = new JButton();
                   
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+fix_asset_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(fix_asset_ledger_value_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(fix_asset_ledger_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            fxd++;
            
            }
               
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
            
          /*  // Heading Invest Asset
            
            JLabel tohead20=new JLabel("Investment");
            tohead20.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(tohead20,gridBagConstraints);
            tohead20.setHorizontalAlignment(SwingConstants.LEFT);
            
            JLabel tohead21=new JLabel();
            tohead21.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead21,gridBagConstraints);
            tohead21.setHorizontalAlignment(SwingConstants.CENTER);
            tohead21.setFont(myFont);
            
            JLabel tohead22=new JLabel();
            tohead22.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead22,gridBagConstraints);
            tohead22.setHorizontalAlignment(SwingConstants.RIGHT);
            tohead22.setFont(myFont);
            
            r++;
          
            //Content Array (Invest Asset  Name,debit Value,Credit Value) displaying
            
              while(rs1.next())
              {
               ivtasetlabel[ivt]=new JLabel();
               ivtasetdblabel[ivt]=new JLabel();
               ivtasetcrlabel[ivt]=new JLabel();
               
            ivtasetlabel[ivt].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(ivtasetlabel[ivt],gridBagConstraints);
            ivtasetlabel[ivt].setHorizontalAlignment(SwingConstants.LEFT);
            ivtasetlabel[ivt].setText("Invest Asset name");
            
            ivtasetdblabel[ivt].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(ivtasetdblabel[ivt],gridBagConstraints);
            ivtasetdblabel[ivt].setHorizontalAlignment(SwingConstants.CENTER); 
            ivtasetdblabel[ivt].setText("Invest Asset Debit value");
            
            ivtasetcrlabel[ivt].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(ivtasetcrlabel[ivt],gridBagConstraints);
            ivtasetcrlabel[ivt].setHorizontalAlignment(SwingConstants.RIGHT);
            ivtasetcrlabel[ivt].setText("Invest Asset Credit value");
            r++;
            ivt++;
              }
                   */        

            // Heading Current Asset
            
           try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps6 =con.createStatement();
           ResultSet rs6=ps6.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Current Asset'");
          
            
            
            
       while(rs6.next())
             {
                 cur_asset=rs6.getString("total_capital");
                 if(cur_asset!=null){
                     current_asset=Double.parseDouble(cur_asset);
                    String c_asset=Double.toString(current_asset);
                     if(current_asset>0.0d){
                         
            labels[row][0] = new JButton("Current Asset");  
           
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
           
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(c_asset);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont);
            r++;
             }
            else{
            current_asset=0 - current_asset;    
            String c_asset1=Double.toString(current_asset);
            
            labels[row][0] = new JButton("Current Asset");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" "); 
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);          
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" "); 
          
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(c_asset1);
            labels[row][3].setFont(myFont);
            
            r++;
             }
                     
                 }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
            
            //Content Array (Current Asset  Name,debit Value,Credit Value) displaying
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps7 =con.createStatement();
           ResultSet rs7=ps7.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Current Asset' group by company_main_table.ledger ");
          
              
            while(rs7.next())
            {
                 String curr_asset_ledger=rs7.getString("ledger");
                 String curr_asset_ledger_value_debit=rs7.getString("debit");
                 String curr_asset_ledger_value_credit=rs7.getString("credit");
               if(curr_asset_ledger!=null)
               {
            
            labels[row][0] = new JButton();
                
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+curr_asset_ledger);
            labels[row][0].setFont(myFont1);
            
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(curr_asset_ledger_value_debit);
            labels[row][1].setFont(myFont1);
            
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(curr_asset_ledger_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            crt++;
            
            }
            
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
            
                  // Heading Sundry Debtors
               try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps6 =con.createStatement();
           ResultSet rs6=ps6.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sundry Debtors'");
          
            
            
            
       while(rs6.next())
             {
                 sundry_debtors=rs6.getString("total_capital");
                 if(sundry_debtors!=null){
                     sundry_deb=Double.parseDouble(sundry_debtors);
                    String s_deb=Double.toString(sundry_deb);
                     if(sundry_deb>0.0d)
                     {
                         
            labels[row][0] = new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("    "+"Sundry Debtors");
            labels[row][0].setFont(myFont2);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setFont(myFont2);
            labels[row][1].setText(s_deb);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont2);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setFont(myFont2);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;  
             }
              else{
                         sundry_deb=0 - sundry_deb;
                            String s_deb1=Double.toString(sundry_deb);
            
            labels[row][0] = new JButton();
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setText("    "+"Sundry Debtors");
            labels[row][0].setFont(myFont2);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setFont(myFont2);
            labels[row][1].setText(" ");
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont2);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setFont(myFont2);
            labels[row][3].setText(s_deb1);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;  
             }       
                 }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
            //Content Array (Sundry Debtors Name,debit Value,Credit Value) displaying
            
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps8 =con.createStatement();
           ResultSet rs8=ps8.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sundry Debtors' group by company_main_table.ledger ");
          
              
            while(rs8.next())
            {
               String sundry_ledger=rs8.getString("ledger");
                 String sundry_debtors_value_debit=rs8.getString("debit");
                 String sundry_debtors_value_credit=rs8.getString("credit");
               if(sundry_ledger!=null)
               {
                
            labels[row][0] = new JButton();      
                 
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("      "+sundry_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(sundry_debtors_value_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(sundry_debtors_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
              
            r++;
            sud++;
               }
            }
            }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
             
            // Heading Sundry Creditors
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps6 =con.createStatement();
           ResultSet rs6=ps6.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sundry Creditors'");
          
         
       while(rs6.next())
             {
                 sundry_creditors=rs6.getString("total_capital");
                 if(sundry_creditors!=null){
                     sundry_cre=Double.parseDouble(sundry_creditors);
                    String s_cre=Double.toString(sundry_cre);
                     if(sundry_cre>0.0d){
            
            labels[row][0] = new JButton("    "+"Sundry Creditor");             
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont2);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1].setFont(myFont2);
            jPanel1.add(labels[row][1],gridBagConstraints);         
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont2);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(s_cre);
            labels[row][3].setFont(myFont2);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++; 
            }
            else
            {
            sundry_cre = 0 -  sundry_cre; 
            String s_cre1=Double.toString(sundry_cre);
            
            labels[row][0] = new JButton("    "+"Sundry Creditor");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont2);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1].setText(s_cre1);
            labels[row][1].setFont(myFont2);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont2);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
          //
            
            labels[row][3].setText(" ");
            labels[row][3].setFont(myFont2);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;          
                      
                     }      
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
            
            //Content Array (Sundry Creditor Name,debit Value,Credit Value) displaying
            
              
              
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps8 =con.createStatement();
           ResultSet rs8=ps8.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sundry Creditors' group by company_main_table.ledger ");
           
              
            while(rs8.next())
            {
               String sundry_cre_ledger=rs8.getString("ledger");
                 String sundry_creditors_value_debit=rs8.getString("debit");
                 String sundry_creditors_value_credit=rs8.getString("credit");
               if(sundry_cre_ledger!=null)
               {
                      
            labels[row][0] = new JButton();
                   
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("      "+sundry_cre_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(sundry_creditors_value_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(sundry_creditors_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            sun++;
             
                }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
              
             // Heading Sales Accout
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sales'");
          
         while(rs60.next())
            {
            
            sales_account=rs60.getString("total_capital");
            
            if( sales_account!=null)
            {
                sales=Double.parseDouble(sales_account);
                String s_aacc=Double.toString(sales);
                if(sales>0.0d)
                     {
                         
            labels[row][0] = new JButton("Sales Account");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1] .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1] .setFont(myFont);
            jPanel1.add(labels[row][1] ,gridBagConstraints);
            labels[row][1] .setHorizontalAlignment(SwingConstants.CENTER);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton("");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(s_aacc);
            labels[row][3].setFont(myFont);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
            
             }
                     else{
                         sales=0 - sales ;
                            String s_aacc1=Double.toString(sales);
                           
            labels[row][0] = new JButton("Sales Account");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1].setText(" ");
            labels[row][1].setFont(myFont);
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(s_aacc1);
            labels[row][3].setFont(myFont);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
                     }
                 }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }    
          
            //Content Array (Sales Account  Name,debit Value,Credit Value) displaying
            
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps80 =con.createStatement();
           ResultSet rs80=ps80.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Sales' group by company_main_table.ledger ");
          
              
            while(rs80.next())
            {
               String sales_ledger=rs80.getString("ledger");
                 String sale_value_debit=rs80.getString("debit");
                 String sale_value_credit=rs80.getString("credit");
               if(sales_ledger!=null)
               {
            
            labels[row][0] = new JButton();
                   
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+sales_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(sale_value_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
                      
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(sale_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            act++;
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
               
           
            // Heading Purchase Accout
            
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Purchase'");
          
         while(rs60.next())
             {
                 purchase_account=rs60.getString("total_capital");
                 if( purchase_account!=null){
                     purchase=Double.parseDouble(purchase_account);
                    String p_acc=Double.toString(purchase);
                     if(purchase>0.0d){
            
            
            labels[row][0] = new JButton("Purchase Account");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1] .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1] .setFont(myFont);
            jPanel1.add(labels[row][1] ,gridBagConstraints);
            labels[row][1] .setHorizontalAlignment(SwingConstants.CENTER);
            
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
             }
            else{
            
            purchase=0 - purchase;
            String p_acc1=Double.toString(purchase);
            
            labels[row][0] = new JButton("Purchase Account");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1] .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1] .setFont(myFont);
            jPanel1.add(labels[row][1] ,gridBagConstraints);
            labels[row][1] .setHorizontalAlignment(SwingConstants.CENTER);
            
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(p_acc1);
            labels[row][3].setFont(myFont);
            
            r++;
             }
                         
                 }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
            

//Content Array (Purchase Account  Name,debit Value,Credit Value) displaying
            
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps80 =con.createStatement();
           ResultSet rs80=ps80.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Purchase' group by company_main_table.ledger ");
          
              
            while(rs80.next())
            {
               String purchase_ledger=rs80.getString("ledger");
                 String purchase_value_debit=rs80.getString("debit");
                 String purchase_value_credit=rs80.getString("credit");
              
                 if(purchase_ledger!=null)
               {
            
            labels[row][0] = new JButton();
                  
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText( "  "+purchase_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(purchase_value_debit);
            labels[row][1].setFont(myFont1);
         
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(purchase_value_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            pur++;
             
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
            // Heading Direct Expense
               try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Direct Expense'");
          
         while(rs60.next())
             {
                 dir_exp=rs60.getString("total_capital");
                 if(dir_exp!=null){
                     direct_exp=Double.parseDouble(dir_exp);
                    String d_exp=Double.toString(direct_exp);
                     if(direct_exp>0.0d){
                         
            
            labels[row][0] = new JButton("Direct Expense");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(d_exp);
            labels[row][1].setFont(myFont);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setFont(myFont);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++; 
             }
                     else
                         {
                          direct_exp=0 - direct_exp;   
                            String d_exp1=Double.toString(direct_exp);
                            
            labels[row][0] = new JButton("Direct Expense");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setFont(myFont);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            
            labels[row][1] = new JButton("");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
           // tohead36.setText(d_exp);
            labels[row][1].setFont(myFont);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setText(d_exp1);
            labels[row][3].setFont(myFont);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++; 
             }
              }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
            //Content Array (Direct Expense  Name,debit Value,Credit Value) displaying
           
               
            try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps800 =con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Direct Expense' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
               String dir_exp_ledger=rs800.getString("ledger");
                 String dir_exp_debit=rs800.getString("debit");
                 String dir_exp_credit=rs800.getString("credit");
             
           if(dir_exp_ledger!=null)
           {
            
            labels[row][0] = new JButton();   
               
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont1);
            labels[row][0].setText("  "+dir_exp_ledger);
            
            
            labels[row][1] = new JButton();
                    
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setFont(myFont1);
            labels[row][1].setText(dir_exp_debit);
           
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][3].setFont(myFont1);
            labels[row][3].setText(dir_exp_credit);
          
            row++;
            
            r++;
            dxp++;
            }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
              
             // Heading Direct Income
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Direct Income'");
          
         while(rs60.next())
             {
                 dir_inc=rs60.getString("total_capital");
                 if(dir_inc!=null){
                     direct_inc=Double.parseDouble(dir_inc);
                    String d_inc=Double.toString(direct_inc);
                     if(direct_inc>0.0d)
                     {
                         
            
            labels[row][0] = new JButton("Direct Income");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1] .setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            labels[row][1] .setFont(myFont);
            jPanel1.add(labels[row][1] ,gridBagConstraints);
            labels[row][1] .setHorizontalAlignment(SwingConstants.CENTER);
            
            labels[row][2] = new JButton(" "); 
           
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(labels[row][2],gridBagConstraints);
            labels[row][2].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][2].setFont(myFont);
          
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(d_inc);
            labels[row][3].setFont(myFont);
            
            r++;  
             }
            }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
            //Content Array (Direct Income  Name,debit Value,Credit Value) displaying
              
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps800 =con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Direct Income' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
               String dir_inc_ledger=rs800.getString("ledger");
                 String dir_inc_debit=rs800.getString("debit");
                 String dir_inc_credit=rs800.getString("credit");
             if(dir_inc_ledger!=null)
             {
                               
            
            labels[row][0] = new JButton();
                 
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont1);
            labels[row][0].setText("  "+dir_inc_ledger);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setFont(myFont1);
            labels[row][1].setText(dir_inc_debit);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont1);
            labels[row][3].setText(dir_inc_credit);
            
            row++;
            
            r++;
            din++;
            }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
              // Heading Indirect Expense
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Indirect Expense'");
          
         while(rs60.next())
             {
                 indir_exp=rs60.getString("total_capital");
                 if(indir_exp!=null){
                     indirect_exp=Double.parseDouble(indir_exp);
                    String ind_exp=Double.toString(indirect_exp);
                     if(indirect_exp>0.0d){
            
            
            labels[row][0] = new JButton("Indirect Expense");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(ind_exp);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setFont(myFont);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;
                     }
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }  
             
                //Content Array (Indirect Expense  Name,debit Value,Credit Value) displaying
            
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps800 =con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Indirect Expense' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
                 String indir_exp_ledger=rs800.getString("ledger");
                 String indir_exp_debit=rs800.getString("debit");
                 String indir_exp_credit=rs800.getString("credit");
             
               if(indir_exp_ledger!=null)
               {
                 
            labels[row][0] = new JButton();
                 
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+ indir_exp_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(indir_exp_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(indir_exp_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            iex++;
               }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
          
              
              
               // Heading Indirect Income 
               try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(credit) - SUM(debit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Indirect Income'");
          
         while(rs60.next())
             {
                 indir_inc=rs60.getString("total_capital");
                 if(indir_inc!=null){
                     indirect_inc=Double.parseDouble(indir_inc);
                    String ind_inc=Double.toString(indirect_inc);
                     if(indirect_inc>0.0d){
            
           
            labels[row][0] = new JButton("Indirect Income");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(ind_inc);
            labels[row][3].setFont(myFont);
            
            r++;  
            
            }
                     
            else
            {
            
            labels[row][0] = new JButton("Indirect Income");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=15;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setText(ind_inc);
            labels[row][1].setFont(myFont);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont);
            
            r++;  
                     }
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
          
             
             
              //Content Array (Indirect Income  Name,debit Value,Credit Value) displaying
           
                 try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps800 =con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Indirect Income' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
               String indir_inc_ledger=rs800.getString("ledger");
                 String indir_inc_debit=rs800.getString("debit");
                 String indir_inc_credit=rs800.getString("credit");
             if(indir_inc_ledger!=null)
             {
                           
            labels[row][0] = new JButton();    
                 
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+indir_inc_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(indir_inc_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(indir_inc_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            iid++;
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
         
              // Heading Cash
                
           try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Cash'");
          
         while(rs60.next())
             {
                cash=rs60.getString("total_capital");
                 if(cash!=null){
                     cash_acc=Double.parseDouble(cash);
                    String cash_account=Double.toString(cash_acc);
                     if(cash_acc>0.0d)
                     {
            
            
            labels[row][0] = new JButton("Cash");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            labels[row][1].setText(cash_account);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            
            r++;  
            }
            
            else
            {
                         cash_acc=0 - cash_acc;
                         String cash_account1=Double.toString(cash_acc);
            
            labels[row][0] = new JButton("Cash");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setFont(myFont);
            labels[row][3].setText(cash_account1);
            
            r++;  
                     }
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
           
            //Content Array (Cash  Name,debit Value,Credit Value) displaying
            
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps800 =con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Cash' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
                 String cash_ledger=rs800.getString("ledger");
                 String cash_debit=rs800.getString("debit");
                 String cash_credit=rs800.getString("credit");
             
             if(cash_ledger!=null)
             {
         
            labels[row][0] = new JButton();
                    
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  " + cash_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(cash_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(cash_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            cas++;
               }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
              // Heading Bank
              try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps60 =con.createStatement();
           ResultSet rs60=ps60.executeQuery("SELECT SUM(debit) - SUM(credit) AS total_capital FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Bank'");
          
         while(rs60.next())
             {
                bank=rs60.getString("total_capital");
                 if(bank!=null){
                     bank_acc=Double.parseDouble(bank);
                    String bank_account=Double.toString(bank_acc);
                     if(bank_acc>0.0d){
            
            
            labels[row][0] = new JButton("Bank");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
            labels[row][1].setText(bank_account);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText("");
            
            r++;  
                     }
            
            else
            {
                bank_acc=0 - bank_acc;
                String bank_account1=Double.toString(bank_acc);
            
            labels[row][0] = new JButton("Bank");
            
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setFont(myFont);
            
            labels[row][1] = new JButton(" ");
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.CENTER);
         //   tohead48.setText(bank_account);
            labels[row][1].setFont(myFont);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton(" ");
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(bank_account1);
            labels[row][3].setFont(myFont);
            
            r++;   
                     }
                      }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
            //Content Array (Bank Name,debit Value,Credit Value) displaying
            
             try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
           Statement ps800 = con.createStatement();
           ResultSet rs800=ps800.executeQuery("SELECT ledger,sum(credit) as credit,sum(debit) as debit FROM company_main_table,ledger WHERE ledger.l_name= company_main_table.ledger AND ledger.l_under='Bank' group by company_main_table.ledger ");
          
              
            while(rs800.next())
            {
               String bank_ledger=rs800.getString("ledger");
               String bank_debit=rs800.getString("debit");
               String bank_credit=rs800.getString("credit");
             
             if(bank_ledger!=null)
             {
                 
            labels[row][0] = new JButton();
                 
            labels[row][0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(labels[row][0],gridBagConstraints);
            labels[row][0].setHorizontalAlignment(SwingConstants.LEFT);
            labels[row][0].setText("  "+ bank_ledger);
            labels[row][0].setFont(myFont1);
            
            labels[row][1] = new JButton();
            
            labels[row][1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][1],gridBagConstraints);
            labels[row][1].setHorizontalAlignment(SwingConstants.RIGHT); 
            labels[row][1].setText(bank_debit);
            labels[row][1].setFont(myFont1);
            
            labels[row][2] = new JButton(" ");
             
            labels[row][2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.green));
            gridBagConstraints.weightx=0;
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL; 
            labels[row][2].setFont(myFont1);
            jPanel1.add(labels[row][2],gridBagConstraints);
            
            labels[row][3] = new JButton();
            
            labels[row][3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(labels[row][3],gridBagConstraints);
            labels[row][3].setHorizontalAlignment(SwingConstants.RIGHT);
            labels[row][3].setText(bank_credit);
            labels[row][3].setFont(myFont1);
            
            row++;
            
            r++;
            bak++;
             }
               }
               }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        }     
             
               
             
            JLabel tohead65=new JLabel("Total");
            tohead65.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.gridx=0;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=17;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.6;
            jPanel1.add(tohead65,gridBagConstraints);
            tohead65.setHorizontalAlignment(SwingConstants.LEFT);
            tohead65.setFont(myFont);
            
            JLabel tohead66=new JLabel("500000000 ");
            tohead66.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.gridx=18;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead66,gridBagConstraints);
            tohead66.setHorizontalAlignment(SwingConstants.RIGHT);
            tohead66.setFont(myFont);
            
            JLabel tohead70=new JLabel(" ");
            tohead70.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.gridx=25;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=1;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0;
            jPanel1.add(tohead70,gridBagConstraints);
            tohead70.setHorizontalAlignment(SwingConstants.RIGHT);
            tohead70.setFont(myFont);
            
            
            JLabel tohead67=new JLabel("8500000.00");
            tohead67.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
            gridBagConstraints.gridx=27;
            gridBagConstraints.gridy=r;
            gridBagConstraints.gridwidth=6;
            gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx=0.2;
            jPanel1.add(tohead67,gridBagConstraints);
            tohead67.setHorizontalAlignment(SwingConstants.RIGHT);
            tohead67.setFont(myFont);
            
            r++;    
             
          // Convering Buttons to Labels
            
            for (int i = 0; i < row; i++) 
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
           
           // Initial Focus on First Row
            
           labels[0][0].requestFocus();
           labels[0][0].setContentAreaFilled(true);
           labels[0][1].setContentAreaFilled(true);
           labels[0][2].setContentAreaFilled(true);
           labels[0][3].setContentAreaFilled(true);
           
           labels[0][0].setBackground(Color.orange);
           labels[0][1].setBackground(Color.orange);
           labels[0][2].setBackground(Color.orange);
           labels[0][3].setBackground(Color.orange);
            
        //Embedding Key Movement traversal
        // i loop for rows
        // j loop for columns
          
        for (int i = 0; i < row; i++) 
        {
          for (int j = 0; j < labels[i].length; j++) {
            final int rowfin = row;
            final int curRow = i;
            final int curCol = j;
            //labels[i][j].setBorderPainted(true);
            labels[i][j].addKeyListener(enter);
            labels[i][j].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (curRow > 0)
                     {
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol+1].setContentAreaFilled(false);
                        labels[curRow][curCol+2].setContentAreaFilled(false);
                        labels[curRow][curCol+3].setContentAreaFilled(false);
                         
                        labels[curRow - 1][curCol].requestFocus();
                        labels[curRow - 1][curCol].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+1].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+2].setContentAreaFilled(true);
                        labels[curRow - 1][curCol+3].setContentAreaFilled(true);
                        
                        labels[curRow - 1][curCol].setBackground(Color.orange);
                        labels[curRow - 1][curCol+1].setBackground(Color.orange);
                        labels[curRow - 1][curCol+2].setBackground(Color.orange);
                        labels[curRow - 1][curCol+3].setBackground(Color.orange);
                     }
                     break;
                  case KeyEvent.VK_DOWN:
                     if (curRow < rowfin - 1)
                     {
                        labels[curRow][curCol].setContentAreaFilled(false);
                        labels[curRow][curCol+1].setContentAreaFilled(false);
                        labels[curRow][curCol+2].setContentAreaFilled(false);
                        labels[curRow][curCol+3].setContentAreaFilled(false);    
                                                                    
                        labels[curRow + 1][curCol].requestFocus();
                        labels[curRow + 1][curCol].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+1].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+2].setContentAreaFilled(true);
                        labels[curRow + 1][curCol+3].setContentAreaFilled(true);
                        
                        labels[curRow + 1][curCol].setBackground(Color.orange);
                        labels[curRow + 1][curCol+1].setBackground(Color.orange);
                        labels[curRow + 1][curCol+2].setBackground(Color.orange);
                        labels[curRow + 1][curCol+3].setBackground(Color.orange);
                     }
                       break;
                  
                  case KeyEvent.VK_LEFT:
                     
                     break;
                  
                  case KeyEvent.VK_RIGHT:
                     
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
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
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trial_balance_demo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trial_balance_demo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trial_balance_demo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trial_balance_demo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trial_balance_demo3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
