package com.maxdsc.chapter1_3;

import com.maxdsc.chapter1_3.collections.Queue;
import com.maxdsc.chapter1_3.collections.Stack;
import edu.princeton.cs.algs4.StdOut;

/** 1_3.6 Что делает следующий кодовый фрагмент с очередью q? Ответ: оборачивает очередь. */
public class Exercise_6 {
  public static void main(String[] args) {
    Queue<String> q = new Queue<String>();
    q.enqueue("1");
    q.enqueue("a");
    q.enqueue("b");
    Stack<String> stack = new Stack<String>();
    while (!q.isEmpty()) {
      stack.push(q.dequeue());
    }
    for (String s : stack) StdOut.printf("%s ", s);
    StdOut.println();
    while (!stack.isEmpty()) {
      q.enqueue(stack.pop());
    }

    for (String s : stack) StdOut.printf("%s ", s);
    StdOut.println();
    for (String s : q) StdOut.printf("%s ", s);
    StdOut.println();
  }
}
