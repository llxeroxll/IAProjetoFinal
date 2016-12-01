import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int v;
	private int e;
	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;
	
	
	// função heuristica
	private double[][] heuristicMatrix;
	
	public void loadHeuristicMatrix(int numOfVertexes, String file){
		heuristicMatrix = new double [numOfVertexes][numOfVertexes];
		
		try {
			FileReader arq = new FileReader(file);
		    BufferedReader lerArq = new BufferedReader(arq);
		 
		    String linha; // lê a primeira linha
		    String[] numbers;
		    for(int i =0; i < numOfVertexes; i++){
		    	linha = lerArq.readLine(); // lê da segunda até a última linha
		    	numbers = linha.split(";");
		    	for(int j = 0; j<numOfVertexes; j++){
		    		heuristicMatrix[i][j] =  Double.parseDouble(numbers[j]);
		    	}
		    }
		    	arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		        e.getMessage());
		    }
				
	}
	
	public int getV(){
		return v;
	}
	
	public double getEclidDist(int no1, int no2){
		return heuristicMatrix[no1][no2];
	}
	// fim função heuristica
	
	public Graph(){
		v = 0;
		e = 0;
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public void addVertex(int id, String name){
		Vertex vertex = new Vertex(id, name);
		this.v++;
		vertexes.add(vertex);
	}
	


	public Vertex searchVertex(int id){
		for(Vertex v: vertexes){
			if(id == v.getId())
				return v;
		}
		return null;
	}
	
	public Edge addEdge(int origin, int destination){
		Edge edge = new Edge(origin, destination);
		this.e++;
		edges.add(edge);
		searchVertex(origin).addEdge(edge);
		return edge;
		
	}
	
	public ArrayList<Edge> getExitingEdges(Vertex vertex){
		return vertex.getEdges();
	}
	
	public ArrayList<Vertex> getNeighbors(Vertex vertex){
		ArrayList<Edge> edges = getExitingEdges(vertex);
		ArrayList<Vertex> retorno = new ArrayList<Vertex>();
		for(Edge edge: edges){
			retorno.add(searchVertex(edge.getDestination()));
		}
		return retorno;
	}
	
	public ArrayList<Edge> getVisitingEdges(Vertex vertex){
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(Edge e: edges){
			if(e.getDestination() == vertex.getId()){
				ret.add(e);
			}
		}
		return ret;
	}
	
	public void removeEdge(Edge edge){
		edges.remove(edge);
		e--;
	}
	
	public void updateEdge(int id1, int id2, int hour, double newValue){
		for(Edge edge: edges){
			if(edge.getOrigin() == id1 && edge.getDestination() == id2){
				edge.setHour(newValue, hour);
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
		v--;
	}
	
	public void loadGraphData(String file){
		
		try {
			FileReader arq = new FileReader(file);
		    BufferedReader lerArq = new BufferedReader(arq);
		 
		    String linha = lerArq.readLine(); // lê a primeira linha
		    int numberOfVertexes = Integer.parseInt(linha);
		    
		    String[] data;
		    
		    for(int i = 0; i < numberOfVertexes; i++){
		    	linha = lerArq.readLine();
		    	addVertex(i, linha);
		    }
		    linha = lerArq.readLine();
		    while(linha != null){
		    	data = linha.split(";");
		    	addEdge(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
		    	linha = lerArq.readLine();
		    }
		    
		    
		    	arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		        e.getMessage());
		    }
		
	}
	
}
