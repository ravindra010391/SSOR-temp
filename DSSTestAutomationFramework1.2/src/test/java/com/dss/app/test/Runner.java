package com.dss.app.test;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.runner.XmlGenerator;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	
	

	public static void main(String [] args) throws Exception {
		
		System.out.println("I am in main Runner lass => ");
		
		String confit_Parameter = System.getProperty("CONFIG_PARAMETER");

		List<XmlSuite> suites = XmlGenerator.createXML(confit_Parameter);
		System.out.println("total suites = " + suites.size());

		int suiteCount = 1;
		List<String> allRunTimeXML = new ArrayList<String>();
		for (XmlSuite eachSuite : suites) {
			System.out.println("Suite created - file ops");
			String runTimeXMLName = "RuntimeXMLSuite"+suiteCount+".xml";
			CoreUtility.createPhysicalXMLFileOfSuite(eachSuite, runTimeXMLName);
			allRunTimeXML.add(runTimeXMLName);
			suiteCount++;
		}
		
		XmlGenerator.createParentSuite(allRunTimeXML);
		
		
		// TestNG test = new TestNG();
		//System.setProperty("XMLSuite","TestNGRunTime1.xml");
		//TestNG test = new TestNG();
		//test.setXmlSuites(suites);
		//test.run();
	}

}
