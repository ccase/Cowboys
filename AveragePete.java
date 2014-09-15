
public class AveragePete extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		char lastMove = mine.charAt(mine.length() - 1);
		
		if(lastMove == 'R'){ return "B"; }//If you just reloaded, take it easy
		if(lastMove == 'B'){ return "S"; }//If you just blocked, take the shot
		if(lastMove == 'S'){ return "R"; }//Out of bullets, better reload
		
		
		return "R";
	}
}
