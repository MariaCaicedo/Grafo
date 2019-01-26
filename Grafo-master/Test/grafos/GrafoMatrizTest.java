package grafos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GrafoMatrizTest {
    GrafoMatriz grafo;

    @Before
    public void inti() {
        grafo = new GrafoMatriz();
    }

    @Test
    public void debeCostruirUnGrafoCorrectamenteConUnValorDeAristasSuperiorADos() {
        grafo = new GrafoMatriz(3);

        int size = grafo.getSize();
        int pesoMismoVertice = grafo.getPeso(0, 0);
        int pesoDefecto = grafo.getPeso(0, 1);

        assertEquals("se esperaba que la maxima candidad de nodos sean 3", 3, size);
        assertEquals("se esperaba que el peso para el mismo vetice sea 0", 0, pesoMismoVertice);
        assertEquals("se esperaba que el peso por defecto entre aristas sea el maximo entero", Integer.MAX_VALUE, pesoDefecto);
    }

    @Test
    public void noDebeConstruirUnGrafoConUnvalorNegativoDeAristas() {
        grafo = new GrafoMatriz(-1);

        int size = grafo.getSize();

        assertEquals("se esperaba que no hayan nodos", 0, size);
    }

    @Test
    public void nodebeConstruirUnGrafoCon2Vertices() {
        grafo = new GrafoMatriz(2);

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
        grafo = new GrafoMatriz(3);

        boolean insertado = grafo.insertar(0, 1, -3);
        int peso = grafo.getPeso(0, 1);

        assertFalse("se esperaba no inserte la arista", insertado);
        assertEquals("se esperaba que retornara el maximo entero al no modificar el peso", Integer.MAX_VALUE, peso);

    }

    @Test
    public void noDebePermitirInsertarPeso0() {
        grafo = new GrafoMatriz(3);

        boolean insertado = grafo.insertar(0, 1, 0);
        int peso = grafo.getPeso(0, 1);

        assertFalse("se esperaba inserte la arista", insertado);
        assertEquals("se esperaba que retornara el maximo entero al no haber camino entre las aristas", Integer.MAX_VALUE, peso);

    }

    @Test
    public void debePermitirInsertarUnPesoSuperiorA0EInferiorOIgualAlMaximoEntero() {
        grafo = new GrafoMatriz(3);

        boolean insertado = grafo.insertar(0, 1, 1233);
        int peso = grafo.getPeso(0, 1);

        assertTrue("se esperaba inserte la arista", insertado);
        assertEquals("se esperaba que existiera camino de peso 8 entre las aristas", 1233, peso);

    }

    @Test
    public void noDebePermitirInsertarPesoMaximoDeUnEntero() {
        grafo = new GrafoMatriz(3);

        boolean insertado = grafo.insertar(0, 1, Integer.MAX_VALUE);
        int peso = grafo.getPeso(0, 1);

        assertFalse("se esperaba que inserte la arista", insertado);
        assertEquals("se esperaba que retorne el maximo entero ", Integer.MAX_VALUE, peso);
    }

    @Test
    public void noDebeCalcularElCaminoMinimoConOrigenInexistente() {
        Optional<List> caminoMinio = grafo.caminoMinimoEntreDosVertices(-1, 0);

        assertFalse("se espera que el camino este vacio", caminoMinio.isPresent());
    }

    @Test
    public void noDebeCalcularElCaminoMinimoConDestinoInexistente() {
        grafo = new GrafoMatriz(5);

        Optional<List> caminoMinio = grafo.caminoMinimoEntreDosVertices(0, 10);

        assertFalse("se espera que el camino este vacio", caminoMinio.isPresent());
    }

    @Test
    public void nodebeCalcularElCaminoMinimoConOrigenYDestinoIguales() {
        grafo = new GrafoMatriz(5);

        Optional<List> caminoMinio = grafo.caminoMinimoEntreDosVertices(0, 0);

        assertFalse("se espera que el camino este vacio", caminoMinio.isPresent());
    }

    @Test
    public void debeCalcularElCaminoMinimoConOrigen1Destino0YPeso3() {
        grafo = new GrafoMatriz(3);
        boolean insertado = grafo.insertar(1, 0, 3);

        Optional<List> caminoMinio = grafo.caminoMinimoEntreDosVertices(1, 0);

        assertTrue("se esperaba que el camino con peso 3 fuese insertado", insertado);
        assertTrue("se espera que el camino contenga datos", caminoMinio.isPresent());
        assertEquals("se espera que el camno contenga 2 vertices", 2, caminoMinio.get().size());
        List<Integer> ruta = caminoMinio.get();
        assertEquals("se espera que el nodo de origen sea 1", 1, (int) ruta.get(0));
        assertEquals("se espera que el nodo de destino sea 0", 0, (int) ruta.get(1));
    }

    @Test
    public void debeCalcularElCaminoMinimoConOrigen0Destino1YPeso3() {
        grafo = new GrafoMatriz(3);
        boolean insertado = grafo.insertar(0, 1, 3);

        Optional<List> caminoMinio = grafo.caminoMinimoEntreDosVertices(0, 1);

        assertTrue("se esperaba que el camino con peso 3 fuese insertado", insertado);
        assertTrue("se espera que el camino contenga datos", caminoMinio.isPresent());
        assertEquals("se espera que el camino contenga 2 vertices", 2, caminoMinio.get().size());
        List<Integer> ruta = caminoMinio.get();
        assertEquals("se espera que el nodo de origen sea 0", 0, (int) ruta.get(0));
        assertEquals("se espera que el nodo de destino sea 1", 1, (int) ruta.get(1));
    }
}
