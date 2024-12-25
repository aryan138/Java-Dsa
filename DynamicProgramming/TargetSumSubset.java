
public class TargetSumSubset {

    public static boolean targetSum_Recursion(int[] num, int target, int n) {
        // Base cases
        if (target == 0)
            return true; // If target is 0, subset exists (empty subset)
        if (n == 0)
            return false; // If no items left and target isn't 0, no solution

        // If the current item's value is less than or equal to target, we have two options:
        // 1. Include the item and reduce the target by num[n - 1]
        // 2. Exclude the item and keep the target as is
        if (num[n - 1] <= target) {
            // Check if including or excluding the item can reach the target
            return targetSum_Recursion(num, target - num[n - 1], n - 1) || targetSum_Recursion(num, target, n - 1);
        } else {
            // If current item's value exceeds target, we cannot include it, so we skip it
            return targetSum_Recursion(num, target, n - 1);
        }
    }

    public static boolean targetSum_Memoization(int[] num, int target, int n, Boolean[][] dp) {
        // Base cases
        if (target == 0)
            return true; // If target is 0, subset exists (empty subset)
        if (n == 0)
            return false; // If no items left and target isn't 0, no solution
        // Check if we have already computed this subproblem
        if (dp[n][target] != null)
            return dp[n][target];
        // Recursive case with memoization
        if (num[n - 1] <= target) {
            // Check including or excluding the item
            dp[n][target] = targetSum_Memoization(num, target - num[n - 1], n - 1, dp)
                    || targetSum_Memoization(num, target, n - 1, dp);
        } else {
            // Item too large to include, skip it
            dp[n][target] = targetSum_Memoization(num, target, n - 1, dp);
        }
        return dp[n][target];
    }

    public static boolean targetSum_Tabulation(int[] num, int target) {
        int n = num.length;
        // Initialize a dp table with false values
        boolean[][] dp = new boolean[n + 1][target + 1];
        // Base case: target sum of 0 can always be achieved with an empty subset
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (num[i - 1] <= j && dp[i - 1][j - num[i - 1]]) {
                    // Include the item or exclude it
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    // Item is too heavy to include, so exclude it
                    dp[i][j] = true;
                }
            }
        }
        // The answer is in the bottom-right cell, indicating if we can achieve 'target' with all items
        return dp[n][target];
    }

    public static void main(String[] args) {
        int num[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        int n = num.length;

        // Memoization approach
        Boolean[][] dp = new Boolean[n + 1][target + 1];
        System.out.println("Target Sum (Memoization): " + targetSum_Memoization(num, target, n, dp));
        // Recursive approach
        System.out.println("Target Sum (Recursion): " + targetSum_Recursion(num, target, n));
        // Tabulation approach
        System.out.println("Target Sum (Tabulation): " + targetSum_Tabulation(num, target));
    }
}
