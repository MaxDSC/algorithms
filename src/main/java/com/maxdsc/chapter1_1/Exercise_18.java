package com.maxdsc.chapter1_1;

import static edu.princeton.cs.algs4.StdOut.println;

/*
 * 1.1.18
 *Чему равны значения mystery(2, 25) и mystery(3, 11)?
 *Какое значение вычисляет вызов mystery(a, b) для положительных целых аргументов а и b?
 *Замените операцию + операцией * и оператор return 0 оператором return 1 и снова ответьте на этот вопрос.
 * Ответ: mystery с операцией плюс вычисляет умножение a на b, при операции умножения a^b
 */
public class Exercise_18 {
  public static void main(String[] args) {
    println(mystery(2, 25));
    println(mystery(3, 11));
    println(mystery(5, 20));
  }

  private static int mystery(int a, int b) {
    if (b == 0) return 1;
    if (b % 2 == 0) return mystery(a * a, b / 2);
    return mystery(a * a, b / 2) * a;
  }
}
