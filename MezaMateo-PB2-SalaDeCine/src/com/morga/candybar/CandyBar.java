package com.morga.candybar;

import java.util.*;

public class CandyBar {
	Set<Producto> productos;
	private int limite;

	public CandyBar(int limite) {
		this.productos = new TreeSet<>();
		this.limite = limite;
		
	}

	public void agregarProducto(Producto producto) throws ProductoDuplicadoException, LimiteAlcanzadoException {
		if(this.productos.size() >= this.limite) { throw new LimiteAlcanzadoException();}
		boolean agregado = this.productos.add(producto);
		if(!agregado) { throw new ProductoDuplicadoException();
		}
		
	}

	public Set<Producto> obtenerInventario() {
		return new TreeSet<>(this.productos);
	}

	public void eliminarProducto(String nombre) throws ProductoNoEncontradoException {
		for (Producto prod : this.productos) {
			if (prod.getNombre().equals(nombre)) {
				 this.productos.remove(prod);
				 return;
			} 
			
		}
		throw new ProductoNoEncontradoException();
		
	}

	public Set<Producto> obtenerBebidasOrdenadasPorPrecioAscendente() {
		Set<Producto> bebidas = new TreeSet<>(new OrdenPorPrecioAscendente());
		for(Producto prod : this.productos) {
			if(prod instanceof Bebida) bebidas.add(prod);
		}
		return bebidas;
	}
	
	public Set<Producto> obtenerSnackOrdenadoPorNombreAscendente() {
		Set<Producto> snackOrdenados = new TreeSet<>(new OrdenPorNombreAscendente());
		for(Producto prod : this.productos) {
			if(prod instanceof Snack) snackOrdenados.add(prod);
		}
		return snackOrdenados;
	}

}
