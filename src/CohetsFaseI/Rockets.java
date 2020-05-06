package CohetsFaseI;

public class Rockets {
	
	private  String name;
	private  int thrusters;
	
	public Rockets(String name, int thrusters) {//Constructor
		
		this.name=name;
		this.thrusters=thrusters;
	}

	public String getName() {
		return name;
	}
	public int getThrusters() {
		return thrusters;
	}
	
}
