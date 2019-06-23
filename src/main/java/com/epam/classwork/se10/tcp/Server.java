package com.epam.classwork.se10.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server started");
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try (ServerSocket socket = new ServerSocket(10_000)) {
            while (true) {
                pool.execute(new ClientRequestHandler(socket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientRequestHandler implements Runnable {

    private final Socket clientSocket;

    ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (clientSocket) {
            System.out.println("Request from client");
            System.out.println(clientSocket.getLocalPort());
            System.out.println(clientSocket.getPort());
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String fromClient = input.readLine();

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            TimeUnit.SECONDS.sleep(15);

            out.write(">>> " + fromClient + System.lineSeparator());
            out.flush();
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
