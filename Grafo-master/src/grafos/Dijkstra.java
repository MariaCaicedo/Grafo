/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import javafx.scene.Node;

/**
 *
 * @author ASUS
 */
public class Dijkstra {
    static final int MAX = 10005;  
    static final int INF = 1<<30; 

    private static void insertar(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Dijkstra() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    static class Nodo implements Comparable<Nodo>{
        int first, second;
        Nodo( int d , int p ){                        
            this.first = d;
            this.second = p;
        }
        public int compare( Nodo otro){              
            if( second > otro.second ) return 1;
            if( second == otro.second ) return 0;
            return -1;
        }

        @Override
        public int compareTo(Nodo o) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    };
    
   /* static Scanner sc = () -> {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }; */
    static ArrayList< List< Nodo > > ady = new ArrayList< List< Nodo > >(); 
    static int distancia[ ] = new int[ MAX ];          
    static boolean visitado[ ] = new boolean[ MAX ];   
    static PriorityQueue< Node > Q = new PriorityQueue<Node>(); 
    static int V;                                      
    static int previo[] = new int[ MAX ];              
    
    static void init(){
        for( int i = 0 ; i <= V ; ++i ){
            distancia[ i ] = INF;  
            visitado[ i ] = false; 
            previo[ i ] = -1;      
        }
    }

    static void relajacion( int actual , int adyacente , int peso ){
        if( distancia[ actual ] + peso < distancia[ adyacente ] ){
            distancia[ adyacente ] = distancia[ actual ] + peso;  
            previo[ adyacente ] = actual;                          
            insertar( new Nodo( adyacente , distancia[ adyacente ] ) ); 
        }
    }

    static void print( int destino ){
        if( previo[ destino ] != -1 )    
            print( previo[ destino ] ); 
        System.out.printf("%d " , destino );      
    }
    
    static void dijkstra( int inicial ){
        insertar( new Nodo( inicial , 0 ) ); 
        distancia[ inicial ] = 0;      
        int actual = 0 , adyacente , peso;
        while( !Q.isEmpty() ){                   
            //actual = Q.element().first;            
            Q.remove();                          
            if( visitado[ actual ] ) continue; 
            visitado[ actual ] = true;         
            for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ 
                adyacente = ady.get( actual ).get( i ).first;   
                peso = ady.get( actual ).get( i ).second;       
                if( !visitado[ adyacente ] ){       
                    relajacion( actual , adyacente , peso ); 
                }
            }
        }
        System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );
        for( int i = 1 ; i <= V ; ++i ){
            System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[ i ] );
        }

        System.out.println("\n**************Impresion de camino mas corto**************");
        System.out.printf("Ingrese vertice destino: ");
        int destino = 0;
        print( destino );
        System.out.printf("\n");
    }
    
    int numeroDeNodos;
    boolean[][] matriz;
        Dijkstra(int numeroDeNodos){
        this.numeroDeNodos=numeroDeNodos;
        matriz=new boolean[numeroDeNodos][numeroDeNodos];
    }

    public void insertarArista(int nodoA, int nodoB){
        matriz [nodoA][nodoB] = true;
    }
    
    public void eliminarArista(int nodoA, int nodoB) {
        matriz[nodoA][nodoB] = false;
    }
    
    public boolean esAdyacente(int nodoA, int nodoB) {
        return matriz[nodoA][nodoB];
    }

    public ArrayList<Integer> adyacentesList(int nodo) {
        ArrayList<Integer> nodos = new ArrayList<>();
        for (int j = 0; j < numeroDeNodos; j++) 
            if (matriz[nodo][j]) nodos.add(j);
        return nodos;
    }
    
    public void InsertarNodo() {
    numeroDeNodos++;
    boolean [][] auxiliar = new boolean [numeroDeNodos][numeroDeNodos];
    for(int i=0; i<numeroDeNodos-1; i++) {
       auxiliar[i] = Arrays.copyOf(matriz[i], numeroDeNodos);
    }
    matriz = auxiliar;
    }
    
    public void eliminarNodo(int nodo) {
    if (nodo > numeroDeNodos || nodo < 0) {
       System.out.println("El seleccionado no existe.");
    } else {
       for (int i=1; i<matriz.length; i++) {
          matriz [nodo][i] = false;
       }
       for (int i=1; i<matriz.length; i++) {
          matriz [i][nodo] = false;
       }
    }
 }
    
}
