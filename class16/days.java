package class16;

import java.util.Scanner;

public class days {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        System.out.println("hours - "+n*24+"\nminutes - "+n*24*60+"\nseconds - "+n*24*60*60);
    }
}
