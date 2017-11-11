package tareasPreliminares;

public abstract class CalculosDeMatriz {

	public static int cantNodos(MatrizSimetrica ms) {
		return ms.getCantNodos();
	}
	
	public static double porcentajeAdyacencia(MatrizSimetrica ms) { 
		return ((double)ms.getCantAristas() / ((ms.getCantNodos()* (ms.getCantNodos()- 1)) / 2))*100;
	}
	
	public static int cantAristas(MatrizSimetrica ms) {
		return ms.getCantAristas();
	}
	
	public static int grMin(MatrizSimetrica ms) {
		int grMin = ms.getCantNodos()-1;
		int fil;
		for (int col = 1; col < ms.getCantNodos(); col++) {
			int gradActual = 0;
			for (fil = 0; fil < col; fil++) {
				if (ms.getValIJ(fil, col)) {
					gradActual++;
				}
			}
			for (int i = col+1; i < ms.getCantNodos() ; i++) {
				if (ms.getValIJ(fil, i)) {
					gradActual++;
				}
			}
			if(gradActual< grMin) {
				grMin = gradActual;
			}
		}
		return grMin;
	}
	
	public static int grMax(MatrizSimetrica ms) {
		int grMax = 0;
		int fil;
		for (int col = 1; col < ms.getCantNodos(); col++) {
			int gradActual = 0;
			for (fil = 0; fil < col; fil++) {
				if (ms.getValIJ(fil, col)) {
					gradActual++;
				}
			}
			for (int i = col+1; i < ms.getCantNodos() ; i++) {
				if (ms.getValIJ(fil, i)) {
					gradActual++;
				}
			}
			if(gradActual> grMax) {
				grMax = gradActual;
			}
		}
		return grMax;
	}
}
