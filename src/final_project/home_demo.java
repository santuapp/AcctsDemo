/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package final_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.SystemColor.menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 *
 * @author virtual vista
 */
public class home_demo extends javax.swing.JFrame {
public JPanel[] panelArray = new JPanel[100];
int i = 0;
int c_id;
demo d5=new demo();
    /**
     * Creates new form home_demo
     */
    public home_demo() {
        initComponents();
       // esc_close();
        login_form lf=new login_form();
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        user_menu.setVisible(false);
        create_comany_menu.setVisible(false);
        select_company_menu.setVisible(false);
        
        
        
        tutorial_panel tp=new tutorial_panel();   
             panelArray[i]=tp;
             //panelArray[i].setBounds(0, 0, 0,0);
            
             panelArray[i].setVisible(true);
             
             //jPanel4.removeAll();
             jPanel3.setLayout(new BorderLayout());
             jPanel3.add(panelArray[i]);
           
             System.out.println("Tutorial Panel added: "+i);
             
        jPanel3.validate();
        jPanel3.setVisible(true);
        
        
         final JButton create_menu_buttons[]={create_company,alter_company, select_company,create_user,admin_logout};
    {
       
         for (int p=0;p<5;p++)
            {
                
               final int p1=p;
               String st=create_menu_buttons[p1].getText();
              
                
               create_menu_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                     switch (e.getKeyCode()) {
                     case KeyEvent.VK_UP:
                     if (p1 > 0){
                     create_menu_buttons[p1-1].requestFocus();
                     create_menu_buttons[p1-1].setContentAreaFilled(true);
                     create_menu_buttons[p1-1].setBorderPainted(true);
                     create_menu_buttons[p1].setContentAreaFilled(false);
                     create_menu_buttons[p1].setBorderPainted(false);
                     create_menu_buttons[p1-1].setBackground(Color.GRAY);
                      
                     }
                      if (p1 == 0){
                     create_menu_buttons[4].requestFocus();
                     create_menu_buttons[4].setContentAreaFilled(true);
                     create_menu_buttons[4].setBorderPainted(true);
                     create_menu_buttons[0].setContentAreaFilled(false);
                     create_menu_buttons[0].setBorderPainted(false);
                     create_menu_buttons[4].setBackground(Color.GRAY);
                      
                     }
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                     case KeyEvent.VK_DOWN:
                     if (p1 <5){
                     create_menu_buttons[p1+1].requestFocus();
                     create_menu_buttons[p1+1].setContentAreaFilled(true);
                     create_menu_buttons[p1+1].setBorderPainted(true);
                     create_menu_buttons[p1].setContentAreaFilled(false);
                     create_menu_buttons[p1].setBorderPainted(false);
                     create_menu_buttons[p1+1].setBackground(Color.GRAY);
                     } // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     
                    if (p1 == 4){
                     create_menu_buttons[0].requestFocus();
                     create_menu_buttons[0].setContentAreaFilled(true);
                     create_menu_buttons[0].setBorderPainted(true);
                     create_menu_buttons[4].setContentAreaFilled(false);
                     create_menu_buttons[4].setBorderPainted(false);
                     create_menu_buttons[0].setBackground(Color.GRAY);
                      
                     }
                     break;
                          case KeyEvent.VK_ENTER:
                     if (p1==0){
                         esc_close();
                       System.out.println("Panel to Delete: "+i);
       
        jPanel4.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel3.validate();
        jPanel3.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      company_registraion_panel crp=new company_registraion_panel();
            panelArray[i]=crp;
           
        
           jPanel3.setLayout(new BorderLayout());
           jPanel3.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel3.revalidate();
        jPanel3.setVisible(true);
                     
    
                     }
                     if (p1==1){
                         esc_close();
                   System.out.println("Panel to Delete: "+i);
       
        jPanel4.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel3.validate();
        jPanel3.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      company_regisration_edit_delete_panel cedp=new company_regisration_edit_delete_panel();
            panelArray[i]=cedp;
           
          
        
           jPanel3.setLayout(new BorderLayout());
           jPanel3.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel3.revalidate();
        jPanel3.setVisible(true);
    
                     }
                         if (p1==2){
                   
                   select_company_menu.setVisible(true);
        create_comany_menu.setVisible(false);
    
                     }
                         
                         if (p1==3){
                    
    
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
         
          final JButton user_buttons[]={user_select_company,user_logout};
       
         for (int p=0;p<2;p++)
            {
                
               final int p1=p;
               String st=user_buttons[p1].getText();
              
                
               user_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                     switch (e.getKeyCode()) {
                     case KeyEvent.VK_UP:
                     if (p1 > 0){
                     user_buttons[p1-1].requestFocus();
                     user_buttons[p1-1].setContentAreaFilled(true);
                     user_buttons[p1-1].setBorderPainted(true);
                     user_buttons[p1].setContentAreaFilled(false);
                     user_buttons[p1].setBorderPainted(false);
                     user_buttons[p1-1].setBackground(Color.GRAY);
                      
                     }
                      if (p1 == 0){
                     user_buttons[4].requestFocus();
                     user_buttons[4].setContentAreaFilled(true);
                     user_buttons[4].setBorderPainted(true);
                     user_buttons[0].setContentAreaFilled(false);
                     user_buttons[0].setBorderPainted(false);
                     user_buttons[4].setBackground(Color.GRAY);
                      
                     }
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                     case KeyEvent.VK_DOWN:
                     if (p1 <3){
                     user_buttons[p1+1].requestFocus();
                     user_buttons[p1+1].setContentAreaFilled(true);
                     user_buttons[p1+1].setBorderPainted(true);
                     user_buttons[p1].setContentAreaFilled(false);
                     user_buttons[p1].setBorderPainted(false);
                     user_buttons[p1+1].setBackground(Color.GRAY);
                     } // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     
                    if (p1 == 2){
                     user_buttons[0].requestFocus();
                     user_buttons[0].setContentAreaFilled(true);
                     user_buttons[0].setBorderPainted(true);
                     user_buttons[4].setContentAreaFilled(false);
                     user_buttons[4].setBorderPainted(false);
                     user_buttons[0].setBackground(Color.GRAY);
                      
                     }
                     break;
                          case KeyEvent.VK_ENTER:
                     if (p1==0){
                       
                     
    
                     }
                     if (p1==1){
                  
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
         
          final JButton select_company_buttons[]={select_select_company};
       
         for (int p=0;p<1;p++)
            {
                
               final int p1=p;
               String st=user_buttons[p1].getText();
              
                
               user_buttons[p1].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  
                  
                     switch (e.getKeyCode()) {
                     case KeyEvent.VK_UP:
                     if (p1 > 0){
                     user_buttons[p1-1].requestFocus();
                     user_buttons[p1-1].setContentAreaFilled(true);
                     user_buttons[p1-1].setBorderPainted(true);
                     user_buttons[p1].setContentAreaFilled(false);
                     user_buttons[p1].setBorderPainted(false);
                     user_buttons[p1-1].setBackground(Color.GRAY);
                      
                     }
                      if (p1 == 0){
                     user_buttons[4].requestFocus();
                     user_buttons[4].setContentAreaFilled(true);
                     user_buttons[4].setBorderPainted(true);
                     user_buttons[0].setContentAreaFilled(false);
                     user_buttons[0].setBorderPainted(false);
                     user_buttons[4].setBackground(Color.GRAY);
                      
                     }
                       // button_array[p1-1].setBorder(BorderFactory.createLineBorder(2, 1, 2, 1, Color.orange));
                     break;
                     case KeyEvent.VK_DOWN:
                     if (p1 <2){
                     user_buttons[p1+1].requestFocus();
                     user_buttons[p1+1].setContentAreaFilled(true);
                     user_buttons[p1+1].setBorderPainted(true);
                     user_buttons[p1].setContentAreaFilled(false);
                     user_buttons[p1].setBorderPainted(false);
                     user_buttons[p1+1].setBackground(Color.GRAY);
                     } // button_array[p1+1].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.orange));
                     
                    if (p1 == 0){
                     user_buttons[0].requestFocus();
                     user_buttons[0].setContentAreaFilled(true);
                     user_buttons[0].setBorderPainted(true);
                     user_buttons[4].setContentAreaFilled(false);
                     user_buttons[4].setBorderPainted(false);
                     user_buttons[0].setBackground(Color.GRAY);
                      
                     }
                     break;
                          case KeyEvent.VK_ENTER:
                     if (p1==0){
                       
                     company_select_form lsf=new company_select_form();
                     lsf.setVisible(true);
                      dispose();
                     }
                     if (p1==1){
                  
    
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
          try{
        
           Class.forName("com.mysql.jdbc.Driver");
           String ConnUrl="jdbc:mysql://localhost:3306/acc_database?" + "user=root&password=admin";
           Connection con = (Connection) DriverManager.getConnection(ConnUrl);
        Statement ps =con.createStatement();
           ResultSet rs=ps.executeQuery("select distinct company_name,company_id from company_creation");
//            jComboBox1.addItem(d2); 
//           jComboBox1.setSelectedItem(d2);
           while(rs.next())
          {
              String name=rs.getString("company_name");
              c_id=Integer.parseInt(rs.getString("company_id"));
              jComboBox1.addItem(name);
              System.out.println(c_id);
          }
         // String name1="Others";
          //jComboBox1.addItem(name1);
            
         
        }catch (SQLException e){
        System.out.println("Sql Exception" + e.toString());
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFoundException" + ce.toString());
        } 
        
    }
 public void esc_close()
{
  KeyStroke escape1111 = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
    Action action1111 = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        int p=JOptionPane.showConfirmDialog(null,"Do you really want to Close?","Close",JOptionPane.YES_NO_OPTION);
    if(p==0){
     System.out.println();
       
        if (i>0)
        {    
        System.out.println("Panel to Delete: "+i);
        
        panelArray[i].setVisible(false);
           
        jPanel3.validate();
        jPanel3.setVisible(true);
         
       
        
        i--;
        System.out.println("Next Panel:"+i);


        jPanel3.setLayout(new BorderLayout());
   
        //jPanel4.add(panelArray[i]);
        panelArray[i].setVisible(true);
     
        
         
            jPanel3.repaint();
         jPanel3.revalidate();
         jPanel3.setVisible(true);
               
                     
     
        }  
         if(i==0)
        {
            jPanel4.setVisible(true);
       
     create_comany_menu.setVisible(true);
       
       
       
      
       
        }


    }
   
    }
    };
        
getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape1111, "escape1111");
getRootPane().getActionMap().put("escape1111", action1111);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        create_comany_menu = new javax.swing.JInternalFrame();
        create_company = new javax.swing.JButton();
        select_company = new javax.swing.JButton();
        create_user = new javax.swing.JButton();
        admin_logout = new javax.swing.JButton();
        alter_company = new javax.swing.JButton();
        user_menu = new javax.swing.JInternalFrame();
        user_select_company = new javax.swing.JButton();
        user_logout = new javax.swing.JButton();
        select_company_menu = new javax.swing.JInternalFrame();
        select_select_company = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Details"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Date:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("DD/MM/YYYY");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Financial Year:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel25.setText("DD/MM/YYYY");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Company Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3304, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        create_comany_menu.setTitle("Admin Menu");
        create_comany_menu.setVisible(true);

        create_company.setText("Create Company");
        create_company.setBorderPainted(false);
        create_company.setContentAreaFilled(false);
        create_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_companyActionPerformed(evt);
            }
        });

        select_company.setText("Select Company");
        select_company.setBorderPainted(false);
        select_company.setContentAreaFilled(false);
        select_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_companyActionPerformed(evt);
            }
        });

        create_user.setText("Create User");
        create_user.setBorderPainted(false);
        create_user.setContentAreaFilled(false);
        create_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_userActionPerformed(evt);
            }
        });

        admin_logout.setText("Logout");
        admin_logout.setBorderPainted(false);
        admin_logout.setContentAreaFilled(false);
        admin_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_logoutActionPerformed(evt);
            }
        });

        alter_company.setText("Alter Company");
        alter_company.setBorderPainted(false);
        alter_company.setContentAreaFilled(false);
        alter_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alter_companyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout create_comany_menuLayout = new javax.swing.GroupLayout(create_comany_menu.getContentPane());
        create_comany_menu.getContentPane().setLayout(create_comany_menuLayout);
        create_comany_menuLayout.setHorizontalGroup(
            create_comany_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(create_company, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(select_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(create_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(admin_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(alter_company, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        create_comany_menuLayout.setVerticalGroup(
            create_comany_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(create_comany_menuLayout.createSequentialGroup()
                .addComponent(create_company)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alter_company)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(select_company)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(create_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(admin_logout)
                .addContainerGap())
        );

        user_menu.setTitle("User Menu");
        user_menu.setVisible(true);

        user_select_company.setText("Select Company");
        user_select_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_select_companyActionPerformed(evt);
            }
        });

        user_logout.setText("Logout");
        user_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout user_menuLayout = new javax.swing.GroupLayout(user_menu.getContentPane());
        user_menu.getContentPane().setLayout(user_menuLayout);
        user_menuLayout.setHorizontalGroup(
            user_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_select_company, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(user_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        user_menuLayout.setVerticalGroup(
            user_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_menuLayout.createSequentialGroup()
                .addComponent(user_select_company)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user_logout)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        select_company_menu.setTitle("Select Company");
        select_company_menu.setVisible(true);

        select_select_company.setText("Go To Gateway");
        select_select_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_select_companyActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout select_company_menuLayout = new javax.swing.GroupLayout(select_company_menu.getContentPane());
        select_company_menu.getContentPane().setLayout(select_company_menuLayout);
        select_company_menuLayout.setHorizontalGroup(
            select_company_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(select_select_company, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        select_company_menuLayout.setVerticalGroup(
            select_company_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(select_company_menuLayout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(select_select_company)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(select_company_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(create_comany_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {create_comany_menu, select_company_menu, user_menu});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(create_comany_menu)
                    .addComponent(select_company_menu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user_menu, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(444, 444, 444))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_logoutActionPerformed
        // TODO add your handling code here:
        login_form lf=new login_form();
        lf.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_admin_logoutActionPerformed

    private void user_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_logoutActionPerformed
        // TODO add your handling code here:
         login_form lf=new login_form();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_user_logoutActionPerformed

    private void create_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_companyActionPerformed
        // TODO add your handling code here:
        esc_close();
        System.out.println("Panel to Delete: "+i);
       
        jPanel4.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel3.validate();
        jPanel3.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      company_registraion_panel crp=new company_registraion_panel();
            panelArray[i]=crp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel3.setLayout(new BorderLayout());
           jPanel3.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel3.revalidate();
        jPanel3.setVisible(true);
    }//GEN-LAST:event_create_companyActionPerformed

    private void alter_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alter_companyActionPerformed
        // TODO add your handling code here:
        esc_close();
         System.out.println("Panel to Delete: "+i);
       
        jPanel4.setVisible(false);
        panelArray[i].setVisible(false);
           
        jPanel3.validate();
        jPanel3.setVisible(true);
        
        
        i++;    
        System.out.println("Panel to add: "+i);
        
      company_regisration_edit_delete_panel cedp=new company_regisration_edit_delete_panel();
            panelArray[i]=cedp;
           
          
//           jPanel4.revalidate();
//           System.out.println("Visible hidden");
//          
           jPanel3.setLayout(new BorderLayout());
           jPanel3.add(panelArray[i]);
           panelArray[i].setVisible(true);
       
        jPanel3.revalidate();
        jPanel3.setVisible(true);
    }//GEN-LAST:event_alter_companyActionPerformed

    private void select_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_companyActionPerformed
        // TODO add your handling code here:
        esc_close();
        select_company_menu.setVisible(true);
        create_comany_menu.setVisible(false);
    }//GEN-LAST:event_select_companyActionPerformed

    private void user_select_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_select_companyActionPerformed
        // TODO add your handling code here:
       
        select_company_menu.setVisible(true);
        user_menu.setVisible(false);
    }//GEN-LAST:event_user_select_companyActionPerformed

    private void select_select_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_select_companyActionPerformed
        // TODO add your handling code here:
        company_select_form csf=new company_select_form();
        csf.setVisible(true);
        dispose();
        int c=jComboBox1.getSelectedIndex();
//        System.out.println(c);
//        if(c==0)
//        {
//      d5.setVisible(true);
//      this.dispose();
//        }
    }//GEN-LAST:event_select_select_companyActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void create_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_userActionPerformed
        // TODO add your handling code here:
        esc_close();
    }//GEN-LAST:event_create_userActionPerformed

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
            java.util.logging.Logger.getLogger(home_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_logout;
    private javax.swing.JButton alter_company;
    public javax.swing.JInternalFrame create_comany_menu;
    private javax.swing.JButton create_company;
    private javax.swing.JButton create_user;
    public javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton select_company;
    public javax.swing.JInternalFrame select_company_menu;
    private javax.swing.JButton select_select_company;
    private javax.swing.JButton user_logout;
    public javax.swing.JInternalFrame user_menu;
    private javax.swing.JButton user_select_company;
    // End of variables declaration//GEN-END:variables
}
