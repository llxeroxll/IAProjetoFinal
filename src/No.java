import java.util.HashMap;

public class No {
	private HashMap<No, Integer> NosAdjacentes;
	private String id;
	
	
	public HashMap<No, Integer> getNosAdjacentes() {
		return NosAdjacentes;
	}
	public void setNosAdjacentes(HashMap<No, Integer> nosAdjacentes) {
		NosAdjacentes = nosAdjacentes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void addNoAdjacente(No no, int peso){
		NosAdjacentes.put(no, peso);
	}
	
}
