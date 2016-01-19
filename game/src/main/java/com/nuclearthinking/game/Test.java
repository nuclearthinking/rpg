package com.nuclearthinking.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kuksin-mv on 18.01.2016.
 */
public class Test
{
    private static final int PORT = 5000;
    private static final String IP = "127.0.0.1";
    Socket socket;
    ServerSocket serverSocket;
    PrintWriter writer;
    InputStreamReader isr;
    BufferedReader br;

    public static void main(String[] args)
    {
        Test test = new Test();
        test.go();
    }

    public ServerSocket getServerSocket() throws IOException
    {
        return serverSocket = new ServerSocket(PORT);
    }

    public Socket getClientSocket() throws IOException
    {
        return socket = new Socket(IP, PORT);
    }

    public void go()
    {
        try
        {
            getServerSocket();
            getClientSocket();
            writer = new PrintWriter(socket.getOutputStream());

            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            String adv = br.readLine();
            System.out.println(adv);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
