import java.util.ArrayList;
import java.io.*;

public class QuickTournament {
    ArrayList<Shooter> cowboys = new ArrayList<Shooter>();
    
    public static void main(String args[]) {
        int number_of_iterations = 10;
        for (int i = 0; i < args.length; i++) {
            // setting iterations
            try {
                number_of_iterations = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                // in case args[i] is not an int
            }
        }
        
        FightClub fc = new FightClub("Tournament_Cowboys.txt");
        int number_of_cowboys = fc.cowboys.size();
        for (int n=0; n<number_of_iterations; n++) {
            for (int i=0; i<number_of_cowboys; i++) {
                for (int j=0; j<number_of_cowboys; j++) {
                    if (i != j) {
                        fc.fight(fc.cowboys.get(i),fc.cowboys.get(j),false);
                    }
                }
            }
        }
        fc.printStandings();
    }
}