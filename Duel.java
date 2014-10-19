
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
		
	public String run(){
		int turnCounter = 0;
		while(turnCounter++ < 100){
			String aMove = A.play(hisA, hisB);
			String bMove = B.play(hisB, hisA);
			hisA = hisA + aMove;
			hisB = hisB + bMove;

      System.out.println(aMove + " " + bMove);

      // try {
      //   Thread.sleep(1000);                 //1000 milliseconds is one second.
      // } catch(InterruptedException ex) {
      //   Thread.currentThread().interrupt();
      // }

      if (aMove.equals("S")) {

        if (bulletsA > 5) {

          if (bMove.equals("S")) {
            
            if (bulletsB > 5) {bulletsA --; bulletsB --;}
            else {return "A";}

          } else {return "A";}

        } else if (bulletsA > 0) {

          if (bMove.equals("S")) {

            if (bulletsB > 5) {return "B";}
            else if (bulletsB > 0) {bulletsA --; bulletsB --;}
            else {return "A";}

          } else if (bMove.equals("R")) {return "A";}

          else {bulletsA --;}

        } else {

          if (bMove.equals("S")) {

            if (bulletsB > 0) {return "B";}

          } else if (bMove.equals("R")) {bulletsB ++;}

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
