package solution1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String file = "fichier-test";
		Position position = new Position(0, 0);
		int pelouseX = 0;
		int pelouseY = 0;
		Orientation orientation = null;
		String resultat = "";
		try(BufferedReader br = new BufferedReader(new FileReader(file))) 
		{
			String line;
			String [] lineSplit;
			while ((line = br.readLine()) != null) {
				lineSplit = line.split(" "); 
				if(lineSplit.length == 2) {
					pelouseX = new Integer(lineSplit[0]);
					pelouseY = new Integer(lineSplit[1]);
				}
				if(lineSplit.length == 3) {
					position.setX(new Integer(lineSplit[0]));
					position.setY(new Integer(lineSplit[1]));
					if("E".equals(lineSplit[2])) {
						orientation = Orientation.E;
					}
					else if("N".equals(lineSplit[2])) {
						orientation = Orientation.N;
					}else if ("S".equals(lineSplit[2])) {
						orientation = Orientation.S;
					} else if ("W".equals(lineSplit[2])) {
						orientation = Orientation.W;
					}
				}
				if(lineSplit.length == 1) {
					Tondeuse tondeuse = new Tondeuse(position, orientation);
					resultat += tondeuse.tondre(pelouseX, pelouseY, line) + " ";
				}
			}
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println(resultat); 
	}

}
