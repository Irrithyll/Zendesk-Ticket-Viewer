package com.zendesk.view;


public class MainView {

	String[] menuOptions = {"Display All Tickets","Display A Single Ticket","Quit Program"};
	String welcomeMsg = "Hello and welcome to the Zendesk ticket viewer!";
	String welcomeInstructions = "Please type menu to view the menu, or q to quit the program:";
	String menuHeader = "---------------------------------\nMenu\n---------------------------------";
	String menuInstructions = "Please type a number to select a menu option (or type q to quit):";
	String confirmExit = "Are you sure you wish exit the program? (y / n):";
	String quitMsg = "Program Exiting...";
	String unrecognizedInputErr = "Error: Unrecognized input, please enter your selection again:";

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

	
}
