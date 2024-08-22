package class16;

import java.util.Scanner;

public class reverse_string {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    for (int i = s.length() - 1; i >= 0; i--)
      System.out.print(s.charAt(i));
  }
}
