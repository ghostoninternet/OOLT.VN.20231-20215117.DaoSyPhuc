import javax.swing.JOptionPane;

public class SumTwoMatrices {
      public static void main(String[] args) {
            int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size of matrix", "Size of Matrix", JOptionPane.INFORMATION_MESSAGE));

            double[][] MatrixA = new double[n][n];
            double[][] MatrixB = new double[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    MatrixA[i][j] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                                            "Enter a number for position " + "(" + i + ", " + j + ") " + "of Matrix A", 
                                            "Enter elements", 
                                            JOptionPane.INFORMATION_MESSAGE));

                    MatrixB[i][j] = Double.parseDouble(JOptionPane.showInputDialog(null, 
                                            "Enter a number for position " + "(" + i + j + ") " + "of Matrix B", 
                                            "Enter elements", 
                                            JOptionPane.INFORMATION_MESSAGE));
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    MatrixA[i][j] += MatrixB[i][j];
                }
            }
            
            String message = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    message += MatrixA[i][j] + " ";
                }
                message += "\n";
            }
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
      }
}
