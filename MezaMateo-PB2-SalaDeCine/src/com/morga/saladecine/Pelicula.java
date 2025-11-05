package com.morga.saladecine;

import java.util.Objects;

public abstract class Pelicula {
	 protected String titulo;
	 protected int duracion; 
	 protected int edadMinima;
	 protected String descripcion;
	 protected String genero;
	 
	public Pelicula(String titulo, int duracion, int edadMinima) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
	}
	
	public String mostrarSinopsis() {
		String sinopsis = "Sinopsis de pelicula de "+ this.genero + '\n';
		sinopsis += "Titulo: " + this.titulo + '\n';
		sinopsis += "Duración en minutos: " + this.duracion + '\n';
		sinopsis += "Edad Minima: " + this.edadMinima  + '\n';
		sinopsis += this.descripcion;
		return sinopsis;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(titulo, other.titulo);
	}


	
	
	
}
