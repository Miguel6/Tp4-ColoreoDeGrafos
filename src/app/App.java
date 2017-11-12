package app;

import java.io.IOException;

import exception.AristaException;
import exception.GrafoException;
<<<<<<< Updated upstream
import nodo.Nodo;
import tareasPreliminares.Coloreo;
=======
import exception.PorcentajeDeAdyacenciaException;
>>>>>>> Stashed changes
import tareasPreliminares.GeneradorDeGrafos;
import tareasPreliminares.Grafo;

public class App {

<<<<<<< Updated upstream
	public static void main(String[] args) throws IOException, AristaException, GrafoException {
		
		GeneradorDeGrafos gg = new GeneradorDeGrafos(5);
		Grafo gPA = gg.GenerarGrafoProbXArista(0.1);
		gPA.mostrarMatriz();
		System.out.println("----COMPLETANDO----");
		System.out.println(Coloreo.welshPowell(gPA));
		System.out.println("termine");

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
=======
	public static void main(String[] args) throws IOException, AristaException, GrafoException, PorcentajeDeAdyacenciaException {
		GeneradorDeGrafos gdg = new GeneradorDeGrafos(7);
		Grafo g = gdg.generarGrafoNPartito(4);
		g.mostrarMatriz();
>>>>>>> Stashed changes
		
	}
}
