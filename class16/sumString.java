package class16;

import java.util.ArrayList;
import java.util.Scanner;

public class sumString {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine(), s1 = "";
    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isAlphabetic(s.charAt(i))) {
        s1 += s.charAt(i);
      } else {
        if (!s1.isEmpty()) {
          arr.add(s1);
          s1 = "";
        }
      }
    }
    if (!s1.isEmpty())
      arr.add(s1);
    int sum = 0;
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
      sum += Integer.parseInt(arr.get(i));
    }
    System.out.println(sum);
  }
}
