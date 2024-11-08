public class Knapsack0_1 {

    public static int knapsack_Recursion(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0)
            return 0;
        if (wt[n - 1] <= W) {// valid
            int ans1 = val[n - 1] + knapsack_Recursion(val, wt, W - wt[n - 1], n - 1);// include
            int ans2 = knapsack_Recursion(val, wt, W, n - 1);// exclude
            return Math.max(ans1, ans2);
        } else {// invalid
            return knapsack_Recursion(val, wt, W, n - 1);// exclude
        }
    }

    public static int knapsack_Memoization(int val[], int wt[], int W, int n,int dp[]) {
        if (W == 0 || n == 0)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        if (wt[n - 1] <= W) {// valid
            int ans1 = val[n - 1] + knapsack_Memoization(val, wt, W - wt[n - 1], n - 1,dp);// include
            int ans2 = knapsack_Memoization(val, wt, W, n - 1,dp);// exclude
            return Math.max(ans1, ans2);
        } else {// invalid
            return knapsack_Memoization(val, wt, W, n - 1,dp);// exclude
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        System.out.println(knapsack_Recursion(val, wt, 7, val.length));
        //System.out.println(knapsack_Memoization(val, wt, 7, val.length));
    }
}
