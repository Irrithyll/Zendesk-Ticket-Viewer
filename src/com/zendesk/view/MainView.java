package com.zendesk.view;

/*
 * The MainView contains common messages displayed to the user so that they 
 * can be re-used in methods and altered in a more efficient manner.
 */
public class MainView {

	private String[] menuOptions = {"Display All Tickets","Display A Single Ticket","Quit Program"};
	private String welcomeMsg = "Hello and welcome to the Zendesk ticket viewer!";
	private String welcomeInstructions = "Please type menu to view the menu, or q to quit the program: ";
	private String menuHeader = "---------------------------------\nMenu\n---------------------------------";
	private String menuInstructions = "Please type a number to select a menu option (or type q to quit): ";
	//private String confirmExit = "Are you sure you wish exit the program? (y / n): ";
	private String quitMsg = "Program Exiting...";
	private String unrecognizedInputErr = "Error: Unrecognized input, please enter your selection again: ";
	private String askTicketID = "Please enter a ticket ID: ";
	private String invalidTicketID = "Invalid ticket ID, please try again. (or type menu to return to the menu)";
	private String invalidPageCommand = "Invalid page command, type n for next, b for back, menu for menu, q for quit:";
	
	public void printMainMenu(){
		printMenuHeader();
		printMenuOptions();
		printMenuInstructions();
		return;
	}
	
	public void printMenuInstructions(){
		System.out.println(menuInstructions);
		return;
	}
	
	public void printWelcome(){
		System.out.println(welcomeMsg);
		System.out.println(welcomeInstructions);
		return;
	}
	
	public void printMenuHeader(){
		System.out.println(menuHeader);
		return;
	}
	
	public void quit(){
		System.out.println(quitMsg);
	}
	
	public void unrecognizedInput(){
		System.out.println(unrecognizedInputErr);
	}
	
	public void printMenuOptions(){
		for(int i = 1; i <= menuOptions.length; i++){
			System.out.println(i + ": "+ menuOptions[i-1]);
		}
		System.out.println("---------------------------------");
		
	}
	
	public void askTicketID(){
		System.out.println(askTicketID);
	}
	
	public void invalidTicket(){
		System.out.println(invalidTicketID);
	}
	
	public void invalidPageCommand(){
		System.out.println(invalidPageCommand);
	}

	
}
