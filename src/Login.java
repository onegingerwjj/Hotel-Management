package hotel.management;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Junjie Wang & Yuhong Chen
 */
public class Login extends javax.swing.JFrame {

    //Creates new form NewJFrame
    public Login() {
        initComponents();
        connectSQL();
    }

    //This method is called from within the constructor to initialize the form.
    //design layout for the scene
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login_button = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        login_button.setFont(new java.awt.Font("Stencil", 1, 18)); 
        login_button.setText("Login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 1, 18)); 
        jLabel1.setText("Username: ");

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 18)); 
        jLabel2.setText("Password:");

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("USER LOGIN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
    
    private JFrame frame;
    
    //start connection and verify the login information
    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // login to the system with username and password
        String user,pass;
        user = username.getText();
        pass = new String(password.getPassword());
        //connect to MySQL
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("USE hotelsystem");
            ResultSet rs = stmt.executeQuery("select * from admin;");
            int f=0;
            //get username and password from databse
            while(rs.next()){
                String usr = rs.getString("username");
                String pwd = rs.getString("password");
                if(user.equals(usr) && pass.equals(pwd)){
                    f=1;
                    break;
                }
            }
            rs.close();
            if(f==1){
                new MainScreen().setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid user id or Password");
                username.setText("");
                password.setText("");
            }
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            System.out.println("Esception: "+e);
        }
        
    }

    
    private void connectSQL(){
        //connect to MySQL and create new tables for database
    	
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS hotelsystem;");
            stmt.executeUpdate("USE hotelsystem");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS admin (id int NOT NULL PRIMARY KEY auto_increment,username varchar(20), password varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS staff (id int NOT NULL PRIMARY KEY auto_increment, name varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customer (customerID int NOT NULL PRIMARY KEY, customerName varchar(20) NOT NULL, contact varchar(20) NOT NULL, brithdate varchar(20));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bookings (id int primary key auto_increment, customerName  varchar(20), date varchar(20), room int NOT NULL,checkin varchar(30) not null,checkout varchar(30),amount int default 0 );");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS room (id int NOT NULL PRIMARY KEY, type varchar(20), price float NOT NULL, status varchar(20) );");
            ResultSet rs = stmt.executeQuery("select COUNT(*) from admin;");
            rs.next();
            String count = rs.getString("COUNT(*)");
            if(count.equals("0")){
                stmt.executeUpdate("INSERT into admin(id,username,password) values('0','admin','admin');");
            }
            rs = stmt.executeQuery("select COUNT(*) from room;");
            rs.next();
            count = rs.getString("COUNT(*)");
            
            //create some sample data
            if(count.equals("0")){
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('101','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('102','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('103','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('104','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('105','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('106','single','500','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('201','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('202','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('203','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('204','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('205','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('206','double','800','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('301','family','1200','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('302','family','1200','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('303','family','1200','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('304','family','1200','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('305','family','1200','empty');");
                stmt.executeUpdate("INSERT into room (id, type, price, status)values('306','family','1200','empty');");
            }
            
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Exception" + e);
        }
    }

    public static void main(String args[]) {
        // Set the Nimbus look and feel    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login_button;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;

}
