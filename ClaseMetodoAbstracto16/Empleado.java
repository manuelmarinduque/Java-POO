//Basado en la herencia.
package com.company;

import javax.swing.*;

/*Una clase abstracta contiene al menos un método que no ha sido especificado, es decir, este método será herado para sobreescribirse.*/

//La clase es abstracta para evitar que sea instanciada, es decir, para que no se pueda crear objetos de esta clase.
public final class Empleado extends Persona {
    //Atributos de la subclase:
    double sueldo;
    String telefono, direccion;

    //Constructor de la subclase:
    public Empleado(String nom, int ed, double suel, String tel, String dir){
        super(nom, ed);
        this.sueldo=suel;
        this.telefono=tel;
        this.direccion=dir;
    }

    //Método de la subclase: Obligatoriamente sobreescrito de la superclase 'Persona' al ser un método abstracto.
    @Override
    public void verDatos(){
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad + "\nSueldo: " + sueldo
        + "\nTeléfono: " + telefono + "\nDirección: " + direccion, "Datos del empleado", JOptionPane.INFORMATION_MESSAGE);
    }

}
