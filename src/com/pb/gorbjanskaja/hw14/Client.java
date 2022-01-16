package com.pb.gorbjanskaja.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String [] args) throws Exception {

        Socket socket = new Socket("localhost", 1234);
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Введите сообщение: ");
        new Thread(() -> {
            while (true) {
                String message = scan.nextLine();
                writer.println(message);

                }
        }).start();
        String fromServer;

        while ((fromServer = reader.readLine()) != null) {
            System.out.println(fromServer);
            System.out.println("Введите сообщение: ");
        }
        System.out.println("Соединение с сервером прервано");
        System.exit(0);
    }
}
