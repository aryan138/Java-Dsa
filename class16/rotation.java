package class16;

import java.util.Scanner;

public class rotation {
  public static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    String concatenated = s1 + s1;

    return concatenated.contains(s2);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter first string:");
    String s1 = scanner.nextLine();

    System.out.println("Enter second string:");
    String s2 = scanner.nextLine();

    if (isRotation(s1, s2)) {
      System.out.println(s2 + " is a rotation of " + s1);
    } else {
      System.out.println(s2 + " is not a rotation of " + s1);
    }

    scanner.close();
  }
}
