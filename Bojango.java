import java.util.Random;
public class Bojango extends Shooter {
	
	public String play(String mine, String other) {
		int myAmmo = getAmmo(mine);
		int otherAmmo = getAmmo(other);
		if(mine.length() == 0) {
			return "R";
		}
		if(mine.length() == 1) {
			return "B";
		}
		if(myAmmo > 6) {
			return "S";
		}
		if(other.length() > 10) {
			if(
			 getReps(10, other, 'B')) {
			 	if(myAmmo == 5 && otherAmmo == 5) {
			 		return "S";
			 	}
				if(mine.charAt(mine.length() -1) == 'B'){
					return "R";
				}
				if(mine.charAt(mine.length() -1) == 'R') {
					return "B";
				}
			}
			if(getReps(9, mine, 'B')
				&& other.substring(other.length() -2).equals("RS")) {
				if(myAmmo > 1) {
					return "S";
				}
			}
		}
		if(other.length() > 3) {
			if(otherAmmo == 1 && myAmmo < 4) {
				if(getReps(2, mine, 'R') || getReps(1, other, 'S') || getReps(1, other, 'R')) {
					return "B";
				}
				if(getReps(3, other, 'B')) {
					return "R";
				}
			}
		}
		Random rand = new Random();
		int[] choices = {2,3,4,5};
		int r = rand.nextInt(4);
		if(otherAmmo == choices[r] && myAmmo > 2) {
			return "S";
		}
		if(otherAmmo > 0 && otherAmmo < 5) {
			return "B";
		}
		if(otherAmmo == 5 && myAmmo > 1 && getReps(1, other, 'B')) {
			return "S";
		}
		if(otherAmmo >= 6 && mine.charAt(mine.length() - 1) == 'S') {
				return "B";
		}
		if(otherAmmo < 1) {
			if (myAmmo > 5) {
				return "S";
			}

		}
		return "R";
	}

	public int getAmmo(String hist) {
		int ammo = 0;
		for(int i = 0; i < hist.length(); i++) {
			if(hist.charAt(i) == 'R') {
				ammo++;
			}
			else if(hist.charAt(i) == 'S') {
				ammo--;
			}
		}
		return ammo;
	}

	public boolean getReps(int thresh, String hist, char move) {
		for(int i = hist.length() - thresh; i < hist.length(); i++) {
			if(hist.charAt(i) != move) {
				return false;	
			}
		}
		return true; 
	}
}