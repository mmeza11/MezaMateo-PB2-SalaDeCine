package com.morga.candybar;

public class Snack extends Producto {
	private Tamano tamano;

	public Snack(String nombre, double precioBase, Tamano tamano, int stock) {
		super(nombre, precioBase, stock);
		this.tamano = tamano;
		
	}

	@Override
	public double calcularPrecioFinal() {
		
		if(this.tamano.equals(Tamano.GRANDE)) {
			return this.precioBase + (this.precioBase * 0.20);
		}

		if(this.tamano.equals(Tamano.PEQUENO)) {
			return this.precioBase - (this.precioBase * 0.15);
		}
		
		// TODO Auto-generated method stub
		return this.precioBase;
	}

	

}
