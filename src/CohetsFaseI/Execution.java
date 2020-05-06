package CohetsFaseI;

import java.util.ArrayList;
import java.util.Scanner;

public class Execution {

	static ArrayList<Rockets> fleet= new ArrayList <Rockets>();
	 
	public  static void main(String[] args) {
		fleet.add(fleet.size(),new Rockets("x", 3));
		fleet.add(fleet.size(),new Rockets("LDSFJA32", 6));
		Entry();
	}

	private static void Entry() {
		@SuppressWarnings("resource")
		Scanner dataEntry = new Scanner(System.in);
		System.out.println("What do you want to do? 1-JOIN A NEW ROCKET  2-SEE THE FLEET");
		int enterOption=dataEntry.nextInt();
		switch (enterOption) {
		case 1:
			NewRocket();
			Entry();
			
		case 2:
			RocketData();
			Entry();
			
		default:
			Entry();
		}
	}

	@SuppressWarnings("resource")
	private static void NewRocket() {
		
		Scanner dataEntry = new Scanner(System.in);
		System.out.println("Type the name of the new Rocket?");
		String name=dataEntry.nextLine();
		System.out.println("Type the number of thrusters of the new Rocket?");
		int thrusters=dataEntry.nextInt();
		System.out.println("The new rocket called "+ name+", equipped with "+ thrusters+" thrusters, is already created.");
		fleet.add(new Rockets (name,thrusters));
	}
	
		
	public static  String RocketData() {
		for (int i=0; i<fleet.size();i++) {
			Rockets e=fleet.get(i);
			System.out.println("The rocket name is " + e.getName() + " and this rocket has " + e.getThrusters()  + " thrusters.");
		}
		return null;
	}
}
