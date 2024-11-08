// Given two strings s1 and s2, write a Java program to find the length of their Longest Common Subsequence (LCS) using dynamic programming.
// The LCS is the longest sequence that appears in both strings in the same order, but not necessarily consecutively. For example, the LCS of "abcde" and "ace" is "ace" with a length of 3.



//DP
public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        // Create a 2D DP array to store lengths of LCS subproblem
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        // Fill the DP array
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                // If characters match, add 1 to the result of the previous characters
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // If they don't match, take the maximum of ignoring either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The value in dp[l1][l2] contains the length of the LCS
        return dp[l1][l2];
    }
    
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adc";
        System.out.println("Length of LCS: " + lcs(s1, s2));
    }
}

//recursion
//  class LongestCommonSubsequence_RE {
//     public static int lcs(String s1, String s2, int l1, int l2) {
//         if (l1 == 0 || l2 == 0)
//             return 0;
//         if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
//             return 1 + lcs(s1, s2, l1 - 1, l2 - 1);
//         else
//             return Math.max(lcs(s1, s1, l1 - 1, l2), lcs(s1, s2, l1, l2 - 1));
//     }
// }

