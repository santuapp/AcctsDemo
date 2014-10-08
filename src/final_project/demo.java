package final_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SOUMYA BASAK
 */
public class demo extends javax.swing.JFrame {
//demo d6=new demo();
    
    
      

    /**
     * Creates new form demo
     */
    JDialog login_panel1=new JDialog();
int i = 0;
public JPanel[] panelArray = new JPanel[100];
JButton[] buttons;
//JButton[] buttons = new JButton[10];

 java.util.Date date=new java.util.Date();
         java.text.SimpleDateFormat dateFormat=new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         
 ActionListener updateClockAction = new ActionListener() {
  public void actionPerformed(ActionEvent e) { 
     jLabel4.setText(new Date().toString());
      
      }
};
       

    public demo() {
     
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      this.setSize(screenSize.width, screenSize.height);
        initComponents();
          esc_close();
         initialize();
     // jLabel4.setText(""+dateFormat.format(date));
         opening_stock_button.setVisible(false);
      
        Timer t = new Timer(1000, updateClockAction);
        t.start();
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jButton5.setVisible(false);
       // esc_close1();
    //   JDialog login=new JDialog();
       
   //jButton5.setFocusable(false);
   //jButton5.setFocusPainted(false);
   demo1.setFocusable(false);
        demo2.setFocusable(false);
          accounting_master_short.setFocusable(false);
              inventory_master_short.setFocusable(false);
                 transaction_short.setFocusable(false);
                   reports_short.setFocusable(false);
        
        jPanel3.setEnabled(true);
        menu.setEnabled(true);
        ledger_create_short.setEnabled(true);
        ledger_group_short.setEnabled(true);
        customer_create_short.setEnabled(true);
        vendor_create_short.setEnabled(true);
        product_group_create_short.setEnabled(true);
        unit_create_short.setEnabled(true);
        product_create_short.setEnabled(true);
        godown_create_short.setEnabled(true);
        purchase_create_short.setEnabled(true);
        sale_create_short.setEnabled(true);
        payment_create_short.setEnabled(true);
        receipt_create_short.setEnabled(true);
        journal_create_short.setEnabled(true);
        
        
        //demo1.setEnabled(false);
       // demo2.setEnabled(false);
       // menu.setVisible(false);
        
        
        //Internal Menu
        
        
       
        menu.setVisible(true);
        account_master.setVisible(false);
        inventory_master.setVisible(false);
        transaction.setVisible(false);
        report.setVisible(false);
        ledger_create.setVisible(false);
        group_create.setVisible(false);
        customer_vendor.setVisible(false);
        customer_create.setVisible(false);
        vendor_create.setVisible(false);
        product_group.setVisible(false);
        unit_create.setVisible(false);
        product_create.setVisible(false);
        godown_create.setVisible(false);
        purchase_create.setVisible(false);
        sale_create_menu.setVisible(false);
        payment_create.setVisible(false);
        receipt_create.setVisible(false);
        journal_create.setVisible(false);
        stock_transfer.setVisible(false);
        fund_transfer.setVisible(false);
        opening_stock.setVisible(false);
        reminder_create.setVisible(false);
        profit_loss_menu.setVisible(false);
        //Internal Menu
        
        
        //Shortcut Panel
        
       ledger_short_panel.setVisible(false);
       group_short_panel.setVisible(false);
       customer_short_panel.setVisible(false);
       vendor_short_panel.setVisible(false);
       product_group_short_panel.setVisible(false);
       unit_short_panel.setVisible(false);
       product_short_panel.setVisible(false);
       godown_short_panel.setVisible(false);
       purchase_short_panel.setVisible(false);
       sale_short_panel.setVisible(false);
       payment_short_panel.setVisible(false);
       receipt_short_panel.setVisible(false);
       journal_short_panel.setVisible(false);
       stock_transfer_panel.setVisible(false);
       fund_transfer_panel.setVisible(false);
       opening_stock_panel.setVisible(false);
       reminder_short_panel.setVisible(false);
       //Shortcut Panel
       
       
        jPanel4.setVisible(true);
        
        //initialize();
        //jPanel4.setVisible(true);
        
        
              
             
             tutorial_panel tp=new tutorial_panel();   
             panelArray[i]=tp;
             //panelArray[i].setBounds(0, 0, 0,0);
            
             panelArray[i].setVisible(true);
             
             //jPanel4.removeAll();
             jPanel4.setLayout(new BorderLayout());
             jPanel4.add(panelArray[i]);
           
             System.out.println("Tutorial Panel added: "+i);
             
        jPanel4.validate();
        jPanel4.setVisible(true);
        
       
    
       
          final JButton menu_buttons[]={menu_account_master, menu_inventory_master,menu_transaction,menu_report,menu_logout};
    {
       // esc_close1();
         for (int p=0;p<5;p++)
            {
                
               final int p1=p;
               String st=menu_buttons[p1].getText();
              
                
               menu_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                     switch (e.getKeyCode()) {
                     case KeyEvent.VK_UP:
                     if (p1 > 0){
                     menu_buttons[p1-1].requestFocus();
                     menu_buttons[p1-1].setContentAreaFilled(true);
                     menu_buttons[p1-1].setBorderPainted(true);
                     menu_buttons[p1].setContentAreaFilled(false);
                     menu_buttons[p1].setBorderPainted(false);
                     menu_buttons[p1-1].setBackground(Color.GRAY);
                      
                     }
                      if (p1 == 0){
                     menu_buttons[4].requestFocus();
                     menu_buttons[4].setContentAreaFilled(true);
                     menu_buttons[4].setBorderPainted(true);
                     menu_buttons[0].setContentAreaFilled(false);
                     menu_buttons[0].setBorderPainted(false);
                     menu_buttons[4].setBackground(Color.GRAY);
                      
                     }
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                     case KeyEvent.VK_DOWN:
                     if (p1 <5){
                     menu_buttons[p1+1].requestFocus();
                     menu_buttons[p1+1].setContentAreaFilled(true);
                     menu_buttons[p1+1].setBorderPainted(true);
                     menu_buttons[p1].setContentAreaFilled(false);
                     menu_buttons[p1].setBorderPainted(false);
                     menu_buttons[p1+1].setBackground(Color.GRAY);
                     } // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     
                    if (p1 == 4){
                     menu_buttons[0].requestFocus();
                     menu_buttons[0].setContentAreaFilled(true);
                     menu_buttons[0].setBorderPainted(true);
                     menu_buttons[4].setContentAreaFilled(false);
                     menu_buttons[4].setBorderPainted(false);
                     menu_buttons[0].setBackground(Color.GRAY);
                      
                     }
                     break;
                          case KeyEvent.VK_ENTER:
                     if (p1==0){
                      esc_close1();
                      menu.setVisible(false);
                      account_master.setVisible(true);
                      try
     {
         account_master.setSelected(true);
ledger_button.setFocusable(true);
    
     }
     catch(Exception we)
     {
     }
    
                     }
                     if (p1==1){
                    esc_close1();
                       inventory_master.setVisible(true);
                       menu.setVisible(false);
                        try
     {
         inventory_master.setSelected(true);
inventory_master_product_group.setFocusable(true);
    
     }
     catch(Exception we)
     {
     }
    
                     }
                         if (p1==2){
                    esc_close1();
                       menu.setVisible(false);
                       transaction.setVisible(true);
                        try
     {
         transaction.setSelected(true);
purchase_button.setFocusable(true);
    
     }
     catch(Exception we)
     {
     }
    
                     }
                         
                         if (p1==3){
                    esc_close1();
                        report.setVisible(true);
                        menu.setVisible(false);
                        try{
                            report.setSelected(true);
                            report_cash_status_button.setFocusable(true);
                            
                        }catch(Exception we){
                            
                        }
    
                     }
                            if (p1==4){
                        
                        login_form lf=new login_form();
                        lf.setVisible(true);
       
                        dispose();
   
    
                     }




// button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     
//                    if (p1 == 4){
//                     button_array[0].requestFocus();
//                     button_array[0].setContentAreaFilled(true);
//                     button_array[0].setBorderPainted(true);
//                     button_array[4].setContentAreaFilled(false);
//                     button_array[4].setBorderPainted(false);
//                     button_array[0].setBackground(Color.GRAY);
//                      
//                     }
                     break;
                      
                  default:
                     break;
                  }
               }
            });
                
               
            
       
            }

       
    }
    
   
    
    
    
    
    
     final JButton account_master_buttons[]={ledger_button, account_master_group,account_master_party,account_master_back};
     esc_close1();
         for (int p=0;p<4;p++)
            {
                
                final int p1=p;
                String st=account_master_buttons[p1].getText();
              
                
               account_master_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                     account_master_buttons[p1-1].requestFocus();
                     account_master_buttons[p1-1].setContentAreaFilled(true);
                     account_master_buttons[p1-1].setBorderPainted(true);
                     account_master_buttons[p1].setContentAreaFilled(false);
                     account_master_buttons[p1].setBorderPainted(false);
                     account_master_buttons[p1-1].setBackground(Color.GRAY);
                     
                    
                     
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                     case KeyEvent.VK_DOWN:
                     if (p1 < 4)
                     account_master_buttons[p1+1].requestFocus();
                     account_master_buttons[p1+1].setContentAreaFilled(true);
                     account_master_buttons[p1+1].setBorderPainted(true);
                     account_master_buttons[p1].setContentAreaFilled(false);
                     account_master_buttons[p1].setBorderPainted(false);
                     account_master_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                         
                           case KeyEvent.VK_ENTER:
                     if (p1==0){
                         
                    esc_close1();
                     ledger_shortcut();
        group_short_panel.setVisible(false);
        ledger_short_panel.setVisible(true);
        ledger_create.setVisible(true);
        account_master.setVisible(false);
        
         try
     {
         ledger_create.setSelected(true);
create_ledger.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                     if (p1==1){
                    esc_close1();
                       group_shortcut();
        group_short_panel.setVisible(true);
        group_create.setVisible(true);
        account_master.setVisible(false);
        
           try
     {
         group_create.setSelected(true);
create_group.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                         if (p1==2){
                    esc_close1();
                       customer_vendor.setVisible(true);
        account_master.setVisible(false);
        
        try{
        customer_vendor.setSelected(true);
customer.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                         
                         if (p1==3){
                             esc_close1();
                      menu.setVisible(true);
        account_master.setVisible(false);
         try{
        menu.setSelected(true);
menu_account_master.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                          
                  default:
                     break;
                  }
               }
            });
                
               
            }
    
    final JButton report_buttons[]={report_cash_status_button, report_bank_status_button,report_vendor_status_button,report_customer_status_button,report_balance_sheet_button,report_trial_balance_button,report_profit_loss_button,report_stock_summary_button,report_tax_detail_button,report_back_button};
        esc_close1();
         for (int p=0;p<10;p++)
            {
                
                final int p1=p;
                String st=report_buttons[p1].getText();
              
                
               report_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        report_buttons[p1-1].requestFocus();
                     report_buttons[p1-1].setContentAreaFilled(true);
                     report_buttons[p1-1].setBorderPainted(true);
                     report_buttons[p1].setContentAreaFilled(false);
                     report_buttons[p1].setBorderPainted(false);
                      report_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 10)
                        report_buttons[p1+1].requestFocus();
                     report_buttons[p1+1].setContentAreaFilled(true);
                     report_buttons[p1+1].setBorderPainted(true);
                      report_buttons[p1].setContentAreaFilled(false);
                     report_buttons[p1].setBorderPainted(false);
                      report_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_ENTER:
                       if(p1==5)
                      {
                          System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        
           trial_balance_panel tbp1=new trial_balance_panel();
           
             panelArray[i]=tbp1;
             
//            jPanel4.add(plvp);
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//       
      
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
//           jPanel4.setLayout(new BorderLayout());
              jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.validate();
        jPanel4.setVisible(true);
          tbp1.labels[0][0].requestFocus(); 
                      }
                      if(p1==9)
                      {
                           menu.setVisible(true);
     report.setVisible(false);
     try{
         menu.setSelected(true);
         menu_account_master.setFocusable(true);
     }catch(Exception we)
     {
         
     }
                      }
                  default:
                     break;
                  }
               }
            });
                
               
            }
    
     final JButton ledger_buttons[]={create_ledger, edit_ledger,back_ledger};
        esc_close1();
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=ledger_buttons[p1].getText();
              
                
               ledger_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        ledger_buttons[p1-1].requestFocus();
                     ledger_buttons[p1-1].setContentAreaFilled(true);
                     ledger_buttons[p1-1].setBorderPainted(true);
                     ledger_buttons[p1].setContentAreaFilled(false);
                     ledger_buttons[p1].setBorderPainted(false);
                      ledger_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        ledger_buttons[p1+1].requestFocus();
                     ledger_buttons[p1+1].setContentAreaFilled(true);
                     ledger_buttons[p1+1].setBorderPainted(true);
                      ledger_buttons[p1].setContentAreaFilled(false);
                     ledger_buttons[p1].setBorderPainted(false);
                      ledger_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                        case KeyEvent.VK_ENTER:
                     if (p1==0){
                    
                     esc_close();
                      System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
        
    
                     }
                     if (p1==1){
                    
             esc_close();      
         System.out.println("Panel to Delete: "+i);
       
      jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       ledger_edit_delete_panel ledp=new ledger_edit_delete_panel();
            panelArray[i]=ledp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    
                     }
                         if (p1==2){
                    
                      esc_close();
        ledger_short_panel.setVisible(false);
        account_master.setVisible(true);
        ledger_create.setVisible(false);
        
           try
     {
         account_master.setSelected(true);
ledger_button.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                        
                      
                      
                  default:
                     break;
                  }
               }
            });
                
            }
         
      
         
         
       
         
         
         
         
         
         
         
          final JButton product_group_button[]={product_group_create_button, product_group_edit_button,product_group_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=product_group_button[p1].getText();
              
                
               product_group_button[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        product_group_button[p1-1].requestFocus();
                     product_group_button[p1-1].setContentAreaFilled(true);
                     product_group_button[p1-1].setBorderPainted(true);
                     product_group_button[p1].setContentAreaFilled(false);
                     product_group_button[p1].setBorderPainted(false);
                      product_group_button[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        product_group_button[p1+1].requestFocus();
                     product_group_button[p1+1].setContentAreaFilled(true);
                     product_group_button[p1+1].setBorderPainted(true);
                      product_group_button[p1].setContentAreaFilled(false);
                     product_group_button[p1].setBorderPainted(false);
                      product_group_button[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                        case KeyEvent.VK_ENTER:
                     if (p1==0){
                    
                      esc_close();
           System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    
                     }
                     if (p1==1){
                    
            esc_close();        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_edit_panel igcp=new inventory_group_edit_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    
                     }
                         if (p1==2){
                    
                      esc_close();        // TODO add your handling code here:
        product_group_short_panel.setVisible(false);
        product_group.setVisible(false);
        inventory_master.setVisible(true);
        
        try
     {
        inventory_master.setSelected(true);
        inventory_master_product_group.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                        
                      
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
         
         
         final JButton group_buttons[]={create_group, edit_group,back_group};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=group_buttons[p1].getText();
              
                
               group_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        group_buttons[p1-1].requestFocus();
                     group_buttons[p1-1].setContentAreaFilled(true);
                     group_buttons[p1-1].setBorderPainted(true);
                     group_buttons[p1].setContentAreaFilled(false);
                     group_buttons[p1].setBorderPainted(false);
                      group_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        group_buttons[p1+1].requestFocus();
                     group_buttons[p1+1].setContentAreaFilled(true);
                     group_buttons[p1+1].setBorderPainted(true);
                      group_buttons[p1].setContentAreaFilled(false);
                     group_buttons[p1].setBorderPainted(false);
                      group_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                        case KeyEvent.VK_ENTER:
                       if (p1==0){
                         
                    
            esc_close();
        System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
        
       
    
                     }
                     if (p1==1){
                    
                      esc_close();
        System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_edit_delete_panel egl=new acc_group_edit_delete_panel();
       panelArray[i]=egl;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    
                     }
                       
                         
                         if (p1==2){
                     esc_close();
        group_short_panel.setVisible(false);
        group_create.setVisible(false);
        account_master.setVisible(true);
        
           try
     {
         account_master.setSelected(true);
account_master_group.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
    
                     }
                      
                      
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
     
         
         
          final JButton party_buttons[]={customer, vendor,customer_vendor_back};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=party_buttons[p1].getText();
              
                
               party_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        party_buttons[p1-1].requestFocus();
                     party_buttons[p1-1].setContentAreaFilled(true);
                     party_buttons[p1-1].setBorderPainted(true);
                     party_buttons[p1].setContentAreaFilled(false);
                     party_buttons[p1].setBorderPainted(false);
                      party_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        party_buttons[p1+1].requestFocus();
                     party_buttons[p1+1].setContentAreaFilled(true);
                     party_buttons[p1+1].setBorderPainted(true);
                      party_buttons[p1].setContentAreaFilled(false);
                     party_buttons[p1].setBorderPainted(false);
                      party_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                       case KeyEvent.VK_ENTER:
                           if(p1==0){
                                esc_close();
        customer_shortcut();
        customer_short_panel.setVisible(true);
        customer_create.setVisible(true);
        customer_vendor.setVisible(false);
        
          try
     {
         customer_create.setSelected(true);
customer_create_button.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
        
        
                           }
                       if(p1==1){
                           esc_close();
        vendor_shortcut();
        vendor_short_panel.setVisible(true);
        vendor_create.setVisible(true);
        customer_vendor.setVisible(false);
         try
     {
         vendor_create.setSelected(true);
vendor_create_button.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
        
                       }
                       if(p1==2){
                            esc_close();        // TODO add your handling code here:
        customer_vendor.setVisible(false);
        account_master.setVisible(true);
        
           try
     {
         account_master.setSelected(true);
customer_vendor.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
                       }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
         final JButton customer_buttons[]={customer_create_button, customer_edit_button,customer_back_button};
           
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=customer_buttons[p1].getText();
              
                
               customer_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  esc_close();
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        customer_buttons[p1-1].requestFocus();
                     customer_buttons[p1-1].setContentAreaFilled(true);
                     customer_buttons[p1-1].setBorderPainted(true);
                     customer_buttons[p1].setContentAreaFilled(false);
                     customer_buttons[p1].setBorderPainted(false);
                      customer_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        customer_buttons[p1+1].requestFocus();
                     customer_buttons[p1+1].setContentAreaFilled(true);
                     customer_buttons[p1+1].setBorderPainted(true);
                      customer_buttons[p1].setContentAreaFilled(false);
                     customer_buttons[p1].setBorderPainted(false);
                      customer_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                        case KeyEvent.VK_ENTER:
                            if(p1==0){
                                esc_close();
                                 System.out.println("Panel to Delete: "+i);
        
       jPanel6.setVisible(false);
       ledger_short_panel.setVisible(true);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel crp=new customer_create_panel();
       panelArray[i]=crp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
        ledger_short_panel.setVisible(false);
                            }
                        
                        if(p1==1){
                            esc_close();
                             System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_edit_panel cep=new customer_edit_panel();
       panelArray[i]=cep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                        }
                        if(p1==2){

                             customer_short_panel.setVisible(false);
        customer_create.setVisible(false);
        customer_vendor.setVisible(true);
        
          try
     {
         customer_vendor.setSelected(true);
customer.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
        
        
                        }
                      
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         final JButton vendor_buttons[]={vendor_create_button, vendor_edit_button,vendor_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=vendor_buttons[p1].getText();
              
                
               vendor_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override   
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        vendor_buttons[p1-1].requestFocus();
                     vendor_buttons[p1-1].setContentAreaFilled(true);
                     vendor_buttons[p1-1].setBorderPainted(true);
                     vendor_buttons[p1].setContentAreaFilled(false);
                     vendor_buttons[p1].setBorderPainted(false);
                      vendor_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        vendor_buttons[p1+1].requestFocus();
                     vendor_buttons[p1+1].setContentAreaFilled(true);
                     vendor_buttons[p1+1].setBorderPainted(true);
                      vendor_buttons[p1].setContentAreaFilled(false);
                     vendor_buttons[p1].setBorderPainted(false);
                      vendor_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                       case KeyEvent.VK_ENTER:
                           if(p1==0){
                               esc_close();
          System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
                               
                           }
                       
                       if(p1==1){
                            esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_edit_delete_panel vedp=new vendor_edit_delete_panel();
            panelArray[i]=vedp;
           
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
                       }
                       
                       if(p1==2){
                           esc_close();        // TODO add your handling code here:
        vendor_short_panel.setVisible(false);
        vendor_create.setVisible(false);
        customer_vendor.setVisible(true);
        
          try
     {
         customer_vendor.setSelected(true);
customer.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
                       }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         final JButton inventory_buttons[]={inventory_master_product_group, inventory_master_unit,inventory_master_product,inventory_master_godown,inventory_master_back};
        
         for (int p=0;p<5;p++)
            {
                
                final int p1=p;
                String st=inventory_buttons[p1].getText();
              
                
               inventory_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                     inventory_buttons[p1-1].requestFocus();
                     inventory_buttons[p1-1].setContentAreaFilled(true);
                     inventory_buttons[p1-1].setBorderPainted(true);
                     inventory_buttons[p1].setContentAreaFilled(false);
                     inventory_buttons[p1].setBorderPainted(false);
                     inventory_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 5)
                     inventory_buttons[p1+1].requestFocus();
                     inventory_buttons[p1+1].setContentAreaFilled(true);
                     inventory_buttons[p1+1].setBorderPainted(true);
                     inventory_buttons[p1].setContentAreaFilled(false);
                     inventory_buttons[p1].setBorderPainted(false);
                     inventory_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case  KeyEvent.VK_ENTER:
                      if(p1==0)
                      {
                           product_group_shortcut();
        product_group_short_panel.setVisible(true);
        product_group.setVisible(true);
        inventory_master.setVisible(false);
        try{
            product_group.setSelected(true);
            product_group_create_button.setFocusable(true);
            
        }
            catch(Exception we)
            {
                
            }
                      }
                  
                  if(p1==1)
                      {
                          
                           unit_shortcut();
        unit_short_panel.setVisible(true);
        unit_create.setVisible(true);
        inventory_master.setVisible(false);
        try{
            unit_create.setSelected(true);
            unit_create_button.setFocusable(true);
            
        }
            catch(Exception we)
            {
                
            }
                          
                      }
                  
                  if(p1==2)
                      {
                           product_shortcut();
        product_short_panel.setVisible(true);
        product_create.setVisible(true);
        inventory_master.setVisible(false);
        try{
            product_create.setSelected(true);
            product_create_button.setFocusable(true);
            
        }
            catch(Exception we)
            {
                
            }
                          
                      }
                  
                  if(p1==3)
                      {
                          
                          godown_shortcut();
        godown_short_panel.setVisible(true);
        godown_create.setVisible(true);
        inventory_master.setVisible(false);
        
        try{
            godown_create.setSelected(true);
            godown_create_button.setFocusable(true);
            
        }
         catch(Exception we)
            {
                
            }
                          
                      }
                  
                  if(p1==4)
                      {
                           menu.setVisible(true);
        inventory_master.setVisible(false);
        
         try
     {
         menu.setSelected(true);
inventory_master.setFocusable(true);
    
     }
     catch(Exception we)
     {
         
     }
                          
                      }
                  
                  
                  default:
                     break;
                  }
               }
            });
                
               
            }
    
         
          final JButton unit_buttons[]={unit_create_button, unit_edit_button,unit_back};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=unit_buttons[p1].getText();
              
                
               unit_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        unit_buttons[p1-1].requestFocus();
                     unit_buttons[p1-1].setContentAreaFilled(true);
                     unit_buttons[p1-1].setBorderPainted(true);
                     unit_buttons[p1].setContentAreaFilled(false);
                     unit_buttons[p1].setBorderPainted(false);
                      unit_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        unit_buttons[p1+1].requestFocus();
                     unit_buttons[p1+1].setContentAreaFilled(true);
                     unit_buttons[p1+1].setBorderPainted(true);
                      unit_buttons[p1].setContentAreaFilled(false);
                     unit_buttons[p1].setBorderPainted(false);
                      unit_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case  KeyEvent.VK_ENTER:
                          if(p1==0){
                              
                              esc_close();
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
            inventory_unit_create_panel iuc=new inventory_unit_create_panel();
           panelArray[i]=iuc;
           
          
         
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
                              
                          }
                      if(p1==1){
                          
                          esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_edit_panel iuep=new inventory_unit_edit_panel();
            panelArray[i]=iuep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
                          
                      }
                      if(p1==2){
                           esc_close();        // TODO add your handling code here:
        unit_short_panel.setVisible(false);
        unit_create.setVisible(false);
        inventory_master.setVisible(true);
        try{
             inventory_master.setSelected(true);
        inventory_master_product_group.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                      }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
          final JButton product_buttons[]={product_create_button, product_edit_button,product_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=product_buttons[p1].getText();
              
                
               product_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        product_buttons[p1-1].requestFocus();
                     product_buttons[p1-1].setContentAreaFilled(true);
                     product_buttons[p1-1].setBorderPainted(true);
                     product_buttons[p1].setContentAreaFilled(false);
                     product_buttons[p1].setBorderPainted(false);
                      product_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        product_buttons[p1+1].requestFocus();
                     product_buttons[p1+1].setContentAreaFilled(true);
                     product_buttons[p1+1].setBorderPainted(true);
                      product_buttons[p1].setContentAreaFilled(false);
                     product_buttons[p1].setBorderPainted(false);
                      product_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case  KeyEvent.VK_ENTER:
                          if(p1==0){
                              
                               esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                              
                          }
                      if(p1==1){
                          
                          esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_edit_panel ipep=new inventory_product_edit_panel();
            panelArray[i]=ipep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                          
           
                          
                      }
                      if(p1==2){
                          esc_close();        // TODO add your handling code here:
        product_short_panel.setVisible(false);
         product_create.setVisible(false);
        inventory_master.setVisible(true);
        try{
             inventory_master.setSelected(true);
        inventory_master_product_group.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                        
                      }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
         final JButton godown_buttons[]={godown_create_button, godown_edit_button,godown_back_button3};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=godown_buttons[p1].getText();
              
                
               godown_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        godown_buttons[p1-1].requestFocus();
                     godown_buttons[p1-1].setContentAreaFilled(true);
                     godown_buttons[p1-1].setBorderPainted(true);
                     godown_buttons[p1].setContentAreaFilled(false);
                     godown_buttons[p1].setBorderPainted(false);
                      godown_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        godown_buttons[p1+1].requestFocus();
                     godown_buttons[p1+1].setContentAreaFilled(true);
                     godown_buttons[p1+1].setBorderPainted(true);
                      godown_buttons[p1].setContentAreaFilled(false);
                     godown_buttons[p1].setBorderPainted(false);
                      godown_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case  KeyEvent.VK_ENTER:
                          if(p1==0){
                                esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                             
                              
                          }
                      if(p1==1){
                          
                           esc_close();        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_edit_panel gep=new godown_edit_panel();
            panelArray[i]=gep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                       
                          
                      }
                      if(p1==2){
                         esc_close();        // TODO add your handling code here:
        godown_short_panel.setVisible(false);
        godown_create.setVisible(false);
        inventory_master.setVisible(true);
        try{
             inventory_master.setSelected(true);
        inventory_master_product_group.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                        
                      }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
          final JButton purchase_buttons[]={purchase_create_button, purchase_edit_button,purchase_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=purchase_buttons[p1].getText();
              
                
               purchase_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        purchase_buttons[p1-1].requestFocus();
                     purchase_buttons[p1-1].setContentAreaFilled(true);
                     purchase_buttons[p1-1].setBorderPainted(true);
                     purchase_buttons[p1].setContentAreaFilled(false);
                     purchase_buttons[p1].setBorderPainted(false);
                      purchase_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        purchase_buttons[p1+1].requestFocus();
                     purchase_buttons[p1+1].setContentAreaFilled(true);
                     purchase_buttons[p1+1].setBorderPainted(true);
                      purchase_buttons[p1].setContentAreaFilled(false);
                     purchase_buttons[p1].setBorderPainted(false);
                      purchase_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case  KeyEvent.VK_ENTER:
                          if(p1==0){
                                 esc_close();
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_create_panel npcp=new normal_purchase_create_panel();
            panelArray[i]=npcp;
           
          
         
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                             
                              
                          }
                      if(p1==1){
                          
                          esc_close();        
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_edit_panel_final npep=new normal_purchase_edit_panel_final();
            panelArray[i]=npep;
           
          
         
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                       
                          
                      }
                      if(p1==2){
                        esc_close();        // TODO add your handling code here:
        purchase_short_panel.setVisible(false);
        purchase_create.setVisible(false);
        transaction.setVisible(true);
        try{
             transaction.setSelected(true);
        purchase_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                        
                      }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
          final JButton sale_buttons[]={sale_create_button,sale_edit_button,sale_print_button,sale_detail_button,sold_item_detail_button,sale_back_button};
        
         for (int p=0;p<6;p++)
            {
                
                final int p1=p;
                String st=sale_buttons[p1].getText();
              
                
               sale_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        sale_buttons[p1-1].requestFocus();
                     sale_buttons[p1-1].setContentAreaFilled(true);
                     sale_buttons[p1-1].setBorderPainted(true);
                     sale_buttons[p1].setContentAreaFilled(false);
                     sale_buttons[p1].setBorderPainted(false);
                      sale_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 6)
                        sale_buttons[p1+1].requestFocus();
                     sale_buttons[p1+1].setContentAreaFilled(true);
                     sale_buttons[p1+1].setBorderPainted(true);
                      sale_buttons[p1].setContentAreaFilled(false);
                     sale_buttons[p1].setBorderPainted(false);
                      sale_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case KeyEvent.VK_ENTER:
                          if(p1==0){
                              esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                              
                          }
                          
                          
                          if(p1==1)
                          {
                              esc_close();        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                          }
                          
                          
                           if(p1==2){
                              esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                              
                          }
                           
                            if(p1==3){
                              esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                              
                          }
                            
                             if(p1==4){
                              esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                              
                          }
                          if(p1==5)
                          {
                              esc_close();        // TODO add your handling code here:
         sale_short_panel.setVisible(false);
        sale_create_menu.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            sale_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                              
                          }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
          final JButton transaction_buttons[]={purchase_button, sale_button,payment_button,receipt_button,journal_button,stock_transfer_button,fund_transfer_button,opening_stock_button,reminder_button,back_transaction_button};
        
         for (int p=0;p<10;p++)
            {
                
                final int p1=p;
                String st=transaction_buttons[p1].getText();
              
                
               transaction_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                     transaction_buttons[p1-1].requestFocus();
                     transaction_buttons[p1-1].setContentAreaFilled(true);
                     transaction_buttons[p1-1].setBorderPainted(true);
                     transaction_buttons[p1].setContentAreaFilled(false);
                     transaction_buttons[p1].setBorderPainted(false);
                     transaction_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 10)
                        transaction_buttons[p1+1].requestFocus();
                     transaction_buttons[p1+1].setContentAreaFilled(true);
                     transaction_buttons[p1+1].setBorderPainted(true);
                      transaction_buttons[p1].setContentAreaFilled(false);
                     transaction_buttons[p1].setBorderPainted(false);
                      transaction_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      case KeyEvent.VK_ENTER:
                          if(p1==0){
                               purchase_shortcut();
        purchase_short_panel.setVisible(true);
        purchase_create.setVisible(true);
        transaction.setVisible(false);
        try{
            purchase_create.setSelected(true);
            purchase_create_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        }
                          }
        
        if(p1==1){
            sale_shortcut();
        sale_short_panel.setVisible(true);
        sale_create_menu.setVisible(true);
        transaction.setVisible(false);
        
           try{
            sale_create_menu.setSelected(true);
            sale_create_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        } 
        }
       
        if(p1==2)
        {
             payment_shortcut();
         payment_short_panel.setVisible(true);
        payment_create.setVisible(true);
        transaction.setVisible(false);
        
         try{
            payment_create.setSelected(true);
            payment_create_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        } 
        
        }
        if(p1==3)
        {
            receipt_shortcut();
        receipt_short_panel.setVisible(true);
        receipt_create.setVisible(true);
        transaction.setVisible(false);
         try{
            receipt_create.setSelected(true);
            receipt_create_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        } 
            
        }
        if(p1==4)
        {
             journal_shortcut();
        journal_short_panel.setVisible(true);
        journal_create.setVisible(true);
        transaction.setVisible(false);
        try{
            journal_create.setSelected(true);
            journal_create_button.setFocusable(true);
            
        }
        catch(Exception we){
            
        } 
        }
        if(p1==5){
             stock_transfer();
        stock_transfer_panel.setVisible(true);
        stock_transfer.setVisible(true);
        transaction.setVisible(false);
        try{
            stock_transfer.setSelected(true);
            stock_transfer_create_button.setFocusable(true);
        }
        catch(Exception we){
        }
                              
        }      
        
         if(p1==6){
             fund_transfer();
        fund_transfer_panel.setVisible(true);
        fund_transfer.setVisible(true);
        transaction.setVisible(false);
        try{
            fund_transfer.setSelected(true);
            create_fund_transfer_button.setFocusable(true);
        }
        catch(Exception we){
        }
                              
        }   
         
         
        if(p1==7){
             opening_stock();
        opening_stock_panel.setVisible(true);
        opening_stock.setVisible(true);
        transaction.setVisible(false);
        try{
            opening_stock.setSelected(true);
            opening_stock_create_button.setFocusable(true);
        }
        catch(Exception we){
        }
                              
        }   
       if(p1==8){
            reminder_shortcut();
        reminder_short_panel.setVisible(true);
        reminder_create.setVisible(true);
        transaction.setVisible(false);
        try{
            reminder_create.setSelected(true);
            reminder_create_button.setFocusable(true);
        }
        catch(Exception we){
        }
                              
        }
                          
                          
                          if(p1==9){
                             menu.setVisible(true);
        transaction.setVisible(false);
        try{
            menu.setSelected(true);
            menu_transaction.setFocusable(true);
        }
        catch(Exception we)
        {
            
        }
                          
                          }         
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
     final JButton payment_buttons[]={payment_create_button,payment_edit_button,payment_print_button,payment_details_button,payment_back_button};
        
         for (int p=0;p<5;p++)
            {
                
                final int p1=p;
                String st=payment_buttons[p1].getText();
              
                
               payment_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        payment_buttons[p1-1].requestFocus();
                     payment_buttons[p1-1].setContentAreaFilled(true);
                     payment_buttons[p1-1].setBorderPainted(true);
                     payment_buttons[p1].setContentAreaFilled(false);
                     payment_buttons[p1].setBorderPainted(false);
                      payment_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 6)
                        payment_buttons[p1+1].requestFocus();
                     payment_buttons[p1+1].setContentAreaFilled(true);
                     payment_buttons[p1+1].setBorderPainted(true);
                      payment_buttons[p1].setContentAreaFilled(false);
                     payment_buttons[p1].setBorderPainted(false);
                      payment_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      
                      case KeyEvent.VK_ENTER:
                         if(p1==0){
                              esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                         }
                         
                          if(p1==1){
                              esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                         }
                          
                           if(p1==2){
                              esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                         }
                          
                           
                            if(p1==3){
                              esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                         }
                          if(p1==4){
                               esc_close();        // TODO add your handling code here:
         payment_short_panel.setVisible(false);
         payment_create.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            payment_button.setFocusable(true);
            
        }
        catch(Exception we)
        {
            
        }
                          }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         final JButton receipt_buttons[]={receipt_create_button,receipt_edit_button,receipt_print_button,receipt_details_button,receipt_back_button};
        
         for (int p=0;p<5;p++)
            {
                
                final int p1=p;
                String st=receipt_buttons[p1].getText();
              
                
               receipt_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        receipt_buttons[p1-1].requestFocus();
                     receipt_buttons[p1-1].setContentAreaFilled(true);
                     receipt_buttons[p1-1].setBorderPainted(true);
                     receipt_buttons[p1].setContentAreaFilled(false);
                     receipt_buttons[p1].setBorderPainted(false);
                      receipt_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 5)
                        receipt_buttons[p1+1].requestFocus();
                     receipt_buttons[p1+1].setContentAreaFilled(true);
                     receipt_buttons[p1+1].setBorderPainted(true);
                      receipt_buttons[p1].setContentAreaFilled(false);
                     receipt_buttons[p1].setBorderPainted(false);
                      receipt_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_ENTER:
                      if(p1==0)
                      {
                           esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_create_panel rcp=new receipt_create_panel();
            panelArray[i]=rcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                          
                      }
                      if(p1==1){
                         esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                      }
                       if(p1==2){
                         esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                      }
                       if(p1==3){
                         esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                      }
                      
                      if(p1==4)
                      {
                          esc_close();        // TODO add your handling code here:
        receipt_short_panel.setVisible(false);
        receipt_create.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            receipt_button.setFocusable(true);
            
        }
        catch(Exception we)
        {
        }
                      }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
         final JButton journal_buttons[]={journal_create_button,journal_edit_button,journal_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=journal_buttons[p1].getText();
              
                
               journal_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        journal_buttons[p1-1].requestFocus();
                     journal_buttons[p1-1].setContentAreaFilled(true);
                     journal_buttons[p1-1].setBorderPainted(true);
                     journal_buttons[p1].setContentAreaFilled(false);
                     journal_buttons[p1].setBorderPainted(false);
                      journal_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        journal_buttons[p1+1].requestFocus();
                     journal_buttons[p1+1].setContentAreaFilled(true);
                     journal_buttons[p1+1].setBorderPainted(true);
                      journal_buttons[p1].setContentAreaFilled(false);
                     journal_buttons[p1].setBorderPainted(false);
                      journal_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      case KeyEvent.VK_ENTER:
                          if(p1==0){
                               esc_close();
        System.out.println("Panel to Delete: "+i);
      
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Journal_panel jcp=new Journal_panel();
            panelArray[i]=jcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                          }
                          
                          if(p1==1){
                            esc_close();        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      journal_edit_panel jep=new journal_edit_panel();
            panelArray[i]=jep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
                          }
                          
                          if(p1==2)
                          {
                              esc_close();        // TODO add your handling code here:
        journal_short_panel.setVisible(false);
        journal_create.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            journal_button.setFocusable(true);
        }
        catch(Exception we)
        {
            
        }
                          }
                      
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
          final JButton stock_transfer_buttons[]={stock_transfer_create_button,stock_transfer_alter_button,stock_transferl_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=stock_transfer_buttons[p1].getText();
              
                
               stock_transfer_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        stock_transfer_buttons[p1-1].requestFocus();
                     stock_transfer_buttons[p1-1].setContentAreaFilled(true);
                     stock_transfer_buttons[p1-1].setBorderPainted(true);
                     stock_transfer_buttons[p1].setContentAreaFilled(false);
                     stock_transfer_buttons[p1].setBorderPainted(false);
                      stock_transfer_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        stock_transfer_buttons[p1+1].requestFocus();
                     stock_transfer_buttons[p1+1].setContentAreaFilled(true);
                     stock_transfer_buttons[p1+1].setBorderPainted(true);
                      stock_transfer_buttons[p1].setContentAreaFilled(false);
                     stock_transfer_buttons[p1].setBorderPainted(false);
                      stock_transfer_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_ENTER:
                      if(p1==0){
                           esc_close();
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Stock_transfer_panel stp=new Stock_transfer_panel();
            panelArray[i]=stp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                      }
                      
                      if(p1==1){
                          
                      }
                      
                      if(p1==2)
                      {
                           esc_close();        // TODO add your handling code here:
        stock_transfer_panel.setVisible(false);
         stock_transfer.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            stock_transfer_button.setFocusable(true);
        }
            catch(Exception we){
                
            }
                      }
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
         
         final JButton fund_transfer[]={create_fund_transfer_button,alter_fund_transfer_button,back_fund_transferl_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=fund_transfer[p1].getText();
              
                
               fund_transfer[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        fund_transfer[p1-1].requestFocus();
                     fund_transfer[p1-1].setContentAreaFilled(true);
                     fund_transfer[p1-1].setBorderPainted(true);
                     fund_transfer[p1].setContentAreaFilled(false);
                     fund_transfer[p1].setBorderPainted(false);
                      fund_transfer[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        fund_transfer[p1+1].requestFocus();
                     fund_transfer[p1+1].setContentAreaFilled(true);
                     fund_transfer[p1+1].setBorderPainted(true);
                      fund_transfer[p1].setContentAreaFilled(false);
                     fund_transfer[p1].setBorderPainted(false);
                      fund_transfer[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_ENTER:
                      if(p1==0){
                           esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       fundtransfer_panel ftp=new fundtransfer_panel();
            panelArray[i]=ftp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                      }
                  
                  if(p1==1){
                      
                  }
                      if(p1==2){
//                          esc_close();     
//                          fund_transfer_panel.setVisible(false);
//         fund_transfer.setVisible(false);
//        transaction.setVisible(true); 
//        try{
//            
//        }
                      }
                  default:
                     break;
                  }
               }
            });
                
               
            }
         
             
     final JButton opening_stock_buttons[]={opening_stock_create_button,opening_stock_edit_button,opening_stock_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=opening_stock_buttons[p1].getText();
              
                
               opening_stock_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        opening_stock_buttons[p1-1].requestFocus();
                     opening_stock_buttons[p1-1].setContentAreaFilled(true);
                     opening_stock_buttons[p1-1].setBorderPainted(true);
                     opening_stock_buttons[p1].setContentAreaFilled(false);
                     opening_stock_buttons[p1].setBorderPainted(false);
                      opening_stock_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        opening_stock_buttons[p1+1].requestFocus();
                     opening_stock_buttons[p1+1].setContentAreaFilled(true);
                     opening_stock_buttons[p1+1].setBorderPainted(true);
                      opening_stock_buttons[p1].setContentAreaFilled(false);
                     opening_stock_buttons[p1].setBorderPainted(false);
                      opening_stock_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      case KeyEvent.VK_ENTER:
                          if(p1==0){
                                esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Openingstockcreate_panel otc=new Openingstockcreate_panel();
            panelArray[i]=otc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                          }
                      
                      if(p1==1)
                      {
                         esc_close();        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       openingstock_edit_panel otep=new openingstock_edit_panel();
            panelArray[i]=otep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
                      }
                      
                      if(p1==2)
                      {
                          esc_close();     
                          opening_stock_panel.setVisible(false);
        opening_stock.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            opening_stock_button.setFocusable(true);
        }
            catch(Exception we){
                
            }              
                      }
                  default:
                     break;
                  }
               }
            });
            }
         
         
         
         final JButton reminder_buttons[]={reminder_create_button,reminder_edit_button,reminder_back_button};
        
         for (int p=0;p<3;p++)
            {
                
                final int p1=p;
                String st=reminder_buttons[p1].getText();
              
                
               reminder_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (p1 > 0)
                        reminder_buttons[p1-1].requestFocus();
                     reminder_buttons[p1-1].setContentAreaFilled(true);
                     reminder_buttons[p1-1].setBorderPainted(true);
                     reminder_buttons[p1].setContentAreaFilled(false);
                     reminder_buttons[p1].setBorderPainted(false);
                      reminder_buttons[p1-1].setBackground(Color.GRAY);
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                  case KeyEvent.VK_DOWN:
                     if (p1 < 3)
                        reminder_buttons[p1+1].requestFocus();
                     reminder_buttons[p1+1].setContentAreaFilled(true);
                     reminder_buttons[p1+1].setBorderPainted(true);
                      reminder_buttons[p1].setContentAreaFilled(false);
                     reminder_buttons[p1].setBorderPainted(false);
                      reminder_buttons[p1+1].setBackground(Color.GRAY);
                       // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     break;
                      case KeyEvent.VK_ENTER:
                          if(p1==0)
                          {
                               esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_Form_panel rfp=new Reminder_Form_panel();
            panelArray[i]=rfp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
                              
                          }
                      
                      if(p1==1)
                      {
                         esc_close();        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_edit_delete_panel redp=new Reminder_edit_delete_panel();
            panelArray[i]=redp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
                      }
                      
                      if(p1==2)
                      {
                          esc_close();        reminder_short_panel.setVisible(false);
        reminder_create.setVisible(false);
        transaction.setVisible(true);
        try{
            transaction.setSelected(true);
            reminder_button.setFocusable(true);
        }catch(Exception we){
            
        }
                      }
                  default:
                     break;
                  }
               }
            });
                
               
            }
      
    
    }
 
 
 public void esc_close()
{
  KeyStroke escape1111 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action action1111 = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        //Shortcut Panel
//       ledger_short_panel.setVisible(false);
//       group_short_panel.setVisible(false);
//       customer_short_panel.setVisible(false);
//       vendor_short_panel.setVisible(false);
//       product_group_short_panel.setVisible(false);
//       unit_short_panel.setVisible(false);
//       product_short_panel.setVisible(false);
//       godown_short_panel.setVisible(false);
//       purchase_short_panel.setVisible(false);
//       sale_short_panel.setVisible(false);
//       payment_short_panel.setVisible(false);
//       receipt_short_panel.setVisible(false);
//       journal_short_panel.setVisible(false);
//       stock_transfer_panel.setVisible(false);
//       fund_transfer_panel.setVisible(false);
//       opening_stock_panel.setVisible(false);
//       reminder_short_panel.setVisible(false);
       //Shortcut Panel
      
        
        
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to Close?","Close",JOptionPane.YES_NO_OPTION);
    if(p==0){
     System.out.println();
       
        if (i>0)
        {    
        System.out.println("Panel to Delete: "+i);
        jPanel4.remove(panelArray[i]);
        
       // panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
         
       
        
        i--;
        System.out.println("Next Panel:"+i);


        jPanel4.setLayout(new BorderLayout());
   
        //jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
     
        
         
            jPanel4.repaint();
         jPanel4.revalidate();
         jPanel4.setVisible(true);
               
           
              
     
        }  
        else{
            
               //Shortcut Panel
       ledger_short_panel.setVisible(false);
       group_short_panel.setVisible(false);
       customer_short_panel.setVisible(false);
       vendor_short_panel.setVisible(false);
       product_group_short_panel.setVisible(false);
       unit_short_panel.setVisible(false);
       product_short_panel.setVisible(false);
       godown_short_panel.setVisible(false);
       purchase_short_panel.setVisible(false);
       sale_short_panel.setVisible(false);
       payment_short_panel.setVisible(false);
       receipt_short_panel.setVisible(false);
       journal_short_panel.setVisible(false);
       stock_transfer_panel.setVisible(false);
       fund_transfer_panel.setVisible(false);
       opening_stock_panel.setVisible(false);
       reminder_short_panel.setVisible(false);
     //  Shortcut Panel
            
        }
         if(i==0)
        {
        jPanel6.setVisible(true);
        menu.setVisible(true);
        
        
        jPanel4.removeAll();
         tutorial_panel tp=new tutorial_panel();   
             panelArray[i]=tp;
         jPanel4.setLayout(new BorderLayout());
   
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
     
        
         
            jPanel4.repaint();
         jPanel4.revalidate();
         jPanel4.setVisible(true);
        
        
        //Shortcut Panel
//       ledger_short_panel.setVisible(false);
//       group_short_panel.setVisible(false);
//       customer_short_panel.setVisible(false);
//       vendor_short_panel.setVisible(false);
//       product_group_short_panel.setVisible(false);
//       unit_short_panel.setVisible(false);
//       product_short_panel.setVisible(false);
//       godown_short_panel.setVisible(false);
//       purchase_short_panel.setVisible(false);
//       sale_short_panel.setVisible(false);
//       payment_short_panel.setVisible(false);
//       receipt_short_panel.setVisible(false);
//       journal_short_panel.setVisible(false);
//       stock_transfer_panel.setVisible(false);
//       fund_transfer_panel.setVisible(false);
//       opening_stock_panel.setVisible(false);
//       reminder_short_panel.setVisible(false);
       //Shortcut Panel
       
       
       
       //Internal Menu
        
        account_master.setVisible(false);
        inventory_master.setVisible(false);
        transaction.setVisible(false);
        report.setVisible(false);
        ledger_create.setVisible(false);
        group_create.setVisible(false);
        customer_vendor.setVisible(false);
        customer_create.setVisible(false);
        vendor_create.setVisible(false);
        product_group.setVisible(false);
        unit_create.setVisible(false);
        product_create.setVisible(false);
        godown_create.setVisible(false);
        purchase_create.setVisible(false);
        sale_create_menu.setVisible(false);
        payment_create.setVisible(false);
        receipt_create.setVisible(false);
        journal_create.setVisible(false);
        stock_transfer.setVisible(false);
        fund_transfer.setVisible(false);
        opening_stock.setVisible(false);
        reminder_create.setVisible(false);
        profit_loss_menu.setVisible(false);
        //Internal Menu
        menu_account_master.setFocusCycleRoot(false);
        menu_inventory_master.setFocusCycleRoot(false);
        menu_transaction.setFocusCycleRoot(false);
     
        menu_report.setFocusCycleRoot(false);
          
        }
       else
         {
               //Shortcut Panel
//       ledger_short_panel.setVisible(false);
//       group_short_panel.setVisible(false);
//       customer_short_panel.setVisible(false);
//       vendor_short_panel.setVisible(false);
//       product_group_short_panel.setVisible(false);
//       unit_short_panel.setVisible(false);
//       product_short_panel.setVisible(false);
//       godown_short_panel.setVisible(false);
//       purchase_short_panel.setVisible(false);
//       sale_short_panel.setVisible(false);
//       payment_short_panel.setVisible(false);
//       receipt_short_panel.setVisible(false);
//       journal_short_panel.setVisible(false);
//       stock_transfer_panel.setVisible(false);
//       fund_transfer_panel.setVisible(false);
//       opening_stock_panel.setVisible(false);
//       reminder_short_panel.setVisible(false);
       //Shortcut Panel
         }

    }
    else
    {
        ledger_short_panel.setVisible(false);
       group_short_panel.setVisible(false);
       customer_short_panel.setVisible(false);
       vendor_short_panel.setVisible(false);
       product_group_short_panel.setVisible(false);
       unit_short_panel.setVisible(false);
       product_short_panel.setVisible(false);
       godown_short_panel.setVisible(false);
       purchase_short_panel.setVisible(false);
       sale_short_panel.setVisible(false);
       payment_short_panel.setVisible(false);
       receipt_short_panel.setVisible(false);
       journal_short_panel.setVisible(false);
       stock_transfer_panel.setVisible(false);
       fund_transfer_panel.setVisible(false);
       opening_stock_panel.setVisible(false);
       reminder_short_panel.setVisible(false);
    }
    }
    };
        
getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape1111, "escape1111");
getRootPane().getActionMap().put("escape1111", action1111);
}

 
  public void esc_close1()
{
  KeyStroke escape1115 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action action1115 = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
       
       
         //Shortcut Panel
       ledger_short_panel.setVisible(false);
       group_short_panel.setVisible(false);
       customer_short_panel.setVisible(false);
       vendor_short_panel.setVisible(false);
       product_group_short_panel.setVisible(false);
       unit_short_panel.setVisible(false);
       product_short_panel.setVisible(false);
       godown_short_panel.setVisible(false);
       purchase_short_panel.setVisible(false);
       sale_short_panel.setVisible(false);
       payment_short_panel.setVisible(false);
       receipt_short_panel.setVisible(false);
       journal_short_panel.setVisible(false);
       stock_transfer_panel.setVisible(false);
       fund_transfer_panel.setVisible(false);
       opening_stock_panel.setVisible(false);
       reminder_short_panel.setVisible(false);
       //Shortcut Panel
       
     
    }
   
    };
        
getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape1115, "escape1115");
getRootPane().getActionMap().put("escape1115", action1115);
}
 
 
 
 
 
  public void esc_close2()
{
  KeyStroke escape1112 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action action1112 = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
       // int p=JOptionPane.showConfirmDialog(null,"Do you really want to Close?","Close",JOptionPane.YES_NO_OPTION);
     
        
        //Shortcut Panel
       ledger_short_panel.setVisible(false);
       group_short_panel.setVisible(false);
       customer_short_panel.setVisible(false);
       vendor_short_panel.setVisible(false);
       product_group_short_panel.setVisible(false);
       unit_short_panel.setVisible(false);
       product_short_panel.setVisible(false);
       godown_short_panel.setVisible(false);
       purchase_short_panel.setVisible(false);
       sale_short_panel.setVisible(false);
       payment_short_panel.setVisible(false);
       receipt_short_panel.setVisible(false);
       journal_short_panel.setVisible(false);
       stock_transfer_panel.setVisible(false);
       fund_transfer_panel.setVisible(false);
       opening_stock_panel.setVisible(false);
       reminder_short_panel.setVisible(false);
       //Shortcut Panel
       
       
       
       //Internal Menu
       menu.setVisible(true);
       //menu.setSelected(true);
       menu_account_master.setFocusable(true);
//       menu_inventory_master.setFocusable(true);
//       menu_transaction.setFocusable(true);
//       menu_report.setFocusable(true);
        account_master.setVisible(false);
        inventory_master.setVisible(false);
        transaction.setVisible(false);
        report.setVisible(false);
        ledger_create.setVisible(false);
        group_create.setVisible(false);
        customer_vendor.setVisible(false);
        customer_create.setVisible(false);
        vendor_create.setVisible(false);
        product_group.setVisible(false);
        unit_create.setVisible(false);
        product_create.setVisible(false);
        godown_create.setVisible(false);
        purchase_create.setVisible(false);
        sale_create_menu.setVisible(false);
        payment_create.setVisible(false);
        receipt_create.setVisible(false);
        journal_create.setVisible(false);
        stock_transfer.setVisible(false);
        fund_transfer.setVisible(false);
        opening_stock.setVisible(false);
        reminder_create.setVisible(false);
        profit_loss_menu.setVisible(false);
        //Internal Menu
            
      


   
    }
    };
        
getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape1112, "escape1112");
getRootPane().getActionMap().put("escape1112", action1112);
}
 
 
 
 
 
 
 
 
 
 //Ledger Shortcuts
 public void ledger_shortcut()
	{
    
         //   Shortcut-Key = Ledger Create
            KeyStroke ShortKeyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction1  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        esc_close();
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke1, "escape1");
getRootPane().getActionMap().put("escape1", ShortkeyAction1 ); 




//   Shortcut-Key = Ledger Edit/Delete
  KeyStroke ShortKeyStroke17 = KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction17  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        esc_close();
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          ledger_edit_delete_panel ledp=new ledger_edit_delete_panel();
            panelArray[i]=ledp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke17, "escape17");
getRootPane().getActionMap().put("escape17", ShortkeyAction17 );




//   Shortcut-Key = Group Create
            KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction2  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape2");
getRootPane().getActionMap().put("escape2", ShortkeyAction2 ); 
        }
 
 //Group Shortcuts
 public void group_shortcut()
	{
            //   Shortcut-Key = Group Create
            KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction2  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape2");
getRootPane().getActionMap().put("escape2", ShortkeyAction2 ); 


//   Shortcut-Key = Group Edit/Delete
  KeyStroke ShortKeyStroke18 = KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction18  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           acc_group_edit_delete_panel egl=new acc_group_edit_delete_panel();
       panelArray[i]=egl;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke18, "escape18");
getRootPane().getActionMap().put("escape18", ShortkeyAction18 );
    
     
        }
 

//Customer Shortcuts 
public void customer_shortcut()
	{
            //   Shortcut-Key = Customer Create
            KeyStroke ShortKeyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction3  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel crp=new customer_create_panel();
       panelArray[i]=crp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke3, "escape3");
getRootPane().getActionMap().put("escape3", ShortkeyAction3 );


//   Shortcut-Key = Customer Edit/Delete
  KeyStroke ShortKeyStroke19 = KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction19  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           customer_edit_panel cep=new customer_edit_panel();
       panelArray[i]=cep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke19, "escape19");
getRootPane().getActionMap().put("escape19", ShortkeyAction19 );


//   Shortcut-Key = Group Create
            KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction2  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape2");
getRootPane().getActionMap().put("escape2", ShortkeyAction2 ); 
    
     
        }
 
 
 //Vendor Shortcuts
 public void vendor_shortcut()
 {
     //   Shortcut-Key = Vendor Create
            KeyStroke ShortKeyStroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction4  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke4, "escape4");
getRootPane().getActionMap().put("escape4", ShortkeyAction4 );



//   Shortcut-Key = Vendor Edit/Delete
  KeyStroke ShortKeyStroke20 = KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction20  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_edit_delete_panel vedp=new vendor_edit_delete_panel();
            panelArray[i]=vedp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke20, "escape20");
getRootPane().getActionMap().put("escape20", ShortkeyAction20 );


//   Shortcut-Key = Group Create
            KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction2  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape2");
getRootPane().getActionMap().put("escape2", ShortkeyAction2 ); 
     
 }
 
 
 //Product Group Shortcuts
 public void product_group_shortcut()
 {
     //   Shortcut-Key = Product Group Create
            KeyStroke ShortKeyStroke5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction5  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
               
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke5, "escape5");
getRootPane().getActionMap().put("escape5", ShortkeyAction5 );



//   Shortcut-Key = Product Group Edit/Delete
  KeyStroke ShortKeyStroke21 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction21  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_group_edit_panel igcp=new inventory_group_edit_panel();
            panelArray[i]=igcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke21, "escape21");
getRootPane().getActionMap().put("escape21", ShortkeyAction21 );
 
 }
 
 
 
 //Unit Shortcuts
 public void unit_shortcut()
 {
     //   Shortcut-Key = Unit Create
            KeyStroke ShortKeyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction6  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke6, "escape6");
getRootPane().getActionMap().put("escape6", ShortkeyAction6 );


//   Shortcut-Key = Unit Edit/Delete
  KeyStroke ShortKeyStroke22 = KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction22  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_unit_edit_panel iuep=new inventory_unit_edit_panel();
            panelArray[i]=iuep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke22, "escape22");
getRootPane().getActionMap().put("escape22", ShortkeyAction22 );
     
 }

 
 
 //Product Shortcuts
 public void product_shortcut()
 {
     //   Shortcut-Key = Product Create
            KeyStroke ShortKeyStroke7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction7  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
           
          
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke7, "escape7");
getRootPane().getActionMap().put("escape7", ShortkeyAction7 );


//   Shortcut-Key = Product Edit/Delete
  KeyStroke ShortKeyStroke23 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK+InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction23  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_product_edit_panel ipep=new inventory_product_edit_panel();
            panelArray[i]=ipep;
           
           
          
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke23, "escape23");
getRootPane().getActionMap().put("escape23", ShortkeyAction23 );



//   Shortcut-Key = Product Group Create
            KeyStroke ShortKeyStroke5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction5  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
               
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke5, "escape5");
getRootPane().getActionMap().put("escape5", ShortkeyAction5 );


//   Shortcut-Key = Unit Create
            KeyStroke ShortKeyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction6  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke6, "escape6");
getRootPane().getActionMap().put("escape6", ShortkeyAction6 );
     
 }
 
 //Godown Shortcuts
 public void godown_shortcut()
 {
     //   Shortcut-Key = Godown Create
            KeyStroke ShortKeyStroke8 = KeyStroke.getKeyStroke(KeyEvent.VK_F8,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction8  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke8, "escape8");
getRootPane().getActionMap().put("escape8", ShortkeyAction8 );


//   Shortcut-Key = Godown Edit/Delete
  KeyStroke ShortKeyStroke24 = KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.ALT_MASK+InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction24  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        godown_edit_panel gep=new godown_edit_panel();
            panelArray[i]=gep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke24, "escape24");
getRootPane().getActionMap().put("escape24", ShortkeyAction24 );
     
 }
 
 
 //Purchase Shortcuts
 public void purchase_shortcut()
 {
     //   Shortcut-Key = Purchase Create
            KeyStroke ShortKeyStroke9 = KeyStroke.getKeyStroke(KeyEvent.VK_F9,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction9  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        normal_purchase_create_panel npcp=new normal_purchase_create_panel();
            panelArray[i]=npcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke9, "escape9");
getRootPane().getActionMap().put("escape9", ShortkeyAction9 );


//   Shortcut-Key = Purchase Edit/Delete
  KeyStroke ShortKeyStroke25 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.ALT_MASK+InputEvent.SHIFT_MASK);
 
  
  Action ShortkeyAction25  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
         normal_purchase_edit_panel_final npep=new normal_purchase_edit_panel_final();
            panelArray[i]=npep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke25, "escape25");
getRootPane().getActionMap().put("escape25", ShortkeyAction25 );


 //   Shortcut-Key = Ledger Create
            KeyStroke ShortKeyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction1  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke1, "escape1");
getRootPane().getActionMap().put("escape1", ShortkeyAction1 );



//   Shortcut-Key = Product Create
            KeyStroke ShortKeyStroke7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction7  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke7, "escape7");
getRootPane().getActionMap().put("escape7", ShortkeyAction7 );



//   Shortcut-Key = Unit Create
            KeyStroke ShortKeyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction6  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke6, "escape6");
getRootPane().getActionMap().put("escape6", ShortkeyAction6 );
     
 }
 
 
 
 //Sale Shortcuts
 public void sale_shortcut()
 {
     //   Shortcut-Key = Sale Create
            KeyStroke ShortKeyStroke10 = KeyStroke.getKeyStroke(KeyEvent.VK_F10,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction10  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke10, "escape10");
getRootPane().getActionMap().put("escape10", ShortkeyAction10 );


//   Shortcut-Key = Sale Edit/Delete
  KeyStroke ShortKeyStroke26 = KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction26  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke26, "escape26");
getRootPane().getActionMap().put("escape26", ShortkeyAction26 );

//   Shortcut-Key = Sale Print
  KeyStroke ShortKeyStroke37 = KeyStroke.getKeyStroke(KeyEvent.VK_P+KeyEvent.VK_S,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction37  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke37, "escape37");
getRootPane().getActionMap().put("escape37", ShortkeyAction37 );

//   Shortcut-Key = Sale Detail
  KeyStroke ShortKeyStroke38 = KeyStroke.getKeyStroke(KeyEvent.VK_D+KeyEvent.VK_S,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction38  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke38, "escape38");
getRootPane().getActionMap().put("escape38", ShortkeyAction38 );

//   Shortcut-Key = Sold Item Details
  KeyStroke ShortKeyStroke39 = KeyStroke.getKeyStroke(KeyEvent.VK_I+KeyEvent.VK_S,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction39  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke39, "escape39");
getRootPane().getActionMap().put("escape39", ShortkeyAction39 );


//   Shortcut-Key = Ledger Create
            KeyStroke ShortKeyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction1  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke1, "escape1");
getRootPane().getActionMap().put("escape1", ShortkeyAction1 ); 


//   Shortcut-Key = Customer Create
            KeyStroke ShortKeyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction3  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel crp=new customer_create_panel();
       panelArray[i]=crp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke3, "escape3");
getRootPane().getActionMap().put("escape3", ShortkeyAction3 );


//   Shortcut-Key = Vendor Create
            KeyStroke ShortKeyStroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction4  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke4, "escape4");
getRootPane().getActionMap().put("escape4", ShortkeyAction4 );


//   Shortcut-Key = Godown Create
            KeyStroke ShortKeyStroke8 = KeyStroke.getKeyStroke(KeyEvent.VK_F8,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction8  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke8, "escape8");
getRootPane().getActionMap().put("escape8", ShortkeyAction8 );

 }
 
 
 //Payment Shortcuts
 public void payment_shortcut()
 {
    //   Shortcut-Key = Payment Create
            KeyStroke ShortKeyStroke11 = KeyStroke.getKeyStroke(KeyEvent.VK_F11,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction11  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke11, "escape11");
getRootPane().getActionMap().put("escape11", ShortkeyAction11 ); 


//   Shortcut-Key = Payment Edit/Delete
  KeyStroke ShortKeyStroke27 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK+InputEvent.SHIFT_MASK);
 
  
  Action ShortkeyAction27  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke27, "escape27");
getRootPane().getActionMap().put("escape27", ShortkeyAction27 );

//   Shortcut-Key = Payment Edit/Delete
  KeyStroke ShortKeyStroke50 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK+InputEvent.SHIFT_MASK);
 
  
  Action ShortkeyAction50  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke50, "escape50");
getRootPane().getActionMap().put("escape50", ShortkeyAction50 );

//   Shortcut-Key = Payment Print
  KeyStroke ShortKeyStroke40 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.SHIFT_MASK);
 
  
  Action ShortkeyAction40  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke40, "escape40");
getRootPane().getActionMap().put("escape40", ShortkeyAction40 );

//   Shortcut-Key = Payment Details
  KeyStroke ShortKeyStroke41 = KeyStroke.getKeyStroke(KeyEvent.VK_P+KeyEvent.VK_D,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction41  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke41, "escape41");
getRootPane().getActionMap().put("escape41", ShortkeyAction41 );

 }
 
 
 
 //Receipt Shortcuts
 public void receipt_shortcut()
 {
     //   Shortcut-Key = Receipt Create
            KeyStroke ShortKeyStroke12 = KeyStroke.getKeyStroke(KeyEvent.VK_F12,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction12  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
         esc_close();
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
         receipt_create_panel rcp=new receipt_create_panel();
            panelArray[i]=rcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke12, "escape12");
getRootPane().getActionMap().put("escape12", ShortkeyAction12 );


//   Shortcut-Key = Receipt Edit/Delete
  KeyStroke ShortKeyStroke28 = KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction28  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
         esc_close();
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke28, "escape28");
getRootPane().getActionMap().put("escape28", ShortkeyAction28 );


//   Shortcut-Key = Receipt Print
  KeyStroke ShortKeyStroke40 = KeyStroke.getKeyStroke(KeyEvent.VK_P+KeyEvent.VK_R,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction40  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke40, "escape40");
getRootPane().getActionMap().put("escape40", ShortkeyAction40 );

//   Shortcut-Key = Receipt Details
  KeyStroke ShortKeyStroke41 = KeyStroke.getKeyStroke(KeyEvent.VK_R+KeyEvent.VK_D,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction41  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke41, "escape41");
getRootPane().getActionMap().put("escape41", ShortkeyAction41 );
 }
 
 
 //Journal Shortcuts
 public void journal_shortcut()
 {
     //   Shortcut-Key = Journal Create
            KeyStroke ShortKeyStroke13 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction13  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
         Journal_panel jcp=new Journal_panel();
            panelArray[i]=jcp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke13, "escape13");
getRootPane().getActionMap().put("escape13", ShortkeyAction13 );


//   Shortcut-Key = Journal Edit/Delete
  KeyStroke ShortKeyStroke29 = KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction29  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           journal_edit_panel jep=new journal_edit_panel();
            panelArray[i]=jep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke29, "escape29");
getRootPane().getActionMap().put("escape29", ShortkeyAction29 );


//   Shortcut-Key = Ledger Create
            KeyStroke ShortKeyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction1  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke1, "escape1");
getRootPane().getActionMap().put("escape1", ShortkeyAction1 ); 
     
 }
 
 
 
 //Stock Transfer Shortcuts
 public void stock_transfer()
 {
    //   Shortcut-Key = Stock Transfer Create
            KeyStroke ShortKeyStroke14 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction14  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
         Stock_transfer_panel stp=new Stock_transfer_panel();
            panelArray[i]=stp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke14, "escape14");
getRootPane().getActionMap().put("escape14", ShortkeyAction14 ); 
 }
 public void fund_transfer()
 {
      //   Shortcut-Key = Fund Transfer eate
            KeyStroke ShortKeyStroke41 = KeyStroke.getKeyStroke(KeyEvent.VK_F3,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction41  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           fundtransfer_panel ftp=new fundtransfer_panel();
            panelArray[i]=ftp;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke41, "escape41");
getRootPane().getActionMap().put("escape41", ShortkeyAction41 );


//   Shortcut-Key = Opening Stock Edit Delete
            KeyStroke ShortKeyStroke42 = KeyStroke.getKeyStroke(KeyEvent.VK_F+KeyEvent.VK_A,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction42  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          openingstock_edit_panel otep=new openingstock_edit_panel();
            panelArray[i]=otep;
           
           
          
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke42, "escape42");
getRootPane().getActionMap().put("escape42", ShortkeyAction42 );

     
 }
 
 //Opening Stock Shortcuts
 public void opening_stock()
 {
     //   Shortcut-Key = Opening Stock Create
            KeyStroke ShortKeyStroke16 = KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction16  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          Openingstockcreate_panel otc=new Openingstockcreate_panel();
            panelArray[i]=otc;
           
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke16, "escape16");
getRootPane().getActionMap().put("escape16", ShortkeyAction16 );


//   Shortcut-Key = Opening Stock Edit Delete
            KeyStroke ShortKeyStroke34 = KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.ALT_MASK);
 
  
  Action ShortkeyAction34  = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
          openingstock_edit_panel otep=new openingstock_edit_panel();
            panelArray[i]=otep;
           
           
          
        
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke34, "escape34");
getRootPane().getActionMap().put("escape34", ShortkeyAction34 );

 }
 
 
 
 
 //Reminder Shortcuts
 public void reminder_shortcut()
 {
     //   Shortcut-Key = Reminder Create
            KeyStroke ShortKeyStroke35 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction35 = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      Reminder_Form_panel rfp=new Reminder_Form_panel();
            panelArray[i]=rfp;
           
          
       
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke35, "escape35");
getRootPane().getActionMap().put("escape35", ShortkeyAction35 );


//   Shortcut-Key = Reminder Edit Delete
            KeyStroke ShortKeyStroke36 = KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK);
 
  
  Action ShortkeyAction36 = new AbstractAction() {
  
    public void actionPerformed(ActionEvent e) {
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_edit_delete_panel redp=new Reminder_edit_delete_panel();
            panelArray[i]=redp;
           
          
       
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
       
        
    }

               
            }; 

getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke36, "escape36");
getRootPane().getActionMap().put("escape36", ShortkeyAction36 );
     
 }
 
 
  public void initialize()
	{
       BasicInternalFrameUI ui = (BasicInternalFrameUI)menu.getUI();
       Container north = (Container)ui.getNorthPane();
       north.remove(0);
       north.validate();
       north.repaint();
      
       BasicInternalFrameUI ui1 = (BasicInternalFrameUI)account_master.getUI();
        Container north1 = (Container)ui1.getNorthPane();
       north1.remove(0);
       north1.validate();
       north1.repaint();
       
       BasicInternalFrameUI ui2 = (BasicInternalFrameUI)inventory_master.getUI();
       Container north2 = (Container)ui2.getNorthPane();
       north2.remove(0);
       north2.validate();
       north2.repaint();
       
        BasicInternalFrameUI ui3 = (BasicInternalFrameUI)transaction.getUI();
        Container north3 = (Container)ui3.getNorthPane();
        north3.remove(0);
        north3.validate();
        north3.repaint();
        
        BasicInternalFrameUI ui4 = (BasicInternalFrameUI)report.getUI();
        Container north4 = (Container)ui4.getNorthPane();
        north4.remove(0);
        north4.validate();
        north4.repaint();
        
        BasicInternalFrameUI ui5 = (BasicInternalFrameUI)ledger_create.getUI();
        Container north5 = (Container)ui5.getNorthPane();
        north5.remove(0);
        north5.validate();
        north5.repaint();
        
        BasicInternalFrameUI ui6 = (BasicInternalFrameUI)group_create.getUI();
        Container north6 = (Container)ui6.getNorthPane();
        north6.remove(0);
        north6.validate();
        north6.repaint();
        
        BasicInternalFrameUI ui7 = (BasicInternalFrameUI)customer_vendor.getUI();
        Container north7 = (Container)ui7.getNorthPane();
        north7.remove(0);
        north7.validate();
        north7.repaint();
        
        BasicInternalFrameUI ui8 = (BasicInternalFrameUI)customer_create.getUI();
        Container north8 = (Container)ui8.getNorthPane();
        north8.remove(0);
        north8.validate();
        north8.repaint();
        
        BasicInternalFrameUI ui9 = (BasicInternalFrameUI)vendor_create.getUI();
        Container north9 = (Container)ui9.getNorthPane();
        north9.remove(0);
        north9.validate();
        north9.repaint();
        
        BasicInternalFrameUI ui10 = (BasicInternalFrameUI)product_group.getUI();
        Container north10 = (Container)ui10.getNorthPane();
        north10.remove(0);
        north10.validate();
        north10.repaint();
        
        BasicInternalFrameUI ui11 = (BasicInternalFrameUI)unit_create.getUI();
        Container north11 = (Container)ui11.getNorthPane();
        north11.remove(0);
        north11.validate();
        north11.repaint();
        
        BasicInternalFrameUI ui12 = (BasicInternalFrameUI)product_create.getUI();
        Container north12 = (Container)ui12.getNorthPane();
        north12.remove(0);
        north12.validate();
        north12.repaint();
        
        BasicInternalFrameUI ui13 = (BasicInternalFrameUI)godown_create.getUI();
        Container north13 = (Container)ui13.getNorthPane();
        north13.remove(0);
        north13.validate();
        north13.repaint();
        
        BasicInternalFrameUI ui14 = (BasicInternalFrameUI)purchase_create.getUI();
        Container north14 = (Container)ui14.getNorthPane();
        north14.remove(0);
        north14.validate();
        north14.repaint();
        
        BasicInternalFrameUI ui15 = (BasicInternalFrameUI)sale_create_menu.getUI();
        Container north15 = (Container)ui15.getNorthPane();
        north15.remove(0);
        north15.validate();
        north15.repaint();
        
        BasicInternalFrameUI ui16 = (BasicInternalFrameUI)payment_create.getUI();
        Container north16 = (Container)ui16.getNorthPane();
        north16.remove(0);
        north16.validate();
        north16.repaint();
        
        BasicInternalFrameUI ui17= (BasicInternalFrameUI)receipt_create.getUI();
        Container north17 = (Container)ui17.getNorthPane();
        north17.remove(0);
        north17.validate();
        north17.repaint();
        
        BasicInternalFrameUI ui18= (BasicInternalFrameUI)journal_create.getUI();
        Container north18 = (Container)ui18.getNorthPane();
        north18.remove(0);
        north18.validate();
        north18.repaint();
        
        BasicInternalFrameUI ui19= (BasicInternalFrameUI)stock_transfer.getUI();
        Container north19 = (Container)ui19.getNorthPane();
        north19.remove(0);
        north19.validate();
        north19.repaint();
        
        BasicInternalFrameUI ui20= (BasicInternalFrameUI)fund_transfer.getUI();
        Container north20 = (Container)ui20.getNorthPane();
        north20.remove(0);
        north20.validate();
        north20.repaint();
        
        BasicInternalFrameUI ui21= (BasicInternalFrameUI)opening_stock.getUI();
        Container north21 = (Container)ui21.getNorthPane();
        north21.remove(0);
        north21.validate();
        north21.repaint();
        
        BasicInternalFrameUI ui22= (BasicInternalFrameUI)reminder_create.getUI();
        Container north22 = (Container)ui22.getNorthPane();
        north22.remove(0);
        north22.validate();
        north22.repaint();
        
        BasicInternalFrameUI ui23= (BasicInternalFrameUI)profit_loss_menu.getUI();
        Container north23 = (Container)ui23.getNorthPane();
        north23.remove(0);
        north23.validate();
        north23.repaint();
        
        }

//Group Shortcuts
// public void group()
//	{
//    
//         //   Shortcut-Key = Ledger Create
//            KeyStroke ShortKeyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction1  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//       Ledger_create_panel lcp=new Ledger_create_panel();
//            panelArray[i]=lcp;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke1, "escape1");
//getRootPane().getActionMap().put("escape1", ShortkeyAction1 ); 
//
////   Shortcut-Key = Group Create
//            KeyStroke ShortKeyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction2  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//       acc_group_create agc=new acc_group_create();
//       panelArray[i]=agc;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke2, "escape2");
//getRootPane().getActionMap().put("escape2", ShortkeyAction2 ); 
//
//
////   Shortcut-Key = Customer Create
//            KeyStroke ShortKeyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction3  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//       Customer_create_panel crp=new Customer_create_panel();
//       panelArray[i]=crp;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke3, "escape3");
//getRootPane().getActionMap().put("escape3", ShortkeyAction3 );
//
//
////   Shortcut-Key = Vendor Create
//            KeyStroke ShortKeyStroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction4  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        vendor_create_panel vcp=new vendor_create_panel();
//            panelArray[i]=vcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke4, "escape4");
//getRootPane().getActionMap().put("escape4", ShortkeyAction4 );
//
//
//      
//       //   Shortcut-Key = Product Group Create
//            KeyStroke ShortKeyStroke5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction5  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_group_create_panel igcp=new inventory_group_create_panel();
//            panelArray[i]=igcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke5, "escape5");
//getRootPane().getActionMap().put("escape5", ShortkeyAction5 );    
//
//
////   Shortcut-Key = Unit Create
//            KeyStroke ShortKeyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction6  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_unit_create_panel iuc=new inventory_unit_create_panel();
//            panelArray[i]=iuc;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke6, "escape6");
//getRootPane().getActionMap().put("escape6", ShortkeyAction6 );
//
//
//
//
////   Shortcut-Key = Product Create
//            KeyStroke ShortKeyStroke7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction7  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_product_create_panel ipcp=new inventory_product_create_panel();
//            panelArray[i]=ipcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke7, "escape7");
//getRootPane().getActionMap().put("escape7", ShortkeyAction7 );
//
//
////   Shortcut-Key = Godown Create
//            KeyStroke ShortKeyStroke8 = KeyStroke.getKeyStroke(KeyEvent.VK_F8,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction8  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        godown_create_panel gcp=new godown_create_panel();
//            panelArray[i]=gcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke8, "escape8");
//getRootPane().getActionMap().put("escape8", ShortkeyAction8 );
//
//
////   Shortcut-Key = Purchase Create
//            KeyStroke ShortKeyStroke9 = KeyStroke.getKeyStroke(KeyEvent.VK_F9,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction9  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        normal_purchase_create_panel npcp=new normal_purchase_create_panel();
//            panelArray[i]=npcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke9, "escape9");
//getRootPane().getActionMap().put("escape9", ShortkeyAction9 );
//
//
////   Shortcut-Key = Sale Create
//            KeyStroke ShortKeyStroke10 = KeyStroke.getKeyStroke(KeyEvent.VK_F10,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction10  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        normal_sale_create_panel nscp=new normal_sale_create_panel();
//            panelArray[i]=nscp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke10, "escape10");
//getRootPane().getActionMap().put("escape10", ShortkeyAction10 );
//
//
//
////   Shortcut-Key = Payment Create
//            KeyStroke ShortKeyStroke11 = KeyStroke.getKeyStroke(KeyEvent.VK_F11,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction11  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        payment_create_panel pcp=new payment_create_panel();
//            panelArray[i]=pcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke11, "escape11");
//getRootPane().getActionMap().put("escape11", ShortkeyAction11 );
//
//
////   Shortcut-Key = Receipt Create
//            KeyStroke ShortKeyStroke12 = KeyStroke.getKeyStroke(KeyEvent.VK_F12,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction12  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//         receipt_create_panel rcp=new receipt_create_panel();
//            panelArray[i]=rcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke12, "escape12");
//getRootPane().getActionMap().put("escape12", ShortkeyAction12 );
//
//
////   Shortcut-Key = Journal Create
//            KeyStroke ShortKeyStroke13 = KeyStroke.getKeyStroke(KeyEvent.VK_F1,InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction13  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//         Journal_panel jcp=new Journal_panel();
//            panelArray[i]=jcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke13, "escape13");
//getRootPane().getActionMap().put("escape13", ShortkeyAction13 );
//
//
////   Shortcut-Key = Stock Transfer Create
//            KeyStroke ShortKeyStroke14 = KeyStroke.getKeyStroke(KeyEvent.VK_F2,InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction14  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//         Stock_transfer_panel stp=new Stock_transfer_panel();
//            panelArray[i]=stp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke14, "escape14");
//getRootPane().getActionMap().put("escape14", ShortkeyAction14 );
//
//
////   Shortcut-Key = Fund Transfer Create
//            KeyStroke ShortKeyStroke15 = KeyStroke.getKeyStroke(KeyEvent.VK_F3,InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction15  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//          fundtransfer_panel ftp=new fundtransfer_panel();
//            panelArray[i]=ftp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke15, "escape15");
//getRootPane().getActionMap().put("escape15", ShortkeyAction15 );
//
//
////   Shortcut-Key = Opening Stock Create
//            KeyStroke ShortKeyStroke16 = KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction16  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//          Openingstockcreate_panel otc=new Openingstockcreate_panel();
//            panelArray[i]=otc;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke16, "escape16");
//getRootPane().getActionMap().put("escape16", ShortkeyAction16 );
//
//
////   Shortcut-Key = Ledger Edit/Delete
//  KeyStroke ShortKeyStroke17 = KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction17  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//          ledger_edit_delete_panel ledp=new ledger_edit_delete_panel();
//            panelArray[i]=ledp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke17, "escape17");
//getRootPane().getActionMap().put("escape17", ShortkeyAction17 );
//
//
//
////   Shortcut-Key = Group Edit/Delete
//  KeyStroke ShortKeyStroke18 = KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction18  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//           acc_group_edit_delete_panel egl=new acc_group_edit_delete_panel();
//       panelArray[i]=egl;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke18, "escape18");
//getRootPane().getActionMap().put("escape18", ShortkeyAction18 );
//
//
////   Shortcut-Key = Customer Edit/Delete
//  KeyStroke ShortKeyStroke19 = KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction19  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//           customer_edit_panel cep=new customer_edit_panel();
//       panelArray[i]=cep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke19, "escape19");
//getRootPane().getActionMap().put("escape19", ShortkeyAction19 );
//
//
////   Shortcut-Key = Vendor Edit/Delete
//  KeyStroke ShortKeyStroke20 = KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction20  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//       vendor_edit_delete_panel vedp=new vendor_edit_delete_panel();
//            panelArray[i]=vedp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke20, "escape20");
//getRootPane().getActionMap().put("escape20", ShortkeyAction20 );
//
//
////   Shortcut-Key = Product Group Edit/Delete
//  KeyStroke ShortKeyStroke21 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction21  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_group_edit_panel igcp=new inventory_group_edit_panel();
//            panelArray[i]=igcp;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke21, "escape21");
//getRootPane().getActionMap().put("escape21", ShortkeyAction21 );
//
////   Shortcut-Key = Unit Edit/Delete
//  KeyStroke ShortKeyStroke22 = KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction22  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_unit_edit_panel iuep=new inventory_unit_edit_panel();
//            panelArray[i]=iuep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke22, "escape22");
//getRootPane().getActionMap().put("escape22", ShortkeyAction22 );
//
//
////   Shortcut-Key = Product Edit/Delete
//  KeyStroke ShortKeyStroke23 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK+InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction23  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        inventory_product_edit_panel ipep=new inventory_product_edit_panel();
//            panelArray[i]=ipep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke23, "escape23");
//getRootPane().getActionMap().put("escape23", ShortkeyAction23 );
//
//
////   Shortcut-Key = Godown Edit/Delete
//  KeyStroke ShortKeyStroke24 = KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.ALT_MASK+InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction24  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        godown_edit_panel gep=new godown_edit_panel();
//            panelArray[i]=gep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke24, "escape24");
//getRootPane().getActionMap().put("escape24", ShortkeyAction24 );
//
//
////   Shortcut-Key = Purchase Edit/Delete
//  KeyStroke ShortKeyStroke25 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.ALT_MASK+InputEvent.SHIFT_MASK);
// 
//  
//  Action ShortkeyAction25  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//         normal_purchase_edit_panel npep=new normal_purchase_edit_panel();
//            panelArray[i]=npep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke25, "escape25");
//getRootPane().getActionMap().put("escape25", ShortkeyAction25 );
//
//
////   Shortcut-Key = Sale Edit/Delete
//  KeyStroke ShortKeyStroke26 = KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction26  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//          normal_sale_edit_panel nsep=new normal_sale_edit_panel();
//            panelArray[i]=nsep;
//           
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke26, "escape26");
//getRootPane().getActionMap().put("escape26", ShortkeyAction26 );
//
//
////   Shortcut-Key = Payment Edit/Delete
//  KeyStroke ShortKeyStroke27 = KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK+InputEvent.SHIFT_MASK);
// 
//  
//  Action ShortkeyAction27  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//           payment_edit_panel pep=new payment_edit_panel();
//            panelArray[i]=pep;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke27, "escape27");
//getRootPane().getActionMap().put("escape27", ShortkeyAction27 );
//
//
////   Shortcut-Key = Receipt Edit/Delete
//  KeyStroke ShortKeyStroke28 = KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction28  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//           receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
//            panelArray[i]=rep;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke28, "escape28");
//getRootPane().getActionMap().put("escape28", ShortkeyAction28 );
//
//
//
////   Shortcut-Key = Journal Edit/Delete
//  KeyStroke ShortKeyStroke29 = KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.ALT_MASK);
// 
//  
//  Action ShortkeyAction29  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//           Journal_edit_panel jep=new Journal_edit_panel();
//            panelArray[i]=jep;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke29, "escape29");
//getRootPane().getActionMap().put("escape29", ShortkeyAction29 );
//
//
////   Shortcut-Key = Opening Stock Edit/Delete
//  KeyStroke ShortKeyStroke30 = KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_MASK+InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction30  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//          openingstock_edit_panel otep=new openingstock_edit_panel();
//            panelArray[i]=otep;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke30, "escape30");
//getRootPane().getActionMap().put("escape30", ShortkeyAction30 );
//
//
////   Shortcut-Key = Reminder Edit/Delete
//  KeyStroke ShortKeyStroke31 = KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_MASK+InputEvent.CTRL_MASK);
// 
//  
//  Action ShortkeyAction31  = new AbstractAction() {
//  
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Panel to Delete: "+i);
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//         Reminder_edit_delete_panel redp=new Reminder_edit_delete_panel();
//            panelArray[i]=redp;
//           
//          
////           jPanel4.revalidate();
////           System.out.println("Visible hidden");
////          
//           jPanel4.setLayout(new BorderLayout());
//           jPanel4.add(panelArray[i]);
//           panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);      
//       
//        
//    }
//
//               
//            }; 
//
//getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ShortKeyStroke31, "escape31");
//getRootPane().getActionMap().put("escape31", ShortkeyAction31 );
//
//
//
//        }       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelyear = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        company_name = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        menu = new javax.swing.JInternalFrame();
        menu_account_master = new javax.swing.JButton();
        menu_inventory_master = new javax.swing.JButton();
        menu_transaction = new javax.swing.JButton();
        menu_report = new javax.swing.JButton();
        menu_logout = new javax.swing.JButton();
        sale_create_menu = new javax.swing.JInternalFrame();
        sale_create_button = new javax.swing.JButton();
        sale_edit_button = new javax.swing.JButton();
        sale_back_button = new javax.swing.JButton();
        sale_detail_button = new javax.swing.JButton();
        sold_item_detail_button = new javax.swing.JButton();
        sale_print_button = new javax.swing.JButton();
        purchase_create = new javax.swing.JInternalFrame();
        purchase_create_button = new javax.swing.JButton();
        purchase_edit_button = new javax.swing.JButton();
        purchase_back_button = new javax.swing.JButton();
        godown_create = new javax.swing.JInternalFrame();
        godown_create_button = new javax.swing.JButton();
        godown_edit_button = new javax.swing.JButton();
        godown_back_button3 = new javax.swing.JButton();
        product_create = new javax.swing.JInternalFrame();
        product_create_button = new javax.swing.JButton();
        product_edit_button = new javax.swing.JButton();
        product_back_button = new javax.swing.JButton();
        unit_create = new javax.swing.JInternalFrame();
        unit_create_button = new javax.swing.JButton();
        unit_edit_button = new javax.swing.JButton();
        unit_back = new javax.swing.JButton();
        vendor_create = new javax.swing.JInternalFrame();
        vendor_create_button = new javax.swing.JButton();
        vendor_edit_button = new javax.swing.JButton();
        vendor_back_button = new javax.swing.JButton();
        customer_create = new javax.swing.JInternalFrame();
        customer_create_button = new javax.swing.JButton();
        customer_edit_button = new javax.swing.JButton();
        customer_back_button = new javax.swing.JButton();
        report = new javax.swing.JInternalFrame();
        report_cash_status_button = new javax.swing.JButton();
        report_bank_status_button = new javax.swing.JButton();
        report_vendor_status_button = new javax.swing.JButton();
        report_customer_status_button = new javax.swing.JButton();
        report_balance_sheet_button = new javax.swing.JButton();
        report_trial_balance_button = new javax.swing.JButton();
        report_profit_loss_button = new javax.swing.JButton();
        report_stock_summary_button = new javax.swing.JButton();
        report_tax_detail_button = new javax.swing.JButton();
        report_back_button = new javax.swing.JButton();
        customer_vendor = new javax.swing.JInternalFrame();
        customer = new javax.swing.JButton();
        vendor = new javax.swing.JButton();
        customer_vendor_back = new javax.swing.JButton();
        transaction = new javax.swing.JInternalFrame();
        purchase_button = new javax.swing.JButton();
        sale_button = new javax.swing.JButton();
        payment_button = new javax.swing.JButton();
        receipt_button = new javax.swing.JButton();
        journal_button = new javax.swing.JButton();
        stock_transfer_button = new javax.swing.JButton();
        fund_transfer_button = new javax.swing.JButton();
        opening_stock_button = new javax.swing.JButton();
        reminder_button = new javax.swing.JButton();
        back_transaction_button = new javax.swing.JButton();
        group_create = new javax.swing.JInternalFrame();
        create_group = new javax.swing.JButton();
        edit_group = new javax.swing.JButton();
        back_group = new javax.swing.JButton();
        ledger_create = new javax.swing.JInternalFrame();
        create_ledger = new javax.swing.JButton();
        edit_ledger = new javax.swing.JButton();
        back_ledger = new javax.swing.JButton();
        inventory_master = new javax.swing.JInternalFrame();
        inventory_master_product_group = new javax.swing.JButton();
        inventory_master_unit = new javax.swing.JButton();
        inventory_master_product = new javax.swing.JButton();
        inventory_master_godown = new javax.swing.JButton();
        inventory_master_back = new javax.swing.JButton();
        account_master = new javax.swing.JInternalFrame();
        account_master_group = new javax.swing.JButton();
        account_master_party = new javax.swing.JButton();
        account_master_back = new javax.swing.JButton();
        ledger_button = new javax.swing.JButton();
        product_group = new javax.swing.JInternalFrame();
        product_group_create_button = new javax.swing.JButton();
        product_group_edit_button = new javax.swing.JButton();
        product_group_back_button = new javax.swing.JButton();
        payment_create = new javax.swing.JInternalFrame();
        payment_create_button = new javax.swing.JButton();
        payment_edit_button = new javax.swing.JButton();
        payment_back_button = new javax.swing.JButton();
        payment_print_button = new javax.swing.JButton();
        payment_details_button = new javax.swing.JButton();
        receipt_create = new javax.swing.JInternalFrame();
        receipt_create_button = new javax.swing.JButton();
        receipt_edit_button = new javax.swing.JButton();
        receipt_back_button = new javax.swing.JButton();
        receipt_details_button = new javax.swing.JButton();
        receipt_print_button = new javax.swing.JButton();
        journal_create = new javax.swing.JInternalFrame();
        journal_create_button = new javax.swing.JButton();
        journal_edit_button = new javax.swing.JButton();
        journal_back_button = new javax.swing.JButton();
        stock_transfer = new javax.swing.JInternalFrame();
        stock_transfer_create_button = new javax.swing.JButton();
        stock_transfer_alter_button = new javax.swing.JButton();
        stock_transferl_back_button = new javax.swing.JButton();
        fund_transfer = new javax.swing.JInternalFrame();
        create_fund_transfer_button = new javax.swing.JButton();
        alter_fund_transfer_button = new javax.swing.JButton();
        back_fund_transferl_button = new javax.swing.JButton();
        opening_stock = new javax.swing.JInternalFrame();
        opening_stock_create_button = new javax.swing.JButton();
        opening_stock_edit_button = new javax.swing.JButton();
        opening_stock_back_button = new javax.swing.JButton();
        reminder_create = new javax.swing.JInternalFrame();
        reminder_create_button = new javax.swing.JButton();
        reminder_edit_button = new javax.swing.JButton();
        reminder_back_button = new javax.swing.JButton();
        profit_loss_menu = new javax.swing.JInternalFrame();
        profit_loss_horizontal = new javax.swing.JButton();
        profit_loss_vertical = new javax.swing.JButton();
        profit_loss_vertical1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ledger_short_panel = new javax.swing.JPanel();
        ledger_create_short = new javax.swing.JButton();
        ledger_group_short = new javax.swing.JButton();
        ledger_edit_delete_short = new javax.swing.JButton();
        group_short_panel = new javax.swing.JPanel();
        group_create_short = new javax.swing.JButton();
        group_edit_delete_short = new javax.swing.JButton();
        customer_short_panel = new javax.swing.JPanel();
        customer_create_short = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        customer_group_short = new javax.swing.JButton();
        vendor_short_panel = new javax.swing.JPanel();
        vendor_create_short = new javax.swing.JButton();
        vendor_edit_delete_panel = new javax.swing.JButton();
        vendor_group_short = new javax.swing.JButton();
        product_group_short_panel = new javax.swing.JPanel();
        product_group_create_short = new javax.swing.JButton();
        product_group_edit_delete_short = new javax.swing.JButton();
        unit_short_panel = new javax.swing.JPanel();
        unit_create_short = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        product_short_panel = new javax.swing.JPanel();
        product_create_short = new javax.swing.JButton();
        product_edit_delete_short = new javax.swing.JButton();
        product_product_group_short = new javax.swing.JButton();
        product_unit_short = new javax.swing.JButton();
        godown_short_panel = new javax.swing.JPanel();
        godown_create_short = new javax.swing.JButton();
        godown_edit_delete_short = new javax.swing.JButton();
        purchase_short_panel = new javax.swing.JPanel();
        purchase_edit_delete_short = new javax.swing.JButton();
        purchase_product_short = new javax.swing.JButton();
        purchase_unit_short = new javax.swing.JButton();
        purchase_ledger_short = new javax.swing.JButton();
        purchase_create_short = new javax.swing.JButton();
        sale_short_panel = new javax.swing.JPanel();
        sale_create_short = new javax.swing.JButton();
        sale_customer_short = new javax.swing.JButton();
        sale_vendor_short = new javax.swing.JButton();
        sale_ledger_short = new javax.swing.JButton();
        sale_godown_short = new javax.swing.JButton();
        sale_edit_delete_short = new javax.swing.JButton();
        sale_print_short = new javax.swing.JButton();
        sale_detail_short = new javax.swing.JButton();
        sold_item_detail_short = new javax.swing.JButton();
        payment_short_panel = new javax.swing.JPanel();
        payment_create_short = new javax.swing.JButton();
        payment_edit_delete_short = new javax.swing.JButton();
        payment_print_short = new javax.swing.JButton();
        payment_details_short = new javax.swing.JButton();
        receipt_short_panel = new javax.swing.JPanel();
        receipt_create_short = new javax.swing.JButton();
        receipt_edit_delete_short = new javax.swing.JButton();
        receipt_print_short = new javax.swing.JButton();
        receipt_details_short = new javax.swing.JButton();
        journal_short_panel = new javax.swing.JPanel();
        journal_create_short = new javax.swing.JButton();
        journal_edit_delete_short = new javax.swing.JButton();
        journal_ledger_short = new javax.swing.JButton();
        stock_transfer_panel = new javax.swing.JPanel();
        stock_transfer_create_short = new javax.swing.JButton();
        stock_transfer_alter_short = new javax.swing.JButton();
        fund_transfer_panel = new javax.swing.JPanel();
        fund_transfer_create_short = new javax.swing.JButton();
        fund_transfer_alter_short = new javax.swing.JButton();
        opening_stock_panel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        opening_stock_edit_delete_short = new javax.swing.JButton();
        reminder_short_panel = new javax.swing.JPanel();
        reminder_create_short = new javax.swing.JButton();
        reminder_edit_delete_short = new javax.swing.JButton();
        menu_short_panel = new javax.swing.JPanel();
        demo1 = new javax.swing.JButton();
        demo2 = new javax.swing.JButton();
        accounting_master_short = new javax.swing.JButton();
        inventory_master_short = new javax.swing.JButton();
        transaction_short = new javax.swing.JButton();
        reports_short = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        login_login = new javax.swing.JButton();
        login_reset = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        user_name1 = new javax.swing.JTextField();
        password1 = new javax.swing.JTextField();
        login_login1 = new javax.swing.JButton();
        login_reset1 = new javax.swing.JButton();

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("WELCOME TO BITS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel13)))
                .addContainerGap(325, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tpanelLayout = new javax.swing.GroupLayout(tpanel);
        tpanel.setLayout(tpanelLayout);
        tpanelLayout.setHorizontalGroup(
            tpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tpanelLayout.setVerticalGroup(
            tpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BITS ACCOUNTING");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Details"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Company Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Loading Time .. ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Date:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Financial Year:");

        labelyear.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelyear.setText("DD/MM/YYYY");

        jButton5.setText("Close Form");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        company_name.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(company_name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelyear)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelyear)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(company_name))
                .addGap(83, 83, 83))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menu.setTitle("Menu");
        menu.setPreferredSize(new java.awt.Dimension(175, 329));
        menu.setVisible(true);

        menu_account_master.setText("Account Master");
        menu_account_master.setBorderPainted(false);
        menu_account_master.setContentAreaFilled(false);
        menu_account_master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_account_masterActionPerformed(evt);
            }
        });

        menu_inventory_master.setText("Inventory Master");
        menu_inventory_master.setBorderPainted(false);
        menu_inventory_master.setContentAreaFilled(false);
        menu_inventory_master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_inventory_masterActionPerformed(evt);
            }
        });

        menu_transaction.setText("Transaction");
        menu_transaction.setBorderPainted(false);
        menu_transaction.setContentAreaFilled(false);
        menu_transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_transactionActionPerformed(evt);
            }
        });

        menu_report.setText("Reports");
        menu_report.setBorderPainted(false);
        menu_report.setContentAreaFilled(false);
        menu_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_reportActionPerformed(evt);
            }
        });

        menu_logout.setText("Logout");
        menu_logout.setBorderPainted(false);
        menu_logout.setContentAreaFilled(false);
        menu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu.getContentPane());
        menu.getContentPane().setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_inventory_master, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(menu_account_master, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_transaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(menu_account_master)
                .addGap(42, 42, 42)
                .addComponent(menu_inventory_master)
                .addGap(44, 44, 44)
                .addComponent(menu_transaction)
                .addGap(43, 43, 43)
                .addComponent(menu_report)
                .addGap(43, 43, 43)
                .addComponent(menu_logout)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        sale_create_menu.setTitle("Sale");
        sale_create_menu.setPreferredSize(new java.awt.Dimension(175, 319));
        sale_create_menu.setVisible(true);

        sale_create_button.setText("Create");
        sale_create_button.setBorderPainted(false);
        sale_create_button.setContentAreaFilled(false);
        sale_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_create_buttonActionPerformed(evt);
            }
        });

        sale_edit_button.setText("Edit/Delete");
        sale_edit_button.setBorderPainted(false);
        sale_edit_button.setContentAreaFilled(false);
        sale_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_edit_buttonActionPerformed(evt);
            }
        });

        sale_back_button.setText("Back");
        sale_back_button.setBorderPainted(false);
        sale_back_button.setContentAreaFilled(false);
        sale_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_back_buttonActionPerformed(evt);
            }
        });

        sale_detail_button.setText("Sale Detail");
        sale_detail_button.setBorderPainted(false);
        sale_detail_button.setContentAreaFilled(false);
        sale_detail_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_detail_buttonActionPerformed(evt);
            }
        });

        sold_item_detail_button.setText("Sold Item Detail");
        sold_item_detail_button.setBorderPainted(false);
        sold_item_detail_button.setContentAreaFilled(false);
        sold_item_detail_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sold_item_detail_buttonActionPerformed(evt);
            }
        });

        sale_print_button.setText("Print");
        sale_print_button.setBorderPainted(false);
        sale_print_button.setContentAreaFilled(false);
        sale_print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_print_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sale_create_menuLayout = new javax.swing.GroupLayout(sale_create_menu.getContentPane());
        sale_create_menu.getContentPane().setLayout(sale_create_menuLayout);
        sale_create_menuLayout.setHorizontalGroup(
            sale_create_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sale_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_print_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_detail_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sold_item_detail_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(sale_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sale_create_menuLayout.setVerticalGroup(
            sale_create_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sale_create_menuLayout.createSequentialGroup()
                .addComponent(sale_create_button)
                .addGap(28, 28, 28)
                .addComponent(sale_edit_button)
                .addGap(28, 28, 28)
                .addComponent(sale_print_button)
                .addGap(30, 30, 30)
                .addComponent(sale_detail_button)
                .addGap(27, 27, 27)
                .addComponent(sold_item_detail_button)
                .addGap(20, 20, 20)
                .addComponent(sale_back_button)
                .addGap(17, 17, 17))
        );

        purchase_create.setTitle("Purchase");
        purchase_create.setPreferredSize(new java.awt.Dimension(175, 196));
        purchase_create.setVisible(true);

        purchase_create_button.setText("Create");
        purchase_create_button.setBorderPainted(false);
        purchase_create_button.setContentAreaFilled(false);
        purchase_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_create_buttonActionPerformed(evt);
            }
        });

        purchase_edit_button.setText("Edit/Delete");
        purchase_edit_button.setBorderPainted(false);
        purchase_edit_button.setContentAreaFilled(false);
        purchase_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_edit_buttonActionPerformed(evt);
            }
        });

        purchase_back_button.setText("Back");
        purchase_back_button.setBorderPainted(false);
        purchase_back_button.setContentAreaFilled(false);
        purchase_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout purchase_createLayout = new javax.swing.GroupLayout(purchase_create.getContentPane());
        purchase_create.getContentPane().setLayout(purchase_createLayout);
        purchase_createLayout.setHorizontalGroup(
            purchase_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchase_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purchase_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(purchase_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        purchase_createLayout.setVerticalGroup(
            purchase_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchase_createLayout.createSequentialGroup()
                .addComponent(purchase_create_button)
                .addGap(38, 38, 38)
                .addComponent(purchase_edit_button)
                .addGap(47, 47, 47)
                .addComponent(purchase_back_button)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        godown_create.setTitle("Godown");
        godown_create.setPreferredSize(new java.awt.Dimension(175, 185));
        godown_create.setVisible(true);

        godown_create_button.setText("Create");
        godown_create_button.setBorderPainted(false);
        godown_create_button.setContentAreaFilled(false);
        godown_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_create_buttonActionPerformed(evt);
            }
        });

        godown_edit_button.setText("Edit/Delete");
        godown_edit_button.setBorderPainted(false);
        godown_edit_button.setContentAreaFilled(false);
        godown_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_edit_buttonActionPerformed(evt);
            }
        });

        godown_back_button3.setText("Back");
        godown_back_button3.setBorderPainted(false);
        godown_back_button3.setContentAreaFilled(false);
        godown_back_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_back_button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout godown_createLayout = new javax.swing.GroupLayout(godown_create.getContentPane());
        godown_create.getContentPane().setLayout(godown_createLayout);
        godown_createLayout.setHorizontalGroup(
            godown_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(godown_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(godown_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(godown_back_button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        godown_createLayout.setVerticalGroup(
            godown_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(godown_createLayout.createSequentialGroup()
                .addComponent(godown_create_button)
                .addGap(38, 38, 38)
                .addComponent(godown_edit_button)
                .addGap(47, 47, 47)
                .addComponent(godown_back_button3)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        product_create.setTitle("Product");
        product_create.setPreferredSize(new java.awt.Dimension(175, 185));
        product_create.setVisible(true);

        product_create_button.setText("Create");
        product_create_button.setBorderPainted(false);
        product_create_button.setContentAreaFilled(false);
        product_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_create_buttonActionPerformed(evt);
            }
        });

        product_edit_button.setText("Edit/Delete");
        product_edit_button.setBorderPainted(false);
        product_edit_button.setContentAreaFilled(false);
        product_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_edit_buttonActionPerformed(evt);
            }
        });

        product_back_button.setText("Back");
        product_back_button.setBorderPainted(false);
        product_back_button.setContentAreaFilled(false);
        product_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout product_createLayout = new javax.swing.GroupLayout(product_create.getContentPane());
        product_create.getContentPane().setLayout(product_createLayout);
        product_createLayout.setHorizontalGroup(
            product_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(product_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        product_createLayout.setVerticalGroup(
            product_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_createLayout.createSequentialGroup()
                .addComponent(product_create_button)
                .addGap(38, 38, 38)
                .addComponent(product_edit_button)
                .addGap(47, 47, 47)
                .addComponent(product_back_button)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        unit_create.setTitle("Unit");
        unit_create.setPreferredSize(new java.awt.Dimension(175, 196));
        unit_create.setVisible(true);

        unit_create_button.setText("Create");
        unit_create_button.setBorderPainted(false);
        unit_create_button.setContentAreaFilled(false);
        unit_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unit_create_buttonActionPerformed(evt);
            }
        });

        unit_edit_button.setText("Edit/Delete");
        unit_edit_button.setBorderPainted(false);
        unit_edit_button.setContentAreaFilled(false);
        unit_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unit_edit_buttonActionPerformed(evt);
            }
        });

        unit_back.setText("Back");
        unit_back.setBorderPainted(false);
        unit_back.setContentAreaFilled(false);
        unit_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unit_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout unit_createLayout = new javax.swing.GroupLayout(unit_create.getContentPane());
        unit_create.getContentPane().setLayout(unit_createLayout);
        unit_createLayout.setHorizontalGroup(
            unit_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(unit_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(unit_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(unit_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        unit_createLayout.setVerticalGroup(
            unit_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_createLayout.createSequentialGroup()
                .addComponent(unit_create_button)
                .addGap(38, 38, 38)
                .addComponent(unit_edit_button)
                .addGap(47, 47, 47)
                .addComponent(unit_back)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        vendor_create.setTitle("Vendor Create");
        vendor_create.setPreferredSize(new java.awt.Dimension(175, 185));
        vendor_create.setVisible(true);

        vendor_create_button.setText("Create");
        vendor_create_button.setBorderPainted(false);
        vendor_create_button.setContentAreaFilled(false);
        vendor_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_create_buttonActionPerformed(evt);
            }
        });

        vendor_edit_button.setText("Edit/Delete");
        vendor_edit_button.setBorderPainted(false);
        vendor_edit_button.setContentAreaFilled(false);
        vendor_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_edit_buttonActionPerformed(evt);
            }
        });

        vendor_back_button.setText("Back");
        vendor_back_button.setBorderPainted(false);
        vendor_back_button.setContentAreaFilled(false);
        vendor_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vendor_createLayout = new javax.swing.GroupLayout(vendor_create.getContentPane());
        vendor_create.getContentPane().setLayout(vendor_createLayout);
        vendor_createLayout.setHorizontalGroup(
            vendor_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vendor_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vendor_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(vendor_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vendor_createLayout.setVerticalGroup(
            vendor_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendor_createLayout.createSequentialGroup()
                .addComponent(vendor_create_button)
                .addGap(38, 38, 38)
                .addComponent(vendor_edit_button)
                .addGap(47, 47, 47)
                .addComponent(vendor_back_button)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        customer_create.setTitle("Customer Create");
        customer_create.setPreferredSize(new java.awt.Dimension(175, 185));
        customer_create.setVisible(true);

        customer_create_button.setText("Create");
        customer_create_button.setBorderPainted(false);
        customer_create_button.setContentAreaFilled(false);
        customer_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_create_buttonActionPerformed(evt);
            }
        });

        customer_edit_button.setText("Edit/Delete");
        customer_edit_button.setBorderPainted(false);
        customer_edit_button.setContentAreaFilled(false);
        customer_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_edit_buttonActionPerformed(evt);
            }
        });

        customer_back_button.setText("Back");
        customer_back_button.setBorderPainted(false);
        customer_back_button.setContentAreaFilled(false);
        customer_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customer_createLayout = new javax.swing.GroupLayout(customer_create.getContentPane());
        customer_create.getContentPane().setLayout(customer_createLayout);
        customer_createLayout.setHorizontalGroup(
            customer_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customer_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customer_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(customer_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        customer_createLayout.setVerticalGroup(
            customer_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_createLayout.createSequentialGroup()
                .addComponent(customer_create_button)
                .addGap(38, 38, 38)
                .addComponent(customer_edit_button)
                .addGap(47, 47, 47)
                .addComponent(customer_back_button)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        report.setTitle("Report");
        report.setPreferredSize(new java.awt.Dimension(175, 328));
        report.setVisible(true);

        report_cash_status_button.setText("Cash Status");
        report_cash_status_button.setBorderPainted(false);
        report_cash_status_button.setContentAreaFilled(false);

        report_bank_status_button.setText("Bank Status");
        report_bank_status_button.setBorderPainted(false);
        report_bank_status_button.setContentAreaFilled(false);

        report_vendor_status_button.setText("Vendor Status");
        report_vendor_status_button.setBorderPainted(false);
        report_vendor_status_button.setContentAreaFilled(false);

        report_customer_status_button.setText("Customer Status");
        report_customer_status_button.setBorderPainted(false);
        report_customer_status_button.setContentAreaFilled(false);

        report_balance_sheet_button.setText("Balance Sheet");
        report_balance_sheet_button.setBorderPainted(false);
        report_balance_sheet_button.setContentAreaFilled(false);

        report_trial_balance_button.setText("Trial Balance");
        report_trial_balance_button.setBorderPainted(false);
        report_trial_balance_button.setContentAreaFilled(false);
        report_trial_balance_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_trial_balance_buttonActionPerformed(evt);
            }
        });

        report_profit_loss_button.setText("Profit & Loss A/C");
        report_profit_loss_button.setBorderPainted(false);
        report_profit_loss_button.setContentAreaFilled(false);
        report_profit_loss_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_profit_loss_buttonActionPerformed(evt);
            }
        });

        report_stock_summary_button.setText("Stock Summary");
        report_stock_summary_button.setBorderPainted(false);
        report_stock_summary_button.setContentAreaFilled(false);

        report_tax_detail_button.setText("Tax Detail");
        report_tax_detail_button.setBorderPainted(false);
        report_tax_detail_button.setContentAreaFilled(false);

        report_back_button.setText("Back");
        report_back_button.setBorderPainted(false);
        report_back_button.setContentAreaFilled(false);
        report_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report.getContentPane());
        report.getContentPane().setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(report_cash_status_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_bank_status_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_vendor_status_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_customer_status_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(report_balance_sheet_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_trial_balance_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_profit_loss_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_stock_summary_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_tax_detail_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(report_back_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addComponent(report_cash_status_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_bank_status_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_vendor_status_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_customer_status_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_balance_sheet_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_trial_balance_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_profit_loss_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_stock_summary_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_tax_detail_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report_back_button)
                .addContainerGap())
        );

        customer_vendor.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        customer_vendor.setTitle("Party");
        customer_vendor.setToolTipText("");
        customer_vendor.setPreferredSize(new java.awt.Dimension(175, 185));
        customer_vendor.setVisible(true);

        customer.setText("Customer");
        customer.setBorderPainted(false);
        customer.setContentAreaFilled(false);
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });

        vendor.setText("Vendor");
        vendor.setBorderPainted(false);
        vendor.setContentAreaFilled(false);
        vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorActionPerformed(evt);
            }
        });

        customer_vendor_back.setText("Back");
        customer_vendor_back.setBorderPainted(false);
        customer_vendor_back.setContentAreaFilled(false);
        customer_vendor_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_vendor_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customer_vendorLayout = new javax.swing.GroupLayout(customer_vendor.getContentPane());
        customer_vendor.getContentPane().setLayout(customer_vendorLayout);
        customer_vendorLayout.setHorizontalGroup(
            customer_vendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customer_vendor_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customer, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );
        customer_vendorLayout.setVerticalGroup(
            customer_vendorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_vendorLayout.createSequentialGroup()
                .addComponent(customer)
                .addGap(38, 38, 38)
                .addComponent(vendor)
                .addGap(47, 47, 47)
                .addComponent(customer_vendor_back)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        transaction.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        transaction.setTitle("Transaction");
        transaction.setPreferredSize(new java.awt.Dimension(175, 434));
        transaction.setVisible(true);

        purchase_button.setText("Purchase");
        purchase_button.setBorderPainted(false);
        purchase_button.setContentAreaFilled(false);
        purchase_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_buttonActionPerformed(evt);
            }
        });

        sale_button.setText("Sale");
        sale_button.setBorderPainted(false);
        sale_button.setContentAreaFilled(false);
        sale_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_buttonActionPerformed(evt);
            }
        });

        payment_button.setText("Payment");
        payment_button.setBorderPainted(false);
        payment_button.setContentAreaFilled(false);
        payment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_buttonActionPerformed(evt);
            }
        });

        receipt_button.setText("Receipt");
        receipt_button.setBorderPainted(false);
        receipt_button.setContentAreaFilled(false);
        receipt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_buttonActionPerformed(evt);
            }
        });

        journal_button.setText("Journal");
        journal_button.setBorderPainted(false);
        journal_button.setContentAreaFilled(false);
        journal_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_buttonActionPerformed(evt);
            }
        });

        stock_transfer_button.setText("Stock Transfer");
        stock_transfer_button.setBorderPainted(false);
        stock_transfer_button.setContentAreaFilled(false);
        stock_transfer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_transfer_buttonActionPerformed(evt);
            }
        });

        fund_transfer_button.setText("Fund Transfer");
        fund_transfer_button.setBorderPainted(false);
        fund_transfer_button.setContentAreaFilled(false);
        fund_transfer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fund_transfer_buttonActionPerformed(evt);
            }
        });

        opening_stock_button.setText("Opening Stock");
        opening_stock_button.setBorderPainted(false);
        opening_stock_button.setContentAreaFilled(false);
        opening_stock_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opening_stock_buttonActionPerformed(evt);
            }
        });

        reminder_button.setText("Reminder");
        reminder_button.setBorderPainted(false);
        reminder_button.setContentAreaFilled(false);
        reminder_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_buttonActionPerformed(evt);
            }
        });

        back_transaction_button.setText("Back");
        back_transaction_button.setBorderPainted(false);
        back_transaction_button.setContentAreaFilled(false);
        back_transaction_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_transaction_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transactionLayout = new javax.swing.GroupLayout(transaction.getContentPane());
        transaction.getContentPane().setLayout(transactionLayout);
        transactionLayout.setHorizontalGroup(
            transactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchase_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(journal_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stock_transfer_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(fund_transfer_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opening_stock_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reminder_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(back_transaction_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transactionLayout.setVerticalGroup(
            transactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionLayout.createSequentialGroup()
                .addComponent(purchase_button)
                .addGap(18, 18, 18)
                .addComponent(sale_button)
                .addGap(18, 18, 18)
                .addComponent(payment_button)
                .addGap(18, 18, 18)
                .addComponent(receipt_button)
                .addGap(18, 18, 18)
                .addComponent(journal_button)
                .addGap(18, 18, 18)
                .addComponent(stock_transfer_button)
                .addGap(18, 18, 18)
                .addComponent(fund_transfer_button)
                .addGap(0, 0, 0)
                .addComponent(opening_stock_button)
                .addGap(18, 18, 18)
                .addComponent(reminder_button)
                .addGap(18, 18, 18)
                .addComponent(back_transaction_button)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        group_create.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        group_create.setTitle("Group");
        group_create.setPreferredSize(new java.awt.Dimension(175, 185));
        group_create.setVisible(true);

        create_group.setText("Create");
        create_group.setBorderPainted(false);
        create_group.setContentAreaFilled(false);
        create_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_groupActionPerformed(evt);
            }
        });

        edit_group.setText("Edit/Delete");
        edit_group.setBorderPainted(false);
        edit_group.setContentAreaFilled(false);
        edit_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_groupActionPerformed(evt);
            }
        });

        back_group.setText("Back");
        back_group.setBorderPainted(false);
        back_group.setContentAreaFilled(false);
        back_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_groupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout group_createLayout = new javax.swing.GroupLayout(group_create.getContentPane());
        group_create.getContentPane().setLayout(group_createLayout);
        group_createLayout.setHorizontalGroup(
            group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(create_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edit_group, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(back_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        group_createLayout.setVerticalGroup(
            group_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_createLayout.createSequentialGroup()
                .addComponent(create_group)
                .addGap(38, 38, 38)
                .addComponent(edit_group)
                .addGap(47, 47, 47)
                .addComponent(back_group)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        ledger_create.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ledger_create.setTitle("Ledger");
        ledger_create.setPreferredSize(new java.awt.Dimension(175, 196));
        ledger_create.setVisible(true);

        create_ledger.setText("Create");
        create_ledger.setBorderPainted(false);
        create_ledger.setContentAreaFilled(false);
        create_ledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_ledgerActionPerformed(evt);
            }
        });

        edit_ledger.setText("Edit/Delete");
        edit_ledger.setBorderPainted(false);
        edit_ledger.setContentAreaFilled(false);
        edit_ledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_ledgerActionPerformed(evt);
            }
        });

        back_ledger.setText("Back");
        back_ledger.setBorderPainted(false);
        back_ledger.setContentAreaFilled(false);
        back_ledger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ledgerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ledger_createLayout = new javax.swing.GroupLayout(ledger_create.getContentPane());
        ledger_create.getContentPane().setLayout(ledger_createLayout);
        ledger_createLayout.setHorizontalGroup(
            ledger_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(create_ledger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edit_ledger, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(back_ledger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ledger_createLayout.setVerticalGroup(
            ledger_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ledger_createLayout.createSequentialGroup()
                .addComponent(create_ledger)
                .addGap(38, 38, 38)
                .addComponent(edit_ledger)
                .addGap(47, 47, 47)
                .addComponent(back_ledger)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        inventory_master.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        inventory_master.setTitle("Inventory Master");
        inventory_master.setPreferredSize(new java.awt.Dimension(175, 307));
        inventory_master.setVisible(true);
        KeyStroke escape8 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action8 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                menu.setVisible(true);

                inventory_master.setVisible(false);
                try
                {
                    menu.setSelected(true);
                }
                catch(Exception we)
                {
                }
            }

        };

        inventory_master.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape8, "escape");
        inventory_master.getActionMap().put("escape", action8);

        inventory_master_product_group.setText("Product Group");
        inventory_master_product_group.setBorderPainted(false);
        inventory_master_product_group.setContentAreaFilled(false);
        inventory_master_product_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_master_product_groupActionPerformed(evt);
            }
        });

        inventory_master_unit.setText("Unit");
        inventory_master_unit.setBorderPainted(false);
        inventory_master_unit.setContentAreaFilled(false);
        inventory_master_unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_master_unitActionPerformed(evt);
            }
        });

        inventory_master_product.setText("Product");
        inventory_master_product.setBorderPainted(false);
        inventory_master_product.setContentAreaFilled(false);
        inventory_master_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_master_productActionPerformed(evt);
            }
        });

        inventory_master_godown.setText("Godown");
        inventory_master_godown.setBorderPainted(false);
        inventory_master_godown.setContentAreaFilled(false);
        inventory_master_godown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_master_godownActionPerformed(evt);
            }
        });

        inventory_master_back.setText("Back");
        inventory_master_back.setBorderPainted(false);
        inventory_master_back.setContentAreaFilled(false);
        inventory_master_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_master_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inventory_masterLayout = new javax.swing.GroupLayout(inventory_master.getContentPane());
        inventory_master.getContentPane().setLayout(inventory_masterLayout);
        inventory_masterLayout.setHorizontalGroup(
            inventory_masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inventory_master_product_group, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(inventory_master_unit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventory_master_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventory_master_godown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventory_master_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inventory_masterLayout.setVerticalGroup(
            inventory_masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_masterLayout.createSequentialGroup()
                .addComponent(inventory_master_product_group)
                .addGap(42, 42, 42)
                .addComponent(inventory_master_unit)
                .addGap(45, 45, 45)
                .addComponent(inventory_master_product)
                .addGap(41, 41, 41)
                .addComponent(inventory_master_godown)
                .addGap(33, 33, 33)
                .addComponent(inventory_master_back)
                .addGap(0, 183, Short.MAX_VALUE))
        );

        account_master.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        account_master.setTitle("Account Master");
        account_master.setPreferredSize(new java.awt.Dimension(175, 263));
        account_master.setVisible(true);

        account_master_group.setText("Group");
        account_master_group.setBorderPainted(false);
        account_master_group.setContentAreaFilled(false);
        account_master_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_master_groupActionPerformed(evt);
            }
        });

        account_master_party.setText("Party");
        account_master_party.setBorderPainted(false);
        account_master_party.setContentAreaFilled(false);
        account_master_party.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_master_partyActionPerformed(evt);
            }
        });

        account_master_back.setText("Back");
        account_master_back.setBorderPainted(false);
        account_master_back.setContentAreaFilled(false);
        account_master_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_master_backActionPerformed(evt);
            }
        });

        ledger_button.setText("Ledger");
        ledger_button.setBorderPainted(false);
        ledger_button.setContentAreaFilled(false);
        ledger_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledger_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout account_masterLayout = new javax.swing.GroupLayout(account_master.getContentPane());
        account_master.getContentPane().setLayout(account_masterLayout);
        account_masterLayout.setHorizontalGroup(
            account_masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(account_master_group, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ledger_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(account_master_party, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(account_master_back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        account_masterLayout.setVerticalGroup(
            account_masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_masterLayout.createSequentialGroup()
                .addComponent(ledger_button)
                .addGap(43, 43, 43)
                .addComponent(account_master_group)
                .addGap(43, 43, 43)
                .addComponent(account_master_party)
                .addGap(43, 43, 43)
                .addComponent(account_master_back)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        product_group.setTitle("Product Group");
        product_group.setPreferredSize(new java.awt.Dimension(175, 185));
        product_group.setVisible(true);

        product_group_create_button.setText("Create");
        product_group_create_button.setBorderPainted(false);
        product_group_create_button.setContentAreaFilled(false);
        product_group_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_group_create_buttonActionPerformed(evt);
            }
        });

        product_group_edit_button.setText("Edit/Delete");
        product_group_edit_button.setBorderPainted(false);
        product_group_edit_button.setContentAreaFilled(false);
        product_group_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_group_edit_buttonActionPerformed(evt);
            }
        });

        product_group_back_button.setText("Back");
        product_group_back_button.setBorderPainted(false);
        product_group_back_button.setContentAreaFilled(false);
        product_group_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_group_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout product_groupLayout = new javax.swing.GroupLayout(product_group.getContentPane());
        product_group.getContentPane().setLayout(product_groupLayout);
        product_groupLayout.setHorizontalGroup(
            product_groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_group_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product_group_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(product_group_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        product_groupLayout.setVerticalGroup(
            product_groupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_groupLayout.createSequentialGroup()
                .addComponent(product_group_create_button)
                .addGap(38, 38, 38)
                .addComponent(product_group_edit_button)
                .addGap(47, 47, 47)
                .addComponent(product_group_back_button)
                .addGap(0, 305, Short.MAX_VALUE))
        );

        payment_create.setTitle("Payment");
        payment_create.setPreferredSize(new java.awt.Dimension(175, 253));
        payment_create.setVisible(true);

        payment_create_button.setText("Create");
        payment_create_button.setBorderPainted(false);
        payment_create_button.setContentAreaFilled(false);
        payment_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_create_buttonActionPerformed(evt);
            }
        });

        payment_edit_button.setText("Edit/Delete");
        payment_edit_button.setBorderPainted(false);
        payment_edit_button.setContentAreaFilled(false);
        payment_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_edit_buttonActionPerformed(evt);
            }
        });

        payment_back_button.setText("Back");
        payment_back_button.setBorderPainted(false);
        payment_back_button.setContentAreaFilled(false);
        payment_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_back_buttonActionPerformed(evt);
            }
        });

        payment_print_button.setText("Print");
        payment_print_button.setBorderPainted(false);
        payment_print_button.setContentAreaFilled(false);
        payment_print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_print_buttonActionPerformed(evt);
            }
        });

        payment_details_button.setText("Payment Detail");
        payment_details_button.setBorderPainted(false);
        payment_details_button.setContentAreaFilled(false);
        payment_details_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_details_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout payment_createLayout = new javax.swing.GroupLayout(payment_create.getContentPane());
        payment_create.getContentPane().setLayout(payment_createLayout);
        payment_createLayout.setHorizontalGroup(
            payment_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(payment_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_print_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_details_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(payment_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        payment_createLayout.setVerticalGroup(
            payment_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payment_createLayout.createSequentialGroup()
                .addComponent(payment_create_button)
                .addGap(29, 29, 29)
                .addComponent(payment_edit_button)
                .addGap(18, 18, 18)
                .addComponent(payment_print_button)
                .addGap(31, 31, 31)
                .addComponent(payment_details_button)
                .addGap(18, 18, 18)
                .addComponent(payment_back_button)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        receipt_create.setTitle("Receipt");
        receipt_create.setPreferredSize(new java.awt.Dimension(175, 246));
        receipt_create.setVisible(true);

        receipt_create_button.setText("Create");
        receipt_create_button.setBorderPainted(false);
        receipt_create_button.setContentAreaFilled(false);
        receipt_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_create_buttonActionPerformed(evt);
            }
        });

        receipt_edit_button.setText("Edit/Delete");
        receipt_edit_button.setBorderPainted(false);
        receipt_edit_button.setContentAreaFilled(false);
        receipt_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_edit_buttonActionPerformed(evt);
            }
        });

        receipt_back_button.setText("Back");
        receipt_back_button.setBorderPainted(false);
        receipt_back_button.setContentAreaFilled(false);
        receipt_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_back_buttonActionPerformed(evt);
            }
        });

        receipt_details_button.setText("Receipt Detail");
        receipt_details_button.setBorderPainted(false);
        receipt_details_button.setContentAreaFilled(false);
        receipt_details_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_details_buttonActionPerformed(evt);
            }
        });

        receipt_print_button.setText("Print");
        receipt_print_button.setBorderPainted(false);
        receipt_print_button.setContentAreaFilled(false);
        receipt_print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_print_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receipt_createLayout = new javax.swing.GroupLayout(receipt_create.getContentPane());
        receipt_create.getContentPane().setLayout(receipt_createLayout);
        receipt_createLayout.setHorizontalGroup(
            receipt_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receipt_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_print_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_details_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(receipt_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        receipt_createLayout.setVerticalGroup(
            receipt_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receipt_createLayout.createSequentialGroup()
                .addComponent(receipt_create_button)
                .addGap(35, 35, 35)
                .addComponent(receipt_edit_button)
                .addGap(18, 18, 18)
                .addComponent(receipt_print_button)
                .addGap(32, 32, 32)
                .addComponent(receipt_details_button)
                .addGap(18, 18, 18)
                .addComponent(receipt_back_button)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        journal_create.setTitle("Journal");
        journal_create.setPreferredSize(new java.awt.Dimension(175, 256));
        journal_create.setVisible(true);

        journal_create_button.setText("Create");
        journal_create_button.setBorderPainted(false);
        journal_create_button.setContentAreaFilled(false);
        journal_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_create_buttonActionPerformed(evt);
            }
        });

        journal_edit_button.setText("Edit/Delete");
        journal_edit_button.setBorderPainted(false);
        journal_edit_button.setContentAreaFilled(false);
        journal_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_edit_buttonActionPerformed(evt);
            }
        });

        journal_back_button.setText("Back");
        journal_back_button.setBorderPainted(false);
        journal_back_button.setContentAreaFilled(false);
        journal_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout journal_createLayout = new javax.swing.GroupLayout(journal_create.getContentPane());
        journal_create.getContentPane().setLayout(journal_createLayout);
        journal_createLayout.setHorizontalGroup(
            journal_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(journal_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(journal_edit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(journal_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        journal_createLayout.setVerticalGroup(
            journal_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(journal_createLayout.createSequentialGroup()
                .addComponent(journal_create_button)
                .addGap(38, 38, 38)
                .addComponent(journal_edit_button)
                .addGap(47, 47, 47)
                .addComponent(journal_back_button)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        stock_transfer.setTitle("Stock Transfer");
        stock_transfer.setPreferredSize(new java.awt.Dimension(175, 208));
        stock_transfer.setVisible(true);

        stock_transfer_create_button.setText("Create");
        stock_transfer_create_button.setBorderPainted(false);
        stock_transfer_create_button.setContentAreaFilled(false);
        stock_transfer_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_transfer_create_buttonActionPerformed(evt);
            }
        });

        stock_transfer_alter_button.setText("Alter");
        stock_transfer_alter_button.setBorderPainted(false);
        stock_transfer_alter_button.setContentAreaFilled(false);
        stock_transfer_alter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_transfer_alter_buttonActionPerformed(evt);
            }
        });

        stock_transferl_back_button.setText("Back");
        stock_transferl_back_button.setBorderPainted(false);
        stock_transferl_back_button.setContentAreaFilled(false);
        stock_transferl_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_transferl_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stock_transferLayout = new javax.swing.GroupLayout(stock_transfer.getContentPane());
        stock_transfer.getContentPane().setLayout(stock_transferLayout);
        stock_transferLayout.setHorizontalGroup(
            stock_transferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stock_transfer_create_button, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(stock_transfer_alter_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stock_transferl_back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        stock_transferLayout.setVerticalGroup(
            stock_transferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_transferLayout.createSequentialGroup()
                .addComponent(stock_transfer_create_button)
                .addGap(38, 38, 38)
                .addComponent(stock_transfer_alter_button)
                .addGap(47, 47, 47)
                .addComponent(stock_transferl_back_button)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        fund_transfer.setTitle("Fund Transfer");
        fund_transfer.setPreferredSize(new java.awt.Dimension(175, 180));
        fund_transfer.setVisible(true);

        create_fund_transfer_button.setText("Create");
        create_fund_transfer_button.setBorderPainted(false);
        create_fund_transfer_button.setContentAreaFilled(false);
        create_fund_transfer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_fund_transfer_buttonActionPerformed(evt);
            }
        });

        alter_fund_transfer_button.setText("Alter");
        alter_fund_transfer_button.setToolTipText("");
        alter_fund_transfer_button.setBorderPainted(false);
        alter_fund_transfer_button.setContentAreaFilled(false);
        alter_fund_transfer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alter_fund_transfer_buttonActionPerformed(evt);
            }
        });

        back_fund_transferl_button.setText("Back");
        back_fund_transferl_button.setBorderPainted(false);
        back_fund_transferl_button.setContentAreaFilled(false);
        back_fund_transferl_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_fund_transferl_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fund_transferLayout = new javax.swing.GroupLayout(fund_transfer.getContentPane());
        fund_transfer.getContentPane().setLayout(fund_transferLayout);
        fund_transferLayout.setHorizontalGroup(
            fund_transferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(create_fund_transfer_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(alter_fund_transfer_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(back_fund_transferl_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fund_transferLayout.setVerticalGroup(
            fund_transferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fund_transferLayout.createSequentialGroup()
                .addComponent(create_fund_transfer_button)
                .addGap(43, 43, 43)
                .addComponent(alter_fund_transfer_button)
                .addGap(44, 44, 44)
                .addComponent(back_fund_transferl_button)
                .addGap(0, 303, Short.MAX_VALUE))
        );

        opening_stock.setTitle("Opening Stock");
        opening_stock.setPreferredSize(new java.awt.Dimension(175, 183));
        opening_stock.setVisible(true);

        opening_stock_create_button.setText("Create");
        opening_stock_create_button.setBorderPainted(false);
        opening_stock_create_button.setContentAreaFilled(false);
        opening_stock_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opening_stock_create_buttonActionPerformed(evt);
            }
        });

        opening_stock_edit_button.setText("Edit/Delete");
        opening_stock_edit_button.setBorderPainted(false);
        opening_stock_edit_button.setContentAreaFilled(false);
        opening_stock_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opening_stock_edit_buttonActionPerformed(evt);
            }
        });

        opening_stock_back_button.setText("Back");
        opening_stock_back_button.setBorderPainted(false);
        opening_stock_back_button.setContentAreaFilled(false);
        opening_stock_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opening_stock_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opening_stockLayout = new javax.swing.GroupLayout(opening_stock.getContentPane());
        opening_stock.getContentPane().setLayout(opening_stockLayout);
        opening_stockLayout.setHorizontalGroup(
            opening_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opening_stock_create_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opening_stock_edit_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(opening_stock_back_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opening_stockLayout.setVerticalGroup(
            opening_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opening_stockLayout.createSequentialGroup()
                .addComponent(opening_stock_create_button)
                .addGap(40, 40, 40)
                .addComponent(opening_stock_edit_button)
                .addGap(43, 43, 43)
                .addComponent(opening_stock_back_button)
                .addGap(0, 307, Short.MAX_VALUE))
        );

        reminder_create.setTitle("Reminder");
        reminder_create.setPreferredSize(new java.awt.Dimension(175, 231));
        reminder_create.setVisible(true);

        reminder_create_button.setText("Create");
        reminder_create_button.setBorderPainted(false);
        reminder_create_button.setContentAreaFilled(false);
        reminder_create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_create_buttonActionPerformed(evt);
            }
        });

        reminder_edit_button.setText("Edit/Delete");
        reminder_edit_button.setBorderPainted(false);
        reminder_edit_button.setContentAreaFilled(false);
        reminder_edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_edit_buttonActionPerformed(evt);
            }
        });

        reminder_back_button.setText("Back");
        reminder_back_button.setBorderPainted(false);
        reminder_back_button.setContentAreaFilled(false);
        reminder_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_back_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reminder_createLayout = new javax.swing.GroupLayout(reminder_create.getContentPane());
        reminder_create.getContentPane().setLayout(reminder_createLayout);
        reminder_createLayout.setHorizontalGroup(
            reminder_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reminder_create_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reminder_edit_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(reminder_back_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reminder_createLayout.setVerticalGroup(
            reminder_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reminder_createLayout.createSequentialGroup()
                .addComponent(reminder_create_button)
                .addGap(38, 38, 38)
                .addComponent(reminder_edit_button)
                .addGap(45, 45, 45)
                .addComponent(reminder_back_button)
                .addGap(0, 307, Short.MAX_VALUE))
        );

        profit_loss_menu.setTitle("Profit Loss A/C");
        profit_loss_menu.setPreferredSize(new java.awt.Dimension(175, 486));
        profit_loss_menu.setVisible(true);

        profit_loss_horizontal.setText("Profit & Loss Horizontal");
        profit_loss_horizontal.setBorderPainted(false);
        profit_loss_horizontal.setContentAreaFilled(false);

        profit_loss_vertical.setText("Profit & Loss Vertical");
        profit_loss_vertical.setBorderPainted(false);
        profit_loss_vertical.setContentAreaFilled(false);

        profit_loss_vertical1.setText("Back");
        profit_loss_vertical1.setBorderPainted(false);
        profit_loss_vertical1.setContentAreaFilled(false);

        javax.swing.GroupLayout profit_loss_menuLayout = new javax.swing.GroupLayout(profit_loss_menu.getContentPane());
        profit_loss_menu.getContentPane().setLayout(profit_loss_menuLayout);
        profit_loss_menuLayout.setHorizontalGroup(
            profit_loss_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profit_loss_horizontal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(profit_loss_vertical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profit_loss_vertical1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profit_loss_menuLayout.setVerticalGroup(
            profit_loss_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profit_loss_menuLayout.createSequentialGroup()
                .addComponent(profit_loss_horizontal)
                .addGap(18, 18, 18)
                .addComponent(profit_loss_vertical)
                .addGap(18, 18, 18)
                .addComponent(profit_loss_vertical1)
                .addGap(0, 354, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reminder_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opening_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fund_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stock_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(journal_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(receipt_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payment_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sale_create_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchase_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(godown_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(product_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unit_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(product_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vendor_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customer_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customer_vendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(group_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ledger_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profit_loss_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventory_master, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(account_master, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {account_master, customer_create, customer_vendor, fund_transfer, godown_create, group_create, inventory_master, journal_create, ledger_create, menu, opening_stock, payment_create, product_create, product_group, profit_loss_menu, purchase_create, receipt_create, reminder_create, report, sale_create_menu, stock_transfer, transaction, unit_create, vendor_create});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(account_master, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(inventory_master, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(ledger_create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(payment_create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(receipt_create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(journal_create, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(transaction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(report, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(profit_loss_menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reminder_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opening_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fund_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sale_create_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purchase_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(godown_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unit_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_group, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vendor_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customer_vendor, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(group_create, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {account_master, customer_create, customer_vendor, fund_transfer, godown_create, group_create, inventory_master, journal_create, ledger_create, menu, opening_stock, payment_create, product_create, product_group, profit_loss_menu, purchase_create, receipt_create, reminder_create, report, sale_create_menu, stock_transfer, transaction, unit_create, vendor_create});

        KeyStroke escape15 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action15 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                sale_create_menu.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        sale_create_menu.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape15, "escape");
        sale_create_menu.getActionMap().put("escape", action15);
        KeyStroke escape14 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action14 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                purchase_create.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        purchase_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape14, "escape");
        purchase_create.getActionMap().put("escape", action14);
        KeyStroke escape12 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action12 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                godown_create.setVisible(false);

                inventory_master.setVisible(true);
                try
                {
                    inventory_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        godown_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape12, "escape");
        godown_create.getActionMap().put("escape", action12);
        KeyStroke escape11 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action11 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                product_create.setVisible(false);

                inventory_master.setVisible(true);
                try
                {
                    inventory_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        product_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape11, "escape");
        product_create.getActionMap().put("escape", action11);
        KeyStroke escape10 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action10 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                unit_create.setVisible(false);

                inventory_master.setVisible(true);
                try
                {
                    inventory_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        unit_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape10, "escape");
        unit_create.getActionMap().put("escape", action10);
        KeyStroke escape7 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action7 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                vendor_create.setVisible(false);

                customer_vendor.setVisible(true);
                try
                {
                    customer_vendor.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        vendor_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape7, "escape");
        vendor_create.getActionMap().put("escape", action7);
        KeyStroke escape5 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action5 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                customer_create.setVisible(false);

                customer_vendor.setVisible(true);
                try
                {
                    customer_vendor.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        customer_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape5, "escape");
        customer_create.getActionMap().put("escape", action5);
        KeyStroke escape22 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action22 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                menu.setVisible(true);

                report.setVisible(false);

                try
                {
                    menu.setSelected(true);
                }
                catch(Exception dwe)
                {
                }
            }

        };

        report.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape22, "escape");
        report.getActionMap().put("escape", action22);
        KeyStroke escape4 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action4 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                customer_vendor.setVisible(false);

                account_master.setVisible(true);
                try
                {
                    account_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        customer_vendor.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape4, "escape");
        customer_vendor.getActionMap().put("escape", action4);
        KeyStroke escape13 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action13 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                menu.setVisible(true);

                transaction.setVisible(false);
                try
                {
                    menu.setSelected(true);
                }
                catch(Exception dwe)
                {
                }
            }

        };

        transaction.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape13, "escape");
        transaction.getActionMap().put("escape", action13);
        KeyStroke escape3 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action3 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                group_create.setVisible(false);

                account_master.setVisible(true);
                try
                {
                    account_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        group_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape3, "escape");
        group_create.getActionMap().put("escape", action3);
        KeyStroke escape2 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action2 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                ledger_create.setVisible(false);

                account_master.setVisible(true);
                try
                {
                    account_master.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }

        };

        ledger_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape2, "escape");
        ledger_create.getActionMap().put("escape", action2);
        KeyStroke escape1 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action1 = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {

                menu.setVisible(true);

                account_master.setVisible(false);
                try
                {
                    menu.setSelected(true);
                }
                catch(Exception we)
                {
                }

            }

        };

        account_master.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape1, "escape");
        account_master.getActionMap().put("escape", action1);
        KeyStroke escape91 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action91 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                payment_create.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        payment_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape91, "escape");
        payment_create.getActionMap().put("escape", action91);
        KeyStroke escape17 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action17 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                receipt_create.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        receipt_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape17, "escape");
        receipt_create.getActionMap().put("escape", action17);
        KeyStroke escape18 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action18 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                journal_create.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        journal_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape18, "escape");
        journal_create.getActionMap().put("escape", action18);
        KeyStroke escape19 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action19 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                stock_transfer.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        stock_transfer.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape19, "escape");
        stock_transfer.getActionMap().put("escape", action19);
        KeyStroke escape20 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action20 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                fund_transfer.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        fund_transfer.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape20, "escape");
        fund_transfer.getActionMap().put("escape", action20);
        KeyStroke escape21 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action21 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyy) {

                opening_stock.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        opening_stock.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape21, "escape");
        opening_stock.getActionMap().put("escape", action21);
        KeyStroke escape25 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action action25 = new AbstractAction() {
            public void actionPerformed(ActionEvent eyys) {

                reminder_create.setVisible(false);

                transaction.setVisible(true);
                try
                {
                    transaction.setSelected(true);
                }
                catch(Exception e)
                {
                }
            }
        };

        reminder_create.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape25, "escape");
        reminder_create.getActionMap().put("escape", action25);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        //Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        // int a=(int)Math.round(center.x*1.6);
        // int b=(int)Math.round(center.y*1.6);
        // int c=(int)Math.round(center.x*0.01);
        // int d=(int)Math.round(center.y*0.3);
        // jPanel4.setPreferredSize(new Dimension(a,b));
        //jPanel4.setLocation(c,d);
        //  jPanel4.setBounds(c,d,a,b);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ledger_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ledger_create_short.setText("Ledger Create-Alt+F1");
        ledger_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ledger_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledger_create_shortActionPerformed(evt);
            }
        });

        ledger_group_short.setText("Group Create-Alt+F2");
        ledger_group_short.setActionCommand("");
        ledger_group_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ledger_group_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledger_group_shortActionPerformed(evt);
            }
        });

        ledger_edit_delete_short.setText("Ledger Edit/Delete-Alt+L");
        ledger_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ledger_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledger_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ledger_short_panelLayout = new javax.swing.GroupLayout(ledger_short_panel);
        ledger_short_panel.setLayout(ledger_short_panelLayout);
        ledger_short_panelLayout.setHorizontalGroup(
            ledger_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ledger_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ledger_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(ledger_group_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ledger_short_panelLayout.setVerticalGroup(
            ledger_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ledger_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ledger_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ledger_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ledger_group_short, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ledger_short_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ledger_create_short, ledger_edit_delete_short, ledger_group_short});

        group_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        group_create_short.setText("Group Create-Alt+F2");
        group_create_short.setActionCommand("");
        group_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        group_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_create_shortActionPerformed(evt);
            }
        });

        group_edit_delete_short.setText("Group Edit/Delete-Alt+G");
        group_edit_delete_short.setActionCommand("");
        group_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        group_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout group_short_panelLayout = new javax.swing.GroupLayout(group_short_panel);
        group_short_panel.setLayout(group_short_panelLayout);
        group_short_panelLayout.setHorizontalGroup(
            group_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(group_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(group_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
        group_short_panelLayout.setVerticalGroup(
            group_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(group_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(group_create_short, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_edit_delete_short, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customer_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        customer_create_short.setText("Customer Create-Alt+F3");
        customer_create_short.setActionCommand("");
        customer_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customer_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_create_shortActionPerformed(evt);
            }
        });

        jButton1.setText("Customer Edit/Delete-Alt+C");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        customer_group_short.setText("Group Create-Alt+F2");
        customer_group_short.setActionCommand("");
        customer_group_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customer_group_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_group_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customer_short_panelLayout = new javax.swing.GroupLayout(customer_short_panel);
        customer_short_panel.setLayout(customer_short_panelLayout);
        customer_short_panelLayout.setHorizontalGroup(
            customer_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customer_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(customer_group_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        customer_short_panelLayout.setVerticalGroup(
            customer_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customer_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customer_group_short, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customer_short_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {customer_create_short, customer_group_short, jButton1});

        vendor_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        vendor_create_short.setText("Vendor Create-Alt+F4");
        vendor_create_short.setActionCommand("");
        vendor_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vendor_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_create_shortActionPerformed(evt);
            }
        });

        vendor_edit_delete_panel.setText("Vendor Edit/Delete-Alt+V");
        vendor_edit_delete_panel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vendor_edit_delete_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_edit_delete_panelActionPerformed(evt);
            }
        });

        vendor_group_short.setText("Group Create-Alt+F2");
        vendor_group_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vendor_group_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendor_group_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vendor_short_panelLayout = new javax.swing.GroupLayout(vendor_short_panel);
        vendor_short_panel.setLayout(vendor_short_panelLayout);
        vendor_short_panelLayout.setHorizontalGroup(
            vendor_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vendor_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vendor_edit_delete_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(vendor_group_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vendor_short_panelLayout.setVerticalGroup(
            vendor_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendor_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vendor_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendor_edit_delete_panel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendor_group_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        product_group_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        product_group_create_short.setText("Product Group Create-Alt+F5");
        product_group_create_short.setActionCommand("");
        product_group_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product_group_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_group_create_shortActionPerformed(evt);
            }
        });

        product_group_edit_delete_short.setText("Product Group Edit/Delete-Alt+P");
        product_group_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_group_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout product_group_short_panelLayout = new javax.swing.GroupLayout(product_group_short_panel);
        product_group_short_panel.setLayout(product_group_short_panelLayout);
        product_group_short_panelLayout.setHorizontalGroup(
            product_group_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_group_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product_group_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
        product_group_short_panelLayout.setVerticalGroup(
            product_group_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_group_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_group_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_group_edit_delete_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        unit_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        unit_create_short.setText("Unit Create-Alt+F6");
        unit_create_short.setActionCommand("");
        unit_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        unit_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unit_create_shortActionPerformed(evt);
            }
        });

        jButton2.setText("Unit Edit/Delete-Alt+U");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout unit_short_panelLayout = new javax.swing.GroupLayout(unit_short_panel);
        unit_short_panel.setLayout(unit_short_panelLayout);
        unit_short_panelLayout.setHorizontalGroup(
            unit_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(unit_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
        unit_short_panelLayout.setVerticalGroup(
            unit_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(unit_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(unit_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        product_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        product_create_short.setText("Product Create-Alt+F7");
        product_create_short.setActionCommand("");
        product_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_create_shortActionPerformed(evt);
            }
        });

        product_edit_delete_short.setText("Product Edit/Delete-Alt+Ctrl+P");
        product_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_edit_delete_shortActionPerformed(evt);
            }
        });

        product_product_group_short.setText("Product Group Create-Alt+F5");
        product_product_group_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product_product_group_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_product_group_shortActionPerformed(evt);
            }
        });

        product_unit_short.setText("Unit Create-Alt+F6");
        product_unit_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        product_unit_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_unit_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout product_short_panelLayout = new javax.swing.GroupLayout(product_short_panel);
        product_short_panel.setLayout(product_short_panelLayout);
        product_short_panelLayout.setHorizontalGroup(
            product_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(product_product_group_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(product_unit_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        product_short_panelLayout.setVerticalGroup(
            product_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_product_group_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_unit_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        godown_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        godown_create_short.setText("Godown Create-Alt+F8");
        godown_create_short.setActionCommand("");
        godown_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        godown_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_create_shortActionPerformed(evt);
            }
        });

        godown_edit_delete_short.setText("Godown Edit/Delete-Alt+Ctrl+G");
        godown_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        godown_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                godown_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout godown_short_panelLayout = new javax.swing.GroupLayout(godown_short_panel);
        godown_short_panel.setLayout(godown_short_panelLayout);
        godown_short_panelLayout.setHorizontalGroup(
            godown_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(godown_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(godown_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
        godown_short_panelLayout.setVerticalGroup(
            godown_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(godown_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(godown_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(godown_edit_delete_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        purchase_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        purchase_edit_delete_short.setText("Purchase Edit/Delete-Alt+Shift+P");
        purchase_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchase_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_edit_delete_shortActionPerformed(evt);
            }
        });

        purchase_product_short.setText("Product Create-Alt+F7");
        purchase_product_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchase_product_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_product_shortActionPerformed(evt);
            }
        });

        purchase_unit_short.setText("Unit Create-Alt+F6");
        purchase_unit_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchase_unit_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_unit_shortActionPerformed(evt);
            }
        });

        purchase_ledger_short.setText("Ledger Create-Alt+F1");
        purchase_ledger_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchase_ledger_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_ledger_shortActionPerformed(evt);
            }
        });

        purchase_create_short.setText("Purchase Create-Alt+F9");
        purchase_create_short.setActionCommand("");
        purchase_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        purchase_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_create_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout purchase_short_panelLayout = new javax.swing.GroupLayout(purchase_short_panel);
        purchase_short_panel.setLayout(purchase_short_panelLayout);
        purchase_short_panelLayout.setHorizontalGroup(
            purchase_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchase_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(purchase_product_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purchase_unit_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purchase_ledger_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(purchase_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        purchase_short_panelLayout.setVerticalGroup(
            purchase_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchase_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(purchase_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(purchase_ledger_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchase_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchase_product_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchase_unit_short)
                .addGap(4, 4, 4))
        );

        sale_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sale_create_short.setText("Sale Create-Alt+F10");
        sale_create_short.setActionCommand("");
        sale_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_create_shortActionPerformed(evt);
            }
        });

        sale_customer_short.setText("Customer Create-Alt+F3");
        sale_customer_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_customer_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_customer_shortActionPerformed(evt);
            }
        });

        sale_vendor_short.setText("Vendor Create-Alt+F4");
        sale_vendor_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_vendor_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_vendor_shortActionPerformed(evt);
            }
        });

        sale_ledger_short.setText("Ledger Create-Alt+F1");
        sale_ledger_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_ledger_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_ledger_shortActionPerformed(evt);
            }
        });

        sale_godown_short.setText("Godown Create-Alt+F8");
        sale_godown_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_godown_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_godown_shortActionPerformed(evt);
            }
        });

        sale_edit_delete_short.setText("Sale Edit/Delete-Alt+S");
        sale_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_edit_delete_shortActionPerformed(evt);
            }
        });

        sale_print_short.setText("Sale Print-Alt+S+P");
        sale_print_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_print_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_print_shortActionPerformed(evt);
            }
        });

        sale_detail_short.setText("Sale Detail-Alt+S+D");
        sale_detail_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sale_detail_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_detail_shortActionPerformed(evt);
            }
        });

        sold_item_detail_short.setText("Sold Item Detail-Alt+S+I");
        sold_item_detail_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sold_item_detail_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sold_item_detail_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sale_short_panelLayout = new javax.swing.GroupLayout(sale_short_panel);
        sale_short_panel.setLayout(sale_short_panelLayout);
        sale_short_panelLayout.setHorizontalGroup(
            sale_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sale_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_customer_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(sale_vendor_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_ledger_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_godown_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_print_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sale_detail_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sold_item_detail_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sale_short_panelLayout.setVerticalGroup(
            sale_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sale_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sale_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_print_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_detail_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sold_item_detail_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_customer_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_vendor_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_ledger_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_godown_short)
                .addContainerGap())
        );

        payment_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        payment_create_short.setText("Payment Create-Alt+F11");
        payment_create_short.setActionCommand("");
        payment_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        payment_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_create_shortActionPerformed(evt);
            }
        });

        payment_edit_delete_short.setText("Payment Edit/Delete-Ctrl+Shift+P");
        payment_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        payment_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_edit_delete_shortActionPerformed(evt);
            }
        });

        payment_print_short.setText("Payment Print-Shift+P");
        payment_print_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        payment_print_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_print_shortActionPerformed(evt);
            }
        });

        payment_details_short.setText("Payment Details-Alt+P+D");
        payment_details_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        payment_details_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_details_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout payment_short_panelLayout = new javax.swing.GroupLayout(payment_short_panel);
        payment_short_panel.setLayout(payment_short_panelLayout);
        payment_short_panelLayout.setHorizontalGroup(
            payment_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(payment_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_print_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(payment_details_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        payment_short_panelLayout.setVerticalGroup(
            payment_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payment_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(payment_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payment_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payment_print_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payment_details_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        receipt_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        receipt_create_short.setText("Receipt Create-Alt+F12");
        receipt_create_short.setActionCommand("");
        receipt_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receipt_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_create_shortActionPerformed(evt);
            }
        });

        receipt_edit_delete_short.setText("Receipt Edit/Delete-Alt+R");
        receipt_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        receipt_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receipt_edit_delete_shortActionPerformed(evt);
            }
        });

        receipt_print_short.setText("Receipt Print-Alt+R+P");
        receipt_print_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        receipt_details_short.setText("Receipt Details-Alt+R+D");
        receipt_details_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout receipt_short_panelLayout = new javax.swing.GroupLayout(receipt_short_panel);
        receipt_short_panel.setLayout(receipt_short_panelLayout);
        receipt_short_panelLayout.setHorizontalGroup(
            receipt_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receipt_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(receipt_print_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receipt_details_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        receipt_short_panelLayout.setVerticalGroup(
            receipt_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receipt_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(receipt_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receipt_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receipt_print_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receipt_details_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        journal_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        journal_create_short.setText("Journal Create-Ctrl+F1");
        journal_create_short.setActionCommand("");
        journal_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        journal_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_create_shortActionPerformed(evt);
            }
        });

        journal_edit_delete_short.setText("Journal Edit/Delete-Alt+J");
        journal_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        journal_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_edit_delete_shortActionPerformed(evt);
            }
        });

        journal_ledger_short.setText("Ledger Create-Alt+F1");
        journal_ledger_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        journal_ledger_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journal_ledger_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout journal_short_panelLayout = new javax.swing.GroupLayout(journal_short_panel);
        journal_short_panel.setLayout(journal_short_panelLayout);
        journal_short_panelLayout.setHorizontalGroup(
            journal_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(journal_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(journal_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(journal_ledger_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        journal_short_panelLayout.setVerticalGroup(
            journal_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(journal_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(journal_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(journal_edit_delete_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(journal_ledger_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stock_transfer_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        stock_transfer_create_short.setText("Stock Transfer Create-Ctrl+F2");
        stock_transfer_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stock_transfer_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_transfer_create_shortActionPerformed(evt);
            }
        });

        stock_transfer_alter_short.setText("Stock Transfer Alter-Alt+S+A");
        stock_transfer_alter_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout stock_transfer_panelLayout = new javax.swing.GroupLayout(stock_transfer_panel);
        stock_transfer_panel.setLayout(stock_transfer_panelLayout);
        stock_transfer_panelLayout.setHorizontalGroup(
            stock_transfer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stock_transfer_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(stock_transfer_alter_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        stock_transfer_panelLayout.setVerticalGroup(
            stock_transfer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_transfer_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stock_transfer_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stock_transfer_alter_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fund_transfer_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        fund_transfer_create_short.setText("Fund Transfer Create-Ctrl+F3");
        fund_transfer_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fund_transfer_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fund_transfer_create_shortActionPerformed(evt);
            }
        });

        fund_transfer_alter_short.setText("Fund Transfer Alter-Alt+F+A");
        fund_transfer_alter_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout fund_transfer_panelLayout = new javax.swing.GroupLayout(fund_transfer_panel);
        fund_transfer_panel.setLayout(fund_transfer_panelLayout);
        fund_transfer_panelLayout.setHorizontalGroup(
            fund_transfer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fund_transfer_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fund_transfer_alter_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fund_transfer_panelLayout.setVerticalGroup(
            fund_transfer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fund_transfer_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fund_transfer_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fund_transfer_alter_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opening_stock_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setText("Opening Stock Create-Ctrl+F4");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        opening_stock_edit_delete_short.setText("Opening Stock Edit/Delete-Alt+O");
        opening_stock_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opening_stock_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opening_stock_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opening_stock_panelLayout = new javax.swing.GroupLayout(opening_stock_panel);
        opening_stock_panel.setLayout(opening_stock_panelLayout);
        opening_stock_panelLayout.setHorizontalGroup(
            opening_stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opening_stock_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opening_stock_panelLayout.setVerticalGroup(
            opening_stock_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opening_stock_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opening_stock_edit_delete_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reminder_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        reminder_create_short.setText("Reminder Create-Ctrl+F5");
        reminder_create_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reminder_create_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_create_shortActionPerformed(evt);
            }
        });

        reminder_edit_delete_short.setText("Reminder Edit/Delete-Ctrl+R");
        reminder_edit_delete_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reminder_edit_delete_short.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reminder_edit_delete_shortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reminder_short_panelLayout = new javax.swing.GroupLayout(reminder_short_panel);
        reminder_short_panel.setLayout(reminder_short_panelLayout);
        reminder_short_panelLayout.setHorizontalGroup(
            reminder_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reminder_create_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reminder_edit_delete_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reminder_short_panelLayout.setVerticalGroup(
            reminder_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reminder_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reminder_create_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reminder_edit_delete_short)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu_short_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        demo1.setText("Date");
        demo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        demo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demo1ActionPerformed(evt);
            }
        });

        demo2.setText("Calculator");
        demo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        demo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demo2ActionPerformed(evt);
            }
        });

        accounting_master_short.setText("Accounting Master");
        accounting_master_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        inventory_master_short.setText("Inventory Master");
        inventory_master_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        transaction_short.setText("Transaction");
        transaction_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        reports_short.setText("Reports");
        reports_short.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout menu_short_panelLayout = new javax.swing.GroupLayout(menu_short_panel);
        menu_short_panel.setLayout(menu_short_panelLayout);
        menu_short_panelLayout.setHorizontalGroup(
            menu_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_short_panelLayout.createSequentialGroup()
                .addGroup(menu_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transaction_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(demo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(demo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accounting_master_short, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(inventory_master_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reports_short, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menu_short_panelLayout.setVerticalGroup(
            menu_short_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_short_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(demo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(demo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accounting_master_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventory_master_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaction_short)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(reports_short)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menu_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(godown_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unit_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(product_group_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vendor_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customer_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(group_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ledger_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchase_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sale_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payment_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receipt_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(journal_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stock_transfer_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fund_transfer_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opening_stock_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reminder_short_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {customer_short_panel, godown_short_panel, group_short_panel, journal_short_panel, ledger_short_panel, payment_short_panel, product_group_short_panel, product_short_panel, purchase_short_panel, receipt_short_panel, sale_short_panel, stock_transfer_panel, unit_short_panel, vendor_short_panel});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ledger_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(group_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customer_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendor_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_group_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unit_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(product_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(godown_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchase_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sale_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payment_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receipt_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(journal_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stock_transfer_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fund_transfer_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opening_stock_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reminder_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu_short_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin or User Login Panel"));

        jLabel1.setText("User Name:");

        jLabel7.setText("Password:");

        login_login.setText("Login");
        login_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_loginActionPerformed(evt);
            }
        });

        login_reset.setText("Reset");
        login_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(login_login)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(login_reset))
                            .addComponent(password)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_login)
                    .addComponent(login_reset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin or User Login Panel"));

        jLabel8.setText("User Name:");

        jLabel9.setText("Password:");

        login_login1.setText("Login");
        login_login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_login1ActionPerformed(evt);
            }
        });

        login_reset1.setText("Reset");
        login_reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_reset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(login_login1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(login_reset1))
                            .addComponent(password1)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addComponent(user_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(user_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_login1)
                    .addComponent(login_reset1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        System.out.println();
       
        if (i>0)
        {    
        System.out.println("Panel to Delete: "+i);
        
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
          //  jPanel6.setVisible(true);
          // ledger_create.setVisible(true);
        
        
        //jPanel4.remove(panelArray[i]);
       
        
        i--;
        System.out.println("Next Panel:"+i);


        jPanel4.setLayout(new BorderLayout());
   
        //jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
//        jPanel6.setLayout(new BorderLayout());
//         jPanel6.setVisible(true);
//          jPanel6.revalidate();
       
        
         
            jPanel4.repaint();
         jPanel4.revalidate();
         jPanel4.setVisible(true);
          //group_create_short.setEnabled(false);
          
           
              
     
        }  
         if(i==0)
        {
        jPanel6.setVisible(true);
        menu.setVisible(true);
        menu.setFocusable(true);
        menu_account_master.setFocusable(true);
        
        ledger_short_panel.setVisible(false);
        
        
        
         account_master.setVisible(false);
        inventory_master.setVisible(false);
        transaction.setVisible(false);
        report.setVisible(false);
        ledger_create.setVisible(false);
        group_create.setVisible(false);
        customer_vendor.setVisible(false);
        customer_create.setVisible(false);
        vendor_create.setVisible(false);
        product_group.setVisible(false);
        unit_create.setVisible(false);
        product_create.setVisible(false);
        godown_create.setVisible(false);
        purchase_create.setVisible(false);
        sale_create_menu.setVisible(false);
        payment_create.setVisible(false);
        receipt_create.setVisible(false);
        journal_create.setVisible(false);
        stock_transfer.setVisible(false);
        fund_transfer.setVisible(false);
        opening_stock.setVisible(false);
        reminder_create.setVisible(false);
        profit_loss_menu.setVisible(false);
            
        }
////                if(panelArray[i].isVisible())
////                {
////                    panelArray[i].setVisible(false);
////                    
////                    panelArray[i-1].setVisible(true);
////                    
////                   
////                    
////                }
////                 else {
////                    
////                    jPanel4.removeAll();
////                    menu.setVisible(true);
////                }
////                 
////                
////                
////                    System.out.println(i);
////                  jPanel4.remove(panelArray[i]);
////                  
////                  
////                  
////                  k=i-1;
////                  System.out.println(k);
////                  
////                 // jPanel4.setLayout(new BorderLayout());
////                  jPanel4.add(panelArray[k]);
////                  panelArray[k].setVisible(true);
////                  
////                  jPanel4.revalidate();
////                  jPanel4.setVisible(true);
////                  
////                  
////                   i--;
////               System.out.println(i);
//       
    }//GEN-LAST:event_jButton5ActionPerformed

  
    
    
    private void customer_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_create_shortActionPerformed
       System.out.println("Panel to Delete: "+i);
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel ccp=new customer_create_panel();
            panelArray[i]=ccp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);     
    }//GEN-LAST:event_customer_create_shortActionPerformed

    private void ledger_group_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledger_group_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        acc_group_create agc=new acc_group_create();
        panelArray[i]=agc;

            
                  // jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_ledger_group_shortActionPerformed

    private void vendor_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_vendor_create_shortActionPerformed

    private void product_group_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_group_create_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
        
    }//GEN-LAST:event_product_group_create_shortActionPerformed

    private void unit_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unit_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_unit_create_shortActionPerformed

    private void product_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_create_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_create_shortActionPerformed

    private void godown_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_godown_create_shortActionPerformed

    private void purchase_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_create_panel npcp=new normal_purchase_create_panel();
            panelArray[i]=npcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_purchase_create_shortActionPerformed

    private void sale_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_sale_create_shortActionPerformed

    private void payment_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_payment_create_shortActionPerformed

    private void receipt_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
     
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_create_panel rcp=new receipt_create_panel();
            panelArray[i]=rcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_receipt_create_shortActionPerformed

    private void journal_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Journal_panel jcp=new Journal_panel();
            panelArray[i]=jcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_journal_create_shortActionPerformed

    private void menu_account_masterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_account_masterActionPerformed
       esc_close();
        menu.setVisible(false);
    account_master.setVisible(true);
    
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_account_masterActionPerformed

    private void menu_inventory_masterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_inventory_masterActionPerformed
        // TODO add your handling code here:
        inventory_master.setVisible(true);
        menu.setVisible(false);
    }//GEN-LAST:event_menu_inventory_masterActionPerformed

    private void menu_transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_transactionActionPerformed
        // TODO add your handling code here:
        menu.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_menu_transactionActionPerformed

    private void menu_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_reportActionPerformed
        // TODO add your handling code here:
        report.setVisible(true);
        menu.setVisible(false);
    }//GEN-LAST:event_menu_reportActionPerformed

    private void sale_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_sale_create_buttonActionPerformed

    private void sale_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_sale_edit_buttonActionPerformed

    private void sale_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         sale_short_panel.setVisible(false);
        sale_create_menu.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_sale_back_buttonActionPerformed

    private void purchase_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_create_panel npcp=new normal_purchase_create_panel();
            panelArray[i]=npcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_purchase_create_buttonActionPerformed

    private void purchase_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_edit_panel_final npep=new normal_purchase_edit_panel_final();
            panelArray[i]=npep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_purchase_edit_buttonActionPerformed

    private void purchase_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        purchase_short_panel.setVisible(false);
        purchase_create.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_purchase_back_buttonActionPerformed

    private void godown_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_godown_create_buttonActionPerformed

    private void godown_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_edit_panel gep=new godown_edit_panel();
            panelArray[i]=gep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_godown_edit_buttonActionPerformed

    private void godown_back_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_back_button3ActionPerformed
 esc_close();        // TODO add your handling code here:
        godown_short_panel.setVisible(false);
        godown_create.setVisible(false);
        inventory_master.setVisible(true);
    }//GEN-LAST:event_godown_back_button3ActionPerformed

    private void product_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_create_buttonActionPerformed

    private void product_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_edit_panel ipep=new inventory_product_edit_panel();
            panelArray[i]=ipep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_edit_buttonActionPerformed

    private void product_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        product_short_panel.setVisible(false);
         product_create.setVisible(false);
        inventory_master.setVisible(true);
    }//GEN-LAST:event_product_back_buttonActionPerformed

    private void unit_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unit_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    }//GEN-LAST:event_unit_create_buttonActionPerformed

    private void unit_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unit_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_edit_panel iuep=new inventory_unit_edit_panel();
            panelArray[i]=iuep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    }//GEN-LAST:event_unit_edit_buttonActionPerformed

    private void unit_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unit_backActionPerformed
 esc_close();        // TODO add your handling code here:
        unit_short_panel.setVisible(false);
         unit_create.setVisible(false);
        inventory_master.setVisible(true);
    }//GEN-LAST:event_unit_backActionPerformed

    private void product_group_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_group_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
           System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_product_group_create_buttonActionPerformed

    private void product_group_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_group_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_edit_panel igcp=new inventory_group_edit_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
        
    }//GEN-LAST:event_product_group_edit_buttonActionPerformed

    private void product_group_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_group_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        product_group_short_panel.setVisible(false);
        product_group.setVisible(false);
        inventory_master.setVisible(true);
    }//GEN-LAST:event_product_group_back_buttonActionPerformed

    private void vendor_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
          System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_vendor_create_buttonActionPerformed

    private void vendor_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_edit_delete_panel vedp=new vendor_edit_delete_panel();
            panelArray[i]=vedp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_vendor_edit_buttonActionPerformed

    private void vendor_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        vendor_short_panel.setVisible(false);
        vendor_create.setVisible(false);
        customer_vendor.setVisible(true);
    }//GEN-LAST:event_vendor_back_buttonActionPerformed

    private void customer_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
         System.out.println("Panel to Delete: "+i);
        
       jPanel6.setVisible(false);
       
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel crp=new customer_create_panel();
       panelArray[i]=crp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
        
    }//GEN-LAST:event_customer_create_buttonActionPerformed

    private void customer_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_edit_panel cep=new customer_edit_panel();
       panelArray[i]=cep;
           
       
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_customer_edit_buttonActionPerformed

    private void customer_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        customer_short_panel.setVisible(false);
        customer_create.setVisible(false);
        customer_vendor.setVisible(true);
    }//GEN-LAST:event_customer_back_buttonActionPerformed

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        // TODO add your handling code here:
         esc_close();
        customer_shortcut();
        customer_short_panel.setVisible(true);
        customer_create.setVisible(true);
        customer_vendor.setVisible(false);
    }//GEN-LAST:event_customerActionPerformed

    private void vendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorActionPerformed
        // TODO add your handling code here:
         esc_close();
        vendor_shortcut();
        vendor_short_panel.setVisible(true);
        vendor_create.setVisible(true);
        customer_vendor.setVisible(false);
    }//GEN-LAST:event_vendorActionPerformed

    private void customer_vendor_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_vendor_backActionPerformed
 esc_close();        // TODO add your handling code here:
        customer_vendor.setVisible(false);
        account_master.setVisible(true);
    }//GEN-LAST:event_customer_vendor_backActionPerformed

    private void purchase_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_buttonActionPerformed
        // TODO add your handling code here:
        purchase_shortcut();
        purchase_short_panel.setVisible(true);
        purchase_create.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_purchase_buttonActionPerformed

    private void sale_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_buttonActionPerformed
        // TODO add your handling code here:
        sale_shortcut();
        sale_short_panel.setVisible(true);
        sale_create_menu.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_sale_buttonActionPerformed

    private void payment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_buttonActionPerformed
        // TODO add your handling code here:
        payment_shortcut();
         payment_short_panel.setVisible(true);
        payment_create.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_payment_buttonActionPerformed

    private void receipt_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_buttonActionPerformed
        // TODO add your handling code here:
        receipt_shortcut();
        receipt_short_panel.setVisible(true);
        receipt_create.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_receipt_buttonActionPerformed

    private void journal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_buttonActionPerformed
        // TODO add your handling code here:
        journal_shortcut();
        journal_short_panel.setVisible(true);
        journal_create.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_journal_buttonActionPerformed

    private void stock_transfer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_transfer_buttonActionPerformed
        // TODO add your handling code here:
        stock_transfer();
        stock_transfer_panel.setVisible(true);
        stock_transfer.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_stock_transfer_buttonActionPerformed

    private void fund_transfer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fund_transfer_buttonActionPerformed
        // TODO add your handling code here:
         fund_transfer();
        fund_transfer_panel.setVisible(true);
        fund_transfer.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_fund_transfer_buttonActionPerformed

    private void opening_stock_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opening_stock_buttonActionPerformed
        // TODO add your handling code here:
        opening_stock();
        opening_stock_panel.setVisible(true);
        opening_stock.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_opening_stock_buttonActionPerformed

    private void reminder_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_buttonActionPerformed
        // TODO add your handling code here:
        reminder_shortcut();
        reminder_short_panel.setVisible(true);
        reminder_create.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_reminder_buttonActionPerformed

    private void back_transaction_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_transaction_buttonActionPerformed
        // TODO add your handling code here:
        menu.setVisible(true);
        transaction.setVisible(false);
    }//GEN-LAST:event_back_transaction_buttonActionPerformed

    private void create_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_groupActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
        
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_create agc=new acc_group_create();
       panelArray[i]=agc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
        
        
        
        
        
//        System.out.println("Panel to Delete: "+i);
//        
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//        
//        
//        i++;    
//        System.out.println("Panel to add: "+i);
//        
//        acc_group_create agc=new acc_group_create();
//        panelArray[i]=agc;
//
//            
//                  // jPanel4.setLayout(new BorderLayout());
//        jPanel4.add(panelArray[i]);
//        panelArray[i].setVisible(true);
//       
//        jPanel4.revalidate();
//        jPanel4.setVisible(true);
      
    }//GEN-LAST:event_create_groupActionPerformed

    private void edit_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_groupActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_edit_delete_panel egl=new acc_group_edit_delete_panel();
       panelArray[i]=egl;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_edit_groupActionPerformed

    private void back_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_groupActionPerformed
        // TODO add your handling code here:
         esc_close();
        group_short_panel.setVisible(false);
        group_create.setVisible(false);
        account_master.setVisible(true);
    }//GEN-LAST:event_back_groupActionPerformed

    private void create_ledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_ledgerActionPerformed
        // TODO add your handling code here:
        esc_close();
        System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Ledger_create_panel lcp=new Ledger_create_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
       // esc_close();
    }//GEN-LAST:event_create_ledgerActionPerformed

    private void edit_ledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_ledgerActionPerformed
        // TODO add your handling code here:
       esc_close();
        System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
       ledger_edit_delete_panel lcp=new ledger_edit_delete_panel();
            panelArray[i]=lcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
    }//GEN-LAST:event_edit_ledgerActionPerformed

    private void back_ledgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ledgerActionPerformed
        // TODO add your handling code here:
         esc_close();
        ledger_short_panel.setVisible(false);
        account_master.setVisible(true);
        ledger_create.setVisible(false);
    }//GEN-LAST:event_back_ledgerActionPerformed

    private void inventory_master_product_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_master_product_groupActionPerformed
        // TODO add your handling code here:
        product_group_shortcut();
        product_group_short_panel.setVisible(true);
        product_group.setVisible(true);
        inventory_master.setVisible(false);
    }//GEN-LAST:event_inventory_master_product_groupActionPerformed

    private void inventory_master_unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_master_unitActionPerformed
        // TODO add your handling code here:
        unit_shortcut();
        unit_short_panel.setVisible(true);
        unit_create.setVisible(true);
        inventory_master.setVisible(false);
    }//GEN-LAST:event_inventory_master_unitActionPerformed

    private void inventory_master_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_master_productActionPerformed
        // TODO add your handling code here:
        product_shortcut();
        product_short_panel.setVisible(true);
        product_create.setVisible(true);
        inventory_master.setVisible(false);
    }//GEN-LAST:event_inventory_master_productActionPerformed

    private void inventory_master_godownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_master_godownActionPerformed
        // TODO add your handling code here:
        godown_shortcut();
        godown_short_panel.setVisible(true);
        godown_create.setVisible(true);
        inventory_master.setVisible(false);
    }//GEN-LAST:event_inventory_master_godownActionPerformed

    private void inventory_master_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_master_backActionPerformed
        // TODO add your handling code here:
        menu.setVisible(true);
        inventory_master.setVisible(false);
    }//GEN-LAST:event_inventory_master_backActionPerformed

    private void account_master_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_master_groupActionPerformed
        // TODO add your handling code here:
        esc_close();
        group_shortcut();
        group_short_panel.setVisible(true);
        group_create.setVisible(true);
        account_master.setVisible(false);
    }//GEN-LAST:event_account_master_groupActionPerformed

    private void account_master_partyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_master_partyActionPerformed
        // TODO add your handling code here:
        customer_vendor.setVisible(true);
        account_master.setVisible(false);
    }//GEN-LAST:event_account_master_partyActionPerformed

    private void account_master_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_master_backActionPerformed
        // TODO add your handling code here:
          menu.setVisible(true);
        account_master.setVisible(false);
    }//GEN-LAST:event_account_master_backActionPerformed

    private void ledger_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledger_buttonActionPerformed
        // TODO add your handling code here:
        esc_close1();
        
        ledger_shortcut();
        group_short_panel.setVisible(false);
        ledger_short_panel.setVisible(true);
        ledger_create.setVisible(true);
        account_master.setVisible(false);
    }//GEN-LAST:event_ledger_buttonActionPerformed

    private void payment_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_payment_create_buttonActionPerformed

    private void payment_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_payment_edit_buttonActionPerformed

    private void payment_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
         payment_short_panel.setVisible(false);
         payment_create.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_payment_back_buttonActionPerformed

    private void receipt_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_create_panel rcp=new receipt_create_panel();
            panelArray[i]=rcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_receipt_create_buttonActionPerformed

    private void receipt_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_edit_buttonActionPerformed
        // TODO add your handling code here:
        esc_close();
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_receipt_edit_buttonActionPerformed

    private void receipt_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        receipt_short_panel.setVisible(false);
        receipt_create.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_receipt_back_buttonActionPerformed

    private void journal_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
      
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Journal_panel jcp=new Journal_panel();
            panelArray[i]=jcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_journal_create_buttonActionPerformed

    private void journal_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_edit_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       journal_edit_delete_panel jep=new journal_edit_delete_panel();
            panelArray[i]=jep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_journal_edit_buttonActionPerformed

    private void journal_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        journal_short_panel.setVisible(false);
        journal_create.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_journal_back_buttonActionPerformed

    private void stock_transfer_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_transfer_create_buttonActionPerformed
        // TODO add your handling code here:
         esc_close();
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Stock_transfer_panel stp=new Stock_transfer_panel();
            panelArray[i]=stp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_stock_transfer_create_buttonActionPerformed

    private void stock_transfer_alter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_transfer_alter_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
    }//GEN-LAST:event_stock_transfer_alter_buttonActionPerformed

    private void stock_transferl_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_transferl_back_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
        stock_transfer_panel.setVisible(false);
         stock_transfer.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_stock_transferl_back_buttonActionPerformed

    private void payment_print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_print_buttonActionPerformed
 esc_close();       
    }//GEN-LAST:event_payment_print_buttonActionPerformed

    private void payment_details_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_details_buttonActionPerformed
 esc_close();      
    }//GEN-LAST:event_payment_details_buttonActionPerformed

    private void receipt_details_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_details_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
    }//GEN-LAST:event_receipt_details_buttonActionPerformed

    private void receipt_print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_print_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
    }//GEN-LAST:event_receipt_print_buttonActionPerformed

    private void sale_detail_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_detail_buttonActionPerformed
 esc_close();       
    }//GEN-LAST:event_sale_detail_buttonActionPerformed

    private void sold_item_detail_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sold_item_detail_buttonActionPerformed
 esc_close();      
    }//GEN-LAST:event_sold_item_detail_buttonActionPerformed

    private void sale_print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_print_buttonActionPerformed
 esc_close();      
    }//GEN-LAST:event_sale_print_buttonActionPerformed

    private void create_fund_transfer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_fund_transfer_buttonActionPerformed
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       fundtransfer_panel ftp=new fundtransfer_panel();
            panelArray[i]=ftp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_create_fund_transfer_buttonActionPerformed

    private void back_fund_transferl_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_fund_transferl_buttonActionPerformed
 esc_close();        fund_transfer_panel.setVisible(false);
        fund_transfer.setVisible(false);
        transaction.setVisible(true);      
    }//GEN-LAST:event_back_fund_transferl_buttonActionPerformed

    private void opening_stock_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opening_stock_create_buttonActionPerformed
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Openingstockcreate_panel otc=new Openingstockcreate_panel();
            panelArray[i]=otc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_opening_stock_create_buttonActionPerformed

    private void opening_stock_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opening_stock_edit_buttonActionPerformed
 esc_close();        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       openingstock_edit_panel otep=new openingstock_edit_panel();
            panelArray[i]=otep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_opening_stock_edit_buttonActionPerformed

    private void opening_stock_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opening_stock_back_buttonActionPerformed
 esc_close();        opening_stock_panel.setVisible(false);
        opening_stock.setVisible(false);
        transaction.setVisible(true);
                                       
    }//GEN-LAST:event_opening_stock_back_buttonActionPerformed

    private void reminder_create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_create_buttonActionPerformed
         esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_Form_panel rfp=new Reminder_Form_panel();
            panelArray[i]=rfp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_reminder_create_buttonActionPerformed

    private void reminder_edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_edit_buttonActionPerformed
 esc_close();        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_edit_delete_panel redp=new Reminder_edit_delete_panel();
            panelArray[i]=redp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_reminder_edit_buttonActionPerformed

    private void reminder_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_back_buttonActionPerformed
 esc_close();        reminder_short_panel.setVisible(false);
        reminder_create.setVisible(false);
        transaction.setVisible(true);
    }//GEN-LAST:event_reminder_back_buttonActionPerformed

    private void report_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_back_buttonActionPerformed
     menu.setVisible(true);
     report.setVisible(false);
    }//GEN-LAST:event_report_back_buttonActionPerformed

    private void report_trial_balance_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_trial_balance_buttonActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        
           trial_balance_panel tbp=new trial_balance_panel();
           
             panelArray[i]=tbp;
             
//            jPanel4.add(plvp);
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//       
      
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
//           jPanel4.setLayout(new BorderLayout());
              jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.validate();
        jPanel4.setVisible(true);
          tbp.labels[0][0].requestFocus();
    }//GEN-LAST:event_report_trial_balance_buttonActionPerformed

    private void report_profit_loss_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_profit_loss_buttonActionPerformed
        // TODO add your handling code here:
//           System.out.println("Panel to Delete: "+i);
//        
//        jPanel6.setVisible(false);
//        panelArray[i].setVisible(false);
//           
//        jPanel4.validate();
//        jPanel4.setVisible(true);
        
        
//        i++;    
//        System.out.println("Panel to add: "+i);
        
        
     esc_close();
       
        panel_test_pl_3 plvp=new panel_test_pl_3();
           
             panelArray[i]=plvp;
             
//            jPanel4.add(plvp);
//        jPanel4.validate();
//        jPanel4.setVisible(true);
//       
      
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
//           jPanel4.setLayout(new BorderLayout());
             
            
             
              jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.validate();
        jPanel4.setVisible(true);
        jPanel6.setVisible(false);
         
          plvp.labels[1][0].requestFocus();
               try
            {
                
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        
             PreparedStatement psq=con.prepareStatement("delete from pl_open");
            PreparedStatement psq1=con.prepareStatement("delete from pl_close");
            
            psq.executeUpdate();
            psq1.executeUpdate();   
             }
            catch (SQLException e)
            {
            System.out.println("Sql Exception" + e.toString());
            }
            catch(ClassNotFoundException ce)
            {
            System.out.println("ClassNotFoundException" + ce.toString());
            }
               
               
               
               //insert
            for (int pl1=1; pl1<plvp.row; pl1++)
            {
                System.out.print(plvp.labels[pl1][1].getText()+" ");
                System.out.println(plvp.labels[pl1][3].getText());
                
                System.out.print(plvp.labels[pl1][6].getText()+" ");
                System.out.println(plvp.labels[pl1][8].getText());
             
            try
            {
                
            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        
//             PreparedStatement psq=con.prepareStatement("delete from pl_open");
//            PreparedStatement psq1=con.prepareStatement("delete from pl_close");
//            
//            psq.executeUpdate();
//            psq1.executeUpdate();
            
            PreparedStatement ps=con.prepareStatement("insert into pl_open(part_data,amt_1,amt_2,year)values('"+plvp.labels[pl1][0].getText()+"','"+plvp.labels[pl1][1].getText()+"','"+plvp.labels[pl1][3].getText()+"','"+2014+"')");
            PreparedStatement ps1=con.prepareStatement("insert into pl_close(part_data_2,amt_3,amt_4,year_2)values('"+plvp.labels[pl1][5].getText()+"','"+plvp.labels[pl1][6].getText()+"','"+plvp.labels[pl1][8].getText()+"','"+2014+"')");
            
            ps.executeUpdate();
            ps1.executeUpdate();
            
            System.out.println("saved");
            
           
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
         
    }//GEN-LAST:event_report_profit_loss_buttonActionPerformed

    private void ledger_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledger_create_shortActionPerformed
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);

        jPanel4.validate();
        jPanel4.setVisible(true);

        i++;
        System.out.println("Panel to add: "+i);

        Ledger_create_panel lcp=new Ledger_create_panel();
        panelArray[i]=lcp;

        //           jPanel4.revalidate();
        //           System.out.println("Visible hidden");
        //
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);

        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_ledger_create_shortActionPerformed

    private void ledger_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledger_edit_delete_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        
      jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       ledger_edit_delete_panel ledp=new ledger_edit_delete_panel();
            panelArray[i]=ledp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);       
    }//GEN-LAST:event_ledger_edit_delete_shortActionPerformed

    private void group_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_group_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        acc_group_create agc=new acc_group_create();
        panelArray[i]=agc;

            
                  // jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_group_create_shortActionPerformed

    private void group_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_group_edit_delete_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       acc_group_edit_delete_panel egl=new acc_group_edit_delete_panel();
       panelArray[i]=egl;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_group_edit_delete_shortActionPerformed

    private void customer_group_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_group_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        acc_group_create agc=new acc_group_create();
        panelArray[i]=agc;

            
                  // jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_customer_group_shortActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
      
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_edit_panel cep=new customer_edit_panel();
       panelArray[i]=cep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void vendor_edit_delete_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_edit_delete_panelActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_edit_delete_panel vedp=new vendor_edit_delete_panel();
            panelArray[i]=vedp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_vendor_edit_delete_panelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_edit_panel iuep=new inventory_unit_edit_panel();
            panelArray[i]=iuep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void product_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_edit_panel ipep=new inventory_product_edit_panel();
            panelArray[i]=ipep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_edit_delete_shortActionPerformed

    private void godown_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_godown_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_edit_panel gep=new godown_edit_panel();
            panelArray[i]=gep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_godown_edit_delete_shortActionPerformed

    private void purchase_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_purchase_edit_panel_final npep=new normal_purchase_edit_panel_final();
            panelArray[i]=npep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_purchase_edit_delete_shortActionPerformed

    private void vendor_group_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendor_group_shortActionPerformed
        // TODO add your handling code here:
             System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        acc_group_create agc=new acc_group_create();
        panelArray[i]=agc;

            
                  // jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_vendor_group_shortActionPerformed

    private void purchase_ledger_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_ledger_shortActionPerformed
        // TODO add your handling code here:
           System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);

        jPanel4.validate();
        jPanel4.setVisible(true);

        i++;
        System.out.println("Panel to add: "+i);

        Ledger_create_panel lcp=new Ledger_create_panel();
        panelArray[i]=lcp;

        //           jPanel4.revalidate();
        //           System.out.println("Visible hidden");
        //
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);

        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_purchase_ledger_shortActionPerformed

    private void purchase_product_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_product_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_product_create_panel ipcp=new inventory_product_create_panel();
            panelArray[i]=ipcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_purchase_product_shortActionPerformed

    private void purchase_unit_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_unit_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_purchase_unit_shortActionPerformed

    private void product_group_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_group_edit_delete_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
       
        
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_edit_panel igcp=new inventory_group_edit_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    }//GEN-LAST:event_product_group_edit_delete_shortActionPerformed

    private void product_product_group_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_product_group_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_group_create_panel igcp=new inventory_group_create_panel();
            panelArray[i]=igcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_product_group_shortActionPerformed

    private void product_unit_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_unit_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       inventory_unit_create_panel iuc=new inventory_unit_create_panel();
            panelArray[i]=iuc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_product_unit_shortActionPerformed

    private void sale_customer_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_customer_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       customer_create_panel ccp=new customer_create_panel();
            panelArray[i]=ccp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);  
    }//GEN-LAST:event_sale_customer_shortActionPerformed

    private void sale_vendor_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_vendor_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       vendor_create_panel vcp=new vendor_create_panel();
            panelArray[i]=vcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);   
    }//GEN-LAST:event_sale_vendor_shortActionPerformed

    private void sale_ledger_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_ledger_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);

        jPanel4.validate();
        jPanel4.setVisible(true);

        i++;
        System.out.println("Panel to add: "+i);

        Ledger_create_panel lcp=new Ledger_create_panel();
        panelArray[i]=lcp;

        //           jPanel4.revalidate();
        //           System.out.println("Visible hidden");
        //
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);

        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_sale_ledger_shortActionPerformed

    private void sale_godown_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_godown_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       godown_create_panel gcp=new godown_create_panel();
            panelArray[i]=gcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_sale_godown_shortActionPerformed

    private void payment_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_edit_panel pep=new payment_edit_panel();
            panelArray[i]=pep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_payment_edit_delete_shortActionPerformed

    private void receipt_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
           receipt_edit_delete_panel rep=new receipt_edit_delete_panel();
            panelArray[i]=rep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);      
    }//GEN-LAST:event_receipt_edit_delete_shortActionPerformed

    private void journal_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
        journal_edit_panel jep=new journal_edit_panel();
            panelArray[i]=jep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_journal_edit_delete_shortActionPerformed

    private void sale_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_edit_delete_shortActionPerformed
        // TODO add your handling code here:
          System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_edit_panel nsep=new normal_sale_edit_panel();
            panelArray[i]=nsep;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_sale_edit_delete_shortActionPerformed

    private void stock_transfer_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_transfer_create_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Stock_transfer_panel stp=new Stock_transfer_panel();
            panelArray[i]=stp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_stock_transfer_create_shortActionPerformed

    private void fund_transfer_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fund_transfer_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       fundtransfer_panel ftp=new fundtransfer_panel();
            panelArray[i]=ftp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_fund_transfer_create_shortActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Openingstockcreate_panel otc=new Openingstockcreate_panel();
            panelArray[i]=otc;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void opening_stock_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opening_stock_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
         openingstock_edit_panel otep=new openingstock_edit_panel();
            panelArray[i]=otep;
           
          
          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_opening_stock_edit_delete_shortActionPerformed

    private void reminder_create_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_create_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
       
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_Form_panel rfp=new Reminder_Form_panel();
            panelArray[i]=rfp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_reminder_create_shortActionPerformed

    private void reminder_edit_delete_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reminder_edit_delete_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       Reminder_edit_delete_panel redp=new Reminder_edit_delete_panel();
            panelArray[i]=redp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_reminder_edit_delete_shortActionPerformed

    private void demo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_demo1ActionPerformed

    private void demo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_demo2ActionPerformed

    private void alter_fund_transfer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alter_fund_transfer_buttonActionPerformed
 esc_close();        // TODO add your handling code here:
    }//GEN-LAST:event_alter_fund_transfer_buttonActionPerformed

    private void journal_ledger_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journal_ledger_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);

        jPanel4.validate();
        jPanel4.setVisible(true);

        i++;
        System.out.println("Panel to add: "+i);

        Ledger_create_panel lcp=new Ledger_create_panel();
        panelArray[i]=lcp;

        //           jPanel4.revalidate();
        //           System.out.println("Visible hidden");
        //
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);

        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_journal_ledger_shortActionPerformed

    private void sale_print_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_print_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_sale_print_shortActionPerformed

    private void sale_detail_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_detail_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_sale_detail_shortActionPerformed

    private void sold_item_detail_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sold_item_detail_shortActionPerformed
        // TODO add your handling code here:
        System.out.println("Panel to Delete: "+i);
        
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       normal_sale_create_panel nscp=new normal_sale_create_panel();
            panelArray[i]=nscp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true);
    }//GEN-LAST:event_sold_item_detail_shortActionPerformed

    private void payment_print_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_print_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_payment_print_shortActionPerformed

    private void payment_details_shortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_details_shortActionPerformed
        // TODO add your handling code here:
         System.out.println("Panel to Delete: "+i);
        jPanel6.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel4.validate();
        jPanel4.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
       payment_create_panel pcp=new payment_create_panel();
            panelArray[i]=pcp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel4.setLayout(new BorderLayout());
           jPanel4.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel4.revalidate();
        jPanel4.setVisible(true); 
    }//GEN-LAST:event_payment_details_shortActionPerformed

    private void menu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_logoutActionPerformed
        // TODO add your handling code here:
        //menu.setVisible(false);
         login_form lf=new login_form();
        lf.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_menu_logoutActionPerformed

    private void login_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_loginActionPerformed
        // TODO add your handling code here:
        String user1=user_name.getText();
        String pass1=password.getText();
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con.createStatement();
            ResultSet rs=ps.executeQuery("select *  from user_table where  user_id='"+user1+"' and user_pass='"+pass1+"'");
            if(rs.next()){
                     
       

jPanel8.setVisible(false);
login_panel1.setVisible(false);

            }
        }
        catch(Exception e)
        {

        }
    }//GEN-LAST:event_login_loginActionPerformed

    private void login_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_resetActionPerformed
        // TODO add your handling code here:
        user_name.setText("");
        password.setText("");

    }//GEN-LAST:event_login_resetActionPerformed

    private void login_login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_login1ActionPerformed
        // TODO add your handling code here:
          String user2=user_name1.getText();
        String pass2=password1.getText();
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
            Connection con = (Connection) DriverManager.getConnection(ConnUrl);
            Statement ps =con.createStatement();
            ResultSet rs=ps.executeQuery("select *  from user_table where  user_id='"+user2+"' and user_pass='"+pass2+"'");
            if(rs.next()){
             

jPanel9.setVisible(false);
login_panel1.setVisible(false);



            }
      
        }
        catch(Exception e)
        {

        }
    }//GEN-LAST:event_login_login1ActionPerformed

    private void login_reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_reset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_reset1ActionPerformed

    private void jLabel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseMoved
        // TODO add your handling code here:
        jLabel4.setVisible(true);
        jLabel3.setVisible(false);
    }//GEN-LAST:event_jLabel11MouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */ 
      
           try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new demo().setVisible(true);
            }
        });
    }
  
    int n=0,j=0,k=0,l=0;
    int a=0;
     
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame account_master;
    private javax.swing.JButton account_master_back;
    private javax.swing.JButton account_master_group;
    private javax.swing.JButton account_master_party;
    private javax.swing.JButton accounting_master_short;
    private javax.swing.JButton alter_fund_transfer_button;
    private javax.swing.JButton back_fund_transferl_button;
    private javax.swing.JButton back_group;
    private javax.swing.JButton back_ledger;
    private javax.swing.JButton back_transaction_button;
    public javax.swing.JLabel company_name;
    private javax.swing.JButton create_fund_transfer_button;
    private javax.swing.JButton create_group;
    private javax.swing.JButton create_ledger;
    private javax.swing.JButton customer;
    private javax.swing.JButton customer_back_button;
    private javax.swing.JInternalFrame customer_create;
    private javax.swing.JButton customer_create_button;
    private javax.swing.JButton customer_create_short;
    private javax.swing.JButton customer_edit_button;
    private javax.swing.JButton customer_group_short;
    private javax.swing.JPanel customer_short_panel;
    private javax.swing.JInternalFrame customer_vendor;
    private javax.swing.JButton customer_vendor_back;
    private javax.swing.JButton demo1;
    private javax.swing.JButton demo2;
    private javax.swing.JButton edit_group;
    private javax.swing.JButton edit_ledger;
    private javax.swing.JInternalFrame fund_transfer;
    private javax.swing.JButton fund_transfer_alter_short;
    private javax.swing.JButton fund_transfer_button;
    private javax.swing.JButton fund_transfer_create_short;
    private javax.swing.JPanel fund_transfer_panel;
    private javax.swing.JButton godown_back_button3;
    private javax.swing.JInternalFrame godown_create;
    private javax.swing.JButton godown_create_button;
    private javax.swing.JButton godown_create_short;
    private javax.swing.JButton godown_edit_button;
    private javax.swing.JButton godown_edit_delete_short;
    private javax.swing.JPanel godown_short_panel;
    private javax.swing.JInternalFrame group_create;
    private javax.swing.JButton group_create_short;
    private javax.swing.JButton group_edit_delete_short;
    private javax.swing.JPanel group_short_panel;
    private javax.swing.JInternalFrame inventory_master;
    private javax.swing.JButton inventory_master_back;
    private javax.swing.JButton inventory_master_godown;
    private javax.swing.JButton inventory_master_product;
    private javax.swing.JButton inventory_master_product_group;
    private javax.swing.JButton inventory_master_short;
    private javax.swing.JButton inventory_master_unit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton journal_back_button;
    private javax.swing.JButton journal_button;
    private javax.swing.JInternalFrame journal_create;
    private javax.swing.JButton journal_create_button;
    private javax.swing.JButton journal_create_short;
    private javax.swing.JButton journal_edit_button;
    private javax.swing.JButton journal_edit_delete_short;
    private javax.swing.JButton journal_ledger_short;
    private javax.swing.JPanel journal_short_panel;
    private javax.swing.JLabel labelyear;
    private javax.swing.JButton ledger_button;
    private javax.swing.JInternalFrame ledger_create;
    private javax.swing.JButton ledger_create_short;
    private javax.swing.JButton ledger_edit_delete_short;
    private javax.swing.JButton ledger_group_short;
    private javax.swing.JPanel ledger_short_panel;
    private javax.swing.JButton login_login;
    private javax.swing.JButton login_login1;
    private javax.swing.JButton login_reset;
    private javax.swing.JButton login_reset1;
    public javax.swing.JInternalFrame menu;
    private javax.swing.JButton menu_account_master;
    private javax.swing.JButton menu_inventory_master;
    private javax.swing.JButton menu_logout;
    private javax.swing.JButton menu_report;
    private javax.swing.JPanel menu_short_panel;
    private javax.swing.JButton menu_transaction;
    private javax.swing.JInternalFrame opening_stock;
    private javax.swing.JButton opening_stock_back_button;
    private javax.swing.JButton opening_stock_button;
    private javax.swing.JButton opening_stock_create_button;
    private javax.swing.JButton opening_stock_edit_button;
    private javax.swing.JButton opening_stock_edit_delete_short;
    private javax.swing.JPanel opening_stock_panel;
    public javax.swing.JTextField password;
    public javax.swing.JTextField password1;
    private javax.swing.JButton payment_back_button;
    private javax.swing.JButton payment_button;
    private javax.swing.JInternalFrame payment_create;
    private javax.swing.JButton payment_create_button;
    private javax.swing.JButton payment_create_short;
    private javax.swing.JButton payment_details_button;
    private javax.swing.JButton payment_details_short;
    private javax.swing.JButton payment_edit_button;
    private javax.swing.JButton payment_edit_delete_short;
    private javax.swing.JButton payment_print_button;
    private javax.swing.JButton payment_print_short;
    private javax.swing.JPanel payment_short_panel;
    private javax.swing.JButton product_back_button;
    private javax.swing.JInternalFrame product_create;
    private javax.swing.JButton product_create_button;
    private javax.swing.JButton product_create_short;
    private javax.swing.JButton product_edit_button;
    private javax.swing.JButton product_edit_delete_short;
    private javax.swing.JInternalFrame product_group;
    private javax.swing.JButton product_group_back_button;
    private javax.swing.JButton product_group_create_button;
    private javax.swing.JButton product_group_create_short;
    private javax.swing.JButton product_group_edit_button;
    private javax.swing.JButton product_group_edit_delete_short;
    private javax.swing.JPanel product_group_short_panel;
    private javax.swing.JButton product_product_group_short;
    private javax.swing.JPanel product_short_panel;
    private javax.swing.JButton product_unit_short;
    private javax.swing.JButton profit_loss_horizontal;
    private javax.swing.JInternalFrame profit_loss_menu;
    private javax.swing.JButton profit_loss_vertical;
    private javax.swing.JButton profit_loss_vertical1;
    private javax.swing.JButton purchase_back_button;
    private javax.swing.JButton purchase_button;
    private javax.swing.JInternalFrame purchase_create;
    private javax.swing.JButton purchase_create_button;
    private javax.swing.JButton purchase_create_short;
    private javax.swing.JButton purchase_edit_button;
    private javax.swing.JButton purchase_edit_delete_short;
    private javax.swing.JButton purchase_ledger_short;
    private javax.swing.JButton purchase_product_short;
    private javax.swing.JPanel purchase_short_panel;
    private javax.swing.JButton purchase_unit_short;
    private javax.swing.JButton receipt_back_button;
    private javax.swing.JButton receipt_button;
    private javax.swing.JInternalFrame receipt_create;
    private javax.swing.JButton receipt_create_button;
    private javax.swing.JButton receipt_create_short;
    private javax.swing.JButton receipt_details_button;
    private javax.swing.JButton receipt_details_short;
    private javax.swing.JButton receipt_edit_button;
    private javax.swing.JButton receipt_edit_delete_short;
    private javax.swing.JButton receipt_print_button;
    private javax.swing.JButton receipt_print_short;
    private javax.swing.JPanel receipt_short_panel;
    private javax.swing.JButton reminder_back_button;
    private javax.swing.JButton reminder_button;
    private javax.swing.JInternalFrame reminder_create;
    private javax.swing.JButton reminder_create_button;
    private javax.swing.JButton reminder_create_short;
    private javax.swing.JButton reminder_edit_button;
    private javax.swing.JButton reminder_edit_delete_short;
    private javax.swing.JPanel reminder_short_panel;
    private javax.swing.JInternalFrame report;
    private javax.swing.JButton report_back_button;
    private javax.swing.JButton report_balance_sheet_button;
    private javax.swing.JButton report_bank_status_button;
    private javax.swing.JButton report_cash_status_button;
    private javax.swing.JButton report_customer_status_button;
    private javax.swing.JButton report_profit_loss_button;
    private javax.swing.JButton report_stock_summary_button;
    private javax.swing.JButton report_tax_detail_button;
    private javax.swing.JButton report_trial_balance_button;
    private javax.swing.JButton report_vendor_status_button;
    private javax.swing.JButton reports_short;
    private javax.swing.JButton sale_back_button;
    private javax.swing.JButton sale_button;
    private javax.swing.JButton sale_create_button;
    private javax.swing.JInternalFrame sale_create_menu;
    private javax.swing.JButton sale_create_short;
    private javax.swing.JButton sale_customer_short;
    private javax.swing.JButton sale_detail_button;
    private javax.swing.JButton sale_detail_short;
    private javax.swing.JButton sale_edit_button;
    private javax.swing.JButton sale_edit_delete_short;
    private javax.swing.JButton sale_godown_short;
    private javax.swing.JButton sale_ledger_short;
    private javax.swing.JButton sale_print_button;
    private javax.swing.JButton sale_print_short;
    private javax.swing.JPanel sale_short_panel;
    private javax.swing.JButton sale_vendor_short;
    private javax.swing.JButton sold_item_detail_button;
    private javax.swing.JButton sold_item_detail_short;
    private javax.swing.JInternalFrame stock_transfer;
    private javax.swing.JButton stock_transfer_alter_button;
    private javax.swing.JButton stock_transfer_alter_short;
    private javax.swing.JButton stock_transfer_button;
    private javax.swing.JButton stock_transfer_create_button;
    private javax.swing.JButton stock_transfer_create_short;
    private javax.swing.JPanel stock_transfer_panel;
    private javax.swing.JButton stock_transferl_back_button;
    private javax.swing.JPanel tpanel;
    private javax.swing.JInternalFrame transaction;
    private javax.swing.JButton transaction_short;
    private javax.swing.JButton unit_back;
    private javax.swing.JInternalFrame unit_create;
    private javax.swing.JButton unit_create_button;
    private javax.swing.JButton unit_create_short;
    private javax.swing.JButton unit_edit_button;
    private javax.swing.JPanel unit_short_panel;
    public javax.swing.JTextField user_name;
    public javax.swing.JTextField user_name1;
    private javax.swing.JButton vendor;
    private javax.swing.JButton vendor_back_button;
    private javax.swing.JInternalFrame vendor_create;
    private javax.swing.JButton vendor_create_button;
    private javax.swing.JButton vendor_create_short;
    private javax.swing.JButton vendor_edit_button;
    private javax.swing.JButton vendor_edit_delete_panel;
    private javax.swing.JButton vendor_group_short;
    private javax.swing.JPanel vendor_short_panel;
    // End of variables declaration//GEN-END:variables
}
