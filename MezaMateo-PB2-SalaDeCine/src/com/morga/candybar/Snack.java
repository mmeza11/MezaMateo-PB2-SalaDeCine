package com.morga.candybar;

public class Snack extends Producto {

	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, precioBase, tamano, stock);
		
	}

	@Override
	public double calcularPrecioFinal() {
		
		if(this.tipo.equals(Tamano.GRANDE)) {
			return this.precioBase + (this.precioBase * 0.20);
		}

		if(this.tipo.equals(Tamano.PEQUENO)) {
			return this.precioBase - (this.precioBase * 0.15);
		}
		
		// TODO Auto-generated method stub
		return this.precioBase;
	}

	

}
