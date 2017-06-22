package com.company;

import javax.swing.*;

public class Alumno {
    //Atributos de la clase: Palabra reserva 'private' para encapsular.
    private int noControl;
    private  String email;
    public String nombre, apellidos;

    /*La clase no tiene constructor. Si lo tuviera, desde la clase 'Main' se inicializa los valores para las variables,
    lo cual va a dar un correcto funcionamiento.   */

    //Métodos de la clase:

    /*Métodos get y set para acceder a los atributos privados:
        Método get: retorna un valor, el cual depende del tipo de dato especificado. No recibe parámetro.
        Método set: no retorna valor. Recibe un parámetro, el cual especifica el dato. Se emplea el operador 'this'  */
    public int getNoControl() {
        return noControl;
    }

    public void setNoControl(int noControl) {
        this.noControl = noControl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Método para mostrar los datos:
    void verDatos(){
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nApellido: " + apellidos
        + "\nNúmero de control: " + noControl + "\nEmal: " + email);
    }
}
