package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
public class Main {
    public static void main(String[] args) throws Exception {
        String filename = "riegoDifuso.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }


        FunctionBlock fb = fis.getFunctionBlock(null);

        // Entradas
        System.out.print("Introduce la temperatura en grados centigrados:");
        double temp = Keyboard.readDouble();
        System.out.print("Introduce la humedad en el ambiente:");
        double hum = Keyboard.readDouble();
        System.out.print("Introduce la frecuencia de dias de riego que necesita la planta:");
        double dt = Keyboard.readDouble();
        fb.setVariable("temp", temp);
        fb.setVariable("hum", hum);
        fb.setVariable("dt", dt);
        // Evaluar
        fb.evaluate();


        fb.getVariable("cantRiego").defuzzify();


        System.out.println(fb);
        System.out.println("cantRiego: " + fb.getVariable("cantRiego").getValue());
        JFuzzyChart.get().chart(fb);
    }
}