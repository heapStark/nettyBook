package org.heapStark.timeClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by WZL on 2017/12/10.
 */
public class TimeClient {
    public static void  main (String... args) throws IOException {
        int port = 8080;
        BufferedReader in =null;
        PrintWriter out = null;
        try {
            Socket socket = new Socket("localhost",8080);
            new PrintWriter(socket.getOutputStream(),true).println("query time");
            String res = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
