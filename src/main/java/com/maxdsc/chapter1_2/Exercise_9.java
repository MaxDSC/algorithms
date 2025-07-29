package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * 1_2.9 Добавьте в класс BinarySearch тип Counter для подсчета об- щего количества ключей,
 * просмотренных во время всех поисков, с последую- щим выводом этого количества после завершения
 * всех поисков. Совет: создай- те переменную Counter в методе main() и передайте ее в качестве
 * аргумента методу rank().
 */
public class Exercise_9 {
  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] allowlist = in.readAllInts();
    Arrays.sort(allowlist);
    Counter counter = new Counter("keys");
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      if (Exercise_9.rank(allowlist, key, counter) == -1) {
        StdOut.println(key);
        StdOut.println(counter);
      }
    }
  }

  public static int rank(int[] a, int key, Counter counter) {
    int lo = 0;
    int hi = a.length - 1;
    counter.increment();
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
}
