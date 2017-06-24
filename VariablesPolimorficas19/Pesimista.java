package com.company;

import javax.swing.*;

public class Pesimista extends Personalidades {
    //Método de clase:
    @Override
    public void hablar() {
        JOptionPane.showMessageDialog(null, "Que mal día el que tengo", "Pesimista", 1);
    }
}
