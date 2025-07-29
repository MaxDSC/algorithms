package com.maxdsc.chapter1_2;

import java.util.Arrays;

/**
 * 1_2.11 Разработайте реализацию типа SmartDate из нашего API-интерфейса Date, которая должна
 * генерировать исключение, если ей попадается несуществующая дата. 1_2.12 Добавьте в тип данных
 * SmartDate метод dayOfTheWeek(), возвращающий для даты строковое значение понедельник, вторник,
 * среда, четверг, пятница, суббота или воскресенье. Можно считать, что даты принадлежат XXI веку.
 * 1.2.19 Разбор строк. Разработайте конструкторы с разбором строк для реализации Date и Transaction
 * из упражнения 1.2.13, которые принимают единый аркан- мент типа String с инициализирующими
 * значениями в форматах, представ- ленных в табл. 1.2.7.
 */
public class SmartDate {
  int day;
  int month;
  int year;

  static final int[] DAY_IN_MONTH = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  static final String[] DAY = {
    "воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота"
  };

  public SmartDate(int day, int month, int year) {
    if (!checkDate(day, month, year))
      throw new IllegalArgumentException("Invalid date" + " - " + day + "." + month + "." + year);
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * @since 1.8
   */
  public SmartDate(String date) {
    int[] dmy = Arrays.stream(date.split("\\.")).mapToInt(d -> Integer.parseInt(d)).toArray();
    if (!checkDate(dmy[0], dmy[1], dmy[2]))
      throw new IllegalArgumentException("Invalid date" + " - " + day + "." + month + "." + year);
    this.day = dmy[0];
    this.month = dmy[1];
    this.year = dmy[2];
  }

  private boolean checkDate(int day, int month, int year) {
    if (month == 2 && day == 29 && !isLeap(year)) return false;
    if (month < 1 || month > 12) return false;
    if (day < 1 || day > DAY_IN_MONTH[month]) return false;
    return true;
  }

  private boolean isLeap(int year) {
    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
  }

  public String dayOfTheWeek() {
    //    W = d + [ (13m - 1) / 5 ] + y + [ y / 4 ] + [ c / 4 ] - 2c, где:
    //      d — число месяца;
    //      m — номер месяца, начиная с марта (март = 1, апрель = 2, …, февраль = 12);
    //      y — номер года в столетии (например, для 1965 года y = 65.
    //          Для января и февраля 1965 года, то есть для m = 11 или m = 12, номер года надо брать
    // предыдущий, то есть y = 64);
    //      c — количество столетий (например, для 2000 года c = 20. И здесь для января и февраля
    // 2000 года надо брать предыдущее столетие, с = 19);
    //      квадратные скобки означают целую часть полученного числа (отбрасывается дробная).
    int m = (month + 10) % 12 == 0 ? 12 : (month + 10) % 12;
    int y = m == 11 || m == 12 ? year % 100 - 1 : year % 100;
    int c = m == 11 || m == 12 ? year / 100 - 1 : year / 100;
    int W = day + (13 * m - 1) / 5 + y + y / 4 + c / 4 - 2 * c;
    return DAY[W % 7];
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return day + "." + month + "." + year;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    SmartDate other = (SmartDate) obj;
    return day == other.day && month == other.month && year == other.year;
  }
}
