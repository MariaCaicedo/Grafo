
package grafos;

import javax.swing.JOptionPane;

public class Grafos {

	private static GrafoMatriz grafoMatriz = new GrafoMatriz();
	private static GrafoLista grafoLista = new GrafoLista();

	public static void main(String[] args) {
		int opcionSelecionadaDelMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
				"0.Salir" + "\n" + "1.Matriz" + "\n" + "2.Lista", "MENU", JOptionPane.DEFAULT_OPTION));
		if (opcionSelecionadaDelMenu == 1)
			menuGrafoMatriz();
		else if (opcionSelecionadaDelMenu == 2)
			menuGrafoLista();
		JOptionPane.showMessageDialog(null, "Que tenga buen dia", "Progama finalizado", JOptionPane.DEFAULT_OPTION);
	}

	private static void menuGrafoMatriz() {
		String menu = "0. Salir" + "\n" + "11. Mostrar" + "\n" + "22. Insertar" + "\n" + "33. Eliminar."
				+ " \n + 44. Buscar";
		char datoObtenido;
		while (true) {
			int opcionSelecionadaDelMenu = Integer
					.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.DEFAULT_OPTION));
			switch (opcionSelecionadaDelMenu) {
			case 0:
				return;
			case 11:
				grafoMatriz.dijkstra(0);
				break;
			case 22:
				String datoAInsertar = JOptionPane.showInputDialog(null, "Debe ingresar un solo caracter",
						"Ingrese Dato", JOptionPane.DEFAULT_OPTION);
				datoObtenido = datoAInsertar.charAt(0);
				grafoMatriz.insertar(datoObtenido);
				break;
			case 33:
				String datoAEliminar = JOptionPane.showInputDialog(null, "Debe ingresar el caracter a eliminar",
						"Eliminar Caracter", JOptionPane.DEFAULT_OPTION);
				datoObtenido = datoAEliminar.charAt(0);
				grafoMatriz.eliminar(datoObtenido);
				break;
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
			int opcionSelecionadaDelMenu = Integer
					.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.DEFAULT_OPTION));
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
}
