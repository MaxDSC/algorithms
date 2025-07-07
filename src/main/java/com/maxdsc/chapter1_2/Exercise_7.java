package com.maxdsc.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

/** 1_2.7 Переворачивает строку. */
public class Exercise_7 {
  public static void main(String[] args) {
    StdOut.println(mystery("Sobaka"));
  }

  public static String mystery(String s) {
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N / 2);
    String b = s.substring(N / 2, N);
    return mystery(b) + mystery(a);
  }
}
