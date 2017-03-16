package com.dss.app.apputilities;

public interface GlobalValues {
	
	public static String baseDirectory=System.getProperty("user.dir");
	public static final String excelPath =baseDirectory  + "/TestData.xlsx";
	public static final String tempLogFilePath= baseDirectory+"\\TempLogFiles";
	
	public static final String windowsChromeDriverPath = baseDirectory+ "\\src\\test\\resources\\chromedriver.exe";
	public static final String windowsFirefoxDriverPath = baseDirectory+ "\\src\\test\\resources\\geckodriver.exe";
	
	//Sauce Lab config details
	public static final String SAUCE_USERNAME = "guri10febf"; 
	public static final String SAUCE_ACCESS_KEY = "bb762560-281d-4fc2-8c1a-7b4da557c498"; 
	public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static final String ExtentReportPath = baseDirectory+"\\Report.html";
	public static final String ExtentReportConfig = baseDirectory+"\\src\\main\\java\\com\\dss\\app\\reporter\\ExtentConf.xml";
}
