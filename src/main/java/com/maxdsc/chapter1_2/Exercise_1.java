package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.printf;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1_2.1 Напишите клиент класса Point2D, который принимает в командной строке целое значение N,
 * генерирует N случайных точек на единичном квадрате и вычисляет расстояние, разделяющее самую
 * близкую пару точек.
 */
public class Exercise_1 {
  public static void main(String[] args) {
    try {
      int N = Integer.parseInt(args[0]);
      if (N > 1) {
        Point2D[] points = getRandomPoint(N);
        Point2D[] nearest = getNearestPoints(points);
        printf("%f\n", nearest[0].distanceTo(nearest[1]));
        drawInfo(points, nearest);
      } else {
        printf("args[0]-N must be > 1\n");
      }
    } catch (Exception e) {
      printf("Argument Error\n");
    }
  }

  private static Point2D[] getRandomPoint(int N) {
    Point2D[] points = new Point2D[N];
    for (int i = 0; i < N; i++) {
      double x = StdRandom.uniformDouble();
      double y = StdRandom.uniformDouble();
      Point2D p = new Point2D(x, y);
      points[i] = p;
    }
    return points;
  }

  private static Point2D[] getNearestPoints(Point2D[] points) {
    double distMin = 0;
    Point2D[] nearestTwoPoints = new Point2D[2];
    for (int i = 0; i < points.length; i++) {
      if (i == 1) {
        distMin = points[0].distanceTo(points[1]);
        nearestTwoPoints[0] = points[0];
        nearestTwoPoints[1] = points[1];
      }
      for (int j = i - 1; j >= 0; j--) {
        double distance = points[i].distanceTo(points[j]);
        if (distance < distMin) {
          distMin = distance;
          nearestTwoPoints[0] = points[i];
          nearestTwoPoints[1] = points[j];
        }
      }
    }
    return nearestTwoPoints;
  }

  private static void drawInfo(Point2D[] points, Point2D[] nearestPoints) {
    StdDraw.setPenRadius(0.01);
    for (int i = 0; i < points.length; i++) {
      points[i].draw();
    }
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.004);
    double xCircle = (nearestPoints[0].x() + nearestPoints[1].x()) / 2;
    double yCircle = (nearestPoints[0].y() + nearestPoints[1].y()) / 2;
    StdDraw.circle(xCircle, yCircle, nearestPoints[0].distanceTo(nearestPoints[1]));
  }

  private static void badCode(int N) {
    Point2D[] points = new Point2D[N];
    double distMin = 0;
    int p1 = 0;
    int p2 = 0;
    StdDraw.setPenRadius(0.01);
    for (int i = 0; i < N; i++) {
      double x = StdRandom.uniformDouble();
      double y = StdRandom.uniformDouble();
      Point2D p = new Point2D(x, y);
      points[i] = p;
      if (i == 1) distMin = points[0].distanceTo(points[1]);
      for (int j = i - 1; j >= 0; j--) {
        double distance = p.distanceTo(points[j]);
        if (distance < distMin) {
          distMin = distance;
          p1 = i;
          p2 = j;
        }
      }
      points[i].draw();
    }

    printf("DIST=%f\n", distMin);
    // Показать на рисунке
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.004);
    double xCircle = (points[p1].x() + points[p2].x()) / 2;
    double yCircle = (points[p1].y() + points[p2].y()) / 2;
    StdDraw.circle(xCircle, yCircle, distMin * 2.1);
    // StdDraw.line(points[p1].x(), points[p1].y(), points[p2].x(), points[p2].y());
  }
}
