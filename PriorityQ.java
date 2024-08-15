
/**
 * PriorityQ class utilizes a doubly linked list of Country objects to act as a priority queue with the highest priority being the lowest COVID death rate and the
 * lowest priority being the country with the highest COVID death rate.
 * Insertion will also be based on COVID death rate.
 * 
 * 
 * @author Brandon Rocha
 *@version October 23, 2022
 */

public class PriorityQ {
	
	private DoubleLinkList theList;
	
	/**
	 * Constructor that creates an empty priority queue.
	 * 
	 */
	PriorityQ () {
		
		theList = new DoubleLinkList();
	}
	/**
	 * Method that returns the highest priority item. 
	 * 
	 * @return the highest priority item in the queue
	 */
	public Link getFirst() {
		return (theList.getFirst());
	}
	/**
	 * Method that allows for insertion into the priority queue for the first object. 
	 * 
	 * @param first is a Country object to be inserted into the queue
	 */
	public void insertFirst(Country first) {
		theList.insertFirst(first);
	}
	/**
	 * Method that allows for insertion into the priority queue based on the Country object's COVID death rate. 
	 * 
	 * @param insCountry is a Country object to be inserted into the queue
	 */
	
	public void insert(Country insCountry) {
		
		theList.insertInOrder(insCountry);
		
	}//end insert
	
	/**
	 * Method that removes the Country object with the highest priority which would be the country with the lowest COVID death rate.
	 * 
	 * @return the Country object that has been removed. 
	 */
	public Country remove() {
		
		return theList.deleteFirst();
	}
	
	/**
	 * Method that removes Country objects from the priority queue based on a user defined interval.
	 * 
	 * @param begin of type double that will describe where the Country objects are to start being removed based on their COVID death rate
	 * @param end of type double that will describe where the Country objects are to stop being removed based on their COVID death rate
	 * @return boolean true if any objects have been removed from the queue, false if no objects were removed
	 */
	public boolean intervalDelete(double begin, double end) {
		
		return theList.intervalDelete(begin, end);
	}

	/**
	 * Method to indicate if the queue is empty.
	 * 
	 * @return a boolean type that is true if the queue is empty, false if the queue has at least one Country object
	 */
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	/**
	 * Method that prints the contents of the priority queue from highest priority to lowest priority.
	 * 
	 */
	public void printQue (Link current) {
		if (current.next == null) {
			current.displayLink();
		}
		else {
			current.displayLink();
			current=current.next;
			printQue(current);
		}
		//theList.displayList();
	}

}//end class