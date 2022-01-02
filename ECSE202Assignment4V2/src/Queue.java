/**
	 * 
	 * 
	 * //Queue Class
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2021-04-14
	 */

public class Queue {
// Instance variables, local to each instance
    listNode front=null;    // Pointer to front
    listNode rear=null;     // Pointer to rear
/**
* enqueue method - adds data to a new node to the end of the queue */
    public void enQueue (String arg) {
        listNode node = new listNode(); // Allocate a new node
        node.payload = arg;
        node.next = null;
        if (rear != null)
        	rear.next = node;
        else
        	front = node;
        rear = node;
// Store payload
// Node at end points to null
// If rear points to a node
// attach this one to it.
// Front points here if first node
// Rear now points to new node
}
/**
* dequeue method - removes data from node at front of queue */
    public String deQueue() {
        if (front != null) {
            if (front == rear) rear=null;
            String payload = front.payload;
            front = front.next;
            return payload;
// If queue is not empty
// On last element, set rear to null
// Retrieve data at front node
// Move front pointer to next frame
// Return payload
        }
        else
        	return null;
    }        
// Case of empty queue
/**
* flush method - deletes queue by removing references to linked * list. Garbage collection takes care of the rest
*/
    public void flush() {
        front = null;
        rear = null; 
    }
/**
* Q2String - appends the elements of a queue into a string */
    public String toString() {
        String out = "";
        listNode cf = front;
        listNode cr = rear;
       
        if (cf == cr) return out;
        while (true) {
// Returns empty string if queue is empty
// Walk the chain extracting each element
// Insert a space in between
// Done when front = rear
            out = out + " " + cf.payload.trim();
            if (cf == cr) break;
            cf = cf.next;
        }
        return out; 
    }
}

