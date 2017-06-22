package com.company;

import javax.swing.*;

public class Programador extends Informaticos {

    //Utilizando sobrecarga en los siguientes métodos heredados:
    public void sueldo(int horas, double pagoHora) {
        JOptionPane.showMessageDialog(null, "Pago: " + (horas*pagoHora));
    }

    public void datos(String nombre, String apellido) {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre +
                "\nApellido: " + apellido);
    }

    public void labores(String labor) {
        JOptionPane.showMessageDialog(null, "Me dedico a " + labor);
    }
}
