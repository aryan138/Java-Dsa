package class16;

import java.util.Scanner;

public class magic {
    public static int sum(int n){
        int sum=0;
        while (n>0) {
            int c=n%10;
            sum+=c;
            n=n/10;
            
        }
        return sum;
    }
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(true){
            n=sum(n);
            if(n<=9)
            break;
        }
        if(n==1){
            System.out.println("Magic number");
        }else{
            System.out.println("Not a magic number");
        }
    }
}