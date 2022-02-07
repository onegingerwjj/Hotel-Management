
package hotel.management;

import javafx.application.Platform;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

/**
 *
 * @author Junjie Wang & Yuhong Chen
 */
public class HotelManagement extends JApplet {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    @Override
    public void init() {
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    
}
