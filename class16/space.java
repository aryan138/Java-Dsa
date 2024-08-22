package class16;

import java.util.Scanner;

public class space {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isWhitespace(s.charAt(i)))
        continue;
      System.out.print(s.charAt(i));
    }
  }
}
