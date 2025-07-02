package com.maxdsc.chapter1_1;

import static java.lang.Math.abs;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 1.1.32
 * Гистограмма. Пусть поток стандартного ввода содержит последовательность чи-
 *сел типа double. Напишите программу, которая принимает из командной стро-
 *ки целое число N и два вещественных значения l и r StdDraw для вывода
 *гистограммы количеств чисел, которые попали в каждый из интервалов,
 *полученных делением интервала (I, r) на N меньших интервалов равного размера.
 */
public class Exercise_32 {
  public static void main(String[] args) {
    int N = 20;
    double l = 0;
    double r = 100;
    double[] number = new double[20];
    for (int i = 0; i < number.length; i++) {
      number[i] = StdRandom.uniformDouble(0, 101);
    }
    StdDraw.setXscale(0, N + 1);
    StdDraw.setYscale(0, N * 10 + 1);

    double[][] histogramm = getHistogrammArray(number, N, l, r);
    StdDraw.setPenRadius(0.0033);
    StdDraw.line(0.25, 30, N - 0.1, 30);
    StdDraw.line(0.25, 30, 0.25, N * 10 - 10);
    StdDraw.setPenRadius(0.01);

    for (int i = 0; i < N; i++) {
      StdDraw.filledRectangle(0.5 + i, 30 + histogramm[1][i], 0.1, histogramm[1][i]);
      StdDraw.text(0.5 + i, 33 + 2 * histogramm[1][i], Integer.toString((int) histogramm[1][i]));
      StdDraw.text(
          0.5 + i,
          13,
          Double.toString(histogramm[0][i]) + "-" + Double.toString(histogramm[0][i + 1]),
          90);
    }
    StdDraw.show();
  }

  private static double[][] getHistogrammArray(double[] number, int N, double l, double r) {
    double[][] historgamm = new double[2][];
    historgamm[0] = new double[N + 1];
    historgamm[1] = new double[N];
    double interval = (abs(l) + abs(r)) / N;
    historgamm[0][0] = l;
    for (int i = 1; i < historgamm[0].length; i++) {
      historgamm[0][i] = historgamm[0][i - 1] + interval;
    }

    for (int i = 1; i < historgamm[1].length; i++) {
      for (int j = 0; j < number.length; j++) {
        if (historgamm[0][i - 1] <= number[j] && number[j] <= historgamm[0][i]) {
          historgamm[1][i - 1]++;
        }
      }
    }
    return historgamm;
  }
}
