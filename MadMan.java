import java.util.Random;


public class MadMan extends Shooter {

	
	
	public String play(String me, String him){
		int myAmmo = findAmmo(me);
		int hisAmmo = findAmmo(him);
		
		//Special cases
		if(me.length() == 0){ return "R";}
		if(myAmmo > 5){ return "S"; }
		if(hisAmmo == 5 && myAmmo > 0){ return "S"; }
		if(myAmmo == 5 && hisAmmo > 0){ return "B"; }
		
		
		Random rand = new Random();
		
		int choice = rand.nextInt(4);
		if(choice == 0){ return "R";}
		else if(choice == 1){ return "B"; }
		else{
			if( myAmmo > 0){ return "S";}
			else return "R";
				
			}
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
