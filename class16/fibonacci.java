package class16;

import java.util.Scanner;

public class fibonacci {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int a = 0, b = 1, sum = a + b, next = 0;

    if (n == 1) {
      sum = a;
    } else if (n == 2) {
      sum = a + b;
    } else {
      for (int i = 2; i < n; i++) {
        next = a + b;
        sum += next;
        a = b;
        b = next;
      }
    }

    System.out.println("Sum of first " + n + " Fibonacci numbers is: " + sum);
  }
}
