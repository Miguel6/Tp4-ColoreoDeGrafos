package tareasPreliminares;

import java.util.ArrayList;
import java.util.LinkedList;

import nodo.Nodo;

public abstract class Coloreo {

	/**
	 * Metodo de coloreo Secuencial
	 * @param grafo		es el grafo a colorear
	 * @return Solucion del algoritmo, cantidad minima de colores usados y el color de cada nodo
	 */
	public static SolColoreo secuencial(Grafo grafo) {

		LinkedList<Integer> coloresProhibidos = new LinkedList<Integer>();

		ArrayList<Integer> coloresEnUso = new ArrayList<Integer>();

		Nodo[] nodos = new Nodo[grafo.getCantNodos()];

		for (int i = 0; i < nodos.length; i++) { // recorre los nodos del vector para colorearlos
			nodos[i] = new Nodo(i);
			for (int j = 0; j < i; j++) { // recorre los nodos ya coloreados
				// System.out.println(i + "," + j + " ----> " + grafo.getMs().getValIJ(i, j)); // -------------------------->
				if (grafo.getMs().getValIJ(i, j)) { // si son adyacentes descarta el color
					coloresProhibidos.add(nodos[j].getColor());
				}
			}
			// recorre lista de colores prohibidos
			//System.out.println("colo en uso : " + coloresEnUso.size()); // --------------------------------------->
			for (int k = 0; (nodos[i].getColor() == 0) && (k < coloresEnUso.size()); k++) {
				if (!coloresProhibidos.contains(k + 1)) {
					nodos[i].setColor(k + 1);
				}
			}
			if (nodos[i].getColor() == 0) { // si todos los colores estan prohibidos pinta con un color nuevo
				nodos[i].setColor(coloresEnUso.size() + 1);
				coloresEnUso.add(coloresEnUso.size() + 1);
			}
			coloresProhibidos.clear(); // limpia la lista de colores prohibidos para que el proximo nodo la utilice
		}

		return new SolColoreo(nodos, coloresEnUso.size()); // retorna los nodos y el numero minimo de colores
															// encontrado.
	}

	/**
	 * Metodo de coloreo de Welsh-Powell o grado mayor primero
	 * @param grafo		es el grafo a colorear
	 * @return Solucion del algoritmo, cantidad minima de colores usados y el color de cada nodo
	 */
	public static SolColoreo welshPowell(Grafo grafo) {

		Nodo[] nodos = new Nodo[grafo.getCantNodos()];
		LinkedList<Nodo> nodosSinColor = new LinkedList<Nodo>();//se hace uso de una lista por la facilidad de remover nodos

		for (int i = 0; i < nodos.length; i++) {	//Se crea cada nodo
			nodosSinColor.add(new Nodo(i));
		}

		for (int i = 0; i < nodos.length; i++) {			//Se calcula el grado de cada nodo
			for (int j = i + 1; j < nodos.length ; j++) {
				if (grafo.getMs().getValIJ(i, j)) {
					nodosSinColor.get(i).setGrado(nodosSinColor.get(i).getGrado() + 1);
					nodosSinColor.get(j).setGrado(nodosSinColor.get(j).getGrado() + 1);
				}
			}
		}
		nodosSinColor.sort(null);	//Los nodos son ordenados por grado de menor a mayor
		
		// a partir de aca no coinciden los nombres de los nodos con sus posiciones.

		int color = 0;

		while (!nodosSinColor.isEmpty()) {	//cada iteracion va a tener un color distinto
			color++;
			//System.out.println(nodosSinColor.size());	//	------------------------------------------------------------->
			
			/**se pintan todos los nodos que no son adyacentes entre si con el mismo color,
			 * se recorre desde el nodo con mayor grado hacia el de menor grado 
			 */
			for (int i = nodosSinColor.size() - 1; i >= 0; i--) {	
				boolean pintar = true;
				for (int j = i; j < nodosSinColor.size() && pintar; j++) {
					if (nodosSinColor.get(j).getColor() != 0
							&& grafo.getMs().getValIJ(nodosSinColor.get(i).getNodo(), nodosSinColor.get(j).getNodo())) {
						pintar = false;
					}
				}
				if (pintar) {
					nodosSinColor.get(i).setColor(color);
				}
			}
			// HASTA ACA SE TERMINA DE PINTAR DE UN COLOR.
			// DESDE ACA SE BUSCA A LOS PINTADOS, SE LOS CARGA AL ARRAY Y ELIMINA DE LA LISTA,
			// SE CAMBIA EL COLOR PARA LA PROXIMA RONDA
			for (int i = 0; i < nodosSinColor.size(); i++) {
				
				if (nodosSinColor.get(i).getColor() != 0) {
					nodos[nodosSinColor.get(i).getNodo()] = nodosSinColor.remove(i);
					i--;
				}
			}
		}
		return new SolColoreo(nodos, color);
	}
	
	/**
	 * Metodo de coloreo de Matula o grado menor primero
	 * @param grafo		es el grafo a colorear
	 * @return Solucion del algoritmo, cantidad minima de colores usados y el color de cada nodo
	 */
	public static SolColoreo matula(Grafo grafo) {

		Nodo[] nodos = new Nodo[grafo.getCantNodos()];
		LinkedList<Nodo> nodosSinColor = new LinkedList<Nodo>();//se hace uso de una lista por la facilidad de remover nodos

		for (int i = 0; i < nodos.length; i++) {		//Se crea cada nodo
			nodosSinColor.add(new Nodo(i));
		}

		for (int i = 0; i < nodos.length; i++) {			//Se calcula el grado de cada nodo
			for (int j = i + 1; j < nodos.length; j++) {
				if (grafo.getMs().getValIJ(i, j)) {
					nodosSinColor.get(i).setGrado(nodosSinColor.get(i).getGrado() + 1);
					nodosSinColor.get(j).setGrado(nodosSinColor.get(j).getGrado() + 1);
				}
			}
		}
		nodosSinColor.sort(null);		//Los nodos son ordenados por grado de menor a mayor
		
		// a partir de aca no coinciden los nombres de los nodos con sus posiciones.

		int color = 0;

		while (!nodosSinColor.isEmpty()) {
			color++;
			
			/**se pintan todos los nodos que no son adyacentes entre si con el mismo color,
			 * se recorre desde el nodo con mayor grado hacia el de menor grado 
			 */
			for (int i = 0; i < nodosSinColor.size(); i++) {
				boolean pintar = true;
				for (int j = i; j >= 0 && pintar; j--) {
					if (nodosSinColor.get(j).getColor() != 0
							&& grafo.getMs().getValIJ(nodosSinColor.get(i).getNodo(), nodosSinColor.get(j).getNodo())) {
						pintar = false;
					}
				}
				if (pintar) {
					nodosSinColor.get(i).setColor(color);
				}
			}
			/* HASTA ACA SE TERMINA DE PINTAR DE UN COLOR.
			 * DESDE ACA SE BUSCA A LOS PINTADOS, SE LOS CARGA AL ARRAY Y ELIMINA DE LA LISTA,
			 * SE CAMBIA EL COLOR PARA LA PROXIMA RONDA
			 */
			for (int i = 0; i < nodosSinColor.size(); i++) {
				if (nodosSinColor.get(i).getColor() != 0) {
					nodos[nodosSinColor.get(i).getNodo()] = nodosSinColor.remove(i);
					i--;
				}
			}
		}
		return new SolColoreo(nodos, color);
	}
}
