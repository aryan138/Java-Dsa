// You are given a rod of length n and a price list arr[] where arr[i] represents the price of a rod of length i + 1. Your goal is to determine the maximum revenue you can obtain by cutting the rod into smaller pieces, and selling those pieces according to the given price list.
// Input: 
// arr[] = {3, 5, 8, 9, 10, 17, 17, 20}
// n = 8

// Output: 
// 24

// You are allowed to cut the rod into multiple pieces and sell the pieces. The prices are given for each length, and you want to find out the maximum profit you can make.

public class RodCutting {

    public static int rodCutting(int[] arr, int idx, int n) {
        // Base case: if we have reached the first rod, the only option is to cut the rod into pieces of length 1
        if (idx == 0) {
            return n * arr[0]; // Price is the price of the first length multiplied by how many times it can be used
        }

        // Option 1: Do not cut the current rod length (just take the result for the previous index)
        int notCut = rodCutting(arr, idx - 1, n);

        // Option 2: Cut the rod into smaller pieces
        int cut = Integer.MIN_VALUE;
        int rodLength = idx + 1; // the rod length corresponding to the current index

        // If we can cut a piece of this length (check if rodLength <= n)
        if (rodLength <= n) {
            cut = arr[idx] + rodCutting(arr, idx, n - rodLength); // Price of the current piece + the maximum revenue for remaining rod
        }

        // Return the maximum of cutting or not cutting the rod
        return Math.max(notCut, cut);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 10, 17, 17, 20}; // Prices for lengths 1 to 8
        int n = 8;  // Length of the rod
        System.out.println("Maximum revenue: " + rodCutting(arr, arr.length - 1, n));
    }
}
