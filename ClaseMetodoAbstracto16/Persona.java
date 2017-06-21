//Basado en la herencia.
package com.company;

/*Una clase abstracta contiene al menos un método que no ha sido especificado, es decir,
este método será herado para sobreescribirse.*/

public abstract class Persona {
    //Atributos de la superclase:
    String nombre;
    int edad;

    //Constructor de la superclase:
    public Persona (String nom, int ed){
        this.nombre=nom;
        this.edad=ed;
    }

    /*Método de la superclase: Al ser un método abstracto no necesita corchetes y debe sobreescribirse
    obligatoriamente en la clase a la cual se hereda, en este caso a 'Empleado.*/
    abstract public void verDatos();
}
