package com.dss.test.coreutilities;

public class Startup {
	
	public static void main(String[] args) {
		System.out.println("This is the main method");
		
		String confi_para = System.getProperty("CONFIG_PARAMETER");
		System.out.println("Config parameter : " +confi_para);
	}

}
