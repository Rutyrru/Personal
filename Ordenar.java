import java.util.Arrays;

public class Estudiante implements  Comparable<Estudiante>{
    String Nombre;
    int Altura;
    int Edad;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int altura) {
        Altura = altura;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public Estudiante(String nombre, int altura, int edad) {
        Nombre = nombre;
        Altura = altura;
        Edad = edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        int resultado=0;
        if (this.Altura<o.Altura) {   resultado = 1;      }
        else if (this.Altura>o.Altura) {    resultado = -1;      }
        else {
            if(this.Edad<o.Edad){resultado=1;}
            else if(this.Edad<o.Edad){resultado=-1;}
        }
        return resultado;

    }

    public static void main(String[] args) {
        Estudiante arrayEstudiantes[]=new Estudiante[5];
        Estudiante aa=new Estudiante("Patri",170,12);
        Estudiante bb=new Estudiante("Manuel",173,43);
        Estudiante cc=new Estudiante("Javier",189,72);
        Estudiante dd=new Estudiante("Alicia",168,52);
        Estudiante ee=new Estudiante("Alberto",189,35);
        arrayEstudiantes[0]= aa;
        arrayEstudiantes[1]=bb;
        arrayEstudiantes[2]=cc;
        arrayEstudiantes[3]=dd;
        arrayEstudiantes[4]=ee;

        System.out.println("----------------Lo primero de todo vamos a comparar de todos los estudiantes quien es mas alto.---------------");
        System.out.println();
        for (int i = 0; i < arrayEstudiantes.length; i++) {
            for (int j = i+1; j < arrayEstudiantes.length; j++) {
                if(arrayEstudiantes[i].compareTo(arrayEstudiantes[j])<0){
                    System.out.println(arrayEstudiantes[i].Nombre+" es mas alto que " + arrayEstudiantes[j].Nombre);
                }else if (arrayEstudiantes[i].compareTo(arrayEstudiantes[j])>0){
                    System.out.println(arrayEstudiantes[j].Nombre+" es mas bajo que " +arrayEstudiantes[i].Nombre );
                }
                Arrays.sort(arrayEstudiantes);
            }
        }
        System.out.println();
        System.out.println("---------------Ahora ordenaremos a los Alumnos de mayor altura a menor y en el caso que la altura sea igual, se ordenara por quien es mayor---------------");
        System.out.println();
        for (int i = 0; i < arrayEstudiantes.length; i++) {
            System.out.println((i+1)+"- "+ arrayEstudiantes[i].Nombre +" Altura: "+ arrayEstudiantes[i].Altura+" Edad: "+arrayEstudiantes[i].Edad);
        }
    }
}
