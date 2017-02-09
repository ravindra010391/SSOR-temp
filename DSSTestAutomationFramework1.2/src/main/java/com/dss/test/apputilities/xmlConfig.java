package com.dss.test.apputilities;

public class xmlConfig {
	
	public static void createXMLFile(String marketConfigData){
		
		String[] marketConfig = marketConfigData.split("-");
		String marketToken = marketConfig[0];
		String marketEnvironmentToken = marketConfig[1];
		String allBrowsersTocken = marketConfig[2];
		
		System.out.println(marketToken+" "+marketEnvironmentToken+" "+allBrowsersTocken);
		String marketFullName = getMarketFullName(marketToken);
		String URL = createURL(marketFullName, marketEnvironmentToken);
		getAllBrowser(allBrowsersTocken);
		
	}
	
	
	
	
	private static String createURL(String marketFullName,String marketEnvironmentToken){
		String URL = null;
		
		if(marketEnvironmentToken.equalsIgnoreCase("st")){
			URL = "http://ngux."+marketFullName+".stage.tribdev.com/";
		}
		if(marketEnvironmentToken.equalsIgnoreCase("pr")){
			URL = "http://www."+marketFullName+".com/";
		}
		
		return URL;
}
	
	private static String getMarketFullName(String marketNameToken){
		
		String marketFullName = null;
		switch (marketNameToken.toLowerCase()) {
		
		case "la": marketFullName = "latimes"; break;
		case "ct": marketFullName = "chicagotribune"; break;
		case "ss": marketFullName = "sun-sentinel"; break;
		case "os": marketFullName = "orlandosentinel"; break;
		case "hc": marketFullName = "courant"; break;
		case "dp": marketFullName = "dailypress"; break;
		case "bs": marketFullName = "baltimoresun"; break;
		case "mcall": marketFullName = "mcall"; break;
		case "cct": marketFullName = "carrollcountytimes"; break;
		case "acg": marketFullName = "capitalgazette"; break;
		case "vg": marketFullName = "vagazette"; break;
		case "sdut": marketFullName = "sandiegouniontribune"; break;

		default:
			System.out.println("Please enter valid MARKET name!!!");
			break;
		}
		return marketFullName;
	}

	private static String[] getAllBrowser(String browserToken){
		String[] browsers = null;
		
		if(browserToken.length()>=4){
			for(int i = 0;i<browserToken.length(); i++ ){
				browsers[i] = browserToken.substring(i, i+1);
				System.out.println(browsers[i]);
				i=i+2;
			}
		}else{
			browsers[0] = browserToken;
		}
		return browsers;
	}	
	
}