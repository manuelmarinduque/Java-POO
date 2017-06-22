package com.company;

/*Encapsulamiento (Acceso prohibido a los atributos): Proceso de ocultar los atributos de la clase, es decir, de los datos
  miembro de un objeto de manera que sólo se pueda cambiar y acceder a estos mediante los métodos definidos para ese objeto
 (especialmente mediante los métodos get y set)    */

public class Main {

    public static void main(String[] args) {
        //Creación del objeto:
        Alumno alumno1 = new Alumno();

        /*Cuando se escribe alumno1.**** no van a aparecer los atributos privados, para acceder a ellos es necesario los
        métodos get y set. Aunque definiendo un constructor para la clase 'Alumno' y creando el objeto se puede inicializar
        las variables sin necesidad de hacer lo siguiente. En el caso de que se quiera acceder al valor ya inicializado de
        una variable se utilizaría el método get.   */

        //Inicializando las variables:
        alumno1.setNoControl(201556071);
        alumno1.setEmail("victor.duque@correounivalle.edu.co");
        alumno1.nombre = "Víctor";
        alumno1.apellidos = "Marin";
        alumno1.verDatos();

        //Forma alternativa para mostrar por pantalla:
        System.out.println("Accediendo al número de control: " + alumno1.getNoControl());

    }
}
