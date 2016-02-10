import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ListeContacts implements ServiceAgenda{

    private Map<String, Contact> liste = new HashMap<String, Contact>();

    public ListeContacts(){ }

    @Override
    public Contact accederContact(String pseudo){
        if ( liste.containsKey( pseudo ) ) {
            System.out.println("\tAccès à -> " + pseudo);
            return this.liste.get(pseudo);
        }
        else
            return null;
    }

    @Override
    public void ajouterContact(Contact c){
        this.liste.put(c.getPseudo(), c);
        System.out.println("\tAjout de -> " + c);
    }
}