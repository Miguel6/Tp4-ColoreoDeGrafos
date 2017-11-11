package nodo;

/**
 * Clase nodo, toda la informacion necesaria del nodo:
 *	Color y el valor del mismo
 */
public class Nodo {
	private int nodo;
	private int color;

	public Nodo(int nodo) {
		this.nodo=nodo;
		this.color = 0;
	}
	public Nodo(int nodo, int color) {
		this.nodo = nodo;
		this.color = color;
	}

	public int getNodo() {
		return nodo;
	}

	public int getColor() {
		return color;
	}

}
