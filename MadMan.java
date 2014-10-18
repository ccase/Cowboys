
public class Duel {

	Shooter A;
	Shooter B;
	String hisA = "";
	String hisB = "";
	int bulletsA = 0;
	int bulletsB = 0;
	
	public Duel(Shooter A, Shooter B){
		this.A = A;
		this.B = B;
		
	}
	
	public static void main(String[] args){
		Shooter one = new AveragePete();
		Shooter two = new MadMan();
		Duel d = new Duel(one, two);
		System.out.println(d.run());
		//System.out.println(two.play("BBBB", "RBSRBS"));
	}
	
	public String run(){
		int turnCounter = 0;
		while(turnCounter++ < 100){
			String aMove = A.play(hisA,  hisB);
			String bMove = B.play(hisB, hisA);
			System.out.println(aMove + " " + bMove);
			hisA = hisA + aMove;
			hisB = hisB + bMove;
			if(aMove.equals("S")){
				if(bMove.equals("R") && bulletsA > 0){ // Shot them while they were reloading!
					return "A";
				}
				if(bulletsA >= 6){ //Shotgun!
					if(!(bMove.equals("S") && bulletsB >= 6)){//Not a tie
						return "A";
					}
				}
				if(bulletsA >0){ bulletsA--; }
				
			}
			if(aMove.equals("R")){ bulletsA++; } // reloaded
			
			if(bMove.equals("S")){
				if(aMove.equals("R") && bulletsB > 0){ // Shot them while they were reloading!
					return "B";
				}
				if(bulletsA >= 6){ //Shotgun!
					if(!(aMove.equals("S") && bulletsA >= 6)){//Not a tie
						return "B";
					}
				}
				if(bulletsA >0){ bulletsB--; }
				
			}
			if(bMove.equals("R")){ bulletsB++; } // reloaded
			
			
			
			//no winner, count a turn and repeat
		}
		
		return "T";
	}
}
