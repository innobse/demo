package ru.innopolis.university.demo.demooperators.waitnotify;

public class Main {

  public static void main(String[] args) {
    final Shop shop = new Shop();

    new Thread(
        new Runnable() {
          @Override
          public void run() {
            // купить хлеб
            System.out.println("Покупаю хлеб");
            try {
              shop.buy();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
    ).start();

    new Thread(
        new Runnable() {
          @Override
          public void run() {
            shop.sell();
          }
        }
    ).start();
  }

}
