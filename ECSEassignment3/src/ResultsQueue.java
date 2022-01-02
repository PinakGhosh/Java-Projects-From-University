/**
	 * 
	 * 
	 * //Queue Class
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-25
	 */


//Professor Ferries Queue Class (code and comments) from Assignment 3 solutions
public class ResultsQueue {

	// initialize front and back listnode
	listNode front = null;
	listNode back = null;
	
	
	
	/**
	 * enQueue adds element onto the queue
	 * @param token
	 */
	public void enQueue(String token) {
		
		//Create new listnode
		listNode Node = new listNode(token);
		
		//initialize .data and .next
		Node.data = token;
		Node.next = null;
		
		//if back is not empty make back equal to node and the next one after
		if (back != null) {
			back.next = Node;
			back = Node;
			
		// if queue empty make front and back equal to list node
		} else {
			
			front = Node;
			back = Node;
			
		}
	
	}	
	
	/**
	 * Unqueues all the values in the queue
	 * @return frontValue
	 * 
	 */
	String deQueue() {
		
		//if front is not empty
		if (front!=null) {
			
			if (front == back) back = null;
			String frontValue = front.data; //element in front is copied to the string
			front = front.next;//now make front the second value after
			
			return frontValue; //return string front value
			
			
		}else
		
		//if not return null	
		return null;
		
	}
	
	/**
	 * return front listnode
	 * @return
	 */
	public listNode getFront () {
		return front;
	}
	
	/**
	 * return back listnode
	 * @return
	 */
	public listNode getback () {
		return back;
	}
	
	
}
