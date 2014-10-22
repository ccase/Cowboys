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
        if (mine.equals("")) {
            return "R";
        }

        int myAmmo = countMatches(mine, 'R') - countMatches(mine, 'S');
        int otherAmmo = countMatches(other, 'R') - countMatches(other, 'S');

        if ((myAmmo == otherAmmo) && myAmmo == 0) {
            return "R";
        }

        if (myAmmo > otherAmmo) {
            return "S";
        } else if (otherAmmo > myAmmo) {
            return "B";
        }

        return "B";
    }

}