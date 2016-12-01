
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

//strategy de IAlgoritmoDeBusca
public class AEstrela implements IAlgoritmoDeBusca {
	
	Graph grafo;
	
	public AEstrela(Graph grafo){
		this.grafo = grafo;
	}
	
	/*
	public String search(Vertex noIni, Vertex noFin, int hour) {
		
		TreeSet<Frontier> openSet = new TreeSet<Frontier>();
		HashSet<String> closedSet = new HashSet<String>();
		double tentative_gScore;
		Frontier current;
		String path = null;
		
		openSet.add(new Frontier(noIni, 0));
		
		while(openSet.size() != 0){			
			
			current = openSet.first();
			current.incPath(current.getVertex().getName());
			
			if(current.getVertex().getId() == noFin.getId()){
				path = current.getPath();
				break;
			}
			
			openSet.remove(current);
			closedSet.add(current.getVertex().getName());
			
			for(Edge edge: grafo.getExitingEdges(current.getVertex())){
				Vertex v = grafo.searchVertex(edge.getDestination());
				System.out.println(v.getName());
				if(isContained(closedSet, v.getName())){
					continue;
				}else{
					tentative_gScore = current.getScore() + edge.getHour(hour);
					Frontier next = new Frontier(v,tentative_gScore);
					
					if(!openSet.contains(next)){
						next.incPath(current.getPath() + "->");
						openSet.add(next);
					}
						
				}
					
			}
		}
		
		return path;
	}
	
	*/
	
	
	
	
	
	
	@Override
	public String search(Vertex noIni, Vertex noFin, int hour) {
		LinkedList<Frontier> openSet = new LinkedList<Frontier>();
		ArrayList<Vertex> closedSet = new ArrayList<Vertex>();
		openSet.addFirst(new Frontier(noIni, 0));
		
		while(openSet.size() != 0){
				
			Frontier current = openSet.getFirst();
			closedSet.add(current.getVertex());
			
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
					nova.incPath(current.getPath() + "->");
					openSet.add(nova);
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
}

