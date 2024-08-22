package class16;

import java.util.Scanner;

public class barcode {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int m,n;
            m=in.nextInt();
            int sum=27;
            int i=0;
            while(sum>26){
                if(i==0) {
                    sum=0;
                    i++;
                }
                System.out.println(sum);
                int y=m;
                while(y>0){
                    n=y%10;
                    sum=sum+n;
                    y=y/10;
                }
            }
            System.out.println(sum);
        }
    }
}
