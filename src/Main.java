import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Classe para testes
public class Main {

	public static void main(String[] args) {
		
		String path = "X:\\UFPB\\P7\\IA\\PROJETO IA\\IAProjetoFinal\\src\\";
		String pathTraining = "X:\\UFPB\\P7\\IA\\PROJETO IA\\IAProjetoFinal\\src\\Treinos\\";
		
		Graph graph = new Graph();
		graph.loadGraphData(path + "graph.txt");
		graph.loadHeuristicMatrix(13, path + "h.txt");
		
		LearningAlgorithm l = new LearningAlgorithm();
		//l.Learn(graph, path + "training.txt");
		
		for(int i = 1; i < 21; i++){
			//System.out.println(i);
			l.Learn(graph, pathTraining + "Treino" + i + ".txt");
		}
				
		
		
		AEstrela executor = new AEstrela(graph);
//		Greedy executor = new Greedy(graph);
		String saida = executor.search(graph.searchVertex(0), graph.searchVertex(6), 6);
		
		System.out.println(saida);
	}

}
