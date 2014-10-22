import java.util.Random;

// Caleb's brother

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
            if (myAmmo >= 6) {
                return shoot();
            }
            return reload();
        } else if (otherAmmo > myAmmo) {
            // if he can pierce
            if (otherAmmo >= 6) {
                // hope he fucks up
                return reload();
            }
            return shoot();
        }

        if (plays > 3) {
            if (lastPlays(mine, 3).equals(lastPlays(other, 3))) {
                if (myAmmo < 6) { return random(); }
                return shoot();
            }
        }


        if (otherLastPlay == 'S') {
            if (myAmmo > 0) { return shoot(); }
            return block();
        }

        return block();
    }

}