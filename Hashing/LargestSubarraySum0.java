package Hashing;

import java.util.*;

public class LargestSubarraySum0 {
  public static void main(String[] args) {
    int arr[] = { 5, -2, 2, -8, 1, 7, 10, 23 };
    HashMap<Integer, Integer> map = new HashMap<>();
    // (sum,idx)
    int sum = 0, len = 0;
    for (int j = 0; j < arr.length; j++) {
      sum += arr[j];
      if (map.containsKey(sum)) {
        len = Math.max(len, j - map.get(sum));
      } else {
        map.put(sum, j);
      }
    }
    System.out.println("largest subarray wit sum as 0 => " + len);
  }
}
