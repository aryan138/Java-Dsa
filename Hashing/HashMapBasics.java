package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapBasics {
  static class HashMap<K, V> {// generic
    private class Node {
      K key;
      V value;

      public Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int n;// n
    private int N;
    private LinkedList<Node> buckets[];// N

    @SuppressWarnings("unchecked")
    public HashMap() {
      this.N = 4;
      this.buckets = new LinkedList[4];
      for (int i = 0; i < 4; i++) {
        this.buckets[i] = new LinkedList<>();
      }
    }

    private int hashFunction(K key) {
      int hc = key.hashCode();
      // 12345;-123456
      return Math.abs(hc) % buckets.length;
    }

    private int SearchInLL(K key, int bi) {
      LinkedList<Node> ll = buckets[bi];
      int di = 0;
      for (int i = 0; i < ll.size(); i++) {
        Node node = ll.get(i);
        if (node.key == key) {
          return di;
        }
        di++;
      }
      return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
      LinkedList<Node> oldBuck[] = buckets;
      buckets = new LinkedList[N * 2];
      N = 2 * N;
      for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new LinkedList<>();
      }
      // nodes add in buckets
      for (int i = 0; i < oldBuck.length; i++) {
        LinkedList<Node> ll = oldBuck[i];
        while (!ll.isEmpty()) { // Corrected this loop to ensure all elements are rehashed
          Node node = ll.removeFirst();
          put(node.key, node.value);
        }
      }
    }

    public void put(K key, V value) {
      // bi=bucket index di=data index
      int bi = hashFunction(key);// 0 to 3
      int di = SearchInLL(key, bi);// valid:-1
      if (di != -1) {
        Node node = buckets[bi].get(di);
        node.value = value;
      } else {
        buckets[bi].add(new Node(key, value));
        n++;
      }
      double lambda = (double) n / N;
      if (lambda > 2.0) {
        rehash();
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);
      if (di != -1) {// valid
        return true;
      } else {
        return false;
      }
    }

    public V get(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);
      if (di != -1) {// valid
        Node node = buckets[bi].get(di);
        return node.value;
      } else {
        return null;
      }
    }

    public V remove(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);
      if (di != -1) {// valid
        Node node = buckets[bi].remove(di);
        n--;
        return node.value;
      } else {
        return null;
      }
    }

    public ArrayList<K> keySet() {
      ArrayList<K> keys = new ArrayList<>();
      for (int i = 0; i < buckets.length; i++) {
        LinkedList<Node> ll = buckets[i];
        for (Node node : ll) {
          keys.add(node.key);
        }
      }
      return keys;
    }

    public boolean isEmpty() {
      return n == 0;
    }
  }

  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("India", 100);
    hm.put("China", 150);
    hm.put("US", 50);
    hm.put("Nepal", 5);
    hm.put("a", 1000);
    hm.put("h", 15);
    hm.put("S", 500);
    hm.put("l", 6);
    hm.put("I", 90);
    hm.put("C", 10);
    hm.put("U", 80);
    hm.put("e", 7);

    ArrayList<String> keys = hm.keySet();
    for (String key : keys) {
      System.out.print(key + " ");
    }
    System.out.println();
    System.out.println(hm.get("India"));
    System.out.println(hm.remove("India"));
    System.out.println(hm.get("India"));
  }
}
