package ru.innopolis.university.demo.demooperators.waitnotify;

public class Shop {
  Integer breadCount = 0;

  public synchronized void buy() throws InterruptedException {
    if (breadCount < 1) {
      System.out.println("Хлеба нет, ожидаем");
      wait();
    }
    System.out.println("Хлеб куплен!");
  }

  public synchronized void sell() {
    for (int i = 0; i < 5; i++) {
      System.out.println("Отпускаю товар");
    }

    System.out.println("Привезли хлеб, уведомляю покупателя");
    breadCount = 5;
    notify();
  }
}
