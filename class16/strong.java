package class16;

import java.util.Scanner;

public class strong {
    public static void sum(int n){
        int sum=0,p=n;
        while (n>0) {
            int c=n%10;
            sum+=fact(c);
            n=n/10;
            
        }
        if(sum==p){
            System.out.println("Strong number");
        }else{
            System.out.println("Not a Strong number");
        }
    }
    public static int fact(int c){
        int p=1;
        while(c!=1){
            p*=c;
            c--;
        }
        return p;
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sum(n);
    }
}
