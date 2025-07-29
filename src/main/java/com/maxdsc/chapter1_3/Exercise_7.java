package com.maxdsc.chapter1_3;

import com.maxdsc.chapter1_3.collections.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1_3.7 Добавьте в класс Stack метод peek(), который возвращает элемент, занесенный в стек
 * последним (без выталкивания).
 */
public class Exercise_7 {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    StdOut.println(stack.peek());
    StdOut.println("SIZE=" + stack.size());
  }
}
