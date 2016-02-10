import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cyprien on 10/02/16.
 */
public interface ServiceAgenda extends Remote {
    Contact accederContact(String s) throws RemoteException;
    void ajouterContact(Contact c) throws RemoteException;
}
