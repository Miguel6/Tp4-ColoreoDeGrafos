package tareasPreliminares;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import nodo.Arista;

public class GeneradorDeGrafos {

	private String path;

	public GeneradorDeGrafos(String path) {
		this.path = path;
	}

	/*
	 * Generador de Grafos aleatorios dados N, y una probabilidad para Cada Arista
	 */
	public void generarGrafoNyPA(int cantNodos, int probXArista) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter(this.path));
		LinkedList<Arista> listaAristas = new LinkedList<>();

		// Calculo la los nodos que van a ir dependiendo de la probabilidad
		for (int i = 1; i < cantNodos; i++) {
			for (int j = i + 1; j <= cantNodos; j++) {
				if (Math.random() <= probXArista) {
					listaAristas.add(new Arista(i, j));
				}
			}
		}

		/// Falta la comprobacion que todos esten unidos

		pw.println(cantNodos + " " + listaAristas.size() + " "
				+ CalculosArchivoIn.porcentajeAdyacencia(listaAristas.size(), cantNodos) + " "
				+ CalculosArchivoIn.gradoMaximo(listaAristas) + " " + CalculosArchivoIn.gradoMinimo(listaAristas));
		for (Arista aristaActual : listaAristas) {
			pw.println(aristaActual.getOrigen() + " " + aristaActual.getDestino());
		}
		pw.close();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
