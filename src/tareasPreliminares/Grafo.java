package tareasPreliminares;

public class Grafo {
	
	private int cantNodos;
	private int cantAristas;
	private double porcentajeAdy;
	private int grMax;
	private int grMin;
	private MatrizSimetrica ms;
	
	public Grafo(int cantNodos, int cantAristas, double porcentajeAdy, int grMax, int grMin, MatrizSimetrica ms) {
		this.cantNodos = cantNodos;
		this.cantAristas = cantAristas;
		this.porcentajeAdy = porcentajeAdy;
		this.grMax = grMax;
		this.grMin = grMin;
		this.ms = ms;
	}
	
	public int getCantNodos() {
		return cantNodos;
	}
	
	public int getCantAristas() {
		return cantAristas;
	}
	
	public double getPorcentajeAdy() {
		return porcentajeAdy;
	}
	
	public int getGrMax() {
		return grMax;
	}
	
	public int getGrMin() {
		return grMin;
	}
	
	public MatrizSimetrica getMs() {
		return ms;
	}
	public void mostrarMatriz() {
		for(int i=0;i<this.ms.getVector().length;i++) {
			System.out.println(this.ms.getVector()[i]);
		}
	}
}
