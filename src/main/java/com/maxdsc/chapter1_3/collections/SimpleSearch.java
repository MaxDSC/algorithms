package com.maxdsc.chapter1_3.collections;

public class SimpleSearch {
  public static boolean contains(String[] arr, String s) {
    boolean result = false;
    for (String p : arr) {
      if (s.equals(p)) {
        return true;
      }
    }
    return result;
  }
}
