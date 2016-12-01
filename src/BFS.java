import java.util.ArrayList;
import java.util.LinkedList;

public class BFS implements IAlgoritmoDeBusca {
	
	Graph grafo;
	
	public BFS(Graph grafo){
		this.grafo = grafo;
	}		
	
	
	@Override
	public String search(Vertex noIni, Vertex noFin, int hour) {
		LinkedList<Frontier> openSet = new LinkedList<Frontier>();
		ArrayList<Vertex> closedSet = new ArrayList<Vertex>();
		openSet.addFirst(new Frontier(noIni, 0));
		
		while(openSet.size() != 0){
				
			Frontier current = openSet.getFirst();
			closedSet.add(current.getVertex());
			openSet.removeFirst();
			
			current.incPath(current.getVertex().getName());
			
			if(current.getVertex().getId() == noFin.getId()){
				return  current.getPath();
			}
			
			for(Edge e: grafo.getExitingEdges(current.getVertex())){
				Vertex v = grafo.searchVertex(e.getDestination());
				
				if(isContained(closedSet, v.getId())){
					continue;
				}else{
					Frontier nova = new Frontier(v, current.getScore() + e.getHour(hour));
					
					if(  !(isContained2(openSet, v.getId()))   ){	
						nova.incPath(current.getPath() + "->");
						openSet.add(nova);
					}
				}	
			}
			
		}
		return null;
	}
	
	private boolean isContained(ArrayList<Vertex> closedSet, int id){
		for(Vertex v: closedSet ){
			if(v.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	private boolean isContained2(LinkedList<Frontier> openSet, int id){
		for(Frontier v: openSet ){
			if(v.getVertex().getId() == id){
				return true;
			}
		}
		return false;
	}
}
