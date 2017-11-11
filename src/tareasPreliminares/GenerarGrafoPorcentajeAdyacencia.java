package tareasPreliminares;

import exception.CantidadDeNodosException;
import exception.PorcentajeDeAdyacenciaException;

public class GenerarGrafoPorcentajeAdyacencia {
	
	private MatrizSimetrica ms ;
	private int cantNodos;
	private double porcentajeAdyacencia;
	public GenerarGrafoPorcentajeAdyacencia(int cantNodos, double porcentajeAdyacencia) throws CantidadDeNodosException, PorcentajeDeAdyacenciaException {
		
		if(cantNodos < 0) {
			throw new CantidadDeNodosException("Cantidad de nodos Negativa");
		}
		this.cantNodos = cantNodos;
		this.porcentajeAdyacencia = porcentajeAdyacencia;
		int cantAristasMaximas = (this.cantNodos*this.cantNodos-this.cantNodos)/2;
		int cantAristasMinimas = this.cantNodos-1;
		
		if(this.porcentajeAdyacencia<0 || this.porcentajeAdyacencia > 100) {
			throw new PorcentajeDeAdyacenciaException("Porcentaje fuera del rango 0-100");
		}
		/**
		 * el +1 es para el redondeo
		 */
		
		int cantAristasAUsar = (int)(Math.round(this.porcentajeAdyacencia*cantAristasMaximas/100));
		if(cantAristasAUsar<cantAristasMinimas) {
			throw new PorcentajeDeAdyacenciaException("Porcentaje inferior al minimo necesario para conectar todo el grafo");
		}
		ms = new MatrizSimetrica(this.cantNodos);
		
		for(int medio = 0; medio < this.cantNodos-1; medio++ ) {
			this.ms.setIJ(medio, medio + 1);
			cantAristasAUsar--;
		}
		for(int col = 2; col < this.cantNodos-1 && cantAristasAUsar > 0; col++) {
			for(int fil = 0; fil < this.cantNodos-2 && cantAristasAUsar > 0; fil++) {
				this.ms.setIJ(fil, col);
			}
		}
	}
	
	public void mostrarVector() {
		this.ms.mostrarVector();
	}
}
