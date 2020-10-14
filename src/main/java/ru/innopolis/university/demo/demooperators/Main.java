package ru.innopolis.university.demo.demooperators;

public class Main {

  public static void main(String[] args) {
    final MyThread myThread1 = new MyThread("Поток 1");
    final MyRunnable myRunnable = new MyRunnable(myThread1);

    myThread1.start();
    new Thread(myRunnable).start();

    System.out.println("Я метод main и я стартанул потоки " + Thread.currentThread().getName());
  }



}