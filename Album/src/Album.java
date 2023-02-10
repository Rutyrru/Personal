import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    String nombre;
    String artista;
    private ArrayList<song> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        canciones = new ArrayList<>();
    }

    private song findSong(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).titulo.equalsIgnoreCase(titulo)) {
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {
        boolean retorno = true;
        if (findSong(titulo) == null) {
            canciones.add(new song(titulo, duracion));
            retorno = true;
            return retorno;
        } else {
            System.out.println("La cancion ya existe, no se ha agregado a tu album");
            retorno = false;
        }
        return retorno;
    }

    public boolean addToPlayList(int numero, LinkedList<song> lista) {
        boolean retorno = true;
        if (numero <= canciones.size()) {
            lista.add(canciones.get(numero));
            return retorno;
        } else {
            System.out.println("No se ha añadido");
            retorno = false;

        }
        return retorno;
    }

    public boolean addToPlaylist(String titulo, LinkedList<song> lista) {
        boolean retorno;
        if (findSong(titulo) == null) {
            System.out.println("La cancion se ha añadido a la lista de reproduccion");
            retorno = true;
            return retorno;
        } else {
            retorno = false;
        }
        return retorno;
    }
}
