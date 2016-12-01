
public class Frontier implements Comparable<Frontier> {
	private double fScore;
	private String path;
	private Vertex no;
	
	public Frontier(Vertex v, double d){
		path = "";
		fScore= d;
		no = v;
	}
	
	public void setScore(double d){
		fScore = d;
	}
	
	public double getScore(){
		return fScore;
	}
	
	public Vertex getVertex(){
		return no;
	}
	
	public boolean equals(Frontier f){
		if(no.getId() == f.getVertex().getId())
			return true;
		else
			return false;
	}
	
	public void incPath(String p){
		path += p;
	}
	
	public String getPath(){
		return path;
	}
	
	@Override
	public int compareTo(Frontier f){
		int res = (int) Math.round(fScore - f.getScore());
		return res;
	}
}
