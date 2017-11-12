package app;

import java.io.IOException;

import exception.AristaException;
import exception.GrafoException;
import nodo.Nodo;
import tareasPreliminares.Coloreo;
import tareasPreliminares.GeneradorDeGrafos;
import tareasPreliminares.Grafo;

public class App {

	public static void main(String[] args) throws IOException, AristaException, GrafoException {
		
		GeneradorDeGrafos gg = new GeneradorDeGrafos(5);
		Grafo gPA = gg.GenerarGrafoProbXArista(0.9);
		gPA.mostrarMatriz();
		System.out.println("----COMPLETANDO----");
		System.out.println(Coloreo.secuencial(gPA));

//		gg.completarGrafo();
//		gPA.mostrarMatriz();
//		LinkedList<Arista> listaAristas = new LinkedList<>();
//		listaAristas.add(new Arista(1,2));
//		listaAristas.add(new Arista(1,5));
//		listaAristas.add(new Arista(1,4));
//		listaAristas.add(new Arista(4,5));
//		CalculosArchivoIn cai = new CalculosArchivoIn(listaAristas);
//		cai.completarGrafo(listaAristas, 5);
//		
//		System.out.println(cai.gradoMaximo(listaAristas));
//		System.out.println(cai.gradoMinimo(listaAristas));
//		for (Integer key : cai.getMapaNodos().keySet()) {
//			System.out.println(key);
//		}
		
	}
}
