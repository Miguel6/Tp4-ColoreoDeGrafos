package tareasPreliminares;


public class CalculosArchivoIn {
	
	public double porcentajeAdyacencia(int cantAristas, int cantNodos) {
		return ((double)cantAristas / ((cantNodos * (cantNodos - 1)) / 2))*100;
	}
	
}
