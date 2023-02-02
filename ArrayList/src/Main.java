import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static String nombrenuv,seleccion;
    static Scanner sc = new Scanner(System.in);
    static Scanner sb = new Scanner(System.in);
    static Scanner sd = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("------------Bienvenido a su agenda de telefono, seleccione una funccion------------");
        eleccion();
    }
    public static void eleccion(){
        System.out.println("0-Salir.\n1-Ver Lista de Contactos.\n2-Añadir Nuevo Contacto.\n3-Actualizar un contacto existente.\n4-Eliminar Contacto.\n5-Buscar informacion sobre Contacto.\n6-Volver a mostrar las opciones.");
               seleccion = sc.nextLine();
               while (!seleccion.matches("[0-6]{1}")) {
                   System.out.println("Vuelva a escribir una opcion valida del 0 al 6");
                   seleccion = sc.nextLine();
               }

        switch (seleccion){
            case "0":salir();break;
            case "1":TelefonoMovil.printContacts();menu();
            case "2": añadirnuevocontacto();menu();
            case "3":actualizarContacto();menu();
            case "4":eliminarContacto();menu();
            case "5":informacionContacto();menu();
            case "6":menu();
        }

    }
    public static void salir(){
        System.out.println("------------Gracias por utilizas tu agenda, hasta luego------------");
    }
    public static void menu(){
        System.out.println();
        System.out.println("Estas son las acciones que puede realizar a continuacion.");
        eleccion();
    }
    public static void añadirnuevocontacto(){
        String nombre,numero;
        System.out.println("Para añadir un nuevo contacto, por favor escriba su nombre");
        nombre =sb.nextLine();
        System.out.println("Y un numero de telefono");
        numero = sd.nextLine();
        while (!numero.matches("[0-9]{9}")){
            System.out.println("Escriba un numero de telefono valido");
            numero=sd.next();
        }
        Contacto nuevo= new Contacto(nombre,numero);
        TelefonoMovil.addNewContact(nuevo);
        System.out.println();
    }
    public static void actualizarContacto(){
        String nombre,numero;
        System.out.println("Escriba el nombre del contacto que desee actualizar:");
        nombre= sb.next();
        Contacto contacto1=TelefonoMovil.queryContact(nombre);
        if (contacto1 == null){
            System.out.println("El contacto que deseas actualizar no existe");
        }else {
            System.out.println("Escriba el nuevo nombre que desee utilizar");
            nombrenuv = sc.next();
            System.out.println("Y su nuevo numero de telefono");
            numero = sd.next();
            while (!numero.matches("[0-9]{9}")) {
                System.out.println("Escriba un numero de telefono valido");
                numero = sd.next();
            }
            Contacto nuevo = new Contacto(nombrenuv, numero);
            TelefonoMovil.updateContact(contacto1, nuevo);
            System.out.println("Su contacto se ha actualizado correctamente!");
            System.out.println();
        }
    }
    public static void eliminarContacto(){
        String nombre;
        System.out.println("Para eliminar contacto por favor escriba su nombre");
        nombre=sb.next();
        Contacto nuevo=TelefonoMovil.queryContact(nombre);
        TelefonoMovil.removeContact(nuevo);
    }
    public static void informacionContacto(){
        String nombre;
        System.out.println("Escribar el nombre del contacto que desee buscar su informacion");
        nombre=sb.nextLine();
        Contacto contactoinfo=TelefonoMovil.queryContact(nombre);
        if (contactoinfo==null){
            System.out.println("EL contacto que deseas buscar informacion no existe\nLe mandaremos de nuevo al menu de opciones");
            System.out.println();
        }else{
            System.out.println("La infomacion de su contacto es: "+ contactoinfo.getName()+" -------> "+contactoinfo.getPhoneNumber());
        }
    }
}
