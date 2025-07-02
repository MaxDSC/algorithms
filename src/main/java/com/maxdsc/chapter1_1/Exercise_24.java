package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.24
 *Приведите последовательность значений р и q, вычисляемые при работе ал-
 *алгоритма Евклида, когда он находит наибольший общий делитель 105 и 24.
 *Напишите на основе кода, приведенного на рис. 1.0.1, программу Euclid, ко-
 *торая принимает из командной строки два целых числа и вычисляет их наибольший общий делитель,
 *выводя оба аргумента для каждого вывода рекурсив-
 *ного метода. Используйте полученную программу для вычисления наибольшего
 *общего делителя 1111111 и 1234567.
 */
public class Exercise_24 {
  public static void main(String[] args) {
    if (args.length == 2) {
      try {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        println(calc(p, q));
      } catch (NumberFormatException e) {

      }
    }
  }

  private static int calc(int p, int q) {
    if (q == 0) return p;
    println(p + " " + q);
    return calc(q, p % q);
  }
}
