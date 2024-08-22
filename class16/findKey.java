package class16;

import java.util.Scanner;

public class findKey {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
    int arr[] = { a, b, c }, st = 10000, lh = 0, sten = 10000, lu = 0;
    for (int i = 0; i < 3; i++) {
      st = Math.min(arr[i] / 1000, st);
      lh = Math.max((arr[i] / 100) % 10, lh);
      sten = Math.min((arr[i] / 10) % 10, sten);
      lu = Math.max(arr[i] % 10, lu);
    }
    System.out.println(st * 1000 + lh * 100 + sten * 10 + lu);
  }
}
