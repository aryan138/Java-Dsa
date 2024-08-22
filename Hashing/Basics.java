package Hashing;

import java.util.*;
import java.util.Map.Entry;

public class Basics {
  public static void main(String[] args) {
    // Create
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("India", 100);
    hm.put("China", 150);
    hm.put("Nepal", 10);
    hm.put("US", 50);

    // Iterate
    Set<String> keys = hm.keySet();
    System.out.println(keys);
    for (String k : keys) {
      System.out.println("keys=" + k + ",value=" + hm.get(k));
    }
    Set<Entry<String, Integer>> k = hm.entrySet();
    System.out.println(k);
  }
}
