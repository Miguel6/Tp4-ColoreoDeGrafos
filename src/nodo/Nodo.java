package nodo;

/**
 * Clase nodo, toda la informacion necesaria del nodo:
 *	Color y el valor del mismo
 */
public class Nodo implements Comparable{
	private int nodo;
	private int color;
	private int grado;

	public Nodo(int nodo) {
		this.nodo=nodo;
		this.color = 0;
		this.grado = 0;
	}
	public Nodo(int nodo, int color) {
		this.nodo = nodo;
		this.color = color;
		this.grado = 0;
	}

	public int getNodo() {
		return nodo;
	}

	public int getColor() {
		return color;
	}
	
	public void setColor(final int color) {
		this.color = color;
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
	}
	
	@Override
	public int compareTo(Object obj) {
		Nodo otroNodo = (Nodo) obj;
		return this.grado - otroNodo.getGrado() ;
	}
	
	@Override
	public String toString() {
		return ("nodo: " + this.nodo + "		color: " + this.color + "	grado: " + this.grado);
	}
}
