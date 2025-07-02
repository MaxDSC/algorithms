package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.14
 *Напишите статический метод 1g(), который принимает в качестве аргумента
 *значение N типа int и возвращает наибольшее целое число, не большее, чем
 *двоичный логарифм N. Не используйте библиотеку Math.
 */
public class Exercise_14 {
  public static void main(String[] args) {
    int N = 33;
    println(lg(N));
  }

  private static boolean check(int N) {
    boolean result = true;
    for (int i = N; i > 1; i /= 2) {
      if (i % 2 == 1) {
        result = false;
        break;
      }
    }
    return result;
  }

  private static int lg(int N) {
    int result = 0;
    for (int i = 2; i <= N; i *= 2) {
      result++;
    }
    return result;
  }
}
