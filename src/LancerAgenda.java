import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerAgenda {

    public static void main (String args[]){

        Contact c1 = new Contact("rich" ,   "richard.feynman@mit.edu");
        Contact c2 = new Contact("albert" , "albert.einstein@eth.zh");
        Contact c3 = new Contact("james" ,  "james.maxwell@cambridge.uk");

        ListeContacts lc = new ListeContacts();

        lc.ajouterContact(c1);
        lc.ajouterContact(c2);
        lc.ajouterContact(c3);

        lc.accederContact("rich");

        try{
            LocateRegistry.createRegistry(1099);
            Registry reg = LocateRegistry.getRegistry();
            ServiceAgenda serviceAgenda = (ServiceAgenda) UnicastRemoteObject.exportObject(lc,0);

            reg.rebind("Agenda",serviceAgenda);
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}