//Elephants never forget
class Elephant extends Shooter
{
	

  static Choice[] analysis = new Choice[9];
  public Elephant(){ analysis[0] = new Choice("RR", 0); analysis[1] = new Choice("RB", 0); analysis[2] = new Choice("RS", 0); analysis[3] = new Choice("SR", 0); analysis[4] = new Choice("SB", 0); analysis[5] = new Choice("SS", 0); analysis[6] = new Choice("BR", 0); analysis[7] = new Choice("BB", 0); analysis[8] = new Choice("BS", 0); }
  
  static void main(String[] args){
	    Elephant e = new Elephant();
	    //e.play("BBBB","SRSR");
	  }

	    public String play(String me, String him){

        //Reset probs
        for(Choice c : analysis){
          c.probability = 0;
        }

	    //Always load first, duh
	    if(him.length() == 0){
	    	return reload();
	    }
	    //Block once to  gather data
	    else if(him.length() == 1){
	    	return block();
	    }
	    
	    else{
	      analyze(him);
	      int hisAmmo = findAmmo(him);
	      int meAmmo = findAmmo(me);

	      //What will he do next?
	      char hisLast = him.toCharArray()[him.toCharArray().length - 1];
	      Choice[] hisOptions = new Choice[3];
	      int k = 0;
	      for(int i = 0; i < 9; i++){
	          if(analysis[i].pattern.toCharArray()[0] == hisLast){
	              hisOptions[k++] = analysis[i];
	          }
	      }


	      char hisNext = 'S';
	      int mostLikely = 0;
	      for(Choice c : hisOptions){
	          if(c != null && c.probability > mostLikely){
	        	  //System.out.println("Option = " + c.pattern);
	        	  //System.out.println("Prob = " + c.probability);
	        	  mostLikely = c.probability;
	        	  hisNext = c.pattern.toCharArray()[1]; }
	      }




	      //Now go through potential cases
	      //System.out.println("His Next = " + hisNext);
	      //System.out.println("Me ammo = " + meAmmo);
	      //Shoot the shotgun
	      if(meAmmo > 5){ return shoot(); }
	      else if(meAmmo > 0){
	        switch(hisNext){
	          case 'S': return block();
	          case 'B': return reload();
	          case 'R': return shoot();
	        }
	      }
	      else{
	        switch(hisNext){
	          case 'S': return block();
	          case 'B': return block();
	          case 'R': return reload();
	        }
	      }
	    }
	    return block();
	  }

	  static String reload(){ 
		  //System.out.println("Reloading");
		  return "R"; }
	  static String block(){
		  //System.out.println("B");
		  return "B"; }
	  static String shoot(){
		  //System.out.println("P");
		  return "S"; }


	  void analyze(String his){
		//System.out.println("Analyzing");
	    char[] shortString = his.substring(1,his.length() - 1).toCharArray();
	    char[] longString = his.toCharArray();
	    for(int i = 0; i < shortString.length; i++) {
	      String pattern = "" + longString[i] + shortString[i];
	      for(Choice c : analysis){
	    	  if(c.pattern.equals(pattern)){
	    		  //System.out.println("Pattern = " + pattern);
	    		  c.probability++;
	    		  //System.out.println("Proba = " + c.probability);
	    		  
	          }
	      }
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

	class Choice{
	    String pattern;
	    int probability;

	    Choice(String p, int i){
	        pattern = p;
	        probability = i;
	    }
	}
