

/**
	 * 
	 * 
	 * //Stack Class
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-25
	 */


//Professor Ferries Stack Class (code and comments) from Assignment 3 solutions


public class Stack {
// Instance variables (particular to each instance)
    listNode top = null;
/**
* push method - creates a new instance of a stack frame, and stores * the payload accordingly.
*/
    public void push(String arg) {
    	listNode node = new listNode();
    	node.payload = arg;
    	if (top != null)
    		node.next = top;
    // Create a new instance
// Store the data
// If stack not empty, link to top
// Otherwise link to null
// Top now points to newly created node

    	else
    		node.next = null;
    	top = node;
    	}
    
    
/**
* pop method - returns the payload at the top of the stack, then * moves the pointer to the next frame in line.
* @return the payload is a string.
*/
public String pop() {
    if (top == null) return null;
    String payload = top.payload;
    top = top.next;
// Check if stack empty, return null
// Otherwise grab payload from top
// Top now points to next frame in line
return payload;                 // Return payload
    }
}