package com.sdp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class TaskListClient {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Socket clientSocket = new Socket("127.0.0.1", 4242);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true){
            System.out.println("R/L/Q");


        }
        out.println("Q");
        String response = in.readLine();
        System.out.println(response);

        in.close();
        out.close();
        clientSocket.close();
    }
}