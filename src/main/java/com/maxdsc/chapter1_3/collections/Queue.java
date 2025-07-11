package com.maxdsc.chapter1_3.collections;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int N;

  private class Node {
    Item item;
    Node next;

    Node(Item item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public void enqueue(Item item) {
    Node added = new Node(item, null);
    if (isEmpty()) {
      first = added;
      last = added;
    } else {
      last.next = added;
      last = added;
    }
    N++;
  }

  public Item dequeue() {
    if (isEmpty()) return null;
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) last = null;
    return item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public static <Item> Queue<Item> invert(Queue<Item> q) {
    Queue<Item> revert = new Queue<Item>();
    for (Item s : q) {
      revert.enqueue(q.dequeue());
    }
    return revert;
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
