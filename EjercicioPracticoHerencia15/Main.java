//Clase principal. Aquí es donde se crean los objetos de las clases definidas y se ejecuta el programa.
package com.company;

/*  Herencia: Permite la creación de nuevas clases basadas en clases existentes. Cuando se hereda de una clase existente
             se reusa (o se hereda) métodos y atributos con la posibilidad de agregar métodos y atributos nuevos para cumplir
             con la situación nueva. Ver https://geekytheory.com/tutorial-13-java-herencia  */

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //Creación de los objetos:

        /*Objeto con ingreso de datos desde el teclado enviados al constructor. Para ello se definen variables en la clase principal
        y luego se inicializan con datos ingresados desde el teclado:     */

        //Declaración de variables:
        String nombre, telefono, direccion;
        int edad;
        double sueldo;

        /*Inicialización de las variables a partir de datos ingresados desde el teclado. Cabe destacar que si el tipo de dato
         es 'String', no se necesita usar la palabra reservada 'parse'; de lo contrario, si la palicación de 'parse' depende del tipo
         de dato tal como se muestra a continuación con int y double*/
        nombre= JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado: ", "Solicitando datos", 3);
        edad= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del empleado: ", "solicitando datos", 3));
        sueldo= Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el sueldo del empleado: ", "solicitando datos", 3));
        telefono= JOptionPane.showInputDialog(null,"Ingrese el teléfono del empleado: ", "Solicitando datos", 3);
        direccion= JOptionPane.showInputDialog(null,"Ingrese la dirección del empleado: ", "Solicitando datos", 3);

        //Creación del objeto:
        Empleado empleado1 = new Empleado(nombre, edad, sueldo, telefono, direccion);
        empleado1.verDatos();

        //Objeto con ingreso de datos estáticos enviados al constructor:
        Empleado empleado2 = new Empleado("Víctor", 18, 756300.31, "2301218", "Calle 17");
        empleado2.verDatos();


    }
}
