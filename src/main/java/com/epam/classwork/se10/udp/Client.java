package com.epam.classwork.se10.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(10_001);
            byte[] dataToSend = "123".getBytes("UTF-8");

            DatagramPacket packet = new DatagramPacket(dataToSend, dataToSend.length, InetAddress.getLocalHost(), 10_000);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
