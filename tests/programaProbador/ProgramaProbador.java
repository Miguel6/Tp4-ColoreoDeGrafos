package programaProbador;

import java.io.FileNotFoundException;

import ioFile.LectoEscritor;
import tareasPreliminares.Coloreo;
import tareasPreliminares.Grafo;
import tareasPreliminares.SolColoreo;

public abstract class ProgramaProbador {
	
	public static void main(String[] args) throws FileNotFoundException {
		Grafo gr1 = LectoEscritor.leerArchivoGrafo("Grafo 0,2Prob de Arista.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr1),gr1);
		ProgramaProbador.probar(Coloreo.matula(gr1),gr1);
		ProgramaProbador.probar(Coloreo.welshPowell(gr1),gr1);
		
		
		Grafo gr2 = LectoEscritor.leerArchivoGrafo("Grafo 0,8Prob de Arista.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr2),gr2);
		ProgramaProbador.probar(Coloreo.matula(gr2),gr2);
		ProgramaProbador.probar(Coloreo.welshPowell(gr2),gr2);
		
		
		Grafo gr3 = LectoEscritor.leerArchivoGrafo("Grafo 20-Partito.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr3),gr3);
		ProgramaProbador.probar(Coloreo.matula(gr3),gr3);
		ProgramaProbador.probar(Coloreo.welshPowell(gr3),gr3);
		
		
		Grafo gr4 = LectoEscritor.leerArchivoGrafo("Grafo con 40Porciento adyacencia.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr4),gr4);
		ProgramaProbador.probar(Coloreo.matula(gr4),gr4);
		ProgramaProbador.probar(Coloreo.welshPowell(gr4),gr4);
		
		
		Grafo gr5 = LectoEscritor.leerArchivoGrafo("Grafo con 60Porciento adyacencia.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr5),gr5);
		ProgramaProbador.probar(Coloreo.matula(gr5),gr5);
		ProgramaProbador.probar(Coloreo.welshPowell(gr5),gr5);
		
		
		Grafo gr6 = LectoEscritor.leerArchivoGrafo("Grafo con 90Porciento adyacencia.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr6),gr6);
		ProgramaProbador.probar(Coloreo.matula(gr6),gr6);
		ProgramaProbador.probar(Coloreo.welshPowell(gr6),gr6);
		
		
		Grafo gr7 = LectoEscritor.leerArchivoGrafo("Grafo con grado 50.in");
		ProgramaProbador.probar(Coloreo.secuencial(gr7),gr7);
		ProgramaProbador.probar(Coloreo.matula(gr7),gr7);
		ProgramaProbador.probar(Coloreo.welshPowell(gr7),gr7);
		
		System.out.println("Termine.");
	}

	private static void probar(SolColoreo sol, Grafo gr) {
		
		for(int i = 1 ; i < gr.getCantNodos() ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(gr.getMs().getValIJ(i, j)) {
					if(sol.getNodos()[i].getColor() == sol.getNodos()[j].getColor()) {
						System.out.println("ERROR: Nodos adyacentes de un mismo color. (" + i + ", " + j + ")");
					}
				}
			}
		}
	}
}
