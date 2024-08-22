package class16;

import java.util.Scanner;

public class palindrome {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine(), s1 = "";
    for (int i = s.length() - 1; i >= 0; i--)
      s1 += s.charAt(i);
    if (s1.equals(s))
      System.out.println("Pallindrome");
    else
      System.out.println("not pallindrome");
  }
}
