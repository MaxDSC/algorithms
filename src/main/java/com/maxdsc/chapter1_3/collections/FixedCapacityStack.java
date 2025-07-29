package com.maxdsc.chapter1_3.collections;

public class FixedCapacityStack<Item> {
  private Item[] a;
  private int N;
  private int capacity;

  @SuppressWarnings("unchecked")
  public FixedCapacityStack(int cap) {
    this.capacity = cap;
    a = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    if (isFull()) throw new IndexOutOfBoundsException("Capacity exceeded!");
    a[N++] = item;
  }

  public Item pop() {
    return a[--N];
  }

  public boolean isFull() {
    return N >= capacity;
  }
}
