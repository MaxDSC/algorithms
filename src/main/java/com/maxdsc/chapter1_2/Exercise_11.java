package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1_2.11 Разработайте реализацию типа SmartDate из нашего API-интерфейса Date, ко- торая должна
 * генерировать исключение, если ей попадается несуществующая дата.
 */
public class Exercise_11 {
  public static void main(String[] args) {
    try {
      StdOut.println(new SmartDate(29, 2, 2000));
      StdOut.println(new SmartDate(29, 2, 2024));
      StdOut.println(new SmartDate(28, 2, 1900));
      StdOut.println(new SmartDate(12, 0, 2025));
      StdOut.println(new SmartDate(0, 12, 2025));
      StdOut.println(new SmartDate(23, 22, 2025));
      StdOut.println(new SmartDate(152, 2, 2025));
      StdOut.println(new SmartDate(29, 2, 1900));
    } catch (IllegalArgumentException e) {
      StdOut.println(e.getMessage());
    }
  }
}
