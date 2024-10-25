package Backtracking;

public class NQueen {
  // Function to print the solution
  public static void printSolution(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  // Function to check if a queen can be placed on board[row][col]
  public static boolean isSafe(int[][] board, int row, int col) {
    int n = board.length;

    // Check the column
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false;
      }
    }

    // Check upper diagonal on the left side
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    // Check upper diagonal on the right side
    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true; // If no conflicts, it's safe to place the queen
  }

  // Recursive utility function to solve the N-Queens problem
  public static boolean solveNQueensUtil(int[][] board, int row) {
    int n = board.length;

    // If all queens are placed, return true
    if (row >= n) {
      printSolution(board);
      return true;
    }

    boolean res = false;

    // Try placing a queen in all columns one by one
    for (int col = 0; col < n; col++) {
      // Check if it is safe to place the queen in board[row][col]
      if (isSafe(board, row, col)) {
        // Place the queen
        board[row][col] = 1;

        // Recur to place the rest of the queens
        res = solveNQueensUtil(board, row + 1) || res;

        // If placing the queen here leads to a solution, return true
        // Otherwise, backtrack by removing the queen
        board[row][col] = 0; // Backtrack
      }
    }

    return res;
  }

  // Main function to solve the N-Queens problem
  public static void solveNQueens(int n) {
    int[][] board = new int[n][n]; // Initialize a board of size n×n

    if (!solveNQueensUtil(board, 0)) {
      System.out.println("No solution exists");
    }
  }

  public static void main(String[] args) {
    int n = 4; // Input for 4-Queens problem
    solveNQueens(n);
  }
}
