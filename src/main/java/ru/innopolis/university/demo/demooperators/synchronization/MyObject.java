package ru.innopolis.university.demo.demooperators.synchronization;

import static java.lang.Thread.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyObject {
  int a;
  Lock lock = new ReentrantLock(true);

  public void sum(int newValue) {
    System.out.printf("Я %s готовлюс захватить монитор\n", Thread.currentThread().getName());

    try {
      lock.lock();

      System.out.printf("Я %s начинаю суммировать\n", Thread.currentThread().getName());
      try {
        a += newValue;
        sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.printf("Я %s закончил суммировать\n", Thread.currentThread().getName());
    } finally {
      lock.unlock();
    }

  }

  public void mul(int newValue) {
    System.out.printf("Я %s готовлюс захватить монитор\n", Thread.currentThread().getName());

    try {
      lock.lock();

      System.out.printf("Я %s начинаю умножать\n", Thread.currentThread().getName());
      try {
        a *= newValue;
        sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.printf("Я %s закончил умножать\n", Thread.currentThread().getName());
    } finally {
      lock.unlock();
    }
  }

  public int getValue() {
    return a;
  }
}
