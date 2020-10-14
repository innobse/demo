package ru.innopolis.university.demo.demooperators;

import java.util.Random;

public class MyThread extends Thread {

  Random random = new Random();

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(getName() + "->" + random.nextInt());
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
