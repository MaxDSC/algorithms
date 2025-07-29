package com.maxdsc.chapter1_2;

/**
 * 1_2.10 Разработайте класс VisualCounter, в котором имеются операции как увеличе- ния, так и
 * уменьшения счетчика на единицу. Конструктор должен принимать два аргумента - N и mах, где N
 * задает максимальное количество операций, а mах - максимальное абсолютное значение для счетчика. В
 * качестве побочного эффекта класс должен создавать чертеж со значением счетчика при каждом его
 * изменении.
 */
public class Exercise_10 {
  public static void main(String[] args) {
    VisualCounter visualCounter = new VisualCounter(1000, 900);
    for (int i = 0; i < 500; i++) {
      if ((i > 100 && i < 150) || (i > 300 && i < 375)) {
        visualCounter.decrement();
      } else {
        visualCounter.increment();
      }
    }
  }
}
