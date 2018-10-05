package grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GrafoMatrizTest {
	GrafoMatriz grafo;

	@Before
	public void inti() {
		grafo = new GrafoMatriz();
	}

	@Test
	public void debeCostruirUnGrafoCorrectamenteConUnValorDeAristasSuperiorACero() {
		grafo = new GrafoMatriz(1);

		int size = grafo.getSize();
		int peso = grafo.getPeso(0, 0);

		assertEquals("se esperaba que la maxima candidad de nodos sea 1", 1, size);
		assertEquals("se esperaba que el peso por defecto de cada arista sea 0", 0, peso);
	}

	@Test
	public void noDebeConstruirUnGrafoConUnvalorNegativoDeAristas() {
		grafo = new GrafoMatriz(-1);

		int size = grafo.getSize();

		assertEquals("se esperaba que no hayan nodos", 0, size);
	}

	@Test
	public void noPermiteInsertarDatosEnGrafoSinVertices() {
		boolean insertado = grafo.insertar(1, 2, 2);
		int peso = grafo.getPeso(1, 2);

		assertFalse("se esperaba no inserte la arista", insertado);
		assertEquals("se esperaba que retornara -1 al no acceder a la posicion en la matriz", -1, peso);
	}

	@Test
	public void noPermiteInsertarPesoConOrigenInexistente() {
		grafo = new GrafoMatriz(2);

		boolean insertado = grafo.insertar(-1, 1, 1);
		int peso = grafo.getPeso(-1, 1);

		assertFalse("se esperaba no inserte la arista", insertado);
		assertEquals("se esperaba que retornara -1 al no acceder a la posicion en la matriz", -1, peso);
	}

	@Test
	public void noPermiteInsertarPesoConDestinoInexistente() {
		grafo = new GrafoMatriz(2);

		boolean insertado = grafo.insertar(0, 2, 1);
		int peso = grafo.getPeso(0, 2);

		assertFalse("se esperaba no inserte la arista", insertado);
		assertEquals("se esperaba que retornara -1 al no acceder a la posicion en la matriz", -1, peso);
	}

	@Test
	public void noDebePermitirInsertarUnPesoInferiorA0() {
		grafo = new GrafoMatriz(2);

		boolean insertado = grafo.insertar(0, 1, -3);
		int peso = grafo.getPeso(0, 1);

		assertFalse("se esperaba no inserte la arista", insertado);
		assertEquals("se esperaba que retornara 0 al no modificar el peso", 0, peso);

	}

	@Test
	public void debePermitirInsertarPeso0() {
		grafo = new GrafoMatriz(2);

		boolean insertado = grafo.insertar(0, 1, 0);
		int peso = grafo.getPeso(0, 1);

		assertTrue("se esperaba inserte la arista", insertado);
		assertEquals("se esperaba que retornara 0 al no haber camino entre las aristas", 0, peso);

	}

	@Test
	public void debePermitirInsertarUnPesoSuperiorA0() {
		grafo = new GrafoMatriz(2);

		boolean insertado = grafo.insertar(0, 1, 8);
		int peso = grafo.getPeso(0, 1);

		assertTrue("se esperaba inserte la arista", insertado);
		assertEquals("se esperaba que existiera camino de peso 8 entre las aristas", 8, peso);

	}
}
