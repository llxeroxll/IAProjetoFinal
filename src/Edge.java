
public class Edge {
	private int origin;
	private int destination;
	private double value;
	
	public Edge(int o,int d, double v){
		origin = o;
		destination = d;
		value = v;
	}

	public int getOrigin() {
		return origin;
	}

	public int getDestination() {
		return destination;
	}


	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
