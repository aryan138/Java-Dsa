package class16;

import java.util.Scanner;

public class pillars {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), c = 0;
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    int a = in.nextInt(), b = in.nextInt();
    for (int i = 0; i < arr.length; i++) {
      if (a % arr[i] == 0 && b % arr[i] == 0)
        c++;
    }
    System.out.println(c);
  }
}
