import java.util.Random;


public class Sprinter extends Shooter{

	
	
	public String play(String me, String him){
		int myAmmo = findAmmo(me);
		int hisAmmo = findAmmo(him);
		
		//Only one goal: Shotgun
		if(myAmmo < 6){ return "R";}
		else{ return "S"; }
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
