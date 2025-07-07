package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1_2.6 Строка s называется циклическим вращением строки t, если она совпадает с t после
 * циклического сдвига символов на любое количество позиций. Например, строка ACTGACG является
 * циклическим сдвигом строки TGACGAC, и наоборот. Выявление таких ситуаций важно в изучении генных
 * последовательностей. Напишите программу, которая проверяет, являются ли заданные строки s и t
 * циклическими вращениями одна другой. Совет: решение можно записать в одну строку с помощью
 * методов indexOf(), length() и конкатенации.
 */
public class Exercise_6 {
  public static void main(String[] args) {
    StdOut.println(isCiclicString("ACTGACG", "TGACGAC"));
    StdOut.println(isCiclicString("GOL", "OLG"));
    StdOut.println(isCiclicString("AC_TGACG", "TGACGAC"));
  }

  public static boolean isCiclicString(String s, String t) {
    return s.length() == t.length() && (s + s).indexOf(t) != -1;
  }
}
