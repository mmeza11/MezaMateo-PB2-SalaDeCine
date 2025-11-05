package com.morga.candybar;

import java.util.Comparator;

public class Bebida extends Producto  {
	private Contenedor contenedor;

	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, precioBase, stock);
		this.contenedor = contenedor;
	}

	@Override
	public double calcularPrecioFinal() {
		if(this.contenedor.equals(Contenedor.BOTELLA)) {
			return this.precioBase + (this.precioBase * 0.10);
		}
		// TODO Auto-generated method stub
		return this.precioBase;
	}

}
