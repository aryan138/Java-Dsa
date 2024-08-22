package class16;

import java.util.Arrays;
import java.util.Scanner;

public class kthLargest {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int n = in.nextInt(), k = in.nextInt(), c = 0;
      int arr[] = new int[n];
      int x = 0;

      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }

      Arrays.sort(arr);

      for (int i = arr.length - 2; i >= 0; i--) {
        if (arr[i] != arr[i + 1]) {
          c++;
        }

        if (c == k) {
          System.out.println(arr[i]);
          x = 1;
          break;
        }
      }

      if (x == 0)
        System.out.println("Invalid");
    }
  }
}
