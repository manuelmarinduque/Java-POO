package com.company;

/*La ventana o marco es un soporte y encima de él se pone un lienzo en el cual dibujar.
Analogía: el marco es la mesa que usa el pintor este no escribe sobre ella directamente si no
que utiliza un lienzo encima para crear su trabajo.

En términos de programación un marco es un soporte para un panel, el panel es un lienzo, para
poder dibujar en él: escribir textos, añadir botones, crear menús. El panel es un cristal
transparente que tiene las misma dimensiones del marco y se pone encima de él.
*/

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MiMarco marco1 = new MiMarco();
    }
}

/*Clase que crea la ventana: Uso de la clase JFrame. Para construir una ventana se debe crear una clase que herede de la
 clase JFrame y a través del constructor de clase se diseña la ventana. */

class MiMarco extends JFrame {

    //Constructor de la clase:
    MiMarco () {
        // P1) Las ventanas nacen con un tamaño inútil. Se necesita del método setSize para darles tamaño.
        setSize(500,300);

        // P2) Las ventanas nacen invisibles. Se necesita del método setVisible para hacerla visible.
        setVisible(true);

        /* P3) Conviene decir qué debe hacer el programa si se cierra una ventana. Para que termine su ejecución se hace uso
        de la siguiente línea de código, junto con el uso de EXIT_ON_CLOSE: (Revisar en la API de java el método
        setDefaultCloseOperation de la clase JFrame y los parámetros que se le pueden ingresar). HIDE_ON_CLOSE es útil
        en los casos cuando se tiene más de una ventana y al cerrar una esta se oculta y las demás siguen abiertas. Los
        parámetros son campos del clase o estáticos*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*Existen ocasiones en que una ventana puede o no redimensionarse, esto es: una ventana puede agrandarse o compactarse.
        Para que una ventana no pueda redimensionarse se hace uso del siguiente método con argumento 'false'. */
        setResizable(false);

        //Método para centrar la ventana:
        setLocationRelativeTo(null);

        //Método para establecer un título a la ventana.
        setTitle("Ventana de prueba");

        /*Para poner el panel encima del marco se crea un objeto de la clase donde se diseña el panel en el constructor del
        marco y luego este panel se agrega al marco.    */
        MiPanel panel1 = new MiPanel();
        add(panel1);
    }
}

/*Clase que crea el panel o lienzo: Uso de la clase JPanel. Para construir un panel se debe crear una clase que herede de la
 clase JPanel y a través del método paintComponent construir los diseños del panel. */

class MiPanel extends JPanel {

    //Constructor de la clase: Constructor por defecto que crea un panel.

    /*Sobreescritura del método paintComponent: Método paintComponent(Graphics g): Método que permite dibujar, crear botones,
    crear menús y demás dentro del panel. Recibe como parámetro una variable de tipo Graphics. Esta clase se encarga
    de proporcionar todas las herramientas o métodos necesarios para poder dibujar gráficos: textos, figuras geométricas, etc.
    En general se debe utilizar un objeto (g) de la clase Graphis para hacer llamado a un método de esta.   */

    public void paintComponent (Graphics g) {

        /*El método sobreescrito debe realizar el trabajo para el cual fue diseñado, para esto se llama este método en la clase
        padre: JComponent, con el operador 'super' (ver apuntes) e ingresar como parámetro la variable de la clase Graphics. Una
        vez hecho su propio trabajo puede realizar los trabajos que uno le asigna. */
        super.paintComponent(g);

        //Método de la clase JPanel que establece un color de fondo al panel:
        setBackground(Color.WHITE);

        //Para ubicar gráficos se toma como referencia el eje cartesiando de la ventana. Tener en cuenta las dimensiones de esta.

        /*Para asignar un color a un gráfico se utiliza el método setColor de la clase Graphics. El color que se define en este
        método perdura hasta que más adelante en el código se redefina. */
        g.setColor(Color.ORANGE);
        g.drawString("Hola", 100,200);

        /*Creando un color propio: Uso de la clase color. Esta clase tiene constructores y uno de estos permite construir un color
        propio teniendo en cuenta el sistema RGB, este constructor recibe tres parámetros de tipo entero y para hallarlos se hace
        uso de la paleta de Paint. Métodos de la clase Color aplicados a los colores para darle más brillo: brighter u opacarlo:
        .darker */
        Color colorMoradoFuerte = new Color(86,50,163).brighter();
        Color colorAzulVerdoso = new Color(9,204,185);

        g.setColor(colorMoradoFuerte);
        g.fillOval(100,100,50,50);

        g.setColor(colorAzulVerdoso.darker());
        g.fillRect(100, 50,10,10);
    }
}
