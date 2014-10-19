import java.util.ArrayList;
import java.io.*;

public class FightClub {

  ArrayList<Shooter> cowboys = new ArrayList<Shooter>();

	public static void main(String[] args){

    FightClub fc = new FightClub("Cowboys.txt");
    int number_of_cowboys = fc.cowboys.size();
    
    for(int i=1; i<number_of_cowboys; i++) {
      for (int j=1; j<number_of_cowboys; j++) {
        if (i != j) {
          fc.fight(i,j);
        }
      }
    }
    
    System.out.printf("%-15s %15s %n", "Wins", "Losses", "Ties", "Points");
    for (int i=1; i<number_of_cowboys; i++) {



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

    System.out.println(one.toS() + " vs " + two.toS());

    String result = d.run();

    if (result.equals("A")) {
      System.out.println(one.toS() + " wins!!!");
      one.setWins(one.getWins() + 1);
      two.setLosses(two.getLosses() + 1);

    } else if (result.equals("B")) {
      System.out.println(two.toS() + " wins!!!");
      one.setLosses(one.getLosses() + 1);
      two.setWins(two.getWins() + 1);

    } else {
      System.out.println("Tie");
      one.setTies(one.getTies() + 1);
      two.setTies(two.getTies() + 1);

    }
    System.out.println();
  }
}


