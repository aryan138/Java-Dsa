package class16;

import java.util.Scanner;

public class substring {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String st = in.nextLine();
    for (int i = 0; i < st.length(); i++) {
      for (int j = i + 1; j <= st.length(); j++) {
        System.out.println(st.substring(i, j));
      }
    }
  }
}
