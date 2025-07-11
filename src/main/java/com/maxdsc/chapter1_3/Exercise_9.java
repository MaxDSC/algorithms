package com.maxdsc.chapter1_3;

import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.chapter1_3.collections.SimpleSearch;
import com.maxdsc.chapter1_3.collections.Stack;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1_3.9 Напишите программу, которая принимает из стандартного ввода выражение без левых скобок и
 * выводит эквивалентное инфиксное выражение со вставленным- ми недостающими скобками. Например, для
 * входных данных 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) программа должна вывести ( ( 1 + 2 ) * ( ( 3 - 4 )
 * * ( 5 - 6 ) ) )
 */
public class Exercise_9 {
  public static void main(String[] args) {
    Stack<String> values = new Stack<String>();
    Stack<String> operations = new Stack<String>();
    Stack<String> temp = new Stack<String>();

    String[] arrOp = {"+", "-", "*", "/"};
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (SimpleSearch.contains(arrOp, s)) {
        operations.push(s);
      } else if (s.equals(")")) {
        temp.push(operations.pop());
      } else {
        values.push(s);
      }
    }
    values = Stack.invert(values);
    operations = Stack.invert(temp);

    Stack<String> result = new Stack<String>();
    while (!values.isEmpty()) {
      String left = values.pop();
      String right = values.pop();
      String s = left;
      if (right != null) {
        s = "(" + left + operations.pop() + right + ")";
      }
      result.push(s);
    }

    while (!operations.isEmpty()) {
      String left = result.pop();
      String right = result.pop();
      String s = "(" + right + operations.pop() + left + ")";
      result.push(s);
    }
    println(result);
  }
}
