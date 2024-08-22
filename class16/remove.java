package class16;

import java.util.Scanner;

public class remove {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    String ch = in.next();
    s = s.replaceAll(ch.toLowerCase(), "");
    s = s.replaceAll(ch.toUpperCase(), "");
    System.out.println(s);
  }
}
