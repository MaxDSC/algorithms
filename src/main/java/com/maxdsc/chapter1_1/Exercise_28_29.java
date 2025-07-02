package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

/* 1.1.28
 * Удаление дубликатов. Измените клиент тестирования в программе BinarySearch,
 *чтобы после сортировки белого списка из него удалялись все повторяющиеся
 *ключи.
 *1.1.29
 * Равные ключи. Добавьте в программу BinarySearch статический метод rank(),
 *который принимает в качестве аргументов ключ и упорядоченный массив цело-
 *численных значений (некоторые могут повторяться) и возвращает количество
 *элементов, меньших ключа. Добавьте также аналогичный метод count(), кото-
 *рый подсчитывает количество элементов, равных нулю. Примечание: если і и
 *j - 3haчения, возвращенные вызовами rank(key, a) и count(key, a) coot-
 *ветственно, то a[i…i+j-1] - значения в массиве, равные key.
 */

public class Exercise_28_29 {
  public static void main(String[] args) {
    int[] whitelist = In.readInts(args[0]);
    Arrays.sort(whitelist);
    // int total=whitelist.length;
    // whitelist = deleteRepeats(whitelist);
    printArray(whitelist);
    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int keyIndex = rank(key, whitelist);
      if (keyIndex != -1) {
        printf("KEY=%d\n", key);
        int countLessKey = 0;
        for (int i = 0; i < keyIndex; i++) {
          countLessKey++;
        }
        printf("%d\n", countLessKey);
      }
    }

    printf("ZERO ELEMENTS=");
    count(whitelist);
    // printf("Delete %d repeats\n", total - whitelist.length );
  }

  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void count(int[] a) {
    int zeroIndex = rank(0, a);
    if (zeroIndex != -1) {
      int countZeroElements = 0;
      for (int i = 0; i < zeroIndex; i++) {
        countZeroElements++;
      }
      printf("%d\n", countZeroElements);
    }
  }

  public static int[] deleteRepeats(int[] a) {
    int count_repeats = 0;
    int[] tempArr = new int[a.length];
    int n = 0;
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] != a[i + 1]) {
        tempArr[n] = a[i];
        n++;
      } else {
        count_repeats++;
      }
    }
    tempArr[n] = a[a.length - 1];
    int[] resultArr = new int[a.length - count_repeats];
    for (int i = 0; i < resultArr.length; i++) resultArr[i] = tempArr[i];

    return resultArr;
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      printf("%d ", a[i]);
    }
    printf("\n");
  }
}
