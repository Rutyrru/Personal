public class Forma {
         private static String nombre;

         public Forma(String nombre) {
             this.nombre = nombre;
         }

         public double area() {
             return 0;
         }

         @Override
         public String toString() {
             return "Forma{" +
                     "nombre='" + nombre + '\'' +
                     '}';
         }

         public static String getNombre() {
             return nombre;
         }

         public static void setNombre(String nombre) {
             Forma.nombre = nombre;
         }

         static class Esfera extends Forma {
             double radio;

             public double getRadio() {
                 return radio;
             }

             public void setRadio(double radio) {
                 this.radio = radio;
             }

             public Esfera(String nombre, double radio) {
                 super(nombre);
                 this.radio = radio;
             }

             public double area() {
                 return 4 * Math.PI * (Math.pow(radio, 2));
             }

             @Override
             public String toString() {
                 return "Esfera{" +
                         "nombre='" + nombre + '\'' +
                         "radio=" + radio + '}';
             }
         }

         static class Rectangulo extends Forma {
             private double longitud;
             private double ancho;

             public double getLongitud() {
                 return longitud;
             }

             public void setLongitud(double longitud) {
                 this.longitud = longitud;
             }

             public double getAncho() {
                 return ancho;
             }

             public void setAncho(double ancho) {
                 this.ancho = ancho;
             }

             public Rectangulo(String nombre, double longitud, double ancho) {
                 super(nombre);
                 this.longitud = longitud;
                 this.ancho = ancho;
             }

             public double area() {
                 return longitud * ancho;
             }

             @Override
             public String toString() {
                 return "Rectangulo{" +
                         "nombre='" + nombre + '\'' +
                         ", longitud=" + longitud +
                         ", ancho=" + ancho +
                         '}';
             }
         }

         static class Cilindro extends Forma {
             private double radio;
             private double altura;

             public Cilindro(String nombre, double radio, double altura) {
                 super(nombre);
                 this.radio = radio;
                 this.altura = altura;
             }

             public double getRadio() {
                 return radio;
             }

             public void setRadio(double radio) {
                 this.radio = radio;
             }

             public double getAltura() {
                 return altura;
             }

             public void setAltura(double altura) {
                 this.altura = altura;
             }

             public double area() {
                 return Math.PI * (Math.pow(radio, 2) * altura);
             }

             @Override
             public String toString() {
                 return "Cilindro{" +
                         "nombre='" + nombre + '\'' +
                         ", radio=" + radio +
                         ", altura=" + altura +
                         '}';
             }
         }

              public static class Pintura {

                 double cobertura;

                  public double getCobertura() {
                      return cobertura;
                  }

                  public void setCobertura(double cobertura) {
                      this.cobertura = cobertura;
                  }

                  public Pintura(double cobertura) {
                     super();
                     this.cobertura = cobertura;
                 }

                 public double cantidad(Forma objeto) {
                     return objeto.area() / cobertura;
                 }

                 @Override
                 public String toString() {
                     return "Pintura{" +
                             "cobertura=" + cobertura +
                             '}';
                 }
             }



         public static class MainPintura{
             public static void main(String[] args) {
                Pintura pintura =new Pintura(250);
                Esfera esfera = new Esfera("Esferon",15);
                Rectangulo rectangulo=new Rectangulo("JuanPedro",20,35);
                Cilindro cilindro = new Cilindro("Cilindron",10,30);
                 System.out.println("----------Vamos a calcular el area en metros cuadrados que ocuparia una figura.------------ ");

                 System.out.println("Empezaos con el rectangulo "+pintura.cantidad(rectangulo)+" m2");
                 System.out.println("Continuamos con la esfera "+ pintura.cantidad(esfera)+" m2");

                 System.out.println("Y para terminar tenemos el cilindro "+pintura.cantidad(cilindro)+" m2");
             }
         }
         }
