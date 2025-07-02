package com.maxdsc.chapter1_1;

import com.maxdsc.Utils;

/*
 * 1.1.30
 * Работа с массивом. Напишите фрагмент кода, который создает логический мас-
 *сив a[][] размером N× N - такой, что a[i][j] равно true, если і и j взаимно
 *просты (не имеют общего делителя), и false в противном случае.
 */
public class Exercise_30 {
  public static void main(String[] args) {
    boolean[][] arr = createArray(5);
    Utils.printArray(arr);
  }

  public static boolean[][] createArray(int N) {

    boolean[][] arr = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        boolean res = calc(i + 1, j + 1) == 1 ? true : false;
        arr[i][j] = res;
      }
    }
    return arr;
  }

  private static int calc(int p, int q) {
    if (q == 0) return p;
    return calc(q, p % q);
  }
}
