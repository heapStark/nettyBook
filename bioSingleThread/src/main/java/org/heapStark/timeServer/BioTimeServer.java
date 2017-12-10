package org.heapStark.timeServer;

import org.heapStark.handler.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by WZL on 2017/12/10.
 */
public class BioTimeServer {
    public static void  main (String... args) throws IOException{
        int port = 8080;

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server!=null){
                server.close();
                server = null;
            }
        }
    }
}
