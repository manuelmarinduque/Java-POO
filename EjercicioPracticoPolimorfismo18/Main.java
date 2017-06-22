package com.company;

/*Polimorfismo: Múltiples formas.
    * Sobrecarga (overload): Polimorfismo con respuesta de acuerdo a los parámetros de un método pudiendo agregar o quitar parámetros.
                             Por ejemplo, si un método recibe dos parámetros se le puede quitar o agregar más parámetros.
    * Sobreescritura (override): Polimorfismo redefiniendo los métodos heredados tal cual como son. No se puede agregar
                                 ni quitar parámetros.*/

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //Creando los objetos:
        Programador programador1 = new Programador();
        Analista analista1 = new Analista();
        AdministradorBD administradorBD1 = new AdministradorBD();

        ProgramadorOverride programadorOverride1 = new ProgramadorOverride();
        AnalistaOverride analistaOverride1 = new AnalistaOverride();
        AdministradorBDOverride administradorBDOverride1 = new AdministradorBDOverride();

        JOptionPane.showMessageDialog(null, "Sobrecarga (overload)");
        /*Sobrecarga en los métodos heredados de 'Informaticos'. Cada método en cada clase tiene diferente cantidad de parámetros. */
        programador1.datos("Juan", "Pérez");
        programador1.sueldo(24, 100.0);
        programador1.labores("programar");

        analista1.datos("Julián", "López", "Calle 25");
        analista1.sueldo(24,100.0, 1000);
        analista1.labores("analizar datos", 8);

        administradorBD1.datos("Pedro");
        administradorBD1.sueldo(4500);
        administradorBD1.labores("administrar la base de datos");

        JOptionPane.showMessageDialog(null, "Sobreescritura (override)");
        /*Sobreescritura. Los métodos para cada clase tienen la misma cantidad de parámetros, es decir, los métodos son compartidos
          o son los mismos para cada clase. */
        programadorOverride1.datos("Manuel");
        programadorOverride1.sueldo(2300);
        programadorOverride1.labores("programar");

        analistaOverride1.datos("Víctor");
        analistaOverride1.sueldo(4120);
        analistaOverride1.labores("analizar datos");

        administradorBDOverride1.datos("Cristian");
        administradorBDOverride1.sueldo(2360);
        administradorBDOverride1.labores("administrar la base de datos");
    }
}
