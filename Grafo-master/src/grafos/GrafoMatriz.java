
package grafos;

public class GrafoMatriz {

	private int size;
	private int matriz[][];

	public GrafoMatriz() {
		this.size = 0;
		matriz = new int[size][size];
	}

	public GrafoMatriz(int size) {
		if (0 < size) {
			this.size = size;
			matriz = new int[size][size];
			initMatriz();
		} else {
			this.size = 0;
			matriz = new int[this.size][this.size];
			System.err.println("No se puede crear un grafo sin Nodos, Valor ingresado: " + size);
		}
	}

	private void initMatriz() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matriz[i][j] = 0;
			}
		}
	}

	public void insertar(int origen, int destino, int peso) {
		if (peso > 0) {
			try {
				matriz[origen][destino] = peso;
			} catch (Exception e) {
				System.err.println("No se puede acceder al nodo " + e.getMessage());
			}
		} else {
			System.err.println("No se puede colocar un peso negativo o sin valor. " + peso);
		}
	}

	public void dijkstra(int i) {
		// TODO Auto-generated method stub

	}

	public void eliminar(int nodo) {
		try {
			matriz[nodo][nodo] = 0;
		} catch (Exception e) {
			System.err.println("No se puede acceder al nodo " + e.getMessage());
		}

	}

	public int getPeso(int origen, int destino) {
		try {
			return matriz[origen][destino];
		} catch (Exception e) {
			System.err.println("No se puede acceder al nodo " + e.getMessage());
			return -1;
		}
	}

	public int getSize() {
		return size;
	}

}
