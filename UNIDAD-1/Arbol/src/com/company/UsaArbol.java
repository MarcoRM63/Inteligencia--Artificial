package com.company;

public class UsaArbol {

    public static void main(String[] args) {
        Arbol a=new Arbol();
        a.insertar(15);
        a.insertar(20);
        a.insertar(30);
        a.insertar(16);
        a.insertar(8);
        a.insertar(6);
        a.insertar(7);
        a.insertar(1);
        a.insertar(60);
        a.insertar(80);
        a.insertar(65);
        a.insertar(90);
       boolean vacio = a.estaVacio();
       System.out.println(vacio);
       a.mostrar(a.raiz,0);
       a.PosOrder(a.raiz);

    }
}
