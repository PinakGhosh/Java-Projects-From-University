/**
	 * 
	 * 
	 * //Main class responsible for all user input
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-14
	 */


import acm.program.ConsoleProgram;


@SuppressWarnings("serial")
public class In2p  extends ConsoleProgram {

	/**
	 *main method
	 */
	public void run() {
		
		println("Infix to Postfix conversion, enter expression of blank line to exit.");//
		postFix mypostFix = new postFix();//create new postFix class
		
		
		mypostFix.setlink(this);//link acm.jar to postFix class
		
		
		
		while (true) {// read inputs until blank space inputed

			String Name = readLine("expr:");//read input b=from user
			if (Name.equals("")) {//if input empty terminate program
				println("");
				break;
			}
			
			print(mypostFix.QueueParse(Name));//print PostFix of users input
			println("");//give space
		}
		
		
		
		
	}
	
	
}
