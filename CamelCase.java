import java.util.Random;

// Caleb's brother

/*
         Cowboy            Wins          Losses            Ties          Points
      CamelCase            2250             350               0            6750
      HappyHobo            2183             417               0            6549
         Jamesy            2066             334             200            6398
       Kemosabe            2081             401             118            6361
         TieGuy            1587            1013               0            4761
            Tom            1361            1239               0            4083
            Ape             930            1470             200            2990
      SimpleJoe             967            1633               0            2901
         MadMan             925            1640              35            2810
       Elephant             719            1403             478            2635
    AveragePete             770            1630             200            2510
   CopyCatBitch             453            1747             400            1759
     YellowBart             107            1418            1075            1396
   TriggerHappy             248            1952             400            1144
*/

public class CamelCase extends Shooter {
    
    String[] possiblePlays = {"S","R","B"};
    Random rand = new Random();

    int ammoCount(String plays) {
        int ammo = 0;
        for (char c : plays.toCharArray()) {
          if (c == 'R'){ ammo++; }
          else if (c == 'S'){ ammo--; }
        }
        return ammo;
    }

    String lastPlays(String plays, int i) {
        return plays.substring(plays.length() - i);
    }

    static String reload() { return "R"; }
    static String block() { return "B"; }
    static String shoot() { return "S"; }

    String random() { return possiblePlays[rand.nextInt(2)]; }

    public String play(String mine, String other) {
        int plays = mine.length();
        int myAmmo = ammoCount(mine);
        int otherAmmo = ammoCount(other);

        if (myAmmo < 0) { myAmmo = 0; }
        if (otherAmmo < 0) { otherAmmo = 0; }

        // other is out of ammo
        if (otherAmmo == 0) {
            // we're both out
            if (myAmmo == 0) {
                return reload();
            } else {
                // can win
                return shoot();
            }
        }

        // exec only gets here if >0 rounds played
        char myLastPlay = mine.charAt(mine.length() - 1);
        char otherLastPlay = other.charAt(other.length() - 1);

        if (myAmmo > otherAmmo) {
            // if i can pierce
            if (myAmmo >= 5) {
                return shoot();
            }
            if (plays > 3 && lastPlays(other, 3).equals("BBB")) { return random(); }
            return reload();
        } else if (otherAmmo > myAmmo) {
            // if he can pierce
            if (otherAmmo >= 6) {
                // hope he fucks up
                return shoot();
            }
            return reload();
        }
         
        if (plays > 5) {
            return random();
        }

        return block();
    }

}