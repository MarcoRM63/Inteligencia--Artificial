package com.company;

import java.util.ArrayList;

public class Nodo {
    private Nodo padre;
    private String valor;
    private  int costo;
    final static String[] MOVIMIENTO = {"13", "024", "15", "045", "1357", "248", "37", "468", "57"};

    public Nodo(String valor) {
        this.valor = valor;
        padre = null;
        //this.padre= padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getPadre() {
        return this.padre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getValor() {
        return valor;
    }

    public ArrayList<Nodo> getSucesores() {
       ArrayList<Nodo> listaSucesores=new ArrayList<Nodo>();
        char caracter = '_';
        int pCero = this.valor.indexOf(caracter);

       if (pCero==0){

       }
        int cont = MOVIMIENTO[pCero].length();
        for (int i = 0; i <  cont; i++) {
            char []aux = this.valor.toCharArray();

            //obtener la posicion por la cual vamos a intercambiar el vacio

            int posicionMovimiento = Integer.parseInt(String.valueOf(MOVIMIENTO[pCero].charAt(i)));
            //respaldar el valor de la celda
            char valorCeldaMovimiento = aux[posicionMovimiento];

            //intercambiar valores
            aux[pCero] = valorCeldaMovimiento;
            aux[posicionMovimiento] =caracter;
            Nodo n = new Nodo(new String(aux));
            n.setPadre(this);

            //añadir el nodo a la lista

            listaSucesores.add(n);

        }
        return listaSucesores;
    }

    public String valorFormateado() {
        return this.valor.substring(0, 3) + "\n" +
                this.valor.substring(3, 6) + "\n" +
                this.valor.substring(6, 9) + "\n ---------------";
    }

}
