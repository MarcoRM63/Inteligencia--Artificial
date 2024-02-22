package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EightPuzzle {
    final String ESTADO_OBJETIVO;
    private Nodo inicial;
    ReporteJuego r;

    public EightPuzzle(Nodo n, String ESTADO_OBJETIVO) {
        this.inicial = n;
        this.ESTADO_OBJETIVO = ESTADO_OBJETIVO;
    }

    public void busquedaPorAnchura() {
        double tiempoInicial;
        int numNodosAnalizados = 0;
        if (inicial.getValor().equals(ESTADO_OBJETIVO)) {
            ReporteJuego.imprimirReporte(inicial, inicial, ESTADO_OBJETIVO, new ArrayList<String>(), 0, 1, 0, "Busqueda por anchura");
        } else {

            Nodo actual = null;
            tiempoInicial = System.currentTimeMillis();
            ArrayList<String> visitados = new ArrayList<String>();//arraylist de nodos visitados
            Queue<Nodo> cola = new LinkedList<>();
            cola.add(inicial);
            visitados.add(inicial.getValor());
            while (!cola.isEmpty()) {
                actual = cola.poll();
                numNodosAnalizados++;
               // System.out.println(actual.getValor());
                if (actual.getValor().equals(ESTADO_OBJETIVO)) {
                    break;
                }
                ArrayList<Nodo> hijos = actual.getSucesores(); //obtener sucesores del nodo
                for (Nodo h : hijos) {
                    if (!visitados.contains(h.getValor())) {
                        cola.add(h);
                        visitados.add(h.getValor());
                    }
                }
            }
            double tiempoFinal = System.currentTimeMillis();
            double duracion = (tiempoFinal - tiempoInicial);
            ReporteJuego.imprimirReporte(inicial, actual, ESTADO_OBJETIVO, visitados, cola.size(), numNodosAnalizados, duracion, "Busqueda por anchura");
        }
    }


    public void busquedaPorProfundidad() {
        double tiempoInicial;
        int numNodosAnalizados = 0;
        //verificar si el nodo incial ya es el estado objetivo
        if (inicial.getValor().equals(ESTADO_OBJETIVO)) {
            ReporteJuego.imprimirReporte(inicial, inicial, ESTADO_OBJETIVO, new ArrayList<String>(), 0, 1, 0, "Busqueda por profundidad");
        } else {

            Nodo actual = null;
            tiempoInicial = System.currentTimeMillis();
            ArrayList<String> visitados = new ArrayList<String>();//arraylist de nodos visitados
            Stack<Nodo> pila = new Stack<>();
            pila.push(inicial); //añadir a la cola y a la lista de visitados el nodo inicial
            visitados.add(inicial.getValor());

            while (!pila.isEmpty()) {
                actual = pila.pop(); //sacar el nodo actual de la cola
                numNodosAnalizados++;
               // System.out.println(actual.valorFormateado());
                if (actual.getValor().equals(ESTADO_OBJETIVO)) {
                    break;
                }
                ArrayList<Nodo> hijos = actual.getSucesores(); //obtener sucesores del nodo
                for (Nodo h : hijos) {
                    if (!visitados.contains(h.getValor())) {
                        pila.push(h);
                        visitados.add(h.getValor());
                    }
                }
            }
            double tiempoFinal = System.currentTimeMillis();
            double duracion = (tiempoFinal - tiempoInicial);
            ReporteJuego.imprimirReporte(inicial, actual, ESTADO_OBJETIVO, visitados, pila.size(), numNodosAnalizados, duracion, "Busqueda por profundidad");
        }

    }

}
