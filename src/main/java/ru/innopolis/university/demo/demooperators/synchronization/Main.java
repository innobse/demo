package ru.innopolis.university.demo.demooperators.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    final MyObject myObject = new MyObject();

    final Thread threadSum = new Thread(
        new Runnable() {
          @Override
          public void run() {
            myObject.sum(10);
          }
        }
    );

    final Thread threadMul = new Thread(
        new Runnable() {
          @Override
          public void run() {
            myObject.mul(10);
          }
        }
    );

    threadMul.start();
    threadSum.start();

    try {
      threadSum.join();
      threadMul.join();
      System.out.println(myObject.getValue());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
