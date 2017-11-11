package tareasPreliminares;

/**
 * Clase encargada de manejar las aristas 
 * como si se tratase de un vector en vez de 
 * una matriz.
 * 
 * @author Los Tres Mosqueteros
 */
public class MatrizSimetrica {

	private boolean[] vector;
	private int ordenMatriz;
	private int tamVector;
	private int cantNodos;
	private int cantAristas;

	public MatrizSimetrica(int cantNodos) {
		this.tamVector= (cantNodos * (cantNodos-1)) / 2;
		this.vector = new boolean[this.tamVector];
		this.ordenMatriz=(int) ((1+Math.sqrt((1+8*this.tamVector)))/2);
		this.cantNodos = cantNodos;
		this.cantAristas = 0;
	}

	public boolean[] getVector() {
		return this.vector;
	}

	public void setIJ(int i, int j) {
		if (i > j) {
			vector[funcionPos(j, i)] = true;
			this.cantAristas++;
		} else {
			vector[funcionPos(i, j)] = true;
			this.cantAristas++;
		}

	}
	public boolean getValIJ(int i , int j) {
		if (i > j) {
			return this.vector[funcionPos(j, i)];
		} else {
			return this.vector[funcionPos(i, j)];
		}
	}

	private int funcionPos(int i, int j) {
		return i * this.ordenMatriz + j - (i * i + 3 * i + 2) / 2;
	}
	
	public int getCantNodos() {
		return cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}
}
