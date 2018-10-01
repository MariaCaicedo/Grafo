
package grafos;

public class GrafoMatriz {

	private int size;
	private int matriz[][];

	public GrafoMatriz() {
		super();
		this.size = 0;
		matriz = new int[size][size];
	}

	public GrafoMatriz(int size) {
		this.size = size;
		matriz = new int[size][size];
	}

	public void insertar(int nodo, int peso) {
		matriz[nodo][nodo] = peso;
	}

	public void dijkstra(int i) {
		// TODO Auto-generated method stub

	}

	public void eliminar(int nodo) {
		matriz[nodo][nodo] = 0;

	}

}
