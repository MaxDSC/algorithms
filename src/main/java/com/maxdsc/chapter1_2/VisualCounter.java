package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {

  private int maxOperations;
  private int maxCounter;
  int count;
  int totalOperations;

  public VisualCounter(int N, int max) {
    maxOperations = N;
    maxCounter = max;
    totalOperations = 0;
    count = 0;
    StdDraw.setXscale(0, maxCounter);
    StdDraw.setYscale(0, maxOperations);
    StdDraw.setPenRadius(0.005);
  }

  public void increment() {
    count++;
    totalOperations++;
    StdDraw.line(totalOperations - 1, count - 1, totalOperations, count);
  }

  public void decrement() {
    count--;
    totalOperations++;
    StdDraw.line(totalOperations - 1, count + 1, totalOperations, count);
  }
}
