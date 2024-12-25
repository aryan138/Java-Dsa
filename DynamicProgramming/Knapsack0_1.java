import java.util.Arrays;

public class Knapsack0_1 {

    public static int knapsack_Recursion(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0)
            return 0;
        if (wt[n - 1] <= W) { // valid
            int ans1 = val[n - 1] + knapsack_Recursion(val, wt, W - wt[n - 1], n - 1); // include
            int ans2 = knapsack_Recursion(val, wt, W, n - 1); // exclude
            return Math.max(ans1, ans2);
        } else { // invalid
            return knapsack_Recursion(val, wt, W, n - 1); // exclude
        }
    }

    public static int knapsack_Memoization(int val[], int wt[], int W, int n, int[][] dp) {// tc -O(n*W)
        // Base case: no items left or no remaining capacity
        if (W == 0 || n == 0)
            return 0;

        // Check if the result is already computed
        if (dp[n][W] != -1)
            return dp[n][W];

        // If the current item's weight is less than or equal to W, consider including
        // it
        if (wt[n - 1] <= W) {
            int include = val[n - 1] + knapsack_Memoization(val, wt, W - wt[n - 1], n - 1, dp); // Include the item
            int exclude = knapsack_Memoization(val, wt, W, n - 1, dp); // Exclude the item
            dp[n][W] = Math.max(include, exclude);
        } else {
            // If the item is too heavy, skip it
            dp[n][W] = knapsack_Memoization(val, wt, W, n - 1, dp);
        }
        return dp[n][W];
    }

    public static int knapsack_Tabulation(int val[], int wt[], int W) {
        // Create a 2D array dp where dp[i][j] represents the maximum value
        // attainable with the first i items and a knapsack capacity of j
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        // Iterate through all items
        for (int i = 1; i <= n; i++) {
            // Iterate through all capacities from 0 to W
            for (int j = 0; j <= W; j++) {
                // If the current item's weight is less than or equal to the current capacity
                if (wt[i - 1] <= j) {
                    // Maximize value by either including or excluding the current item
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // Otherwise, exclude the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final answer will be in dp[n][W], the maximum value with n items and capacity W
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int n = val.length;

        // Memoization approach
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Maximum Knapsack Value (Memoization): " + knapsack_Memoization(val, wt, W, n, dp));
        // Recursive approach
        System.out.println("Maximum Knapsack Value (Recursion): " + knapsack_Recursion(val, wt, W, n));
        // Tabulation approach
        System.out.println("Maximum Knapsack Value (Tabulation): " + knapsack_Tabulation(val, wt, W));
    }
}
