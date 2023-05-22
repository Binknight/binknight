package org.binknight.copilot;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test_03 {
    public static void main(String[] args) {
       createSocketServer();
    }

    // write method to create a socket server and bind to port 8080 then to start listening
    public static void createSocketServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("server start listening");
            while(true){
                Socket socket = serverSocket.accept();
                //获取流对象并打印内容
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    String s = new String(bytes, 0, len);
                    if("server-shutdown".equals(s)){
                        System.out.println("server-shutdown");
                        socket.close();
                        return;
                    }else {
                        System.out.println(s);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
