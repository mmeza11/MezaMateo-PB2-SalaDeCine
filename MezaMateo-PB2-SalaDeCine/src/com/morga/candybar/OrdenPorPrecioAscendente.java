package com.morga.candybar;

import java.util.Comparator;

public class OrdenPorPrecioAscendente implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		int comparar = Double.compare(o1.calcularPrecioFinal(), o2.calcularPrecioFinal());
		if(comparar != 0) return comparar;
		return o1.nombre.compareTo(o2.nombre);
	}

}
