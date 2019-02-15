/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author cristiandavid
 */

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Dijkstra {

    
    
    public int distancia[]=new int[10];
    public static int costo [][]=new int [10][10];
    
    
    
    //metodo que calculo la distancia mas corta 
    
    public void calc(int n,int origen){
        
        int flag[]=new int[n+1];
        int i,k,c ,minimo;
        int minpos=1;
        //llevamos al vector la distancia de la rpimera fila de la matiz
        for(i=1;i<=n;i++){
            flag[i]= 0;
            this.distancia[i] = this.costo[origen][i];//costo[1][1]=0
        }
        c=2;
        while(c<=n)
        {
            minimo=99;
            for(k=1;k<=n;k++){
                
                if(this.distancia[k]<minimo && flag[k]!=1){
                   
                    minimo=this.distancia[i];
                    minpos=k;
                    
                }   
            }
            flag[minpos]=1;
            c++;
            for(k=1;k<=n;k++)
            {      // distancia y costo se refieren a la distancia del objeto actual y la matriz de coste 
                if(this.distancia[minpos]+this.costo[minpos][k]<this.distancia[k] && flag[k]!=1){
                    
                    this.distancia[k]=this.distancia[minpos] + this.costo[minpos][k];
                }
            }
        }   
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
         JTextArea ventana= new JTextArea();
         String salida= "NODO\tA \tB  \tC  \tD\n";
         int c=1;
         
         int nodos,origen,i,j;
         Scanner in=new Scanner(System.in);
         System.out.println("ingrese el numero de nodos:  ");
         nodos=in.nextInt();
         
         Dijkstra d =new Dijkstra();
         System.out.println("ingrese el costo de los pesos  de la matriz separados por espacios:  ");
         
         //llenamos la matriz
         
         for(i=1;i <= nodos;i++){
             salida += c++ + "\t";
             for(j=1;j<=nodos;j++){
                 d.costo[i][j]= in.nextInt(); // alamecenamos cada peso fila por fila 
                 salida += d.costo[i][j] + "\t";
                 
             }
            salida += "\n";
         }
        ventana.setText(salida); // mostramos los datos de la primera matriz 
        JOptionPane.showMessageDialog(null, ventana);
        
        System.out.println("ingrese el verticwe de origen : ");
        origen=in.nextInt();
        
        d.calc(nodos,origen); //envismos el #de los nodos y el # de nodos de origen o punto de partida
        System.out.println("la ruta mas corta desde el nodo \t"+origen+"\t a todos los desde es : \n");
        
        for(i=1;i<=nodos;i++)
        {
            if(i!=origen){
                
                System.out.println("origen: "+ origen +"\t destino: "+ i +"\t costo minimo es: "+ d.distancia[i] + "\t");
            }
        }
        
        System.out.println("mostramos la matriz de costo");
        
        for(i=0;i<=nodos;i++){
                     
            for(j=0;j<=nodos;j++){
                System.out.println(costo[i][j]+"\t");
               
            }
            System.out.println("");
        }
        
        
    }
    
}
