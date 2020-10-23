package ru.innopolis.university.demo.demooperators.lambda;

public class MyStringModifier {

  String strReverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}
