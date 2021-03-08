import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        int n;
//        declare to get input from input- next line
        Scanner sc = new Scanner(System.in);
//        Get input of n- how many you want to save in array
        System.out.printf("Array have n value, type n:");
        n = sc.nextInt();
//        Array have maximum length is 10
        int[] array = new int[n];
//       printf in terminal
        System.out.println("Enter the elements of the array:");
//        run loop to get data
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Array element here:");
//        Before sort
        for (int i = 0; i < n; i++) {
            System.out.println("value of " + i + "is " + array[i]);
        }

        System.out.println("-------------------------");
//        using array sort to sort data in array
        Arrays.sort(array);
//        printf result after sort
        for (int i = 0; i < n; i++) {
            System.out.println("value of " + i + "is " + array[i]);
        }
    }
}
