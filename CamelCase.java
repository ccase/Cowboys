public class CamelCase extends Shooter {

    public static int countMatches(String haystack, char needle) {
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }

    public String play(String mine, String other){
        int myAmmo = countMatches(mine, 'R') - countMatches(mine, 'S');
        int otherAmmo = countMatches(other, 'R') - countMatches(other, 'S');

        if (otherAmmo == 0) {
            if (myAmmo == 0) {
                return "R";
            } else {
                return "S";
            }
        }

        // exec only gets here if >0 rounds played
        char myLastPlay = mine.charAt(mine.length() - 1);
        char otherLastPlay = other.charAt(other.length() - 1);

        if (otherLastPlay == 'B') {
            if (myAmmo < 6 && myLastPlay != 'R') {
                return "R";
            } else {
                return "B";
            }
        }

        if (otherLastPlay == 'S') {
            if (myAmmo > 0) {
                return "S";
            } else {
                return "B";
            }
        }

        if (myAmmo > otherAmmo) {
            // if i can pierce
            if (myAmmo >= 6) {
                return "S";
            }
            return "R";
        } else if (otherAmmo > myAmmo) {
            // if he can pierce
            if (otherAmmo >= 6) {
                // hope he fucks up
                return "R";
            }
            return "S";
        }

        return "B";
    }

}