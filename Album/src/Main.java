import java.util.*;

public class Main {
    static String seleccion;
    static ArrayList<Album> Lista = new ArrayList<Album>();
    static LinkedList<song> Contento = new LinkedList<song>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Album Badbunny = new Album("Un verano sin ti", "Bad bunny");
        Badbunny.addSong("Titi ME Pregunto", 3.40);
        Badbunny.addSong("Despues de la playa", 4);
        Badbunny.addSong("Ojitos Lindo", 4.25);
        Lista.add(Badbunny);

        Album Romeo = new Album("Formula Vol 2", "Romeo Santos");
        Romeo.addSong("Amigo", 4.24);
        Romeo.addSong("Ella y Yo", 3.51);
        Romeo.addSong("Eres mía", 4.10);
        Lista.add(Romeo);

        Lista.get(0).addToPlayList(0, Contento);
        Lista.get(0).addToPlayList(1, Contento);
        Lista.get(0).addToPlayList(2, Contento);
        Lista.get(1).addToPlayList(0, Contento);
        Lista.get(1).addToPlayList(1, Contento);
        Lista.get(1).addToPlayList(2, Contento);

        System.out.println(
                "------------Bienvenido a su aplicacion de musica  de su telefono, seleccione una funccion------------");
        play(Contento);

    }

    public static void play(LinkedList<song> canciones) {
        ListIterator<song> it = canciones.listIterator();
        boolean cero = true;
        boolean continuar = true;
        boolean haciaAdelante = true;
        imprimirmenu();
        while (continuar) {

            switch (seleccion) {
                case "0":
                    salir();
                    continuar = false;
                    break;
                case "1":
                    if (Contento.size()==0){
                        System.out.println("**No hay canciones en tu lista***");
                    }else {
                        if (cero == true) {
                            it.next();
                            System.out.println("***Sonando " + it.previous());
                            cero = false;
                        } else {
                            if (!haciaAdelante) {
                                if (it.hasNext())
                                    it.next();
                                haciaAdelante = true;
                            }
                            if (it.hasNext()) {
                                it.next();
                                if (it.hasNext()) {
                                    System.out.println("***Sonando " + it.next());
                                    it.previous();
                                } else {
                                    System.out.println("***Ya no hay más canciones***");
                                    haciaAdelante = false;
                                }
                            }
                        }
                    }
                    imprimirmenu();
                    break;
                case "2":
                    if (Contento.size()==0){
                        System.out.println("***No hay canciones en tu lista***");
                    }else {
                        if (cero == true) {
                            System.out.println("********Actualmente no esta sonando ninguna cancion********\n");
                        } else if (cero == false) {
                            if (it.hasPrevious()) {
                                System.out.println("***Sonando " + it.previous());
                            } else {
                                System.out.println("***Estas en la primera cancion***");
                            }
                        }
                    }
                    imprimirmenu();
                    break;
                case "3":
                    if (cero == true) {
                        System.out.println("********Actualmente no esta sonando ninguna cancion********\n");
                    } else if (cero == false) {
                        if (it.hasNext()) {
                            it.next();
                            System.out.println(it.previous());
                        }
                    }
                    imprimirmenu();
                    break;

                case "4":
                    listasrep();
                    imprimirmenu();
                    break;
                case "5":
                    if (cero == true) {
                        System.out.println("********Actualmente no esta sonando ninguna cancion********\n");
                    } else if (cero == false) {
                        try {
                            it.next();
                            System.out.println(
                                    "***La cancion " + it.previous().titulo + " ha sido eliminada de la lista***\n");
                            it.remove();

                            if(it.hasNext()){
                            it.next();
                                System.out.println("***Actualmente esta sonando " + it.previous().titulo + "***");
                            }else if(it.hasPrevious()){
                                System.out.println("***Actualmente esta sonando " + it.previous().titulo + "***");
                            }
                        } catch (Exception e) {
                            System.out.println("***Su lista de reproduccion esta vacia***\n");
                        }
                    }
                    imprimirmenu();
                    break;

                case "6":
                    imprimirmenu();
            }

        }
    }

    public static void salir() {
        System.out.println("------------Gracias por utilizas su aplicacion de musica, hasta luego------------");
    }

    public static void listasrep() {
        System.out.println("Actualmente se encuentran disponible las siguientes canciones en su lista de reproduccion");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < Contento.size(); i++) {

            System.out.println((i + 1) + "-" + Contento.get(i).getTitulo());
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    public static void imprimirmenu() {
        System.out.println(
                " 0-Salir \n 1-Reproducir siguiente cancion \n 2-Reproducir cancion anterior\n 3-Repetir cancion actual\n 4-Imprimir lista de canciones en playlist\n 5-Eliminar cancion actual\n 6-Volver a imprimir el menu");
        seleccion = sc.nextLine();
        while (!seleccion.matches("[0-6]{1}")) {
            System.out.println("Vuelva a escribir una opcion valida del 0 al 6");
            seleccion = sc.nextLine();
        }

    }
}
