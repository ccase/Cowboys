import java.io.*;

public class QuickDuel {    
    public static void main(String args[]) {
        int number_of_duels = 10;
        String cowboy1 = "";
        String cowboy2 = "";
        if (args.length < 2) {
            System.err.println("Gotta choose two cowboys, brother.");
        } else if (args.length < 3) {
            if (args[0] instanceof String) {
                cowboy1 = args[0];
            }
            if (args[1] instanceof String) {
                cowboy2 = args[1];
            }
        } else {
            if (args[0] instanceof String) {
                cowboy1 = args[0];
            }
            if (args[1] instanceof String) {
                cowboy2 = args[1];
            }
            try {
                number_of_duels = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                // in case args[2] is not an int
            }
        }

        FightClub duel = new FightClub(cowboy1, cowboy2);

        for (int i=0; i<number_of_duels; i++) {
          duel.fight(duel.cowboys.get(0), duel.cowboys.get(1), false);
        }
        
        duel.printStandings();
    }
}