package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.3
 * Напишите программу, которая принимает из командной строки три целочис-
 * ленных аргумента и выводит строку равны, если все они равны, и не равны в
 * противном случае.
 */
public class Exercise_3 {
  public static void main(String[] args) {
    if (args.length == 3) {
      try {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        String answer = compare(a, b, c) ? "==" : "!=";
        println(answer);
      } catch (NumberFormatException e) {
        println("Error!");
      }
    } else {
      println("Error!");
    }
  }

  static boolean compare(int a, int b, int c) {
    if (a == b && b == c) {
      return true;
    } else {
      return false;
    }
  }
}
