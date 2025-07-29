package com.maxdsc.chapter1_3;

import com.maxdsc.chapter1_3.collections.Stack;
import edu.princeton.cs.algs4.StdOut;

/** 1_3.5 Ответ: этот код выводит двоичное представление N (110010, если N равно 50). */
public class Exercise_5 {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    int N = 50;
    while (N > 0) {
      stack.push(N % 2);
      N = N / 2;
    }
    for (int d : stack) StdOut.print(d);
    StdOut.println();
  }
}
