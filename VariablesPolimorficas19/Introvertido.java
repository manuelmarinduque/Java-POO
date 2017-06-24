package com.company;

import javax.swing.*;

public class Introvertido extends Personalidades {
    //Método de clase:
    @Override
    public void hablar() {
        JOptionPane.showMessageDialog(null, "Hola", "Introvertido", 1);
    }
}
