/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import javax.swing.JOptionPane;

/**
 *
 * @author sala203
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Dijkstra Grafo;
        Grafo = new Dijkstra();
        String menu = "**MENU**" + "\n" + "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar" + "\n" + "33. Eliminar." + " \n + 44. Buscar";
        char datoObtenido;
        while (true) {
            int opcionSelecionadaDelMenu = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.DEFAULT_OPTION));
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    System.out.println("Estos son los datos del arbol: ");
                    Grafo.mostrar(Graf.retornarRaiz());
                    System.out.println("Ya estan todos los datos.");
                    break;
                case 22:
                    String datoAInsertar = JOptionPane.showInputDialog(null, "Debe ingresar un solo caracter", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAInsertar.charAt(0);
                    Grafo.InsertarNodo();
                    System.out.println("Dato Insertado");
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar", "Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar.charAt(0);
                    Grafo.eliminarNodo(datoObtenido);
                    System.out.println("Dato Eliminado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);

            }
        }
   
    }    
}
