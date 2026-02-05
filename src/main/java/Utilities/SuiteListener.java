package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.google.common.io.Files;

import base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	
//public void onTestFailure(ITestResult result) {
//		
//		String filename= System.getProperty("user.dir")+File.separator+ "Screenshot"+ File.separator+result.getMethod().getMethodName();
//		File src= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(filename+ ".jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}	
//
//      }
	
	@Override
    public void onTestFailure(ITestResult result) {
        // Create screenshot folder path
        String screenshotDir = System.getProperty("user.dir") + File.separator + "Screenshot";
        File directory = new File(screenshotDir);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Build unique file name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = screenshotDir + File.separator 
                        + result.getMethod().getMethodName() + "_" + timestamp + ".png";

        // Take screenshot
        File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src, new File(filename));
            System.out.println("Screenshot captured: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void transform(
	      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	    annotation.setRetryAnalyzer(RetryAnalyzer.class);
	  }




    
}

