package Heap;

public class HeapCheck {

  static boolean isMinHeap(int[] arr, int n) {
    for (int i = 0; i <= (n - 2) / 2; i++) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (left < n && arr[i] > arr[left])
        return false;
      if (right < n && arr[i] > arr[right])
        return false;
    }
    return true;
  }

  static boolean isMaxHeap(int[] arr, int n) {
    for (int i = 0; i <= (n - 2) / 2; i++) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (left < n && arr[i] < arr[left])
        return false;
      if (right < n && arr[i] < arr[right])
        return false;
    }
    return true;
  }

  static int checkHeap(int[] arr) {
    int n = arr.length;
    if (isMinHeap(arr, n)) {
      return 0;
    } else if (isMaxHeap(arr, n)) {
      return 1;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    int arr1[] = { 3, 5, 7, 12, 10, 8 };

    System.out.println((checkHeap(arr1) == 0 ? "Min Heap" : checkHeap(arr1) == 1 ? "Max Heap" : "-1"));
  }
}
