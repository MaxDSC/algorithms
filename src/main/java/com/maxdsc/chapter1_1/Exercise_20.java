package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.20
 *Напишите рекурсивный статический метод, который вычисляет значение In(N!).
 */
public class Exercise_20 {
  public static void main(String[] args) {
    println(lnFactorial(10));
  }

  private static double lnFactorial(int N) {
    if (N <= 1) return 0;
    return Math.log(N) + lnFactorial(N - 1);
  }
}
