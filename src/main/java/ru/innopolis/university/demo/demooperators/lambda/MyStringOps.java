package ru.innopolis.university.demo.demooperators.lambda;

public class MyStringOps {

  static String strReverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}
