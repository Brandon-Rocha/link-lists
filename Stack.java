
	/**
	 * The Stack class uses a double-ended singly linked list of Country objects to implement a stack. 
	 * Only allows insertion(push) or deletion(pop) to occur at the top of the stack. 
	 * 
	 * @author Brandon Rocha
	 * @version October 23, 2022
	 *
	 */


	
	public class Stack {
		private SingleLinkList theList;
		
		/**
		 * Constructor for Stack class that creates an empty stack.
		 */
		Stack() {
			
			theList = new SingleLinkList();
			
		}
		/**
		 * Method that will push (insert) a Country object onto the top of the stack.
		 * 
		 * @param addCountry is the Country object to be inserted onto the top of the stack.
		 */
		public void push(Country addCountry) {

			theList.insertFirst(addCountry);
			
		}// end push
		/**
		 * Method that will pop (remove) a Country object from the top of the stack.
		 * 
		 * @return the Country object that has been removed
		 */
		public Country pop() {
			
			return theList.deleteFirst();
			
		}//end pop
		/**
		 * Method that returns the top of the stack
		 * 
		 * @return the top of the stack
		 */
		public Link peek() {
			return (theList.getFirst());
		}
		/**
		 * Method to indicate that the stack is empty.
		 * 
		 * @return a boolean that is true if the stack is empty, false if the stack has at least one Country object
		 */
		public boolean isEmpty() {
			
			return ( theList.isEmpty() );
		
		}
		
		/**
		 * Method that will print the stack from top to bottom.
		 */
		public void printStack(Link current) {
			if (current.next == null) {
				current.displayLink();
			}
			else {
				current.displayLink();
				current=current.next;
				printStack(current);
			}
			//theList.displayList();
			
		}
	}//end stack class