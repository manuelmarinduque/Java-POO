package com.company;

//Variable polimórfica: Es aquella que contiene un objeto.
//Para este caso la clase 'Personalidades' no debe ser abstracta ya que se deben hacer instancias de esta.

public class Main {

    public static void main(String[] args) {
        //Creando objetos: En este caso los objetos se crean en una forma alternativa que involucra la clase padre.
        Personalidades objExtrovertido = new Extrovertido();
        Personalidades objIntrovertido = new Introvertido();
        Personalidades objOptimista = new Optimista();
        Personalidades objPesimista = new Pesimista();

        //Creando variable polimórfica: En este caso tal variable es un vector de personalidades.
        Personalidades objPersonalidad[] = new Personalidades[4];
        objPersonalidad[0] = objExtrovertido;
        objPersonalidad[1] = objIntrovertido;
        objPersonalidad[2] = objOptimista;
        objPersonalidad[3] = objPesimista;

        //Ejecutando las variables polimórficas definidas:
        objPersonalidad[0].hablar();
        objPersonalidad[1].hablar();
        objPersonalidad[2].hablar();
        objPersonalidad[3].hablar();
    }
}
