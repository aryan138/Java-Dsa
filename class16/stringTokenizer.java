package class16;

import java.util.StringTokenizer;

public class stringTokenizer {
  public static void main(String[] args) {
    String a = "ar";
    String b = "Welcome aaa as : to : Chit    kara : . : How : are : You";
    StringTokenizer c = new StringTokenizer(b, a);
    int c1 = c.countTokens();
    System.out.println("Tokens = " + c1);
    for (int i = 0; i < c1; i++) {
      System.out.println(c.nextToken());
    }
    while (c.hasMoreTokens()) {
      System.out.println(c.nextElement());
    }
  }
}
// .nextToken() and .nextElement() are same
// .hasMoreToken() and .hasMoreElement() are same