import java.util.Scanner;
import java.io.*;
public class musicGuide {
	//Function to read through a file 
	public static void analyse(Scanner fS, String k, String m, String c){
		String current_line;
		
		while(fS.hasNext()){
			current_line = fS.nextLine();
			current_line = current_line.toLowerCase();
			String[] fileText = current_line.split("\\s+");		
			if(fileText.length == 3 && fileText[0].equals(k) && fileText[1].equals(m) && fileText[2].equals(c)) {
				current_line = fS.nextLine();
				while (!current_line.equals("*")){
					System.out.println(current_line);
					current_line = fS.nextLine();					
				}
				return;
			}
		}
		System.out.println("We've reached the end of file, and havent found anything, please check your input");

	}
	
	public static void main (String[] args) throws Exception{
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("What category would you like info about?");
			System.out.println("\t<key> <mode> scale"+
							 "\n\t<key> <mode> chord"+
							 "\n\t<key> <mode> Progression_Patterns"+
							 "\n\t<key> <mode> Fingerings"+
							 "\n\tExit");
			String input_text = userInput.nextLine();

			if (input_text.equals("exit")){
				System.out.println("Goodbye");
				System.exit(0);
			}

			input_text = input_text.toLowerCase();
			String[] input = input_text.split("\\s+");

			if (input.length != 3) {
				System.out.println("Please give correct input");
			}

			else {
				String key = input[0];
				String mode = input[1];
				String category = input[2];

				//if (!category.equals("scale") && !category.equals("chord") && !category.equals("Progression_Patterns") && !category.equals("fingerings")) {
				//	System.out.println("Please give correct input");
				//}

				//else {
				//System.out.println("About to analyse file");
				File inputFile = new File("music_data.txt");
				Scanner fileScanner = new Scanner(inputFile);
				analyse(fileScanner, key, mode, category);
				//}
			}
				
		}	
	}
}