package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        
        int option = JOptionPane.showConfirmDialog(null, 
                    "Do you want to change the first ticket?",
                    "Ask",
                    JOptionPane.YES_NO_OPTION);
        
        JOptionPane.showMessageDialog(null, "You've chosen: "
                    + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
