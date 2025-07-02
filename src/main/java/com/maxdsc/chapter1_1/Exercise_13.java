package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.Utils;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 1.1.13
 * Напишите фрагмент кода для вывода транспозиции двумерного массива с М
 *строками и N столбцами (строки заменены столбцами).
 *
 */
public class Exercise_13 {
  public static void main(String[] args) {
    int[][] array = getFillArray();
    Utils.printArray(array);
    int[][] transArray = transposition(array);
    println("------------");
    Utils.printArray(transArray);
  }

  static int[][] getFillArray() {
    int row = StdRandom.uniformInt(2, 5);
    int col = StdRandom.uniformInt(2, 5);
    int[][] array = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        array[i][j] = StdRandom.uniformInt(10);
      }
    }
    return array;
  }

  static int[][] transposition(int[][] array) {
    int row = array.length;
    int col = array[0].length;
    int[][] transArray = new int[col][row];
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        transArray[i][j] = array[j][i];
      }
    }
    return transArray;
  }
}
