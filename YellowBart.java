import java.util.Random;


public class YellowBart extends Shooter {

	
	
	public String play(String me, String him){
		int myAmmo = findAmmo(me);
		int hisAmmo = findAmmo(him);
		
		//Start
		if(me.length() == 0){ return "R";}
		if(me.length() == 1 || me.length() == 2){ return "B"; }
		if(me.length() == 3){ return "R"; }
		
		
		//reload if empty, and just shot at
		if(myAmmo < 1 && him.charAt(him.length() - 1) == 'S'){
			return "R";
			
		}
		
		//If you're about to get shot, shoot
		if((hisAmmo + myAmmo) > 5 && myAmmo > 0){ return "S";}
		
		//Otherwise, play it safe partner
		return "B";
		
		
		
		}
		
		

	
	int findAmmo(String hist){
	      int Ammo = 0;
	      for(char c : hist.toCharArray()){
	          if(c == 'R'){ Ammo++; }
	          else if (c == 'S'){ Ammo--;}
	      }
	      return Ammo;
	  }
}
