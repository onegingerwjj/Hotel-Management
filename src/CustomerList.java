
package hotel.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Junjie Wang & Yuhong Chen
 */
public class CustomerList extends javax.swing.JFrame {
	
	//Creates new form CustomerList
    public CustomerList() {
        initComponents();
        showDetails();
    }
    
    private JFrame frame;
    
    //set up connection to SQL
    public void showDetails(){
        DefaultTableModel model = (DefaultTableModel)table.getModel();  
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("use hotelsystem;");
            ResultSet rs=stmt.executeQuery("select * from bookings b join customer c where b.customerName =c.customerName and b.checkout is null;");
            while(rs.next()){
                String name=rs.getString("name");
                String contact=rs.getString("contact");
                int room=rs.getInt("room");
                
              model.addRow(new Object[]{name,contact,room,});
            }
            rs.close();  
            con.close();
            stmt.close();           
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }
        table.setModel(model);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    
    //design the layout of the scene
    //create event listener and handler
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        home_button = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        table.setBackground(new java.awt.Color(255, 204, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Contact", "Room number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        home_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        home_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-home-page-32.png"))); 
        home_button.setText("Home");
        home_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_buttonActionPerformed(evt);
            }
        });

        logout_button.setFont(new java.awt.Font("Kristen ITC", 1, 12)); 
        logout_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-exit-32.png"))); 
        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(home_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 682, Short.MAX_VALUE)
                .addComponent(logout_button))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_button)
                    .addComponent(home_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
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

    //event handler for home button
    private void home_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new MainScreen().setVisible(true);
        this.setVisible(false);
    }

    //event handler for logout button
    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    //event handler for input in the table
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.rowAtPoint(evt.getPoint());
        String room = (String) table.getValueAt(row, 3);
        String aadhar = (String) table.getValueAt(row, 2);
        
        
        Date date = new Date();
        long time = date.getTime();
        //set up connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con=DriverManager.getConnection("JDBC:mysql://localhost:3306/mysql","root","");
            Statement stmt;
            stmt=con.createStatement();
            stmt.executeUpdate("use hotelsystem;");
            
            //list out current customers and their information
            ResultSet rs=stmt.executeQuery("select * from bookings b join customer c where b.customerName =c.customerName and b.checkout is null;");
            rs.next();
            int id = rs.getInt("id");
            String amount = rs.getString("amount");
            String checkin = rs.getString("checkin");
            long chkin = Long.parseLong(checkin);
            long bill = Long.parseLong(amount);
            rs = stmt.executeQuery("select * from room where id="+Integer.parseInt("romm")+";");
            rs.next();
            int price = Integer.parseInt(rs.getString("price"));
            long div = 1000*60*60*24;
            long days = (time-chkin)/div+1;
            bill=bill+price*days;
            
            //checkout of a customer
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Bill: "+bill, "Do you Want to Checkout?", dialogButton);
            if(dialogResult == 0) {
                stmt.executeUpdate("update room set status=oppupied where id="+Integer.parseInt("romm")+";");
                stmt.executeUpdate("update bookings set checkout='"+time+"' where id="+id+";");
                stmt.executeUpdate("update bookings set amount="+bill+" where id="+id+";");
                JOptionPane.showMessageDialog(frame, "Checked Out");
                new CustomerList().setVisible(true);
                this.setVisible(false);
                con.close();
                stmt.close();          
            } 
            else{
                return;
            }             
        }
        catch(Exception e)
        {
            System.out.println("Esception: "+e);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* If Nimbus is not available, stay with the default look and feel.
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerList().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton home_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout_button;
    private javax.swing.JTable table;

}
