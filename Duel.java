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

      int printBulletsA = bulletsA + ((aMove.equals("R"))?1:0) - ((aMove.equals("S"))?1:0);
      int printBulletsB = bulletsB + ((bMove.equals("R"))?1:0) - ((bMove.equals("S"))?1:0);
      if (printBulletsA < 0) {printBulletsA = 0;}
      if (printBulletsB < 0) {printBulletsB = 0;}

      if (show_moves) {

        System.out.print("\u001b[2J");
        System.out.flush();
        System.out.println("Round " + rounds + "\n");
        System.out.println("      " + A.toS() + "                     ------versus------                    " + B.toS() + "\n");
        System.out.println("Ammo  " + printBulletsA + "                                                           " + printBulletsB);
        
        AePlayWave aw;

        if (aMove.equals("S") && bMove.equals("S")) {
          System.out.print(AsciiArt.ss);
          if (bulletsA > 5 && bulletsB > 5) {
            aw = new AePlayWave("./sound_effects/richochet.wav" );
          } else if (bulletsA > 5 || bulletsB > 5) {
            aw = new AePlayWave("./sound_effects/shot.wav" );
          } else if (bulletsA > 0 && bulletsB > 0) {
            aw = new AePlayWave("./sound_effects/richochet.wav" );
          } else if (bulletsA > 0 || bulletsB > 0) {
            aw = new AePlayWave("./sound_effects/pain.wav" );
          } else {
            aw = new AePlayWave("./sound_effects/blank.wav" );
          }
        }
        else if (aMove.equals("S") && bMove.equals("R")) {
          System.out.print(AsciiArt.sr);
          if (bulletsA > 5) {
            aw = new AePlayWave("./sound_effects/shot.wav" );
          }
          else if (bulletsA > 0) {
            aw = new AePlayWave("./sound_effects/pain.wav" );
          } else {
            aw = new AePlayWave("./sound_effects/blank.wav" );
          }
        }
        else if (aMove.equals("S") && bMove.equals("B")) {
          System.out.print(AsciiArt.sb);
          if (bulletsA > 5) {
            aw = new AePlayWave("./sound_effects/shot.wav" );
          } else if (bulletsA > 0) {
            aw = new AePlayWave("./sound_effects/richochet.wav" );
          } else {
            aw = new AePlayWave("./sound_effects/blank.wav" );
          }
        }
        else if (aMove.equals("R") && bMove.equals("S")) {
          System.out.print(AsciiArt.rs);
          if (bulletsB > 5) {
            aw = new AePlayWave("./sound_effects/shot.wav" );
          } else if (bulletsB > 0){
            aw = new AePlayWave("./sound_effects/pain.wav" );
          } else {
            aw = new AePlayWave("./sound_effects/blank.wav" );
          }
        }
        else if (aMove.equals("R") && bMove.equals("R")) {
          System.out.print(AsciiArt.rr);
          aw = new AePlayWave("./sound_effects/reload.wav" );
        }
        else if (aMove.equals("R") && bMove.equals("B")) {
          System.out.print(AsciiArt.rb);
          aw = new AePlayWave("./sound_effects/reload.wav" );
        }
        else if (aMove.equals("B") && bMove.equals("S")) {
          System.out.print(AsciiArt.bs);
          if (bulletsB > 5) {
            aw = new AePlayWave("./sound_effects/shot.wav" );
          } else if (bulletsB > 0) {
            aw = new AePlayWave("./sound_effects/richochet.wav" );
          } else {
            aw = new AePlayWave("./sound_effects/blank.wav" );
          }
        }
        else if (aMove.equals("B") && bMove.equals("R")) {
          System.out.print(AsciiArt.br);
          aw = new AePlayWave("./sound_effects/reload.wav" );
        }
        else {
          System.out.print(AsciiArt.bb);
          aw = new AePlayWave("./sound_effects/block.wav" );
        }

        aw.start();
      
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
