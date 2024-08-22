package class16;

import java.util.Scanner;

public class removeAlpha {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    System.out.println(s.replaceAll("[a-zA-Z0-9]", ""));
    // for (int i = 0; i < s.length(); i++) {
    // if (Character.isUpperCase(s.charAt(i)) || Character.isLowerCase(s.charAt(i))
    // || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
    // continue;
    // else
    // System.out.print(s.charAt(i));
    // }
  }
}
