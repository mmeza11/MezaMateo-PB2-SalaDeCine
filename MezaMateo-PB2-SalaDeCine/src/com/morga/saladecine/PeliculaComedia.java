package com.morga.saladecine;

public class PeliculaComedia extends Pelicula {

	public PeliculaComedia(String titulo, int duracion, int edadMinima) {
		super(titulo, duracion, edadMinima);
	}

	@Override
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de Comedia" + '\n';
		sinopsis += "Titulo: " + super.getTitulo() + '\n';
		sinopsis += "Duración en minutos: " + super.getDuracion() + '\n';
		sinopsis += "Edad Minima: " + super.getEdadMinima() + '\n';
		sinopsis += "Las peliculas de comedia se caracterizan por ser graciosas";
		return sinopsis;

	}

}
