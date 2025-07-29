package com.maxdsc.chapter1_3.collections;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
  private Node first;
  private int N;

  private class Node {
    Item item;
    Node next;

    Node(Item item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public void push(Item item) {
    Node old = first;
    first = new Node(item, old);
    N++;
  }

  public Item pop() {
    if (isEmpty()) return null;
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public static <Item> Stack<Item> invert(Stack<Item> stack) {
    Stack<Item> revert = new Stack<Item>();
    for (Item s : stack) {
      revert.push(stack.pop());
    }
    return revert;
  }

  public Item peek() {
    return first.item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  @Override
  public String toString() {
    String result = "";
    for (Item s : this) {
      result = result + s + " ";
    }
    return result;
  }

  @Override
  public Iterator<Item> iterator() {
    Iterator<Item> i =
        new Iterator<Item>() {
          Node current = first;

          @Override
          public boolean hasNext() {
            return current != null;
          }

          @Override
          public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
          }
        };
    return i;
  }
}
