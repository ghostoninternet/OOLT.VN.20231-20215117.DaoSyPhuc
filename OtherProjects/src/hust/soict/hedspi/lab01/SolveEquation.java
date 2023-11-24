package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
import java.lang.Math;

public class SolveEquation {

    /**
     * The method is used for to take user input coefficients
     * 
     * @param title Title for the current input dialog
     * @return Return an array of user input coefficients
     * 
     */
    static double[] takeUserInput(String title) {
        double[] userNumsInput = new double[3];
        userNumsInput[0] = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input a:",
                title,
                JOptionPane.INFORMATION_MESSAGE));
        userNumsInput[1] = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input b:",
                title,
                JOptionPane.INFORMATION_MESSAGE));
        userNumsInput[2] = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Input c:",
                title,
                JOptionPane.INFORMATION_MESSAGE));

        return userNumsInput;
    }

    /**
     * The method is used to solve system linear equation
     */
    static void solveSystemEquation() {
        double[] firstEqCoeff = new double[3];
        double[] secondEqCoeff = new double[3];
        firstEqCoeff = takeUserInput("First equation in linear system equation"); 
        // Take all coefficients of the first linear equation

        secondEqCoeff = takeUserInput("second equation in linear system equation");
        // Take all coefficients of the second linear equation

        String equation1 = firstEqCoeff[0] + "x" + " + " + firstEqCoeff[1] + "y" + " = " + firstEqCoeff[2];
        // Make the first equation in system linear equation: a1 * x + b1 * y = c1

        String equation2 = secondEqCoeff[0] + "x" + " + " + secondEqCoeff[1] + "y" + " = " + secondEqCoeff[2];
        // Make the second equation in system linear equation: a2 * x + b2 * y = c2

        // Calculate D Dx Dy
        // Example: 
        //      a1 * x + b1 * y = c1
        //      a2 * x + b2 * y = c2
        //
        // D = a1*b2 - a2*b1
        // Dx = c1*b2 - c2*b1
        // Dy = a1*c2 - a2*c1
        double D = firstEqCoeff[0]*secondEqCoeff[1] - secondEqCoeff[0]*firstEqCoeff[1];
        double Dx = firstEqCoeff[2]*secondEqCoeff[1] - secondEqCoeff[2]*firstEqCoeff[1];
        double Dy = firstEqCoeff[0]*secondEqCoeff[2] - secondEqCoeff[0]*firstEqCoeff[2];

        // If D != 0 --> The system equation has roots!
        // If D == 0 --> Check if Dx != 0 or Dy != 0. If one of them != 0 then the system equation has no root!
        // else the system equation has infinite root!
        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            String message = "System equation " + equation1 + " and " + equation2 + " has result: " + "( " + x + ", " + y + " )"; 
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else if ( D == 0) {
            if (Dx != 0 || Dy != 0) {
                JOptionPane.showMessageDialog(null, "System equation has no root!", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String infiniteResult = "( " + firstEqCoeff[2] + " - " + firstEqCoeff[1] + "y )" +  "/" + firstEqCoeff[0];
                String messageInfinite = "Infinite Result! System equation " + equation1 + " and " + equation2 + " has result: " + infiniteResult;
                JOptionPane.showMessageDialog(null, messageInfinite, "Result", JOptionPane.INFORMATION_MESSAGE);  
            }
        }
    }

    /**
     * The method is used to solve second-degree equation: a * x^2 + b * x + c = 0
     * @param a First coefficient
     * @param b Second coefficient
     * @param c Third coefficient
     */
    static void solveSecondDegree(double a, double b, double c) {
        String equation = a + "x^2" + " + " + b + "x" + " + " + c + " = " + "0";
        double delta = Math.pow(b, 2) - 4 * a * c;
        double deltaSqrt = Math.sqrt(Math.abs(delta)); // Math.abs was used in case delta < 0

        // If a == 0 --> The second-degree equation turns into first-degree equation
        // If a != 0 
        //      --> Check if delta != 0 or not
        //      --> If delta == 0 --> The root is = -b / 2*a
        //      --> If delta != 0 --> Check if delta is > or < than 0. If > 0 --> 2 real roots. If < 0 --> 2 imaginary roots.
        if (a == 0) {
            solveFirstDegree(b, c, 0);
        } else {
            if (delta == 0) {
                double result = -b / 2 * a;
                JOptionPane.showMessageDialog(null, "Equation " + equation + " has result: " + result, "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (delta != 0) {
                double result1 = (-b + deltaSqrt) / 2 * a;
                double result2 = (-b - deltaSqrt) / 2 * a;
                if (delta < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Equation " + equation + " has result: " + result1 + " or " + result2, "Result",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Equation " + equation + " has result: " + result1 + " or " + result2, "Result",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    /**
     * This method is used to solve first-degree equation a*x + b = c
     * @param a First coefficient
     * @param b Second coefficient
     * @param c Third coefficient (This is not neccessary :v It was my logical fault that lead to this mistake)
     */
    static void solveFirstDegree(double a, double b, double c) {
        String equation = a + "x" + " + " + b + " = " + c;
        if (a == 0) {
            if (b != c) {
                JOptionPane.showMessageDialog(null, "Equation " + equation + " has no root!", "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Equation " + equation + " has infinite root!", "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double result = (c - b) / a;
            JOptionPane.showMessageDialog(null, "Equation " + equation + " has result: " + result, "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int i;
        String message = "Choose equation:\n1. Equation\n2. System Equation";
        String message2 = "Choose type of equation:\n1. First-degree\n2.Second-degree";
        double[] coefficients = new double[3];
        while (true) {
            i = Integer.parseInt(JOptionPane.showInputDialog(null, message, "Menu", JOptionPane.INFORMATION_MESSAGE));
            switch (i) {
                case 1:
                    i = Integer.parseInt(
                            JOptionPane.showInputDialog(null, message2, "Menu", JOptionPane.INFORMATION_MESSAGE));
                    switch (i) {
                        case 1:
                            coefficients = takeUserInput("Equation a*x + b = c");
                            solveFirstDegree(coefficients[0], coefficients[1], coefficients[2]);
                            break;
                        case 2:
                            coefficients = takeUserInput("Equation a*x^2 + b*x + c = 0");
                            solveSecondDegree(coefficients[0], coefficients[1], coefficients[2]);
                            break;
                    }
                    break;
                case 2:
                    solveSystemEquation();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
