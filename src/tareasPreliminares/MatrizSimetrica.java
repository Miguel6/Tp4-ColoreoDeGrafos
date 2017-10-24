package tareasPreliminares;

import nodo.Arista;

public class MatrizSimetrica {

	private boolean[] vector;
	private int ordenMatriz;
	private int tamVector;

	public MatrizSimetrica(int cantNodos) {
		this.tamVector= (cantNodos * (cantNodos-1)) / 2;
		this.vector = new boolean[this.tamVector];
		this.ordenMatriz=(int) ((1+Math.sqrt((1+8*this.tamVector)))/2);
	}

	public void generarMatrizSimetrica(Arista[] listaNodos) {

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
	public boolean getValIJ(int i , int j) {
		return this.vector[funcionPos(i, j)];
	}

	private int funcionPos(int i, int j) {
		return i * this.ordenMatriz + j - (i * i + 3 * i + 2) / 2;
	}

}
