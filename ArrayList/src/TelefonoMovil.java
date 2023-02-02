import java.util.ArrayDeque;
import java.util.ArrayList;
public class TelefonoMovil {
    private String MyNumber;
    private static ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(String myNumber) {
        this.MyNumber = myNumber;
        myContacts.add(Contacto.createContact("", MyNumber));
    }

    public static boolean addNewContact(Contacto contacto) {
        if (findContact(contacto)<0){
            System.out.println("Se ha añadido el contacto");
            myContacts.add(contacto);
            System.out.println();
            return true;
        }else{
            System.out.println("El numero ya existe, no se ha podido añadir a la lista");
            System.out.println();
            return false;
        }
    }
    public static boolean updateContact(Contacto oldcontact,Contacto newContact){
        if (findContact(oldcontact.getName())>=0){
            System.out.println("El numero se ha actualizado");
            myContacts.set(findContact(oldcontact),newContact);
            System.out.println();
            return true;
        }else{
            System.out.println("El contacto a actualizar no existe");
            System.out.println();
            return false;
        }
    }
    public static boolean removeContact(Contacto contacto){
        if(findContact(contacto)>=0){
            System.out.println("El numero ha sido eliminado");
            System.out.println();
            myContacts.remove(contacto);
            return true;
        }else{
            System.out.println("El contacto que has escrito no existe");
            System.out.println();
            return false;
        }
    }
    public static int findContact(Contacto contacto) {
        int posicion = myContacts.indexOf(contacto);
        if (posicion >= 0) {
            return myContacts.indexOf(contacto);
        } else {
            return -1;
        }
    }
    public static int findContact(String name){
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public static Contacto queryContact(String name){
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)){
                return myContacts.get(i);
            }
        }
        return null;
    }
    public static void printContacts(){
        if (myContacts.size()==0){
            System.out.println("La lista de contactos esta vacia");
            System.out.println();
        }else {
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println("Lista de contactos: \n" + myContacts.get(i).getName() + " -----> " + myContacts.get(i).getPhoneNumber());
            }
        }
    }
}