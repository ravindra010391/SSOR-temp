package com.dss.app.reporter;

import java.io.File;

import org.testng.ISuite;

import com.dss.app.apputilities.AppUtility;
import com.dss.app.apputilities.GlobalValues;
import com.dss.app.coreutilities.CoreUtility;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class Extentmanager {
	
	static ExtentReports extent;
    final static String filePath = GlobalValues.ExtentReportPath;
    
    public synchronized static ExtentReports getReporter(String suiteName) {
        if (extent == null) {
        	System.out.println("Creatig report file getReporter called");
        	System.out.println("report of"+filePath+"\\"+suiteName+"AutomationReport.html");
            extent = new ExtentReports(filePath + File.separator +"Report"+suiteName+AppUtility.getCurrentDate()+".html", true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(GlobalValues.ExtentReportConfig));
            System.out.println(GlobalValues.ExtentReportConfig);

        }
        
        return extent;
    }
    
    public synchronized static ExtentReports getReporter() {
    	return extent;
    }
    

}
