package nodo;

public class Nodo {

	private int origen;
	private int destino;

	public Nodo(int origen, int destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public int getOrigen() {
		return this.origen;
	}

	public int getDestino() {
		return this.destino;
	}

}
