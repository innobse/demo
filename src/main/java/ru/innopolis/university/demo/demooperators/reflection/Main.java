package ru.innopolis.university.demo.demooperators.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

  public static void main(String[] args)
      throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {

    demoMyObj();
    demoBoolean();

  }

  private static void demoBoolean() throws NoSuchFieldException, IllegalAccessException {

    final Field value = Boolean.class.getDeclaredField("value");

    value.setAccessible(true);
    value.setBoolean(Boolean.TRUE, false);
    value.setBoolean(Boolean.FALSE, true);

    if (Boolean.TRUE == false) {
      System.out.println("Что за чертовщина тут творится? Почему TRUE == false?");
    }

    if (Boolean.FALSE == true) {
      System.out.println("Что за чертовщина тут творится? Почему FALSE == true?");
    }

  }

  private static void demoMyObj()
      throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    MyObject myObject = new MyObject("Hello");

    System.out.println("Приветствие изначальное: " + myObject.getHello());

    Class targetClass = myObject.getClass();

    final Field helloField = targetClass.getDeclaredField("hello");
    helloField.setAccessible(true);

    helloField.set(myObject, "Добро пожаловать");

    System.out.println("Приветствие после изменения объекта: " + myObject.getHello());

    final Method setNewHello = targetClass.getDeclaredMethod("setNewHello", String.class);
    setNewHello.setAccessible(true);

    setNewHello.invoke(myObject, "Bonjour!");

    System.out.println("Приветствие после вызова приватного метода: " + myObject.getHello());
  }

}
