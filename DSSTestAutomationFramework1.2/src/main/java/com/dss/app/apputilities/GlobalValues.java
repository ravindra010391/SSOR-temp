package com.dss.app.apputilities;

public interface GlobalValues {
	
	public static String baseDirectory=System.getProperty("user.dir");
	public static final String excelPath =baseDirectory  + "/TestData.xlsx";
	public static final String logConfigFilePath=baseDirectory +"\\src\\main\\java\\log4j.properties";
	public static final String reportFilePath= baseDirectory+"\\AutomationReport.html";
	
	public static final String windowsChromeDriverPath = baseDirectory+ "\\src\\test\\resources\\chromedriver.exe";
	public static final String windowsFirefoxDriverPath = baseDirectory+ "\\src\\test\\resources\\geckodriver.exe";

}
