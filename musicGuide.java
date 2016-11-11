import java.util.Scanner;
import java.io.*;
public class musicGuide {
	
	public static void scales(Scanner input, String mode, String key){
		//print the scale of given mode and key
		
		System.out.println(mode+" | "+key);
	}

	//Function to read through a file 
	public static void analyse(Scanner fS){
		int i = 0;
		String line;
		while(fS.hasNext()){
			line = fS.nextLine();
			System.out.println(line);
			if (line.equals("Scales")){
				System.out.println(line);
				line = fS.next();
				if (line.equals("C_Major1")){
					for (int random=0;random<10; random++){
						line = fS.next();
						System.out.println(line);
					}
				}
			}
			i++;
		}
		System.out.println(i);
	}
	
	public static void main (String[] args) throws Exception{
		Scanner userInput = new Scanner(System.in);
		System.out.println("What category would you like info about?");
		System.out.println("\tScales <mode>,<key>"+
						 "\n\tChords <mode>,<key>"+
						 "\n\tProgression Pattern for Scales <mode>,<key>"+
						 "\n\tFingerings <key>");
		String category = userInput.nextLine();
		category = category.toLowerCase();
		String[] input = category.split("\\s+");
		String mode = input[1];
		String key = input[2];
		scales(userInput,mode,key);

		//Scanner for analyse function

		System.out.println("About to analyse file");
		File inputFile = new File("music_data.txt");
		Scanner fileScanner = new Scanner(inputFile);
		analyse(fileScanner);		
	}
}