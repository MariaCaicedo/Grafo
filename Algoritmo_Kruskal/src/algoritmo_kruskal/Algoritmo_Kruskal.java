
package algoritmo_kruskal;

import java.util.Scanner;


public class Algoritmo_Kruskal {


    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);//Leer lo que se ingresa por teclado
                
                Scanner entrada=new Scanner(System.in);
                int nodos=0;
                System.out.println(" ingrese el numero de nodos");
                nodos=entrada.nextInt();
                
                
                
		int[][] matriz = new int[nodos][nodos];
		int[] parent = new int[nodos];
		int min;
		int u = 0; 
		int v = 0;
		int noOfEdges = 1;
		int total = 0;
		//Recibiendo Parametro de la matriz de 5x5
		for(int i = 0; i < nodos; i++)
                {
			
			parent[i] = 0;
			//Para recibir todos los parametros de la matriz
			for(int j = 0; j < nodos; j++)
                        {
                                System.out.println("Ingrese valor: ["+i+"] ["+j+"]");
				matriz[i][j] = scan.nextInt();
				if(matriz[i][j]==0){
					matriz[i][j] = 999;
				}
				
			}
			
		}
		
		while(noOfEdges < nodos){
			
			min = 999;
			
			for(int i = 0; i < nodos; i++)
                        {
				
				for(int j = 0; j < nodos; j++){
					
					if(matriz[i][j] < min){
						
						min = matriz[i][j];
						u = i;
						v = j;
						
					}
					
				}
				
			}
			//*Chequeamos si se hace un loop o no
			while(parent[u]!=0)
                        {
				u = parent[u];
			}
			
			while(parent[v]!=0)
                        {
				v = parent[v];
			}

                       //*
                       
                       //Imprimiendo las rutas para crear el arborl de expansión mínimo
			if(v!=u) //Si v = u significa que existe un loop pero sino significa que no hay loop
                        {
				
				noOfEdges++;
				System.out.println("Vertice encontrado: " + u + "->" + v+" Min : " + min);// Vertice encontrado desde u a v + Peso
				total+=min;
				parent[v] = u;
				
			}
			
			matriz[u][v] = 999;
			matriz[v][u] = 999;
			
		}
		
		System.out.println("El peso del árbol de expansión mínimo es "+total);
    }
    
}
