import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws NotBoundException,RemoteException{
        String serveur="localhost";
        int port=1099;

        if( args.length > 0 )
            serveur=args[0];
        if( args.length > 1 )
            port=Integer.parseInt(args[1]);

        Registry rg = LocateRegistry.getRegistry(serveur,port);

        ServiceAgenda serviceAgenda = (ServiceAgenda)rg.lookup("Agenda");

        Contact alb = serviceAgenda.accederContact("albert");

        System.out.println("Récupéré : " + alb.toString());
        System.out.println("Ajoute KAARIS");
        serviceAgenda.ajouterContact(new Contact("KAARIS 270","kaaris93@gmail.com"));
        Contact kaa = serviceAgenda.accederContact("KAARIS 270");
        System.out.println("Recupere: " + kaa.toString());
    }
}
