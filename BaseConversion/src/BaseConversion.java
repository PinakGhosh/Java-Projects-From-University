// Name: Pinak Ghosh
//Student ID: 260970600





import acm.program.ConsoleProgram; // import acm.jar

public class BaseConversion extends ConsoleProgram{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //for some reason  need this code to run
	
	
	// following code taken from Assignment instructions however manipulated
	
	
	public void run() {
		
		println("Base conversion program; converts +ve integers to a target base.");
		println("Enter number to be converted and target base on separate lines following the prompts."); 
		println("A blank entry for either input terminates the program.");
		
		// Main program loop: read input, check for exit, convert, print result.
		
	
		while (true) {

			String input = readLine("Number > "); // Read input and check for break. i
			if (input.equals("")) {
				println("Program terminated"); break;}
			
				int number = String2Int(input); // Convert to integer
			
			if(input.matches("[0-9]+") && input.length() > 0) {//checks if only numbers in string (needed some help from the internet here)
		        
				input = readLine("Target base : "); // Now do the same for the base value
				if (input.equals("")) { println("Program terminated"); break;}
				int base = String2Int(input); // Convert to integer
				
				
				
				
				
				
				
				
				
				if (base < 2 || base > 16) { // range error
					println("The base must be between 2 and 16 inclusive.");
				}
				else {
					String result = baseConv(number,base); // Convert and print result
					println(number+" expressed in base "+base+" is "+result);

				}
				
				
				
				
				
				
				
			}
			else {
				println("Error! "+input+" does not correspond to a positive integer.");
				}
			
			
				
				
		}
	}

	

	private int String2Int(String input) { // string to integer method
		
		int sum = 0; //declaring variables
		int PowerOfTen = 1;
		int countdown = 0;
		
		//loops until "operation" has been performed on every digit of the string.
		
		for (countdown = 1; countdown <= input.length();  countdown++) {	
	
	
			int number = input.charAt(input.length() - countdown) - '0'; // turns into digits from right to left of string into integer data type
			sum = sum + (number * PowerOfTen);//puts digit into appropriate place value (Ex: ones, tens hundreds....etc)
			PowerOfTen = PowerOfTen * 10;//sets "PowerOfTen" variable up to place digit in correct place value in the next loop
		
		
		}
		
		
		return sum; //returns the "sum"variables value back 
	}
	
	
	private String baseConv(int number, int base) {
	
		int Number = number; //declaring variables
		String Character = ""; 
		String fullstring = "";
		String reverseString = "";
		
		while (Number > 0)  {//loop until the variable number is less than 0
		
			int digit = Number % base;//give value of "digit" the value of the remainder of number divided by the base 
	    	Number = Number/base; //divide number by base
	    	
	    
	    	
	    	
	    	
		    	if (digit == 0) { //give string values for integer results of the arithmetics above
		    		Character = "0";//assign value to "character"
		    		fullstring = fullstring + Character; //add character to string with all other results of arithmetics
		    	}
		    	//repeat for all other values up to "F" (16)
		    	else if (digit == 1) {
		    		Character = "1";
		    		fullstring = fullstring + Character;
		    	}	
		    	
		    	else if (digit == 2) {
		    		Character = "2";
		    		fullstring = fullstring + Character;
		    	}	
		    	
		    	else if (digit == 3) {
		    		Character = "3";
		    		fullstring = fullstring + Character;
		    	}	
		    	
		    	else if (digit == 4) {
		    		Character = "4";
		    		fullstring = fullstring + Character;
		    	}	
		    	
		    	else if (digit == 5) {
		    		Character = "5";
		    		fullstring = fullstring + Character;
		    	}	
		    	
		    	else if (digit == 6) {
		    		Character = "6";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 7) {
		    		Character = "7";
		    		fullstring = fullstring + Character;
		    	}		
		    	else if (digit == 8) {
		    		Character = "8";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 9) {
		    		Character = "9";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 10) {
		    		Character = "A";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 11) {
		    		Character = "B";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 12) {
		    		Character = "C";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 13) {
		    		Character = "D";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 14) {
		    		Character = "E";
		    		fullstring = fullstring + Character;
		    	}	
		    	else if (digit == 15) {
		    		Character = "F";
		    		fullstring = fullstring + Character;
		    	}	
		  
	    }
		
		int length = fullstring.length(); //declare variable that takes length of string as an integer value
		
		for (int index = length - 1; index >= 0 ; index-- ) //loop that reads String 
   		 reverseString = reverseString + fullstring.charAt(index);
   	
		
		
		return reverseString;//return value of variable "reverseString"
		
	}
		
		
}
	
	
	

