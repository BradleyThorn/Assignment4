
import acm.program.*;

import java.io.*;
import java.text.*;
import java.util.*;

public class Assignment5
{
	 public static void main(String[] args) 
	 {
		wordCount("lear.txt");
		System.out.println("\n\n");
		histogram("MidtermScores.txt");
		System.out.println("\n\n");
		uniqueNames();
	 }
	 
	 //program for finding word, char, and line count
	 static void wordCount(String fileName)
	 {
		//instantiate our variables
		String line;
		int lines = 0;
		int words = 0;
		int chars = 0;
		
		//gets a new file reader and puts it in a try/catch to catch errors
		try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			//counts through every line until the next line is blank, noting the end of the file
			while((line = br.readLine()) != null)
			{
				//increase out line count by 1 for every iteration
				lines += 1;
				//test through each character in a line
				for(int x = 0; x <line.length(); x++)
				{
					//if the line isn't a b;ank space, increase char count
					if(line.charAt(x) != ' ')
					{
						chars++;
						
					}
				}
				//puts all of our words inside of an array list, separating them by spaces and apostrophes
				ArrayList<String> wordCount = new ArrayList<>(Arrays.asList(line.split(" |\\'")));
				//since every word is now a space in the arraylist, we get the size of the array list as the new word count to add
				words += wordCount.size();
				
			}
				
		}
		//catches any bad files
		catch(IOException ex)
		{
			System.out.println("Bad file");
		}
		
		//prints our results
		System.out.println("File = " + fileName);
		System.out.println("Line = " + lines);
		System.out.println("Words = " + words);
		System.out.println("Chars = " + chars);
		
			
	}
	 
	 static void histogram(String fileName)
	 {
		 //makes a new variable to hold our possible values for scores, from 0-9 to 100
		 String[] possValues = {"", "", "", "", "", "", "", "", "", "", ""};
		 String line;
		 //make a new file reader
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		 {
			 //reads every line until then end
			 while((line = br.readLine()) != null)
			 {
				 //turns our string line into an int
				 int num = Integer.parseInt(line.trim());
				 //test to see what the value of the int is and then adds a * to the appropriate value in the array
				 if (num < 10)
				 {
				 	possValues[0] += "*";
				 }
				 else if (num >= 10 && num < 20)
				 {
				 	possValues[1] += "*";
				 }
				 else if (num >= 20 && num < 30)
				 {
				 	possValues[2] += "*";
				 }
				 else if (num >= 30 && num < 40)
				 {
				 	possValues[3] += "*";
				 }
				 else if (num >= 40 && num < 50)
				 {
				 	possValues[4] += "*";
				 }
				 else if (num >= 50 && num < 60)
				 {
				 	possValues[5] += "*";
				 }
				 else if (num >= 60 && num < 70)
				 {
				 	possValues[6] += "*";
				 }
				 else if (num >= 70 && num < 80)
				 {
				 	possValues[7] += "*";
				 }
				 else if (num >= 80 && num < 90)
				 {
				 	possValues[8] += "*";
				 }
				 else if (num >= 90 && num < 100)
				 {
				 	possValues[9] += "*";
				 }
				 else if (num == 100)
				 {
				 	possValues[10] += "*";
				 }
				 
			 }
		 }
		 catch(IOException ex)
		 {
			System.out.println("Bad file!"); 
		 }
		 //prints our results
		 System.out.println("00-09: " + possValues[0]);
		 System.out.println("10-19: " + possValues[1]);
		 System.out.println("20-29: " + possValues[2]);
		 System.out.println("30-39: " + possValues[3]);
		 System.out.println("40-49: " + possValues[4]);
		 System.out.println("50-59: " + possValues[5]);
		 System.out.println("60-69: " + possValues[6]);
		 System.out.println("70-79: " + possValues[7]);
		 System.out.println("80-89: " + possValues[8]);
		 System.out.println("90-99: " + possValues[9]);
		 System.out.println("100  : " + possValues[10]);
	 }
	 
	 static void uniqueNames()
	 {
		 //make a new scanner for inputs as well as new variables
		 Scanner input = new Scanner(System.in);
		 ArrayList<String> names = new ArrayList<String>();
		 String nameInput;
		 //while(true) continuously loops until a break statement is given
		 while (true)
		 {
			 System.out.println("Enter name: ");
			 //gets out input
			 nameInput = input.nextLine();
			 //quits out of the loop if nothing is typed
			 if(nameInput.isEmpty())
			 {
				 break;
			 }
			 //otherwise checks to see if the name is already in our array list
			 else if(names.contains(nameInput))
			 {
				 continue;
			 }
			 //if its not in the array list, then we add it
			 else 
			 {
				 names.add(nameInput);
			 }
			 
		 }
		 System.out.println("Unique name list contains: ");
		 //prints every name in the array list
		 for(int x = 0; x < names.size(); x++)
		 {
			 System.out.println(names.get(x));
		 }
	 }
	 
}


