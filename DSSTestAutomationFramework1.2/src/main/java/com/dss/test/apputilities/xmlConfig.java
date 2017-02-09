package com.dss.test.apputilities;

public class xmlConfig {
	
	public static void createXMLFile(String marketConfigData){
		
		String[] marketConfig = marketConfigData.split("-");
		String marketName = marketConfig[0];
		String marketEnvironment = marketConfig[1];
		String allBrowsers = marketConfig[2];
		System.out.println(marketName+" "+marketEnvironment+" "+allBrowsers);
		
	}
	

}
