package class16;

import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;

        System.out.println("Enter the number of rows:");
        m = in.nextInt();
        int arr[][] = new int[m][];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the number of columns for row " + (i + 1) + ":");
            n = in.nextInt();
            arr[i] = new int[n];
            System.out.println("Enter the elements for row " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println("The 2D array is:");
        for (int i = 0; i < m; i++) {
            int sum=0;
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                sum+=arr[i][j];
            }
            System.out.print("\t"+sum);
            System.out.println();
        }

        in.close();
    }
}
