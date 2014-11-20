///The Pale Rider Never Misses


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class PaleRider extends Shooter {
String opponent = "";
PrintStream tempOut = System.out;

String pattern = "RBBBS";


public String play(String me, String him){
	int turn = me.length();
	if(turn == 0){
		try {
			System.setOut(new PrintStream("magic"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "R";
	}
	if(turn == 1){
		System.setOut(tempOut);
		
		BufferedReader br = null;
		
	    String everything = "";
		try {
			br = new BufferedReader(new FileReader("magic"));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	if(line.contains("SimpleJoe")){ opponent = "SimpleJoe"; pattern = "RBS"; }
	        	if(line.contains("AveragePete")){ opponent = "AveragePete"; pattern = "RBBS"; }
	        	if(line.contains("Sprinter")){ opponent = "Sprinter"; pattern = "RS"; }
	        	if(line.contains("Elephant")){ opponent = "Elephant"; pattern = "RBBBS"; }
	        	if(line.contains("Bojango")){ opponent = "Bojango"; pattern = "RBBBS"; }
	        	if(line.contains("CamelCase")){ opponent = "CamelCase"; pattern = "RBBBBBS"; }
	        	if(line.contains("Kemosabe")){ opponent = "Kemosabe"; pattern = "RBBBS"; }
	        	if(line.contains("CopyCatBitch")){ opponent = "CopyCatBitch"; pattern = "RS"; }
	        	if(line.contains("HappyHobo")){ opponent = "HappyHobo"; pattern = "RBBBBS"; }
	        	if(line.contains("Jamesy")){ opponent = "Jamesy"; pattern = "RBBBS"; }
	        	if(line.contains("MadMan")){ opponent = "MadMan"; pattern = "RRRBSSSRRRRBSSSSRRRRRRBS"; }
	        	if(line.contains("TexasTim")){ opponent = "TexasTim"; pattern = "RBBBS"; }
	        	if(line.contains("TieGuy")){ opponent = "Jamesy"; pattern = "RBBBS"; }
	        	if(line.contains("Tom")){ opponent = "Jamesy"; pattern = "RBBBS"; }
	        	if(line.contains("YellowBart")){ opponent = "YellowBart"; pattern = "RBS"; }
	        	
	        	
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        everything = sb.toString();
	        System.out.println(everything);
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	}
	
	
	
	
	//System.out.println("Turn = " + turn);
	if(turn < pattern.length()){
		return "" + pattern.charAt(turn);
	}
	if(findAmmo(me) < 6){
	return "R";
	}
	return "S";
	//System.out.println("Opponent = " + opponent);
}

int findAmmo(String hist){
    int Ammo = 0;
    for(char c : hist.toCharArray()){
        if(c == 'R'){ Ammo++; }
        else if (c == 'S'){ Ammo--;}
    }
    return Ammo;
}


}
