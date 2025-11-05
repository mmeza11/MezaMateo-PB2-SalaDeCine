package com.morga.saladecine;

public class PeliculaDrama extends Pelicula{

	public PeliculaDrama(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		this.descripcion = "Las peliculas de drama se caracterizan por ser dramaticas";
		this.genero = "Drama";
	}

}
