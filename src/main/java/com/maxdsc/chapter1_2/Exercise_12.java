package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 1_2.12 Добавьте в тип данных SmartDate метод dayOfTheWeek(), возвращающий для даты строковое
 * значение понедельник, вторник, среда, четверг, пятница, суббота или воскресенье. Можно считать,
 * что даты принадлежат XXI веку.
 */
public class Exercise_12 {
  public static void main(String[] args) {
    SmartDate date = new SmartDate(10, 7, 2025);
    println(date.dayOfTheWeek());
  }
}
