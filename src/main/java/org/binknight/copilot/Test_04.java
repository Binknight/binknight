package org.binknight.copilot;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Test_04 {
    public static void main(String[] args) {
        createSocketClient();
    }
    public static void createSocketClient() {
        try {
            Socket socket = new Socket("localhost", 8080);
            Scanner scanner = new Scanner(System.in);
            while(true){
                if(scanner.hasNext()){
                    String next = scanner.next();
                    socket.getOutputStream().write(next.getBytes());
                    if(next.equals("exit")){
                        break;
                    }
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
