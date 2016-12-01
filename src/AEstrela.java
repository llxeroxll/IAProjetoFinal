
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

		while(!(noAux.getId() == noFin.getId())){
			System.out.println("Inicial: "+ noAux.getId() + "\tFinal: " + noFin.getId());
			//System.out.println("entrou no while");
			resultado += " -> ";
			menorVal = Double.MAX_VALUE;
			distLocal = 0;

			for (Edge e : noAux.getEdges()) {
				
				//System.out.println("entrou no for");
				if(grafo.getEclidDist(e.getDestination(), noFin.getId()) < 0) {
					continue;
				}

				distHeuristica = 0;
				distHeuristica = grafo.getEclidDist(e.getDestination(), noFin.getId());
				distHeuristica += e.getHour(hour);

				if(distHeuristica <= menorVal){
					//System.out.println("entrou no if");
					menorVal = distHeuristica;
					distLocal = e.getHour(hour);
					noAux = grafo.searchVertex(e.getDestination());
				}
			}

			distancia += distLocal;
			resultado += noAux.getName();

		}
		resultado += "\nDistancia Total: " + distancia;
		return resultado;
	}

}
