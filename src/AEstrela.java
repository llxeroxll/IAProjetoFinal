
//strategy de IAlgoritmoDeBusca
public class AEstrela implements IAlgoritmoDeBusca {

	@Override
	public String search(Vertex noIni, Vertex noFin, Graph grafo) {
		Vertex noAux = noIni;
		double distância = 0;
		double distanciaLocal;
		double menorVal;
		double distHeuristica;
		String resultado = noIni.getId() + ";";

		while(!noAux.getId().equals(noFin.getId())){

			menorVal = Double.MAX_VALUE;
			distanciaLocal = 0;

			for (Edge e : noAux.getEdges()) {

				if(grafo.getEclidDist(e.getDestination(), noFin.getId() < 0) {
					continue;
				}

				distHeuristica = 0;
				distHeuristica = grafo.getEclidDist(e.getDestination(), noFin.getId());
				distHeuristica += e.getValue();

				if(distHeuristica < menorVal){
					menorVal = distHeuristica;
					distLocal = e.getValue();
					noAux = grafo.searchVertex(e.getDestination());
				}
			}

			distancia += distLocal;
			resultado += noAux.getId();

		}

		return resultado;
	}

}
