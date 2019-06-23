package com.epam.classwork.se10.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(10_000);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                System.out.println(new String(buffer, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
