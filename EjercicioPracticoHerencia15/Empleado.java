//Clase hija o subclase. Hereda de la superclase Persona
package com.company;

import javax.swing.*;

//Palabra reservada 'final' para que esta clase ya no sea heredable.
public final class Empleado extends Persona {
    //Atributos de la subclase:
    double sueldo;
    String telefono, direccion;

    //Constructor de la subclase:
    /*La subclase tiene su propio constructor: El constructor recibe parámetros los cuales son los atributos de la superclase
    y los definidos posteriormente en esta misma. El constructor de la subclase invoca al constructor de la superclase, para
    ello se incluye, obligatoriamente, la palabra clave super como primera línea del constructor de la subclase.    */

    public Empleado(String nom, int ed, double suel, String tel, String dir){
        super(nom, ed); //'super' para los atributos que se heredan de otra clase; aunque previamente definidos en el constructor.
        this.sueldo=suel;
        this.telefono=tel;
        this.direccion=dir;
    }

    //Método de la subclase:

    //Sobreescritura: Redefinir método heredado.
    @Override
    public void verDatos(){
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad + "\nSueldo: " + sueldo
        + "\nTeléfono: " + telefono + "\nDirección: " + direccion, "Datos del empleado", JOptionPane.INFORMATION_MESSAGE);

        /*Title: Mensaje o titulo de la ventana que se despliega.
          Icon: Ícono de la ventana que se despliega. Estos pueden obtenerse a través de JOptionPane. ***; aunque puede
                sustituirse por números:
                1 = Ícono de información.
                2 = Ícono de exclamación o advertencia.
                3 = Ícono de pregunta.
         */
    }

}
