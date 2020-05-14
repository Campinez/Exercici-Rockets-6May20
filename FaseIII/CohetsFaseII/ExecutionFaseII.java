package CohetsFaseII;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExecutionFaseII {
	static ArrayList<RocketsFaseII> fleet= new ArrayList <RocketsFaseII>();
	
	public  static void main(String[] args) {
		//Instancio primer cohete
		RocketsFaseII first=new RocketsFaseII("LDSFJA32",3);
		fleet.add(fleet.size(),first);
		ThrustersFaseII one= new ThrustersFaseII(2,80);
		first.thrustersList.add(0, one);
		ThrustersFaseII two= new ThrustersFaseII(1,30);
		first.thrustersList.add(0, two);
		ThrustersFaseII three= new ThrustersFaseII(0,10);
		first.thrustersList.add(0, three);
		//Instancio segundo cohete y propulsores
		RocketsFaseII second=new RocketsFaseII(" ",6);
		fleet.add(fleet.size(),second);
		ThrustersFaseII one2= new ThrustersFaseII(5,10);
		second.thrustersList.add(0, one2);
		ThrustersFaseII two2= new ThrustersFaseII(4,30);
		second.thrustersList.add(0, two2);
		ThrustersFaseII three2= new ThrustersFaseII(3,50);
		second.thrustersList.add(0, three2);
		ThrustersFaseII four2= new ThrustersFaseII(2,50);
		second.thrustersList.add(0, four2);
		ThrustersFaseII five2= new ThrustersFaseII(1,40);
		second.thrustersList.add(0, five2);
		ThrustersFaseII six2= new ThrustersFaseII(0,30);
		second.thrustersList.add(0, six2);

//Primera Ejecución menú inicio
		try {
			Scanner dataEntry = new Scanner(System.in);
			System.out.println("What do you want to do? 1-JOIN A NEW ROCKET  2-SEE THE FLEET  3-SEE ROCKET DATA AND POWER  4-SET POWER OF A ROCKET");
			int enterOption=dataEntry.nextInt();
			switch (enterOption) {
				case 1:
					NewRocket();
					Entry();
			
				case 2:
					RocketData();
					Entry();
				case 3:
					SeeRocketPower();
					Entry();
				case 4:
					SetPower();
					Entry();
				default:
					return;
			}
		}catch(IndexOutOfBoundsException e ){
			System.out.println("Wrong option!!");
			return;
		}
		
		
	}
	
	//Menu inicio en método
	public static void Entry() {
		
		try {
			Scanner dataEntry = new Scanner(System.in);
			System.out.println("What do you want to do? 1-JOIN A NEW ROCKET  2-SEE THE FLEET  3-SEE ROCKET DATA AND POWER  4-SET POWER OF A ROCKET");
			int enterOption=dataEntry.nextInt();
			switch (enterOption) {
				case 1:
					NewRocket();
					Entry();
			
				case 2:
					RocketData();
					Entry();
				case 3:
					SeeRocketPower();
					Entry();
				case 4:
					SetPower();
					Entry();
				default:
					return;
			}
		}catch(IndexOutOfBoundsException e ){
			System.out.println("Wrong option!!");
			return;
		}
		
	}


//Método para variar velocidad propulsores( Pantallazo de datos (Cohete y cantidad propulsores), elección cohete y acelerar o frenar		
		protected  static void SetPower()throws InputMismatchException  {
				
			for (int i=0; i<fleet.size();i++) {
					RocketsFaseII e=fleet.get(i);
					System.out.println("Number "+ i + " the rocket name is " + e.getName() + " and this rocket has " + e.getThrustersNumber()  + " thrusters.");
			}try {	
				
				Scanner dataEntry = new Scanner(System.in);
				System.out.println("Type the number of rocket you want to accelerate or brake");
				int enterOption=dataEntry.nextInt();
				fleet.get(enterOption);
				RocketsFaseII e=fleet.get(enterOption);
				System.out.println("The "+ e.getName()+" rocket has "+e.getThrustersNumber()+" thrusters at current power:");
				for (int j=0;j<e.getThrustersList().size();j++) {
					ThrustersFaseII f=e.thrustersList.get(j);
					System.out.println("The maximum power of thruster "+j+" is "+f.getPowerMax()+ " and the current power is " + f.getPowerActuallyThruster());
					}
				for (int j=0;j<e.getThrustersList().size();j++) {
					ThrustersFaseII f=e.thrustersList.get(j);
					int powerDifference = 0;
					boolean action = false;
	//Recoge el nuevo valor para el propulsor designado y descarta darle una potencia por encima de la suya máxima
					System.out.println("Type the new power target of thruster "+j+" is:");
					
					int newPower=dataEntry.nextInt();
					while (newPower >f.getPowerMax()) {
						System.out.println("You're wrong. The maximum power of this thruster is "+f.getPowerMax());
						System.out.println("Type the new power target of thruster "+j+" is:");
						newPower=dataEntry.nextInt();
						
					}
					if ( f.getPowerActuallyThruster()>=newPower) {
						powerDifference= f.getPowerActuallyThruster()-newPower;
						action=false;
					}
					if ( f.getPowerActuallyThruster()<newPower) {
						powerDifference= newPower-f.getPowerActuallyThruster();
						action=true;
					}
					Runnable r= new SetThreads(enterOption, powerDifference, j, action);
						Thread t=new Thread(r);
						t.start();
				}
			}catch(InputMismatchException e ){
					System.out.println("Wrong option!!");
					SetPower();
				}
		}
//Metodo para ver cohetes con propulsores y potencia
		private static void SeeRocketPower() {
			for (int i=0; i<fleet.size();i++) {
				RocketsFaseII e=fleet.get(i);
				System.out.println("The rocket name is " + e.getName() + " and this rocket has " + e.getThrustersNumber() + " thrusters.");
				
				
				for (int j=0;j<e.getThrustersList().size();j++) {
					ThrustersFaseII f=e.thrustersList.get(j);
					System.out.println("The maximum power of thruster "+j+" is "+f.getPowerMax()+ " and the current power is " + f.getPowerActuallyThruster());
					}
				
			}
			return;
		}
		
//Metodo para instanciar nuevos cohetes
		@SuppressWarnings("resource")
		private static void NewRocket() throws InputMismatchException  {
			try {	
			
			Scanner dataEntry = new Scanner(System.in);
			System.out.println("Type the name of the new Rocket?");
			String name=dataEntry.nextLine();
			System.out.println("Type the number of thrusters of the new Rocket?");
			int thrusters=dataEntry.nextInt();
			System.out.println("The new rocket called "+ name+", equipped with "+ thrusters+" thrusters, is already created.");
			RocketsFaseII apolo= new RocketsFaseII (name,thrusters);
			for(int i=0; i<thrusters;i++) {
				System.out.println("Please, type te power of thruster number "+i+" :");
				int poweri=dataEntry.nextInt();
				ThrustersFaseII uno= new ThrustersFaseII(i,poweri);
				apolo.thrustersList.add(i, uno);
				System.out.println("The rocket "+apolo.getName()+" thruster number "+ i+" has power "+poweri);
			}
			fleet.add(fleet.size(), apolo);
			}catch(InputMismatchException e ){
				System.out.println("Wrong option!!");
			}
		}
		
//Metodo para visibilizar flota de cohetes	
		public static  String RocketData() {
			for (int i=0; i<fleet.size();i++) {
				RocketsFaseII e=fleet.get(i);
				System.out.println("The rocket name is " + e.getName() + " and this rocket has " + e.getThrustersNumber()  + " thrusters.");
			}
			return null;
		}
	}

//clase hilos con el runnable
class SetThreads implements Runnable{
	
	//Constructor de hilos
	public SetThreads (int enterOption, int powerDifference, int j, boolean action ) {
		this.enterOption = enterOption;
		this.powerDifference= powerDifference;
		this.j= j;
		this.action=action;
	}
	//Runnable
	public  void run() {
		
		RocketsFaseII zeroRocket= ExecutionFaseII.fleet.get(enterOption);
		ThrustersFaseII zeroThruster = zeroRocket.thrustersList.get(j);
		//Marco dos opciones de operación en función de si hay que sumar o restar potencia
		if (action==true) {
			for(int i =0;i<powerDifference;i++) {
				int up=zeroThruster.getPowerActuallyThruster()+1;
				System.out.println("The actually power of thruster "+j+" is "+ up);
				zeroThruster.setPowerMaxThruster(up);
			}
		}
		if (action==false) {
			for(int i =0;i<powerDifference;i++) {
				int up=zeroThruster.getPowerActuallyThruster()-1;
				System.out.println("The actually power of thruster "+j+" is "+ up);
				zeroThruster.setPowerMaxThruster(up);
			}
		}
		return;
	} 				
	private int enterOption;
	private  int j;
	private int powerDifference;
	private boolean action;
}





		