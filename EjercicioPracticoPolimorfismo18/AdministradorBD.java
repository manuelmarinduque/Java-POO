package com.company;

import javax.swing.*;

public class AdministradorBD extends Informaticos {

    //Utilizando sobrecarga en los siguientes métodos heredados:
    public void sueldo(double pago) {
        JOptionPane.showMessageDialog(null, "Pago: " + pago);
    }

    public void datos(String nombre) {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre);
    }

    public void labores(String labor) {
        JOptionPane.showMessageDialog(null, "Me dedico a " + labor);
    }
}
