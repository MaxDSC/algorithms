package com.maxdsc.chapter1_3;

import static edu.princeton.cs.algs4.StdOut.println;

import com.maxdsc.chapter1_3.collections.FixedCapacityStackOfStrings;

/** 1_3.1 Добавьте в класс FixedCapacityStackOfStrings метод isFull(). */
public class Exercise_1 {
  public static void main(String[] args) {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
    stack.push("First");
    stack.push("Two");
    // stack.push("Three"); //Exception
    println(stack.isFull());
  }
}
