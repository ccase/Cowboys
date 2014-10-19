import java.util.Scanner;

public class Duel {

	Shooter A;
	Shooter B;
	String hisA = "";
	String hisB = "";
	int bulletsA = 0;
	int bulletsB = 0;
  int rounds = 0;

	public Duel(Shooter A, Shooter B){
		this.A = A;
		this.B = B;
		
	}
		
	public String run(boolean show_moves){
		int turnCounter = 0;

		while(turnCounter++ < 100){
      rounds = turnCounter;
			String aMove = A.play(hisA, hisB);
			String bMove = B.play(hisB, hisA);
			hisA = hisA + aMove;
			hisB = hisB + bMove;
      
      if (show_moves) {
        System.out.print("\u001b[2J");
        System.out.flush();
        System.out.println("      " + A.toS() + "                     ------versus------                    " + B.toS());
        if (aMove.equals("S") && bMove.equals("S")) {System.out.print(AsciiArt.ss);}
        else if (aMove.equals("S") && bMove.equals("R")) {System.out.print(AsciiArt.sr);}
        else if (aMove.equals("S") && bMove.equals("B")) {System.out.print(AsciiArt.sb);}
        else if (aMove.equals("R") && bMove.equals("S")) {System.out.print(AsciiArt.rs);}
        else if (aMove.equals("R") && bMove.equals("R")) {System.out.print(AsciiArt.rr);}
        else if (aMove.equals("R") && bMove.equals("B")) {System.out.print(AsciiArt.rb);}
        else if (aMove.equals("B") && bMove.equals("S")) {System.out.print(AsciiArt.bs);}
        else if (aMove.equals("B") && bMove.equals("R")) {System.out.print(AsciiArt.br);}
        else {System.out.print(AsciiArt.bb);}
      
        Scanner s = new Scanner(System.in);
        s.nextLine();

        // try {
        //   Thread.sleep(1000);                 //1000 milliseconds is one second.
        // } catch(InterruptedException ex) {
        //   Thread.currentThread().interrupt();
        // }
      }

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
