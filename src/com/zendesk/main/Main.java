package com.zendesk.main;

import com.zendesk.model.APIHandler;
import com.zendesk.model.MenuHandler;
import com.zendesk.view.MainView;

public class Main {
	
	public static void main(String[] args) {
		MenuHandler menu = new MenuHandler();
		menu.runWelcomeMenu();
		
	}

}
