package app;

import java.io.IOException;
import java.util.LinkedList;

import exception.AristaException;
import exception.GrafoException;
import exception.PorcentajeDeAdyacenciaException;
import tareasPreliminares.Coloreo;
import tareasPreliminares.GeneradorDeGrafos;

public class App {


	public static void main(String[] args) throws IOException, AristaException, GrafoException, PorcentajeDeAdyacenciaException {
		GeneradorDeGrafos gdg = new GeneradorDeGrafos(600);
		LinkedList<Integer> colores = new LinkedList<>();
		for(int i=0;i<10000;i++) {
			colores.add(Coloreo.matula(gdg.GenerarGrafoPorcentajeAdyacencia(0.4)).getCantidadColores());
			System.out.println(colores.get(i));
		}
		
		
	}
}
