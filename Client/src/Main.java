import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try{
            System.out.println("Créer une connexion au serveur");
            Socket clientSocket = new Socket("localhost", 3000);
            System.out.println("Génération d'un objet inputStream et outputStream de la socket");
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            System.out.print("Lire un nombre au clavier: NB = ");
            Scanner sc = new Scanner(System.in);
            int nb = sc.nextInt();
            System.out.println("Envoyer le nombre "+nb+" au serveur");
            os.write(nb);
            System.out.println("Attendre la réponse du serveur");
            int rep = is.read();
            System.out.println("La réponse est: "+rep);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}