package ru.innopolis.university.demo.demooperators.callable;

import static java.lang.Thread.sleep;

import java.util.concurrent.Callable;

public class ArraySummator implements Callable<Integer> {

  int[] array;

  public ArraySummator(int[] array) {
    this.array = array;
  }

  @Override
  public Integer call() throws Exception {

    sleep(3000);
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}
