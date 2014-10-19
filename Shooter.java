
public class Shooter {

  private int wins;
  private int losses;
  private int ties;

  public int getWins() {return wins;}
  public int getLosses() {return losses;}
  public int getTies() {return ties;}
  public void setWins(int w) {wins = w;}
  public void setLosses(int l) {losses = l;}
  public void setTies(int t) {ties = t;}

  public Shooter() {
    wins = 0;
    losses = 0;
    ties = 0;
  }

  public String toS() {
    return this.getClass().getName();
  }

	public String play(String historyA, String historyB){
		return "B";
		
	}
}
