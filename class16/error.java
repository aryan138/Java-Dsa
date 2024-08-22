package class16;

import java.util.Scanner;

public class error {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = -10; i < 11; i++) {
      try {
        System.out.println(n / i);
      } catch (Exception e) {
        System.out.println("Division with zero not allowed");
      }
    }
  }
}
