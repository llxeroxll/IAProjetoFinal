import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int v;
	private int e;
	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;
	
	public Graph(){
		v = 0;
		e = 0;
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public void addVertex(String id){
		Vertex vertex = new Vertex(id);
		this.v++;
		vertexes.add(vertex);
	}
	
	public Vertex searchVertex(String id){
		return null;//todo
	}
	
	public void addEdge(String origin, String destination, double value){
		Edge edge = new Edge(origin, destination, value);
		this.e++;
		edges.add(edge);
		searchVertex(origin).addEdge(edge);
		
	}
	
	public ArrayList<Edge> getExitingEdges(Vertex vertex){
		return null; //todo
	}
	
	public ArrayList<Edge> getVisitingEdges(Vertex vertex){
		return null;//todo
	}
	
	public void removeEdge(Edge edge){
		edges.remove(edge);
	}
	
	public void updateEdge(String id1, String id2, double newValue){
		for(Edge edge: edges){
			if(edge.getOrigin() == id1 && edge.getDestination() == id2){
				edge.setValue(newValue);
				break;
			}
		}
	}
	
	public void removeVertex(Vertex vertex){
		
		for(Edge edge: getExitingEdges(vertex)){
			searchVertex(edge.getDestination()).removeEdge(edge);
			removeEdge(edge);
		}
		
		for(Edge edge: getVisitingEdges(vertex)){
			searchVertex(edge.getOrigin()).removeEdge(edge);
			removeEdge(edge);
		}
			
	}
	
	
}
