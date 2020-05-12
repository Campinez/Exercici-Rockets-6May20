package CohetsFaseII;

import java.util.ArrayList;

public class RocketsFaseII {

	private  String name;
	private int thrusterNumber;
	ArrayList<ThrustersFaseII> thrustersList= new ArrayList <ThrustersFaseII>();
	
	public RocketsFaseII(String name, int thrusterPower) {//Constructor
		
		this.name=name;
		this.thrusterNumber=thrusterPower;
		ArrayList<ThrustersFaseII> thrustersList= new ArrayList <ThrustersFaseII>();
	}

	
	public String getName() {
		return name;
	
	}

	public int getThrustersNumber() {
		
		return thrusterNumber;
	}
	
	public ArrayList<ThrustersFaseII> getThrustersList() {
		return thrustersList;
	}
}

