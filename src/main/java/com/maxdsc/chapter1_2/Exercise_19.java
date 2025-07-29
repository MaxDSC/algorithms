package com.maxdsc.chapter1_2;

/**
 * 1_2.19 Разбор строк. Разработайте конструкторы с разбором строк для реализации Date и Transaction
 * из упражнения 1.2.13, которые принимают единый аркан- мент типа String с инициализирующими
 * значениями в форматах, представ- ленных в табл. 1.2.7.
 */
public class Exercise_19 {
  public static void main(String[] args) {
    SmartDate date = new SmartDate("07.07.2025");
    Transaction transaction = new Transaction("Max", date, 11.99);
    System.out.println(date);
    System.out.println(transaction);
  }
}
