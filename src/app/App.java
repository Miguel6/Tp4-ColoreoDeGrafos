package app;

import java.io.IOException;

import exception.AristaException;
import exception.GrafoException;
import exception.PorcentajeDeAdyacenciaException;
import tareasPreliminares.GeneradorDeGrafos;
import tareasPreliminares.Grafo;

public class App {


	public static void main(String[] args) throws IOException, AristaException, GrafoException, PorcentajeDeAdyacenciaException {
		GeneradorDeGrafos gdg = new GeneradorDeGrafos(7);
		Grafo g = gdg.generarGrafoNPartito(4);
		g.mostrarMatriz();
		
	}
}
