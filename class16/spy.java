package class16;

import java.util.Scanner;

public class spy {
    public static void sum(int n){
        int sum=0,p=1;
        while (n>0) {
            int c=n%10;
            sum+=c;
            p*=c;
            n=n/10;
            
        }
        if(sum==p){
            System.out.println("Spy number");
        }else{
            System.out.println("Not a Spy number");
        }
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sum(n);
    }
}
