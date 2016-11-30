import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Classe para testes
public class Main {

	public static void main(String[] args) {
		
		String path = "X:\\UFPB\\P7\\IA\\PROJETO IA\\IAProjetoFinal\\src\\";
		
		Graph g = new Graph();
		g.loadGraphData(path + "graph.txt");
		g.loadHeuristicMatrix(10, path + "h.txt");
		
		AEstrela executor = new AEstrela(g);
		String saida = executor.search(g.searchVertex(0), g.searchVertex(9));
		
		System.out.println(saida);
	}

}
