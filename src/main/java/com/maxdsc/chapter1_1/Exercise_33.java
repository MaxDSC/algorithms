package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;

import com.maxdsc.Utils;

/*
 * 1.1.33
 * Библиотека матричных вычислений. Сделать операции скалярного произведения, произведения двух матриц,
 * транспонирование, произведения матрицы на вектор, произведения вектора на матрицу.
 * Разработайте клиент тестирования, который читает значения из стандартного
 * ввода и проверяет работу всех методов.
 */
public class Exercise_33 {
  public static void main(String[] args) {
    try {
      printf("Input vectorX (1 arg is length) -> ");
      double[] vectorX = Utils.inputVecor();
      printf("Input vectorY (1 arg is length) -> ");
      double[] vectorY = Utils.inputVecor();
      printf("Input matrix A (1 and 2 arg is row and column) -> ");
      double[][] matrixA = Utils.inputArray();
      printf("Input matrix B (1 and 2 arg is row and column) -> ");
      double[][] matrixB = Utils.inputArray();
      printf("VectorX -> ");
      Utils.printArray(vectorX);
      printf("VectorY -> ");
      Utils.printArray(vectorY);
      printf("MatrixA -> \n");
      Utils.printArray(matrixA);
      printf("MatrixB  -> \n");
      Utils.printArray(matrixB);

      printf("--Testing---\n");
      //     printf("Dot vectorX*vectorY result = %f\n", dot(vectorX, vectorY));
      //     printf("MatrixA* MatrixB result -> \n");
      //     Utils.printArray(mult(matrixA, matrixB));
      //     printf("TRANSPOSE MatrixA result -> \n");
      //     Utils.printArray(transpose(matrixA));
      //     printf("Mult MatrixA*vectorX result -> \n");
      //     Utils.printArray(mult(matrixA, vectorX));
      printf("Mult vectorY * MatrixA result -> \n");
      Utils.printArray(mult(vectorY, matrixA));

    } catch (Exception e) {
      printf(e.getMessage());
    }
  }

  private static double dot(double[] x, double[] y) {
    if (x.length == y.length) {
      int xy = 0;
      for (int i = 0; i < x.length; i++) {
        xy += x[i] * y[i];
      }
      return xy;
    } else {
      throw new IllegalArgumentException("Invalid length of vectors!\n");
    }
  }

  private static double[][] mult(double[][] a, double[][] b) {
    if (a[0].length == b.length) {
      double[][] ab = new double[a.length][b[0].length];
      for (int i = 0; i < ab.length; i++)
        for (int j = 0; j < ab[0].length; j++)
          for (int c = 0; c < a[0].length; c++) ab[i][j] += a[i][c] * b[c][j];
      return ab;
    } else {
      throw new IllegalArgumentException("Invalid size of matrix!\n");
    }
  }

  private static double[][] mult(double[][] a, double[] x) {
    if (a[0].length == x.length) {
      double[][] ax = new double[a.length][1];
      for (int i = 0; i < ax.length; i++)
        for (int c = 0; c < x.length; c++) ax[i][0] += a[i][c] * x[c];
      return ax;
    } else {
      throw new IllegalArgumentException("Invalid size of matrix!\n");
    }
  }

  private static double[][] mult(double[] y, double[][] a) {
    if (a[0].length == 1 && a.length == y.length) {
      int len = a.length;
      double[][] ay = new double[len][len];
      for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) ay[i][j] = a[i][0] * y[j];
      return ay;
    } else {
      throw new IllegalArgumentException("Invalid size of matrix!\n");
    }
  }

  private static double[][] transpose(double[][] array) {
    int row = array.length;
    int col = array[0].length;
    double[][] transArray = new double[col][row];
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        transArray[i][j] = array[j][i];
      }
    }
    return transArray;
  }
}
