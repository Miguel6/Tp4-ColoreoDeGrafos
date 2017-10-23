package ioFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import nodo.Nodo;
import nodo.NodoColoreado;

public class LectoEscritor {

	private int cantNodos;
	private int cantAdyacencia;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;

	public LinkedList<Nodo> leerArchivo(String path) throws FileNotFoundException {

		LinkedList<Nodo> listaDeNodos = new LinkedList<>();
		Scanner sc = new Scanner(new FileReader(path));

		this.cantNodos = sc.nextInt();
		this.cantAdyacencia = sc.nextInt();
		this.porcentajeAdyacencia = sc.nextInt();
		this.gradoMax = sc.nextInt();
		this.gradoMin = sc.nextInt();

		for (int i = 0; i < this.cantNodos; i++) {
			listaDeNodos.add(new Nodo(sc.nextInt(), sc.nextInt()));

		}
		sc.close();
		return listaDeNodos;
	}

	public void escribirArchivo(String path, int cantColores, LinkedList<NodoColoreado> listaNodosColoreados)
			throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(path));

		String primeraLinea = this.cantNodos + " " + cantColores + " " + this.cantAdyacencia + " "
				+ this.porcentajeAdyacencia + " " + this.gradoMax + " " + this.gradoMin;

		pw.println(primeraLinea);

		for (NodoColoreado nodoColoreado : listaNodosColoreados) {
			pw.println(nodoColoreado.getNodo() + " " + nodoColoreado.getColor());
		}
		pw.close();
	}

	public int getCantNodos() {
		return this.cantNodos;
	}

	public int getCantAdyacencia() {
		return this.cantAdyacencia;
	}

	public int getPorcentajeAdyacencia() {
		return this.porcentajeAdyacencia;
	}

	public int getGradoMax() {
		return this.gradoMax;
	}

	public int getGradoMin() {
		return this.gradoMin;
	}
}
