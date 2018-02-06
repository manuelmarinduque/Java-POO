package com.company;

/* Vídeo 54: Clases internas locales: Clase dentro de un  método. Se utiliza cuando se va a instanciar un objeto de una clase
interna sólo una vez y esto ayuda a simplificar código. Una clase interna local no lleva modificador de acceso. Una clase externa
no puede acceder a una clase interna ni a una clase local, ambos tipos están muy encapsulados. Una clase local puede acceder a las
variables locales declaradas en el método y a las variables globales declaradas en la clase externa que la contenga.

En este caso particular se implementa un temporizador que funciona de igual forma que el anterior pero con código diferente. Esta
vez no se necesita hacer uso del constructor de la clase Reloj y las variables globales de esta pasarían a ser variables locales,
mejor dicho parámetros, del método Marcha. En este caso la clase interna Hora puede ser una clase local ya que para que el objeto
Timer dentro del método Marcha funcione sólo se debe crear un objeto interface ActionListener (oyente) que se declara en Hora .

En comparación con Temporizador2, este programa contiene menos código en la clase Reloj. PENSAR EN ESTO POSTERIORES PROGRAMAS.*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Temporizador3 {

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
        Reloj miReloj = new Reloj();
        miReloj.Marcha(intervalo, sonido);
        JOptionPane.showMessageDialog(null, "Pulse 'Aceptar' para salir.");
        System.exit(0);
    }
}

class Reloj {

    /*Método que implementa la variable Timer y contiene una clase local. Además este método recibe los parámetros que recibía
    el constructor. */
    void Marcha(int intervalo, boolean sonido) {

        //La clase local debe declararse antes de la creación de un objeto de esta.
        class Hora implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date ahora = new Date();
                System.out.println("La hora se coloca cada " + (intervalo/1000) + " segundos. Son las: " + ahora);

                if (sonido) { //No hace falta escribir sonido==true, ya que se sobreentiende si es true.
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        //Creación del objeto interface, el cual proviene de la clase interna local Hora:
        ActionListener oyente = new Hora(); //Por el pirncipio de sustitución.

        //Creación e inicialización de un objeto de la clase Timer:
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }
}
