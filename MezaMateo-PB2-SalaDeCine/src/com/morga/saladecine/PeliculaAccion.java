package com.morga.saladecine;

public class PeliculaAccion extends Pelicula{

	public PeliculaAccion(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		this.descripcion = "Las peliculas de accion se caracterizan por tener un alto grado de violencia, explosivos impresionantes y heroes que salvan al mundo.";
		this.genero = "Accion";
	}

}
