/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 * @author cristiandavid
 */

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Dijkstra {

    public int distancia[] = new int[10];
    public static int costo[][] = new int[10][10];

    public void calcularLaDistanciaMasCorta(int cantidadDeNodos, int origen) {
        int flag[] = new int[cantidadDeNodos + 1];
        int i, iterator, contador, minimo;
        int minpos = 1;

        for (i = 1; i <= cantidadDeNodos; i++) {
            flag[i] = 0;
            this.distancia[i] = this.costo[origen][i];//costo[1][1]=0
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
            for (iterator = 1; iterator <= cantidadDeNodos; iterator++) {      // distancia y costo se refieren a la distancia del objeto actual y la matriz de coste
                if (this.distancia[minpos] + this.costo[minpos][iterator] < this.distancia[iterator] && flag[iterator] != 1) {

                    this.distancia[iterator] = this.distancia[minpos] + this.costo[minpos][iterator];
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JTextArea ventana = new JTextArea();
        String salida = "NODO\t1 \t2  \t3  \t4 \t5 \n";
        int c = 1;

        int nodos, origen, i, iterator;
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese el numero de nodos:  ");
        nodos = in.nextInt();

        Dijkstra d = new Dijkstra();
        System.out.println("ingrese el costo de los pesos  de la matriz separados por espacios:  ");

        for (i = 1; i <= nodos; i++) {
            salida += c++ + "\t";
            for (iterator = 1; iterator <= nodos; iterator++) {
                d.costo[i][iterator] = in.nextInt();
                salida += d.costo[i][iterator] + "\t";

            }
            salida += "\n";
        }
        ventana.setText(salida);
        JOptionPane.showMessageDialog(null, ventana);

        System.out.println("ingrese el verticwe de origen : ");
        origen = in.nextInt();

        d.calcularLaDistanciaMasCorta(nodos, origen);
        System.out.println("la ruta mas corta desde el nodo \t" + origen + "\t a todos los desde es : \n");

        for (i = 1; i <= nodos; i++) {
            if (i != origen) {

                System.out.println("origen: " + origen + "\t destino: " + i + "\t costo minimo es: " + d.distancia[i] + "\t");
            }
        }

        System.out.println("mostramos la matriz de costo");

        for (i = 0; i <= nodos; i++) {

            for (iterator = 0; iterator <= nodos; iterator++) {
                System.out.println(costo[i][iterator] + "\t");

            }
            System.out.println("");
        }
    }

}
