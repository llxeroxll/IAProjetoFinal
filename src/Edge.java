
public class Edge {
	private int origin;
	private int destination;
	private Day day;
	
	public Edge(int o,int d){
		origin = o;
		destination = d;
		day = new Day();
	}

	public int getOrigin() {
		return origin;
	}

	public int getDestination() {
		return destination;
	}


	public double getHour(int hour) {
		return day.getHour(hour);
	}

	public void setHour(double value, int hour) {
		day.setHour(value, hour);
	}
	
	
	
}
