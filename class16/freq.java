package class16;

import java.util.Arrays;
import java.util.Scanner;

public class freq {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    Arrays.sort(arr);

    int l = -1;
    for (int i = 0; i < arr.length; i++) {
      int count = 1;
      while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
        count++;
        i++;
      }
      if (count == arr[i]) {
        l = arr[i];
      }
    }

    System.out.println(l);
  }
}
