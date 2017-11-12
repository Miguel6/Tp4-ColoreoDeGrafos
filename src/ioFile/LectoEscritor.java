package ioFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import nodo.Nodo;
import tareasPreliminares.Grafo;
import tareasPreliminares.MatrizSimetrica;
import tareasPreliminares.SolColoreo;

public abstract class LectoEscritor {

	public static Grafo leerArchivoGrafo(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader(path));
		int cantNodos = sc.nextInt();
		int cantAristas = sc.nextInt();
		double porcentajeAdyacencia = sc.nextDouble();
		int gradoMax = sc.nextInt();
		int gradoMin = sc.nextInt();
		Grafo gr = new Grafo(cantNodos, cantAristas, porcentajeAdyacencia, gradoMax, gradoMin, new MatrizSimetrica(cantNodos));

		for (int i = 0; i < cantAristas; i++) {
			gr.getMs().setIJ(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		return gr;
	}


	public static void escribirArchivoGrafo(String path, Grafo gr) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(path));
		
		String primeraLinea = gr.getCantNodos() + " " + gr.getCantAristas() + " "
				+ String.format("%.2f", gr.getPorcentajeAdy()) + " " + gr.getGrMax() + " " + gr.getGrMin();
		
		pw.println(primeraLinea);
		
		for(int i = 1 ; i < gr.getCantNodos() ; i++) {
			for(int j = 0 ; j < i ; j++) {
				pw.println(i + " " + j);
			}
		}
		pw.close();
	}


	public static void escribirArchivoColoreo(String path, SolColoreo sol, Grafo gr) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(path));

		String primeraLinea = gr.getCantNodos() + " " + sol.getCantidadColores() + " " + gr.getCantAristas() + " "
				+ String.format("%.2f", gr.getPorcentajeAdy()) + " " + gr.getGrMax() + " " + gr.getGrMin();

		pw.println(primeraLinea);

		for (int i = 0; i < sol.getNodos().length; i++) {
			pw.println(sol.getNodos()[i].getNodo() + " " + sol.getNodos()[i].getColor());
		}
		pw.close();
	}
}
