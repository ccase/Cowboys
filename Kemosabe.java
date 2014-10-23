import java.util.Random;

public class Kemosabe extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move

    int rounds = mine.length();
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

    if (myBullets > 5) {return "S";}

    // if (myLastMove == 'R') {
    //   int r = randInt(0,3);
    //   if (r == 0 && myBullets > 0) {return "S";}
    //   else {return "B";}
    // }

    if (hisBullets == 0) {return "R";}

    if (rounds > 3) {
        
      String myLastThree = mine.substring(mine.length()-3);
      String hisLastThree = other.substring(mine.length()-3);
      
      if (rounds > 4) {

        String myLastFive = mine.substring(mine.length()-5);
        String hisLastFive = other.substring(mine.length()-5);
      
        if (myLastFive.substring(0,4).equals(hisLastFive.substring(1))) {
          if (myLastMove == 'R' && myBullets > 0) {return "S";}
          else {return "R";}
        }
        
        if (hisLastFive.equals("RRRRR") && myBullets > 0) {
          return "S";
        }

      
        if (rounds > 5) {
      
          String myLastSix = mine.substring(mine.length()-6);
          String hisLastSix = other.substring(mine.length()-6);
        
          if (hisLastSix.substring(0,3).equals(hisLastThree)) {
            if (hisLastThree.substring(0,1).equals("R")) {
              if (myBullets > 0) {return "S";}
            }
            //if (hisLastThree.equals("SSS")) {return "B";}
            // else if (hisLastThree.equals("SSR")) {return "B";}
            // else if (hisLastThree.equals("SSB")) {return "B";}
            // else if (hisLastThree.equals("SRS")) {return "B";}
            // else if (hisLastThree.equals("SRR")) {return "B";}
            // else if (hisLastThree.equals("SRB")) {return "B";}
            // else if (hisLastThree.equals("SBS")) {return "B";}
            // else if (hisLastThree.equals("SBR")) {return "B";}
            // else if (hisLastThree.equals("SBB")) {return "B";}
            // if (hisLastThree.equals("RSS")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RSR")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RSB")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RRS")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RRR")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RRB")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RBS")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RBR")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("RBB")) {if (myBullets>0){return "S";}else{return "R";}}
            // else if (hisLastThree.equals("BSS")) {return "B";}
            // else if (hisLastThree.equals("BSR")) {return "B";}
            // else if (hisLastThree.equals("BSB")) {return "B";}
            // else if (hisLastThree.equals("BRS")) {return "B";}
            // else if (hisLastThree.equals("BRR")) {return "B";}
            // else if (hisLastThree.equals("BRB")) {return "B";}
            // else if (hisLastThree.equals("BBS")) {return "B";}
            // else if (hisLastThree.equals("BBR")) {return "B";}
            // else {return "B";}
          }
        }
      } 
      
      if (myLastThree.equals(hisLastThree) || (hisLastThree == "BBB")) {
        int r = randInt(0,5);
        if ((r == 0 || r == 1) && myBullets > 0) {return "S";}
        else if (r == 2) {return "B";}
        else {return "R";}
      } 
    }

    if (hisBullets == 5 && myBullets == 5) {return "S";}
    else if (hisBullets == 5 && myBullets < 4) {return "R";}
    else if (hisBullets - myBullets == 1) {return "B";}
    else if (hisBullets > 0 && myBullets > 0) {return "B";}
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
