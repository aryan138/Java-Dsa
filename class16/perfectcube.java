package class16;

import java.util.Scanner;

public class perfectcube {
  private static boolean perfectCube(int num) {
    int cubeRoot = (int) Math.cbrt(num);
    return cubeRoot * cubeRoot * cubeRoot == num;
  }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    for (int i = 0; i < arr.length; i++) {
      if (perfectCube(arr[i]))
        System.out.print(arr[i] + ", ");
    }
  }
}
