package ru.innopolis.university.demo.demooperators.classloaders;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {


  @Override
  protected Class<?> findClass(String name) {
    File classFile = new File(name + ".class");
    try (
        BufferedInputStream bis = new BufferedInputStream(
            new FileInputStream(
                classFile
            )
        )
        ) {
      byte[] content = new byte[(int) classFile.length()];
      bis.read(content);
      final Class<?> simple = defineClass(name, content, 0, content.length);
      return simple;
    } catch (IOException e) {
      System.out.println("Что-то пошло не так");
      return null;
    }
  }
}
