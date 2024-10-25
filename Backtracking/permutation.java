package Backtracking;

// class Permutation {
//   public static void permute(char[] arr, int index, int r) {
//     if (index == r) {
//       System.out.println(String.valueOf(arr));
//     } else {
//       for (int i = index; i <= r; i++) {
//         swap(arr, index, i);
//         permute(arr, index + 1, r);
//         swap(arr, index, i);
//       }
//     }
//   }
//   public static void swap(char[] arr, int i, int j) {
//     char temp = arr[i];
//     arr[i] = arr[j];
//     arr[j] = temp;
//   }
//   public static void main(String[] args) {
//     String str = "ABC";
//     int n = str.length();
//     char[] arr = str.toCharArray();
//     permute(arr, 0, n - 1);
//   }
// }

class Solution {
  public static void permute(String str, String ans) {
    if (str.isEmpty()) {
      System.out.println(ans);
    } else {
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        String remaining = str.substring(0, i) + str.substring(i + 1);
        permute(remaining, ans + c);
      }
    }
  }

  public static void main(String[] args) {
    String str = "ABC";
    permute(str, "");
  }
}