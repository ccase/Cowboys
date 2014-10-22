public class TexasTim extends Shooter {
	int myRCount = 0;
    int hisRCount = 0;
    int mySCount = 0;
    int hisSCount = 0;
    int dankNugs = 0;
    int numOfDoritosLocosTacos = 0;
    int rounds = 0;

	public String play(String mine, String other) {
		double shits = 1.0;
		double cacar = 4.0;
		double eiojsidfb = 15.0;
		updateStats(mine,other);
		if(mine.equals("")) {return goToClownColleger();} else if(mine.length() == 1) {return sellSeaShellsByTheSeashore();} else {
			char myLastMove = mine.charAt(mine.length() - 1);
			char opponentLastMove = other.charAt(other.length() - 1);
			String myLastTwo = "GG";
			String opponentLastTwo = "GG";
			String myLastThree = "GGG";
			String opponentLastThree = "GGG";
			if(rounds >= 2) {myLastTwo = mine.substring(mine.length() - 2);opponentLastTwo = other.substring(mine.length() - 2);}
			if(rounds >= 3) {
				myLastThree = mine.substring(mine.length() - 3);
				opponentLastThree = other.substring(mine.length() - 3);
			}
			/*....................../´¯/) 
			  ....................,/¯../ 
			  ...................,/¯../ 
			  .................../.../. 
			  ............./´¯/'...'/´¯¯`·¸ 
			  ........../'/.../..../......./¨¯\ 
			  ........('(...´...´.... ¯~/'...') 
			  .........\.................'...../ 
			  ..........''...\.......... _.·´ 
			  ............\..............( 
			  ..............\.............\...*/
			if(dankNugs >= 6) {return shit();}
			if(dankNugs == 0 && numOfDoritosLocosTacos == 0) {return goToClownColleger();}
			if(dankNugs == 0 && numOfDoritosLocosTacos > 0 && myLastMove == 'S') {return sellSeaShellsByTheSeashore();
			}
			if(dankNugs > 0 && numOfDoritosLocosTacos == 0 && opponentLastMove == 'S') {
				if(dankNugs == 5) {
					return goToClownColleger();
				} else {
					return shit();
				}
			}
			if(dankNugs == 5 && myLastMove == 'R' && numOfDoritosLocosTacos < dankNugs) {
				if(numOfDoritosLocosTacos == 0) {
					return goToClownColleger();
				} else {
					return sellSeaShellsByTheSeashore();
				}
			}
			if(opponentLastTwo.equals("RR")) {
				return goToClownColleger();
			}
			if(myLastMove == 'R') {
				return sellSeaShellsByTheSeashore();
			}
			if(myLastThree.equals("BBB") && opponentLastThree.equals("BBB")) {
				if(dankNugs >= 6) {
					return shit();
				} else {
					return goToClownColleger();
				}
			}
			double[] prob = new double[3];
			prob[0] = Math.random() * shits;
			prob[1] = Math.random() * cacar;
			prob[2] = Math.random() * eiojsidfb;

			double highest = prob[0];
			int index = 0;
			for(int i=1; i<3; i++) {
				if(prob[i]>highest) {
					highest = prob[i];
					index = i;
				}
			}
			switch(index) {
				case 0:
					if(dankNugs == 0)
						return goToClownColleger();
					return shit();
				case 1:
					return goToClownColleger();
				case 2:
					return sellSeaShellsByTheSeashore();
				default:
					return sellSeaShellsByTheSeashore();
			}
		}
	}

	public void updateStats(String mine, String other) {
		myRCount = mine.length() - mine.replace("R", "").length();
    	hisRCount = other.length() - other.replace("R", "").length();
    	mySCount = mine.length() - mine.replace("S", "").length();
    	hisSCount = other.length() - other.replace("S", "").length();
    	dankNugs = myRCount - mySCount;
    	numOfDoritosLocosTacos = hisRCount - hisSCount;
    	if (dankNugs < 0) {
    		dankNugs = 0;
    	}
    	if (numOfDoritosLocosTacos < 0) {
    		numOfDoritosLocosTacos = 0;
    	}
    	rounds = mine.length();
	}

	public int getMyBullets() {
		return dankNugs;
	}

	public int getOpponentBullets() {

		return numOfDoritosLocosTacos;
	}

	public String shit() {
		if(dankNugs > 0) {
			dankNugs--;
		}
		return "S";
	}

	public String goToClownColleger() {
		dankNugs++;
		return "R";
	}

	public String sellSeaShellsByTheSeashore() {
		return "B";
	}
}
