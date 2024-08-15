/**
 * The DoubleLinkList class creates a doubly linked list to be utilized as a priority queue by the PriorityQ class.
 * 
 * @author Brandon Rocha
 *@version October 23, 2022
 */
public class DoubleLinkList {
	
	private Link first;
	private Link last;
	
	public DoubleLinkList () {
		first = null;
		last = null;
	}
	
	/**
	 * Method that indicates whether the linked list is empty.
	 * 
	 * @return boolean that is true if the list is empty, otherwise it returns false.
	 */
	public boolean isEmpty () {
		return (first==null);
	}
	
	public Link getFirst() {
		return first;
	}
	/**
	 * Allows for insertion of a new link at the beginning of the linked list
	 * 
	 * @param country is a Country object that is going to be associated with the new link to be inserted 
	 */
	public void insertFirst(Country country) {
		Link newLink = new Link(country);
		
		if( isEmpty() ) {
			last = newLink;
		}
		else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	/**
	 * Method that allows for insertion of a new link into the linked list and is inserted based on the Country objects COVID death rate. 
	 * The lower the COVID death rate the closer to the beginning of the linked list it is placed. 
	 * 
	 * 
	 * @param country Country object that is to be associated with the new link to be inserted into the linked list
	 */
	public void insertInOrder(Country country) {
		Link newLink = new Link(country);
		
		Link previous = null;
		Link current = first;
		
		while(current != null && newLink.coData.getDeathRate() > current.coData.getDeathRate() ) {
			previous = current;
			current = current.next;
		}
		
		if (previous == null) {
			if( isEmpty() ) {
				last = newLink;
			}
			else {
				first.previous = newLink;
			}
			newLink.next = first;
			first = newLink;
		}
		else if (current == null) {
			if( isEmpty() ) {
				first = newLink;
			}
			else {
				last.next = newLink;
				newLink.previous = last;
			}
			last = newLink;
		}
		
		if(current != null && previous != null) {
		previous.next = newLink;
		newLink.previous = previous;
		current.previous = newLink;   
		newLink.next = current;
		}
		
		

	}//end inserInOrder
	
	/**
	 * Method that removes the first link in the linked list.
	 * 
	 * @return temp the Country object that has been removed from the linked list
	 */
	public Country deleteFirst() {
		Country temp = first.coData;
		
		if(first.next == null) {
			last = null;
		}
		else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	/**
	 * Method that removes Country objects from the linked list based on a user defined interval.
	 * 
	 * @param begin of type double that will describe where the Country objects are to start being removed based on their COVID death rate
	 * @param end of type double that will describe where the Country objects are to stop being removed based on their COVID death rate
	 * @return boolean true if any objects have been removed from the linked list, false if no objects were removed
	 */
	public boolean intervalDelete(double begin, double end) {
		int i = 0;
		
		Link current = first;
		
		while (current != null && current.coData.getDeathRate() < begin) {
			current = current.next;
		}
		while (current != null && current.coData.getDeathRate() <= end) {
			++i;
			if(current==first) { 
				first = current.next;
			}
			else {                      
				current.previous.next = current.next;   
				}
			if(current==last) {                           
				last = current.previous;
				}
			else {
				current.next.previous = current.previous;
		
				}
			current = current.next;
			if(current != null && current.coData.getDeathRate() > end) {
				break;
			}
		}	
		
		
		if( i == 0 ) { 
			return false;
		}
		
		return true;
	}
	
	/**
	 * Method that prints the linked list data from first link to last link.
	 * 
	 */
	public void displayList() {
		
		Link current = first;

		while(current != null) {
			
			current.displayLink();
			current = current.next;
		}
	}

	

}
