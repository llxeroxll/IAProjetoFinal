import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> edges;
	private String id;
	
	public Vertex(String id){
		this.id = id;
		edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge edge){
		edges.add(edge);
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}

	public void removeEdge(Edge edge){
		edges.remove(edge);
	}
	
	public String getId(){
		return id;
	}
	
}
