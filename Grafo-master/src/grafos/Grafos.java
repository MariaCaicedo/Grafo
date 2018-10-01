
package grafos;

import javax.swing.JOptionPane;

public class Grafos {

	private static Grafo grafo =new Grafo();
	
    public static void main(String[] args) {
        String menu = "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar" + "\n" + "33. Eliminar." + " \n + 44. Buscar";
        char datoObtenido;
        while (true) {
            int opcionSelecionadaDelMenu = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.DEFAULT_OPTION));
            switch (opcionSelecionadaDelMenu) {
                case 0:
                    return;
                case 11:
                    grafo.dijkstra(0);
                    break;
                case 22:
                    String datoAInsertar = JOptionPane.showInputDialog(null, "Debe ingresar un solo caracter", "Ingrese Dato", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAInsertar.charAt(0);
                    grafo.insertar(datoObtenido);
                    break;
                case 33:
                    String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar", "Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
                    datoObtenido = datoAEliminar.charAt(0);
                    grafo.eliminar(datoObtenido);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Intente de nuevo", JOptionPane.WARNING_MESSAGE);

            }
        }
   
    }    
}
