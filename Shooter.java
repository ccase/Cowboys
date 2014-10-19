
public class Shooter {

  private int wins;
  private int losses;
  private int ties;
  private int points;

  public int getWins() {return wins;}
  public int getLosses() {return losses;}
  public int getTies() {return ties;}
  public int getPoints() {return points;}
  public void setWins(int w) {wins = w;}
  public void setLosses(int l) {losses = l;}
  public void setTies(int t) {ties = t;}
  public void setPoints(int p) {points = p;}

  public Shooter() {
    wins = 0;
    losses = 0;
    ties = 0;
    points = 0;
  }

  public String toS() {
    return this.getClass().getName();
  }

	public String play(String historyA, String historyB){
    return "B";
		
	}
}
