package class16;

import java.util.Scanner;

public class reverse {
  public static String revers(String s1) {
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
    String s1 = "", s3 = "";

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isWhitespace(ch)) {
        s3 += revers(s1) + ch;
        s1 = "";
      } else {
        s1 += ch;
      }
    }
    s3 += revers(s1);

    System.out.println(s3);
  }
}
