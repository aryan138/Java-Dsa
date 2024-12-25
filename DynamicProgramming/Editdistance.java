import java.util.Arrays;

public class Editdistance {

    static int editDistance(String s1, String s2, int n, int m) {
        // Base cases
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        // If last characters are the same, no need to edit this character
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return editDistance(s1, s2, n - 1, m - 1);
        }

        // If last characters are different, consider all three operations
        return 1 + Math.min(
                editDistance(s1, s2, n, m - 1), // Insert
                Math.min(
                        editDistance(s1, s2, n - 1, m), // Remove
                        editDistance(s1, s2, n - 1, m - 1) // Replace
                ));
    }

    static int editDistance_Memoization(String s1, String s2, int n, int m, int[][] dp) {
        // Base cases
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        // Check if result is already computed
        if (dp[n][m] != -1)
            return dp[n][m];

        // If last characters are the same, no need to edit this character
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = editDistance_Memoization(s1, s2, n - 1, m - 1, dp);
        } else {
            // If last characters are different, consider all three operations
            dp[n][m] = 1 + Math.min(
                    editDistance_Memoization(s1, s2, n, m - 1, dp), // Insert
                    Math.min(
                            editDistance_Memoization(s1, s2, n - 1, m, dp), // Remove
                            editDistance_Memoization(s1, s2, n - 1, m - 1, dp) // Replace
                    ));
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "hello";
        String s1 = "seldom";
        int result = editDistance(s, s1, s.length(), s1.length());
        int n = s.length();
        int m = s1.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Edit Distance: " + editDistance_Memoization(s, s1, n, m, dp));
        System.out.println("Edit Distance: " + result);
    }
}
