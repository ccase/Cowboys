
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
		
    //Class<?> clazz = Class.forName("java.util.Date");
    //Object date = clazz.newInstance();
    
    try {
    Class shooter1 = Class.forName(args[0]);
    Class shooter2 = Class.forName(args[1]); 

    Shooter one = (Shooter) shooter1.newInstance();
		Shooter two = (Shooter) shooter2.newInstance();
		Duel d = new Duel(one, two);

    String result = d.run();

    if (result.equals("A")) {System.out.println(args[0] + " wins!!!");}
    else if (result.equals("B")) {System.out.println(args[1] + " wins!!!");}
    else {System.out.println("Tie");}

    } catch (ClassNotFoundException ex) {
      System.err.println(ex + " Interpreter class must be in class path.");
    } catch(InstantiationException ex) {
      System.err.println(ex + " Interpreter class must be concrete.");
    } catch(IllegalAccessException ex) {
      System.err.println(ex + " Interpreter class must have a no-arg constructor.");
    }

	}
	
	public String run(){
		int turnCounter = 0;
		while(turnCounter++ < 100){
			String aMove = A.play(hisA, hisB);
			String bMove = B.play(hisB, hisA);
			hisA = hisA + aMove;
			hisB = hisB + bMove;

      System.out.println(aMove + " " + bMove);

      try {
        Thread.sleep(1000);                 //1000 milliseconds is one second.
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }

      if (aMove.equals("S")) {

        if (bulletsA > 0) {

          if (bMove.equals("S")) {
            
            if (bulletsB > 0) {return "T";}
            else {return "A";}

          } else if (bMove.equals("R")) {
            
            return "A";

          } else {

            if (bulletsA > 5) {return "A";}
            else {bulletsA --;}
          
          }

        } else {
          
          if (bMove.equals("S")) {
            
            if (bulletsB > 0) {return "B";}

          } else if (bMove.equals("R")) {

            bulletsB ++;

          }
        }
      } else if (aMove.equals("R")) {

        if (bMove.equals("S")) {
            
          if (bulletsB > 0) {return "B";}
          else {bulletsA ++;}

        } else if (bMove.equals("R")) {

          bulletsA ++;
          bulletsB ++;

        } else {

          bulletsA ++;

        }
      } else {

        if (bMove.equals("S")) {

          if (bulletsB > 5) {return "B";}
          else if (bulletsB > 0) {bulletsB --;}

        } else if (bMove.equals("R")) {bulletsB ++;}

      }
    }
    return "T";
  }
}

      // if(aMove.equals("S")){
      // 		if(bMove.equals("R") && bulletsA > 0){ // Shot them while they were reloading!
      // 			return "A";
      // 		}
      // 		if(bulletsA >= 6){ //Shotgun!
      // 			if(!(bMove.equals("S") && bulletsB >= 6)){//Not a tie
      // 				return "A";
      // 			}
      // 		}
      // 		if(bulletsA > 0){ bulletsA--; }
				
      // 	}
      // 	if(aMove.equals("R")){ bulletsA++; } // reloaded
			
      // 	if(bMove.equals("S")){
      // 		if(aMove.equals("R") && bulletsB > 0){ // Shot them while they were reloading!
      // 			return "B";
      // 		}
      // 		if(bulletsA >= 6){ //Shotgun!
      // 			if(!(aMove.equals("S") && bulletsA >= 6)){//Not a tie
      // 				return "B";
      // 			}
      // 		}
      // 		if(bulletsA >0){ bulletsB--; }
				
      // 	}
      // 	if(bMove.equals("R")){ bulletsB++; } // reloaded
			
			
			
      // 	//no winner, count a turn and repeat
      // }
