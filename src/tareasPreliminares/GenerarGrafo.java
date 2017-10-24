package tareasPreliminares;

import java.util.LinkedList;

import nodo.Arista;

public class GenerarGrafo {

	private MatrizSimetrica ms;
	private String path;
	private int cantNodos;

	public GenerarGrafo(int cantNodos, String path) {
		this.ms = new MatrizSimetrica(cantNodos);
		this.cantNodos = cantNodos;
		this.path = path;

	}

	public void generarAristas(double probXArista) throws AristaException {
		if (probXArista > 1 || probXArista < 0) {
			throw new AristaException("Ingrese una probabilidad entre 0 y 1");
		}

		LinkedList<Arista> listaAristas = new LinkedList<>();
		// Calculo la los nodos que van a ir dependiendo de la probabilidad
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < this.cantNodos; j++) {
				if (Math.random() >= probXArista) {
					listaAristas.add(new Arista(i, j));
					this.ms.setIJ(i, j);

				}
			}
		}
	}

	public void mostrarVector() {
		for (int i = 0; i < this.ms.getVector().length; i++) {
			System.out.println("-->" + this.ms.getVector()[i]);
		}
	}

	public void completarGrafo() {

		int fil;
		boolean tieneUnaConexion;
		/*
		 * Si en una columna no tengo al menos un true, significa, que ese nodo esta
		 * desconectado
		 */
		for (int col = 1; col < this.cantNodos; col++) {
			tieneUnaConexion = false;

			for (fil = 0; fil < col && !tieneUnaConexion; fil++) {
				if (this.ms.getValIJ(fil, col)) {
					tieneUnaConexion = true;
				}
			}
			for (int i = col+1; i < this.cantNodos && !tieneUnaConexion; i++) {
				
				if (this.ms.getValIJ(fil, i)) {
					tieneUnaConexion = true;
				}
			}

			if (!tieneUnaConexion) {
				this.ms.setIJ(fil - 1, col);
			}
		}
	}
}
