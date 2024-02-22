package com.company;

public class Main {
    final static String GOAL_STATE = "_12345678";
    final static String EASY = "1_2384765";
    final static String HARD = "1432_5786";
    final static String SUPER_EASY = "1_2345678";
    public static void main(String[] args) {


        EightPuzzle e = new EightPuzzle(new Nodo(HARD), GOAL_STATE);
     //   e.busquedaPorAnchura();
        e.busquedaPorProfundidad();
    }
}
