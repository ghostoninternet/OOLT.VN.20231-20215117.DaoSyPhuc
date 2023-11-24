package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane; 

public class DisplayTriangle {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(
                            null, 
                            "Enter the triangle height: ", 
                            "Triangle", 
                            JOptionPane.INFORMATION_MESSAGE));

        String message = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                message += " ";
            }
            for (int k = 1; k <= 2*i - 1; k++) {
                message += "*";
            }
            message += "\n";
        }
        System.out.println(message);
    }
}
