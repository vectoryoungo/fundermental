/*
 * module: fundermental
 * file: Client.java
 * date: 6/22/19 10:28 AM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.architecture.bio;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import	java.io.BufferedReader;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = null;

        int port = 0;

        if (args.length > 2) {
            host = args [0];
            port = Integer.parseInt(args [1]);
        }else {
            host = "127.0.0.1";
            port = 9999;
        }

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(host, port);
            String message = null;

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            writer = new PrintWriter(socket.getOutputStream(),true);

            while (true) {
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(message);
                writer.flush();
                System.out.println(reader.readLine());

            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            socket = null;

            if (reader!= null) {
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

