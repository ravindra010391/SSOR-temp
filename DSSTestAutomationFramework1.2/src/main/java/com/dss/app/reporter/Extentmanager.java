package com.dss.app.reporter;

import java.io.File;

import com.dss.app.apputilities.GlobalValues;
import com.relevantcodes.extentreports.ExtentReports;

public class Extentmanager {
	
	static ExtentReports extent;
    final static String filePath = GlobalValues.ExtentReportPath;
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
            extent.loadConfig(new File(GlobalValues.ExtentReportConfig));
            System.out.println(GlobalValues.ExtentReportConfig);
           
        }
        
        return extent;
    }

}
