package com.company;

/*Una clase abstracta contiene al menos un método que no ha sido especificado, es decir, este método será herado para
sobreescribirse.*/

public class Main {

    public static void main(String[] args) {
	    //Creacion del objeto:
        /*Como la clase 'Persona' es abstracta, no se puede crear objetos de esta. Así que el objeto que se crea
        es con respecto a la clase 'Empleado' */
        Empleado empleado1 = new Empleado("Manuel", 20, 25630.11, "2301218", "Calle 17");
        empleado1.verDatos();
    }
}
