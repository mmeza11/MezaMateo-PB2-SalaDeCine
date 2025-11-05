package com.morga.candybar;

public class Combo  {
	private String nombre;
	private Snack snack;
	private Bebida bebida;
	private double descuento;
	private int stock;


	public Combo(String nombre, Snack snack, Bebida bebida, double descuento, int stock) {
		super();
		this.nombre = nombre;
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;
		this.stock = stock;
	}

	public double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		if(this.nombre.equals("Combo Deluxe")) {
		return ((this.snack.calcularPrecioFinal() + this.bebida.calcularPrecioFinal()) * (1 - descuento));
	}
		return (this.snack.calcularPrecioFinal() + this.bebida.calcularPrecioFinal());
	}



}
