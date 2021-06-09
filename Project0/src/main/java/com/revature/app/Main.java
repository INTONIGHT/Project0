package com.revature.app;

import java.util.List;

import com.revature.logging.AppLogger;
import com.revature.models.User;

import com.revature.repos.UserDAO;

import com.revature.services.ProcessInput;

//main method will run the code here.
public class Main {
	public static void logInfo(String message) {
		AppLogger.logger.info(message);
	}
	public static void main(String[] args) {
		AppLogger.logger.info("Program Started");
		ProcessInput pi = new ProcessInput();
		pi.processString();
		AppLogger.logger.warn("The scanner isnt closed by the program");
		logInfo("info level");
		
	}

}
