/**
 * SingleLinkList class creates a double-ended singly linked list to be utilized as a stack in the Stack class. 
 * 
 * 
 *@author Brandon Rocha
 *@version October 23, 2022
 */
public class SingleLinkList {
	
	private Link first;
	private Link last;
	
	/**
	 * Constructor that creates an empty double ended singly linked list.
	 * 
	 */
	public SingleLinkList() {
		first = null;
		last = null;
	}
	
	/**
	 * Method that indicates whether the linked list is empty.
	 * 
	 * @return boolean that is true if the list is empty, otherwise it returns false.
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	/**
	 * Method that allows the first link in the list to be returned.
	 * @return the first link in the list
	 */
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
		
		if ( isEmpty() ) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	/**
	 * Method that removes the first link in the linked list.
	 * 
	 * @return tempCountry the Country object that has been removed from the linked list
	 */
	public Country deleteFirst() {
		Country tempCountry = first.coData;
		if ( first.next == null ) {
			last = null;
		}
		first = first.next;
		return tempCountry;
	}
	
	/**
	 * Method that prints the linked list data from first link to last link.
	 * 
	 */
	public void displayList() { //--------- do not know if this is needed if I need to print stack recursively		
		
		Link current = first;

		while(current != null) {
			
			current.displayLink();
			current = current.next;
		}
	}
}
