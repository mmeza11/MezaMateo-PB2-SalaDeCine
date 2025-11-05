package com.morga.saladecine;

public class Asiento {
	private String nombreComprador;
	private boolean ocupado;
		
	public Asiento() {
		this.liberar();
	}
	
	public Asiento(String nombreComprador, boolean ocupado) {
		this.nombreComprador = nombreComprador;
		this.ocupado = ocupado;
	}
	
	public String getNombreComprador() {
		return nombreComprador;
	}
	
	public void ocupar(String nombreComprador) {
		this.nombreComprador = nombreComprador;
		this.ocupado = true;
	}
	
	public void liberar() {
		this.nombreComprador = null;
		this.ocupado = false;
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}

	
}
