package com.maxdsc;

import static edu.princeton.cs.algs4.StdOut.printf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
 * Utils
 */
public class Utils {
  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      printf("%d ", a[i]);
    }
    printf("\n");
  }

  public static void printArray(double[] a) {
    for (int i = 0; i < a.length; i++) {
      printf("%f ", a[i]);
    }
    printf("\n");
  }

  public static void printArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) printf("%d ", a[i][j]);
      printf("\n");
    }
  }

  public static void printArray(double[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) printf("%f ", a[i][j]);
      printf("\n");
    }
  }

  public static void printArray(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i][j]) printf("1");
        if (!arr[i][j]) printf("0");
      }
      printf("\n");
    }
  }

  public static double[][] getFillArray() {
    int row = StdRandom.uniformInt(2, 5);
    int col = StdRandom.uniformInt(2, 5);
    double[][] array = new double[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        array[i][j] = StdRandom.uniformDouble(0, 101);
      }
    }
    return array;
  }

  public static double[][] inputArray() {
    int row = StdIn.readInt();
    int col = StdIn.readInt();
    double[][] array = new double[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        array[i][j] = StdIn.readDouble();
      }
    }
    return array;
  }

  public static double[] inputVecor() {
    int count = StdIn.readInt();
    double[] array = new double[count];
    for (int i = 0; i < count; i++) {
      array[i] = StdIn.readDouble();
    }
    return array;
  }
}
