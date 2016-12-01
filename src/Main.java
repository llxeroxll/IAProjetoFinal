import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Classe para testes
public class Main {

	public static void main(String[] args) {
		
		String path = "C:\\Coisas\\IAProjetoFinal\\src\\";
		
		Graph graph = new Graph();
		graph.loadGraphData(path + "graph.txt");
		graph.loadHeuristicMatrix(10, path + "h.txt");
		
		LearningAlgorithm l = new LearningAlgorithm();
		l.Learn(graph, path + "training.txt");
		
		Greedy executor = new Greedy(graph);
		String saida = executor.search(graph.searchVertex(0), graph.searchVertex(9), 0);
		
		System.out.println(saida);
	}

}
