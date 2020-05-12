package CohetsFaseII;

public class ThrustersFaseII {

	private int idThruster;
	private  int powerMaxThruster;
	private int powerActuallyThruster;
	
	public ThrustersFaseII(int idThruster, int powerMaxThruster) {
		this.idThruster=idThruster;
		this.powerMaxThruster=powerMaxThruster;
		this.powerActuallyThruster=0;
		
	}

	
	public synchronized  void setPowerMaxThruster(int powerMaxThruster) {
		this.powerActuallyThruster = powerMaxThruster;
	}


	public int getPowerActuallyThruster() {
		return powerActuallyThruster;
	}




	public int getIdThruster() {
		return idThruster;
	}

	public   int getPowerMax (){
		return powerMaxThruster;
	}



}

 
		

