import java.util.Scanner;
import java.io.*;
public class musicGuide {
	
	public static void scales(Scanner input, String mode, String key){
		//print the scale of given mode and key
		
		System.out.println(mode+" | "+key);
	}

	//Function to read through a file 
	public static void analyse(Scanner fS, String k, String m, String c){
		int i = 0;
		String current_line;
		
		while(fS.hasNext()){
			current_line = fS.nextLine();
			current_line = current_line.toLowerCase();
			String[] fileText = current_line.split("\\s+");		
			if(fileText.length == 3 && fileText[0].equals(k) && fileText[1].equals(m) && fileText[2].equals(c)) {
				while (!current_line.equals("*")){
					current_line = fS.nextLine();
					System.out.println(current_line);
				}
			}
			i++;
		}
		System.out.println(i);
	}
	
	public static void main (String[] args) throws Exception{
		Scanner userInput = new Scanner(System.in);
		System.out.println("What category would you like info about?");
		System.out.println("\t<key> <mode> scale"+
						 "\n\t<key> <mode> chord"+
						 "\n\tProgression Pattern for Scales <key>,<mode>"+
						 "\n\tFingerings <key>,<mode>");
		String input_text = userInput.nextLine();
		input_text = input_text.toLowerCase();
		String[] input = input_text.split("\\s+");
		String key = input[0];
		String mode = input[1];
		String category = input[2];
		//scales(userInput,mode,key);

		//Scanner for analyse function

		System.out.println("About to analyse file");
		File inputFile = new File("music_data.txt");
		Scanner fileScanner = new Scanner(inputFile);
		analyse(fileScanner, key, mode, category);		
	}
}