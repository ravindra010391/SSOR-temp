package com.dss.app.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.xml.XmlSuite;

import com.dss.app.coreutilities.CoreUtility;
import com.dss.app.runner.XmlGenerator;

/*
 * This method will generate the XML files based on Jenkin parameter
 */
public class Runner {

	public static void main(String[] args) throws Exception {

		String confit_Parameter = System.getProperty("CONFIG_PARAMETER");
		List<XmlSuite> suites = XmlGenerator.createXML(confit_Parameter);
		System.out.println("total suites = " + suites.size());

		int suiteCount = 1;
		List<String> allRunTimeXML = new ArrayList<String>();
		for (XmlSuite eachSuite : suites) {

			String runTimeXMLName = "RuntimeXMLSuite" + suiteCount + ".xml";
			CoreUtility.createPhysicalXMLFileOfSuite(eachSuite, runTimeXMLName);
			allRunTimeXML.add(runTimeXMLName);
			suiteCount++;
		}

		XmlGenerator.createParentSuite(allRunTimeXML);

	}

}
