package class16;
import java.util.*;

public class class1 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in =  new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=2*n-1;i++){
            int x=n;
            for(int j=1;j<=2*n-1;j++){
                System.out.print(x+"  ");
                if(j<i)
                x--;
                if(j>(2*n)-1-i)
                x++;
            }
            System.out.println();
            System.out.println();

        }
    }
}
