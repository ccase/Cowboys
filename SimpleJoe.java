
public class SimpleJoe extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		char lastMove = mine.charAt(mine.length() - 1);
		if(lastMove == 'R'){ return "S"; }//If you've got a bullet, use it
		return "R";
	}
}
