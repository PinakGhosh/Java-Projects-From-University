/**
	 * 
	 * 
	 * //PostFix class where infix is converted to postfix
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-14
	 */

import java.util.StringTokenizer;// Import these to run program
import acm.program.ConsoleProgram;

public class postFix {

	/**
	 * Declare variable that will link to buffer sort so that acm.jar can be used
	 */
	ConsoleProgram link;
	
	
	/**
	 * puts Infix into queue that is in postfix order
	 * @param data
	 * @return
	 */
	public String QueueParse(String data) {
	
	//@param opStack - stack used for storing operators
	//@param Rqueue - queue used for storing and printing out final result
	//@param string - StringTokenizer which cycles through each token of the string
		
	StringTokenizer string = new StringTokenizer(data, "+-/*()", true);
	OperatorStack opStack = new  OperatorStack();
	ResultsQueue Rqueue = new ResultsQueue();	
	
	


	
	//this loop allows to cycle threw the tokens given by the StringTokenizer
	while (string.hasMoreTokens()) {
		String toke = string.nextToken();//the string toke is equal to "next token" given by StringTokenizer
		
		//check if token is an operator
		if(toke.equals("+") || toke.equals("-") || toke.equals("/") || toke.equals("^") || toke.equals("*")) {
			
			
			
			if(opStack.front != null) {//if top of stack is not empty
				
				if(hierarchy(toke) > hierarchy(opStack.front.data)) {//if higher precedence  push token onto stack
					opStack.push(toke);
				}
				
				else if(hierarchy(toke) <= hierarchy(opStack.front.data)) { //if precedence same or less
					
					while(true) { // loop until break reached
						
						if(opStack.front != null) {//if top of stack is not empty
							
							
							if(hierarchy(toke) > hierarchy(opStack.front.data)) break; //if higher precedence break
							
							
						}else break;  ///otherwise push the token onto opStack
						Rqueue.enQueue(opStack.pop());	
					}
					opStack.push(toke);
					
					
				}
				//if opStack push token 
			}	else if (opStack.front == null) {
				opStack.push(toke);
				
			}
			
		//if token left parentheses 	
		}else if (toke.equals("(")) {
			opStack.push(toke);//push the token
			
		//if token right parentheses
		}else if (toke.equals(")")) {
			//loop until left parentheses
			while(true) {
				
				while(opStack.front.data != null &&! opStack.front.data.equals("(")) {
					Rqueue.enQueue(opStack.pop());//keep putting operators from stack onto queue until left parentheses
				}
				
				if (opStack.front.data.equals("(")) {
					opStack.pop();//get rid of left parentheses and break
					break;
				}	
			}
			
		}else {
			
			Rqueue.enQueue(toke); //if not an operator of parentheses just put token on queue
			
		}	
	
	
	} 
	
	while(opStack.front != null) {		//while top of opStack contains operators
		Rqueue.enQueue(opStack.pop());	//push all final operators onto the output queue
	}
	
	
	return In2Post(Rqueue); //return value after running value for Rqueue threw In2Post Method

	
	
	
	}
	
	
	
	/**
	 * In2Post turns values in queue into string
	 * @param data
	 * @return
	 */
	public String In2Post(ResultsQueue data) {
		
		ResultsQueue Rqueue = data; //create queue variable
		
		String end = "";//create string variable
		
		while(Rqueue.front != null) {//dequeue values until queue is empty onto the string
			end = end + " " + Rqueue.deQueue();
		}
		 
		
		
		return end;	//returns value for end variable to QueueParse
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int hierarchy(String data) {
		
		if (data.equals("*") || data.equals("/")) 			//higher precedence  (* and /)
			return 2;
		
		if (data.equals("+") || data.equals("-"))			//second highest  (+ and -)
			return 1;
		
		 if (data.equals("("))							
			
			 return -1;
															//pops stack when needed
		else 
															
			return 0;										
	
}

	
	/**
	 * 
	 * creates link to link postFix class to In2p
	 * 
	 * @param link allows to link console program to postFix class
	 */
	 
	public void setlink(ConsoleProgram link) {

		this.link = link;

	}
	
	


	
	


	
}


