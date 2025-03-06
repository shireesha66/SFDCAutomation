package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FileConstants;

public class ReportManager {
	private static ExtentReports report=null;

	public static ExtentReports getInstance() {
		if(report==null) {
		report=ReportManager.createInstance();
		}
		
		return report;
	}

	private static ExtentReports createInstance() {
		
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(FileConstants.REPORT_PATH);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setDocumentTitle("SFDC");
		report = new ExtentReports();
		report.attachReporter(sparkreporter);
		return report;
		
	}



}
