
public class TriggerHappy extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		else {return "S";}
	}
}
