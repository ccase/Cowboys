Cowboys
=======

repository for the Quickest Gun in Budapest challenge.

Here's how the game works...

Two players fight at a time.
Each round, the players simultaneously choose one of three options:
1. Shoot
2. Reload
3. Block

Each reload gives you one more bullet, each shot takes one away.
While reloading you are vulnerable, i.e. if player A shoots while B is reloading, then player A wins.
The same goes for shooting without ammo, i.e. if both players A and B shoot but A has ammo and B doesn't, then player A wins.
If both players shoot and both have bullets then the shots will cancel out, except for one special case!

The shotgun:
Having 6 or more bullets gives you a powerful shotgun. The shotgun will shoot through a block, overpower a lesser weapon, and just generally fuck shit up. The only way to counter a shotgun shot is with another shotgun.

The challenge: 
Write the best AI cowboy possible.

How to do it:
The game is written in java. Cowboys are stored as extensions of the Shooter class. To create a cowboy, you need to write a play function, which, based on two inputs--your move history and your opponents move history--will determine your next move. Here is an example of a simple cowboy, SimpleJoe.

public class SimpleJoe extends Shooter {

	public String play(String mine, String other){

		if(mine.equals("")){ return "R"; } //Always reload the first move
		char lastMove = mine.charAt(mine.length() - 1);
		if(lastMove == 'R'){ return "S"; }//If you've got a bullet, use it
		return "R";

	}
}

SimpleJoe simply reloads and shoots, reloads and shoots.
Notice that the move history of each player is stored as a string composed of the letters "S" = shoot, "R" = reload, and "B" = block.
The history string is ordered such that the most recent move occurs at the end of the string.
Here is another example of a simple cowboy, CopyCatBitch.

public class CopyCatBitch extends Shooter {

	public String play(String mine, String other){
		if(mine.equals("")){ return "R"; } //Always reload the first move
		
    char othersLastMove = other.charAt(other.length() - 1);
    
    return "" + othersLastMove;
	}
}

CopyCatBitch simply copies his opponent's last move.

You get the idea.
Email cowboys to me, jreuter@wesleyan.edu, and I'll add them to the tournament, or if you want you could fork the github and submit a pull request with your cowboy file.

Testing your cowboy:
To run the tournament, first fork the github repo and pull it to your computer.
Once you have the repo downloaded, add your new cowboy class file to it, compile everything (javac *.java) and then run the FightClub class (java FightClub).
Leaderboard can be updated regularly.
Looking at/copying the other cowboys in the github is considered cheating.

Chump's up, let's do this.










