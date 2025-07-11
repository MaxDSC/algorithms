package com.maxdsc.chapter1_3;

import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.chapter1_3.collections.FixedCapacityStack;

/**
 * 1_3.2 Что выведет команда java Stack для следующих входных данных? it was - the best - of times -
 * - - it was - the - -
 */
public class Exercise_2 {
  public static void main(String[] args) {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(100);
    String[] str = "it was - the best - of times - - - it was - the - -".split(" ");
    for (String s : str) {
      if (s.equals("-")) {
        String strPop = (String) stack.pop();
        println("pop->" + strPop);
      } else {
        stack.push(s);
        println("push->" + s);
      }
    }

    while (stack.size() > 0) {
      println(stack.pop());
    }
  }
}
