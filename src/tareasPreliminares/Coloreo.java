package tareasPreliminares;

import java.util.ArrayList;
import java.util.LinkedList;

import nodo.Nodo;

public abstract class Coloreo {
	
	public static SolColoreo secuencial(Grafo grafo){
		
		LinkedList<Integer> coloresProhibidos = new LinkedList<Integer>();
		
		ArrayList<Integer> coloresEnUso = new ArrayList<Integer>();
		
		Nodo[] nodos = new Nodo[grafo.getCantNodos()];

		for(int i = 0 ; i < nodos.length; i++){		//recorre los nodos del vector para colorearlos
			nodos[i] = new Nodo(i);
			for(int j = 0 ; j < i ; j++){	//recorre los nodos ya coloreados
				System.out.println(i + ","+j+" ----> " + grafo.getMs().getValIJ(i, j) ); //-------------------------->
				if(grafo.getMs().getValIJ(i, j)){	//si son adyacentes descarta el color 
					coloresProhibidos.add(nodos[j].getColor());
				}
			}
			//recorre lista de colores prohibidos
			System.out.println("colo en uso : " + coloresEnUso.size() );	//--------------------------------------->
			for(int k = 0 ; (nodos[i].getColor() == 0)  &&  (k < coloresEnUso.size()) ; k++){ 
				if( ! coloresProhibidos.contains(k+1)){
					nodos[i].setColor(k+1);
				}
			}
			if(nodos[i].getColor() == 0){	//si todos los colores estan prohibidos pinta con un color nuevo
				nodos[i].setColor(coloresEnUso.size() +1);
				coloresEnUso.add(coloresEnUso.size() + 1);
			}
			coloresProhibidos.clear();	//limpia la lista de colores prohibidos para que el proximo nodo la utilice
		}

		return new SolColoreo(nodos, coloresEnUso.size());	//retorna los nodos y el numero minimo de colores encontrado.	
	}
}
