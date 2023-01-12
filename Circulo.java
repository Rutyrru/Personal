import javax.sound.sampled.spi.AudioFileReader;
import java.awt.geom.Area;
import java.util.Scanner;

public class Circulo {
    static double radio;

    public Circulo(double radio) {
    this.radio=radio;
    }

    public static double getRadio() {
        return radio;
    }

    public static double getArea() {
        return radio * radio * Math.PI;
    }

    public static class Cilindro extends Circulo {
        static double altura;
        public Cilindro(double radio, double altura) {
            super(radio);
            this.altura=altura;
        }
        public double getAltura() {
            return altura;
        }
        public  double getVolumen(){
            return getArea()*altura;
        }
    }
    public static void main(String[]ars){
        Scanner sc= new Scanner(System.in);
        Scanner sb= new Scanner(System.in);
        System.out.println("Por favor introduce un radio y una altura para su cilindro:");
        System.out.print("Radio: ");
        double radio= sc.nextDouble();
        System.out.println();
        System.out.print("Altura: ");
        double altura= sb.nextDouble();
        System.out.println();
        Cilindro Cilindro = new Cilindro(radio, altura);
        System.out.println("El Radio de su cilindro es: " +getRadio());
        System.out.println("El Area de su cilindro es: " +getArea());
        System.out.println("La Altura de su cilindro es: "+Cilindro.getAltura());
        System.out.println("El Volumen de su cilindro es: "+Cilindro.getVolumen());

    }
}
