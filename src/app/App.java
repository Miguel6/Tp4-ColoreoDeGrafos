package app;

import java.io.IOException;

import exception.AristaException;
import exception.GrafoException;
import exception.PorcentajeDeAdyacenciaException;
import ioFile.LectoEscritor;
import tareasPreliminares.GeneradorDeGrafos;
import tareasPreliminares.Grafo;

public class App {


	public static void main(String[] args) throws IOException, AristaException, GrafoException, PorcentajeDeAdyacenciaException {
		GeneradorDeGrafos gdg = new GeneradorDeGrafos(600);
		LectoEscritor.escribirArchivoGrafo("Grafo 20-Partito.in", gdg.generarGrafoNPartito(20));
		LectoEscritor.escribirArchivoGrafo("Grafo con grado 50.in", gdg.generarGrafoConGrado(50));
		LectoEscritor.escribirArchivoGrafo("Grafo con 40Porciento adyacencia.in", gdg.GenerarGrafoPorcentajeAdyacencia(40));
		LectoEscritor.escribirArchivoGrafo("Grafo con 60Porciento adyacencia.in", gdg.GenerarGrafoPorcentajeAdyacencia(60));
		LectoEscritor.escribirArchivoGrafo("Grafo con 90Porciento adyacencia.in", gdg.GenerarGrafoPorcentajeAdyacencia(90));
		LectoEscritor.escribirArchivoGrafo("Grafo 0,2Prob de Arista.in", gdg.GenerarGrafoProbXArista(0.2));
		LectoEscritor.escribirArchivoGrafo("Grafo 0,8Prob de Arista.in", gdg.GenerarGrafoProbXArista(0.8));	
		
		
	}
}
