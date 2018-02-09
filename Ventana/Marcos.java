package Graficos;

import javax.swing.*; //Librería que contiene las clases para construir ventanas.
import java.awt.*;

public class Marcos {

    public static void main (String[] args) {

        MiMarco marco1 = new MiMarco();

        /*P2 y P3 pueden declararse en el constructor de la clase o dentro del método main con el uso del objeto.
        A veces resulta más cómodo de una manera que de otra. Además hay varias formas de construir una ventana.    */
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

        /*El método setLocation establece una ubicación para el marco definida por el usuario y toma como referencia la pantalla,
        esto cuando se tiene un marco; en caso de que un marco contenga a otro se toma como referencia el componente padre, es
        decir, el marco que lo engloba. Tener en cuenta que este método hace uso de un eje carteasiano y su punto céntrico es
        la esquina superior izquierda de la pantalla, por tanto la pantalla corresponde al cuarto cuadrante del eje.  */
        //setLocation(450,250); //Sólo recibe parámetros positivos correspondientes a un punto (x,y).

        /*El método setBounds reemplaza el uso de setSize y de setLocation, ya que este método define una posición (x,y), un ancho
        y un alto. Para la posición se debe tener en cuenta el eje cartesiado mencionado anteriormente. */
        //setBounds(450,250, 250,250);

        /*Existen ocasiones en que una ventana puede o no redimensionarse, esto es: una ventana puede agrandarse o compactarse. Para
        que una ventana no pueda redimensionarse se hace uso del siguiente método con argumento 'false'. */
        setResizable(false);

        //Método para centrar la ventana:
        setLocationRelativeTo(null);

        /*Método para que la ventana se abra a pantalla completa. Revisar en la API de java el método que es de la clase JFrame y
        los parámetros que se le pueden ingresar.   */
        //setExtendedState(Frame.MAXIMIZED_BOTH);

        /*Método para establecer un título a la ventana.    */
        setTitle("Ventana de prueba");

        /*Método para establecer un ícono a un programa. Se hace uso del método estático getDafaultToolkit que retorna un valor de tipo
        Toolkit el cual contiene el sistema nativo de ventanas y se almacena en la variable miPantalla. Luego se hace uso del método
        getImage de la clase Toolkit, por lo cual debe ser llamado por un objeto de esta, que retorna un valor de tipo Image y se almacena
        en la variable miImagen. Por último se utiliza el método setIconImage que recibe como parámetro la imagen contenida en la variable
        miImagen.   */
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miImagen = miPantalla.getImage("src/phi.png"); //Se debe especificar la ruta en donde esté la imagen.
        setIconImage(miImagen);

        /*Los valores que retorna cada método son valores objetos. Cuando un método retorne un valor objeto se procede a crearse como 
        lo que se hace en la línea 61-62 y 80. */
    }
}

/*Clase para poder centrar una ventana. Esta forma es la más exacta que el método anterior. NO TERMINADO.  */

class VentanaCentrada extends  JFrame {

    //Constructor de la clase:
    VentanaCentrada () {
        //Se hace uso del método getDafaultToolkit que retorna un valor de tipo Toolkit el cual contiene el sistema nativo de ventanas.
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        /*El método getScreenSize obtiene el tamaño o resolución de la pantalla. Al ser de la clase Toolkit se llama a través
        de un objeto de esta. Este método retorna un valor de tipo 'Dimension'. Al tratarse de resolución se refiere a 720*460 HD,
        1900*1080 FHD y así.    */
        Dimension miDimension = miPantalla.getScreenSize();
        /*Ahora hay que obtener por separado la altura y el ancho de la resolución de la pantalla almacenado en miDimension, este
        método almacena cada dato en las variables de clase width y height. Para obtenerlos se crea dos variales que las contenga.  */
        int altura = miDimension.height;
        int ancho = miDimension.width;
        setLocation((ancho-altura)/2, (altura-ancho)/2);
        setVisible(true);
    }

}
