import java.util.ArrayList;

public class song {
    String titulo;
    double duracion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public song(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return  titulo + ", Duracion=" + duracion + "m ***\n";

    }
}