package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.27
 * Биномиальное распределение. Оцените количество рекурсивных вызовов, которые
 *потребуются коду
 *для вычисления значения binomial(100, 50). Разработайте лучшую реализа-
 *цию, в которой вычисленные значения хранятся в массиве.
 */
public class Exercise_27 {
  public static void main(String[] args) {
    println(binomial(10, 5, 0.5));
  }

  public static double binomial(int N, int k, double p) {
    printf("1\n");
    if (k > N) return 0.0;

    if (N == 0 && k == 0) return 1.0;
    if (N < 0 || k < 0) return 0.0;
    return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
  }
}
