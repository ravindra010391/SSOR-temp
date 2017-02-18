package com.dss.app.coreutilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {

	public static Logger Log;
	
	public static void logInit(){
		//BasicConfigurator.configure();
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\log4j.properties");
		//CONSOLE_LOGGER = Logger.getLogger("CONSOLE_LOGGER");
		Log = Logger.getLogger("FILE_LOGGER");
	}

	 // Initialize Log4j logs
	 	

	  // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	  public static void startTestCase(String sTestCaseName){


	 	Log.info("****************************************************************************************");

	 	Log.info("------------------------------ "+sTestCaseName+ " -------------------------------------");

	 	Log.info("****************************************************************************************");

	 	}

	 	//This is to print log for the ending of the test case

	  public static void endTestCase(){

	 	Log.info("****************************"+"-E---N---D-"+"*******************************************");

	 	}

	 	// Need to create these methods, so that they can be called  

	  public static void info(String message) {

	 		Log.info(message);

	 		}

	  public static void warn(String message) {

	     Log.warn(message);

	 	}

	  public static void error(String message) {

	     Log.error(message);

	 	}

	  public static void fatal(String message) {

	     Log.fatal(message);

	 	}

	  public static void debug(String message) {

	     Log.debug(message);

	 	}

	 

		
}

