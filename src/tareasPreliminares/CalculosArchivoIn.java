package tareasPreliminares;

import java.util.HashMap;
import java.util.LinkedList;

import nodo.Arista;

public abstract class CalculosArchivoIn {

	public static double porcentajeAdyacencia(int cantAristas, int cantNodos) {
		return cantAristas / ((cantNodos * (cantNodos - 1)) / 2);
	}

	public static int gradoMinimo(LinkedList<Arista> listaAristas) {
		int min = 0;

		HashMap<Integer, Integer> mapaNodos = new HashMap<Integer, Integer>();

		for (Arista aristaActual : listaAristas) {

			if (!mapaNodos.containsKey(aristaActual.getOrigen())) {
				mapaNodos.put(aristaActual.getOrigen(), 1);
			} else {
				mapaNodos.put(aristaActual.getOrigen(), mapaNodos.get(aristaActual.getOrigen()) + 1);
			}
			if (!mapaNodos.containsKey(aristaActual.getDestino())) {
				mapaNodos.put(aristaActual.getDestino(), 1);
			} else {
				mapaNodos.put(aristaActual.getDestino(), mapaNodos.get(aristaActual.getDestino()) + 1);
			}
		}

		for (Integer key : mapaNodos.keySet()) {
			if (mapaNodos.get(key) < min || min == 0) {
				min = mapaNodos.get(key);
			}
		}
		return min;
	}

	public static int gradoMaximo(LinkedList<Arista> listaAristas) {
		int max = 0;

		HashMap<Integer, Integer> mapaNodos = new HashMap<Integer, Integer>();

		for (Arista aristaActual : listaAristas) {

			if (!mapaNodos.containsKey(aristaActual.getOrigen())) {
				mapaNodos.put(aristaActual.getOrigen(), 1);
			} else {
				mapaNodos.put(aristaActual.getOrigen(), mapaNodos.get(aristaActual.getOrigen()) + 1);
			}
			if (!mapaNodos.containsKey(aristaActual.getDestino())) {
				mapaNodos.put(aristaActual.getDestino(), 1);
			} else {
				mapaNodos.put(aristaActual.getDestino(), mapaNodos.get(aristaActual.getDestino()) + 1);
			}
		}

		for (Integer key : mapaNodos.keySet()) {
			if (mapaNodos.get(key) > max) {
				max = mapaNodos.get(key);
			}
		}
		return max;
	}
}
