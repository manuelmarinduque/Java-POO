package com.company;
import java.util.*;

/*  Único fichero .java: Sólo puede haber una clase pública (public class) y esta debe contener el método principal (main)  */

public class Main {

    public static void main (String[] args){

        //Creación de los objetos de la clase Empleado mediante un arreglo de tipo clase 'Empleado':

        Empleado[] misEmpleados = new Empleado[6]; //Tener en cuenta el tipo del arreglo. Este es de tipo 'Empleado' y guarda objetos de esta clase.

        //Se puede ingresar diferentes tipos de datos al arreglo, esto debido al constructor de la clase:
        misEmpleados[0] = new Empleado("Manuel", 125000, 2018, 1,10);
        misEmpleados[1] = new Empleado("Víctor", 130000, 2018, 12,12);
        misEmpleados[2] = new Empleado("Cristian", 14000, 2018, 7,11);
        misEmpleados[3] = new Empleado("Carlos"); //Objeto con estado inicial diferente, otro constructor, y valores por defecto.

        /*Polimorfismo en acción. Principio de sustitución: Se puede utilizar un objeto de la subclase siempre que el programa espere
        un objeto de la superclase. Esto es posible por la regla "es un" de la herencia: Un jefe es un empleado. En el vector misEmpleados
        de tipo 'Empleado' se guardan objetos de la superclase 'Empleado' y objetos de la subclase 'Jefatura'. */
        Jefatura jefeRecursosHumanos = new Jefatura("Alejandro", 55000, 2018, 01, 1);
        jefeRecursosHumanos.setIncentivo(2570);
        misEmpleados[4] = jefeRecursosHumanos;
        misEmpleados[5] = new Jefatura("Mario", 32000, 2018, 01, 28);

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

        for (int i = 0; i < misEmpleados.length; i++) {
            misEmpleados[i].setSubeSueldo(5); //Los objetos de la subclase pueden hacer uso de los métodos de la clase padre.
        }

        //Método para imprimir los datos

        for (int i = 0; i < misEmpleados.length; i++) {
            System.out.println(misEmpleados[i].getNombre() + " " +
                    misEmpleados[i].getSueldo()
                    /*Polimorfismo en acción: Cuando se ha sobreescrito un método y, en este caso, los objetos de la superclase y de la
                    subclase están dentro de un vector, el método sobreescrito, getSueldo, se comporta diferente para los dos tipos de objetos:
                    Para los objetos de la superclase se le suma al sueldo un 5% y para los de la subclase, además del 5%, se le suma un incentivo
                    establacido en el método setIncentivo.  */
                    + " " + misEmpleados[i].getFechaIngreso()) ;
        }
    }
}

class  Empleado {

    //Variables de la clase o atributos del objeto. Variables globales:

    //'private' para que se cumpla el concepto de encapsulación.
    private String nombre;
    private double sueldo;
    private Date fechaIngreso; //Importar paquete java.util

    //Constructor con parámetros de la clase: Permite dar un estado inicial a un objeto. Inicializa las variables declaradas.

    public Empleado(String nombre, double sueldo, int year, int mes, int dia) {

        //Instrucción 'this.' para hacer referencia a una variable de clase.
        this.nombre = nombre;
        this.sueldo = sueldo;

        //Uso de la clase GregorianCalendar

        //Como se utiliza un constructor de esta clase, se debe crear un objeto de esta con parámetros.
        GregorianCalendar calendario = new GregorianCalendar(year, mes-1, dia); //mes-1 porque enero = 0
        //Se obtiene la fecha especificada en el objeto 'calendario' a través del método getTime() que devuelve un valor de tipo Date.
        fechaIngreso = calendario.getTime();
    }

    //Métodos getters & setters: Para que se cumpla el concepto de encapsulación.

    public String getNombre (){
        return nombre;
    }

    public double getSueldo (){
        return sueldo;
    }

    public Date getFechaIngreso (){
        return fechaIngreso;
    }

    public void setSubeSueldo(double porcentaje) {

        //Variable local:
        double aumento = sueldo*porcentaje/100;

        sueldo += aumento;
    }

    /* Vídeo 39: Sobrecarga de constructores:

     Crear varios constructores dentro de una clase con la característica de que cada uno tiene diferente número y tipos de parámetros. La
     necesidad de esta sobrecarga es para dar diferentes estados iniciales a los objetos. Imagine que para los objetos de esta clase se conoce
     el nombre y se desconoce el sueldo y la fecha en que entra a trabajar un empleado. Para suplir este desconocimiento se crea un nuevo
     constructor que lo cubra. */

    public Empleado (String nombre) {

        //this.nombre = nombre;

        /* Para este caso particular, en que se desconocen datos, se quiere que los campos sueldo y fechaIngreso sean predefinidos. Para
        definirlos se hace uso de 'this', como se muestra debajo: Este udo de 'this' llama al constructor definido arriba. En caso de haber
        otros constructores, tal 'this' apuntaría al que tenga la misma cantidad de parámetros.*/

        this (nombre, 30000, 2000, 01, 01);
    }
}

//Vídeo 43: Diseñando la herencia.

class Jefatura extends Empleado {

    //Atributos de la clase o variables:

    private double incentivo;

    //Constructor de la clase:

    public Jefatura (String nombre, double sueldo, int year, int mes, int dia){
        super(nombre, sueldo, year, mes, dia);
    }

    /*Método que obtiene el sueldo de un jefe: Este método aumenta un pago de incentivo al sueldo. Sobreescritura del método getSueldo
    definido en la clase padre 'Empleado'.   */

    //Método para definir un incentivo que se le da a un jefe:

    public void setIncentivo (double incentivo) {
        this.incentivo = incentivo;
    }

    public double getSueldo () {

            /*Variable local: Llamada al método getSueldo de la clase padre, el cual retorna el sueldo del empleado (objeto) y es
            almacenado en la variable sueldoJefe. Esta llamada es con el objetivo de acceder a la variable 'sueldo' definida en la clase
            padre.

            Un llamado a un método de la clase padre desde una clase hija se aplica cuando una clase hija necesita acceder a
            una variable definida en la clase padre y para esto tal método debe ser de tipo getter y que retorne tal variable.

            La sintaxis para llamar a un método de la clase padre desde la clase hija es: super.-nombre_metodo-

            Tener en cuenta que el método getSueldo es sobreescrito en la clase hija y por esto se utiliza la instrucción 'super' para
            hacer referencia a un método de la clase padre. Es similar al uso de la instrucción 'this'.

            Este proceso se puede evitar declarando tal variable como protegida (protected) y llamando normalmente a la variable en la
            subclase. La idea es conservar el encapsulamiento al declarar la variable como privada*/

        double sueldoJefe = super.getSueldo();

        return sueldoJefe + incentivo;
    }
}