public class James extends Shooter{
	
	public String play(String mine, String other) {
    if(mine.equals("")) {return "R";}
    if(mine.length() == 1) {return "B";}
    int otherAmmo = 0;
    int myAmmo = 0;
    for (int i = 0; i < other.length();i++) {
      if(other.charAt(i) =='R') {
        otherAmmo++;
      }
      if(other.charAt(i) =='S') {
        otherAmmo--;
      }
    }
    for (int i = 0; i < mine.length();i++) {
      if(mine.charAt(i) =='R') {
        myAmmo++;
      }
      if(other.charAt(i) =='S') {
        myAmmo--;
      }
    }
    if(otherAmmo >0 && otherAmmo < 5) {
      return "B";
    }
    if(otherAmmo >= 5) {
      return "S";
    }
    if(otherAmmo < 1) {
      if(myAmmo > 0){
        return "S";
      } else {
        return "R";
      }
      
    }
    return "R";
	}
}