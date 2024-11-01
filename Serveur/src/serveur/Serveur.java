/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serveur;
import java.io.*;
import java.net.*;

/**
 *
 * @author HP
 */
public class Serveur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("J'attends la connexion du client");
            Socket clientSocket = ss.accept();
            System.out.println("Nouveau client connecté");
            System.out.println("Generation d'un objet inputStream et OutputStream");
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            System.out.println("J'attends un nombre (1 octet)");
            int nb = is.read();
            System.out.println("J'envoies la réponse");
            os.write(nb*5);
            System.out.println("Déconnexion du client");
            clientSocket.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
