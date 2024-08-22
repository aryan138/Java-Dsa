package class16;

import java.util.Scanner;

public class capatilize {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    StringBuilder s1 = new StringBuilder();

    boolean capitalizeNext = true;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isWhitespace(c)) {
        s1.append(c);
        capitalizeNext = true;
      } else if (capitalizeNext) {
        s1.append(Character.toUpperCase(c));
        capitalizeNext = false;
      } else {
        s1.append(Character.toLowerCase(c));
      }
    }

    System.out.println(s1.toString());
  }
}
