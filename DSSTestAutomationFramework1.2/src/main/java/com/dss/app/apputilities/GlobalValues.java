package com.dss.app.apputilities;

public interface GlobalValues {
	
	public static String baseDirectory=System.getProperty("user.dir");
	public static final String excelPath =baseDirectory  + "/TestData.xlsx";
	public static final String tempLogFilePath= baseDirectory+"\\TempLogFiles";
	
	public static final String windowsChromeDriverPath = baseDirectory+ "\\src\\test\\resources\\chromedriver.exe";
	public static final String windowsFirefoxDriverPath = baseDirectory+ "\\src\\test\\resources\\geckodriver.exe";
	
	//Sauce Lab config details
	public static final String SAUCE_USERNAME = "ravindra.mandage1"; 
	public static final String SAUCE_ACCESS_KEY = "57949a79-890c-456e-86e8-cc867d6a25d8"; 
	public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	public static final String SAUCE_MAC_VERSION = "macOS 10.12";
	public static final String SAUCE_WINDOWS_VERSION = "windows 7";
	
	public static final String ExtentReportPath = baseDirectory;
	public static final String ExtentReportConfig = baseDirectory+"\\src\\main\\java\\com\\dss\\app\\reporter\\ExtentConf.xml";
}
