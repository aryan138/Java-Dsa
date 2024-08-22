package class16;

import java.util.Scanner;

public class maths {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int g=in.nextInt();
        int j=0,c;
        while(n>0){
            c=n%10;
            if(c!=g)
            j++;
            n=n/10;
        }
        System.out.println(j);
    }
}