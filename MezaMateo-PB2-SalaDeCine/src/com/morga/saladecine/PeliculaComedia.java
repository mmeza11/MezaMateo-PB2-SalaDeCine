package com.morga.saladecine;

public class PeliculaComedia extends Pelicula {

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		this.descripcion = "Las peliculas de comedia se caracterizan por ser graciosas";
		this.genero = "Comedia";
	}

}
