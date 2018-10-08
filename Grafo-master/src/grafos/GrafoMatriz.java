
package grafos;

import java.util.Optional;

public class GrafoMatriz {

	private static final String NO_SE_PUEDE_ACCEDER_AL_NODO = "No se puede acceder al nodo ";
	private int size;
	private int matriz[][];
	private int origen;
	private int distanciaMinima[];
	private int verticesVisitados[];
	private int ruta[];

	public GrafoMatriz() {
		this.size = 0;
		matriz = new int[size][size];
	}

	public GrafoMatriz(int size) {
		if (0 < size) {
			this.size = size;
			matriz = new int[size][size];
			initMatriz();
			origen = -1;
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

	public boolean insertar(int origen, int destino, int peso) {
		if (peso >= 0) {
			try {
				matriz[origen][destino] = peso;
				return true;
			} catch (Exception e) {
				System.err.println(NO_SE_PUEDE_ACCEDER_AL_NODO + e.getMessage());
			}
		} else {
			System.err.println("No se puede colocar un peso negativo o sin valor. " + peso);
		}
		return false;
	}

	public Optional<int[]> caminoMinimoentredosVertices(int origen, int destino) {
		if (origen <= 0 || (destino < this.size && destino > 0)) {
			if (this.origen == -1 || this.origen != origen) {
				this.origen = origen;
				dijkstra();
			}
			return obtenerCamino(destino);
		}
		System.err.println("no se puede calcular un camino de un vertice inexistente; valide que el origen " + origen
				+ " y/o que el destino " + destino + " existen en el grafo.");
		return Optional.empty();
	}

	private void dijkstra() {
		inicializarVaribalesParaDistanciaMinima();

		for (int k = 0; k < this.size; k++) {
			int w = obtenerVerticeConMenorPesoYsinVisitar();
			verticesVisitados[w] = 1;
			for (int j = 0; j < this.size; j++) {
				int paso = 0;
				if (verticesVisitados[j] == 0) {
					paso = distanciaMinima[w] + matriz[w][j];
					if (paso < distanciaMinima[j]) {
						distanciaMinima[j] = paso;
						ruta[j] = w;
					}
				}
			}
		}
	}

	private void inicializarVaribalesParaDistanciaMinima() {
		distanciaMinima = new int[this.size];
		verticesVisitados = new int[this.size];
		ruta = new int[this.size];

		for (int k = 0; k < this.size; k++) {
			distanciaMinima[k] = matriz[this.origen][k];
			verticesVisitados[k] = 0;
			ruta[k] = 0;
		}
	}

	private int obtenerVerticeConMenorPesoYsinVisitar() {
		// TODO Auto-generated method stub
		return 0;
	}

	private Optional<int[]> obtenerCamino(int destino) {
		if (ruta.length > 0 && ruta[1] != 0) {
			return Optional.of(ruta);
		}
		return Optional.empty();
	}

	public void eliminar(int nodo) {
		try {
			matriz[nodo][nodo] = 0;
		} catch (Exception e) {
			System.err.println(NO_SE_PUEDE_ACCEDER_AL_NODO + e.getMessage());
		}
	}

	public int getPeso(int origen, int destino) {
		try {
			return matriz[origen][destino];
		} catch (Exception e) {
			System.err.println(NO_SE_PUEDE_ACCEDER_AL_NODO + e.getMessage());
			return -1;
		}
	}

	public int getSize() {
		return size;
	}

}
