package com.company;

import javax.swing.*;

public class Analista extends Informaticos {

    //Utilizando sobrecarga en los siguientes métodos heredados:
    public void sueldo(int horas, double pagoHora, double incentivo) {
        JOptionPane.showMessageDialog(null, "Pago: " + ((horas*pagoHora)+incentivo));
    }

    public void datos(String nombre, String apellido, String direccion) {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre +
                "\nApellido: " + apellido + "\nDireccion: " + direccion);
    }

    public void labores(String labor, int horas) {
        JOptionPane.showMessageDialog(null, "Me dedico a " + labor + " " + horas + " horas al día");
    }
}
