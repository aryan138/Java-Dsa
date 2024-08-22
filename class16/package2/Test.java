package class16.package2;

import class16.MATH.*;
// import class16.package1.Demo;

public class Test {
    public static void main(String[] args) {
        // Demo demo = new Demo();
        // demo.msg();
        // class16.package1.Demo obj = new class16.package1.Demo();
        // obj.msg();
        Operators operators = new Operators();
        combine combine = new combine();

        // Test Operators class
        System.out.println("Addition: " + operators.add(5, 3));
        System.out.println("Subtraction: " + operators.subtract(5, 3));
        System.out.println("Multiplication: " + operators.multiply(5, 3));
        System.out.println("Division: " + operators.divide(5, 3));
        System.out.println("Modulus: " + operators.mod(5, 3));

        // Test Combine class
        System.out.println("Minimum: " + combine.min(5, 3));
        System.out.println("Maximum: " + combine.max(5, 3));
        System.out.println("Mid: " + combine.mid(5));
    }
}
