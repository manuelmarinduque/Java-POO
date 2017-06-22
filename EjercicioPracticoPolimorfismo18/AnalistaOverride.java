package com.company;

import javax.swing.*;

public class AnalistaOverride extends InformaticosOverride{

    //Métodos de la clase, redefinidos tal cual como se heredan de 'InformaticosOverride':
    @Override
    public void datos(String nombre) {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre);
    }

    @Override
    public void sueldo(double pago) {
        JOptionPane.showMessageDialog(null, "Pago: " + pago);
    }

    @Override
    public void labores(String labor) {
        JOptionPane.showMessageDialog(null, "Labor: " + labor);
    }
}
