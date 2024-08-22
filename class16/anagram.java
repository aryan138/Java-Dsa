package class16;

import java.util.Scanner;

public class anagram {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();
    String s2 = in.nextLine();
    int arr1[] = new int[150];
    int arr2[] = new int[150];
    for (int i = 0; i < s1.length(); i++) {
      int ch = s1.charAt(i);
      arr1[ch]++;
    }
    for (int i = 0; i < s2.length(); i++) {
      int ch = s2.charAt(i);
      arr2[ch]++;
    }
    boolean flag = true;
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i])
        flag = false;
    }
    if (flag)
      System.out.println("Amalgam");
    else {
      System.out.println("not amalgam");
    }
  }
}
