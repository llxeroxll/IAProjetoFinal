
public class Edge {
	private String origin;
	private String destination;
	private double value;
	
	public Edge(String o,String d, double v){
		origin = o;
		destination = d;
		value = v;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}


	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
