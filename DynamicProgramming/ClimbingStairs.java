
import java.util.Arrays;

public class ClimbingStairs {

    public static int count_recursion(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return count_recursion(n - 1) + count_recursion(n - 2);
    }

    public static int count_memoization(int n,int dp[]) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        dp[n]=count_memoization(n - 1,dp) + count_memoization(n - 2,dp);
        return dp[n];
    }

    public static int count_tabulation(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=6;
        System.out.println(count_recursion(n));
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(count_memoization(n, ways));
        System.out.println(count_tabulation(n));
    }
}
