package com.morga.saladecine;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;

public class SalaCineTest {

	Pelicula peliculas[] = new Pelicula[4];
	Pelicula peliculasExtra[] = new Pelicula[4];
	SalaCine sala1;

	@Before // o @Before en junit4
	public void metodoQueSeEjecutaAntesDeTodo() {

		// Películas de Acción
		peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
		peliculas[1] = new PeliculaAccion("Misión Imposible", 150, 13);
		peliculas[2] = new PeliculaAccion("John Wick 4", 169, 16);
		peliculas[3] = new PeliculaAccion("Top Gun: Maverick", 130, 13);

		// Películas extra
		peliculasExtra[0] = new PeliculaComedia("La Máscara", 120, 7);
		peliculasExtra[1] = new PeliculaDrama("En busca de la felicidad", 117, 10);
		peliculasExtra[2] = new PeliculaInfantil("Toy Story", 81, 0);
		peliculasExtra[3] = new PeliculaTerror("El Conjuro", 112, 16);

		sala1 = new SalaCine(2, 3);
	}

	@Test
	public void crearSalaOk() {

		PeliculaAccion pelicomparacion = new PeliculaAccion("Piratas del Caribe 1", 200, 14);// (peli1= 0x1235)

		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(2, sala1.getButacas().length);
		assertEquals(3, sala1.getButacas()[0].length);

		assertEquals(pelicomparacion, sala1.getPeliculaActual());
		assertEquals("Piratas del Caribe 1", sala1.getTitulo());
		assertEquals(200, sala1.getPeliculaActual().getDuracion());

	}

	@Test
	public void venderBoletoExitoso() {
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 14, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 2, 16, "Julian Morga");
		assertTrue(venta1);
		assertTrue(venta2);
	}

	@Test
	public void venderBoletoNoExitosoPorqueSeIntentaVenderYaVendido() {

		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		boolean venta2 = sala1.venderBoleto(0, 1, 18, "Julian Morga");
		assertTrue(venta1);
		assertFalse(venta2);
	}

	@Test
	public void venderBoletoNoExitosoPorqueEdadMinimaNoCumplida() {

		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, 12, "Julian Morga");
		boolean venta3 = sala1.venderBoleto(0, 1, -5, "Julian Morga");

		assertFalse(venta1);
		assertFalse(venta3);
	}

	@Test
	public void venderBoletoNoExitosoPorqueElCompradorEsNull() {
		sala1.cambiarPelicula(peliculas[0]);

		boolean venta3 = sala1.venderBoleto(0, 2, 19, null);
		assertFalse(venta3);
	}

	@Test
	public void obtenerTotalAscientosTest() {
		SalaCine sala1 = new SalaCine(2, 3);
		assertEquals(6, sala1.getTotalAsientos());

	}

	@Test
	public void contarAsientosOcupadosTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
	}

	@Test
	public void liberarAsientoVendido() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		assertTrue(sala1.liberarAsiento(0, 1));
		assertEquals(2, sala1.contarAsientosOcupados());
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(0, -2));
		assertFalse(sala1.liberarAsiento(22, 22));
		assertFalse(sala1.liberarAsiento(0, 4));
	}

	@Test
	public void liberarAsientoVendidoFueraDeRangoTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		sala1.venderBoleto(1, 2, 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(5, 10));
		assertFalse(sala1.liberarAsiento(-1, -1));
		assertEquals(3, sala1.contarAsientosOcupados());
	}

	@Test
	public void cambiarAOtraPelicula() {
		sala1.cambiarPelicula(peliculas[2]);
		assertEquals(sala1.getPeliculaActual(), peliculas[2]);
		sala1.cambiarPelicula(peliculas[3]);
		assertEquals(sala1.getPeliculaActual(), peliculas[3]);

	}
	
	@Test
	public void verificarSinopsis() {
		assertTrue(peliculasExtra[0].mostrarSinopsis().contains("La Máscara"));
		assertTrue(peliculasExtra[1].mostrarSinopsis().contains("En busca de la felicidad"));
		assertTrue(peliculasExtra[2].mostrarSinopsis().contains("Toy Story"));
		assertTrue(peliculasExtra[3].mostrarSinopsis().contains("El Conjuro"));
		assertTrue(peliculas[1].mostrarSinopsis().contains("Misión Imposible"));
	}

	@Test
	public void testearEqualsPelicula() {
		Pelicula peli1 = peliculas[0];
		assertFalse(peli1.equals(null));
		assertFalse(peli1.equals(123));

	}

	@Test
	public void reiniciarSalaTest() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.venderBoleto(0, 2, 18, "Julian Morga");
		assertEquals(2, sala1.contarAsientosOcupados());

		sala1.reiniciarSala();
		assertEquals(0, sala1.contarAsientosOcupados());
	}

	@Test
	public void mostrarButacasDetalle() {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, 18, "Julian Morga");
		sala1.mostrarButacasDetalle();
	}

	@Test
	public void testearAsientos() {
		Asiento asiento = new Asiento("Julian Morga", true);
		assertTrue(asiento.estaOcupado());
		assertEquals(asiento.getNombreComprador(), "Julian Morga");
	}

}
