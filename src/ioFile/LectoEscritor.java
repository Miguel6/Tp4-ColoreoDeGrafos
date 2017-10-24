package ioFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import nodo.Arista;
import nodo.NodoColoreado;

public class LectoEscritor {

	private int cantNodos;
	private int cantAristas;
	private int porcentajeAdyacencia;
	private int gradoMax;
	private int gradoMin;

	public Arista[] leerArchivo(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(path));

		this.cantNodos = sc.nextInt();
		this.cantAristas = sc.nextInt();
		this.porcentajeAdyacencia = sc.nextInt();
		this.gradoMax = sc.nextInt();
		this.gradoMin = sc.nextInt();

		Arista[] nodos = new Arista[this.cantNodos];

		for (int i = 0; i < nodos.length; i++)
			nodos[i] = new Arista(sc.nextInt(), sc.nextInt());

		sc.close();
		return nodos;
	}

	public void escribirArchivo(String path, int cantColores, NodoColoreado[] nodosColoreados) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(path));

		String primeraLinea = this.cantNodos + " " + cantColores + " " + this.cantAristas + " "
				+ this.porcentajeAdyacencia + " " + this.gradoMax + " " + this.gradoMin;

		pw.println(primeraLinea);

		for (int i = 0; i < nodosColoreados.length; i++)
			pw.println(nodosColoreados[i].getNodo() + " " + nodosColoreados[i].getColor());

		pw.close();
	}

	public int getCantNodos() {
		return this.cantNodos;
	}

	public int getCantAristas() {
		return this.cantAristas;
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
