package tareasPreliminares;

import nodo.Nodo;

public class SolColoreo {
	
	private Nodo[] nodos;
	private int cantidadColores;
	
	public SolColoreo(final Nodo[] nodos, final int cantColores) {
		this.nodos = nodos;
		this.cantidadColores = cantColores;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
		this.nodos = nodos;
	}

	public int getCantidadColores() {
		return cantidadColores;
	}

	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}
	
	@Override
	public String toString() {
		for(int i = 0 ; i < this.nodos.length ; i++) {
			System.out.println(nodos[i]);
		}
		return "-> cant. colores: " + cantidadColores;
	}
}
