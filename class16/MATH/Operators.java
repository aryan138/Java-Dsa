package class16.MATH;

public class Operators {
  public double add(double a, double b) {
    return a + b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double divide(double a, double b) {
    if (b == 0) {
      throw new IllegalArgumentException("Division by zero is not allowed.");
    }
    return a / b;
  }

  public int mod(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Modulus by zero is not allowed.");
    }
    return a % b;
  }
}
