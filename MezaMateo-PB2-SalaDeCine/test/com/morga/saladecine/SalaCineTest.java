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

		sala1 = new SalaCine();
		sala1.agregarButaca("A1");
		sala1.agregarButaca("A2");
		sala1.agregarButaca("A3");
	}

	@Test
	public void crearSalaOk() {

		PeliculaAccion pelicomparacion = new PeliculaAccion("Piratas del Caribe 1", 200, 14);// (peli1= 0x1235)

		sala1.agregarButaca("A4");
		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(4, sala1.getButacas());

		assertEquals(pelicomparacion, sala1.getPeliculaActual());
		assertEquals("Piratas del Caribe 1", sala1.getTitulo());
		assertEquals(200, sala1.getPeliculaActual().getDuracion());

	}

	@Test
	public void venderBoletoExitoso() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 14, "Julian Morga");
		sala1.venderBoleto("A2", 16, "Julian Morga");
		assertEquals(2, sala1.contarAsientosOcupados());
	}

	@Test
	public void venderBoletoNoExitosoPorqueSeIntentaVenderYaVendido() throws Exception {

		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");

		try {
			sala1.venderBoleto("A1", 18, "Julian Morga");
		} catch (Exception e) {
		}

	}

	@Test
	public void venderBoletoNoExitosoPorqueEdadMinimaNoCumplida() throws Exception {

		sala1.cambiarPelicula(peliculas[0]);

		try {
			sala1.venderBoleto("A2", 15, "Julian Morga");
		} catch (Exception d) {
		}

	}

	@Test
	public void venderBoletoNoExitosoPorqueElCompradorEsNull() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		try {
			sala1.venderBoleto("A1", 19, null);
		} catch (Exception e) {
		}

	}

	@Test
	public void obtenerTotalAscientosTest() {

		assertEquals(3, sala1.getTotalAsientos());

	}

	@Test
	public void contarAsientosOcupadosTest() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");
		sala1.venderBoleto("A2", 18, "Julian Morga");
		sala1.venderBoleto("A3", 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
	}

	@Test
	public void liberarAsientoVendido() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");
		sala1.venderBoleto("A2", 18, "Julian Morga");
		sala1.venderBoleto("A3", 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		sala1.liberarAsiento("A1");
		assertEquals(2, sala1.contarAsientosOcupados());
		sala1.venderBoleto("A1", 18, "Julian Morga");
		assertEquals(3, sala1.contarAsientosOcupados());

	}

	@Test
	public void liberarAsientoVendidoFueraDeRangoTest() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");
		sala1.venderBoleto("A2", 18, "Julian Morga");
		sala1.venderBoleto("A3", 18, "Julian Morga");

		assertEquals(3, sala1.contarAsientosOcupados());
		try {
			sala1.liberarAsiento("B4");

		} catch (Exception e) {
		}
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
		assertTrue(peliculasExtra[0].mostrarSinopsis().contains("graciosas"));
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
	public void reiniciarSalaTest() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");
		sala1.venderBoleto("A2", 18, "Julian Morga");
		sala1.venderBoleto("A3", 18, "Julian Morga");
		assertEquals(3, sala1.contarAsientosOcupados());

		sala1.reiniciarSala();
		assertEquals(0, sala1.contarAsientosOcupados());
	}

	@Test
	public void mostrarButacasDetalle() throws Exception {
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto("A1", 18, "Julian Morga");
		sala1.venderBoleto("A2", 18, "Julian Morga");
		sala1.venderBoleto("A3", 18, "Julian Morga");
		sala1.agregarButaca("A4");
		String detalles = sala1.mostrarButacasDetalle();
		assertTrue(detalles.contains("Julian Morga"));
	}

	@Test
	public void testearAsientos() {
		Asiento asiento = new Asiento("Julian Morga", true);
		assertTrue(asiento.estaOcupado());
		assertEquals(asiento.getNombreComprador(), "Julian Morga");
	}

}
