// Name: Pinak Ghosh
//Student ID: 260970600

import acm.program.ConsoleProgram; // import acm.jar

/**
 * @author pinakghosh
 *
 * @version 1.0
 * @since 2020-02-17
 */
@SuppressWarnings("serial")
public class SortBuffer extends ConsoleProgram {

	/**
	 *
	 * gives instructions to code,creates binary tree and reads inputs that will be
	 * inputed in binary tree and then reads them according to the code in
	 * bTree.java uses ( @link bTree ) class
	 */
	public void run() {

		println("Text Sorting Program: (ECSE 202 - Assignment2)");// print instructions
		println("Enter text to be sorted, line by line. A blank line terminates.");
		println("You can cut and paste text into this window:");

		bTree myTree = new bTree();// create bTree
		myTree.setlink(this);// link acm.jar to bTree class

		while (true) {// read inputs until blank space inputed

			String Name = readLine();
			if (Name.equals("")) {
				println("");
				break;
			}
			myTree.addNode(Name);

		}

		// print spaces and information to understand what is outputed by the the code
		println("");
		println("Text Sort in Order:");
		println("");
		myTree.displayInOrder();
		println("");
		// print spaces and information to understand what is outputed by the the code
		println("");
		println("Text Sort in ReverseOrder:");
		println("");
		myTree.displayInReverseOrder();
		println("");

	}

}
