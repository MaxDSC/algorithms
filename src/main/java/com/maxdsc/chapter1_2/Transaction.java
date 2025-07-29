package com.maxdsc.chapter1_2;

import java.util.Objects;

/**
 * 1_2.13 разработайте реализацию типа данных Transaction по образу реализации типа Date (рис.
 * 1.2.22). 1.2.14 Разработайте реализацию метода equals() для типа Transaction по образу метода
 * equals() для типа Date (листинг 1.2.5). 1.2.19 Разбор строк. Разработайте конструкторы с разбором
 * строк для реализации Date и Transaction из упражнения 1.2.13, которые принимают единый аркан-
 * мент типа String с инициализирующими значениями в форматах, представ- ленных в табл. 1.2.7.
 */
public class Transaction {

  private String who;
  private SmartDate when;
  private double amount;

  public Transaction(String who, SmartDate when, double amount) {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }

  public Transaction(String transaction) {
    String[] split = transaction.split("\\s+");
    if (split.length != 3)
      throw new IllegalArgumentException("Invalid String format! Use-> name dd.mm.yy amount");
    this.who = split[0];
    this.when = new SmartDate(split[1]);
    this.amount = Double.parseDouble(split[2]);
  }

  public String getWho() {
    return who;
  }

  public SmartDate getWhen() {
    return when;
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Transaction [who=" + who + ", when=" + when + ", amount=" + amount + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Transaction other = (Transaction) obj;
    return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
        && Objects.equals(when, other.when)
        && Objects.equals(who, other.who);
  }
}
