package com.sdp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TaskListSv {
    public List<String> pedidos = new ArrayList<>();
    String tarefas;

    private void listarTarefas(){
        String unicastring = String.join(", ", pedidos);
        System.out.println(unicastring);
    }
    private void adicionarTarefas(String tarefas){
        if (tarefas.length()> 120){
            System.out.println("Task excceeded maximum letters.");
        }
        else {
            pedidos.add(tarefas);
        }
    }
    public static void main(String[] args) throws Exception {
        TaskListSv t = new TaskListSv();
        t.listarTarefas();


        ServerSocket serverSocket = new ServerSocket(4242);
        Socket clientSocket = serverSocket.accept(); // bloqueante
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String command = in.readLine();
        out.println("Server: received command " + command);

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}