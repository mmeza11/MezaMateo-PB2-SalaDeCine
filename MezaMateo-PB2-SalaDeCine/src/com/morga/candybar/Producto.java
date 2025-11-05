package com.morga.candybar;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {
	protected String nombre;
	protected double precioBase;
	protected Enum tipo;
	protected int stock;

	public Producto(String nombre, double precioBase, Enum tipo, int stock) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.tipo = tipo;
		this.stock = stock;
	}
	
	
	public abstract double calcularPrecioFinal();
	
	public String getNombre() {
		return nombre;
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Producto o) {
		if(this.stock != o.stock) return Integer.compare(this.stock, o.stock);
		return this.nombre.compareTo(o.nombre);
	}


}
