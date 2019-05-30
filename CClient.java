package com.example.yoni.videocontroller;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class CClient
        implements Runnable
{
    private Socket socket;
    private static final int ServerPort = 13000;

    @Override
    public void run()
    {
        try
        {
            socket = new Socket(MainActivity.ipadd, ServerPort);
        }
        catch(Exception e)
        {
            System.out.print("Whoops! It didn't work!:");
            System.out.print(e.getLocalizedMessage());
            System.out.print("\n");
        }
    }

    public void Send(String s)
    {
        try
        {
            PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            outToServer.print(s);
            outToServer.flush();
            outToServer.close();


        }
        catch (UnknownHostException e) {
            System.out.print(e.toString());
        } catch (IOException e) {
            System.out.print(e.toString());
        }catch (Exception e) {
            System.out.print(e.toString());
        }

    }
}
