
package hotel.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Junjie Wang & Yuhong Chen
 */
public class RoomBooking extends javax.swing.JFrame {

    /**
     * Creates new form RoomBooking
     */
    public RoomBooking() {
        initComponents();
    }
    private JFrame frame;
    int f=0;
    
    //This method is called from within the constructor to initialize the form.
    @SuppressWarnings("unchecked")
    
    //design layout
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back_button = new javax.swing.JButton();
        home_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namef = new javax.swing.JTextField();
        contactf = new javax.swing.JTextField();
        roomf = new javax.swing.JTextField();
        book_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        back_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        back_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-go-back-32.png"))); 
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        home_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        home_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-home-page-32.png"))); 
        home_button.setText("Home");
        home_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("Customer Name :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel3.setText("Contact Number:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel7.setText("Room Number :");

        namef.setFont(new java.awt.Font("Tahoma", 0, 18)); 

        contactf.setFont(new java.awt.Font("Tahoma", 0, 18)); 

        roomf.setFont(new java.awt.Font("Tahoma", 0, 18)); 

        book_button.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); 
        book_button.setText("Book");
        book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        jLabel2.setText("Room Booking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(home_button)
                .addGap(176, 176, 176)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back_button))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namef, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(book_button)))
                .addGap(171, 298, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(home_button)
                        .addComponent(back_button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contactf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(roomf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(book_button)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    //Back button action
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {

        new RoomList().setVisible(true);
        this.setVisible(false);
    }
    
    //Home button action
    private void home_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new MainScreen().setVisible(true);
        this.setVisible(false);
    }
    
    //get input from text area
    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = namef.getText();
        String contact = contactf.getText();
        String room = roomf.getText();
        if(name.equals("")||contact.equals("")||room.equals("")){
            JOptionPane.showMessageDialog(frame, "Please fill the details");
            return;
        }
        int l =contact.length();
        for(int i=0;i<l;i++){
            if(contact.charAt(i)>'9'||contact.charAt(i)<'0'||l!=10){
                JOptionPane.showMessageDialog(frame, "Invalid contact");
                return;
            }
        }
        Date date = new Date();
        long time = date.getTime();
        //connect to MySQL
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("use hotelsystem;");       
            ResultSet rs = stmt.executeQuery("select * from room where id="+room+";");
            rs.next();
            String type = rs.getString("type");
            String occ = rs.getString("occupied");
            if(occ=="occupied"){
                JOptionPane.showMessageDialog(frame, "Room is already occupied");
                return;
            }
            //make a booking
            if(f==1){
                stmt.executeUpdate("insert into customer(customerName,contact) values('"+name+"','"+contact+"');");
            }
            stmt.executeUpdate("insert into bookings(customerName,room,checkin) values('"+name+"','"+Integer.parseInt("romm")+",'"+time+"');");
            stmt.executeUpdate("update room set status=occupied where id="+Integer.parseInt("romm")+";");
            JOptionPane.showMessageDialog(frame, "Room Booked");
            new CustomerList().setVisible(true);
            this.setVisible(false);
            con.close();
            stmt.close();           
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }
        
    }/

    void setTextField(String room){
        roomf.setText(room);
    }
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomBooking().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton back_button;
    private javax.swing.JButton book_button;
    private javax.swing.JTextField contactf;
    private javax.swing.JButton home_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField namef;
    private javax.swing.JTextField roomf;

}
