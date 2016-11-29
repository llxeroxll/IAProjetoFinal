
//strategy de IAlgoritmoDeBusca
public class AEstrela implements IAlgoritmoDeBusca {

	@Override
	public String search(Vertex noIni, Vertex noFin, Graph grafo) {
		Vertex noAux = noIni;
		Double distância = 0;

		while(!noAux.getId().equals(noFin.getId())){

			for (Vertex v : noAux.getEdges()) {
				grafo.getEclidDist(v.getId(), v.)
			}


		}


		return null;
	}

}
