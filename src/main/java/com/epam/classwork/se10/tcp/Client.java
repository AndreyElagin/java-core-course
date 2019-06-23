package com.epam.classwork.se10.tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 10_000)){
            System.out.println(socket.isClosed());

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write("Hello, server!" + System.lineSeparator());
            out.flush();
            System.out.println(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
