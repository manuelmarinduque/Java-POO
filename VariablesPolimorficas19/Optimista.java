package com.company;

import javax.swing.*;

public class Optimista extends Personalidades {
    //Método de clase:
    @Override
    public void hablar() {
        JOptionPane.showMessageDialog(null, "Tengo un excelente día", "Optimista", 1);
    }
}
