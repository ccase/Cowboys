
public class HappyHobo extends Shooter {

  int tieCounter = 0;

	public String play(String mine, String other){
		
    if(mine.equals("")){ tieCounter=0; return "R"; } //Always reload the first move

    char hisLastMove = other.charAt(other.length()-1);
    char myLastMove = mine.charAt(mine.length()-1);


    int myRCount = mine.length() - mine.replace("R", "").length();
    int hisRCount = other.length() - other.replace("R", "").length();
    int mySCount = mine.length() - mine.replace("S", "").length();
    int hisSCount = other.length() - other.replace("S", "").length();
    int myBullets = myRCount - mySCount;
    int hisBullets = hisRCount - hisSCount;

    if (myBullets < 0) {myBullets = 0;}
    if (hisBullets < 0) {hisBullets = 0;}

    if ( (mine.length()>5) && (mine.charAt(mine.length()-6)=='S') && (mine.charAt(mine.length()-5)=='R') && (mine.charAt(mine.length()-4)=='S') && (mine.charAt(mine.length()-3)=='R') && (mine.charAt(mine.length()-2)=='S') && (myLastMove=='R')) {
      return "R";
    }
    
    if (myBullets > 5) {return "S";}
    if (hisBullets > 5) {
      if (myBullets > 0) {return "S";}
      else {return "R";}
    }

    if (hisBullets == 5) {
      if (hisLastMove == 'R') { return "R";}
      else {
          if (myLastMove != 'S') {return "S";}
          else {return "R";}
      }

      
    }
    if (myBullets > 3) {
      if (myLastMove == 'R') { return "B"; }
    }
    
    if (myBullets > 0) {
      if ( (other.length() > 3) && (other.charAt(other.length()-4)=='B') && (other.charAt(other.length()-3)=='B') && (other.charAt(other.length()-2)== 'B') && (hisLastMove == 'B')   ) { return "R"; }
      //if ( (other.length() > 2) && (other.charAt(other.length()-3)=='B') && (other.charAt(other.length()-2)== 'B') && (yourLastMove == 'B')   ) {return "S";}
      if ( (other.length() > 3) && ((other.charAt(other.length()-4)) == 'R') && ((other.charAt(other.length()-3)) == 'R') && ((other.charAt(other.length()-2)) == 'B') && (hisLastMove == 'R') ) {return "S";}
      if ( (other.length() > 2) && ((other.charAt(other.length()-3)) == 'R') && ((other.charAt(other.length()-2)) == 'R') && (hisLastMove == 'R') ) {return "S";}
    }

    if (hisBullets > 0) { 
      if ( (other.length() > 3) && (other.charAt(other.length()-4)=='B') && (other.charAt(other.length()-3)=='B') && (other.charAt(other.length()-2)== 'B') && (hisLastMove == 'B')   ) { return "R"; }
      else {return "B";} 
    }
    if (hisBullets == 0) { return "R"; }
    return "R";
	}
}
