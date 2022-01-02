package additiontriangle;


import acm.program.ConsoleProgram; // import acm.jar

public class additiontriangle extends ConsoleProgram{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		
		int UserNum = readInt("input number you want to sum too: ");//read a number after displaying this message
		int addNum = 1; // declare variable
		
		int innerSumNum = 0;
	
		
	if (UserNum > 0) {	//if number is less than O make number triangle
		
		while(addNum <= UserNum) {	//loop until addNumber is as large as the user inputed number
		
			innerSumNum = innerSumNum + 1;// add one to sum number
			int SumNum = 0;//declare variable
		
				for (addNum = 1 ; addNum <= innerSumNum ; addNum++) {//loop until sum number is equal to the number you added
				
					if (addNum < innerSumNum) {  
						print(addNum + "+"); // print number and put plus at end
						SumNum = SumNum + addNum; //sums all displayed numbers
					}
					else {
						print(addNum); // print number 
						SumNum = SumNum + addNum; //sums all displayed numbers
				
					}		
				}
				println("="+ SumNum); // put equals sign and sum of numbers
		}
	}	
	
	else {// if number less than 0 then display given message
		
		println("Only imput numbers greater than 0");
		
	}
	
	}

}
