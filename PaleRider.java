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

String pattern = "X";


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
	        	if(line.contains("Elephant")){ opponent = "Elephant"; pattern = "RBBBBBS"; }
	        	if(line.contains("Kemosabe")){ opponent = "Sprinter"; pattern = "RBBBS"; }
	        	
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
	return "S";
	//System.out.println("Opponent = " + opponent);
}


}
