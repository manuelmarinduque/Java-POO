package com.company;

/* Vídeo 53: Vídeo 53: Clases internas: Clase dentro de otra. Cada clase tiene sus propios métodos y variables. Las clases internas
 pueden ser privadas (recomendado), las normales no pueden serlo.

 En este caso particular se implementa un temporizador que funciona de igual forma que el anterior pero con código diferente.
 Además se utiliza una clase interna con la necesidad de que esta sea anónima (private) ya que estas son útiles para gestionar
 eventos y retrollamadas, es decir, en el anterior código se crea la clase Hora con el objetivo de implementar un objeto interface
 de tipo ActionListener y luego ser pasado como segundo parámetro al constructor de la clase Timer; pero ahora en este código la
 clase Hora es una clase interna de la clase Roloj y tiene el mismo funcionamiento. Cabe mencionar que en este código se pasa como
 parámetro a un objeto de la clase Reloj el retrazo (primer parámetro del contructor de Timer) y si tiene sonido o no.  */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Temporizador2 {

    public static void main(String[] args) {

        //Variables en las que se almacena los valores ingresados por teclado:

        //Se multiplica por 1000 porque el intervalo es en milisegundos.
        int intervalo = (Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese intervalo")) * 1000);

        //Variables para determinar si hay sonido o no:
        boolean sonido;
        String valor;

        //El ciclo do-while es para que únicamente sean ingresados 'si' o 'no' correspondientes al sonido:
        do {
            valor = JOptionPane.showInputDialog(null, "¿Con o sin sonido?");
            sonido = valor.equalsIgnoreCase("si");
        }while (!valor.equalsIgnoreCase("si") && !valor.equalsIgnoreCase("no"));

        //Creación e inicialización del objeto de la clase Reloj:
        Reloj miReloj = new Reloj(intervalo, sonido);
        miReloj.Marcha();
        JOptionPane.showMessageDialog(null, "Pulse 'Aceptar' para salir.");
        System.exit(0);
    }
}

class Reloj {

    //Variables de la clase:
    private int intervalo;
    private boolean sonido;

    //Constructor de la clase:
    Reloj (int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    //Método que implementa la variable Timer:
    void Marcha() {

        //Creación del objeto interface, el cual proviene de la clase interna Hora:
        ActionListener oyente = new Hora(); //Por el pirncipio de sustitución.

        //Creación e inicialización de un objeto de la clase Timer:
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }

    //Clase interna la cual es anónima para implementar la interface ActionListener y crear un objeto interface de esta.
    private class Hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            System.out.println("La hora se coloca cada " + (intervalo/1000) + " segundos. Son las: " + ahora);

            /*Una clase interna puede acceder a las variables de la clase externa en la que esté, así sean privadas.    */
            if (sonido) { //No hace falta escribir sonido==true, ya que se sobreentiende si es true.
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
