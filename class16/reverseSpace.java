package class16;

import java.util.ArrayList;
import java.util.Scanner;

public class reverseSpace {

  public static class reverse {
    public static String revers(String s1, ArrayList<Integer> arr) {
      String s2 = "";
      int c = 0;
      for (int i = s1.length() - 1; i >= 0; i--) {
        if (arr.get(c) == s1.length() - i - 1) {
          s2 += " ";
        }
        s2 += s1.charAt(i);
      }
      return s2;
    }

    public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      String s = in.nextLine();
      String s1 = "";
      ArrayList<Integer> arr = new ArrayList<>();

      for (int i = 0; i < s.length(); i++) {
        if (Character.isWhitespace(s.charAt(i))) {
          arr.add(i);
          continue;
        }
        s1 += s.charAt(i);
      }

      System.out.println(revers(s1, arr));
    }
  }
}
