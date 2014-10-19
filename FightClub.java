import java.util.ArrayList;
import java.io.*;

public class FightClub {

  ArrayList<Shooter> cowboys = new ArrayList<Shooter>();

	public static void main(String[] args){

    FightClub fc = new FightClub("Cowboys.txt");
    int number_of_cowboys = fc.cowboys.size();
    
    for (int i=0; i<number_of_cowboys; i++) {
      for (int j=0; j<number_of_cowboys; j++) {
        if (i != j) {
          fc.fight(i,j);
        }
      }
    }
    
    ArrayList<Shooter> sortedCowboys = new ArrayList<Shooter>();
    for (int i=0; i<number_of_cowboys; i++) {
      int index = 0;
      for (int j=0; j<sortedCowboys.size(); j++) {
        if (fc.cowboys.get(i).getPoints() < sortedCowboys.get(j).getPoints()) {
          index = j+1;
        }
      }
      sortedCowboys.add(index, fc.cowboys.get(i));
    }

    System.out.printf("%15s %15s %15s %15s %15s %n", "Cowboy", "Wins", "Losses", "Ties", "Points");
    for (int i=0; i<number_of_cowboys; i++) {
      Shooter s = sortedCowboys.get(i);
      System.out.printf("%15s %15s %15s %15s %15s %n",
                        s.toS(),
                        s.getWins(),
                        s.getLosses(),
                        s.getTies(),
                        s.getPoints());

    }
    
  }

  public FightClub(String filename) {

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line = null;
      while ((line = reader.readLine()) != null) {
        Class shooter = Class.forName(line);
        cowboys.add((Shooter) shooter.newInstance());
      }
    } catch (FileNotFoundException ex) {
      System.err.println(ex + " File not found.");
    } catch (IOException ex) {
      System.err.println(ex + " IO problem.");
    } catch (ClassNotFoundException ex) {
      System.err.println(ex + " Interpreter class must be in class path.");
    } catch(InstantiationException ex) {
      System.err.println(ex + " Interpreter class must be concrete.");
    } catch(IllegalAccessException ex) {
      System.err.println(ex + " Interpreter class must have a no-arg constructor.");
    }
  }

  public void fight(int a, int b) {

    Shooter one = cowboys.get(a);
    Shooter two = cowboys.get(b);
    Duel d = new Duel(one, two);

    String matchup = one.toS() + " vs " + two.toS() + ": ";
    String outcome;

    String result = d.run();

    if (result.equals("A")) {
      outcome = one.toS() + " wins!!!";
      one.setWins(one.getWins() + 1);
      two.setLosses(two.getLosses() + 1);

    } else if (result.equals("B")) {
      outcome = two.toS() + " wins!!!";
      one.setLosses(one.getLosses() + 1);
      two.setWins(two.getWins() + 1);

    } else {
      outcome = "Tie";
      one.setTies(one.getTies() + 1);
      two.setTies(two.getTies() + 1);

    }
    one.setPoints(one.getWins()*3 + one.getTies());
    two.setPoints(two.getWins()*3 + two.getTies());

    System.out.printf("%-30.30s  %-30.30s%n", matchup, outcome);
    System.out.println();
  }
}


