package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //Variables en las que se almacena los valores ingresados por teclado:

        //Se multiplica por 1000 porque el intervalo es en milisegundos.
        int intervalo = (Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese intervalo")) * 1000);

        Aumento miObjeto = new Aumento();
        miObjeto.aumentar(intervalo);
    }
}

class Aumento {

    private int variable;

    void aumentar (int intervalo){
        class Interface implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                variable++;
                System.out.println("Se ha sumado 1. Variable es igual a: " + variable);
            }
        }

        ActionListener oyente = new Interface();
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
        JOptionPane.showMessageDialog(null, "Pulse 'Aceptar' para salir.");
        System.exit(0);
    }
}
