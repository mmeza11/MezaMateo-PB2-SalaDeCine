package com.morga.saladecine;

import java.util.*;

public class SalaCine {
	private Map<String, Asiento> butacas;
	private Pelicula pelicula;

	public SalaCine() {
		this.butacas = new TreeMap<>();

	}

	public int getButacas() {
		return butacas.size();
	}

	public int contarAsientosOcupados() {
		int contador = 0;
		for (Asiento asiento : this.butacas.values()) {
			if (asiento.estaOcupado())
				contador++;
		}

		return contador;
	}

	public int getTotalAsientos() {
		return butacas.size();
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Pelicula getPeliculaActual() {
		return pelicula;
	}

	public void venderBoleto(String lugar, int edad, String nombreComprador) throws Exception {

		Asiento asiento = this.butacas.get(lugar);

		if (nombreComprador == null || asiento == null) throw new Exception();
		if (asiento.estaOcupado()) throw new Exception();
		if (this.pelicula.getEdadMinima() > edad) throw new Exception();

		asiento.ocupar(nombreComprador);
	}

	public String getTitulo() {
		return pelicula.getTitulo();
	}

	public void liberarAsiento(String lugar) throws Exception {
		Asiento asiento = this.butacas.get(lugar);
		if (asiento == null || !asiento.estaOcupado()) throw new Exception();
		asiento.liberar();

	}

	public void reiniciarSala() {
		for (Asiento asiento : this.butacas.values()) {
			asiento.liberar();
		}
	}

	public String mostrarButacasDetalle() {
		String estado = "";

		for (Map.Entry<String, Asiento> entry : butacas.entrySet()) {
			String lugar = entry.getKey();
			Asiento asiento = entry.getValue();

			if (asiento.estaOcupado()) {
				estado += "Butaca " + lugar + " está ocupada por: " + asiento.getNombreComprador() + "\n";
			} else {
				estado += "Butaca " + lugar + " está libre\n";
			}
		}

		return estado;

	}

	public void agregarButaca(String lugar) {
		this.butacas.put(lugar, new Asiento());
	}


	/*
	 * } String butacasDetalle = ""; for (int i = 0; i < butacas.length; i++) { for
	 * (int j = 0; j < butacas[i].length; j++) { String estado =
	 * this.butacas[i][j].estaOcupado() ? "\nButaca Fila " + i + ", Columna " + j +
	 * " está ocupada por: " + this.butacas[i][j].getNombreComprador() + "." :
	 * "\nButaca Fila " + i + ", Columna " + j + " está libre."; butacasDetalle +=
	 * estado; }
	 * 
	 * }
	 * 
	 * return butacasDetalle; }
	 */

}
