package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.In;

/**
 * 1_2.15 Файловый ввод. Разработайте возможную реализацию статического метода readInts() из класса
 * In (который мы будем использовать для различных кли- ентов тестирования - например, бинарного
 * поиска), основанную на методе split() из класса String.
 */
public class Exercise_15 {
  public static void main(String[] args) {
    // args[0] must be name file
    for (int a : readInts(args[0])) System.out.println(a);
  }

  public static int[] readInts(String name) {
    In in = new In(name);
    String input = in.readAll();
    String[] words = input.split("\\s+");
    int[] ints = new int[words.length];
    for (int i = 0; i < words.length; i++) ints[i] = Integer.parseInt(words[i]);
    return ints;
  }
}
