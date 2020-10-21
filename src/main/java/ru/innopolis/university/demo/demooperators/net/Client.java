package ru.innopolis.university.demo.demooperators.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) throws IOException {
    System.out.println("Старт подключения");

    Socket socket = new Socket("localhost", 25554);

    try (BufferedReader br = new BufferedReader(
        new InputStreamReader(
            socket.getInputStream()
        ));
        PrintWriter out = new PrintWriter(
            new OutputStreamWriter(
                socket.getOutputStream()
            ), true
        );
        Scanner console = new Scanner(System.in)) {

      while(true) {
        final String line = console.nextLine();
        if ("end".equals(line))
          break;

        out.println(line);

        System.out.println("Ответ от сервера: " + br.readLine());
      }
    }
  }

}
