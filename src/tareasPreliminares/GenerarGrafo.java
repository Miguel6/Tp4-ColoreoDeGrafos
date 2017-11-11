package tareasPreliminares;

/**
 * Clase encargada de generar Grafo Aleatorio dado una probabilidad.
 * @author Los Tres Mosqueteros
 */
public class GenerarGrafo {

	private MatrizSimetrica ms;
	private int cantNodos;

	public GenerarGrafo(int cantNodos) {
		this.ms = new MatrizSimetrica(cantNodos);
		this.cantNodos = cantNodos;
	}

	/**
	 * Punto 2 del TP:
	 * Generar un grafo aleatorio dado N nodos y una prob para Cada Arista
	 * 
	 * @param probXArista Probabilidad de la arista entre 0 y 1
	 * @throws AristaException Excepcion a lanzar.
	 */
	public void generarAristas(double probXArista) throws AristaException {
		if (probXArista > 1 || probXArista < 0) {
			throw new AristaException("Ingrese una probabilidad entre 0 y 1");
		}
		// Calculo la los nodos que van a ir dependiendo de la probabilidad
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < this.cantNodos; j++) {
				/**
				 * Usa el complemento porque sino con por Ej: 0.7, era
				 * un 70% que no iba a salir.
				 */
				if (Math.random() >= 1 - probXArista) {
					this.ms.setIJ(i, j);
				}
			}
		}
	}

	/**
	 * Imprime el vector en pantalla.
	 */
	public void mostrarVector() {
		for (int i = 0; i < this.ms.getVector().length; i++) {
			System.out.println("-->" + this.ms.getVector()[i]);
		}
	}

	/**
	 * Funcion encargada de completar la matriz simetrica del Grafo
	 */
	public void completarGrafo() {
	
		
		int fil;
		int col;
		boolean estaConectado;
		for(int medio = 0; medio < this.cantNodos-1; medio++ ) {
			this.ms.setIJ(medio, medio + 1);
		}
		
		/**
		 * Tiene un problema cuando detecta un TRUE original, y al pasar eso, no une subgrafos
		 * Pasa cuando se genera un grafo con 2 Nodos originalmente
		 */
		/*
		 * Si en una columna no tengo al menos un true, significa, que ese nodo esta
		 * desconectado
		 */
//		for (int col = 1; col < this.cantNodos; col++) {
//			tieneUnaConexion = false;
//			
//			/**
//			 * Estos dos for hace una L para recorrer el triangulo superior
//			 * de la "Matriz".
//			 */
//			for (fil = 0; fil < col && !tieneUnaConexion; fil++) {
//				if (this.ms.getValIJ(fil, col)) {
//					tieneUnaConexion = true;
//				}
//			}
//			for (int i = col+1; i < this.cantNodos && !tieneUnaConexion; i++) {
//				if (this.ms.getValIJ(fil, i)) {
//					tieneUnaConexion = true;
//				}
//			}
//			if (!tieneUnaConexion) {
//				this.ms.setIJ(fil-1, col);
//			}
//		}
	}
}
