import javax.swing.JOptionPane;

public class CalculateDouble {
    static double sum(double num1, double num2) {
        return num1 + num2;
    }

    static double difference(double num1, double num2) {
        return num1 - num2;
    }

    static double product(double num1, double num2) {
        return num1 * num2;
    }

    static double quotient(double num1, double num2) {
        if ((num2 == 0) && (num1 < 0)) {
            System.out.println("MINUS INFINITY");
            return Double.NEGATIVE_INFINITY * 1.0;
        } else if ((num2 == 0) && (num1 > 0)) {
            System.out.println("POSITIVE INFINITY");
            return Double.POSITIVE_INFINITY * 1.0;
        }
        return num1 / num2;
    }
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                        "Input the first number",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE));

        double num2 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                        "Input the second number",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE));

        System.out.println("The result of sum: " + sum(num1, num2));
        System.out.println("The result of difference: " + difference(num1, num2));
        System.out.println("The result of product: " + product(num1, num2));
        System.out.println("The result of division: " + quotient(num1, num2));
    }
}