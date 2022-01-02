/**
	 * 
	 * 
	 * //PostFix class where infix is converted to postfix
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-25
	 */

import java.util.StringTokenizer;// Import these to run program

//Professor Ferries postfix method (code and comments) from Assignment 3 solutions
public class postFix {

	static Character[] operators =
            new Character[] {'^','%','x','*','/','+','-'};  // Operator LUT
    static int[] oPrecedence =
            new int[] {4,3,3,3,3,2,2};                      // Precedence LUT
    static Character[] poperators =                         // for parsing
            new Character[] {'^','%','x','*','/','+','-','(',')'};

    
    
    public Queue In2Post (Queue Qin) {
        String s,o;
// Create output queue and stacks.
       
        Stack opStack = new Stack(); // Stack for operators
        Queue Qout = new Queue(); // Queue for postfix stream


// Slightly more refined version of Dijkstra's shunting yard algorithm.  Handles
// parentheses, but not unary operators.
    
        while ((s=Qin.deQueue()) != null) {                         // Get next token
    
        	if (isOperator(s)) {									// Check if operator
        	    while ((o=opStack.pop()) != null) {
        	        if (Precedence(o) >= Precedence(s)) {// Pop operator stack onto output queue
        	         
        	            Qout.enQueue(o); // until precedence < new token
        	        }
        	        else {
        	            opStack.push(o); // last popped has < precedence; put back
        	            
        	            break; // drop out of while
        	        }
        	    } 	
        	opStack.push(s); // push new token (an operator)
        	}
        
        	// Handler for parentheses now added here.
        
        	else if (s.charAt(0)=='(') { // push ( on to operator stack
                opStack.push(s);
        	}
        	
        	else if (s.charAt(0)==')') {
                while ((o=opStack.pop()) != null) {
                	if (o.charAt(0) != '(') {
                        Qout.enQueue(o);
                	}
                	else {
                		break; 
                	}
                }
        	}  	
        	
        	else if (s.charAt(0) != ')') {
                Qout.enQueue(s);
        	}
        }  
        
     // Pop any remaining operators off the stack onto the output queue
        while ((o=opStack.pop()) != null)
            Qout.enQueue(o);
        // Evaluate the postfix expression for the simple case and output
        return Qout;
        
    }   
        	
        	
        	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
/**
* Precedence method returns the precedence associated with the first * character of the input string using the oPrecedence lookup table.
* @param o
* @return an integer with the precedence value
*/
	    
  //Professor Ferries precedence method (code and comments) from Assignment 3 solutions 
    private static int Precedence(String s) {
        for (int i=0; i<operators.length; i++) {
            if (s.charAt(0) == operators[i]) return oPrecedence[i];
        }
        return 0; 

    }

	
	    
	    
	    /**
	* This is identical to the precedence method, but it simply returns * true if the first character is in the list of operators.
	* @param s
	* @return
	*/
	// Modified to check for cases of negative numbers
 
  //Professor Ferries operator method (code and comments) from Assignment 3 solutions 	
    private static boolean isOperator(String s) {
        if (s.length() == 1) {
        	for (int i=0; i<operators.length; i++) {
            if (s.charAt(0) == operators[i]) return true;
        	} 
        }
    return false;
    }
	
	
  //Professor Ferries parse method (code and comments) from Assignment 3 solutions
	public Queue parse (String arg) {
		Queue Qout = new Queue();
		StringTokenizer st = new StringTokenizer(arg,"^%x*/+-()",true);
		while (st.hasMoreTokens()) {
			String token=st.nextToken();
			if (!token.equals(" ")) {
				token=token.replace('!', '-').trim();
				Qout.enQueue(token.replaceAll("\\s", ""));
			}	
		}
		
		return Qout;
		
	}





	/**evaluates postfix and returns singular number
	 * 
	 * 
	 * @param data
	 * @return results
	 */
	public double PostEval(Queue data) {
		Queue Rqueue = new Queue(); //create new queue
		Rqueue = data;//Rqueue now holds the value for data
		Double results;//initialize variable
		Stack compute = new Stack();//create stack
		
		
		
		while(Rqueue.front != null){//loop until front of queue is empty
			
			String value = Rqueue.deQueue();
			
			if(" + - / * ".indexOf(value) == -1) { // if number push onto stack
				compute.push(value);
				
				//from assignment 4 instructions
			} else { //if anything but number (operator)
				Double A = Double.parseDouble(compute.pop()); // pop 2 numbers from stack and parse
				Double B = Double.parseDouble(compute.pop());
				double inside;
				
				
				switch(value) {
					case "+": // do appropriate evaluation for proper operator
						inside = B+A;
						compute.push(Double.toString(inside));//push result back onto stack	
						break;
						
					case "-":
						inside = B-A;
						compute.push(Double.toString(inside));	
						break;	
						
					case "*":
						inside = B*A;
						compute.push(Double.toString(inside));	
						break;
						
					case "/":
						inside = B/A;
						compute.push(Double.toString(inside));	
						break;
				
					
				}
			}	
			
		}	
		
		results = Double.parseDouble(compute.pop());//now should have only the final answer remaining in stack, pop that value and parse
		return results;//return that value
			
	}
	
}


