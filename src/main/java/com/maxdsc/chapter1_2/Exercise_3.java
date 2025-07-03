package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1_2.3 Напишите клиент класса Interva12D, который принимает в командной стро- ке аргументы N, min
 * и max и генерирует на единичном квадрате N случайных двумерных интервалов, ширины и высоты
 * которых равномерно распределены между min и max. Начертите их на StdDraw и выведите количество
 * пересекаю- щихся пар интервалов и количество интервалов, содержащихся один в другом.
 */
public class Exercise_3 {

  private Interval2D[] rectangles;
  private Point2D[] centers;
  private Point2D[][] corners;

  public Exercise_3(int N, double min, double max) {
    rectangles = new Interval2D[N];
    centers = new Point2D[N];
    corners = new Point2D[N][4];
    for (int i = 0; i < N; i++) {
      Interval1D xInterval = getRandomInterval(min, max);
      Interval1D yInterval = getRandomInterval(min, max);
      rectangles[i] = new Interval2D(xInterval, yInterval);
      double xCenter = (Math.abs(xInterval.max()) + Math.abs(xInterval.min())) / 2;
      double yCenter = (Math.abs(yInterval.max()) + Math.abs(yInterval.min())) / 2;
      centers[i] = new Point2D(xCenter, yCenter);
      corners[i][0] = new Point2D(xInterval.min(), yInterval.max());
      corners[i][1] = new Point2D(xInterval.max(), yInterval.max());
      corners[i][2] = new Point2D(xInterval.max(), yInterval.min());
      corners[i][3] = new Point2D(xInterval.min(), yInterval.min());
    }
  }

  public static void main(String[] args) {
    try {
      int N = Integer.parseInt(args[0]);
      double min = Double.parseDouble(args[1]);
      double max = Double.parseDouble(args[2]);
      if (N > 1) {
        Exercise_3 rect = new Exercise_3(N, min, max);
        rect.draw();
        for (int i = 0; i < N; i++) {
          Interval2D[] intersects = rect.getIntersectsRectagles(rect.getRectangles()[i]);
          Interval2D[] inners = rect.getInnerRectangles(rect.getRectangles()[i]);
          int countIntersects = intersects == null ? 0 : intersects.length;
          int countInners = inners == null ? 0 : inners.length;
          printf("Rectangle #%d - Intersect=%d, Inner=%d\n", i, countIntersects, countInners);
          for (int j = 0; intersects != null && j < countIntersects; j++)
            printf("    Intersects with #%d\n", rect.getIndexRectangle(intersects[j]));
          for (int k = 0; inners != null && k < countInners; k++)
            printf("    Contains inner #%d\n", rect.getIndexRectangle(inners[k]));
        }
      } else {
        printf("args[0]-N must be > 1\n");
      }
    } catch (Exception e) {
      printf("Argument Error\n");
      println(e.toString());
    }
  }

  public Interval2D[] getIntersectsRectagles(Interval2D rect) {
    int N = rectangles.length;
    int countItersects = 0;
    Interval2D[] temp = new Interval2D[N];
    for (int i = 0; i < N; i++) {
      if (!rect.equals(rectangles[i])
          && rect.intersects(rectangles[i])
          && !containsInner(rect, rectangles[i])
          && !containsInner(rectangles[i], rect)) {
        temp[countItersects] = rectangles[i];
        countItersects++;
      }
    }
    Interval2D[] intersects = null;
    if (countItersects > 0) {
      intersects = new Interval2D[countItersects];
      for (int i = 0; i < countItersects; i++) intersects[i] = temp[i];
    }
    return intersects;
  }

  public Interval2D[] getInnerRectangles(Interval2D rect) {
    int N = rectangles.length;
    int countInners = 0;
    Interval2D[] temp = new Interval2D[N];
    for (int i = 0; i < N; i++) {
      if (!rect.equals(rectangles[i]) && containsInner(rect, rectangles[i])) {
        temp[countInners] = rectangles[i];
        countInners++;
      }
    }
    Interval2D[] inners = null;
    if (countInners > 0) {
      inners = new Interval2D[countInners];
      for (int i = 0; i < countInners; i++) inners[i] = temp[i];
    }
    return inners;
  }

  public int getIndexRectangle(Interval2D rect) {
    int index = -1;
    for (int i = 0; i < rectangles.length; i++) {
      if (rect.equals(rectangles[i])) {
        index = i;
        break;
      }
    }
    return index;
  }

  public void draw() {
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.001);
    for (int i = 0; i < rectangles.length; i++) {
      rectangles[i].draw();
      StdDraw.text(centers[i].x(), centers[i].y(), "" + i);
    }

    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.008);
    for (int i = 0; i < rectangles.length; i++) {
      centers[i].draw();
      for (int j = 0; j < 4; j++) corners[i][j].draw();
    }
  }

  public Interval2D[] getRectangles() {
    return rectangles;
  }

  private boolean containsInner(Interval2D rect1, Interval2D rect2) {
    int countInnerCorners = 0;
    if (!rect1.equals(rect2)) {
      for (int j = 0; j < 4; j++) {
        if (rect1.contains(corners[getIndexRectangle(rect2)][j])) {
          countInnerCorners++;
        } else {
          break;
        }
      }
    }
    boolean contains = countInnerCorners == 4 ? true : false;
    return contains;
  }

  private Interval2D[] getRandomRectangles(int N, double min, double max) {
    Interval2D[] rectangles = new Interval2D[N];
    for (int i = 0; i < N; i++) {
      Interval1D xInterval = getRandomInterval(min, max);
      Interval1D yInterval = getRandomInterval(min, max);
      rectangles[i] = new Interval2D(xInterval, yInterval);
    }
    return rectangles;
  }

  private Interval1D getRandomInterval(double min, double max) {
    double randomMin = StdRandom.uniformDouble(min, max);
    double randomMax = StdRandom.uniformDouble(min, max);
    while (randomMax < randomMin) randomMax = StdRandom.uniformDouble(min, max);
    // По условию единичный квадрат, поэтому приводим к единице
    while (randomMin >= 1.0) randomMin /= 10.0;
    while (randomMax >= 1.0) randomMax /= 10.0;
    Interval1D interval = new Interval1D(randomMin, randomMax);
    return interval;
  }
}
