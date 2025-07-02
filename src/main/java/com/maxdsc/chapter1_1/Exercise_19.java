package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

import edu.princeton.cs.algs4.Stopwatch;

/*
 * 1.1.19
 Каково наибольшее значение N, для которого программа вычисляет значение
F(N) менее чем за час? Разработайте лучшую реализацию F(N),
которая сохраняет вычисленные значения в массиве.
 * Ответ:
 */
public class Exercise_19 {
  public static void main(String[] args) {
    Stopwatch timer = new Stopwatch();
    for (int N = 0; N < 50; N++) {
      println(N + " " + F(N));
      double time = timer.elapsedTime();
      println("Time=" + time);
    }
  }

  private static long F(int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    return F(N - 1) + F(N - 2);
  }
}
