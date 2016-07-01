package com.zendesk.view;

import java.util.Scanner;

public class MainView {

	String[] menuOptions = {"Display All Tickets","Display A Single Ticket","Exit Program"};
	String welcomeMsg = "--- Hello and welcome to the Zendesk ticket viewer! ---";
	String menuInstructions = "Please type a number to select a menu option (or press q to quit):";
	String confirmExit = "Are you sure you wish exit the program? (y / n):";
	
	Scanner sc;
	public void printMainMenu(){
		printMenuInstructions();
		printMenuOptions();
		return;
	}
	
	public void printMenuInstructions(){
		System.out.println(menuInstructions);
		return;
	}
	
	public void printWelcome(){
		System.out.println(welcomeMsg);
		return;
	}
	
	public void printMenuOptions(){
		System.out.println("---------------------------------");
		for(int i = 1; i <= menuOptions.length; i++){
			System.out.println(i + ": "+ menuOptions[i-1]);
		}
		System.out.println("---------------------------------");
		
	}

	
}
