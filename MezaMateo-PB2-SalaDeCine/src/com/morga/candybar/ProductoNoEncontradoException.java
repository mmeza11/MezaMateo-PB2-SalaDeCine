package com.morga.candybar;

public class ProductoNoEncontradoException extends Exception{
public ProductoNoEncontradoException() {
	super("El producto no existe");
}
}
