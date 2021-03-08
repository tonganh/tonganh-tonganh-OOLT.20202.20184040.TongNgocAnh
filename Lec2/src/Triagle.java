import java.util.Scanner;

public class Triagle {
    public static void main(String[] args) {
    int n;
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhap n:");
    n = sc.nextInt();
//    First way
        for(int i=0; i < n; i++){
            for (int j=n-1-i;j>0;j--){
                System.out.printf(" ");
            }
            for (int q=1;q<=2*i +1;q++)
            {
                System.out.printf("*");
            }
            System.out.println("");
        }
//    Second way
//        for (int i=1; i<=n; i++){
//            for (int j=1;j<=n-i;j++) System.out.print(" ");
//            for (int q=1;q<=i;q++) System.out.print("* ");
//            System.out.println("");
//        }
    }
}
