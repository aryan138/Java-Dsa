package class16;

import java.util.Scanner;

public class bitwisemax {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int k, n, maxand = 0, maxor = 0, maxxor = 0;
      n = in.nextInt();
      k = in.nextInt();
      for (int i = 1; i <= n - 1; i++) {
        for (int j = i + 1; j <= n; j++) {
          int and = i & j;
          int or = i | j;
          int xor = i ^ j;
          if (and < k && and > maxand)
            maxand = and;
          if (or < k && or > maxor)
            maxor = or;
          if (xor < k && xor > maxxor)
            maxxor = xor;
        }
      }
      System.out.println("Bitwise & maximun is " + maxand);
      System.out.println("Bitwise | maximun is " + maxor);
      System.out.println("Bitwise ^ maximun is " + maxxor);
    }
  }
}
