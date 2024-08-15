/**
 * Link class creates a link to be used in a linked list, for this project it is used in the SingleLinkList class and the DoubleLinkList class.
 * The link contains a Country object as its data.
 * 
 *@author Brandon Rocha
 *@version October 23, 2022
 */
public class Link {
	
	public Country coData;
	public Link next;
	public Link previous;
	
	/**
	 * Constructor that creates a link with data being a Country object
	 * 
	 * @param coEdit the Country object to be assicuated with this link
	 */
	public Link(Country coEdit) {
		coData = coEdit;
		
	}
	/**
	 * Method that displays the Country object information associated with a specific link.
	 */
	public void displayLink() {
		coData.toString(coData);
	}
	
	
}
