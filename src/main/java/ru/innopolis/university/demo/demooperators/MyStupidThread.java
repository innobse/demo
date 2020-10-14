package ru.innopolis.university.demo.demooperators;

public class MyStupidThread extends Thread {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
