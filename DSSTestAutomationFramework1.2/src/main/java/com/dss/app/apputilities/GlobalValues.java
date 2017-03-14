package com.dss.app.apputilities;

public interface GlobalValues {
	
	public static String baseDirectory=System.getProperty("user.dir");
	public static final String excelPath =baseDirectory  + "/TestData.xlsx";
	public static final String logConfigFilePath=baseDirectory +"\\src\\main\\java\\log4j.properties";
	public static final String reportFilePath= baseDirectory+"\\AutomationReport.html";
	
	public static final String windowsChromeDriverPath = baseDirectory+ "\\src\\test\\resources\\chromedriver.exe";
	public static final String windowsFirefoxDriverPath = baseDirectory+ "\\src\\test\\resources\\geckodriver.exe";
	
	//Sauce Lab config details
	public static final String SAUCE_USERNAME = "ravindra.manadage"; 
	public static final String SAUCE_ACCESS_KEY = "78ea3dc2-6312-4b08-872d-9312203d1d3e"; 
	public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";


}
