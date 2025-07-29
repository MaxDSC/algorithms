package com.maxdsc.chapter1_2;

import static java.lang.Math.abs;

import java.util.Objects;

/**
 * 1.2.16 Рациональные числа. Реализуйте неизменяемый тип данных Rational для ра- циональных чисел,
 * который поддерживает операции сложения, вычитания, ум- умножения и деления. Чтобы не заботиться о
 * переполнении (см. упражнение 1.2.17), используйте в каче- стве переменных экземпляров два
 * значения long, которые представляют числи- тель и знаменатель. Для сокращения числителя и
 * знаменателя на общий делитель используйте алгоритм Евклида (см. рис. 1.0.1). Добавьте клиент
 * тестирования, ко- торый демонстрирует работоспособность всех написанных вами методов.
 */
public class Rational {

  private long numerator;
  private long denumerator;
  private boolean positive;

  public Rational(long numerator, long denumerator) {
    positive = !(numerator > 0 ^ denumerator > 0);
    this.numerator = abs(numerator);
    this.denumerator = abs(denumerator);
  }

  public boolean isPositive() {
    return positive;
  }

  public Rational shorten() {
    long d = gcd(numerator, denumerator);
    this.numerator = numerator / d;
    this.denumerator = denumerator / d;
    return this;
  }

  public Rational plus(Rational b) {
    Rational result = null;
    Rational copyA = new Rational(abs(numerator), abs(denumerator));
    Rational copyB = new Rational(abs(b.numerator), abs(b.denumerator));
    if (positive && !b.positive) result = copyA.minus(copyB);
    if (!positive && b.positive) result = copyB.minus(copyA);
    if (!(positive ^ b.positive)) {
      long newNum = copyA.numerator + copyB.numerator;
      long newDenum = copyA.denumerator;
      if (copyA.denumerator != copyB.denumerator) {
        newNum = copyA.numerator * copyB.denumerator + copyB.numerator * copyA.denumerator;
        newDenum = copyA.denumerator * copyB.denumerator;
      }
      result = shorten(new Rational(newNum, newDenum));
      if (!positive && !b.positive) result.positive = false;
    }
    return result;
  }

  public Rational minus(Rational b) {
    Rational copyA = new Rational(abs(numerator), abs(denumerator));
    Rational copyB = new Rational(abs(b.numerator), abs(b.denumerator));
    Rational result = null;

    if (positive && !b.positive) result = copyA.plus(copyB);
    if (!positive && b.positive) {
      result = copyA.plus(copyB);
      result.positive = false;
    }
    if (!positive && !b.positive) result = copyB.minus(copyA);

    if (positive && b.positive) {
      long newNum = abs(copyA.numerator - copyB.numerator);
      long newDenum = copyA.denumerator;
      if (copyA.denumerator != copyB.denumerator) {
        newNum = abs(copyA.numerator * copyB.denumerator - copyB.numerator * copyA.denumerator);
        newDenum = copyA.denumerator * copyB.denumerator;
      }
      if (getDouble(copyA) < getDouble(copyB)) newNum = -1 * newNum;
      result = shorten(new Rational(abs(newNum), newDenum));
      if (newNum < 0) result.positive = false;
    }
    return result;
  }

  public Rational times(Rational b) {
    Rational copyA = new Rational(abs(numerator), abs(denumerator));
    Rational copyB = new Rational(abs(b.numerator), abs(b.denumerator));
    long newNum = copyA.numerator * copyB.numerator;
    long newDenum = copyA.denumerator * copyB.denumerator;
    Rational result = shorten(new Rational(newNum, newDenum));
    if (positive ^ b.positive) result.positive = false;
    return result;
  }

  public Rational divides(Rational b) {
    Rational copyA = new Rational(abs(numerator), abs(denumerator));
    Rational copyB = new Rational(abs(b.numerator), abs(b.denumerator));
    long newNum = copyA.numerator * copyB.denumerator;
    long newDenum = copyA.denumerator * copyB.numerator;
    Rational result = shorten(new Rational(newNum, newDenum));
    if (positive ^ b.positive) result.positive = false;
    return result;
  }

  public double getDouble() {
    double a = (double) numerator / (double) denumerator;
    if (!positive) a = -1 * a;
    return a;
  }

  public static double getDouble(Rational r) {
    double a = (double) r.numerator / (double) r.denumerator;
    if (!r.positive) a = -1 * a;
    return a;
  }

  private void set(long numerator, long denominator) {
    this.numerator = numerator;
    this.denumerator = denominator;
  }

  private Rational shorten(Rational a) {
    long d = gcd(a.n(), a.d());
    a.set(a.n() / d, a.d() / d);
    return a;
  }

  private static long gcd(long p, long q) {
    if (q == 0) return p;
    return gcd(q, p % q);
  }

  public long n() {
    return numerator;
  }

  public long d() {
    return denumerator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(denumerator, numerator, positive);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Rational other = ((Rational) obj).shorten();
    Rational thisShort = this.shorten();
    return thisShort.denumerator == other.denumerator
        && thisShort.numerator == other.numerator
        && thisShort.positive == other.positive;
  }

  @Override
  public String toString() {
    String str = positive ? "" : "-";
    return str + abs(numerator) + "/" + abs(denumerator);
  }
}
