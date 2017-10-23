package tareasPreliminares;

import nodo.Nodo;

public class MatrizSimetrica {

	private boolean[] vector;
	private int orden;

	public MatrizSimetrica(int tam) {
		this.orden = (tam * (tam - 1)) / 2;
		this.vector = new boolean[this.orden];
	}

	public void generarMatrizSimetrica(Nodo[] listaNodos) {

		/*
		 * Es -1, ya que los nodos son correlativos y consecutivos empezando en 1
		 */
		for (int i = 0; i < listaNodos.length; i++) {
			setIJ(listaNodos[i].getOrigen() - 1, listaNodos[i].getDestino() - 1);
		}
	}

	public boolean[] getVector() {
		return this.vector;
	}

	public void setIJ(int i, int j) {
		if (i > j) {
			vector[funcionPos(j, i)] = true;
		} else {
			vector[funcionPos(i, j)] = true;
		}

	}

	private int funcionPos(int i, int j) {
		return i * this.orden + j - (i * i + 3 * i + 2) / 2;
	}

}
