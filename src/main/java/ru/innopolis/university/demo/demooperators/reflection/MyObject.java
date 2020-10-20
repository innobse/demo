package ru.innopolis.university.demo.demooperators.reflection;

public class MyObject {

  private String hello;

  public MyObject(String hello) {
    this.hello = hello;
  }

  private void setNewHello(String newHello) {
    hello = newHello;
  }

  public String getHello() {
    return hello;
  }
}
