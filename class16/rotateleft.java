package class16;

import java.util.Scanner;

public class rotateleft {
  public static String reverse(String s1) {
    String s2 = "";
    for (int i = s1.length() - 1; i >= 0; i--) {
      s2 += s1.charAt(i);
    }
    return s2;
  }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int c = in.nextInt();
    System.out.println(s.substring(c, s.length()) + s.substring(0, c));
    System.out.println(reverse(s.substring(0, c + 1)) + reverse(s.substring(c + 1, s.length())));
  }
}
