
public class Ape extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		if(mine.equals("R")){ return "S"; }
    
    char othersSecondToLastMove = other.charAt(other.length() - 2);
    char othersLastMove = other.charAt(other.length() - 1);


    int myRCount = mine.length() - mine.replace("R", "").length();
    int hisRCount = other.length() - other.replace("R", "").length();
    int mySCount = mine.length() - mine.replace("S", "").length();
    int hisSCount = other.length() - other.replace("S", "").length();
    int myBullets = myRCount - mySCount;
    int hisBullets = hisRCount - hisSCount;

    if (myBullets < 0) {myBullets = 0;}
    if (hisBullets < 0) {hisBullets = 0;}


    if (myBullets > 5) {return "S";}
    if (othersSecondToLastMove == 'R') {
      return "R";
    } else {    
      return "" + othersLastMove;
    }
	}
}

