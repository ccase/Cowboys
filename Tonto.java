
public class Tonto extends Shooter {

  private Boolean bart = false;

	public String play(String mine, String other){
		if(mine.equals("")){ bart = false; return "R"; } //Always reload the first move
    
    int rounds = mine.length();

    int myRCount = mine.length() - mine.replace("R", "").length();
    int hisRCount = other.length() - other.replace("R", "").length();
    int mySCount = mine.length() - mine.replace("S", "").length();
    int hisSCount = other.length() - other.replace("S", "").length();
    int myBullets = myRCount - mySCount;
    int hisBullets = hisRCount - hisSCount;

    if (myBullets < 0) {myBullets = 0;}
    if (hisBullets < 0) {hisBullets = 0;}

    if (myBullets > 5) {return "S";}
    if (bart) {
      if (myBullets < 4) {return "R";}
      else if (myBullets == 5){if (hisBullets < 1){return"R";}else{return "B";}}
      else if (hisBullets < 2) {return "R";}
      else {return "B";}
    }


    if (rounds < 5) {
      return "B";
    } else {
      char myLastMove = mine.charAt(mine.length()-1);
      String theirLastFour = other.substring(other.length()-4);
      String myLastFour = mine.substring(mine.length()-4);
      if (theirLastFour.equals("RRRR")) {return "S";}
      else if (theirLastFour.equals("BBBB"))
        {if (myLastFour.equals("SBSB")){bart = true;return "R";} else if (myLastMove == 'S'){return "B";}else if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("SRSR")) {return "B";}
      else if (theirLastFour.equals("RSRS")) {if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("RSRS")) {if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("BSRB")) {return "B";}
      else if (theirLastFour.equals("SRBS")) {if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("BBSR")) {return "B";}
      else if (theirLastFour.equals("BSRS")) {if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("BSBB")) {return "B";}
      else if (theirLastFour.equals("BBBR")) {if (myBullets > 0){return "S";}else{return "R";}}
      else if (theirLastFour.equals("BBRB")) {return "B";}
      else if (theirLastFour.equals("BRBS")) {return "B";}
      else {return "R";}
    }
	}
}

