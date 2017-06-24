package com.company;

import javax.swing.*;

public class Extrovertido extends  Personalidades {
    //Método de clase:
    @Override
    public void hablar() {
        JOptionPane.showMessageDialog(null, "Hola a todos, hoy tengo un buen dia, espero que ustedes también",
                "Extrovertido", 1);
    }
}
