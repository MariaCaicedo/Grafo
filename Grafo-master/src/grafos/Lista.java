/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ASUS
 */
public class Lista {
 private int numeroDeNodos;
 private ArrayList<ArrayList<Integer>> lista;
 
    public void Lista (int numeroDeNodos) {
       this.numeroDeNodos = numeroDeNodos;
       this.lista = new ArrayList<>();
       for (int i=0; i<numeroDeNodos; i++) {
          lista.add(i,new ArrayList<>());
       }
    }
    
   public void insertarArista(int nodoA, int nodoB) {
     lista.get(nodoA).add(nodoB);
    }
   
   public void eliminarArista(int nodoA, int nodoB) {
    Iterator<Integer> it = lista.get(nodoA).iterator();
    while (it.hasNext()) {
       if(it.next() == nodoB) {
          it.remove();
          break;
        }
        }
    }
   
   public boolean esAdyacente(int nodoA, int nodoB) {
    return lista.get(nodoA).contains(nodoB);
    }
   
   public ArrayList<Integer> listaAdyacentet(int nodo) {
    return lista.get(nodo);
    }
   
   public void insertarNodo() {
    numeroDeNodos ++;
    lista.add(new ArrayList<>());
    }
   
   public void eliminarNodo(int nodo) {
    numeroDeNodos--;
    lista.add(nodo, new ArrayList<>());
    for (int i=0; i<lista.size(); i++) {
       Iterator<Integer> it2 = lista.get(i).iterator();
       while (it2.hasNext()) {
       if(it2.next() == nodo) {
          it2.remove();
        }
        }
        }
    }
}

