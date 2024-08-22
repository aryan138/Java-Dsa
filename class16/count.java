package class16;

import java.util.Scanner;

public class count {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String st = in.nextLine();
    st = " " + st;
    int c = 0;
    for (int i = 0; i < st.length() - 1; i++) {
      if (Character.isWhitespace(st.charAt(i)) && Character.isLetter(st.charAt(i + 1))) {
        c++;
      }
    }
    System.out.println(c);
  }
}
