package grafos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class Grafos {

    private static GrafoMatriz grafoMatriz = new GrafoMatriz();
    private static GrafoLista grafoLista = new GrafoLista();

    private static int origen;
    private static int destino;

    public static void main(String[] args) {
        int opcionSelecionadaDelMenu = obtenerEnteroPorPantalla("0.Salir" + "\n" + "1.Matriz" + "\n" + "2.Lista");
        int sizeGrafo = 0;
        if (opcionSelecionadaDelMenu == 1) {
            sizeGrafo = obtenerEnteroPorPantalla("Ingrese cantidad de nodos o vertices");
            grafoMatriz = new GrafoMatriz(sizeGrafo);
            menuGrafoMatriz();
        } else if (opcionSelecionadaDelMenu == 2) {
            sizeGrafo = obtenerEnteroPorPantalla("Ingrese cantidad de nodos o vertices");
            grafoLista = new GrafoLista(sizeGrafo);
            menuGrafoLista();
        }
        JOptionPane.showMessageDialog(null, "Que tenga buen dia", "Progama finalizado", JOptionPane.DEFAULT_OPTION);
    }

    private static void menuGrafoMatriz() {
        String menu = "0. Salir" + "\n" + "11. Mostrar Grafo" + "\n" + "22. Insertar" + "\n" + "33. Eliminar." + " \n"
                + "44. Distancia minima entre nodos" + " \n" + "99. Volver";
        int datoObtenido;
        while (true) {
            int opcionSelecionadaDelMenu = obtenerEnteroPorPantalla(menu);
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    int[][] matriz = grafoMatriz.getMatriz();
                    String mostrarMatriz = "";
                    for (int iterator = 0; iterator < grafoMatriz.getSize(); iterator++) {
                        for (int j = 0; j < grafoMatriz.getSize(); j++) {
                            mostrarMatriz += Integer.toString(matriz[iterator][j]) + " \t";
                        }
                        mostrarMatriz += "\n";
                    }
                    JOptionPane.showMessageDialog(null, mostrarMatriz, "Grafo", JOptionPane.DEFAULT_OPTION);
                    break;
                case 22:
                    origen = obtenerEnteroPorPantalla("Ingrese el nodo origen");
                    destino = obtenerEnteroPorPantalla("ingrese el nodo destino");
                    int peso = obtenerEnteroPorPantalla("ingrese el peso de la arista");
                    boolean inserto = grafoMatriz.insertar(origen, destino, peso);
                    if (inserto) {
                        JOptionPane.showMessageDialog(null, "Arista con peso " + peso + " Entre los nodos " + origen + " " + destino + " Insertada Correctamente.", "Insertado",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Arista con peso " + peso + " Entre los nodos " + origen + " " + destino + " No insertada.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar",
                            "Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar.charAt(0);
                    grafoMatriz.eliminar(datoObtenido);
                    break;
                case 44:
                    origen = obtenerEnteroPorPantalla("Ingrese el nodo origen");
                    destino = obtenerEnteroPorPantalla("ingrese el nodo destino");
                    int distanciaMinima = grafoMatriz.getDistanciaMinima(origen, destino);
                    JOptionPane.showMessageDialog(null, "La distancia minima entre los nodos "
                            + origen + " y " + destino
                            + " es " + distanciaMinima,
                            "La Distancia Minima es", JOptionPane.DEFAULT_OPTION
                    );
                    break;
                case 55:
                    origen = obtenerEnteroPorPantalla("Ingrese el nodo origen");
                    Optional<List> ruta = grafoMatriz.caminoMinimoEntreDosVertices(origen, 0);
                    JOptionPane.showMessageDialog(null, Arrays.deepToString(ruta.get().toArray()), "ruta", JOptionPane.DEFAULT_OPTION);
                    break;
                case 99:
                    System.out.println("se borraron valores ingresados");
                    main(new String[0]);
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo",
                            JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    private static void menuGrafoLista() {
        String menu = "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar" + "\n" + "33. Eliminar."
                + " \n + 44. Buscar";
        char datoObtenido;
        while (true) {
            int opcionSelecionadaDelMenu = obtenerEnteroPorPantalla(menu);
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    grafoLista.dijkstra(0);
                    break;
                case 22:
                    String datoAInsertar = JOptionPane.showInputDialog(null, "Debe ingresar un solo caracter",
                            "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAInsertar.charAt(0);
                    grafoLista.insertar(datoObtenido);
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar",
                            "Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar.charAt(0);
                    grafoLista.eliminar(datoObtenido);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo",
                            JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    private static int obtenerEnteroPorPantalla(String message) {
        int dato = 0;
        while (true) {
            try {
                dato = Integer.parseInt(
                        JOptionPane.showInputDialog(null, message, "Ingrese un Numero", JOptionPane.DEFAULT_OPTION));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracter " + message + " no Valido", e.getMessage(),
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return dato;
    }
}
