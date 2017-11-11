package app;

import java.io.IOException;

import tareasPreliminares.AristaException;
import tareasPreliminares.GenerarGrafo;

public class App {

	public static void main(String[] args) throws IOException, AristaException {
		
		GenerarGrafo gg = new GenerarGrafo(5);
		gg.generarAristas(0.1);
		gg.mostrarVector();
		System.out.println("----COMPLETANDO----");
		gg.completarGrafo();
		gg.mostrarVector();
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
