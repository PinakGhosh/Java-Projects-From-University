/**
	 * 
	 * 
	 * //class that runs GUI
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-25
	 */



// Imports needed to run program
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.gui.*;
import acm.program.Program;

@SuppressWarnings("serial")
public class CalcGUI extends Program {
	
	//initialize variables
	double resultCalc;
	String input= ""; 
	 //placed outside of init so can be reached by other Methods
	JTextField inputField = new JTextField("");
	JTextField outputField = new JTextField("");
	
	
	 /**
	 * creates buttons, textfields and appropriate listeners to make calculator
	 */
	public void init() {   
		setSize(400,475);
		setLayout(new TableLayout(6, 5)); //make a layout grid that is 6 by 5   
		
		
		
		 //add textfield with perameters
		 add(inputField, "gridwidth = 5 height=25");
		
		 
		 //add textfield with perameters
		 add(outputField, "gridwidth = 5 height=25");
		
		 
		 
		 //make perameters for button
		
		 String buttonGrid = "1";
		 //create array that will give label to buttons
		 String buttonLabel[]= {"7","8","9","(",")","4","5","6","*","/","1","2","3","+","-","0",".","C"};
			
			//String contains perameters for button
			String constraint = "gridwidth=" + buttonGrid;
		
			//for loop the array to buld buttons (easier than doing each one manually) 
			for (int index = 0; index < buttonLabel.length; index++) {
		
				
				JButton button = new JButton(buttonLabel[index]); //create new Button
				
				
				
				button.addActionListener(this);	//adds action listener
				
				add(button, constraint); //adds the button
		
			}
			
			
			JButton equals = new JButton("="); //make equals (wanted equals to take 2 grid boxes)
			equals.addActionListener(this);// add Action listener
			add(equals,"gridwidth = 2");//add perameters
		 
	} 
	
	
	
	 
	 /**
	 * tells what to do when button pressed 
	 */
	public void actionPerformed(ActionEvent e) {
		 
		
		 
		 if(e.getActionCommand()== "C") {// if C pressed then clear textfields and input string
			 
			 inputField.setText("");
			 outputField.setText("");
			 input= "";
			 
			 	 
		 }
		 else if(e.getActionCommand()== "=") {// if equals is pressed then evaluate input 
			 
			 postFix Calculation = new postFix();//create postfix class
			 Queue Qin =  Calculation.parse (input);//parse string that user inputed 
	    	 Queue pfResult =  Calculation.In2Post(Qin);//turn into postfix
	    	 resultCalc = Calculation.PostEval(pfResult);//evaluate
	    		
	    	 outputField.setText("" + resultCalc);//display result
			 
	    	
			 
		 }
		 else {// if anything else inputed (numbers and operators) 
			 
			
			
			 
			 
			input = input + e.getActionCommand();//add that value to input string
			inputField.setText("" + input); //display input string
			 
			 
			 
			 
		 }
		 
		 
		 
	 }
	 
	 
	 
	
}
