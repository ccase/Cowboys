import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FightClub {

  ArrayList<Shooter> cowboys = new ArrayList<Shooter>();

	public static void main(String[] args){
    
    System.out.println();
    System.out.println();
  
    System.out.print(AsciiArt.pikachus);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Single duel or full tournament? (s/f/q to quit) ");
    
    Boolean done = false;
    while (!done) {
      String answer = scanner.nextLine();
      if (answer.equals("s")) {

        String cowboy1;
        String cowboy2;
        boolean show_moves;
        boolean wait;

        System.out.print("Cowboy 1? ");
        cowboy1 = scanner.nextLine();
        System.out.print("Cowboy 2? ");
        cowboy2 = scanner.nextLine();

        System.out.print("Show moves? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          show_moves = true;
        } else {
          show_moves = false;
        }

        System.out.print("Wait between turns? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          wait = true;
        } else {
          wait = false;
        }

        FightClub single_duel = new FightClub(cowboy1, cowboy2);
        single_duel.fight(single_duel.cowboys.get(0), 
                          single_duel.cowboys.get(1), show_moves, wait);
                
        System.out.println();
        System.out.print("Single duel or full tournament? (s/f/q to quit) ");
        
      } else if (answer.equals("f")) {

        boolean show_moves;
        boolean wait;

        System.out.print("Show moves? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          show_moves = true;
        } else {
          show_moves = false;
        }

        System.out.print("Wait between turns? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          wait = true;
        } else {
          wait = false;
        }
        
        System.out.println();

        FightClub fc = new FightClub("Cowboys.txt");
        int number_of_cowboys = fc.cowboys.size();

        for (int i=0; i<number_of_cowboys; i++) {
          for (int j=0; j<number_of_cowboys; j++) {
            if (i != j) {
              System.out.println(fc.cowboys.get(i).toS() + " vs " + 
                                 fc.cowboys.get(j).toS());

              System.out.println("Type go to fight!");
              while (!scanner.nextLine().equals("go")) {}

              fc.fight(fc.cowboys.get(i),fc.cowboys.get(j),show_moves,wait);
            }
          }
        }
    
        fc.printStandings();
        
        System.out.print("Single duel or full tournament? (s/f/q to quit) ");
      } else if (answer.equals("q")) {
        done = true;
        System.out.println();
        System.out.println();
        System.out.println(AsciiArt.owls);
        System.out.println("Thanks for playing :)\n");
      } else {
        System.out.print("? ");
      }
    }
  }

  
  public FightClub(String a, String b) {
    
    try {
      Class shooter1 = Class.forName(a);
      Class shooter2 = Class.forName(b);
      cowboys.add((Shooter) shooter1.newInstance());
      cowboys.add((Shooter) shooter2.newInstance());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex + " Interpreter class must be in class path.");
    } catch(InstantiationException ex) {
      System.err.println(ex + " Interpreter class must be concrete.");
    } catch(IllegalAccessException ex) {
      System.err.println(ex + " Interpreter class must have a no-arg constructor.");
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

  public void printStandings() {

    int number_of_cowboys = cowboys.size();

    ArrayList<Shooter> sortedCowboys = new ArrayList<Shooter>();
    for (int i=0; i<number_of_cowboys; i++) {
      int index = 0;
      for (int j=0; j<sortedCowboys.size(); j++) {
        if (cowboys.get(i).getPoints() < sortedCowboys.get(j).getPoints()) {
          index = j+1;
        }
      }
      sortedCowboys.add(index, cowboys.get(i));
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
    System.out.println();
  }

  public void printFighters() {

    int number_of_cowboys = cowboys.size();
    for (int i=0; i<number_of_cowboys; i++) {
      System.out.println(cowboys.get(i).toS());
    }

  }

  public void fight(Shooter one, Shooter two, boolean show_moves, boolean wait) {

    Duel d = new Duel(one, two);

    String matchup = one.toS() + " vs " + two.toS() + ": ";
    String outcome;

    String result = d.run(show_moves, wait);

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

    System.out.printf("%-30.30s  %-30.30s %-30.30s%n", matchup, outcome, d.rounds);
    System.out.println();
  }
}


