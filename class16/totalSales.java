package class16;

import java.util.*;

public class totalSales {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), k = in.nextInt();
    int arr[] = new int[n], a = 1;
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = 1; j < n; j++) {
        if (arr[i] + arr[j] == k) {
          System.out.println(i + " " + j);
          a = 0;
          break;
        }
      }
      if (a == 0) {
        break;
      }

    }
  }
}
