package com.morga.candybar;

public class ProductoDuplicadoException extends Exception {
	public ProductoDuplicadoException() {
		super("El producto esta duplicado");
	}
}
