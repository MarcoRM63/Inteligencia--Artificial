package com.company;

import java.util.Comparator;

public class Heuristica implements Comparator<Nodo> {

    @Override
    public int compare(Nodo x, Nodo y) {
        if (x.getCosto() < y.getCosto()) {
            return -1;
        }
        if (x.getCosto() > y.getCosto()) {
            return 1;
        }
        return 0;
    }
}
