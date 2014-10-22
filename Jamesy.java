public class Jamesy extends Shooter{
	
	public String play(String mine, String other) {
		if(mine.equals("")) {return "R";}
		if(mine.length() == 1) {return "B";}
		int otherAmmo = 0;
		int myAmmo = 0;
		for (int i = 0; i < other.length();i++) 
		{
			if(other.charAt(i) == 'R') {
				otherAmmo++;
			}
			if(other.charAt(i) == 'S') {
				otherAmmo--;
			}
		}
		for (int i = 0; i < mine.length();i++) 
		{
			if(mine.charAt(i) == 'R') {
				myAmmo++;
			}
			if(mine.charAt(i) == 'S') {
				myAmmo--;
			}
		}
		if(myAmmo > 7) {
			return "S";
		}

		if(myAmmo > otherAmmo && myAmmo > 5) {
			return "S";
		}
		if(myAmmo == 7 || myAmmo == 6) {
			if(mine.charAt(mine.length() -1) == 'S') {
				return "S";
			}
		}
		if(other.length() > 10) {
			if(//otherAmmo >= 5 &&
			 other.substring(other.length() - 10).equals("BBBBBBBBBB")) {
				if(mine.charAt(mine.length() -1) == 'B'){
					return "R";
				}
				if(mine.charAt(mine.length() -1) == 'R') {
					return "B";
				}
			}
			
			if(mine.substring(mine.length() - 9).equals("BBBBBBBBB")
				&& other.substring(other.length() -2).equals("RS")) {
				if(myAmmo > 1) {
					return "S";
				}
			}	
		}
		if(other.length() > 3) {
			if (getBlocks(3, other) && getBlocks(3, mine)) {
				if(myAmmo > 5) {
					return "S";
				}
				else {
					return "R";
				}
			}
		
		}
		if(otherAmmo >0 && otherAmmo < 5) {
			return "B";
		}
		if(otherAmmo >= 5 && myAmmo > 1) {
			return "S";
		 }
		if(otherAmmo >= 5 && mine.charAt(mine.length() - 1) == 'S') {
				return "B";
		}
		if(otherAmmo < 1) {
			if(myAmmo > 0) {
				return "S";
			} else {
				return "R";
			}
		}
	return "R";
	}

	public boolean getBlocks(int thresh, String hist) {
		for(int i = hist.length() - thresh; i < hist.length(); i++) {
			if(hist.charAt(i) != 'B') {
				return false;	
			}
		}
		return true; 
	}
}

