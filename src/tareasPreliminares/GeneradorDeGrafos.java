package tareasPreliminares;

import exception.AristaException;
import exception.GrafoException;
import exception.PorcentajeDeAdyacenciaException;
public class GeneradorDeGrafos {
	private final int cantNodos;
	private MatrizSimetrica ms;

	public GeneradorDeGrafos(int cantNodos) throws GrafoException {
		if (cantNodos < 0) {
			throw new GrafoException("Cantidad de nodos Negativa");
		}
		this.cantNodos = cantNodos;
	}

	public Grafo GenerarGrafoProbXArista(double probXArista) throws AristaException {
		this.ms = new MatrizSimetrica(cantNodos);
		if (probXArista > 1 || probXArista < 0) {
			throw new AristaException("Ingrese una probabilidad entre 0 y 1");
		}
		// Calculo la los nodos que van a ir dependiendo de la probabilidad
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < this.cantNodos; j++) {
				/**
				 * Usa el complemento porque sino con por Ej: 0.7, era un 70% que no iba a
				 * salir.
				 */
				if (Math.random() >= 1 - probXArista) {
					this.ms.setIJ(i, j);
				}
			}
		}
		for (int medio = 0; medio < this.cantNodos - 1; medio++) {
			this.ms.setIJ(medio, medio + 1);
		}
		return new Grafo(this.cantNodos, this.ms.getCantAristas(), CalculosDeMatriz.porcentajeAdyacencia(this.ms),
				CalculosDeMatriz.grMax(ms), CalculosDeMatriz.grMin(ms), ms);
	}

	public Grafo GenerarGrafoPorcentajeAdyacencia(double porcentajeAdyacencia)
			throws GrafoException, PorcentajeDeAdyacenciaException {
		if (porcentajeAdyacencia < 0 || porcentajeAdyacencia > 100) {
			throw new PorcentajeDeAdyacenciaException("Porcentaje fuera del rango 0-100");
		}

		this.ms = new MatrizSimetrica(this.cantNodos);
		int cantAristasMaximas = (this.cantNodos * this.cantNodos - this.cantNodos) / 2;
		int cantAristasMinimas = this.cantNodos - 1;

		/**
		 * el +1 es para el redondeo
		 */
		int cantAristasAUsar = (int) (Math.round(porcentajeAdyacencia * cantAristasMaximas / 100));
		int cantAristas = cantAristasAUsar;
		if (cantAristasAUsar < cantAristasMinimas) {
			throw new PorcentajeDeAdyacenciaException(
					"Porcentaje inferior al minimo necesario para conectar todo el grafo");
		}
		ms = new MatrizSimetrica(this.cantNodos);

		for (int medio = 0; medio < this.cantNodos - 1; medio++) {
			this.ms.setIJ(medio, medio + 1);
			cantAristasAUsar--;
		}
		for (int col = 2; col < this.cantNodos - 1 && cantAristasAUsar > 0; col++) {
			for (int fil = 0; fil < this.cantNodos - 2 && cantAristasAUsar > 0; fil++) {
				this.ms.setIJ(fil, col);
			}
		}
		return new Grafo(this.cantNodos, cantAristas, porcentajeAdyacencia, CalculosDeMatriz.grMax(ms),
				CalculosDeMatriz.grMin(ms), ms);
	}

	private void setADistancia(int cantidadVeces, int distancia) {
		for(int i=0;i<cantidadVeces;i++) {
			this.ms.setIJ(i, (i + distancia)%cantidadVeces);
		}
	}
	public Grafo generarGrafoConGrado(int grado) throws GrafoException {
		if (grado >= cantNodos || grado < 0)
			throw new GrafoException(" grado invalido");
		this.ms = new MatrizSimetrica(cantNodos);

		if (this.cantNodos % 2 == 0) { // par
			if (grado % 2 == 1) {
				if(grado == 1 && this.cantNodos!=2) {
					throw new GrafoException("Grado 1 imposible de hacer, no genera un UNICO grafo conexo");
				}
				for(int i=0;i<grado;i++) {
					setADistancia(this.cantNodos, i+1);
				}
			} else {//HECHO
				//grado par
				for(int i=0;i<grado/2;i++) {
					setADistancia(this.cantNodos, i+1);
				}
			}
		} else { // impar
			//HECHO
			if (grado % 2 == 1)
				throw new GrafoException("Grado Impar con cantidad de nodos impar, imposible construir");
			for(int i=0;i<grado/2;i++) {
				setADistancia(this.cantNodos, i+1);
			}

		}
		return new Grafo(this.cantNodos, this.ms.getCantAristas(), CalculosDeMatriz.porcentajeAdyacencia(this.ms),
				CalculosDeMatriz.grMax(this.ms), CalculosDeMatriz.grMin(this.ms), this.ms);
	}
}
