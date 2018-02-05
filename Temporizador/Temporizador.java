package com.company;

//Vídeo 52:

import javax.swing.*;
import javax.swing.Timer; //Para utilizar la clase Timer.
import java.awt.event.*; //Para utilizar la interface ActionListener.
import java.util.*; //Para declarar variable de tipo Date.

//Temporizador: Programa que desencadena una acción cada determinado tiempo.

public class Temporizador {

    public static void main(String[] args) {

        /*Objeto de tipo interface ActionListener el cual es el segundo parámetro del constuctor de Timer.*/
        ActionListener oyente = new Hora();

        /*Como se usa el constructor de la clase Timer se crea un objeto de esta. Tal constructor recibe dos parámetros:
        el primero es de tipo entero y hace referencia al retraso (delay): frecuencia con que se realiza una determinada
        acción expresada en milisegundos y el segundo es de tipo interface ActionListener (detalles en la clase Hora).

        (26:55) Todos los eventos deben invocar al método actionPerformed. Debido a esto toda clase que desencadena un evento
        debe implementar la interface ActionListener simplemente para asegurar que el método actionPerformed ha sido sobreescrito.
        Es por esta razón que el segundo parámetro del constructor de Timer es de tipo interface.   */

        Timer miTemporizador = new Timer(5000, oyente);

        //Inicia la variable miTemporizador y hace que comience a enviar eventos de acción a sus oyentes:

        miTemporizador.start();

        /*Pero la instrucción anterior se ejecuta rápidamente, en menos de un segundo, y luego el programa terminaría su
        ejecución, con lo cual no se puede apreciar los eventos. Para resolver el problema es necesario hacer uso de una
        ventana de diálogo, la cual para el flujo de ejecución del programa para que los eventos sean visibles. Cuando
        se es pulsado el botón 'Aceptar' de la ventana, esta se cierra y el flujo continúa y con lo cuál la última línea
        de código detiene la ejecución del programa. */

        JOptionPane.showMessageDialog(null, "Pulsa 'aceptar' para detener");

        System.exit(0);
    }
}

/*(10:45) El segundo parámetro del constructor de la clase Timer es de tipo interface ActionListener; pero para poder pasarse este
parámetro se debe crear una clase que implemente tal interface, luego crear un objeto de esta clase y pasar este como parámetro.
Esto se realiza así porque Java es orientado a objetos por lo que obliga a que se pase como segundo parámetro al constructor de
Timer un objeto de tipo interface ActionListener (oyente) y la creación de la clase es porque una interface no se puede instanciar,
por lo que esta clase, por el principio de sustitución, crearía instancias de la interface. */

class Hora implements ActionListener { //Al implementar una interface se debe sobreescribir todos sus métodos.

    /*Este método que se sobreescribe realiza la acción que se reproduce cada cierto tiempo el cual se especifica en el
    constructor de la clase Timer. El método es llamado cuando ocurre una acción.

     En este caso particular, cada 5 segundos se almacena la hora actual en la variable 'ahora', esto debido al constructor
     de cla clase, y luego es visualizada. */

    @Override
    public void actionPerformed(ActionEvent e) {

        Date ahora = new Date();

        System.out.println("La hora se coloca cada 5 segundos. Son las: " + ahora);
    }
}
