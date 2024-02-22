package com.company;

import java.util.ArrayList;

public class ReporteJuego {


    static void imprimirReporte(Nodo inicial, Nodo ultimo, String estadoObjetivo, ArrayList<String>visitados,int restantes,int analizados, double tiempoEjecucion, String metodoBusqueda) {
        System.out.println("*************************************Reporte Final***************************************");
    for (int i = 0; i <visitados.size() ; i++) {

            System.out.println("******* Estado numero: "+(i+1)+"");
            System.out.println("* " + visitados.get(i).substring(0, 3)+" *");
            System.out.println("* " + visitados.get(i).substring(3, 6)+" *");
            System.out.println("* " + visitados.get(i).substring(6, 9)+" *");
            System.out.println("*******");
        }
        System.out.println("*****************************************************************+");
        System.out.println("Estado inicial:"+ inicial.getValor());
        System.out.println("Estado objetivo:" +estadoObjetivo);
        System.out.println("Ultimo estado:"+ultimo.getValor());
        System.out.println("Tiempo de ejecución (milisegundos):" + tiempoEjecucion);
        System.out.println("Numero de estados visitados:"+ visitados.size());
        System.out.println("Numero de estados sacados de la estructura:"+ analizados);
        System.out.println("Numero de estados restantes por analizar:"+ restantes);
        System.out.println("Tipo de busqueda utilizado:"+ metodoBusqueda);

    }

}


