package com.dss.app;

import com.dss.app.runner.XmlGenerator;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Runner {

	public static void main(String [] args) throws Exception {
		System.out.println("I am in main Runner lass => ");

		List<XmlSuite> suites = XmlGenerator.createXML("SS,STAGE,CHFF,WINDOWS,RG");
		System.out.println("total suites = " + suites.size());

		int i = 1;
		for (XmlSuite each : suites) {
			File file = new File("TestNGRunTime" + i + ".xml");
			System.out.println("file" + file);
			FileWriter writer = new FileWriter(file);
			writer.write(each.toXml());
			writer.close();
			i++;

		}

		TestNG test = new TestNG();
		test.setXmlSuites(suites);
		test.run();
	}

}
