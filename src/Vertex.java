import java.util.ArrayList;

public class Vertex {
	private ArrayList<Edge> edges;
	private int id;
	private String name;
	
	public Vertex(int id, String name){
		this.id = id;
		this.name = name;
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
	
	public int getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
