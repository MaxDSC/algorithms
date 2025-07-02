package com.maxdsc.chapter1_1;

import static java.lang.Math.pow;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 1.1.31
 *Случайные соединения. Напишите программу, которая принимает из командной
 *строки в качестве аргументов целое N и значение р типа double (между 0 до 1),
 *вычерчивает N точек размера 0.05, равномерно распределенных по окружности,
 *и затем вычерчивает серые отрезки, соединяющие каждую пару точек с вероят-
 *ностью р.
 */
public class Exercise_31 {
  public static void main(String[] args) {
    int N = 10;
    int r = 200;
    double p = 0.5;
    int scaleX = 500;
    int scaleY = 500;
    StdDraw.setXscale(0, scaleX);
    StdDraw.setYscale(0, scaleY);
    StdDraw.setPenRadius(0.01);
    int[][] points = createPoints(scaleX, scaleY, N, r);
    int[][] selectedPoints = selectPoints(points, p);
    StdDraw.setPenRadius(.001);
    StdDraw.circle(scaleX / 2, scaleY / 2, r);
    StdDraw.setPenColor(StdDraw.GREEN);
    for (int i = 0; i < selectedPoints[0].length; i += 2) {
      StdDraw.line(
          selectedPoints[0][i],
          selectedPoints[1][i],
          selectedPoints[0][i + 1],
          selectedPoints[1][i + 1]);
    }

    StdDraw.show();
  }

  private static int[][] createPoints(int scaleX, int scaleY, int N, int r) {
    int count = 0;
    int[][] points = new int[2][N];
    for (int i = 0; i < 10000; i++) {
      int x = StdRandom.uniformInt(-1 * scaleX / 2, scaleX / 2);
      int y = StdRandom.uniformInt(-1 * scaleY / 2, scaleY / 2);
      if (pow(x, 2) + pow(y, 2) <= pow(r, 2)) {
        StdDraw.text(scaleX / 2 + x, scaleY / 2 + y + 10, Integer.toString(count));
        StdDraw.point(scaleX / 2 + x, scaleY / 2 + y);
        points[0][count] = scaleX / 2 + x;
        points[1][count] = scaleY / 2 + y;
        count++;
      }
      if (count == N) break;
    }

    return points;
  }

  private static int[][] selectPoints(int[][] points, double p) {
    int N = points[0].length;
    int[] pArr = new int[N];
    int index = 0;
    for (int i = 0; i < N; i++) {
      if (StdRandom.bernoulli(p)) {
        pArr[index] = i;
        index++;
      }
    }

    if (index % 2 == 1) index--;
    int[][] selected = new int[2][index];
    for (int i = 0; i < index; i++) {
      selected[0][i] = points[0][pArr[i]];
      selected[1][i] = points[1][pArr[i]];
    }
    return selected;
  }
}
