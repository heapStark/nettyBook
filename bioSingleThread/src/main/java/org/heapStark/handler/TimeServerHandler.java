package org.heapStark.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by WZL on 2017/12/10.
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;
    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }
    public void run() {
        BufferedReader in =null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            while (true){
                String body = in.readLine();
                System.out.println(body);
                if (body==null)
                    break;
                String time = new Date().toString();
                out.println(time);

            }
        } catch (Exception e) {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
            }
            if (this.socket!=null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket=null;
            }
        } finally {
        }


    }
}
