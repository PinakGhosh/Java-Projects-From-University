/**
	 * 
	 * 
	 * //class that runs console
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-25
	 */



// imports needed to run program
import acm.program.*;


@SuppressWarnings("serial")
public class JCalc extends ConsoleProgram {
	
//Code from professor Ferrie's assignment 4 instructions
    postFix pf = new postFix();

    public void run() {
    	println("Infix to Postfix conversion, enter expression of blank line to exit.");
    	
    	while (true) { // loop until false (when input nothing)
    		String input = readLine("expr: ");//read value inputed after "exper: "
    	if (input.equals("")) break; //end loop if input nothing
    		Queue Qin = pf.parse (input); //parse value
    		Queue pfResult = pf.In2Post(Qin); //turn into postfix
    		String postString = pfResult.toString(); //make postfix as string
    		println(input+" => "+postString); //display postfix
    		double eval = pf.PostEval(pfResult); //evaluate postfix
    		println(postString+" evaluates to "+eval);//display evaluation
    	}
    	println("Program terminated."); //message
    	
    }
	
}
