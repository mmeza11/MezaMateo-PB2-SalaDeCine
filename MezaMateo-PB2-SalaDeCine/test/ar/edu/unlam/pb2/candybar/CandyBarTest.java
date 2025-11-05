package ar.edu.unlam.pb2.candybar;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.morga.candybar.*;

public class CandyBarTest {

	private CandyBar candyBar;
	private Snack palomitas;
	private Bebida refresco;

	// Se ejecuta antes de cada test para inicializar el objeto CandyBar
	@Before
	public void setUp() {
		candyBar = new CandyBar(5); // Capacidad para 5 productos
		palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 10);
		refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
	}

	@Test
	public void testAgregarProductoQueNoSeDuplique() throws ProductoDuplicadoException, LimiteAlcanzadoException {
		candyBar.agregarProducto(palomitas);
		assertEquals(1, contarProductosEnInventario());

		assertThrows(ProductoDuplicadoException.class, () -> candyBar.agregarProducto(palomitas));

		candyBar.agregarProducto(refresco);
		assertEquals(2, contarProductosEnInventario());

	}

	@Test
	public void testEliminarProductoExistente() throws ProductoDuplicadoException, ProductoNoEncontradoException, LimiteAlcanzadoException {
		candyBar.agregarProducto(palomitas);
		candyBar.agregarProducto(refresco);
		candyBar.eliminarProducto("Palomitas");
		assertEquals(1, contarProductosEnInventario());
	}

	@Test
	public void testEliminarProductoNoExistente() throws ProductoDuplicadoException, ProductoNoEncontradoException, LimiteAlcanzadoException {
		candyBar.agregarProducto(palomitas);
		assertThrows(ProductoNoEncontradoException.class, () -> {
			candyBar.eliminarProducto("Chocolate");
		});
		assertEquals(1, contarProductosEnInventario());
	}

	@Test
	public void testInventarioLleno() throws ProductoDuplicadoException, LimiteAlcanzadoException {
		// Llenar el inventario hasta su capacidad
		candyBar.agregarProducto(new Snack("SnackExtra1", 1.0, Tamano.MEDIANO, 3));
		candyBar.agregarProducto(new Snack("SnackExtra2", 1.0, Tamano.MEDIANO, 3));
		candyBar.agregarProducto(new Snack("SnackExtra3", 1.0, Tamano.MEDIANO, 3));
		candyBar.agregarProducto(new Snack("SnackExtra4", 1.0, Tamano.MEDIANO, 3));
		candyBar.agregarProducto(new Snack("SnackExtra5", 1.0, Tamano.MEDIANO, 3));

		// Intentar agregar un sexto producto
		assertThrows(LimiteAlcanzadoException.class,()->{
			candyBar.agregarProducto(new Snack("SnackExtra", 1.0, Tamano.MEDIANO, 3));});
		assertEquals(5, contarProductosEnInventario());
	}
	
	@Test
	public void obtenerBebidasOrdenadasPorPrecioAscendenteTest() throws ProductoDuplicadoException, LimiteAlcanzadoException {
		candyBar.agregarProducto(new Bebida("Cola", 1.0, Contenedor.BOTELLA, 3));
		candyBar.agregarProducto(new Bebida("Manaos", 7.2, Contenedor.BOTELLA, 3));
		candyBar.agregarProducto(new Bebida("Pepsi", 3.1, Contenedor.BOTELLA, 3));
		
		candyBar.agregarProducto(new Snack("SnackExtra5", 1.0, Tamano.MEDIANO, 3));
		
		Set<Producto> bebidasOrdenadas = candyBar.obtenerBebidasOrdenadasPorPrecioAscendente();
		Iterator<Producto> it = bebidasOrdenadas.iterator();
		Producto arriba = it.next();
		Producto medio = it.next();
		Producto abajo = it.next();
		
		assertEquals("Cola", arriba.getNombre());
		assertEquals("Pepsi", medio.getNombre());
		assertEquals("Manaos", abajo.getNombre());
		
		assertEquals(3, bebidasOrdenadas.size());
	}
	
	@Test
	public void obtenerSnackOrdenadoPorNombreAscendenteTest() throws ProductoDuplicadoException, LimiteAlcanzadoException {
		candyBar.agregarProducto(new Snack("bSnack", 1.0, Tamano.GRANDE, 3));
		candyBar.agregarProducto(new Snack("aSnack", 7.2, Tamano.PEQUENO, 3));
		candyBar.agregarProducto(new Snack("cSnack", 3.1, Tamano.PEQUENO, 3));
		
		Set<Producto> snacksOrdenados = candyBar.obtenerSnackOrdenadoPorNombreAscendente();
		
		Iterator<Producto> it = snacksOrdenados.iterator();
		Producto arriba = it.next();
		Producto medio = it.next();
		Producto abajo = it.next();
		
		assertEquals("aSnack", arriba.getNombre());
		assertEquals("bSnack", medio.getNombre());
		assertEquals("cSnack", abajo.getNombre());
		
	}

	private int contarProductosEnInventario() {
		int count = 0;
		for (Producto p : candyBar.obtenerInventario()) {
			if (p != null) {
				count++;
			}
		}
		return count;
	}
	
}
