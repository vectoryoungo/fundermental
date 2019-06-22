/*
 * module: fundermental
 * file: Server.java
 * date: 6/22/19 9:50 AM
 * author: VectorJu
 */


package com.xlab.service_java_infrastructure.architecture;

import	java.net.ServerSocket;
import java.io.*;
import	java.net.Socket;
/**
 * @create 2019-06-22 09:50
 * @desc net programming
 **/

public class Server {

    public static void main(String[] args) {
        int port = genPort(args);

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server started ");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Handler implements Runnable {
        Socket socket = null;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
                String readMeassage = null;

                while (true) {
                    System.out.println("server reading data ......");
                    if ((readMeassage = reader.readLine()) == null) {
                        break;
                    }

                    System.out.println(readMeassage);
                    writer.println("server receive " + readMeassage);
                    writer.flush();

                }
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                socket = null;
                if (reader != null ){
                    try {
                        reader.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                reader = null;

                if (writer != null) {
                    writer.close();
                }

                writer = null;
            }
        }
    }

    private static int genPort(String[] args) {
        if (args.length > 0) {
            try {
                return Integer.parseInt(args [0]);
            }catch (NumberFormatException e) {
                return 9999;
            }
        }else {
            return 9999;
        }
    }
}

