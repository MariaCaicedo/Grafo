package grafos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GrafoMatrizTest {
	GrafoMatriz grafo;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void inti() {
		grafo = new GrafoMatriz();
	}

	@Test
	public void noPermiteInsertarDatosEnGrafoVacio() {
		grafo.insertar(1, 2, 2);
		
		int peso = grafo.getPeso(1, 2);
		
		assertEquals("se esperaba que retornara -1 al no acceder a la posicion en la matriz", -1, peso);
	}

	@Test
	public void debeCostruirUnGrafoCorrectamente() {
		grafo = new GrafoMatriz(1);
		
		int size = grafo.getSize();
		int peso = grafo.getPeso(0, 0);

		assertEquals("se esperaba que la maxima candidad de nodos sea 1", 1, size);
		assertEquals("se esperaba que el peso por defecto de cada arista sea 0", 0, peso);
	}

	@Test
	public void noDebeConstruirUnGrafo() {
		grafo = new GrafoMatriz(-1);
		
		int size = grafo.getSize();
		
		assertEquals("se esperaba que no hayan nodos", 0, size);
	}
}
