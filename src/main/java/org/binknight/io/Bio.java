package org.binknight.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Bio {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            System.out.println("pending connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("connected...");
            RequestHandler(clientSocket);
        }
    }

    private static void RequestHandler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read done...");
        if (read !=-1) {
            System.out.println("received customer client data..." + new String(bytes,0,read));
        }
        System.out.println("end");
    }
}
