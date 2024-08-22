package class16;

import java.util.Scanner;

public class countAlpha {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int c = 1;

    for (int i = 0; i < s.length(); i++) {
      if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
        System.out.print(s.charAt(i) + "" + c);
        c = 1;
      } else {
        c++;
      }
    }
  }
}
