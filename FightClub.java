import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FightClub {

  ArrayList<Shooter> cowboys = new ArrayList<Shooter>();

	public static void main(String[] args){

    AePlayWave player = new AePlayWave("./sound_effects/theme_song.wav");
    player.start();

    System.out.println();
    System.out.println();
  
    System.out.print(AsciiArt.pikachus);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Duel or tournament? (d/t/q to quit) ");
    
    Boolean done = false;
    while (!done) {
      String answer = scanner.nextLine();
      if (answer.equals("d")) {

        String cowboy1;
        String cowboy2;
        boolean show_moves;
        boolean wait;
        int number_of_duels;

        System.out.print("Cowboy 1? ");
        cowboy1 = scanner.nextLine();
        System.out.print("Cowboy 2? ");
        cowboy2 = scanner.nextLine();
        
        System.out.print("How many duels? ");

        number_of_duels = scanner.nextInt();

        System.out.print("Show moves? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          show_moves = true;
          player.suspend();
        } else {
          show_moves = false;
        }

        FightClub duel = new FightClub(cowboy1, cowboy2);

        for (int i=0; i<number_of_duels; i++) {
          duel.fight(duel.cowboys.get(0), duel.cowboys.get(1), show_moves);
        }
        
        duel.printStandings();

        if (show_moves) {
          player = new AePlayWave("./sound_effects/theme_song.wav");
          player.start();
        }
                
        System.out.println();
        System.out.print("Duel or tournament? (d/t/q to quit) ");
        
      } else if (answer.equals("t")) {

        boolean should_restart_music = false;
        boolean skip;
        boolean show_moves;

        System.out.print("Want to see the action? (y/n) ");
        if (scanner.nextLine().equals("y")) {
          skip = false;
          show_moves = true;
        } else {
          skip = true;
          show_moves = false;
        }

        System.out.println();

        FightClub fc = new FightClub("Tournament_Cowboys.txt");
        int number_of_cowboys = fc.cowboys.size();

        for (int i=0; i<number_of_cowboys; i++) {
          for (int j=0; j<number_of_cowboys; j++) {
            if (i != j) {
              if (!skip) {

                System.out.println(fc.cowboys.get(i).toS() + " vs " + fc.cowboys.get(j).toS());
                System.out.println("Type f to fight! (s to skip, a to skip all) ");

                boolean isDone = false;
                while (!isDone) {
                  String fight_or_skip = scanner.nextLine();
                  if (fight_or_skip.equals("f")) {
                    player.suspend();
                    should_restart_music = true;
                    show_moves = true;
                    isDone = true;
                  } else if (fight_or_skip.equals("s")) {
                    show_moves = false;
                    isDone = true;
                  } else if (fight_or_skip.equals("a")) {
                    show_moves = false;
                    skip = true;
                    isDone = true;
                  }
                }
                isDone = false;
              } else {
                show_moves = false;
              }
              fc.fight(fc.cowboys.get(i),fc.cowboys.get(j),show_moves);
            }
          }
        }

        if (should_restart_music) {
          player = new AePlayWave("./sound_effects/theme_song.wav");
          player.start();
        }
    
        fc.printStandings();
        
        System.out.print("Duel or tournament? (d/t/q to quit) ");
      } else if (answer.equals("q")) {
        done = true;
        System.out.println();
        System.out.println();
        System.out.println(AsciiArt.owls);
        player.stop();
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

  public void fight(Shooter one, Shooter two, boolean show_moves) {

    Duel d = new Duel(one, two);

    String matchup = one.toS() + " vs " + two.toS() + ": ";
    String outcome;

    String result = d.run(show_moves);

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

    System.out.printf("%-30.30s  %-30.30s %-30.30s%n", matchup, outcome, "in " + d.rounds + " rounds");
    System.out.println();
  }
}


