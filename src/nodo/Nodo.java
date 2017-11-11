package nodo;

import java.awt.Color;

public class NodoColoreado {
	private int nodo;
	private Color color;

	public NodoColoreado(int nodo, Color color) {
		this.nodo = nodo;
		this.color = color;
	}

	public int getNodo() {
		return nodo;
	}

	public Color getColor() {
		return color;
	}

}
