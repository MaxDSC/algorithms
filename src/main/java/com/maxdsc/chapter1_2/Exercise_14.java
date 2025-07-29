package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1_2.14 Разработайте реализацию метода equals() для типа Transaction по образу метода equals() для
 * типа Date (листинг 1.2.5).
 */
public class Exercise_14 {
  public static void main(String[] args) {
    Transaction tr = new Transaction("max 04.07.2025 1000");
    Transaction tr1 = new Transaction("nick 04.07.2025 3456");
    Transaction tr2 = new Transaction("max 04.07.2025 1000");
    println(tr.equals(tr1));
    println(tr.equals(tr2));
  }
}
