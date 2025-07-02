package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.Utils;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 1.1.15
 *Напишите статический метод histogram(), который принимает в качестве apгументов
 *массив а[] значений типа int и целое число M и возвращает массив длиной M,
 *і-й элемент которого равен количеству появлений числа і в массиве-аргументе.
 *Если значения в а[] находятся между 0 и м-1, то сумма значений полученного массива
 * должна быть равна a.length.
 */
public class Exercise_15 {
  public static void main(String[] args) {
    int[] a = getFillArray();
    Utils.printArray(a);
    printf("\na[] length=%d\n", a.length);
    int M = 11;
    int[] histogramm = histogram(a, M);
    println("---------");
    Utils.printArray(histogramm);
    int sum = 0;
    for (int i = 0; i < M; i++) {
      sum += histogramm[i];
    }
    printf("\nsum=%d\n", sum);
  }

  private static int[] getFillArray() {
    int row = 10;
    int[] array = new int[row];
    for (int i = 0; i < row; i++) {
      array[i] = StdRandom.uniformInt(10);
    }
    return array;
  }

  private static int[] histogram(int[] a, int M) {
    int[] arrH = new int[M];
    for (int i = 0; i < M; i++) {
      int count = 0;
      for (int j = 0; j < a.length; j++) if (a[j] == i) count++;
      arrH[i] = count;
    }
    return arrH;
  }
}
