package class16;

import java.util.Scanner;

public class automorphic {
    public static void sum(int n){
        int s=n*n,l=0,a=n;
        while (n>0) {
            l++;
            n=n/10;
        }
        if(a==(s%Math.pow(10,l)))
            System.out.println("Automorphic nuber");
        else
            System.out.println("Not a automorphic number");
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sum(n);
    }
}
