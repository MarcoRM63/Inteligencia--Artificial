package com.company;

public class Nodo{
    public Nodo Padre;
    public Nodo li;
    public Nodo ld;
    public int claveart;
    public Nodo (int Indice) {
        claveart = Indice;
        li = null;
        ld = null;
        Padre = null;
    }

    public int getClaveart() {
        return claveart;
    }
}
