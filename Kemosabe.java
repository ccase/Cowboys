import java.util.Random;

public class Kemosabe extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		
    char myLastMove = mine.charAt(mine.length() - 1);
    char hisLastMove = other.charAt(mine.length() - 1);

    int myRCount = mine.length() - mine.replace("R", "").length();
    int hisRCount = other.length() - other.replace("R", "").length();
    int mySCount = mine.length() - mine.replace("S", "").length();
    int hisSCount = other.length() - other.replace("S", "").length();
    int myBullets = myRCount - mySCount;
    int hisBullets = hisRCount - hisSCount;

    if (myBullets < 0) {myBullets = 0;}
    if (hisBullets < 0) {hisBullets = 0;}

    int rounds = mine.length();
    if (rounds > 3) {
      if (mine.substring(mine.length()-3).equals(other.substring(other.length()-3))) {
        int r = randInt(0,2);
        if (r == 0) {return "S";}
        else if (r == 1) {return "R";}
        else {return "B";}
      }
    }
    if (myBullets > 5) {return "S";}
    else if (hisBullets == 0) {return "R";}
    else if (hisBullets < 5 && myBullets > 0) {return "B";}
    else {return "R";}
  }

  public static int randInt(int min, int max) {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }
}
