package Backtracking;

public class Sudoku {

  // Size of the grid (9x9)
  private static final int GRID_SIZE = 9;

  public static void main(String[] args) {
      // Sudoku puzzle (0 means unassigned cells)
      int[][] board = {
          {7, 0, 2, 0, 5, 0, 6, 0, 0},
          {0, 0, 0, 0, 0, 3, 0, 0, 0},
          {1, 0, 0, 0, 0, 9, 5, 0, 0},
          {8, 0, 0, 0, 0, 0, 0, 9, 0},
          {0, 4, 3, 0, 0, 0, 7, 5, 0},
          {0, 9, 0, 0, 0, 0, 0, 0, 8},
          {0, 0, 9, 7, 0, 0, 0, 0, 5},
          {0, 0, 0, 2, 0, 0, 0, 0, 0},
          {0, 0, 7, 0, 4, 0, 2, 0, 3}
      };

      if (solveBoard(board)) {
          System.out.println("Sudoku solved successfully!");
      } else {
          System.out.println("No solution exists.");
      }

      printBoard(board);
  }

  // Function to check if a number is valid at the given row and column
  private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
      // Check row
      for (int i = 0; i < GRID_SIZE; i++) {
          if (board[row][i] == number) {
              return false;
          }
      }

      // Check column
      for (int i = 0; i < GRID_SIZE; i++) {
          if (board[i][column] == number) {
              return false;
          }
      }

      // Check 3x3 grid
      int boxRow = row / 3 * 3;
      int boxCol = column / 3 * 3;

      for (int i = boxRow; i < boxRow + 3; i++) {
          for (int j = boxCol; j < boxCol + 3; j++) {
              if (board[i][j] == number) {
                  return false;
              }
          }
      }

      return true;
  }

  // Function to solve the Sudoku puzzle using backtracking
  private static boolean solveBoard(int[][] board) {
      for (int row = 0; row < GRID_SIZE; row++) {
          for (int col = 0; col < GRID_SIZE; col++) {
              // If the cell is empty (0)
              if (board[row][col] == 0) {
                  // Try placing numbers 1-9
                  for (int number = 1; number <= GRID_SIZE; number++) {
                      if (isValidPlacement(board, number, row, col)) {
                          board[row][col] = number;

                          // Recursively attempt to solve with this placement
                          if (solveBoard(board)) {
                              return true;
                          }

                          // If not solvable, backtrack by resetting the cell
                          board[row][col] = 0;
                      }
                  }

                  // If no number fits, return false (trigger backtracking)
                  return false;
              }
          }
      }

      // Puzzle solved
      return true;
  }

  // Function to print the Sudoku board
  private static void printBoard(int[][] board) {
      for (int row = 0; row < GRID_SIZE; row++) {
          if (row % 3 == 0 && row != 0) {
              System.out.println("-----------");
          }
          for (int col = 0; col < GRID_SIZE; col++) {
              if (col % 3 == 0 && col != 0) {
                  System.out.print("|");
              }
              System.out.print(board[row][col] == 0 ? " " : board[row][col]);
          }
          System.out.println();
      }
  }
}

