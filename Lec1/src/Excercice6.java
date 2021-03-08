import javax.swing.*;

public class Excercice6 {
    public static void main(String[] args) {
        System.out.println("Caculate x in: ax + b =0");
        String strNum1, strNum2;
        double INFINITIVE_VALUE = 999999999;
        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number:",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number:",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        if (a == 0.0){
            if (b==0.0){
                System.out.println("All value of x is accepted!");
                System.exit(0);
            } else {
                System.out.println("No variable can accept");
                System.exit(0);
            }
        }
        System.out.println("Value of x approved is:" + b/a);
    }
}
