package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/*
 * 1.1.22
 *Напишите версию программы BinarySearch, в которой задействован рекур-
 *сивный метод rank(), приведенный в листинге 1.1.1, и выполняется трассиров-
 *ка вызовов этого метода. При каждом вызове рекурсивного метода он должен
 *выводить значения lo и hi с отступом слева, соответствующим глубине рекур-
 *сии. Совет: добавьте в метод дополнительный аргумент, который будет отсле-
 *живать глубину рекурсии.
 * 1.1.23
 *Добавьте в клиент тестирования BinarySearch возможность реагировать на
 *второй аргумент: если он положителен, то должен выводить числа из стандарт-
 *ного ввода, которые отсутствуют в белом списке, а если отрицателен - кото-
 *рые присутствуют там.
 */
public class Exercise_22_23 {
  public static void main(String[] args) {
    if (args.length == 2) {
      In input = new In(args[0]);
      int[] whitelist = input.readAllInts();
      Arrays.sort(whitelist);
      for (int i = 0; i < whitelist.length; i++) {
        printf("%d ", whitelist[i]);
      }
      println();
      printf("lo ... ho\n");
      while (!StdIn.isEmpty()) {
        int key = StdIn.readInt();

        boolean mode;
        String infoText = "";
        if (Integer.parseInt(args[1]) > 0) {
          mode = rank(key, whitelist) == -1;
          infoText = "included in the list";
        } else {
          mode = rank(key, whitelist) != -1;
          infoText = "not included in the list";
        }

        if (mode) {
          StdOut.println(key);
        } else {
          printf("%d %s\n", key, infoText);
        }
      }
    } else {
      println("Args error");
    }
  }

  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    int deep = 0;
    while (lo <= hi) {
      printInfo(deep, lo, hi);
      deep++;
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

  private static void printInfo(int deep, int lo, int hi) {
    for (int i = 0; i < deep; i++) {
      printf("\t");
    }
    printf("%d ... %d\n", lo, hi);
  }
}
