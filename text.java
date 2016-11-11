import java.util.*;
import java.io.*;
public class text {
	public static void analyse(Scanner fS){
		int i = 0;
		while(fS.hasNext()){
			String line = fS.nextLine();
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
		// git hub test2

	}
	public static void main(String[] args)throws Exception{
		String fileName;
		int length = args.length;

		//If the user doesnt enter filename at runtime 
		if (length <= 0){
			while(true){
				Scanner userInput = new Scanner(System.in);
				System.out.println("You didnt enter a file. Enter a file name here:");
				fileName = userInput.nextLine();
				if(!fileName.equals("")){
					break;
				}
			}
			length++;
		}
		//an argument was given at run time
		else {
			fileName = args[0];
		}
		File inputFile = new File(fileName);
		Scanner fileScanner = new Scanner(inputFile);
		analyse(fileScanner);
	}
}