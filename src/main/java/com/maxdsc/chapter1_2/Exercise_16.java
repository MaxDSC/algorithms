package com.maxdsc.chapter1_2;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 1_2.16 Рациональные числа. Реализуйте неизменяемый тип данных Rational для ра- циональных чисел,
 * который поддерживает операции сложения, вычитания, ум- умножения и деления. Чтобы не заботиться о
 * переполнении (см. упражнение 1.2.17), используйте в каче- стве переменных экземпляров два
 * значения long, которые представляют числи- тель и знаменатель. Для сокращения числителя и
 * знаменателя на общий делитель используйте алгоритм Евклида (см. рис. 1.0.1). Добавьте клиент
 * тестирования, ко- торый демонстрирует работоспособность всех написанных вами методов.
 */
public class Exercise_16 {
  public static void main(String[] args) {
    Rational[] arrA = {
      new Rational(1, 2),
      new Rational(-1, 2),
      new Rational(1, -2),
      new Rational(-1, -2),
      new Rational(3, 2),
      new Rational(-3, 2),
      new Rational(3, -2),
      new Rational(-3, -2)
    };
    Rational[] arrB = {
      new Rational(1, 5),
      new Rational(-1, 5),
      new Rational(1, -5),
      new Rational(-1, -5),
      new Rational(5, 4),
      new Rational(-5, 4),
      new Rational(5, -4),
      new Rational(-5, -4)
    };
    Rational[] arrC = {
      new Rational(5, 10), new Rational(-5, 10), new Rational(5, -10), new Rational(-5, -10)
    };
    println("----Shorten test----");
    for (Rational i : arrC) printf("[shorten %d/%d]-> %s\n", i.n(), i.d(), i.shorten());

    println("----Equals test----");
    for (Rational i : arrC)
      for (Rational a : arrA) printf("[%s equals %s ?] -> %s\n", i, a, i.equals(a));

    Operations[] oper = Operations.values();
    for (int i = 0; i < oper.length; i++) {
      printf("----%s test----\n", oper[i].name());
      for (Rational a : arrA) for (Rational b : arrB) test(oper[i], a, b);
    }
  }

  private static void test(Operations operation, Rational a, Rational b) {
    Rational result = null;
    double realResult = 0;
    char o = ' ';
    BigDecimal aDouble = new BigDecimal(Rational.getDouble(a)).setScale(7, RoundingMode.DOWN);
    BigDecimal bDouble = new BigDecimal(Rational.getDouble(b)).setScale(7, RoundingMode.DOWN);
    switch (operation) {
      case PLUS:
        result = a.plus(b);
        realResult = aDouble.add(bDouble).doubleValue();
        o = '+';
        break;
      case MINUS:
        result = a.minus(b);
        realResult = aDouble.subtract(bDouble).doubleValue();
        o = '-';
        break;
      case TIMES:
        result = a.times(b);
        realResult = aDouble.multiply(bDouble).doubleValue();
        o = '*';
        break;
      case DIVIDES:
        result = a.divides(b);
        realResult = aDouble.divide(bDouble).doubleValue();
        o = '/';
        break;
    }
    boolean check = realResult == Rational.getDouble(result);
    String color = check ? "\033[42m" : "\033[41m";
    printf("%s %c %s = %s real=%f(%s%s\033[47m)\n", a, o, b, result, realResult, color, check);
  }

  enum Operations {
    PLUS,
    MINUS,
    TIMES,
    DIVIDES
  };
}
