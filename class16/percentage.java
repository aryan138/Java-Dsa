package class16;

import java.util.Scanner;

public class percentage {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String st = in.nextLine();
    int l = 0, u = 0, n = 0, s = 0;
    for (int i = 0; i < st.length(); i++) {
      char ch = st.charAt(i);
      if (Character.isLowerCase(ch))
        l++;
      else if (Character.isUpperCase(ch))
        u++;
      else if (48 <= ch && ch <= 57)
        n++;
      else
        s++;
    }
    System.out.println(l + " " + u + " " + n + " " + s);
  }
}
