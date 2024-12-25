public class CoinsChange {
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize the first column to 1, as there's one way to make sum 0 (using no coins).
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // Loop through coins and sum values
        for (int i = 1; i <= n; i++) {
            int v = coins[i - 1];
            for (int j = 1; j <= sum; j++) {
                if (v <= j)
                    dp[i][j] = dp[i][j - v] + dp[i - 1][j]; // Include the coin or exclude it
                else
                    dp[i][j] = dp[i - 1][j]; // Exclude the coin
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        System.out.println("Number of ways to make change: " + coinChange(coins, sum));
    }
}
