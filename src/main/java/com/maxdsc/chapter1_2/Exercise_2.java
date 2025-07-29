package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import java.util.InputMismatchException;

/**
 * 1_2.2 Напишите клиент класса Interval1D, который принимает в командной строке целое значение N,
 * читает из стандартного ввода N интервалов (каждый из кото- рых определен парой значений double) и
 * выводит все пересекающиеся пары.
 */
public class Exercise_2 {
  public static void main(String[] args) {
    try {
      int N = Integer.parseInt(args[0]);
      if (N > 1) {
        Interval1D[] intervals = inputIntervals(N);
        for (int i = 0; i < intervals.length; i++) printf("[%d] %s\n", i, intervals[i]);
        println("------------------------");
        for (int i = 0; i < N; i++) {
          Interval1D[] in = getIntersectsIntervals(intervals[i], intervals);
          if (in == null) {
            printf("Interval #%d - Count Intersects=0\n", i);
          } else {
            printf("Interval #%d - Count Intersects=%d\n", i, in.length);
            for (int j = 0; j < in.length; j++) println(in[j]);
          }
        }
      } else {
        printf("args[0]-N must be > 1\n");
      }
    } catch (Exception e) {
      printf("Argument Error\n");
      println(e.toString());
    }
  }

  private static Interval1D[] getIntersectsIntervals(
      Interval1D interval, Interval1D[] allIntervals) {
    int countAll = allIntervals.length;
    Interval1D[] temp = new Interval1D[countAll];
    int countIntr = 0;
    for (int i = 0; i < countAll; i++) {
      if (!interval.equals(allIntervals[i]) && interval.intersects(allIntervals[i])) {
        temp[countIntr] = allIntervals[i];
        countIntr++;
      }
    }

    Interval1D[] intersects = null;
    if (countIntr > 0) {
      intersects = new Interval1D[countIntr];
      for (int i = 0; i < countIntr; i++) intersects[i] = temp[i];
    }

    return intersects;
  }

  private static Interval1D[] inputIntervals(int N) {
    Interval1D[] intervals = new Interval1D[N];
    for (int i = 0; i < N; i++) {
      try {
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();
        intervals[i] = new Interval1D(min, max);
      } catch (InputMismatchException e) {
        intervals = null;
        println(e.toString());
        break;
      }
    }
    return intervals;
  }
}
