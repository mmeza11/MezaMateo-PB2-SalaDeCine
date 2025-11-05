package com.morga.saladecine;

public class PeliculaTerror extends Pelicula {

	public PeliculaTerror(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
		this.descripcion = "Las peliculas de terror se caracterizan por ser muy malas";
		this.genero = "Terror";
	}

}
