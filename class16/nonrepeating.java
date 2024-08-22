package class16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class nonrepeating {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    Map<Character, Integer> v1 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      v1.put(c, v1.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < s.length(); i++) {
      if (v1.get(s.charAt(i)) == 1) {
        System.out.println(s.charAt(i));
        break;
      }

    }
    int maxi = 0;
    char ans = '\0';
    for (Map.Entry<Character, Integer> e : v1.entrySet()) {
      if (e.getValue() > maxi) {
        ans = e.getKey();
        maxi = e.getValue();
      }

    }
    System.out.println(ans);

  }

}
