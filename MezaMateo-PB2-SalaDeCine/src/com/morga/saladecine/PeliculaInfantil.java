package com.morga.saladecine;

public class PeliculaInfantil extends Pelicula{

	public PeliculaInfantil(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		this.descripcion = "Las peliculas infantiles se caracterizan por ser para toda la familia";
		this.genero = "Infantil";
	}

}
