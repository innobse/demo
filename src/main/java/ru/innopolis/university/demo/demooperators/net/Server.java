package ru.innopolis.university.demo.demooperators.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {

    //  Определяем порт, который будем слушать
    ServerSocket serverSocket = new ServerSocket(49883);

    while(true) {

      //  Ждем подключения клиента и открываем IO-потоки
      try (Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader br = new BufferedReader(
              new InputStreamReader(
                  socket.getInputStream()
              )
          )
      ) {
        String line;
        while((line = br.readLine()) != null) {

          System.out.println("Получено от клиента: " + line);
          out.println("Echo: " + line);
        }
      }
    }
  }

}
