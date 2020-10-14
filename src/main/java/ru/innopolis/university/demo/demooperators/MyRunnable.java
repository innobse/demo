package ru.innopolis.university.demo.demooperators;

import static java.lang.Thread.sleep;

import java.util.Random;

public class MyRunnable implements Runnable {
  Random random = new Random();
  Thread thread;

  public MyRunnable(Thread thread) {
    this.thread = thread;
  }

  @Override
  public void run() {
    try {
      //  Жду завершения работы thread
      thread.join();
      for (int i = 0; i < 10; i++) {
        //  Вывожу числа
        System.out.println(Thread.currentThread().getName() + "->" + random.nextInt());

        //  Отдыхаю 1 секунду
        sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
