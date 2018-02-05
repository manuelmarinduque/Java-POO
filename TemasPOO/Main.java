package com.company;
import java.util.*;

/*  Único fichero .java: Sólo puede haber una clase pública (public class) y esta debe contener el método principal (main)  */

public class Main {

    public static void main (String[] args){

        //Creación de los objetos de la clase Empleado mediante vector de objetos de tipo 'Empleado':

        Empleado[] misEmpleados = new Empleado[6]; //Tener en cuenta el tipo del arreglo. Este es de tipo 'Empleado' y guarda objetos de esta clase.

        //Se puede ingresar diferentes tipos de datos al arreglo, esto debido al constructor de la clase:
        misEmpleados[0] = new Empleado("Manuel", 125000, 2018, 1,10);
        misEmpleados[1] = new Empleado("Víctor", 130000, 2018, 12,12);
        misEmpleados[2] = new Empleado("Cristian", 14000, 2018, 7,11);
        misEmpleados[3] = new Empleado("Carlos"); //Objeto con estado inicial diferente, otro constructor, y valores por defecto.

        /*Polimorfismo en acción. Principio de sustitución: Se puede utilizar un objeto de la subclase siempre que el programa espere
        un objeto de la superclase. Esto es posible por la regla "es un" de la herencia: Un jefe es un empleado. En el vector misEmpleados
        de tipo 'Empleado' se guardan objetos de la superclase 'Empleado' y objetos de la subclase 'Jefatura'. */
        Jefatura jefeRecursosHumanos = new Jefatura("Alejandro", 55000, 2018, 1, 1);
        jefeRecursosHumanos.setIncentivo(2570);
        misEmpleados[4] = jefeRecursosHumanos;
        misEmpleados[5] = new Jefatura("Mario", 32000, 2018, 1, 28);

        /*Vídeo 44: Casting o refundición de objetos: En el vector de tipo empleado se guardan objetos de la superclase y de la subclase,
        posible por el principio de sustitución; pero el vector sólo hace uso de los métodos definidos en la  superclase 'Empleado', por
        lo que no se puede hacer uso de los métodos definidos en la subclase 'Jefatura'. Para que los objetos de la subclase almacenados
        en el vector puedan hacer uso de sus propios métodos se hace casting de objetos. En este caso particular, se hace casting al
        objeto de tipo 'Jefatura' almacenado en la posicón 5 del vector para que pueda hacer uso del método setIncentivo. El proceso
        es similar a la refundición de tipo de datos y además se debe crear un objeto. Con el casting lo que se busca es convertir
        un objeto de una clase en un objeto de otra clase. Hay que tener en cuenta la herencia y la regla "es un", por lo que se puede
        hacer casting a 'Jefatura' a los objetos ubicados en las posiciones 4 y 5 pero no a los de las demás posiciones */

        Jefatura jefeSistemas = (Jefatura) misEmpleados[5];
        jefeSistemas.setIncentivo(3600);

        //Método para aumentar en 5% el sueldo de cada empleado:

        for (Empleado misEmpleado : misEmpleados) {
            misEmpleado.setSubeSueldo(5); //Los objetos de la subclase pueden hacer uso de los métodos de la clase padre.
        }

        /*Método para ordenar el vector misEmpleados por sueldo de menor a mayor. Tener en cuenta el método .sort de la clase Arrays, este debe ser
        elegido de acuerdo al tipo de dato que se ingresa como parámetro,  y la implementación de la interface 'Comparable' en la clase Empleado ya que
        esta clase es el tipo de dato del vector.   */

        Arrays.sort(misEmpleados);

        //Método para imprimir los datos

        for (Empleado misEmpleado : misEmpleados) {
            System.out.println(misEmpleado.getNombre() + " " + misEmpleado.getID() + " " +
                    misEmpleado.getSueldo()
                    /*Polimorfismo en acción: Cuando se ha sobreescrito un método y, en este caso, los objetos de la superclase y de la
                    subclase están dentro de un vector, el método sobreescrito, getSueldo, se comporta diferente para los dos tipos de objetos:
                    Para los objetos de la superclase se le suma al sueldo un 5% y para los de la subclase, además del 5%, se le suma un incentivo
                    establecido en el método setIncentivo.

                    El compilador de java en tiempo de ejecución sabe a qué método (sobreescrito) llamar de forma automática dependiendo del
                    objeto que lo invoque. A esto se le conoce como enlazado dinámico.  */
                    + " " + misEmpleado.getFechaIngreso());
        }
    }
}

/*Para que se pueda hacer el uso adecuado del método sort la clase Empleado debe implementar la interface 'Comparable', así lo marca la API de java, y sobreescribir
obligatoriamente su método: compareTo.*/

class  Empleado implements Comparable {

    //Variables de la clase o atributos del objeto. Variables globales:

    //'private' para que se cumpla el concepto de encapsulación.
    private final String nombre;
    private double sueldo;
    private Date fechaIngreso; //Importar paquete java.util
    private int ID;
    /*Variable estática: Variable que no pertenece a los objetos sino que pertenece a la clase, por lo que tal variable no depende de la creación de un objeto.
    Además no tiene copias, es única (No confundir con una constante). Todos los objetos de la clase comparten el valor de esta variable. Para manipular una
    variable estática se necesita de un método estático. La sintaxis para el llamado de un miembro estático es: nombre_clase.nombre_metodo/variable. No es
    necesario crear un objeto de la clase para hacer uso de una variable o método estático. Para convertir un miembro como estática se pone el modificador
    de acceso 'static' delante de una variable o método. Una variable estática debe ser declarada en la cabecera de la clase, donde se declaran las variables
    globales, esta no debe ser local si el método es no estático.   */
    private static int idSiguiente = 1;

    //Constructor con parámetros de la clase: Permite dar un estado inicial a un objeto. Inicializa las variables declaradas.

    Empleado(String nombre, double sueldo, int year, int mes, int dia) {

        //Instrucción 'this.' para hacer referencia a una variable de clase.
        this.nombre = nombre;
        this.sueldo = sueldo;
        /*Cada vez que se crea un objeto automáticamente se le asigna un ID y este luego se incrementa para ser asignado a un próximo objeto cuando se cree.
        En este caso, el hecho de la variable estática es para que el valor de idSiguiente no dependa de la creación de un objeto y sea compartido por todos.    */
        ID = idSiguiente;
        idSiguiente++;

        //Uso de la clase GregorianCalendar

        //Como se utiliza un constructor de esta clase, se debe crear un objeto de esta con parámetros.
        GregorianCalendar calendario = new GregorianCalendar(year, mes-1, dia); //mes-1 porque enero = 0
        //Se obtiene la fecha especificada en el objeto 'calendario' a través del método getTime() que devuelve un valor de tipo Date.
        fechaIngreso = calendario.getTime();
    }

    //Métodos getters & setters: Para que se cumpla el concepto de encapsulación.

    String getNombre (){
        return nombre;
    }

    int getID (){
        return ID;
    }

    double getSueldo (){
        return sueldo;
    }

    Date getFechaIngreso (){
        return fechaIngreso;
    }

    void setSubeSueldo(double porcentaje) {

        //Variable local:
        double aumento = sueldo*porcentaje/100;

        sueldo += aumento;
    }

    /* Vídeo 39: Sobrecarga de constructores:

     Crear varios constructores dentro de una clase con la característica de que cada uno tiene diferente número y tipos de parámetros. La
     necesidad de esta sobrecarga es para dar diferentes estados iniciales a los objetos. Imagine que para los objetos de esta clase se conoce
     el nombre y se desconoce el sueldo y la fecha en que entra a trabajar un empleado. Para suplir este desconocimiento se crea un nuevo
     constructor que lo cubra. */

    Empleado (String nombre) {

        //this.nombre = nombre;

        /* Para este caso particular, en que se desconocen datos, se quiere que los campos sueldo y fechaIngreso sean predefinidos. Para
        definirlos se hace uso de 'this', como se muestra debajo: Este udo de 'this' llama al constructor definido arriba. En caso de haber
        otros constructores, tal 'this' apuntaría al que tenga la misma cantidad de parámetros.*/

        this (nombre, 30000, 2000, 1, 1);
    }

    @Override
    public int compareTo(Object miObjeto) {
        /*Se hace casting de objetos, cast a tipo Empleado ya que el parámetro de tal método es de tipo Object, y así comparar los sueldos
        de los empleados. Luego debe darse sentido al método con la instrucción 'if', debido a la definición del método en la API. También
        se puede ordenar por ID y otros tipos. En general, en el 'if' se declara por cuál dato ordenar. */

        Empleado otroEmpleado = (Empleado) miObjeto;

        if (this.sueldo<otroEmpleado.sueldo) {
            return -1;
        }

        if (this.sueldo>otroEmpleado.sueldo){
            return 1;
        }

        return 0;
    }
}

//Vídeo 43: Diseñando la herencia.

class Jefatura extends Empleado {

    //Atributos de la clase o variables:

    private double incentivo;

    //Constructor de la clase:

    Jefatura (String nombre, double sueldo, int year, int mes, int dia){
        /*Cuando el constructor de la superclase tiene parámetros y esta clase se hereda el constructor de la subclase debe tener estos
        mismos parámetros, mas otros nuevos, y estos deben ser especificados en la instruccción 'super (parámetros superclase);'. Si tal
        constructor no tiene parámetros, se deja solo 'super();' dentro del constructor de la subclase.*/
        super(nombre, sueldo, year, mes, dia);
    }

    //Método para definir un incentivo que se le da a un jefe:

    void setIncentivo (double incentivo) {
        this.incentivo = incentivo;
    }

    /*Método que obtiene el sueldo de un jefe: Este método aumenta un pago de incentivo al sueldo. Sobreescritura del método getSueldo
    definido en la clase padre 'Empleado'.   */

    public double getSueldo () {

            /*Variable local: Llamada al método getSueldo de la clase padre, el cual retorna el sueldo del empleado (objeto) y es
            almacenado en la variable sueldoJefe. Esta llamada es con el objetivo de acceder a la variable 'sueldo' definida en la clase
            padre.

            Un llamado a un método de la superclase desde una subclase se aplica cuando una subclase necesita acceder a una variable
            definida en la superclase y que sea privada; para esto tal método debe ser de tipo getter y que retorne tal variable.

            La sintaxis para llamar a un método de la clase padre desde la clase hija es: super.-nombre_metodo-

            Tener en cuenta que el método getSueldo es sobreescrito en la clase hija y por esto se utiliza la instrucción 'super' para
            hacer referencia a un método de la clase padre. Es similar al uso de la instrucción 'this'.

            Este proceso se puede evitar declarando tal variable como protegida (protected) y llamando normalmente a la variable en la
            subclase. La idea es conservar el encapsulamiento al declarar la variable como privada*/

        double sueldoJefe = super.getSueldo();

        return sueldoJefe + incentivo;
    }
}