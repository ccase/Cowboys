
public class CopyCatBitch extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		
    char othersLastMove = other.charAt(other.length() - 1);
    
    return "" + othersLastMove;
	}
}
