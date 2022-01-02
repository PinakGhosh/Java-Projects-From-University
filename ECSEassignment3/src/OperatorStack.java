

/**
	 * 
	 * 
	 * //Stack Class
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-14
	 */


public class OperatorStack {

	//name list node Front (should have named top in hindsight)
	listNode front;
	
	
	
	/**
	 * push method adds elements to the stack 
	 * @param token
	 */
	
	public void push(String token){
		
		//initializes new listnode
		listNode Node = new listNode(token);
		
		//first listnode points to next list node
		Node.next = front;
		front = Node;
		
		
	}
	
	
	/**
	 * pop removes elements from the stack
	 * @return oldFront.data
	 */
	public String pop(){
		
		
		//If stack is empty 
		if(front == null)
		{
			//return null
			return null;
		}
		
		else
		{
			
			//element at top changed to element in second place
			
			listNode oldFront = front;
			front = front.next;
			
			//return value stored at the top of the stack
			return oldFront.data;
		}
	}
	
	
	
}
