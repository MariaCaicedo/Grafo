package grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GrafoMatriz {

    public static final int MAX_VALUE = 9999;
    private static final String NO_SE_PUEDE_ACCEDER_AL_NODO = "No se puede acceder al nodo ";
    private int size;
    private int matriz[][];
    private int origen;
    private int distanciaMinima[];
    private int verticesVisitados[];
    private List<Integer> ruta;

    public GrafoMatriz() {
        this.size = 0;
        matriz = new int[size][size];
    }

    public GrafoMatriz(int size) {
        if (2 < size) {
            this.size = size;
            matriz = new int[size][size];
            initMatriz();
            origen = -1;
        } else {
            this.size = 0;
            matriz = new int[this.size][this.size];
            System.err.println("No se puede crear con menos de 2 vertices, Valor ingresado: " + size);
        }
    }

    private void initMatriz() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = this.MAX_VALUE;
                }
            }
        }
    }

    public boolean insertar(int origen, int destino, int peso) {
        if (peso > 0 && peso < this.MAX_VALUE) {
            try {
                matriz[origen][destino] = peso;
                matriz[destino][origen] = peso;
                return true;
            } catch (Exception e) {
                System.err.println(NO_SE_PUEDE_ACCEDER_AL_NODO + e.getMessage());
            }
        } else {
            System.err.println("No se puede colocar un peso superior a 0. ingresado:" + peso);
        }
        return false;
    }

    public Optional<List> caminoMinimoEntreDosVertices(int origen, int destino) {
        if (origen >= 0 && (destino < this.size && destino != origen)) {
            validateAndCalculateDijkstra(origen);
            return obtenerCamino(destino);
        }
        System.err.println("no se puede calcular un camino de un vertice inexistente; valide que el origen " + origen
                + " y/o que el destino " + destino + " existen en el grafo.");
        return Optional.empty();
    }

    private void validateAndCalculateDijkstra(int origen) {
        if (this.origen == -1 || this.origen != origen) {
            this.origen = origen;
            dijkstra();
        }
    }

    private void dijkstra() {
        inicializarVaribalesParaDistanciaMinima();
        verticesVisitados[this.origen] = 1;
        for (int k = 0; k < this.size; k++) {
            int nodoConMinimoPeso = obtenerVerticeConMenorPesoYsinVisitar();
            verticesVisitados[nodoConMinimoPeso] = 1;
            for (int iterator = 0; iterator < this.size; iterator++) {
                if (verticesVisitados[iterator] == 0) {
                    int paso = distanciaMinima[nodoConMinimoPeso] + matriz[nodoConMinimoPeso][iterator];
                    if (paso < distanciaMinima[iterator] && paso != 0) {
                        distanciaMinima[iterator] = paso;
                        ruta.add(nodoConMinimoPeso);
                    }
                }
            }
        }
    }

    private void inicializarVaribalesParaDistanciaMinima() {
        distanciaMinima = new int[this.size];
        verticesVisitados = new int[this.size];
        ruta = new ArrayList<>();
        ruta.add(this.origen);
        for (int iterator = 0; iterator < this.size; iterator++) {
            distanciaMinima[iterator] = matriz[iterator][this.origen];
        }
    }

    private int obtenerVerticeConMenorPesoYsinVisitar() {
        int maximoPeso = this.MAX_VALUE;
        int nodo = 0;
        for (int iterator = 0; iterator < this.size; iterator++) {
            if (verticesVisitados[iterator] == 0 && distanciaMinima[iterator] < maximoPeso) {
                maximoPeso = distanciaMinima[iterator];
                nodo = iterator;
            }
        }
        return nodo;
    }

    private Optional<List> obtenerCamino(int destino) {
        if (!ruta.isEmpty()) {
            ruta.add(destino);
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

    int[][] getMatriz() {
        int matrizAMostrar[][] = this.matriz;
        for (int iterator = 0; iterator < this.size; iterator++) {
            for (int j = 0; j < this.size; j++) {
                if (this.matriz[iterator][j] == this.MAX_VALUE) {
                    matrizAMostrar[iterator][j] = -1;
                }
            }
        }
        return matrizAMostrar;
    }

    int getDistanciaMinima(int origen, int destino) {
        if(destino < this.size && origen >= 0){
            validateAndCalculateDijkstra(origen);
            return distanciaMinima[destino];
        }else{
          System.err.println(NO_SE_PUEDE_ACCEDER_AL_NODO + 0);
        }
        return 0;
    }
}
