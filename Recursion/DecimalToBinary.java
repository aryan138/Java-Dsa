package Recursion;

public class DecimalToBinary {
  static String convert(long n, String s) {
    if (n == 0)
      return s;
    return convert(n / 2, n % 2 + s);
  }

  public static void main(String[] args) {
    System.out.println(convert(3, ""));
  }
}
