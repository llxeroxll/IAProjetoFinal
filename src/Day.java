
public class Day {
	private double[][] hours;
	
	public Day(){
		hours = new double[24][2];
		for(int i = 0; i < 24; i++){
			hours[i][0] = Double.MAX_VALUE;
			hours[i][1] = 0;
		}
	}
	
	public void setHour(double value, int hour){
		hours[hour][0] = (hours[hour][0]*hours[hour][1] + value)/(++hours[hour][1] );
	}
	
	public double getHour(int hour){
		return hours[hour][0];
	}
}
