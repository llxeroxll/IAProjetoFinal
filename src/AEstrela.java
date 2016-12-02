
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

//strategy de IAlgoritmoDeBusca
public class AEstrela implements IAlgoritmoDeBusca {
	
	Graph grafo;
	
	public AEstrela(Graph grafo){
		this.grafo = grafo;
	}
		
	
	@Override
	public String search(Vertex noIni, Vertex noFin, int hour) {
		Vertex noAux = noIni;
		double distancia = 0;
		double distLocal;
		double menorVal;
		double distHeuristica;
		String resultado = noIni.getName();
		
		Stack<Integer> nogo = new Stack<Integer>();
		Stack<Integer> path = new Stack<Integer>();
		
		while(!(noAux.getId() == noFin.getId())){
			resultado += " -> ";
			menorVal = Double.MAX_VALUE;
			distLocal = 0;
			
			path.push(noAux.getId());
//			System.out.println("Adding " + noAux.getId());
			for (Edge e : noAux.getEdges()) {

				if(nogo.search(e.getDestination()) != -1 || path.search(e.getDestination()) != -1) {
					continue;
				}

				distHeuristica = 0;
				distHeuristica = grafo.getEclidDist(e.getDestination(), noFin.getId());
				distHeuristica += e.getHour(hour);

				if(distHeuristica < menorVal){
					menorVal = distHeuristica;
					distLocal = e.getHour(hour);
					noAux = grafo.searchVertex(e.getDestination());
				}
			}
			
			if(path.peek() == noAux.getId()){
//				System.out.println("Banning " + noAux.getId());
//				System.out.println("path: " + Arrays.toString(path.toArray()));
//				System.out.println("nogo: " + Arrays.toString(nogo.toArray()));
				nogo.push(noAux.getId());
				path.pop();
				noAux = grafo.searchVertex(path.pop());
			}

			distancia += distLocal;
			
		}
		
		Stack<Integer> pathAux = new Stack<Integer>();

		resultado = noAux.getName();
		pathAux.push(noAux.getId());
		
		while(!path.isEmpty()) {
			pathAux.push(path.peek());
			resultado = grafo.searchVertex(path.pop()).getName() + " -> " + resultado;
		}
		
		
		distancia = 0;
		int auxId = 0;
		
		if(!pathAux.isEmpty()){
			auxId = pathAux.pop();
		}
		
		while(!pathAux.isEmpty()){
			distancia += grafo.getEdgeValue(auxId, pathAux.peek(), hour);
			auxId = pathAux.pop();
		}
		
		
		
		
		resultado += "\nTempo Total: " + distancia;
		return resultado;
	}

}

