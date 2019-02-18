/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 * @author cristiandavid
 */

import jdk.nashorn.internal.scripts.JO;

import java.util.*;
import javax.swing.*;

public class Dijkstra {

    public int distancia[] = new int[10];
    public static int costo[][] = new int[10][10];

    public static void main(String[] args) {
        String salida;
        int c = 1;

        int nodos, origen, i, iterator;
        nodos = obtenerNumeroPorEntrada("Ingrese Datos", "Ingrese el numero de nodos");

        Dijkstra d = new Dijkstra();
        System.out.println("ingrese el costo de los pesos  de la matriz separados por espacios:  ");
        salida = "Nodos\t _1_\t_2_\t_3_\t_4_\t_5_\t_6_\t_7_\t_8_\n";
        for (i = 1; i <= nodos; i++) {
            salida += c++ + "\t|";
            for (iterator = 1; iterator <= nodos; iterator++) {
                d.costo[i][iterator] = obtenerNumeroPorEntrada("Ingrese Datos", String.format("Ingrese nodo [%d][%d]", i, iterator));
                salida += String.format(" %d \t", d.costo[i][iterator]);
            }
            salida += "\n";
        }
        showLongTextMessageInDialog(salida);

        origen = obtenerNumeroPorEntrada("Ingrese Datos", "Ingrese vertice de origen");

        d.calcularLaDistanciaMasCorta(nodos, origen);
        salida = "las distancias minimas\n";
        for (i = 1; i <= nodos; i++) {
            if (i != origen) {
                salida += String.format("la ruta mas corta desde el nodo %d al nodo %d es: %d \n", origen, i, d.distancia[i]);
            }
        }
        showLongTextMessageInDialog(salida);

        System.out.println("Matriz de costo");
        for (i = 1; i <= nodos; i++) {
            for (iterator = 1; iterator <= nodos; iterator++) {
                System.out.print(costo[i][iterator] + "\t");

            }
            System.out.println();
        }
    }

    public void calcularLaDistanciaMasCorta(int cantidadDeNodos, int origen) {
        int flag[] = new int[cantidadDeNodos + 1];
        int i, iterator, contador, minimo;
        int minpos = 1;

        for (i = 1; i <= cantidadDeNodos; i++) {
            flag[i] = 0;
            this.distancia[i] = this.costo[origen][i];
        }
        contador = 2;
        while (contador <= cantidadDeNodos) {
            minimo = 99;
            for (iterator = 1; iterator <= cantidadDeNodos; iterator++) {
                if (this.distancia[iterator] < minimo && flag[iterator] != 1) {
                    minimo = this.distancia[i];
                    minpos = iterator;
                }
            }
            flag[minpos] = 1;
            contador++;
            for (iterator = 1; iterator <= cantidadDeNodos; iterator++) {
                if (this.distancia[minpos] + this.costo[minpos][iterator] < this.distancia[iterator] && flag[iterator] != 1) {
                    this.distancia[iterator] = this.distancia[minpos] + this.costo[minpos][iterator];
                }
            }
        }
    }

    public static void showLongTextMessageInDialog(String longMessage) {
        JTextArea textArea = new JTextArea(9, 30);
        textArea.setText(longMessage);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }

    public static int obtenerNumeroPorEntrada(String titulo, String mensaje) {
        do {

            String option = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION);
            try {
                return Integer.parseInt(option);
            } catch (Exception e) {
                if ("null".equals(e.getMessage())) {
                    return 0;
                }
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero\n" + e.getMessage(), "Error", JOptionPane.ERROR);
            }
        } while (true);
    }
}
