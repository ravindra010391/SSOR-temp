package com.dss.app.coreutilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.dss.app.apputilities.GlobalValues;

/*
 * This class is to log the information in Log4J log file
 */

public class Log {

	public static Logger Log;
	
	
	public static void logInit(){
		//BasicConfigurator.configure();
		PropertyConfigurator.configure(GlobalValues.logConfigFilePath);
		Log = Logger.getLogger("FILE_LOGGER");
	}

	
	  public static void startTestCase(String sTestCaseName){


	 	Log.info("----------------------------------------------------------------------------------------");

	 	Log.info("------------------------------ "+sTestCaseName+ " -------------------------------------");

	 	Log.info("----------------------------------------------------------------------------------------");

	 	}

	  public static void endTestCase(){

	 	Log.info("--------------------------------- "+"-E---N---D-"+"------------------------------------");

	 	}

	 
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

