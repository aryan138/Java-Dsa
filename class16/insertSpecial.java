package class16;

import java.util.Scanner;

public class insertSpecial {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int n = in.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = in.nextInt();
    }
    int c = 0;
    String st1 = "";
    for (int i = 0; i < s.length(); i++) {
      if (i == arr[c]) {
        st1 += "*";
        c++;
      }
      st1 += s.charAt(i);
    }
    System.out.println(st1);
  }
}
