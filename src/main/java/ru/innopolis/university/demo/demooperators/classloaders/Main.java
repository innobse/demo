package ru.innopolis.university.demo.demooperators.classloaders;

import com.sun.nio.zipfs.ZipInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException {



    System.out.println(String.class.getClassLoader());
    System.out.println(ZipInfo.class.getClassLoader());
    System.out.println(ru.innopolis.university.demo.demooperators.reflection.Main.class.getClassLoader());

    final Class simpleClass = loadSimpleClass();

    analizeClass(simpleClass);

  }


  private static void analizeClass(Class clazz) {

    System.out.println("Начинаем анализировать класс");

    System.out.println("Описанные в классе поля");
    for (Field declaredField : clazz.getDeclaredFields()) {
      System.out.println("Имя поля: " + declaredField.getName());
      System.out.println("Тип поля: " + declaredField.getType());

      System.out.println("(" + declaredField + ")\n");
    }

    System.out.println("Описанные в классе методы");
    for (Method declaredMethod : clazz.getDeclaredMethods()) {
      System.out.println("Имя метода: " + declaredMethod.getName());
      System.out.println("Тип результата: " + declaredMethod.getReturnType());

      System.out.println("Аннотации метода: ");
      for (Annotation[] annot : declaredMethod.getParameterAnnotations()) {
        System.out.println(annot);
      }

      System.out.println("(" + declaredMethod + ")\n");
    }
  }

  private static Class loadSimpleClass() throws ClassNotFoundException {
    MyClassLoader myClassLoader = new MyClassLoader();

    final Class<?> simpleClass = Class.forName("Simple", true, myClassLoader);

    System.out.println(simpleClass);

    System.out.println("Класслоадер работает " +
        (Class.forName("Simple", true, myClassLoader).equals(simpleClass) ?
            "ВЕРНО" :
            "НЕВЕРНО"));

    return simpleClass;
  }
}
