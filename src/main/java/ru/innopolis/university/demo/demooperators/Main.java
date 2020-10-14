package ru.innopolis.university.demo.demooperators;

import static java.lang.Thread.sleep;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import ru.innopolis.university.demo.demooperators.callable.ArraySummator;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    demoCallable2();

  }

  private static void demoCallable2() throws ExecutionException, InterruptedException {

    final ArraySummator myCallableArraySummator = new ArraySummator(getRandomArray(100));
    final ExecutorService executorService = Executors.newSingleThreadExecutor();

    //  Запускаем задачу
    final Future<Integer> future = executorService.submit(myCallableArraySummator);


    while(!future.isDone()) {
      System.out.println("Результата пока нет, что-то делаем");
      sleep(500);
    }

    System.out.println("Результат вычисений: " + future.get());

    executorService.shutdown();

  }

  private static void demoCallable() throws ExecutionException, InterruptedException {

    final ArraySummator myCallableArraySummator = new ArraySummator(getRandomArray(100));
    final ExecutorService executorService = Executors.newSingleThreadExecutor();

    //  Запускаем задачу
    final Future<Integer> future = executorService.submit(myCallableArraySummator);


    System.out.println("Пока задача выполняется, что-то делаем");

    try {
      System.out.println("Результат суммирования: " + future.get(1, TimeUnit.SECONDS));
    } catch (TimeoutException e) {
      System.out.println("Результат за 1 секунду не был посчитан");
    }


    System.out.println("Пока задача выполняется, что-то делаем");

    System.out.println("Результат суммирования: " + future.get());

    executorService.shutdown();

  }

  private static int[] getRandomArray(int length) {
    Random rand = new Random();
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = rand.nextInt(256);
    }
    return array;
  }

  private static void demoJoin() {
    final MyThread myThread1 = new MyThread("Поток 1");
    final MyRunnable myRunnable = new MyRunnable(myThread1);

    myThread1.start();
    new Thread(myRunnable).start();

    System.out.println("Я метод main и я стартанул потоки " + Thread.currentThread().getName());
  }

  private static void demoRunVsStart() {

    System.out.println("Вызываю RUN!");
    new MyStupidThread().run();

    System.out.println("А теперь START!");
    new MyStupidThread().start();

    System.out.println("Еще раз RUN!");
    new MyStupidThread().run();
  }



}