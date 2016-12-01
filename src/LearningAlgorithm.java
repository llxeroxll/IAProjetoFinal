import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LearningAlgorithm implements ILearningAlgorithm {
	
	public void Learn(Graph graph, String file){
		try{
			FileReader arq = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String[] data;
			String line;
			
			line = lerArq.readLine();
			while(line != null){
				data = line.split(";"); // origin;destination;hour;value
				graph.updateEdge(Integer.parseInt(data[0]), 
								 Integer.parseInt(data[1]), 
								 Integer.parseInt(data[2]),
								 Double.parseDouble(data[3]));
			}
			
			
		}catch(IOException e){
			
		}
	}
}
