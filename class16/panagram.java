package class16;

import java.util.Scanner;

public class panagram {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();
    int arr1[] = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      if (Character.isWhitespace(s1.charAt(i))) {
        continue;
      }
      int ch = s1.charAt(i) - 'a';
      arr1[ch]++;
    }
    boolean flag = true;
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] == 0) {
        flag = false;
        break;
      }
    }
    if (flag)
      System.out.println("Panagram");
    else {
      System.out.println("not Panagram");
    }
  }
}
