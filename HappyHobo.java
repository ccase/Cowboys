
public class HappyHobo extends Shooter {

  boolean keepShooting = false;

	public String play(String mine, String other){
		
    if(mine.equals("")){ return "R"; } //Always reload the first move

    char yourLastMove = other.charAt(other.length()-1);
    char myLastMove = mine.charAt(mine.length()-1);

    //if (other.length()>3) {secondLastMove = other.charAt(other.length()-2);}

    int myRCount = mine.length() - mine.replace("R", "").length();
    int hisRCount = other.length() - other.replace("R", "").length();
    int mySCount = mine.length() - mine.replace("S", "").length();
    int hisSCount = other.length() - other.replace("S", "").length();
    int myBullets = myRCount - mySCount;
    int hisBullets = hisRCount - hisSCount;
    
    if (myBullets > 5) {return "S";}

    if (hisBullets > 4) {
      if (myBullets > 1) {return "S";}
      else {
        if (hisBullets > 5) {return "S";}
        else {return "B";}
      }
    }

    if (myBullets < 0) {myBullets = 0;}
    if (hisBullets < 0) {hisBullets = 0;}

    if (myBullets > 0) {
      if ( (other.length() > 3) && ((other.charAt(other.length()-4)) == 'R') && ((other.charAt(other.length()-3)) == 'R') && ((other.charAt(other.length()-2)) == 'B') && (yourLastMove == 'R') ) {return "S";}
      if ( (other.length() > 2) && ((other.charAt(other.length()-3)) == 'R') && ((other.charAt(other.length()-2)) == 'R') && (yourLastMove == 'R') ) {return "S";}
    }

    if (hisBullets > 0) { return "B"; }
    if (hisBullets == 0) { return "R"; }
    if (keepShooting == true) { return "S"; }
    else {return "R";}
	}
}
