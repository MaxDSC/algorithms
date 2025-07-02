package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import edu.princeton.cs.algs4.StdIn;

/*
 * 1.1.21
 * Напишите программу, которая читает строки из стандартного ввода, где каждая
 *строка содержит имя и два целых числа, а затем использует метод printf() для
 *вывода таблицы, в каждой строке которой содержатся имя, оба целых числа и
 *результат деления первого числа на второе с точностью до трех десятичных зна-
 *ков. Похожую программу можно использовать для вывода рейтингов игроков в
 *бейсбол или оценок студентов.
 */
public class Exercise_21 {
  public static void main(String[] args) {
    String[] arr = inputData(3);
    printTable(arr);
  }

  private static String[] inputData(int countString) {
    String[] strArr = new String[countString];
    for (int i = 0; i < countString && !StdIn.isEmpty(); i++) {
      strArr[i] = StdIn.readLine();
    }
    return strArr;
  }

  private static void printTable(String[] strArr) {
    for (int i = 0; i < strArr.length; i++) {
      printf("%s", strArr[i]);
      if (strArr[i].matches(" ") || strArr[i].split(" ").length == 3) {
        try {
          int num1 = Integer.parseInt(strArr[i].split(" ")[1]);
          int num2 = Integer.parseInt(strArr[i].split(" ")[2]);
          printf(" %.3f\n", (double) num1 / num2);
        } catch (NumberFormatException e) {
          println(" n/a");
        }
      } else {
        println(" n/a");
      }
    }
  }
}
