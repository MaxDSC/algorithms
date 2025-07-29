package com.maxdsc.chapter1_3;

import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.chapter1_3.collections.SimpleSearch;
import com.maxdsc.chapter1_3.collections.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1_3.4 Напишите клиент стека Parentheses, который читает поток символов из стан- дартного ввода и
 * использует стек для определения правильности балансиров- ки скобок. Например, программа должна
 * вывести true для [()]{}{[()()]()} и false для [(]).
 */
public class Exercise_4 {
  public static void main(String[] args) {
    boolean result = true;
    Stack<String> stack = new Stack<String>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (!check(stack, s)) {
        result = false;
        break;
      }
    }
    println("Result=" + result);
    println("SIZE STACK=" + stack.size());
  }

  public static boolean check(Stack<String> stack, String s) {
    String[] openP = {"(", "[", "{"};
    String[] closeP = {")", "]", "}"};
    // if (!SimpleSearch.contains(openP, s) && !SimpleSearch.contains(closeP, s)) return false;
    if (SimpleSearch.contains(openP, s)) {
      stack.push(s);
    } else if (SimpleSearch.contains(closeP, s)) {
      if (getIndex(closeP, s) != getIndex(openP, stack.pop())) return false;
    }
    return true;
  }

  public static int getIndex(String[] arr, String s) {
    for (int i = 0; i < arr.length; i++) {
      if (s.equals(arr[i])) return i;
    }
    return -1;
  }
}
