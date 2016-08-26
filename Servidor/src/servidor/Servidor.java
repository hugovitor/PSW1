/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ra21503801
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Aguardando uma " + "conexão na porta 1234");
            ServerSocket servidor = new ServerSocket(1234);// Prepara o servidor para receber conexoes na porta 1234
            Socket cliente = servidor.accept();//Interrompe a execução esperando um cliente
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());// lê ip do cliente
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(cliente.getInputStream())); //Prepara as classes para leitura dos dados 
            String lido = inputReader.readLine(); //Le a informação enviada

            String resposta = "papel";
            if (lido.trim().equals("tesoura")) {
                resposta = "pedra";
            } else if (lido.trim().equals("papel")) {
                resposta = "tesoura";
            }

            DataOutputStream out = new DataOutputStream(cliente.getOutputStream()); //Prepara as classes para envio dos dados 
				out.writeBytes(resposta + '\n'); //envia a mensagem (msg deve ser String)
                               // out.close();
            System.out.println("Fim." + lido);
        } catch (Exception e) {
            System.out.println("Erro ao esperar conexão ");
        }
    }

}
