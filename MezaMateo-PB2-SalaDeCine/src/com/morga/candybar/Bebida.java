package com.morga.candybar;

import java.util.Comparator;

public class Bebida extends Producto  {

	public Bebida(String nombre, double precioBase, Contenedor contenedor, int stock) {
		super(nombre, precioBase, contenedor, stock);
	}

	@Override
	public double calcularPrecioFinal() {
		if(this.tipo.equals(Contenedor.BOTELLA)) {
			return this.precioBase + (this.precioBase * 0.10);
		}
		// TODO Auto-generated method stub
		return this.precioBase;
	}

}
