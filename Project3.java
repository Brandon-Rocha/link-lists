import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project 3 class starts by taking in a file named Countries3.csv, parsing out the information and creating Country (using Country class) objects out of each line from the file.
 * From these Country objects a stack (using Stack class) is created using COVID death rate as a parameter. Only Country objects with a death rate of greater than or equal to twenty
 * but less than three-hundred and fifty make it into the stack. The stack is then printed.
 * <p>
 * A priority que is then created by popping each country object from the stack and inserting them into the queue one at a time. The priority queue is then printed.
 * 
 * <p>
 * After the stack and queue are filled, the user is prompted repeatedly to enter a number corresponding to an action on a menu, until 3 is entered, 
 * then the program will terminate.
 * 
 * @author Brandon Rocha
 *@version October 23, 2022
 */
public class Project3 {

	public static void main(String[] args) {
		
		Stack countryStack = new Stack(); 
		PriorityQ priQue = new PriorityQ();
		
		Scanner openFl = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String filename = openFl.next();

		
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e ){
			System.out.println("Unable to open the file: "+filename);
			System.exit(1);
		}
		inFile.useDelimiter(",|\n");
		//get through the first line
		inFile.nextLine();
		
		while(inFile.hasNext()) {
			Country example = new Country();
			example.setName(inFile.next());
			example.setCapitol(inFile.next());
			example.setPop(inFile.nextDouble());
			example.setGdp(inFile.nextDouble());
			example.setCases(inFile.nextLong());
			example.setDeaths(inFile.nextLong());
			String a = inFile.next();
			double area = Double.parseDouble(a);
			example.setArea(area);
			

			if (example.getDeathRate() >= 20 && example.getDeathRate() < 350) {
				countryStack.push(example);
			}//close if
			
			
		} //close while loop
		System.out.println("------------------------------------------------------Stack Contents------------------------------------------------------");
		System.out.printf("%-35s %-18s %9s %10s %16s %15s %12s\n", "Name", "Capitol", "GDPPC", "CFR", "CaseRate", "DeathRate", "PopDensity");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		countryStack.printStack(countryStack.peek());
		System.out.println("");
		System.out.println("--------------------------------------------------Priority Queue Contents--------------------------------------------------");
		System.out.printf("%-35s %-18s %9s %10s %16s %15s %12s\n", "Name", "Capitol", "GDPPC", "CFR", "CaseRate", "DeathRate", "PopDensity");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		Country first = new Country();
		first = countryStack.pop();
		priQue.insertFirst(first);
		
		while(!countryStack.isEmpty()) {
			Country temp = new Country();
			temp = countryStack.pop();
			priQue.insert(temp);
		}
		priQue.printQue(priQue.getFirst());
		System.out.println("");
		
		Scanner menuOption = new Scanner(System.in);
		String input = "0";
		while(!input.equals("3")) {
			Project3.printMenu();
			input = menuOption.next();
			System.out.println();
			if (input.equals("1")) {
				int tryAgain = 1;
				while(tryAgain == 1) {
				Scanner interval1 = new Scanner(System.in);
				Scanner interval2 = new Scanner(System.in);
				try {
				System.out.print("Enter the lesser number of the interval you wish to delete: ");
					double start = interval1.nextDouble();
				System.out.print("Enter the greater number of the interval you wish to delete: ");
					double end = interval2.nextDouble();
				System.out.println("");
				if (start > end) {
					System.out.print("The first value entered must be less than the second value entered. \n"
							+ "Please try again with valid input. \n"
							+ "\n");
				}
				else {
					priQue.intervalDelete(start, end);
					break;
				}
				}
				catch(InputMismatchException e) {
					System.out.print("The lesser and greater value must be a number, no other characters will be accepted. \n"
							+ "Please try again with valid input. \n"
							+ "\n");
					continue;
				}
				
			}//end tryAgain while
			}//end option 1
			
			else if (input.equals("2")) {
				System.out.println("--------------------------------------------------Priority Queue Contents--------------------------------------------------");
				System.out.printf("%-35s %-18s %9s %10s %16s %15s %12s\n", "Name", "Capitol", "GDPPC", "CFR", "CaseRate", "DeathRate", "PopDensity");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------");
				priQue.printQue(priQue.getFirst());
			}//end option 2
			
			else if (input.equals("3")) {
				break;
			}//end option 3
			else {
				System.out.println("That is not a valid menu option, please enter 1 or 2, 3 to quit.");
			}
			System.out.println();
		}//end of while loop
		System.out.println("Goodbye!");
		openFl.close();
		menuOption.close();
		inFile.close();
	}//end of main
	/**
	 * This method is called to print a menu, each option allowing the user to enter an interval of death rates to be deleted from the priority queue, to print the priority queue,
	 * or to quit the program.
	 * 
	 */
	public static void printMenu () {
		System.out.print("1) Enter a DR interval for deletions on priority queue\n"
				+ "2) Print the priority queue\n"
				+ "3) Exit program\n"
				+ "Enter your choice: ");
	} //end of printMenu
}//end of Project3
