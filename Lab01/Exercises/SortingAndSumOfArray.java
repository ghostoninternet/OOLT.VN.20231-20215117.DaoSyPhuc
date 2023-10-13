import javax.swing.JOptionPane;
import java.util.Arrays;

public class SortingAndSumOfArray {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter size of array", "Size of Array", JOptionPane.INFORMATION_MESSAGE));
        int[] arrayOfNum = new int[n];
        for (int i = 0; i < n; i++) {
            arrayOfNum[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number for array", "Input", JOptionPane.INFORMATION_MESSAGE));
        }
        String messageArrayBeforeSort = "";
        for (int i = 0; i < n; i++) {
            messageArrayBeforeSort += arrayOfNum[i] + " ";
        }

        Arrays.sort(arrayOfNum);
        String messageArrayAfterSort = "";
        for (int i = 0; i < n; i++) {
            messageArrayAfterSort += arrayOfNum[i] + " ";
        }
        JOptionPane.showMessageDialog(null, "Array before: \n" + messageArrayBeforeSort, "Before", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Array after: \n" + messageArrayAfterSort, "After", JOptionPane.INFORMATION_MESSAGE);

        double sum = 0 ;
        for(int number : arrayOfNum)
        {
            sum += number ;
        }
        JOptionPane.showMessageDialog(null, "Sum of array: " + sum, "Result", JOptionPane.INFORMATION_MESSAGE);

        sum = sum / n ;
        JOptionPane.showMessageDialog(null, "Average of array: " + sum, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}


