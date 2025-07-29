package com.maxdsc.chapter1_3.collections;

/** 1_3.1 Добавьте в класс FixedCapacityStackOfStrings метод isFull(). */
public class FixedCapacityStackOfStrings {
  private String[] a;
  private int N;
  private int capacity;

  public FixedCapacityStackOfStrings(int cap) {
    this.capacity = cap;
    a = new String[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(String item) {
    if (isFull()) throw new IndexOutOfBoundsException("Capacity exceeded!");
    a[N++] = item;
  }

  public String pop() {
    return a[--N];
  }

  public boolean isFull() {
    return N >= capacity;
  }
}
