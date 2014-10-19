
public class Tom extends Shooter {

    int numBullets = 0;
    int myBullets = 0; 

	public String play(String mine, String other){
		
    if(mine.equals("")){ return "R"; } //Always reload the first move

    char lastMove = other.charAt(other.length()-1);
    char secondLastMove = 't';
    
    if (other.length()>1) {secondLastMove = other.charAt(other.length()-2);}

    if (lastMove == 'S') {numBullets--;}
    if (lastMove == 'R') {numBullets++;}
    if (mine.charAt(mine.length()-1) == 'R') {myBullets++;}
  
    if (numBullets == 0) { if (myBullets > 0) {myBullets --; return "S";} }
    
		if(lastMove == 'R'){ return "B"; }//If you just reloaded, take it easy
		if(lastMove == 'B'){ 
      if (secondLastMove == 'B'){ if (myBullets > 0) {myBullets --; return "S";} else {return "R";} }
      else {return "B";} 
    }//If you just blocked, take the shot
		if(lastMove == 'S'){if (myBullets > 0) {myBullets --; return "S";} else {return "R";} }//Out of bullets, better reload
		
		return "R";
	}
}
